package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.AngajatiRequest;
import com.example.hotelManagement.model.Angajati;
import org.springframework.stereotype.Component;

@Component
public class AngajatiMapper {
    public Angajati angajatiRequest(AngajatiRequest angajatiRequest){
        return new Angajati(angajatiRequest.getNume(), angajatiRequest.getPrenume(), angajatiRequest.getSalariu(),angajatiRequest.getHotel());
    }
}
