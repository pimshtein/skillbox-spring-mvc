package ru.skillbox.mvc.mvc5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private String title;
    private String content;
    private LocalDateTime publicationDate;
    private String author;
} 