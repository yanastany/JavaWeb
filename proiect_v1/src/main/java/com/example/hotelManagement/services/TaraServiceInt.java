package com.example.hotelManagement.services;

import com.example.hotelManagement.dto.TaraUpdateDto;
import com.example.hotelManagement.exception.DuplicateTara;
import com.example.hotelManagement.exception.TaraNotFoundException;
import com.example.hotelManagement.model.Tara;
import com.example.hotelManagement.repositories.TaraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaraServiceInt implements Taraservice {
    private final TaraRepository taraRepository;

    public TaraServiceInt(TaraRepository taraRepository) {
        this.taraRepository = taraRepository;
    }


    public List<Tara> getAllTara() {
        return taraRepository.findAll();
    }


    public Optional<Tara> getTaraById(Long id) throws TaraNotFoundException {
        Optional<Tara> tara = taraRepository.findById(id);
        if (tara.isPresent()) {
            return tara;
        } else {
            throw new TaraNotFoundException(id);
        }
    }

    @Override
    public Tara saveTara(Tara tara) {
        Optional<Tara> taraExistent = taraRepository.findByNrid(tara.getId());
        taraExistent.ifPresent(c -> {
            throw new DuplicateTara();
        });
        return taraRepository.save(tara);
    }


    public Tara updateTara(Long id, TaraUpdateDto tara) throws TaraNotFoundException {
        Optional<Tara> taraOptional = taraRepository.findById(id);
        if(taraOptional.isPresent()){
            Tara t = taraOptional.get();
            t.setNumeTara(tara.getNumeTara());
            return taraRepository.save(t);
        }else
        {
            throw new TaraNotFoundException(id);
        }
    }


    public Tara updateTara(Long id, Tara tara) {
        // Implement the update logic
        return taraRepository.save(tara);
    }



    @Override
    public List<Tara> gettaraDescNumeTara() {
        return null;
    }


    public List<Tara> gettaraAscNume() {
        // Implement the sorting logic
        return taraRepository.findAll(); // Placeholder implementation
    }

    public void deleteById(Long id) throws TaraNotFoundException {
        Optional<Tara> tara = taraRepository.findById(id);
        if(tara.isPresent()){
            taraRepository.deleteById(id);
        }else
        {
            throw new TaraNotFoundException(id);
        }
    }
    public List<Tara> gettaraDescNume() {
        return null;
    }


    public List<Tara> getTaraDescNume() {
        return null;
    }


    public List<Tara> getTaraAscNume() {
        return null;
    }

    // Implement other methods...
}
