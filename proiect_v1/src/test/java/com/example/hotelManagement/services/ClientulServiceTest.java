package com.example.hotelManagement.services;


import com.example.hotelManagement.model.Clientul;
import com.example.hotelManagement.repositories.ClientulRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class ClientulServiceTest {

    @InjectMocks
    private ClientulServiceImpl clientulservice;

    @Mock
    private ClientulRepository clientulRepository;

//    @Test
//    void whenClientulAlreadyExists_saveClientul_throwsDuplicateClientulException() throws ParseException {
//
//
//        Clientul h = new Clientul("Stan","Ana","ana@gmail.com","077777");
//
//
//        when(clientulRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.of(h));
//
//        //Act
//        DuplicateClientul exception = assertThrows(DuplicateClientul.class,
//                () -> clientulservice.saveClientul(h));
//
//        //Assert
//        assertEquals("Deja exista un client cu acest numar de inregistrare.",exception.getMessage());
//        verify(clientulRepository,times(0)).save(h);
//    }
//
//    @Test
//    void whenClientulDoesntExist_saveClientul_savesTheClientul() throws ParseException {
//
//
//        Clientul h = new Clientul("Stan","Ana","ana@gmail.com","077777");
//
//
//        when(clientulRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.empty());
//
//        Clientul h1 = new Clientul("Stan","Ana","ana@gmail.com","077777");
//
//        when(clientulRepository.save(h)).thenReturn(h1);
//
//        Clientul result = clientulservice.saveClientul(h);
//
//        assertNotNull(result);
//        assertEquals(h1.getId(),result.getId());
//
//        assertEquals(h1.getId(),result.getId());
//        assertEquals(h.getId(),result.getId());
//
//        verify(clientulRepository).findByNrid(h.getId());
//        verify(clientulRepository).save(h);
//    }

    @Test
    void testGetAllClientul() throws ParseException {

        Clientul h = new Clientul("Stan","Ana","ana@gmail.com","077777");


        Clientul h2 = new Clientul("Stan","Ana","ana@gmail.com","077777");

        List<Clientul> clientulList = new ArrayList<>();;
        clientulList.add(h);
        clientulList.add(h2);

        when(clientulRepository.findAll()).thenReturn(clientulList);

        List<Clientul> result = clientulservice.getAllClientul();

        assertEquals(clientulList.size(),result.size());
        assertEquals(clientulList,result);

    }

}
