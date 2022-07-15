package book.chapter2.discountPolicy;

import book.chapter2.Money;
import book.chapter2.Screening;
import book.chapter2.discountCondition.DiscountCondition;

public class PercentDiscountPolicy extends DiscountPolicy{
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
