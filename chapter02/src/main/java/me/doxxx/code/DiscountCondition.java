package main.java.me.doxxx.code;

interface DiscountCondition {

    // 메서드를 한개만 갖도록 할 것
    boolean isSatisfiedBy(Screening screening, int audienceCount);

    Money calculateFee(Money fee);
}