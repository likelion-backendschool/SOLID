package main.java.me.doxxx.code;

import java.util.HashSet;
import java.util.Set;

abstract class DisCountPolicy {

    private Set<DiscountCondition> conditions = new HashSet<>();

    public void addCondition(DiscountCondition condition) {
        conditions.add(condition);
    }

    // 선택이 아니다.
    public void copyCondition(DisCountPolicy policy) {
        policy.conditions.addAll(conditions);
    }

    public Money calculateFee(Screening screening, int count, Money fee) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening, count)) {
                return calculateFee(fee);
            }
        }
        return fee;
    }

    // hook
    protected abstract Money calculateFee(Money fee);
}
