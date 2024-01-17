package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.RezervareRequest;
import com.example.hotelManagement.exception.RezervareNotFoundException;
import com.example.hotelManagement.mapper.RezervareMapper;
import com.example.hotelManagement.model.*;
import com.example.hotelManagement.services.RezervareService;
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

@WebMvcTest(controllers = RezervareController.class)
public class RezervareControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private RezervareService rezervareService;
    @MockBean
    private RezervareMapper rezervareMapper;

    @Test
    public void createrezervare() throws Exception{
        Hotel h = new Hotel("Ramada","Sect2");
        Camera c = new Camera(101,h);
        Tara t = new Tara("Romania","Europa");
        Clientul clientul = new Clientul("stan","ana","11a@gmail.com","08966887",t);
        RezervareRequest request = new RezervareRequest(101,"10-10-2024","10-10-2024","10-10-2024",c,clientul);
        when(rezervareService.saveRezervare(any())).thenReturn(new Rezervare(101,"10-10-2024","10-10-2024","10-10-2024",c,clientul));
        mockMvc.perform(post("/rezervare")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numarRezervare").value(request.getNumarRezervare()));
    }

    @Test
    public void getAllTip() throws Exception {
        Hotel h = new Hotel("Ramada","Sect2");
        Camera c = new Camera(101,h);
        Tara t = new Tara("Romania","Europa");
        Clientul clientul = new Clientul("stan","ana","11a@gmail.com","08966887",t);
        Rezervare rezervare1 = new Rezervare(101,"10-10-2024","10-10-2024","10-10-2024",c,clientul);
        Rezervare rezervare2 = new Rezervare(102,"10-10-2024","10-10-2024","10-10-2024",c,clientul);
        List<Rezervare> rezervareList = new ArrayList<>();
        rezervareList.add(rezervare1);
        rezervareList.add(rezervare2);

        when(rezervareService.getRezervareAscNumar()).thenReturn(rezervareList);
        mockMvc.perform(get("/rezervare/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(rezervareList.size()))
                .andExpect(jsonPath("$[0].id").value(rezervareList.get(0).getId()))
                .andExpect(jsonPath("$[0].numarRezervare").value(rezervareList.get(0).getNumarRezervare()))
                .andExpect(jsonPath("$[0].dataStart").value(rezervareList.get(0).getDataStart()))
                .andExpect(jsonPath("$[0].dataFinal").value(rezervareList.get(0).getDataFinal()))
                .andExpect(jsonPath("$[0].rezervare").value(rezervareList.get(0).getRezervare()))
                .andExpect(jsonPath("$[1].id").value(rezervareList.get(1).getId()))
                .andExpect(jsonPath("$[1].numarRezervare").value(rezervareList.get(1).getNumarRezervare()))
                .andExpect(jsonPath("$[1].dataStart").value(rezervareList.get(1).getDataStart()))
                .andExpect(jsonPath("$[1].dataFinal").value(rezervareList.get(1).getDataFinal()))
                .andExpect(jsonPath("$[1].rezervare").value(rezervareList.get(1).getRezervare()));

    }
    @Test
    public void deleteRezervare() throws Exception, RezervareNotFoundException {
        Long id = 1L;
        rezervareService.deleteById(id);
        mockMvc.perform(delete("/rezervare/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
