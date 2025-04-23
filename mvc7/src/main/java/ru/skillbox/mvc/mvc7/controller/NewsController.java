package ru.skillbox.mvc.mvc7.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skillbox.mvc.mvc7.dto.NewsDto;

import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/v1/news")
public class NewsController {
    private final TreeMap<Long, NewsDto> newsMap = new TreeMap<>(Map.of(
            1L, new NewsDto(1L, "Первая новость", "Содержание первой новости", LocalDate.now()),
            2L, new NewsDto(2L, "Вторая новость", "Содержание второй новости", LocalDate.now())));

    @Operation(
            summary = "Получение новости по ID",
            description = "Возвращает новость по указанному идентификатору"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Новость успешно найдена",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = NewsDto.class))
    )
    @ApiResponse(
            responseCode = "404",
            description = "Новость не найдена"
    )
    @GetMapping
    public ResponseEntity<NewsDto> getNews(
            @Parameter(description = "ID новости")
            @RequestParam Long id
    ) {
        NewsDto news = newsMap.get(id);
        if (news == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(news);
    }
}