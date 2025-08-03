package org.example.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.example.entity.ParkingPerson;


import java.util.List;

@RestController
@RequestMapping("/api/parking-person")
@RequiredArgsConstructor
public class PersonRestController {

    private final PersonService service;

    @GetMapping
    public List<ParkingPerson> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ParkingPerson getById(@PathVariable Long id) {
        return service.findById(id);
    }
}