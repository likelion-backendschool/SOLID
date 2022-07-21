package codespitz.chapter2.discount;


import codespitz.chapter2.Money;
import codespitz.chapter2.Screening;

public class SequenceAmountDiscount extends AmountDiscount{
    private final int sequence;

    public SequenceAmountDiscount(Money amount, int sequence) {
        super(amount);
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening, int audienceCount) {
        return screening.sequence == sequence;
    }
}
