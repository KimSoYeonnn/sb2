package org.zerock.sb2.board.service;

import org.springframework.stereotype.Service;
import org.zerock.sb2.board.dto.BoardListDTO;
import org.zerock.sb2.board.dto.BoardRegisterDTO;
import org.zerock.sb2.board.dto.PageRequestDTO;
import org.zerock.sb2.board.dto.PageResponseDTO;
import org.zerock.sb2.board.entities.BoardEntity;
import org.zerock.sb2.board.repository.BoardRepository;

import groovy.util.logging.Log4j2;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImpl implements BoardService {

    private final BoardRepository repository;

    @Override
    public PageResponseDTO<BoardListDTO> list(PageRequestDTO requestDTO) {
        
        return repository.list(requestDTO);
    }

    @Override
    public void saveBoard(BoardRegisterDTO dto) {
        
        BoardEntity boardEntity = BoardEntity.builder()
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();

        repository.save(boardEntity);
    }
}
