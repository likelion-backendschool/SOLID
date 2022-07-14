package io.doxxx.code;

class Audience {

    private Ticket ticket = Ticket.EMPTY;
    private Invitation invitation = Invitation.EMPTY;
    private Long amount;

    public Audience(Long amount) {
        this.amount = amount;
    }

    // seller를 찾아간다.
    public void buyTicket(TicketSeller seller) {
        ticket = seller.getTicket(this);
    }

    // 트랜 잭션의 스펙 -> 인터페이스로 뽑을 수 있음
    // 트랜잭션 컨디션으로 추출 가능
    public boolean hasAmount(Long amount) {
        return this.amount >= amount;
    }

    public boolean minusAmount(Long amount) {
        if (amount > this.amount) {
            return false;
        }
        this.amount -= amount;
        return true;
    }

    public Invitation getInvitation() {
        return invitation;
    }

    public void removeInvitation() {
        invitation = Invitation.EMPTY;
    }
    // 트랜잭션 컨디션 끝

    // Theater

    public Ticket getTicket() {
        return ticket;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }
}