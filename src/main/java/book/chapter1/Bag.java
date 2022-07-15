package book.chapter1;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;
    public Bag(long amount){
        this(null,amount);
    }
    public Bag(Invitation invitation,long amount){
        this.invitation = invitation;
        this.amount = amount;
    }
    private void setTicket(Ticket ticket){
        this.ticket = ticket;
    }
    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }

    public boolean hasInvitation(){
        return invitation != null;
    }
    private void minusAmount(Long amount){
        this.amount -= amount;
    }
    private void plusAmount(Long amount){
        this.amount += amount;
    }
}
