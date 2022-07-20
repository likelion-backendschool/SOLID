package main.java.me.doxxx.code;

import java.time.LocalDateTime;

class Screening {

    private int seat;
    final int sequence;
    final LocalDateTime whenScreened;

    public Screening(int sequence, LocalDateTime when, int seat) {
        this.sequence = sequence;
        this.whenScreened = when;
        this.seat = seat;
    }

    // Trigger
    boolean hasSeat(int count) {
        return seat >= count;
    }

    // Action
    void reserveSeat(int count) {
        if (hasSeat(count)) {
            seat -= count;
        } else {
            throw new RuntimeException("no seat");
        }
    }
}