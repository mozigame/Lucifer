package com.bc.lottery.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luis on 2017/4/13.
 */

public interface LotteryType <E extends Enum<E>>{

    static LotteryType parseType(int lotteryId, long playId) {
        switch (lotteryId) {
            case 1:
                return ShishicaiType.parse(playId);
            default:
                return ShishicaiType.parse(playId);
        }
    }

    long value();

    String desc();
}
