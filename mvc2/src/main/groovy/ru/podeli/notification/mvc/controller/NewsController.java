package ru.podeli.notification.mvc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.podeli.notification.mvc.model.News;
import ru.podeli.notification.mvc.repository.NewsRepository;

@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsRepository newsRepository;

    @GetMapping("/v1/news/{id}")
    public News getNewsById(@PathVariable("id") Long id) {
        return newsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("News not found"));
    }
}
