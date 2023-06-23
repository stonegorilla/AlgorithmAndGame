package com.algorithm.game.controller;


import com.algorithm.game.dto.request.UserRequest;
import com.algorithm.game.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRequest.SignUp signUp){
        userService.registerUser(signUp);
        return ResponseEntity.ok().body(null);
    }
}
