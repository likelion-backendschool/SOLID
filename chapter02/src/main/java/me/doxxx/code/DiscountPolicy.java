package main.java.me.doxxx.code;

interface DiscountPolicy {

    // enum으로 하고 싶지만 자바에서는 enum은 타입이 될 수 없다.
    // interface로 정의한 모습.
    interface AMOUNT extends DiscountPolicy {

    }

    interface PERCENT extends DiscountPolicy {

    }

    interface COUNT extends DiscountPolicy {

    }

    interface NONE extends DiscountPolicy {

    }
}