package main.java.me.doxxx.code;

interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening, int audienceCount);
}
