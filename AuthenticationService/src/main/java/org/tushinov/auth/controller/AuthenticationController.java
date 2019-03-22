package org.tushinov.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok("{\"message\":\"intentionally left blank, route=/login\"}");
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<String> register(){
        return ResponseEntity.ok("{\"message\":\"intentionally left blank, route=/register\"}");
    }
}
