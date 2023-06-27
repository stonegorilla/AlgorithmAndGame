package com.algorithm.game.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class BoardResponse {


    @Getter
    @Setter
    public static class BoardsAll{

        private Long boardSeq;
        private String writer;
        private String title;

        private Long viewCnt;
        private LocalDateTime createTime;

        @Builder
        public BoardsAll(Long boardSeq, String writer, String title, Long viewCnt, LocalDateTime createTime) {
            this.boardSeq = boardSeq;
            this.writer = writer;
            this.title = title;
            this.viewCnt = viewCnt;
            this.createTime = createTime;
        }
    }
}
