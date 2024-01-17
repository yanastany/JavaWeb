package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.AngajatiRequest;
import com.example.hotelManagement.exception.AngajatiNotFoundException;
import com.example.hotelManagement.mapper.AngajatiMapper;
import com.example.hotelManagement.model.Angajati;
import com.example.hotelManagement.services.AngajatiService;
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
@RequestMapping("/angajati")
@Tag(name = "Angajati",description = "Endpoint manage Angajati")
public class AngajatiController {
    AngajatiService angajatiService;
    AngajatiMapper angajatiMapper;

    public AngajatiController(AngajatiService angajatiService, AngajatiMapper angajatiMapper) {
        this.angajatiService = angajatiService;
        this.angajatiMapper = angajatiMapper;
    }


    @GetMapping(path = "/asc",produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Afisarea angajatiurilor in ordine alfabetica",
            summary = "Afisare angajati alfabetic",
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
    public ResponseEntity<List<Angajati>> GetangajatiAscNume(){
        return ResponseEntity.ok(angajatiService.getAngajatiAscNume());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare angajati",
            summary = "Creare angajati nou   ",
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
    public ResponseEntity<Angajati> createCarte(@Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
//                                                             @ExampleObject(name = "angajati", value = "{\"nume_angajati\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\",\"id\":1}")
                                                             @ExampleObject(name = "angajati", value = "{\"nume\":\"Stan\",\"prenume\":\"Ana\",\"salariu\":10000,\"hotel\":{\"id\":1}}")




                                                     }
                                                     ))
                                             AngajatiRequest angajatiRequest){
        Angajati angajati = angajatiService.saveAngajati(angajatiMapper.angajatiRequest(angajatiRequest));
        return ResponseEntity.created(URI.create("/angajati/" + angajati.getId()))
                .body(angajati);
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea angajati cu id dat",
            summary = "Stergerea unui angajat cu id dat",
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
    public void deleteAngajati(@PathVariable
                            @Parameter(name = "id",description = "Codul angajatului pe care doriti sa il stergeti",example = "1",required = true)
                            Long id) throws AngajatiNotFoundException {
        angajatiService.deleteById(id);
    }
}
