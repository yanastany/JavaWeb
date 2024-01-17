package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.TaraRequest;
import com.example.hotelManagement.model.Tara;
import org.springframework.stereotype.Component;

@Component
public class TaraMapper {
    public Tara taraRequest(TaraRequest taraRequest){
        return new Tara(taraRequest.getNumeTara(), taraRequest.getRegiuneTara());
    }
}
