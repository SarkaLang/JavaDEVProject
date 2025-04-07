package org.example.entity;

import jakarta.validation.constraints.*;

public final class ParkingPerson {

    @NotBlank(message = "Jméno je povinné.")
    @Size(max=64)
    private String name;

    @NotBlank(message = "Příjmení je povinné.")
    @Size(max=64)
    private String surname;

    @NotBlank(message = "E-mail je povinný.")
    @Email(message = "E-mail musí mít platný formát.")
    private String email;

    @NotBlank(message = "Telefonní číslo je povinné.")
    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Telefonní číslo musí mít 9 až 15 číslic a může začínat znakem +.")
    private int phoneNumber;

    @NotBlank(message = "SPZ je povinná.")
    private String licensePlate;

    @AssertTrue(message = "Chybí souhlas s všeobecnými obchodbími podmínkami.")
    private boolean termsConditions;


    private boolean marketingConsent;

    public ParkingPerson() {}

    public ParkingPerson(String surname, String name, String email, int phoneNumber, String licensePlate, boolean termsConditions, boolean marketingConsent) {
        this.surname = surname;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licensePlate = licensePlate;
        this.termsConditions = termsConditions;
        this.marketingConsent = marketingConsent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
}
