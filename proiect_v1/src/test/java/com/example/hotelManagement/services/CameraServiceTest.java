package com.example.hotelManagement.services;


import com.example.hotelManagement.model.Camera;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.repositories.CameraRepository;
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
public class CameraServiceTest {

    @InjectMocks
    private CameraServiceImpl cameraservice;

    @Mock
    private CameraRepository cameraRepository;

//    @Test
//    void whenCameraAlreadyExists_saveCamera_throwsDuplicateCameraException() throws ParseException {
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Camera h = new Camera(101,a);
//
//
//        when(cameraRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.of(h));
//
//        //Act
//        DuplicateCamera exception = assertThrows(DuplicateCamera.class,
//                () -> cameraservice.saveCamera(h));
//
//        //Assert
//        assertEquals("Deja exista o camera cu acest numar de inregistrare.",exception.getMessage());
//        verify(cameraRepository,times(0)).save(h);
//    }
//
//    @Test
//    void whenCameraDoesntExist_saveCamera_savesTheCamera() throws ParseException {
//
//
//        Hotel a= new Hotel("Intercontinental","Universitate");
//        Camera h = new Camera(101,a);
//
//
//        when(cameraRepository.findByNrid(h.getId()))
//                .thenReturn(Optional.empty());
//
//
//        Camera h1 = new Camera(101,a);
//
//        when(cameraRepository.save(h)).thenReturn(h1);
//
//        Camera result = cameraservice.saveCamera(h);
//
//        assertNotNull(result);
//        assertEquals(h1.getId(),result.getId());
//
//        assertEquals(h1.getId(),result.getId());
//        assertEquals(h.getId(),result.getId());
//
//        verify(cameraRepository).findByNrid(h.getId());
//        verify(cameraRepository).save(h);
//    }

    @Test
    void testGetAllCamera() throws ParseException {

        Hotel a= new Hotel("Intercontinental","Universitate");
        Camera h = new Camera(101,a);
        Camera h2 = new Camera(101,a);

        List<Camera> cameraList = new ArrayList<>();;
        cameraList.add(h);
        cameraList.add(h2);

        when(cameraRepository.findAll()).thenReturn(cameraList);

        List<Camera> result = cameraservice.getAllCamera();

        assertEquals(cameraList.size(),result.size());
        assertEquals(cameraList,result);

    }

}
