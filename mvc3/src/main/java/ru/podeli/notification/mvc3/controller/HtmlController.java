package ru.podeli.notification.mvc3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.podeli.notification.mvc3.model.News;

@Controller
public class HtmlController {
    
    @GetMapping("/news/html")
    public String getNews(Model model) { // model - специализированный объект для хранения аттрибута "news" для шаблона
        News news = new News(1L, "Заголовок новости", "Содержимое новости");
        model.addAttribute("news", news);

        return "news"; // имя шаблона без расширения
    }
}
