package com.chessMaster.chessMasterWeb.Auth;

import com.chessMaster.chessMasterWeb.JWT.JwtService;
import com.chessMaster.chessMasterWeb.UserModel.Role;
import com.chessMaster.chessMasterWeb.UserModel.User;
import com.chessMaster.chessMasterWeb.UserModel.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private  final UserRepository userRepository;
    private final JwtService jwtservice;
    private final PasswordEncoder passwordEncoder;
    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .password(request.password)
                .lastname(request.getLastname())
                .country(request.getCountry())
                .role(Role.USER)
                .build();

        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtservice.getToken(user))
                .build();

    }
}
