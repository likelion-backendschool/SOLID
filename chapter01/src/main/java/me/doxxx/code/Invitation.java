package io.doxxx.code;

public class Invitation {
    final static public Invitation EMPTY = new Invitation(null);
    final private Theater theater;
    // Ticket과 비슷하다.
    public Invitation(Theater theater){
        this.theater = theater;
    }
}