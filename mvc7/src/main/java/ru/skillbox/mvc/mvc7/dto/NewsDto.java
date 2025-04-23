package ru.skillbox.mvc.mvc7.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Модель новости")
public class NewsDto {
    @Schema(description = "Идентификатор новости")
    private Long id;

    @Schema(description = "Заголовок новости")
    private String title;

    @Schema(description = "Содержание новости")
    private String content;

    @Schema(description = "Дата публикации")
    private LocalDate publishDate;
}