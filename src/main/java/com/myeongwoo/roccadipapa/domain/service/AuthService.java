package com.myeongwoo.roccadipapa.domain.service;

import com.myeongwoo.roccadipapa.core.security.JwtTokenProvider;
import com.myeongwoo.roccadipapa.domain.exception.UserAlreadyExistsException;
import com.myeongwoo.roccadipapa.domain.exception.UserNotFoundException;
import com.myeongwoo.roccadipapa.domain.model.entity.User;
import com.myeongwoo.roccadipapa.domain.model.repository.UserRepository;
import com.springboot.template.application.request.UserSignInRequest;
import com.springboot.template.application.request.UserSignupRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public void signup(UserSignupRequest userSignupRequest) {
        if (userRepository.existsByUsername(userSignupRequest.getUsername()))
            throw new UserAlreadyExistsException();
        User user = new User(userSignupRequest);
        userRepository.save(user);
    }

    public String signIn(UserSignInRequest userSignInRequest) {
        User user = userRepository.findByUsernameAndPassword(userSignInRequest.getUsername(), userSignInRequest.getPassword()).orElseThrow(UserNotFoundException::new);
        return jwtTokenProvider.generateJwtToken(user.getId(), user.getRole());
    }
}
