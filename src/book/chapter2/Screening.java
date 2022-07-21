package book.chapter2;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened){
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime(){
        return whenScreened;
    }

    //순번의 일치여부 검사
    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public Money getMovieFee(){
        return movie.getFee();
    }

}
