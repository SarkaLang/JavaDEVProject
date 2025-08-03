package org.example.dto;

import lombok.Getter;

import java.time.LocalDate;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(boolean termsConditions) {
        this.termsConditions = termsConditions;
    }

    public boolean isMarketingConsent() {
        return marketingConsent;
    }

    public void setMarketingConsent(boolean marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

    public long getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public LocalDate getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(LocalDate dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfReturn;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfReturn = dateOfDeparture;
    }
}
