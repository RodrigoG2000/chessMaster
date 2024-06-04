package com.chessMaster.chessMasterWeb.Demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor

//clase muestra de los endpoint protegidos.

public class DemoController {
    @PostMapping(value = "demo")
    public String welcome(){
        return "Welcome form secure endpoint";
    }
}
