package org.zerock.sb2.reply;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.reply.dto.ReplyListDTO;
import org.zerock.sb2.reply.dto.ReplyReadDTO;
import org.zerock.sb2.reply.entities.ReplyEntity;
import org.zerock.sb2.reply.repository.ReplyRepository;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class ReplyRepoTests {
    
    @Autowired(required = false)
    private ReplyRepository repository;

    @Test
    public void testInsert() {

        for (int i = 0; i <24; i++) {

            //가짜 BoardEntity가 필요
            BoardEntity board = BoardEntity.builder().bno(123L).build();
    
            ReplyEntity replyEntity = ReplyEntity.builder()
            .replyText("댓글입니다")
            .replyer("user00")
            .board(board)
            .build();
    
            repository.save(replyEntity);
            
        }

    }

    @Test
    public void testRead() {

        Long rno = 1L;

        Optional<ReplyEntity> result = repository.findById(rno);

        ReplyEntity reply = result.orElseThrow();

        log.info(reply);
    }

    @Test
    public void testListOfBoard() {

        Long bno = 123L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        repository.listOfBoard(bno, pageable);
    }

    @Test
    public void testListOfBoard2() {

        Long bno = 123L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Object[]> result = repository.listOfBoard2(bno, pageable);

        result.getContent().forEach(arr -> log.info(Arrays.toString(arr)));
    }

    @Test
    public void testListOfBoard3() {

        Long bno = 123L;

        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<ReplyListDTO> result = repository.listOfBoard3(bno, pageable);

        result.getContent().forEach(dto -> log.info(dto));
    }

    @Test
    public void testSelectOne(){
        
        Long rno = 1L;

        ReplyReadDTO dto = repository.selectOne(rno);

        log.info(dto);

    }

}
