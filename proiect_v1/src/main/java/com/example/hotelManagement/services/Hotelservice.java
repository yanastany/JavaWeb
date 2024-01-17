package com.example.hotelManagement.services;


import com.example.hotelManagement.dto.HotelUpdateDto;
import com.example.hotelManagement.exception.HotelNotFoundException;
import com.example.hotelManagement.model.Hotel;

import java.util.List;

public interface Hotelservice {
    Hotel updateHotel(Long id, HotelUpdateDto imprumut) throws HotelNotFoundException;

    Hotel saveHotel(Hotel hotel);
    Hotel updateHotel(Long id, Hotel hotel);
    void deleteById(Long id) throws HotelNotFoundException;
    List<Hotel> gethotelAscNume();
    List<Hotel> gethotelDescNume();
}
