package com.chessMaster.chessMasterWeb.Auth;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
