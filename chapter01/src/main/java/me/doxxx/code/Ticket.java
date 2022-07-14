package io.doxxx.code;

public class Ticket {

    final static public Ticket EMPTY = new Ticket(null);
    final private Theater theater;
    private boolean isEntered = false;

    // Theater의 정보를 알고 있는 녀석
    public Ticket(Theater theater) {
        this.theater = theater;
    }

    // isEntered 라는 숨겨진 항목 (Maintain of State) -> 본인만 알 수 있음
    // Theater validation
    // 티켓이 null이면 EMPTY
    // 객체를 식별자를 통해 식별하기 때문에 이런 코드를 작성한 것
    public boolean isValid(Theater theater) {
        if (isEntered || theater != this.theater || this == EMPTY) {
            return false;
        } else {
            isEntered = true;
            return true;
        }
    }

    // pointer to pointer to pointer
    // Ticket.getFee()  to theater to theater.getFee()
    public Long getFee() {
        return theater.getFee();
    }
}