package ru.podeli.notification.mvc3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import ru.podeli.notification.mvc3.model.News;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class RestSyncAsyncController {
    
    @GetMapping("/news/json")
    public News getNews() {
        return new News(1L, "Заголовок новости", "Содержимое новости");
    }

    @GetMapping("/news/async/future")
    public CompletableFuture<News> getNewsAsyncFuture() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Имитируем задержку при получении новости, расчет происходит в отдельном потоке
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return new News(1L, "Асинхронный заголовок", "Это новость получена асинхронно!");
        });
    }

    @GetMapping("/news/async/deferred")
    public DeferredResult<News> getNewsAsyncDeferred() {
        DeferredResult<News> deferredResult = new DeferredResult<>();
        
        new Thread(() -> {
            try {
                // Имитируем задержку при получении новости
                TimeUnit.SECONDS.sleep(10);
                // Устанавливаем результат
                deferredResult.setResult(new News(2L, "Deferred заголовок", "Это новость получена через DeferredResult!"));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                deferredResult.setErrorResult(e);
            }
        }).start();
        
        return deferredResult;
    }

    @GetMapping("/news/async/future/rightnow")
    public ResponseEntity<String> getNewsAsyncFutureRightNow() {
        CompletableFuture<List<News>> futureResult = CompletableFuture.supplyAsync(() -> {
            try {
                // Имитируем задержку при парсинге новостей, расчет происходит в отдельном потоке
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return List.of(
                    new News(1L, "Первая новость", "Первая новость получена после длительного парсинга"),
                    new News(2L, "Вторая новость", "Вторая новость получена после длительного парсинга")
            );
        });

        // Добавляем обработчик результата асинхронной операции
        futureResult.thenAccept(news -> {
            // Обработка результата, например, логирование
            System.out.println("Завершена работа длительного метода: " + news);
        });

        // Результат пользователю возвращаем сразу, не дожидаясь завершения асинхронной операции
        return ResponseEntity.ok("Процесс парсинга успешно запущен");
    }
}
