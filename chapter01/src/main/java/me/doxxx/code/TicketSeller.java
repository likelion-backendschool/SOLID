package io.doxxx.code;

// TicketSeller 는 Audience와의 비즈니스 로직을 알아야한다.
// 변동 가능성이 높다.
public class TicketSeller {

    private TicketOffice ticketOffice;

    public void setTicketOffice(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    // Transaction이 성립한다.
    // Audience가 표를 원할 때 거래가 성립한다.
    public Ticket getTicket(Audience audience) {
        Ticket ticket = Ticket.EMPTY;
        // 초대권이 있는지 확인한다.
        if (audience.getInvitation() != Invitation.EMPTY) {
            ticket = ticketOffice.getTicketWithNoFee();
            // not empty이면 거래를 진행한다.
            if (ticket != Ticket.EMPTY) {
                // 초대권 파기 -> 메모리 해지
                // 누가 주체인지, 객체인지 알아야함
                audience.removeInvitation();
            }
        } else if (audience.hasAmount(ticketOffice.getTicketPrice())) {
            ticket = ticketOffice.getTicketWithFee();
            if (ticket != Ticket.EMPTY) {
                audience.minusAmount(ticketOffice.getTicketPrice());
            }
        }
        return ticket;
    }
}