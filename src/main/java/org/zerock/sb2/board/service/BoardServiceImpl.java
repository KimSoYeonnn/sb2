package org.zerock.sb2.board.service;

import org.springframework.stereotype.Service;
import org.zerock.sb2.board.dto.BoardListDTO;
import org.zerock.sb2.board.dto.PageRequestDTO;
import org.zerock.sb2.board.dto.PageResponseDTO;
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
}
