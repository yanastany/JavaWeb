package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.AngajatiNotFoundException;
import com.example.hotelManagement.model.Angajati;

import java.util.List;

public interface AngajatiService {
    Angajati saveAngajati(Angajati angajati);
    Angajati updateAngajati(Long id, Angajati angajati);
    List<Angajati> getAngajatiAscNume();
    List<Angajati> getangajatiDescNume();
    void deleteById(Long id) throws AngajatiNotFoundException;
    List<Angajati> getAllAngajati();
}
