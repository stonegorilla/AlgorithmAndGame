package com.algorithm.game.service;


import com.algorithm.game.domain.User;
import com.algorithm.game.dto.request.UserRequest;
import com.algorithm.game.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public void registerUser(UserRequest.SignUp signUp) {

        User user = User.builder()
                .email(signUp.getEmail()).password(signUp.getPassword())
                .nickname(signUp.getNickname()).name(signUp.getName()).build();
        userRepository.save(user);
    }
}
