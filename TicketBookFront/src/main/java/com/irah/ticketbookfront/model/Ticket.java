package com.irah.ticketbookfront.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Ticket {
    private Integer ticketNumber;
    private Double ticketPrice;
    private String status;
    private String passengerName;
    private String from;
    private String to;
    private String doj;
    private String trainNumber;


}
