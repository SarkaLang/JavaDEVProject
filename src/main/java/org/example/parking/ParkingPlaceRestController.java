package org.example.parking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.entity.ParkingPlace;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.entity.ParkingPlace;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/parking-places")
@RequiredArgsConstructor
public class ParkingPlaceRestController {

    private final ParkingService service;

    @GetMapping
    public List<ParkingPlace> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ParkingPlace getById(@PathVariable int id) {
        return service.getParkingPlaceByIndex(id);
    }
}
