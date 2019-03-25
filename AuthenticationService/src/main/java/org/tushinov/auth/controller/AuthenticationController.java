package org.tushinov.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.tushinov.auth.model.binding.LoginBindingModel;
import org.tushinov.auth.model.binding.RegisterBindingModel;

@RestController
public class AuthenticationController {

    @PostMapping(value = "/login", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginBindingModel loginBindingModel){

        String username = loginBindingModel.getUsername();

        System.out.println(String.format("Username: %s", username));
        System.out.println(String.format("Password: %s", loginBindingModel.getPassword()));

        return ResponseEntity.ok(String.format("{\"message\":\"Hello %s, you accessed '/login' successfully!\"}", username));
    }

    @PostMapping(value = "/register", produces = "application/json")
    public ResponseEntity<String> register(@RequestBody RegisterBindingModel registerBindingModel){

        String username = registerBindingModel.getUsername();

        System.out.println(String.format("Username: %s", username));
        System.out.println(String.format("Password: %s", registerBindingModel.getPassword()));
        System.out.println(String.format("Confirm: %s", registerBindingModel.getConfirmPassword()));

        return ResponseEntity.ok(String.format("{\"message\":\"Hello %s, you accessed '/register' successfully\"}", username));
    }
}
