package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(name = "parking_places")
public final class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean status;

    private int parkingNumber;

    private int numberOfFlour;

    private int price;

    private Integer newPrice;

    @FutureOrPresent(message = "Datum musí být dnešní nebo do budoucnosti")
    private LocalDate dateOfArrival;

    @FutureOrPresent(message = "Datum musí být dnešní nebo do budoucnosti")
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    public int getNumberOfFlour() {
        return numberOfFlour;
    }

    public void setNumberOfFlour(int numberOfFlour) {
        this.numberOfFlour = numberOfFlour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Integer newPrice) {
        this.newPrice = newPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
