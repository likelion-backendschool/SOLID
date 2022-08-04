package main.java.me.doxxx.code;

public class AmountPolicy extends DisCountPolicy {

    private final Money amount;

    public AmountPolicy(Money amount) {
        this.amount = amount;
    }

    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}
