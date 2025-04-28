package ru.podeli.notification.mvc3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {
    private Long id;
    private String title;
    @JsonIgnore
    private String description;
}
