package com.bc.lottery.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luis on 2017/4/13.
 */

public interface LotteryType<E extends Enum<E>> {

    static LotteryType parseType(long lotteryId, long playId) {

        switch (String.valueOf(lotteryId)) {
            case 1 + "":
                return ShishicaiType.parse(playId);
            default:
                return ShishicaiType.parse(playId);
        }
    }

    long value();

    String desc();
}
