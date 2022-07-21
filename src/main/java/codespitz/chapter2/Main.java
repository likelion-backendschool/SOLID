package codespitz.chapter2;

import codespitz.chapter2.discount.AmountDiscount;
import codespitz.chapter2.discount.SequenceAmountDiscount;

import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Theater theater = new Theater(Money.of(100.0));
        Movie movie = new Movie<AmountDiscount>(
                "spiederman",
                Duration.ofMinutes(120L),
                Money.of(5000.0),
                new SequenceAmountDiscount(Money.of(1000.0), 1)
        );

        theater.addMovie(movie);
        for(int day =7;day<32;day++){
            for(int hour=10, seq=1;hour<24;hour+=3,seq++){
                theater.addScreening(
                        movie,
                        new Screening(
                                100,
                                seq,
                                LocalDateTime.of(2019,7,day,hour,00,00)

                        )
                );
            }
        }
        Customer customer = new Customer(Money.of(100.0));
        TicketOffice ticketOffice = new TicketOffice(Money.of(0.0));
        theater.contractTicketOffice(ticketOffice,10.0);
        TicketSeller seller = new TicketSeller();
        seller.setTicketOffice(ticketOffice);
        for(Screening screening: theater.getScreening(movie)){
            customer.reserve(seller, theater, movie,screening,2);
            boolean isOk = theater.enter(customer,2);
            System.out.println(isOk);
            break;
        }
    }
}
