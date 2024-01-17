package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.ClientulRequest;
import com.example.hotelManagement.model.Clientul;
import org.springframework.stereotype.Component;

@Component
public class ClientulMapper {
    public Clientul clientulRequest(ClientulRequest clientulRequest){
        return new Clientul(
                clientulRequest.getNume(),
                clientulRequest.getPrenume(),
                clientulRequest.getMail(),
                clientulRequest.getTelefon(),
                clientulRequest.getTara()
        );
    }
}
