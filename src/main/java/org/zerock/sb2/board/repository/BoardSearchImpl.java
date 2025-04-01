package org.zerock.sb2.board.repository;

import java.util.List;

import org.zerock.sb2.board.dto.BoardListDTO;
import org.zerock.sb2.board.dto.PageRequestDTO;
import org.zerock.sb2.board.dto.PageResponseDTO;
import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.board.entities.QBoardEntity;

import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.JPQLQueryFactory;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
public class BoardSearchImpl implements BoardSearch {

    private final JPQLQueryFactory queryFactory;
    
    @Override
    public PageResponseDTO<BoardListDTO> list(PageRequestDTO pageRequestDTO) {

        QBoardEntity board = QBoardEntity.boardEntity;

        JPQLQuery<BoardEntity> query = queryFactory.selectFrom(board);
        query.where(board.bno.gt(0L));
        query.where(board.delFlag.eq(false));

        // 검색 조건

        query.limit(pageRequestDTO.getLimit());
        query.offset(pageRequestDTO.getOffset());
        query.orderBy(new OrderSpecifier<>(Order.DESC, board.bno));

        // 우리가 원하는건 entity가 아니라 dto

        JPQLQuery<BoardListDTO> dtoQuery = query.select(Projections.bean(
            BoardListDTO.class, 
            board.bno, board.title, board.writer, board.viewCnt, board.regDate));

        long count = dtoQuery.fetchCount();

        List<BoardListDTO> dtoList = dtoQuery.fetch();

        log.info(dtoList);
        log.info(count);        

        return PageResponseDTO.<BoardListDTO>withAll()
        .dtoList(dtoList)
        .total((int)count)
        .pageRequestDTO(pageRequestDTO)
        .build();
    }
}
