package codespitz.chapter2;

import java.time.LocalDateTime;

public class Screening {
    private int seat;
    public final int sequence;
    public final LocalDateTime whenScreened;

    public Screening(int seat, int sequence, LocalDateTime whenScreened) {
        this.seat = seat;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }
    boolean hasSeat(int count){
        return seat >= count;
    }
    void reserveSeat(int count){
        if(hasSeat(count)) seat -= count;
        else throw new RuntimeException("no seat");
    }
}
