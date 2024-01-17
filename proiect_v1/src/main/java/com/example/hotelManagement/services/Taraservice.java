package com.example.hotelManagement.services;

import com.example.hotelManagement.dto.TaraUpdateDto;
import com.example.hotelManagement.exception.TaraNotFoundException;
import com.example.hotelManagement.model.Tara;
import jakarta.validation.Valid;

import java.util.List;

public interface Taraservice {

    Tara saveTara(Tara tara);
    Tara updateTara(Long id, @Valid TaraUpdateDto tara) throws TaraNotFoundException;
    List<Tara> gettaraAscNume();
    List<Tara> gettaraDescNumeTara();
    void deleteById(Long id) throws TaraNotFoundException;


}
