package main.java.me.doxxx.code;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    Reservation reserve(Customer customer, Theater theater, Movie movie, Screening screening,
        int count) {
        Reservation reservation = Reservation.NONE;
        // movie의 변화 오염
        // 잘못된 코드임을 알아 차려야함
//        Money price = movie.calculateFee(screening, count);
        Money price = ticketOffice.calculateFee(movie, screening, count);
        if (customer.hasAmount(price)) {
            reservation = ticketOffice.reserve(theater, movie, screening, count);
            if (reservation != Reservation.NONE) {
                customer.minusAmount(price);
            }
        }
        return reservation;
    }
}
