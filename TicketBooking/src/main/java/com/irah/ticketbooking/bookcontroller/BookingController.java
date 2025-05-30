package com.irah.ticketbooking.bookcontroller;

import com.irah.ticketbooking.model.Passenger;
import com.irah.ticketbooking.model.Ticket;
import com.irah.ticketbooking.serviceimpl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

    @Autowired
    private BookingServiceImpl impl;

    @PostMapping(value = "/book",
            consumes = {"application/json"}
    )
    public ResponseEntity<Ticket> bookTicket(@RequestBody Passenger passenger) {
        return new ResponseEntity<>(impl.bookTicket(passenger), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-ticket/{tno}",
            produces = {"application/json"}
    )
    public ResponseEntity<Ticket> getTicket(@PathVariable("tno") Integer ticketNumber) {
        return new ResponseEntity<>(impl.getTicket(ticketNumber), HttpStatus.OK);
    }
}
