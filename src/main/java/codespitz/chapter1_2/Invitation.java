package codespitz.chapter1_2;

public class Invitation {
    // null을 사용하고 싶지 않다면 Empty를 생성해놓자
    final static public Invitation EMPTY = new Invitation(null);
    final private Theater theater;
    public Invitation(Theater theater) {
        this.theater = theater;
    }
}
