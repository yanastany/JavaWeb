package com.example.hotelManagement.services;

import com.example.hotelManagement.dto.HotelUpdateDto;
import com.example.hotelManagement.exception.DuplicateHotel;
import com.example.hotelManagement.exception.HotelNotFoundException;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceInt implements Hotelservice {
    
    private final HotelRepository hotelRepository;

    public HotelServiceInt(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }


    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();
    }


    public Optional<Hotel> getHotelById(Long id) throws HotelNotFoundException {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if (hotel.isPresent()) {
            return hotel;
        } else {
            throw new HotelNotFoundException(id);
        }
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        Optional<Hotel> hotelExistent = hotelRepository.findByNrid(hotel.getId());
        hotelExistent.ifPresent(c -> {
            throw new DuplicateHotel();
        });
        return hotelRepository.save(hotel);
    }


    public Hotel updateHotel(Long id, Hotel hotel) {
        return null;
    }


    public void deleteById(Long id) throws HotelNotFoundException {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isPresent()){
            hotelRepository.deleteById(id);
        }else
        {
            throw new HotelNotFoundException(id);
        }
    }


    public Hotel updateHotel(Long id, HotelUpdateDto hotel) throws HotelNotFoundException {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if(hotelOptional.isPresent()){
            Hotel imp = hotelOptional.get();
            imp.setNume(hotel.getNume());
            return hotelRepository.save(imp);
        }else
        {
            throw new HotelNotFoundException(id);
        }
    }

    @Override
    public List<Hotel> gethotelAscNume() {
        // Implement the sorting logic
        return hotelRepository.findAll(); // Placeholder implementation
    }

    @Override
    public List<Hotel> gethotelDescNume() {
        return null;
    }


    public List<Hotel> getHotelDescNume() {
        return null;
    }


    public List<Hotel> getHotelAscNume() {
        return null;
    }

    // Implement other methods...
}


