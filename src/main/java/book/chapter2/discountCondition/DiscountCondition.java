package book.chapter2.discountCondition;

import book.chapter2.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
