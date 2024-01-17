package com.example.hotelManagement.services;


import com.example.hotelManagement.model.Rezervare;
import com.example.hotelManagement.repositories.RezervareRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class RezervareServiceTest {

    @InjectMocks
    private RezervareServiceImpl rezervareservice;

    @Mock
    private RezervareRepository rezervareRepository;

//    @Test
//    void whenRezervareAlreadyExists_saveRezervare_throwsDuplicateRezervareException() throws ParseException {
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Rezervare h = new Rezervare(101,a);
//
//
//        when(rezervareRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.of(h));
//
//        //Act
//        DuplicateRezervare exception = assertThrows(DuplicateRezervare.class,
//                () -> rezervareservice.saveRezervare(h));
//
//        //Assert
//        assertEquals("Deja exista o rezervare cu acest numar de inregistrare.",exception.getMessage());
//        verify(rezervareRepository,times(0)).save(h);
//    }
//
//    @Test
//    void whenRezervareDoesntExist_saveRezervare_savesTheRezervare() throws ParseException {
//
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Rezervare h = new Rezervare(101,a);
//
//
//        when(rezervareRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.empty());
//
//
//        Rezervare h1 = new Rezervare(101,a);
//
//        when(rezervareRepository.save(h)).thenReturn(h1);
//
//        Rezervare result = rezervareservice.saveRezervare(h);
//
//        assertNotNull(result);
//        assertEquals(h1.getId(),result.getId());
//
//        assertEquals(h1.getId(),result.getId());
//        assertEquals(h.getId(),result.getId());
//
//        verify(rezervareRepository).findByNrid(h.getId());
//        verify(rezervareRepository).save(h);
//    }

    @Test
    void testGetAllRezervare() throws ParseException {


        Rezervare h = new Rezervare();
        Rezervare h2 = new Rezervare();

        List<Rezervare> rezervareList = new ArrayList<>();;
        rezervareList.add(h);
        rezervareList.add(h2);

        when(rezervareRepository.findAll()).thenReturn(rezervareList);

        List<Rezervare> result = rezervareservice.getAllRezervare();

        assertEquals(rezervareList.size(),result.size());
        assertEquals(rezervareList,result);

    }

}
