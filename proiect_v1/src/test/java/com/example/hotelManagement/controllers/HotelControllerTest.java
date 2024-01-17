package com.example.hotelManagement.controllers;

import com.example.hotelManagement.exception.HotelNotFoundException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import com.example.hotelManagement.dto.HotelRequest;
import com.example.hotelManagement.mapper.HotelMapper;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.services.Hotelservice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = HotelController.class)
public class HotelControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private Hotelservice hotelService;
    @MockBean
    private HotelMapper hotelMapper;

    @Test
    public void createhotel() throws Exception{
        HotelRequest request = new HotelRequest("Ramada","Sector2");
        when(hotelService.saveHotel(any())).thenReturn(new Hotel(1,"Ramada","Sector2"));
        mockMvc.perform(post("/hotel")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nume").value(request.getNume()));
    }

    @Test
    public void getAllTip() throws Exception {
        Hotel hotel1 = new Hotel(1,"Ramada","Sector2");
        Hotel hotel2 = new Hotel(2,"Intercontinental","Sector1");
        List<Hotel> hotelList = new ArrayList<>();
        hotelList.add(hotel1);
        hotelList.add(hotel2);

        when(hotelService.gethotelAscNume()).thenReturn(hotelList);
        mockMvc.perform(get("/hotel/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(hotelList.size()))
                .andExpect(jsonPath("$[0].id").value(hotelList.get(0).getId()))
                .andExpect(jsonPath("$[0].nume").value(hotelList.get(0).getNume()))
                .andExpect(jsonPath("$[0].adresa").value(hotelList.get(0).getAdresa()))
                .andExpect(jsonPath("$[1].id").value(hotelList.get(1).getId()))
                .andExpect(jsonPath("$[1].nume").value(hotelList.get(1).getNume()))
                .andExpect(jsonPath("$[1].adresa").value(hotelList.get(1).getAdresa()));
    }

    @Test
    public void updateHotel() throws Exception{
        Hotel h = new Hotel(1,"Ramada","Sector2");
        Hotel h1 = new Hotel(2,"Intercontinental","Sector2");

        mockMvc.perform(put("/hotel/{id}",1)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(h1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nume").value("Intercontinental"));

    }





    @Test
    public void deleteHotel() throws Exception, HotelNotFoundException {
        Long id = 1L;
        hotelService.deleteById(id);
        mockMvc.perform(delete("/hotel/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
