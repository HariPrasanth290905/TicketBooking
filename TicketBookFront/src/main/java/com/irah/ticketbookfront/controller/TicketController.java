package com.irah.ticketbookfront.controller;

import com.irah.ticketbookfront.impl.TicketServiceImpl;
import com.irah.ticketbookfront.model.Passenger;
import com.irah.ticketbookfront.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TicketController {

    @Autowired
    TicketServiceImpl ser;
    @Autowired
    private Passenger passenger;

    @GetMapping("/")
    String index() {
        return "index";
    }

    @GetMapping("/book-ticket")
    String bookPage(@ModelAttribute Passenger passenger, Model model) {
        model.addAttribute("passenger", new Passenger());
        return "bookticket";
    }

    @PostMapping("/book-ticket")
    String bookTicket(@ModelAttribute Passenger passenger, Model model) {
        ser.bookTicket(passenger);
        model.addAttribute("passenger", passenger);
        return "display";
    }
    @GetMapping("/get-ticket")
    String ticketPage(Model model) {
        model.addAttribute("ticket", new Ticket());
        return "getticket";
    }
    @PostMapping("/get-ticket")
    String getTicket(@RequestParam("ticketNumber") int ticketNumber, Model model) {
        Ticket ticket = ser.getTicket(ticketNumber);
        System.out.println("Ticket: "+ticket);
        model.addAttribute("ticket", ticket);
        return "getticket";
    }
}
