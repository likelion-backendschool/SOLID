package main.java.me.doxxx.code;

import java.util.*;
import java.time.Duration;

// Policy 이면서 Condition인 AmountDiscount, PercentDiscount, CountDiscount, NoneDiscount 을 가질 수 있다.
class Movie<T extends DiscountPolicy & DiscountCondition> {

    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final Set<T> discountConditions = new HashSet<>(); // if 의 조건을 의미한다.

    // 제네릭은 if를 대체하는 방법중 하나이다.
    public Movie(String title, Duration runningTIme, Money fee, T... conditions) {
        this.title = title;
        this.runningTime = runningTIme;
        this.fee = fee;
        // List는 값 컨텍스트를 쓰고 있는 증거이다.
        // 객체 컨텍스트를 쓰면 Set 쓴다.
        this.discountConditions.addAll(Arrays.asList(conditions));
    }

    public Money calculateFee(Screening screening, int audienceCount) {
        for (T condition : discountConditions) {
            if (condition.isSatisfiedBy(screening, audienceCount)) {
                return condition.calculateFee(fee).multi((double) audienceCount);
            }
        }
        return fee.multi((double) audienceCount);
    }
}