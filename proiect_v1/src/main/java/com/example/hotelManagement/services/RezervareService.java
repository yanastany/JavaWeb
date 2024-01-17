package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.RezervareNotFoundException;
import com.example.hotelManagement.model.Rezervare;

import java.util.List;

public interface RezervareService {
    Rezervare saveRezervare(Rezervare rezervare);
    Rezervare updateRezervare(Long id, Rezervare rezervare);
    List<Rezervare> getRezervareAscNumar();
    List<Rezervare> getrezervareDescNumar();
    void deleteById(Long id) throws RezervareNotFoundException;
    List<Rezervare> getAllRezervare();
}
