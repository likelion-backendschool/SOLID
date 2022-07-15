package book.chapter2.discountPolicy;

import book.chapter2.Money;
import book.chapter2.Screening;
import book.chapter2.discountCondition.DiscountCondition;

public class AmountDiscountPolicy extends DiscountPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
