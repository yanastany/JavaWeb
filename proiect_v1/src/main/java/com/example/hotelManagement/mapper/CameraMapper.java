package com.example.hotelManagement.mapper;

import com.example.hotelManagement.dto.CameraRequest;
import com.example.hotelManagement.model.Camera;
import org.springframework.stereotype.Component;

@Component
public class CameraMapper {
    public Camera cameraRequest(CameraRequest cameraRequest){
        return new Camera(cameraRequest.getNumar(), cameraRequest.getHotel());
    }
}
