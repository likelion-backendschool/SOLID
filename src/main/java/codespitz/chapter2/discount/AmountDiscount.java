package codespitz.chapter2.discount;
import codespitz.chapter2.Money;

abstract public class AmountDiscount implements DiscountPolicy.AMOUNT,DiscountCondition {
    private final Money amount;

    public AmountDiscount(Money amount) {
        this.amount = amount;
    }
    @Override
    public final Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}
