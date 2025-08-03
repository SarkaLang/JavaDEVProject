package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "parking_places")
public final class ParkingPlace {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private boolean status;

    private int parkingNumber;

    private int numberOfFlour;

    private int price;

    @Setter
    private Integer newPrice;

    @FutureOrPresent(message = "Datum nesmí být do minulosti")
    private LocalDate dateOfArrival;

    @FutureOrPresent(message = "Datum nesmí být do minulosti")
    private LocalDate dateOfDeparture;

    public ParkingPlace() {

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

    public boolean isStatus() {
        return status;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public int getNumberOfFlour() {
        return numberOfFlour;
    }

    public int getPrice() {
        return price;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public long getId() {
        return id;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

}
