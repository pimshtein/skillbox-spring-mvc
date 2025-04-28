package ru.podeli.notification.mvc3.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {
    @GetMapping(value = "/news/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<Resource> getNewsPdf() {
        // Ищем файл в ресурсах или рабочей директории
        Resource resource = new ClassPathResource("news.pdf");

        if (!resource.exists()) {
            resource = new FileSystemResource("news.pdf");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"news.pdf\"")
                .body(resource);
    }
}
