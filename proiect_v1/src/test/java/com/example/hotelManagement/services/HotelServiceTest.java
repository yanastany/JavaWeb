package com.example.hotelManagement.services;


import com.example.hotelManagement.exception.DuplicateHotel;
import com.example.hotelManagement.model.*;
import com.example.hotelManagement.repositories.HotelRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class HotelServiceTest {

    @InjectMocks
    private HotelServiceInt hotelservice;

    @Mock
    private HotelRepository hotelRepository;

    @Test
    void whenHotelAlreadyExists_saveHotel_throwsDuplicateHotelException() throws ParseException {


        Hotel h = new Hotel("Intercontinental","Universitate");


        when(hotelRepository.findByNrid(h.getId()))
                .thenReturn(Optional.of(h));

        //Act
        DuplicateHotel exception = assertThrows(DuplicateHotel.class,
                () -> hotelservice.saveHotel(h));

        //Assert
        assertEquals("Deja exista un hotel cu acest numar de inregistrare.",exception.getMessage());
        verify(hotelRepository,times(0)).save(h);
    }

    @Test
    void whenHotelDoesntExist_saveHotel_savesTheHotel() throws ParseException {


        Hotel h = new Hotel("Intercontinental","Universitate");


        when(hotelRepository.findByNrid(h.getId()))
                .thenReturn(Optional.empty());

        Hotel h1 = new Hotel("Intercontinental","Universitate");

        when(hotelRepository.save(h)).thenReturn(h1);

        Hotel result = hotelservice.saveHotel(h);

        assertNotNull(result);
        assertEquals(h1.getId(),result.getId());

        assertEquals(h1.getId(),result.getId());
        assertEquals(h.getId(),result.getId());

        verify(hotelRepository).findByNrid(h.getId());
        verify(hotelRepository).save(h);
    }

    @Test
    void testGetAllHotel() throws ParseException {

        Hotel h = new Hotel("Intercontinental","Universitate");


        Hotel h2 = new Hotel("Intercontinental2","Universitate");

        List<Hotel> hotelList = new ArrayList<>();;
        hotelList.add(h);
        hotelList.add(h2);

        when(hotelRepository.findAll()).thenReturn(hotelList);

        List<Hotel> result = hotelservice.gethotelAscNume();

        assertEquals(hotelList.size(),result.size());
        assertEquals(hotelList,result);

    }

}
