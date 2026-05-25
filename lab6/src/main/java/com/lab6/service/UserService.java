package com.lab6.service;

import com.lab6.auth.AuthService;
import com.lab6.repository.UserRepository;
import javax.inject.Inject;

public class UserService {

    private final UserRepository userRepository;
    private final AuthService authService;

    @Inject
    public UserService(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }

    public void loginUser(int userId, String token) {
        System.out.println("UserService: user login...");
        String user = userRepository.findUser(userId);
        boolean ok = authService.authenticate(token);
        System.out.println("  " + user + " logged in: " + (ok ? "yes" : "no"));
    }
}
