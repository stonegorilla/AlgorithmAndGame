package com.algorithm.game.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MessageResponse {
    private String message;

    @Builder
    public MessageResponse(String message) {
        this.message = message;
    }
}
