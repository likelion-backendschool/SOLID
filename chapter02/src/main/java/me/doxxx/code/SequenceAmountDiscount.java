package main.java.me.doxxx.code;

class SequenceAmountDiscount extends AmountDiscount {

    private final int sequence;

    SequenceAmountDiscount(Money amount, int sequence) {
        super(amount);
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}