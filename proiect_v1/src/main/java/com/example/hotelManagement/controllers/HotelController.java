package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.HotelRequest;
import com.example.hotelManagement.dto.HotelUpdateDto;
import com.example.hotelManagement.exception.HotelNotFoundException;
import com.example.hotelManagement.mapper.HotelMapper;
import com.example.hotelManagement.model.Hotel;
import com.example.hotelManagement.services.Hotelservice;


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
@RequestMapping("/hotel")
@Tag(name = "Hotel",description = "Endpoint manage Hotel")
public class HotelController {
    Hotelservice hotelService;
    HotelMapper hotelMapper;

    public HotelController(Hotelservice hotelService, HotelMapper hotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
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
    public ResponseEntity<List<Hotel>> GethotelAscNume(){
        return ResponseEntity.ok(hotelService.gethotelAscNume());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare hotel",
            summary = "Creare hotel nou   ",
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
    public ResponseEntity<Hotel> createCarte(@Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
//                                                             @ExampleObject(name = "hotel", value = "{\"nume_hotel\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\",\"id\":1}")
                                                               @ExampleObject(name = "hotel", value = "{\"nume\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\"}")



                                                     }
                                                     ))
                                             HotelRequest hotelRequest){
        Hotel hotel = hotelService.saveHotel(hotelMapper.hotelRequest(hotelRequest));
        return ResponseEntity.created(URI.create("/hotel/" + hotel.getId()))
                .body(hotel);
    }

//    @PutMapping(path = "/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
//    @Operation(description = "Updatarea imprumutului cu un id dat - se poate modifica sau adauga data de returnare",
//            summary = "Updatarea unui imprumut cu un id dat",
//            responses = {
//                    @ApiResponse(
//                            description = "Success",
//                            responseCode = "200",
//                            content = @Content(examples = {
//                                    @ExampleObject(value = "{\"id\":1,\"nume\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\"")
//                            }
//                            )
//                    ),
//                    @ApiResponse(
//                            description = "Not Found",
//                            responseCode = "404",
//                            content = @Content(examples = {
//                                    @ExampleObject()
//                            }
//                            )
//                    ),
//                    @ApiResponse(
//                            description = "Field validation error",
//                            responseCode = "400",
//                            content = @Content(examples = {
//                                    @ExampleObject(value = "{\"nume\":\"Sheraton\"}")
//                            }
//                            )
//                    ),
//            })
//    public ResponseEntity<Hotel> updateHotel(@PathVariable
//                                                   @Parameter(name = "id",description = "Codul hotelului pe care doriti sa il modificati",example = "1",required = true)
//                                                   Long id,
//                                                   @Valid
//                                                   @RequestBody
//                                                   @Parameter(description = "MyDto")
//                                                   @io.swagger.v3.oas.annotations.parameters.RequestBody(
//                                                           content = @Content(examples = {
//                                                                   @ExampleObject(value = "{\"nume\":\"Sheraton\"}")
//                                                           }
//                                                           ))
//                                                 HotelUpdateDto imprumutUpdateDto) throws Exception, HotelNotFoundException {
//        return  ResponseEntity.ok(hotelService.updateHotel(id,imprumutUpdateDto));
//    }

    @PutMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Updatarea hotelului cu un id dat ",
            summary = "Updatarea unui hotel cu un id dat",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(examples = {
                                    @ExampleObject(value = "{\"id\":1,\"nume\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\"}")
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
                                    @ExampleObject(value = "{\"nume\":\"Sheraton\"}")
                            })
                    ),
            })
    public ResponseEntity<Hotel> updateHotel(@PathVariable
                                             @Parameter(name = "id", description = "Codul hotelului pe care doriti sa il modificati", example = "1", required = true)
                                             Long id,
                                             @Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
                                                             @ExampleObject(value = "{\"nume\":\"Sheraton\"}")
                                                     })
                                             )
                                             HotelUpdateDto hotelUpdateDto) throws Exception, HotelNotFoundException {
        return ResponseEntity.ok(hotelService.updateHotel(id, hotelUpdateDto));
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea hotelului cu id dat",
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
    public void deleteHotel(@PathVariable
                               @Parameter(name = "id",description = "Codul Hotel pe care doriti sa il stergeti",example = "1",required = true)
                               Long id) throws HotelNotFoundException {
        hotelService.deleteById(id);
    }

}
