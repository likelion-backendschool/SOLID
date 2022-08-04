package main.java.me.doxxx.code;

public class PercentPolicy extends DisCountPolicy {

    private final Double percent;

    public PercentPolicy(Double percent) {
        this.percent = percent;
    }

    @Override
    protected Money calculateFee(Money fee) {
        return fee.minus(fee.multi(percent));
    }
}
