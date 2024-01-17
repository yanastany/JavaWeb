package com.example.hotelManagement.services;


import com.example.hotelManagement.model.Angajati;
import com.example.hotelManagement.repositories.AngajatiRepository;
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
public class AngajatiServiceTest {

    @InjectMocks
    private AngajatiServiceImpl angajatiservice;

    @Mock
    private AngajatiRepository angajatiRepository;

//    @Test
//    void whenAngajatiAlreadyExists_saveAngajati_throwsDuplicateAngajatiException() throws ParseException {
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Angajati h = new Angajati(101,a);
//
//
//        when(angajatiRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.of(h));
//
//        //Act
//        DuplicateAngajati exception = assertThrows(DuplicateAngajati.class,
//                () -> angajatiservice.saveAngajati(h));
//
//        //Assert
//        assertEquals("Deja exista o angajati cu acest numar de inregistrare.",exception.getMessage());
//        verify(angajatiRepository,times(0)).save(h);
//    }
//
//    @Test
//    void whenAngajatiDoesntExist_saveAngajati_savesTheAngajati() throws ParseException {
//
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Angajati h = new Angajati(101,a);
//
//
//        when(angajatiRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.empty());
//
//
//        Angajati h1 = new Angajati(101,a);
//
//        when(angajatiRepository.save(h)).thenReturn(h1);
//
//        Angajati result = angajatiservice.saveAngajati(h);
//
//        assertNotNull(result);
//        assertEquals(h1.getId(),result.getId());
//
//        assertEquals(h1.getId(),result.getId());
//        assertEquals(h.getId(),result.getId());
//
//        verify(angajatiRepository).findByNrid(h.getId());
//        verify(angajatiRepository).save(h);
//    }

    @Test
    void testGetAllAngajati() throws ParseException {

        
        Angajati h = new Angajati();
        Angajati h2 = new Angajati();

        List<Angajati> angajatiList = new ArrayList<>();;
        angajatiList.add(h);
        angajatiList.add(h2);

        when(angajatiRepository.findAll()).thenReturn(angajatiList);

        List<Angajati> result = angajatiservice.getAllAngajati();

        assertEquals(angajatiList.size(),result.size());
        assertEquals(angajatiList,result);

    }

}
