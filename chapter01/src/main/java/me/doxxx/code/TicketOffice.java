package io.doxxx.code;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

    // Theater에 별로 관심이 없음
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    // 자본
    public TicketOffice(Long amount) {
        this.amount = amount;
    }

    // Theater 에서 Ticket을 받아옴
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    // 돈을 받고 티켓을 주는 경우
    // Ticket이 없으면 EMPTY
    // Ticket이 있으면 Ticket의 fee만큼 amout 추가 있는 Ticket을 반환
    public Ticket getTicketWithFee() {
        if (tickets.size() == 0) {
            return Ticket.EMPTY;
        } else {
            Ticket ticket = tickets.remove(0);
            amount += ticket.getFee();
            return ticket;
        }
    }

    // TicketOffice는 Invitation의 존재를 모름, VIP, 연간회원권 등 여러가지로 확장 가능성
    // Ticket이 없으면 EMPTY
    // 티켓이 있으면 amount는 변함없고 Ticket을 반환
    public Ticket getTicketWithNoFee() {
        if (tickets.size() == 0) {
            return Ticket.EMPTY;
        } else {
            return tickets.remove(0);
        }
    }

    // Theater 에서 티켓 가격을 받아옴
    // 단방향 의존성
    // 갖고 있는 Ticket을 통해서 Theater 에서 가격을 받아옴
    public Long getTicketPrice() {
        if (tickets.size() == 0) {
            return 0L;
        } else {
            return tickets.get(0).getFee();
        }
    }
}