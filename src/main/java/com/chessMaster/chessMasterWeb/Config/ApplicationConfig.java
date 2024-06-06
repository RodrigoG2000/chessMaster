package com.chessMaster.chessMasterWeb.Config;

import com.chessMaster.chessMasterWeb.UserModel.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    private final UserRepository userRepository;
    //metodos para acceder a las intancias.  // accede a las intancias y retorna

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    //metodo que devuelva el provedor.
     public AuthenticationProvider authenticationProvider(){
         DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
         authenticationProvider.setUserDetailsService(userDetailService());
         authenticationProvider.setPasswordEncoder(passwordEncoder());
         return authenticationProvider;
     }

     @Bean
     public UserDetailsService userDetailService(){
        return  username -> userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found"));
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }
}
