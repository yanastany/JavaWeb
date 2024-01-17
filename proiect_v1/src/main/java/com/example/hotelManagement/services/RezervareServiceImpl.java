package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.RezervareNotFoundException;
import com.example.hotelManagement.model.Rezervare;
import com.example.hotelManagement.repositories.RezervareRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RezervareServiceImpl implements RezervareService {
    private final RezervareRepository rezervareRepository;

    public RezervareServiceImpl(RezervareRepository rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }

    public Rezervare saveRezervare(Rezervare rezervare) {
        return rezervareRepository.save(rezervare);
    }

    @Override
    public Rezervare updateRezervare(Long id, Rezervare rezervare) {
        return null;
    }

    @Override
    public List<Rezervare> getRezervareAscNumar() {
        return rezervareRepository.findAllByOrderByNumarRezervareAsc();
    }

    @Override
    public List<Rezervare> getrezervareDescNumar() {
        return null;
    }

    public List<Rezervare> getRezervareAscNume(){
        return rezervareRepository.findAllByOrderByNumarRezervareAsc();
    }
    public void deleteById(Long id) throws RezervareNotFoundException {
        Optional<Rezervare> rezervare = rezervareRepository.findById(id);
        if(rezervare.isPresent()){
            rezervareRepository.deleteById(id);
        }else
        {
            throw new RezervareNotFoundException(id);
        }
    }

    public List<Rezervare> getAllRezervare() {
        return rezervareRepository.findAll();
    }
}
