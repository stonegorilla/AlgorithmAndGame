package com.algorithm.game.dto.request;

import lombok.Getter;
import lombok.Setter;

public class UserRequest {


    @Getter
    @Setter
    public static class SignUp{

        private String email;
        private String password;

        private String nickname;
        private String name;


    }
}
