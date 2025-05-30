package com.irah.ticketbookfront.impl;

import com.irah.ticketbookfront.model.Passenger;
import com.irah.ticketbookfront.model.Ticket;
import com.irah.ticketbookfront.service.TicketService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TicketServiceImpl implements TicketService {
    static String book_url = "http://35.154.235.190:8080/book";
    static String get_url = "http://35.154.235.190:8080/get-ticket/{ticketNumber}";

    @Override
    public Ticket bookTicket(Passenger passenger) {

        WebClient client = WebClient.create();

        return client.post()
                .uri(book_url)
                .bodyValue(passenger)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
    }

    @Override
    public Ticket getTicket(int ticketNumber) {
       WebClient client = WebClient.create();

        return client.get()
                .uri(get_url, ticketNumber)
                .retrieve()
                .bodyToMono(Ticket.class)
                .block();
    }
}
