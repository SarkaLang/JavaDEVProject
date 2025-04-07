package org.example.parking;

import org.example.entity.ParkingPlace;
import org.example.entity.ParkingDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ParkingService {

    private final ParkingRepository repository;

    public ParkingService(ParkingRepository repository) {
        this.repository = repository;
    }

    public List<ParkingPlace> findAll() {
        return repository.findAll();
    }

    public Optional<ParkingPlace> findById(Long id) {
        return repository.findById(id);
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
