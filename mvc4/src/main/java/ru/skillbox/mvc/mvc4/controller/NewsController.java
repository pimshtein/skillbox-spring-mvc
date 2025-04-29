package ru.skillbox.mvc.mvc4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skillbox.mvc.mvc4.dto.ErrorDto;
import ru.skillbox.mvc.mvc4.dto.NewsDto;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {
    private TreeMap<Long, NewsDto> news = new TreeMap<>();

    @GetMapping()
    public ResponseEntity<TreeMap<Long, NewsDto>> getAll() {
        return ResponseEntity.ok(news);
    }

    @PostMapping()
    public ResponseEntity<NewsDto> create(@RequestBody NewsDto newsDto) {
        Map.Entry<Long, NewsDto> lastSavedNews = news.lastEntry();

        Long lastKey = 0L;
        if (lastSavedNews != null) {
            lastKey = lastSavedNews.getKey();
        }

        return ResponseEntity.ok(news.put(lastKey + 1, newsDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody NewsDto newsDto) {
        if (news.containsKey(id)) {
            news.put(id, newsDto);
            return ResponseEntity.ok(news.get(id));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorDto("NOT_FOUND",
                "Новость не найдена"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        if (news.containsKey(id)) {
            news.remove(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}