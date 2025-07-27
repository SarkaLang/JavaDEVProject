package org.example.parking;

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

       model.addAttribute("parkingPrice", service.calculateNewPrice(numberOfDays));
        model.addAttribute("dateOfArrival", dateOfArrival);
        model.addAttribute("dateOfDeparture", dateOfDeparture);
        model.addAttribute("numberOfFlour", numberOfFlour);
        model.addAttribute("parkingNumber", parkingNumber);
        model.addAttribute("parkingPlace", parkingPlace);

        return "placeID";
    }

    @PutMapping("/{id}")
    public String form(
        Model model,  ParkingPlace parkingPlace,
        BindingResult bindingResult,
        @RequestParam(value = "dateOfArrival", required = false) String dateOfArrival,
        @RequestParam(value = "dateOfDeparture", required = false) String dateOfDeparture) {

     /*   if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("placeID");
            model.addObject("parkingPlace", parkingPlace);
            model.addObject("dateOfArrival", dateOfArrival);
            model.addObject("dateOfDeparture", dateOfDeparture);
            return model;
        }*/
    
        return "placeReservation";
    }
}
