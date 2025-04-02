package org.zerock.sb2.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BoardReadDTO {
    
    private Long bno;

    private String title, content, writer;

    private boolean delFag;

    private LocalDateTime regDate, modDate;

    // bno, title, content, writer, delFag, regDate, modDate
    public BoardReadDTO(Long bno, String title, String content, String writer, boolean delFag, LocalDateTime regDate,
            LocalDateTime modDate) {
        this.bno = bno;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.delFag = delFag;
        this.regDate = regDate;
        this.modDate = modDate;
    }

    
}
