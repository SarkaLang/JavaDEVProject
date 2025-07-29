package org.example.parking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.entity.ParkingPlace;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Validated
@Controller
@RequiredArgsConstructor
public class ParkingController {

    private final ParkingService service;

    @GetMapping("/")
    public String index(Model model, ParkingPlace parkingPlace) {

        LocalDate dateOfArrival = parkingPlace.getDateOfArrival() != null ? parkingPlace.getDateOfArrival() : LocalDate.now();
        LocalDate dateOfDeparture = parkingPlace.getDateOfDeparture() != null ? parkingPlace.getDateOfDeparture() : LocalDate.now();


        model.addAttribute("dateOfArrival", dateOfArrival.toString());
        model.addAttribute("dateOfDeparture", dateOfDeparture.toString());

        long numberOfDays = ChronoUnit.DAYS.between(dateOfArrival, dateOfDeparture);
        model.addAttribute("parkingDate", numberOfDays);

        if (numberOfDays > 0) {
            model.addAttribute("parkingPlace", service.calculateNewPrice(numberOfDays));
        }

        return "index";
    }


    @GetMapping("/{id}")
    public String placeID(Model model, String dateOfArrival, String dateOfDeparture, @PathVariable int id, @RequestParam (required = false) int numberOfFlour, @RequestParam (required = false) int parkingNumber, long numberOfDays) {

        ParkingPlace parkingPlace = service.getParkingPlaceByIndex(id);

        return getString(model, dateOfArrival, dateOfDeparture, numberOfFlour, parkingNumber, numberOfDays, parkingPlace);
    }

    @PutMapping("/{id}")
    public String form(
            @PathVariable int id, String dateOfArrival, String dateOfDeparture, @RequestParam (required = false) int numberOfFlour, @RequestParam (required = false) int parkingNumber, long numberOfDays, @Valid  @ModelAttribute ParkingPlace parkingPlace, BindingResult bindingResult, Model model ) {

       if (bindingResult.hasErrors()) {
           return getString(model, dateOfArrival, dateOfDeparture, numberOfFlour, parkingNumber, numberOfDays, parkingPlace);
       }
    
        return "placeReservation";
    }

    private String getString(@Valid Model model, String dateOfArrival, String dateOfDeparture, @RequestParam(required = false) int numberOfFlour, @RequestParam(required = false) int parkingNumber, long numberOfDays, ParkingPlace parkingPlace) {
        model.addAttribute("parkingPrice", service.calculateNewPrice(numberOfDays));
        model.addAttribute("dateOfArrival", dateOfArrival);
        model.addAttribute("dateOfDeparture", dateOfDeparture);
        model.addAttribute("numberOfFlour", numberOfFlour);
        model.addAttribute("parkingNumber", parkingNumber);
        model.addAttribute("parkingPlace", parkingPlace);
        model.addAttribute("parkingDate", numberOfDays);
        return "placeID";
    }
}
