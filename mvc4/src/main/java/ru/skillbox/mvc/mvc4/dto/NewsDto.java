package ru.skillbox.mvc.mvc4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsDto {
    private Long id;
    private String title;
    private String description;
}
