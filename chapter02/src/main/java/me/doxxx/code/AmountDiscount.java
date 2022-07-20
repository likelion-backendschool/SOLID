package main.java.me.doxxx.code;

// if 2개를 대체하는 객체하는 것.
// amount 계열의 discount
abstract class AmountDiscount implements DiscountPolicy.AMOUNT, DiscountCondition {

    private final Money amount;

    AmountDiscount(Money amount) {
        this.amount = amount;
    }

    // 부모에 따라 amount
    @Override
    public final Money calculateFee(Money fee) {
        return fee.minus(amount);
    }
}