package com.irah.ticketbookfront.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Passenger {
    private String passengerName;
    private String from;
    private String to;
    private String doj;
    private String trainNumber;

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerName='" + passengerName + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", doj='" + doj + '\'' +
                ", trainNumber='" + trainNumber + '\'' +
                '}';
    }
}
