package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "parking_person")
public final class ParkingPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Jméno je povinné.")
    @Size(max=64)
    private String firstName;

    @NotBlank(message = "Příjmení je povinné.")
    @Size(max=64)
    private String surname;

    @NotBlank(message = "E-mail je povinný.")
    @Email(message = "E-mail musí mít platný formát.")
    private String email;

    @NotBlank(message = "Telefonní číslo je povinné.")
    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Telefonní číslo musí mít 9 až 15 číslic a může začínat znakem +.")
    private String phoneNumber;

    @NotBlank(message = "SPZ je povinná.")
    private String licensePlate;

    @AssertTrue(message = "Chybí souhlas s všeobecnými obchodbími podmínkami.")
    private boolean termsConditions;


    private boolean marketingConsent;

    public ParkingPerson() {}

    public ParkingPerson(long id, String surname, String firstName, String email, String phoneNumber, String licensePlate, boolean termsConditions, boolean marketingConsent) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licensePlate = licensePlate;
        this.termsConditions = termsConditions;
        this.marketingConsent = marketingConsent;
    }

    public long getId() {return id;}

    public void setId(long id) { this.id = id; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
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
}
