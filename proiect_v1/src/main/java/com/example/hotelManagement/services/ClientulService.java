package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.ClientulNotFoundException;
import com.example.hotelManagement.model.Clientul;

import java.util.List;

public interface ClientulService {
    Clientul saveClientul(Clientul clientul);
    Clientul updateClientul(Long id, Clientul clientul);
    List<Clientul> getclientulAscNume();
    List<Clientul> getclientulDescNume();
    void deleteById(Long id) throws ClientulNotFoundException;
    List<Clientul> getAllClientul();
}
