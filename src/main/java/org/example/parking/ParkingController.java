package org.example.parking;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.dto.ParkingReservationRequest;
import org.example.entity.ParkingPerson;
import org.example.entity.ParkingPlace;
import org.example.person.PersonService;
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
    private final PersonService personService;

    @GetMapping("/")
    public String index(@ModelAttribute ParkingPlace parkingPlace, Model model) {

        LocalDate dateOfArrival = parkingPlace.getDateOfArrival() != null ? parkingPlace.getDateOfArrival() : LocalDate.now();
        LocalDate dateOfDeparture = parkingPlace.getDateOfDeparture() != null ? parkingPlace.getDateOfDeparture() : LocalDate.now();
        model.addAttribute("dateOfArrival", dateOfArrival.toString());
        model.addAttribute("dateOfDeparture", dateOfDeparture.toString());
        boolean hasError = false;

        if (dateOfArrival.isBefore(LocalDate.now())) {
             model.addAttribute("arrivalError", "Datum příjezdu nesmí být do minulosti");
             hasError = true;
        }

        if (dateOfDeparture.isBefore(dateOfArrival)) {
            model.addAttribute("departureError", "Datum odjezdu nesmí být do minulosti");
            hasError = true;
        }

        return "index";
    }

    @GetMapping("/find")
    public String find(@ModelAttribute ParkingPlace parkingPlace, Model model) {

        model.addAttribute("dateOfArrival", parkingPlace.getDateOfArrival());
        model.addAttribute("dateOfDeparture", parkingPlace.getDateOfDeparture());
        boolean hasError = false;

        long numberOfDays = ChronoUnit.DAYS.between(parkingPlace.getDateOfArrival(), parkingPlace.getDateOfDeparture());
        model.addAttribute("parkingDate", numberOfDays);

        if(parkingPlace.getDateOfArrival().isEqual(parkingPlace.getDateOfDeparture())) {
            model.addAttribute("numberOfDaysError", "Počet dnů musí být větší než nula");
            hasError = true;
        }

        if (numberOfDays > 0) {
            model.addAttribute("parkingPlace", service.calculateNewPrice(numberOfDays));
        }

        return "index";
    }


    @GetMapping("/{id}")
    public String placeID(@Valid @ModelAttribute ParkingReservationRequest request,@PathVariable int id, BindingResult bindingResult, Model model) {

        ParkingPlace parkingPlace = service.getParkingPlaceByIndex(id);

        long numberOfDays = ChronoUnit.DAYS.between(
                request.getDateOfArrival(),
                request.getDateOfDeparture()
        );

        if (bindingResult.hasErrors()) {
            return model.addAttribute("index", request).toString();
        }

        model.addAttribute("parkingPlace", parkingPlace);
        model.addAttribute("parkingPrice", service.calculateNewPrice(numberOfDays));
        model.addAttribute("parkingDate", numberOfDays);
        model.addAttribute("dateOfArrival", request.getDateOfArrival());
        model.addAttribute("dateOfDeparture", request.getDateOfDeparture());
        model.addAttribute("numberOfFlour", request.getNumberOfFlour());
        model.addAttribute("parkingNumber", request.getParkingNumber());

        return "placeID";
    }

    @PutMapping("/save")
    public String saveParkingPlace(
            @Valid  @ModelAttribute ParkingReservationRequest request, BindingResult bindingResult, Model model ) {

       if (bindingResult.hasErrors()) {
           return model.addAttribute("parkingReservationRequest", request).toString();
       }

        int cleanPrice = Integer.parseInt(request.getNewPrice().replaceAll("\\s+", ""));
        ParkingPlace updateParkingPlace = service.findById(request.getId()).orElseThrow();
        updateParkingPlace.setStatus(false);
        updateParkingPlace.setNewPrice(cleanPrice);
        updateParkingPlace.setDateOfDeparture(request.getDateOfDeparture());
        updateParkingPlace.setDateOfArrival(request.getDateOfArrival());

        ParkingPerson person = new ParkingPerson();
        person.setFirstName(request.getFirstName());
        person.setEmail(request.getEmail());
        person.setSurname(request.getSurname());
        person.setPhoneNumber(request.getPhoneNumber());
        person.setLicensePlate(request.getLicensePlate());
        person.setMarketingConsent(request.isMarketingConsent());
        person.setTermsConditions(request.isTermsConditions());

       updateParkingPlace.setReservedBy(person);
       personService.save(person);
       service.save(updateParkingPlace);
    
        return "placeReservation";
    }

}
