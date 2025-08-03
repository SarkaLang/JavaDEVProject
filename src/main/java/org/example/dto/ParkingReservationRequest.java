package org.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ParkingReservationRequest {

    // parkingPlace
    @Getter
    private long id;

    @Getter
    private boolean status;

    private int parkingNumber;

    private int numberOfFlour;

    private int price;

    private String newPrice;

    private LocalDate dateOfArrival;

    private LocalDate dateOfReturn;
    // parkingPerson

    private String firstName;

    private String surname;

    private String email;

    private String phoneNumber;

    private String licensePlate;

    private boolean termsConditions;

    private boolean marketingConsent;


    public LocalDate getDateOfDeparture() {
        return dateOfReturn;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfReturn = dateOfDeparture;
    }
}