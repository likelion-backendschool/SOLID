package codespitz.chapter2.discount;

// enum 대신 씀
public interface DiscountPolicy {
    interface AMOUNT extends DiscountPolicy{}
    interface PERCENT extends DiscountPolicy{}
    interface COUNT extends DiscountPolicy{}
    interface NONE extends DiscountPolicy{}
}
