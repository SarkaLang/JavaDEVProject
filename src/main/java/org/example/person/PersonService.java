package org.example.person;

import lombok.RequiredArgsConstructor;
import org.example.entity.ParkingPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public ParkingPerson save(ParkingPerson parkingPerson) {
        return repository.save(parkingPerson);
    }

    public List<ParkingPerson> findAll() {
        return repository.findAll(); }

    public ParkingPerson findById(Long id) {
        return repository.findById(id).get(); }
}
