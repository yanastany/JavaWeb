package com.example.hotelManagement.services;

import com.example.hotelManagement.exception.CameraNotFoundException;
import com.example.hotelManagement.model.Camera;
import com.example.hotelManagement.repositories.CameraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CameraServiceImpl implements CameraService {
    private final CameraRepository cameraRepository;

    public CameraServiceImpl(CameraRepository cameraRepository) {
        this.cameraRepository = cameraRepository;
    }

    public Camera saveCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    @Override
    public Camera updateCamera(Long id, Camera camera) {
        return null;
    }

    @Override
    public List<Camera> getCameraAscNumar() {
        return cameraRepository.findAllByOrderByNumarAsc();
    }

    @Override
    public List<Camera> getcameraDescNumar() {
        return null;
    }

    public List<Camera> getCameraAscNume(){
        return cameraRepository.findAllByOrderByNumarAsc();
    }
    public void deleteById(Long id) throws CameraNotFoundException {
        Optional<Camera> camera = cameraRepository.findById(id);
        if(camera.isPresent()){
            cameraRepository.deleteById(id);
        }else
        {
            throw new CameraNotFoundException(id);
        }
    }

    public List<Camera> getAllCamera() {
        return cameraRepository.findAll();
    }
}
