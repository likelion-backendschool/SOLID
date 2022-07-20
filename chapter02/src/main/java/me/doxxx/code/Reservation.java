package main.java.me.doxxx.code;

class Reservation {

    // null 대신 쓰는 거
    static final Reservation NONE = new Reservation(null, null, null, 0);
    final Theater theater;
    final Movie movie;
    final Screening screening;
    final int count;

    Reservation(Theater theater, Movie movie, Screening screening, int audienceCount) {
        this.theater = theater;
        this.movie = movie;
        this.screening = screening;
        this.count = audienceCount;
    }
}