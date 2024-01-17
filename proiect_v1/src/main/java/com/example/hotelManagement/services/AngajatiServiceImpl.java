package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.AngajatiNotFoundException;
import com.example.hotelManagement.model.Angajati;
import com.example.hotelManagement.repositories.AngajatiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AngajatiServiceImpl implements AngajatiService {
    private final AngajatiRepository angajatiRepository;

    public AngajatiServiceImpl(AngajatiRepository angajatiRepository) {
        this.angajatiRepository = angajatiRepository;
    }

    public Angajati saveAngajati(Angajati angajati) {
        return angajatiRepository.save(angajati);
    }

    @Override
    public Angajati updateAngajati(Long id, Angajati angajati) {
        return null;
    }

    public void deleteById(Long id) throws AngajatiNotFoundException {
        Optional<Angajati> angajati = angajatiRepository.findById(id);
        if(angajati.isPresent()){
            angajatiRepository.deleteById(id);
        }else
        {
            throw new AngajatiNotFoundException(id);
        }
    }

    public List<Angajati> getAllAngajati() {
        return angajatiRepository.findAll();
    }

    @Override
    public List<Angajati> getangajatiDescNume() {
        return null;
    }

    public List<Angajati> getAngajatiAscNume(){
        return angajatiRepository.findAllByOrderByNumeAsc();
    }
}
