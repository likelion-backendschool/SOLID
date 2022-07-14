package io.doxxx.code;

public class Main {

    public static void main(String[] args) {
        Theater theater = new Theater(100L);
        Audience audience1 = new Audience(0L);
        Audience audience2 = new Audience(50L);
        TicketOffice ticketOffice = new TicketOffice(0L);
        TicketSeller seller = new TicketSeller();

        theater.setTicketOffices(ticketOffice);
        theater.setTicket(ticketOffice, 10L);
        theater.setInvitation(audience1);

        seller.setTicketOffice(ticketOffice);

        audience1.buyTicket(seller);
        audience2.buyTicket(seller);

        boolean isOk1 = theater.enter(audience1);
        boolean isOk2 = theater.enter(audience2);

        System.out.println(isOk1); // true
        System.out.println(isOk2); // false
    }
}

/*
* 1. 도메인에 맞는 시나리오를 먼저 짜라 -> 객체지향은 클래스지향이 아니다
* 2. 시나리오에 맞는 클래스를 만들어라
* */