package com.irah.ticketbooking.serviceimpl;

import com.irah.ticketbooking.model.Passenger;
import com.irah.ticketbooking.model.Ticket;
import com.irah.ticketbooking.service.BookingService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BookingServiceImpl implements BookingService {
    Map<Integer, Ticket> ticket = new HashMap<>();

    @Override
    public Ticket bookTicket(Passenger passenger) {
        Ticket t = new Ticket();
        BeanUtils.copyProperties(passenger, t);
        t.setTicketPrice(1200.0);
        t.setTicketNumber(8789);
        t.setStatus("Booked");
        ticket.put(t.getTicketNumber(), t);
        return t;
    }

    @Override
    public Ticket getTicket(Integer ticketNumber) {
        return ticket.get(ticketNumber);
    }
}
