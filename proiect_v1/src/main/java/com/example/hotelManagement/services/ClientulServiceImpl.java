package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.ClientulNotFoundException;
import com.example.hotelManagement.model.Clientul;
import com.example.hotelManagement.repositories.ClientulRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientulServiceImpl implements ClientulService {
    private final ClientulRepository clientulRepository;

    public ClientulServiceImpl(ClientulRepository clientulRepository) {
        this.clientulRepository = clientulRepository;
    }

    public Clientul saveClientul(Clientul clientul) {
        return clientulRepository.save(clientul);
    }


    public Clientul updateClientul(Long id, Clientul clientul) {
        return null;
    }


    public List<Clientul> getclientulAscNume() {
        return clientulRepository.findAllByOrderByNumeAsc();
    }


    public List<Clientul> getclientulDescNume() {
        return null;
    }

    public void deleteById(Long id) throws ClientulNotFoundException {
        Optional<Clientul> clientul = clientulRepository.findById(id);
        if(clientul.isPresent()){
            clientulRepository.deleteById(id);
        }else
        {
            throw new ClientulNotFoundException(id);
        }
    }

    public List<Clientul> getAllClientul() {
        return clientulRepository.findAll();
    }
}