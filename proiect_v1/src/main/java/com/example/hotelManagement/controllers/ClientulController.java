package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.ClientulRequest;
import com.example.hotelManagement.exception.ClientulNotFoundException;
import com.example.hotelManagement.mapper.ClientulMapper;
import com.example.hotelManagement.model.Clientul;
import com.example.hotelManagement.services.ClientulService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController()
@Validated
@RequestMapping("/clientul")
@Tag(name = "Clientul",description = "Endpoint manage Clientul")
public class ClientulController {
    ClientulService clientulService;
    ClientulMapper clientulMapper;

    public ClientulController(ClientulService clientulService, ClientulMapper clientulMapper) {
        this.clientulService = clientulService;
        this.clientulMapper = clientulMapper;
    }


    @GetMapping(path = "/asc",produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Afisarea clientulurilor in ordine alfabetica",
            summary = "Afisare clientul alfabetic",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404"
                    ),
            })
    public ResponseEntity<List<Clientul>> GetclientulAscNume(){
        return ResponseEntity.ok(clientulService.getclientulAscNume());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare clientul",
            summary = "Creare clientul nou   ",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "201"
                    ),
                    @ApiResponse(
                            description = "Bad Request - validation error per request",
                            responseCode = "500"
                    ),
                    @ApiResponse(
                            description = "Field validation error",
                            responseCode = "400"
                    ),
            })
    public ResponseEntity<Clientul> createCarte(@Valid
                                                @RequestBody
                                                @Parameter(description = "MyDto")
                                                @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                        content = @Content(examples = {
                                                                @ExampleObject(name = "clientul", value = "{\"nume\":\"Gigi\",\"prenume\":\"Balan\",\"mail\":\"gigi@google.com\",\"telefon\":\"0732222222\",\"tara\":{\"id\":1}}")
                                                        }
                                                        ))
                                                ClientulRequest clientulRequest){
        Clientul clientul = clientulService.saveClientul(clientulMapper.clientulRequest(clientulRequest));
        return ResponseEntity.created(URI.create("/clientul/" + clientul.getId()))
                .body(clientul);
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea clientului cu id dat",
            summary = "Stergerea unui client cu id dat",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404"
                    ),
            })
    public void deleteClientul(@PathVariable
                            @Parameter(name = "id",description = "Codul clientului pe care doriti sa il stergeti",example = "1",required = true)
                            Long id) throws ClientulNotFoundException {
        clientulService.deleteById(id);
    }
}

