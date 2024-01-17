package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.RezervareRequest;
import com.example.hotelManagement.exception.RezervareNotFoundException;
import com.example.hotelManagement.mapper.RezervareMapper;
import com.example.hotelManagement.model.Rezervare;
import com.example.hotelManagement.services.RezervareService;
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
@RequestMapping("/rezervare")
@Tag(name = "Rezervare",description = "Endpoint manage Rezervare")
public class RezervareController {
    RezervareService rezervareService;
    RezervareMapper rezervareMapper;

    public RezervareController(RezervareService rezervareService, RezervareMapper rezervareMapper) {
        this.rezervareService = rezervareService;
        this.rezervareMapper = rezervareMapper;
    }


    @GetMapping(path = "/asc",produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Afisarea rezervareurilor in ordine alfabetica",
            summary = "Afisare rezervare alfabetic",
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
    public ResponseEntity<List<Rezervare>> GetrezervareAscNumar(){
        return ResponseEntity.ok(rezervareService.getRezervareAscNumar());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare rezervare",
            summary = "Creare rezervare nou   ",
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
    public ResponseEntity<Rezervare> createCarte(@Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
//                                                             @ExampleObject(name = "rezervare", value = "{\"nume_rezervare\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\",\"id\":1}")
                                                             @ExampleObject(name = "rezervare", value = "{\"numarRezervare\":\"1101\",\"dataStart\":\"2024-10-12\",\"dataFinal\":\"2024-10-22\",\"rezervare\":\"2023-12-12\",\"camera\":{\"id\":1},\"clientul\":{\"id\":1}}")




                                                     }
                                                     ))
                                             RezervareRequest rezervareRequest){
        Rezervare rezervare = rezervareService.saveRezervare(rezervareMapper.rezervareRequest(rezervareRequest));
        return ResponseEntity.created(URI.create("/rezervare/" + rezervare.getId()))
                .body(rezervare);
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea rezerv cu id dat",
            summary = "Stergerea unui hotel cu id dat",
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
    public void deleteRezervare(@PathVariable
                               @Parameter(name = "id",description = "Codul rezervarii pe care doriti sa il stergeti",example = "1",required = true)
                               Long id) throws  RezervareNotFoundException {
        rezervareService.deleteById(id);
    }
}
