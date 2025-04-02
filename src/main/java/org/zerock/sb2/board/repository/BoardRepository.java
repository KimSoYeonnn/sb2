package org.zerock.sb2.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.sb2.board.dto.BoardReadDTO;
import org.zerock.sb2.board.entities.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardSearch{
    
    //dto로 바로 만들고 싶다
    // bno, title, content, writer, delFag, regDate, modDate
    // @Query("select new org.zerock.sb2.board.dto.BoardReadDTO(b.bno, b.title, b.writer, b.delFlag, b.viewCnt, b.regDate, b.modDate)  " +
    // " from BoardEntity b where b.bno = :bno")
    // BoardReadDTO selectOne( @Param("bno") Long bno);

}
