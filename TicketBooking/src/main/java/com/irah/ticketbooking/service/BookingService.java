package com.irah.ticketbooking.service;

import com.irah.ticketbooking.model.Passenger;
import com.irah.ticketbooking.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    Ticket bookTicket(Passenger passenger);

    Ticket getTicket(Integer ticketNumber);
}
