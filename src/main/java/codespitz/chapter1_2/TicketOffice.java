package codespitz.chapter1_2;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(long amount) {
        this.amount = amount;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }
    //seller 가 결정
    public Ticket getTicketWithFee(){
        if(tickets.size() == 0) return Ticket.EMPTY;
        else{
            Ticket ticket = tickets.remove(0);
            amount+= ticket.getFee();
            return ticket;
        }
    }
    public Ticket getTicketWithNoFee(){
        // 초대권에 대해 모르기 떄문에 -> 나중에 vip, 다른 할인 고려
        if(tickets.size() == 0) return Ticket.EMPTY;
        else return tickets.remove(0);
    }

    public Long getTicketPrice(){
        // theater를 모르기때문에 ticket에게 물어봐야 한다.
        if(tickets.size() == 0) return 0L;
        else return tickets.get(0).getFee();
    }
}
