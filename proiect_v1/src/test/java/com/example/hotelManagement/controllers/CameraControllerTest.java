package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.CameraRequest;
import com.example.hotelManagement.exception.CameraNotFoundException;
import com.example.hotelManagement.mapper.CameraMapper;
import com.example.hotelManagement.model.Camera;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.services.CameraService;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CameraController.class)
public class CameraControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private CameraService cameraService;
    @MockBean
    private CameraMapper cameraMapper;

    @Test
    public void createcamera() throws Exception{
        Hotel h = new Hotel("Ramada","Sect2");
        CameraRequest request = new CameraRequest(101, h);
        when(cameraService.saveCamera(any())).thenReturn(new Camera(101,h));
        mockMvc.perform(post("/camera")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numarCamera").value(request.getNumar()));
    }

    @Test
    public void getAllTip() throws Exception {
        Hotel h = new Hotel("Ramada","Sect2");
        Camera camera1 = new Camera(101, h);
        Camera camera2 = new Camera(102, h);
        List<Camera> cameraList = new ArrayList<>();
        cameraList.add(camera1);
        cameraList.add(camera2);

        when(cameraService.getCameraAscNumar()).thenReturn(cameraList);
        mockMvc.perform(get("/camera/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(cameraList.size()))
                .andExpect(jsonPath("$[0].id").value(cameraList.get(0).getId()))
                .andExpect(jsonPath("$[0].numarCamera").value(cameraList.get(0).getNumarCamera()))
                .andExpect(jsonPath("$[1].id").value(cameraList.get(1).getId()))
                .andExpect(jsonPath("$[1].numarCamera").value(cameraList.get(1).getNumarCamera()));

    }
    @Test
    public void deleteCamera() throws Exception, CameraNotFoundException {
        Long id = 1L;
        cameraService.deleteById(id);
        mockMvc.perform(delete("/camera/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
