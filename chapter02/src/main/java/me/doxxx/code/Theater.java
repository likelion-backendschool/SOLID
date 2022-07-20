package main.java.me.doxxx.code;

import java.util.*;

class Theater {

    public static final Set<Screening> EMPTY = new HashSet<>();
    private final Set<TicketOffice> ticketOffices = new HashSet<>();
    private final Map<Movie, Set<Screening>> movies = new HashMap<>();
    private Money amount;

    public Theater(Money amount) {
        this.amount = amount;
    }

    public boolean addMovie(Movie movie) {
        if (movies.containsKey(movie)) {
            return false;
        }
        movies.put(movie, new HashSet<>());
        return true;
    }

    public boolean addScreening(Movie movie, Screening screening) {
        if (!movies.containsKey(movie)) {
            return false;
        }
        movies.get(movie).add(screening);
        return true;
    }

    public boolean contractTicketOffice(TicketOffice ticketOffice, Double rate) {
        if (!ticketOffice.contract(this, rate)) {
            return false;
        }
        ticketOffices.add(ticketOffice);
        return true;
    }

    public boolean cancelTicketOffice(TicketOffice ticketOffice) {
        if (!ticketOffices.contains(ticketOffice) || !ticketOffice.cancel(this)) {
            return false;
        }
        ticketOffices.remove(ticketOffice);
        return true;
    }

    // 값 객체. 포인터가 변경됨 -> this.amount 은닉. 외부 노출 금지
    // this.amount.amount 만 노출
    public void plusAmount(Money money) {
        this.amount = this.amount.plus(money);
    }

    Set<Screening> getScreening(Movie movie) {
        if (!movies.containsKey(movie) || movies.get(movie).size() == 0) {
            return EMPTY;
        }
        return movies.get(movie);
    }

    boolean isValidScreening(Movie movie, Screening screening) {
        return movies.containsKey(movie) && movies.get(movie).contains(screening);
    }

    public boolean enter(Customer customer, int count) {
        Reservation reservation = customer.reservation;
        return reservation != Reservation.NONE &&
            reservation.theater == this &&
            isValidScreening(reservation.movie, reservation.screening) &&
            reservation.count == count;
    }

    // public이 아닌 이유?
    Reservation reserve(Movie movie, Screening screening, int count) {
        if (!isValidScreening(movie, screening) || !screening.hasSeat(count)) {
            return Reservation.NONE;
        }
        screening.reserveSeat(count);
        return new Reservation(this, movie, screening, count);
    }
}