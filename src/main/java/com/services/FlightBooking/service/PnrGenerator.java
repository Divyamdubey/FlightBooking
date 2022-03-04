package com.services.FlightBooking.service;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class PnrGenerator {

    public String getPnr() {
        StringBuilder pnr= new StringBuilder("");
        Random random = new Random();
        for (int i=1;i<=3;i++) {
            char code = (char)(65+random.nextInt( 90-65 + 1));
            pnr.append(code);
        }
        for (int i=1;i<=3;i++) {
            int code = (random.nextInt(9 - 1 + 1));
            pnr.append(code);
        }
        return pnr.toString();
    }



}
