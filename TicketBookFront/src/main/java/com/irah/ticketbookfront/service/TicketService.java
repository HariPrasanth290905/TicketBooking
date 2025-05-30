package com.irah.ticketbookfront.service;

import com.irah.ticketbookfront.model.Passenger;
import com.irah.ticketbookfront.model.Ticket;

public interface TicketService {
    Ticket bookTicket(Passenger passenger);
    Ticket getTicket(int ticketNumber);
}
