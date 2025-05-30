package ru.skillbox.mvc.mvchome.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.skillbox.mvc.mvchome.exception.NotFoundException;
import ru.skillbox.mvc.mvchome.model.Hotel;
import ru.skillbox.mvc.mvchome.repository.HotelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {
    
    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public Hotel getHotel(Long id) {
        return hotelRepository.findById(id).orElseThrow(() -> new NotFoundException("Отель не найден"));
    }

    public void saveHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        if (!hotelRepository.existsById(id)) {
            throw new NotFoundException("Отель не найден");
        }
        hotelRepository.deleteById(id);
    }
} 