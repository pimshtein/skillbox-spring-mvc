package ru.podeli.notification.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.podeli.notification.mvc.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
