package codespitz.chapter2.discount;


import codespitz.chapter2.Money;
import codespitz.chapter2.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening, int audienceCount);
    Money calculateFee(Money fee);
}
