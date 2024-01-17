package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.ClientulRequest;
import com.example.hotelManagement.exception.ClientulNotFoundException;
import com.example.hotelManagement.mapper.ClientulMapper;
import com.example.hotelManagement.model.Clientul;
import com.example.hotelManagement.model.Tara;
import com.example.hotelManagement.services.ClientulService;

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

@WebMvcTest(controllers = ClientulController.class)
public class ClientulControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private ClientulService clientulService;
    @MockBean
    private ClientulMapper clientulMapper;

    @Test
    public void createclientul() throws Exception{
        Tara t = new Tara(1,"Romania","Europa");
        ClientulRequest request = new ClientulRequest();
        when(clientulService.saveClientul(any())).thenReturn(new Clientul("Stan","Ana","ana@gmail.com","0777777777",t));
        mockMvc.perform(post("/clientul")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nume").value(request.getNume()));
    }

    @Test
    public void getAllTip() throws Exception {
        Tara t = new Tara(1,"Romania","Europa");
        Clientul clientul1 = new Clientul("Stan","Ana","ana@gmail.com","0777777777",t);
        Clientul clientul2 = new Clientul("Ion","Mihai","mihai@gmail.com","0777711777",t);
        List<Clientul> clientulList = new ArrayList<>();
        clientulList.add(clientul1);
        clientulList.add(clientul2);

        when(clientulService.getclientulAscNume()).thenReturn(clientulList);
        mockMvc.perform(get("/clientul/asc")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(clientulList.size()))
                .andExpect(jsonPath("$[0].id").value(clientulList.get(0).getId()))
                .andExpect(jsonPath("$[0].nume").value(clientulList.get(0).getNume()))
                .andExpect(jsonPath("$[0].prenume").value(clientulList.get(0).getPrenume()))
                .andExpect(jsonPath("$[0].mail").value(clientulList.get(0).getMail()))
                .andExpect(jsonPath("$[0].telefon").value(clientulList.get(0).getTelefon()))
                .andExpect(jsonPath("$[1].id").value(clientulList.get(1).getId()))
                .andExpect(jsonPath("$[1].nume").value(clientulList.get(1).getNume()))
                .andExpect(jsonPath("$[1].prenume").value(clientulList.get(1).getPrenume()))
                .andExpect(jsonPath("$[1].mail").value(clientulList.get(1).getMail()))
                .andExpect(jsonPath("$[1].telefon").value(clientulList.get(1).getTelefon()));
    }
    @Test
    public void deleteClientul() throws Exception, ClientulNotFoundException {
        Long id = 1L;
        clientulService.deleteById(id);
        mockMvc.perform(delete("/clientul/{id}",id)
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
