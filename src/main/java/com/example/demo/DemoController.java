package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/init")
    public ResponseEntity<Void> initSession(HttpSession session) {
        session.setAttribute("test", "test value");

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<String> getSession(HttpSession session) {
        String test = String.valueOf(session.getAttribute("test"));

        return ResponseEntity.ok(test);
    }

}
