package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.AngajatiRequest;
import com.example.hotelManagement.exception.AngajatiNotFoundException;
import com.example.hotelManagement.mapper.AngajatiMapper;
import com.example.hotelManagement.model.Angajati;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.services.AngajatiService;
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

@WebMvcTest(controllers = AngajatiController.class)
public class AngajatiControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private AngajatiService angajatiService;
    @MockBean
    private AngajatiMapper angajatiMapper;

    @Test
    public void createangajati() throws Exception{
        Hotel h = new Hotel("Ramada","Sect2");
        AngajatiRequest request = new AngajatiRequest("Stan","ana",10000,h);
        when(angajatiService.saveAngajati(any())).thenReturn(new Angajati("Stan","ana",10000,h));
        mockMvc.perform(post("/angajati")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nume").value(request.getNume()));
    }

    @Test
    public void getAllTip() throws Exception {
        Hotel h = new Hotel("Ramada","Sect2");
        Angajati angajati1 = new Angajati("Stan","ana",10000,h);
        Angajati angajati2 = new Angajati("Ion","Mario",8100,h);
        List<Angajati> angajatiList = new ArrayList<>();
        angajatiList.add(angajati1);
        angajatiList.add(angajati2);

        when(angajatiService.getAngajatiAscNume()).thenReturn(angajatiList);
        mockMvc.perform(get("/angajati/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(angajatiList.size()))
                .andExpect(jsonPath("$[0].id").value(angajatiList.get(0).getId()))
                .andExpect(jsonPath("$[0].nume").value(angajatiList.get(0).getNume()))
                .andExpect(jsonPath("$[0].prenume").value(angajatiList.get(0).getPrenume()))
                .andExpect(jsonPath("$[0].salariu").value(angajatiList.get(0).getSalariu()))
                .andExpect(jsonPath("$[1].id").value(angajatiList.get(1).getId()))
                .andExpect(jsonPath("$[1].nume").value(angajatiList.get(1).getNume()))
                .andExpect(jsonPath("$[1].prenume").value(angajatiList.get(1).getPrenume()))
                .andExpect(jsonPath("$[1].salariu").value(angajatiList.get(1).getSalariu()));


    }
    @Test
    public void deleteAngajati() throws Exception,  AngajatiNotFoundException {
        Long id = 1L;
        angajatiService.deleteById(id);
        mockMvc.perform(delete("/angajati/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
