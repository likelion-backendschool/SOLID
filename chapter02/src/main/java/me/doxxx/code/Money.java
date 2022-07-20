package main.java.me.doxxx.code;

// 값 객체: 불변 객체, 값이 변화하면 새로운 객체를 리턴한다.
class Money {

    public static Money of(Double amount) {
        return new Money(amount);
    }

    // 필드가 final 이어야함
    private final Double amount;

    Money(Double amount) {
        this.amount = amount;
    }

    // 모든 메서드들이 새로운 객체를 리턴함
    public Money minus(Money money) {
        return new Money(this.amount > money.amount ? this.amount - money.amount : 0.0);
    }

    // 객체 컨텍스트에서 하나라도 값 컨텍스트를 사용하게되면 여파를 미침
    public Money multi(Double times) {
        return new Money(this.amount * times);
    }

    public Money plus(Money money) {
        return new Money(this.amount + money.amount);
    }

    // 내부 데이터는 은닉, API로만 접근 가능
    // 동시성 문제에서 자유롭다.
    public boolean greaterThen(Money money) {
        return this.amount >= money.amount;
    }
}