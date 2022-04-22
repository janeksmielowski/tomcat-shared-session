package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/init")
    public ResponseEntity<String> initSession(HttpSession session) {
        String username = getRequesterUsername();
        session.setAttribute("attribute", "OK");

        return ResponseEntity.ok(username);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getSession(HttpSession session) {
        String username = getRequesterUsername();
        String test = String.valueOf(session.getAttribute("attribute"));

        return ResponseEntity.ok(username + ", session=" + test);
    }

    private String getRequesterUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            return null;
        }

        User user = (User) authentication.getPrincipal();

        if (user == null) {
            return null;
        }

        return user.getUsername();
    }

}
