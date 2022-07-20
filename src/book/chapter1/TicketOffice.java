package book.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private static List<Ticket> tickets = new ArrayList<>();

    public void sellTicketTo(Audience audience){
        plusAmount(audience.buy(getTicket()));
    }
    public TicketOffice(Long amount, Ticket tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));

    }

    public Ticket getTicket() {
        return tickets.remove(0);
    }

    public void minusAmount(Long amount){
        this.amount -= amount;
    }

    public void plusAmount(Long amount){
        this.amount += amount;
    }
}
