package book.chapter2.discountPolicy;

import book.chapter2.Money;
import book.chapter2.Screening;

public class NoneDiscountPolicy extends DiscountPolicy{
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
