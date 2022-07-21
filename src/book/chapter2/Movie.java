package book.chapter2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration running;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration running, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.running = running;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        if (discountPolicy == null) return fee;
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}