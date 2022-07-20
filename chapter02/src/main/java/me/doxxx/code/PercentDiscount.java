package main.java.me.doxxx.code;

// if문 2개를 대체하는 것
// domain이 policy에 따라.
abstract class PercentDiscount implements DiscountPolicy.PERCENT, DiscountCondition {

    private final double percent;

    PercentDiscount(double percent) {
        this.percent = percent;
    }

    // 부모에 따라 percent
    @Override
    public final Money calculateFee(Money fee) {
        return fee.minus(fee.multi(percent));
    }
}