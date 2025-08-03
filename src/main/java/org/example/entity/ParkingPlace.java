package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "parking_places")
public final class ParkingPlace {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Getter
    @Setter
    private boolean status;

    @Getter
    private int parkingNumber;

    @Getter
    private int numberOfFlour;

    @Getter
    private int price;

    @Getter
    @Setter
    private Integer newPrice;

    @Getter
    @FutureOrPresent(message = "Datum nesmí být do minulosti")
    private LocalDate dateOfArrival;

    @Getter
    @FutureOrPresent(message = "Datum nesmí být do minulosti")
    private LocalDate dateOfDeparture;

    public ParkingPlace() {

    }

    @ManyToOne
    @JoinColumn(name = "person_id")
    private ParkingPerson reservedBy;

    public ParkingPerson getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(ParkingPerson reservedBy) {
        this.reservedBy = reservedBy;
    }


    public ParkingPlace(boolean status, int parkingNumber, int numberOfFlour, int price, Integer newPrice,  LocalDate dateOfArrival, LocalDate dateOfDeparture) {
        this.status = status;
        this.parkingNumber = parkingNumber;
        this.numberOfFlour = numberOfFlour;
        this.price = price;
        this.newPrice = newPrice;
        this.dateOfArrival = dateOfArrival;
        this.dateOfDeparture = dateOfDeparture;
    }

    public ParkingPlace(LocalDate dateOfArrival, LocalDate dateOfDeparture) {
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

}
