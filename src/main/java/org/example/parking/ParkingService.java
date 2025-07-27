package org.example.parking;

import lombok.RequiredArgsConstructor;
import org.example.entity.ParkingPlace;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ParkingService {

    private final ParkingRepository repository;

    public List<ParkingPlace> findAll() {
        return repository.findAll();
    }

    public Optional<ParkingPlace> findById(Long id) {
        return repository.findById(id);
    }

    public ParkingPlace save(ParkingPlace parkingPlace) { return repository.save(parkingPlace); }

    public ParkingPlace getParkingPlaceByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index should be greater than 0");
        }

        Pageable pageable = PageRequest.of(index, 1, Sort.by("id"));
        List<ParkingPlace> results = repository.findAll(pageable).getContent();

        return results.stream()
                .findFirst().orElseThrow(() -> new IllegalArgumentException("index out of range"));
    }


    public List<ParkingPlace> calculateNewPrice(long numberOfDays) {

        return repository.findAll().stream()
                .peek(place -> place.setNewPrice(getPrice(place, numberOfDays)))
                .toList();
    }

    public int getPrice(ParkingPlace place, long numberOfDays) {
        return (int) (place.getPrice() * numberOfDays);
    }

}
