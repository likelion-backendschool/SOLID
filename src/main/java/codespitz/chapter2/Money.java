package codespitz.chapter2;


import java.math.BigDecimal;

public class Money {
    public static Money of(double v) {return new Money(BigDecimal.valueOf(v));}
    private final BigDecimal amount;

    Money(BigDecimal amount){
        this.amount = amount;
    }


    public Money plus(Money amount) {
        return new Money(this.amount.add(amount.amount));
    }
    public Money minus(Money amount){
        return new Money(this.amount.subtract(amount.amount));
    }
    public Money multi(double percent){
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other){
        return amount.compareTo(other.amount) <0;
    }
    public boolean isGreaterThanOrEqual(Money other){
        return amount.compareTo(other.amount) >= 0;
    }
}
