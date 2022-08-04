package main.java.me.doxxx.code;

import java.time.Duration;

public class Movie {

    private final String title;
    private final Duration runningTime;
    private final Money fee;
    private final DisCountPolicy policy;

    public Movie(String title, Duration runningTime, Money fee, DisCountPolicy policy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.policy = policy;
    }

    // policy에 위임
    Money calculateFee(Screening screening, int count) {
        return policy.calculateFee(screening, count, fee);
    }
}
