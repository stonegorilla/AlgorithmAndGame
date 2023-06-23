package com.algorithm.game.service;

import com.algorithm.game.dto.request.UserRequest;

public interface UserService {

    void registerUser(UserRequest.SignUp signUp);
}
