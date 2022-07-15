package codespitz.chapter1_2;

public class Ticket {
    // 티켓이 널이거나 잘못됐을때 empty라는 인스턴스로 대체할 것이다.
    // 객체를 식별자로 식별해서 오는 파워
    final static public Ticket EMPTY = new Ticket(null);
    final private Theater theater;
    private boolean isEntered = false;
    public Ticket(Theater theater) {
        this.theater = theater;
    }
    public boolean isValid(Theater theater){
        // 자기 상태는 자기가 관리한다. maintain status
        if(isEntered || theater != this.theater || this == EMPTY){
            return false;
        }else{
            isEntered = true;
            return true;
        }
    }


    public Long getFee(){
        //동적으로 값의 변화가 반영되도록 간접 참조 수행
        return theater.getFee();
    }
}
