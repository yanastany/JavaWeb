package com.example.hotelManagement.repositories;

import com.example.hotelManagement.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Long> {
    List<Camera> findAllByOrderByNumarAsc();

    List<Camera> findAllByOrderByNumarDesc();

    //    Optional<Camera> findByNrid(long id);
    @Query("SELECT h FROM Camera h WHERE h.id = :id")
    Optional<Camera> findByNrid(@Param("id") long id);

}