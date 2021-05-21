package com.jojoldu.book.springboot.practiceController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @GetMapping("/pracitce/hello")
    public String practiceHello() {
        return "hello";
    }
}
