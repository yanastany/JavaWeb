package com.example.hotelManagement.services;


import com.example.hotelManagement.exception.DuplicateTara;
import com.example.hotelManagement.model.Tara;
import com.example.hotelManagement.repositories.TaraRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class TaraServiceTest {

    @InjectMocks
    private TaraServiceInt taraservice;

    @Mock
    private TaraRepository taraRepository;

    @Test
    void whenTaraAlreadyExists_saveTara_throwsDuplicateTaraException() throws ParseException {


        Tara h = new Tara("Intercontinental","Universitate");


        when(taraRepository.findByNrid(h.getId()))
                .thenReturn(Optional.of(h));

        //Act
        DuplicateTara exception = assertThrows(DuplicateTara.class,
                () -> taraservice.saveTara(h));

        //Assert
        assertEquals("Deja exista o tara cu acest numar de inregistrare.",exception.getMessage());
        verify(taraRepository,times(0)).save(h);
    }

    @Test
    void whenTaraDoesntExist_saveTara_savesTheTara() throws ParseException {


        Tara h = new Tara("Intercontinental","Universitate");


        when(taraRepository.findByNrid(h.getId()))
                .thenReturn(Optional.empty());

        Tara h1 = new Tara("Intercontinental","Universitate");

        when(taraRepository.save(h)).thenReturn(h1);

        Tara result = taraservice.saveTara(h);

        assertNotNull(result);
        assertEquals(h1.getId(),result.getId());

        assertEquals(h1.getId(),result.getId());
        assertEquals(h.getId(),result.getId());

        verify(taraRepository).findByNrid(h.getId());
        verify(taraRepository).save(h);
    }

    @Test
    void testGetAllTara() throws ParseException {

        Tara h = new Tara("Intercontinental","Universitate");


        Tara h2 = new Tara("Intercontinental2","Universitate");

        List<Tara> taraList = new ArrayList<>();;
        taraList.add(h);
        taraList.add(h2);

        when(taraRepository.findAll()).thenReturn(taraList);

        List<Tara> result = taraservice.gettaraAscNume();

        assertEquals(taraList.size(),result.size());
        assertEquals(taraList,result);

    }

}
