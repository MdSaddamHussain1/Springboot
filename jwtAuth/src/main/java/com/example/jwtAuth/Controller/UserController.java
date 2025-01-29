package com.example.jwtAuth.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/public")
    @PreAutherize("/public")
    public String publicEndpoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "This is an admin endpoint, accessible by jwtFirstRole";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "This is a user endpoint, accessible by jwtSecondRole";
    }
}
