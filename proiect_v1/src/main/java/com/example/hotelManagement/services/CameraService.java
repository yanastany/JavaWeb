package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.CameraNotFoundException;
import com.example.hotelManagement.model.Camera;

import java.util.List;

public interface CameraService {
    Camera saveCamera(Camera camera);
    Camera updateCamera(Long id, Camera camera);
    List<Camera> getCameraAscNumar();
    List<Camera> getcameraDescNumar();
    void deleteById(Long id) throws CameraNotFoundException;
    List<Camera> getAllCamera();
}
