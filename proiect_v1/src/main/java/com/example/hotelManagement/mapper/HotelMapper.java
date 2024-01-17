package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.HotelRequest;
import com.example.hotelManagement.model.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public Hotel hotelRequest(HotelRequest hotelRequest){
        return new Hotel(hotelRequest.getNume(), hotelRequest.getAdresa());
    }
}
