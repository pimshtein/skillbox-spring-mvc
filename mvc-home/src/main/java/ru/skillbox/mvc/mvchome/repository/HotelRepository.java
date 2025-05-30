package ru.skillbox.mvc.mvchome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.skillbox.mvc.mvchome.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
} 