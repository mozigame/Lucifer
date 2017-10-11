package com.bc.lottery.entity;

/**
 * Created by luis on 2017/4/13.
 */

public interface LotteryType<E extends Enum<E>> {

    static LotteryType parseType(long lotteryId, long playId) {

        switch (String.valueOf(lotteryId)) {
            case 1 + "":
                return ShishicaiType.parse(playId);
            case 2 + "":
                return ShishicaiDoubleType.parse(playId);
            default:
                return ShishicaiType.parse(playId);
        }
    }

    long value();

    String desc();
}
