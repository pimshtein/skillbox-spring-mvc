package ru.podeli.notification.mvc3.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.podeli.notification.mvc3.model.News;

@RestController
@ControllerAdvice
public class ControllerAdviceExampleController {

    @ExceptionHandler({IllegalStateException.class})
    public String handleIllegalStateException(IllegalStateException e) {
        return "Error IllegalStateException: " + e.getMessage();
    }

    @ExceptionHandler({SecurityException.class})
    public String handleSecurityException(SecurityException e) {
        return "Error SecurityException: " + e.getMessage();
    }
}