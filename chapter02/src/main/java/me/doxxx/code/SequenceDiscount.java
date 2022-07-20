package main.java.me.doxxx.code;

abstract class SequenceDiscount implements DiscountCondition {

    private final int sequence;

    SequenceDiscount(int sequence) {
        this.sequence = sequence;
    }

    // sequence 기반의 discount, 분기가 amount, percent 등이 된다.
    @Override
    public final boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}