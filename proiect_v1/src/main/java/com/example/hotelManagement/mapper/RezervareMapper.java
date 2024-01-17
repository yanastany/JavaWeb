package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.RezervareRequest;
import com.example.hotelManagement.model.Rezervare;
import org.springframework.stereotype.Component;

@Component
public class RezervareMapper {
    public Rezervare rezervareRequest(RezervareRequest rezervareRequest){
        return new Rezervare(rezervareRequest.getNumarRezervare(), rezervareRequest.getDataStart(),rezervareRequest.getDataFinal(),rezervareRequest.getRezervare(),rezervareRequest.getCamera(),rezervareRequest.getClientul());
    }
}
