package org.example.parking;

import ch.qos.logback.classic.PatternLayout;
import org.example.entity.ParkingPlace;
import org.example.entity.ParkingDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    private final ParkingRepository repository;
    private final ParkingRepository parkingRepository;

    @Autowired
    public ParkingService(ParkingRepository repository, ParkingRepository parkingRepository) {
        this.repository = repository;
        this.parkingRepository = parkingRepository;
    }

    public List<ParkingPlace> findAll() {
        return repository.findAll();
    }

    public Optional<ParkingPlace> findById(Long id) {
        return repository.findById(id);
    }

    public ParkingPlace getParkingPlaceByIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index should be greater than 0");
        }

        Pageable pageable = PageRequest.of(index, 1, Sort.by("id"));
        List<ParkingPlace> results = parkingRepository.findAll(pageable).getContent();

        return results.stream()
                .findFirst().orElseThrow(() -> new IllegalArgumentException("index out of range"));
    }

    public long getNumberOfDays(String dateOfArrivalStr, String dateOfDepartureStr) {
        if (dateOfArrivalStr != null && dateOfDepartureStr != null) {
            LocalDate dateOfArrival = LocalDate.parse(dateOfArrivalStr);
            LocalDate dateOfDeparture = LocalDate.parse(dateOfDepartureStr);

            ParkingDate parkingDate = new ParkingDate(dateOfArrival, dateOfDeparture);
            return ChronoUnit.DAYS.between(parkingDate.getDateOfArrival(), parkingDate.getDateOfDeparture());
        } else {
            return 0;
        }
    }

    public int getPrice(ParkingPlace place, long numberOfDays) {
        return (int) (place.getPrice() * numberOfDays);
    }

}
