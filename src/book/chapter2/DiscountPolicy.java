package book.chapter2;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
