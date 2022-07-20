package main.java.me.doxxx.code;

import java.time.*;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater(Money.of(100.0));
        // Amount 계열
        Movie movie = new Movie<AmountDiscount>(
            "spiderMan", Duration.ofMinutes(120L), Money.of(5000.0),
            // if 문 2개를 대체한 상황 -> 컴파일러에 맡김
            new SequenceAmountDiscount(Money.of(1000.0), 1)
        );
        theater.addMovie(movie);

        LocalDateTime screeningTIme;
        int seats = 100;
        for (int day = 7; day < 32; day++) {
            for (int hour = 10, seq = 1; hour < 24; hour += 3, seq++) {
                screeningTIme = LocalDateTime.of(2022, 7, day, hour, 0, 0);
                theater.addScreening(movie, new Screening(seq, screeningTIme, seats));
            }
        }

        TicketOffice ticketOffice = new TicketOffice(Money.of(0.0));
        theater.contractTicketOffice(ticketOffice, 10.0);
        TicketSeller seller = new TicketSeller();
        seller.setTicketOffice(ticketOffice);

        Customer customer = new Customer(Money.of(20000.0));
        for (Screening screening : theater.getScreening(movie)) {
            customer.reserve(seller, theater, movie, screening, 2);
            boolean isOk = theater.enter(customer, 2);
            System.out.println(isOk);
            break;
        }
    }
}
