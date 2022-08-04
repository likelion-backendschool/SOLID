package main.java.me.doxxx.code;

public class NosalePolicy extends DisCountPolicy {

    @Override
    protected Money calculateFee(Money fee) {
        return fee;
    }
}
