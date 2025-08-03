package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "parking_person")
public final class ParkingPerson {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @NotBlank(message = "Jméno je povinné.")
    @Size(max=64)
    private String firstName;

    @Setter
    @NotBlank(message = "Příjmení je povinné.")
    @Size(max=64)
    private String surname;

    @Setter
    @NotBlank(message = "E-mail je povinný.")
    @Email(message = "E-mail musí mít platný formát.")
    private String email;

    @Setter
    @NotBlank(message = "Telefonní číslo je povinné.")
    @Pattern(regexp = "\\+?[0-9]{9,15}", message = "Telefonní číslo musí mít 9 až 15 číslic a může začínat znakem +.")
    private String phoneNumber;

    @Setter
    @NotBlank(message = "SPZ je povinná.")
    private String licensePlate;

    @Setter
    @AssertTrue(message = "Chybí souhlas s všeobecnými obchodbími podmínkami.")
    private boolean termsConditions;


    @Setter
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

    @OneToMany(mappedBy = "reservedBy")
    private List<ParkingPlace> reservedPlaces;
}
