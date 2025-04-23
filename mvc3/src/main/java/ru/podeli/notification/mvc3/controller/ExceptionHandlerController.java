package ru.podeli.notification.mvc3.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podeli.notification.mvc3.model.News;

@RestController
public class ExceptionHandlerController {
    @GetMapping("/news/error")
    public News getError() {
        throw new IllegalStateException("Error");
    }

    @ExceptionHandler
    public String handleException(IllegalStateException e) {
        return "Error: " + e.getMessage();
    }
}