package codespitz.chapter2.discount;

import codespitz.chapter2.Money;

abstract class PercentDiscount implements DiscountPolicy.PERCENT, DiscountCondition {
    private final double percent;

    public PercentDiscount(double percent) {
        this.percent = percent;
    }
    @Override
    public final Money calculateFee(Money fee) {
        return fee.minus(fee.multi(percent));
    }
}
