package ru.skillbox.mvc.mvc5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.skillbox.mvc.mvc5.model.News;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller()
@RequestMapping("/news")
public class NewsController {

    @GetMapping("/thymeleaf")
    public String home(Model model) {
        // Базовые атрибуты
        model.addAttribute("message", "Добро пожаловать на новостной портал!");
        model.addAttribute("currentDate", LocalDateTime.now());
        model.addAttribute("isAdmin", true);

        // Новость
        model.addAttribute("news", new News(
                "Это пример для Thymeleaf",
                "Демонстрация работы с Thymeleaf",
                LocalDateTime.now(),
                "Команда Thymeleaf"
        ));

        // Список новостей
        List<News> newsList = Arrays.asList(
                new News("Новость 1", "Содержание новости 1", LocalDateTime.now().minusDays(1), "Автор 1"),
                new News("Новость 2", "Содержание новости 2", LocalDateTime.now().minusDays(2), "Автор 2"),
                new News("Новость 3", "Содержание новости 3", LocalDateTime.now().minusDays(3), "Автор 3")
        );
        model.addAttribute("newsList", newsList);

        // Map для демонстрации
        Map<String, String> userInfo = new HashMap<>();
        userInfo.put("name", "Иван Иванов");
        userInfo.put("email", "ivan@example.com");
        userInfo.put("role", "admin");
        model.addAttribute("userInfo", userInfo);

        // Массив для демонстрации
        String[] categories = {"Политика", "Экономика", "Наука", "Технологии"};
        model.addAttribute("categories", categories);

        return "home";
    }

    @GetMapping("/jsp-example")
    public String jspExample(Model model) {
        model.addAttribute("news", new News(
                "Это пример для jsp",
                "Демонстрация работы с jsp",
                LocalDateTime.now(),
                "Команда JSP"
        ));
        return "jsp-example";
    }
}