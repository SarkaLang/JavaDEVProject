package org.example.parking;

import jakarta.validation.Valid;
import org.example.entity.ParkingDate;
import org.example.entity.ParkingPlace;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@Validated
@Controller
public class ParkingController {

    private final ParkingService service;

    public ParkingController(ParkingService service) {this.service = service;}

    @GetMapping("/")
    public ModelAndView mainPaige(@Valid @ModelAttribute ParkingDate parkingDate) {

        ModelAndView result = new ModelAndView("index");

        String dateOfArrival = parkingDate.getDateOfArrival() != null ? parkingDate.getDateOfArrival().toString() : String.valueOf(LocalDate.now());
        String dateOfDeparture = parkingDate.getDateOfDeparture() != null ? parkingDate.getDateOfDeparture().toString() : String.valueOf(LocalDate.now());

        result.addObject("dateOfArrival", dateOfArrival);
        result.addObject("dateOfDeparture", dateOfDeparture);

        long numberOfDays = service.getNumberOfDays(dateOfArrival, dateOfDeparture);
        result.addObject("parkingDate", numberOfDays);

        if (numberOfDays > 0) {

            List<ParkingPlace> parkingPlace = service.findAll().stream()
                    .peek(place -> place.setNewPrice(service.getPrice(place, numberOfDays)))
                    .toList();
            result.addObject("parkingPlace", parkingPlace);
        }

        return result;
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @GetMapping("/{id}")
    public ModelAndView parkingPlaceID(@PathVariable int id, @RequestParam(value = "dateOfArrival", required = false) String dateOfArrivalStr, @RequestParam(value = "dateOfDeparture", required = false) String dateOfDepartureStr) {
        ModelAndView detail =  new ModelAndView("placeID");
        ParkingPlace place = service.findById((long) id).orElse(null);
        if (place != null) {
            detail.addObject("placeID", place);
            detail.addObject("parkingPlace", place);
        } else {
            detail.addObject("placeID", place);
            detail.addObject("parkingPlace", place);
        }

        detail.addObject("dateOfArrival", dateOfArrivalStr);
        detail.addObject("dateOfDeparture", dateOfDepartureStr);
        return detail;
    }

    @PostMapping("/{id}")
    public ModelAndView form(
        @Valid @ModelAttribute ParkingPlace parkingPlace,
        BindingResult bindingResult,
        @RequestParam(value = "dateOfArrival", required = false) String dateOfArrival,
        @RequestParam(value = "dateOfDeparture", required = false) String dateOfDeparture) {
        if (bindingResult.hasErrors()) {
            ModelAndView model = new ModelAndView("placeID");
            model.addObject("parkingPlace", parkingPlace);
            model.addObject("dateOfArrival", dateOfArrival);
            model.addObject("dateOfDeparture", dateOfDeparture);
            return model;
        }
    
        return new ModelAndView("/placeReservation");
    }
}
