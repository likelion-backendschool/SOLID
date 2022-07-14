package io.doxxx.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Theater {

    final private List<TicketOffice> ticketOffices = new ArrayList<>();
    final private Long fee;

    // Theater가 fee를 알고 있는 유일한 녀석
    public Theater(Long fee) {
        this.fee = fee;
    }

    Long getFee() {
        return this.fee;
    }

    // 다수의 TicketOffice를 보유하고 있다. 온라인 오프라인 대행업체 등
    public void setTicketOffices(TicketOffice... ticketOffices) {
        this.ticketOffices.addAll(Arrays.asList(ticketOffices));
    }

    // 거래하고 있는 TicketOffice인지를 확인하고 Ticket을 발부
    public void setTicket(TicketOffice ticketOffice, Long num) {
        if (!ticketOffices.contains(ticketOffice)) {
            return;
        }
        while (num-- > 0) {
            // 가장 중요한 요소인 "어떤" Theater에서 발급했는지를 Theater에서만이 알 수 있다..
            ticketOffice.addTicket(new Ticket(this));
        }
    }

    // 고객과의 관계, Audience를 알아야 한다.
    public void setInvitation(Audience audience) {
        audience.setInvitation(new Invitation(this));
    }

    // 티켓을 받고, validation 해야함
    public boolean enter(Audience audience) {
        Ticket ticket = audience.getTicket();
        // 극장이라는 인스턴스를 받아와야함
        return ticket.isValid(this);
    }
}
