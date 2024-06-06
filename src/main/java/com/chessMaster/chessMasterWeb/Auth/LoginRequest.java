package com.chessMaster.chessMasterWeb.Auth;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;
}
