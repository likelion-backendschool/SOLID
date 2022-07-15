package codespitz.chapter1_2;

public class TicketSeller {
    private TicketOffice ticketOffice;
    public void setTicketOffice(TicketOffice ticketOffice){
        this.ticketOffice = ticketOffice;
    }
    // audience 와 ticketOffice 사이에 방파제 역할 seller
    // 트랜잭션은 누가 주체인지, 무슨 책임을 가지고 있는지
    public Ticket getTicket(Audience audience){
        // 을은 audience, 트랜잭션은 관객이 원할때 수행됨
        Ticket ticket = Ticket.EMPTY;
        if(audience.getInvitation() != Invitation.EMPTY){
            ticket = ticketOffice.getTicketWithNoFee();
            if(ticket != Ticket.EMPTY) audience.removeInvitation();
        }else if(audience.hasAmount(ticketOffice.getTicketPrice())){
            ticket = ticketOffice.getTicketWithFee();
            if(ticket != Ticket.EMPTY) audience.minusAmount(ticketOffice.getTicketPrice());
        }
        return ticket;
    }
}
