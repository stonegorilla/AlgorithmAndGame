package com.algorithm.game.dto.request;

import lombok.Getter;
import lombok.Setter;

public class BoardRequest {

    @Getter
    @Setter
    public static class Register{

        private String title;

        private String content;

        private Long userSeq;
    }

    @Getter
    @Setter
    public static class Modify{

        private Long boardSeq;
        private String title;
        private String content;
    }
}
