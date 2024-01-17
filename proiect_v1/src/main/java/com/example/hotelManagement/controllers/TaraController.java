package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.TaraRequest;
import com.example.hotelManagement.dto.TaraUpdateDto;
import com.example.hotelManagement.exception.TaraNotFoundException;
import com.example.hotelManagement.mapper.TaraMapper;

import com.example.hotelManagement.model.Tara;

import com.example.hotelManagement.services.Taraservice;
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
@RequestMapping("/tara")
@Tag(name = "Tara",description = "Endpoint manage Tara")
public class TaraController {
    Taraservice taraService;
    TaraMapper taraMapper;

    public TaraController(Taraservice taraService, TaraMapper taraMapper) {
        this.taraService = taraService;
        this.taraMapper = taraMapper;
    }


    @GetMapping(path = "/asc",produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Afisarea hotelurilor in ordine alfabetica",
            summary = "Afisare hotel alfabetic",
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
    public ResponseEntity<List<Tara>> GettaraAscNume(){
        return ResponseEntity.ok(taraService.gettaraAscNume());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare tara",
            summary = "Creare tara nou   ",
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

    public ResponseEntity<Tara> createCarte(@Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
//                                                             @ExampleObject(name = "tara", value = "{\"nume_tara\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\",\"id\":1}")
                                                             @ExampleObject(name = "tara", value = "{\"numeTara\":\"Romania\",\"regiuneTara\":\"Europa\"}")



                                                     }
                                                     ))
                                             TaraRequest taraRequest){
        Tara tara = taraService.saveTara(taraMapper.taraRequest(taraRequest));
        return ResponseEntity.created(URI.create("/tara/" + tara.getId()))
                .body(tara);
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea tarii cu id dat",
            summary = "Stergerea unui tari cu id dat",
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
    public void deleteTara(@PathVariable
                            @Parameter(name = "id",description = "Codul tarii pe care doriti sa il stergeti",example = "1",required = true)
                            Long id) throws TaraNotFoundException {
        taraService.deleteById(id);
    }

    @PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Updatarea tarii cu un id dat",
            summary = "Updatarea unui tari cu un id dat",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(examples = {
                                    @ExampleObject(value = "{\"id\":1,\"numeTara\":\"Romania\",\"regiuneTara\":\"Europa\"}")
                            })
                    ),
                    @ApiResponse(
                            description = "Not Found",
                            responseCode = "404",
                            content = @Content(examples = {
                                    @ExampleObject(value = "{}")
                            })
                    ),
                    @ApiResponse(
                            description = "Field validation error",
                            responseCode = "400",
                            content = @Content(examples = {
                                    @ExampleObject(value = "{\"numeTara\":\"Romania\",\"regiuneTara\":\"Europa\"}")
                            })
                    ),
            })
    public ResponseEntity<Tara> updateTara(@PathVariable
                                             @Parameter(name = "id", description = "Codul tarii pe care doriti sa il modificati", example = "1", required = true)
                                             Long id,
                                            @Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
                                                             @ExampleObject(value = "{\"numeTara\":\"Romania\",\"regiuneTara\":\"Europa\"}")
                                                     })
                                             )
                                                TaraUpdateDto taraUpdateDto) throws  TaraNotFoundException {
        return ResponseEntity.ok(taraService.updateTara(id, taraUpdateDto));
    }

}
