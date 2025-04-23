package ru.podeli.notification.mvc3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {
    private Long id;
    private String title;
    private String description;
}
