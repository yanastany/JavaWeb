package com.example.hotelManagement.controllers;

import com.example.hotelManagement.dto.CameraRequest;
import com.example.hotelManagement.exception.CameraNotFoundException;
import com.example.hotelManagement.mapper.CameraMapper;
import com.example.hotelManagement.model.Camera;
import com.example.hotelManagement.services.CameraService;
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
@RequestMapping("/camera")
@Tag(name = "Camera",description = "Endpoint manage Camera")
public class CameraController {
    CameraService cameraService;
    CameraMapper cameraMapper;

    public CameraController(CameraService cameraService, CameraMapper cameraMapper) {
        this.cameraService = cameraService;
        this.cameraMapper = cameraMapper;
    }


    @GetMapping(path = "/asc",produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Afisarea cameraurilor in ordine alfabetica",
            summary = "Afisare camera alfabetic",
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
    public ResponseEntity<List<Camera>> GetcameraAscNumar(){
        return ResponseEntity.ok(cameraService.getCameraAscNumar());
    }

    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE })
    @Operation(description = "Creare camera",
            summary = "Creare camera nou   ",
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
    public ResponseEntity<Camera> createCarte(@Valid
                                             @RequestBody
                                             @Parameter(description = "MyDto")
                                             @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                                     content = @Content(examples = {
//                                                             @ExampleObject(name = "camera", value = "{\"nume_camera\":\"Sheraton\",\"adresa\":\"Blv Iuliu Maniu 5\",\"id\":1}")
                                                             @ExampleObject(name = "camera", value = "{\"numar\":\"206\",\"hotel\":{\"id\":1}}")




                                                     }
                                                     ))
                                             CameraRequest cameraRequest){
        Camera camera = cameraService.saveCamera(cameraMapper.cameraRequest(cameraRequest));
        return ResponseEntity.created(URI.create("/camera/" + camera.getId()))
                .body(camera);
    }
    @DeleteMapping(path = "/{id}")
    @Operation(description = "Stergerea camerei cu id dat",
            summary = "Stergerea unei camere cu id dat",
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
    public void deleteCamera(@PathVariable
                            @Parameter(name = "id",description = "Codul camerei pe care doriti sa il stergeti",example = "1",required = true)
                            Long id) throws CameraNotFoundException {
        cameraService.deleteById(id);
    }
}
