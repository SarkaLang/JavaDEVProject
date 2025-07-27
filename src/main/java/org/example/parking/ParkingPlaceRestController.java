package org.example.parking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.entity.ParkingPlace;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping("/{id}")
    public ParkingPlace update(@Valid @RequestBody ParkingPlace parkingPlace) {
        parkingPlace.setId(parkingPlace.getId());
        return service.save(parkingPlace);
    }
}
