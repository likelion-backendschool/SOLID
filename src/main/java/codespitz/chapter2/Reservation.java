package codespitz.chapter2;

public class Reservation {
    static final Reservation NONE = new Reservation(null,null,null,0);

    final Theater theater;
    final Movie movie;
    final Screening screening;
    final int count;

    public Reservation(Theater theater, Movie movie, Screening screening, int count) {
        this.theater = theater;
        this.movie = movie;
        this.screening = screening;
        this.count = count;
    }
}
