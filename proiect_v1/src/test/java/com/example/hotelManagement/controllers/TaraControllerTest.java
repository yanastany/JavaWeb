package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.TaraRequest;
import com.example.hotelManagement.exception.TaraNotFoundException;
import com.example.hotelManagement.mapper.TaraMapper;
import com.example.hotelManagement.model.Tara;
import com.example.hotelManagement.services.Taraservice;
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

@WebMvcTest(controllers = TaraController.class)
public class TaraControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private Taraservice taraService;
    @MockBean
    private TaraMapper taraMapper;

    @Test
    public void createtara() throws Exception{
        TaraRequest request = new TaraRequest("Romania","Europa");
        when(taraService.saveTara(any())).thenReturn(new Tara(1,"Romania","Europa"));
        mockMvc.perform(post("/tara")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.numeTara").value(request.getNumeTara()));
    }

    @Test
    public void getAllTip() throws Exception {
        Tara tara1 = new Tara("Romania", "Europa");
        Tara tara2 = new Tara("Germania", "Europa");
        List<Tara> taraList = new ArrayList<>();
        taraList.add(tara1);
        taraList.add(tara2);

        when(taraService.gettaraAscNume()).thenReturn(taraList);
        mockMvc.perform(get("/tara/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(taraList.size()))
                .andExpect(jsonPath("$[0].id").value(taraList.get(0).getId()))
                .andExpect(jsonPath("$[0].numeTara").value(taraList.get(0).getNumeTara()))
                .andExpect(jsonPath("$[0].regiuneTara").value(taraList.get(0).getRegiuneTara()))
                .andExpect(jsonPath("$[1].id").value(taraList.get(1).getId()))
                .andExpect(jsonPath("$[1].numeTara").value(taraList.get(1).getNumeTara()))
                .andExpect(jsonPath("$[1].regiuneTara").value(taraList.get(1).getRegiuneTara()));
    }

    @Test
    public void deleteTara() throws Exception, TaraNotFoundException {
        Long id = 1L;
        taraService.deleteById(id);
        mockMvc.perform(delete("/tara/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

}
