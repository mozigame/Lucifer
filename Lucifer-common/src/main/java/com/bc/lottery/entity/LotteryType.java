package com.bc.lottery.entity;

/**
 * Created by luis on 2017/4/13.
 */

public interface LotteryType<E extends Enum<E>> {

    static LotteryType parseType(long lotteryId, long playId) {
        int lotteryChange = (int) lotteryId;
        switch (lotteryChange) {
            case 1:
                return ShishicaiType.parse(playId);
            case 2:
            case 12:
            case 14:
                return ShishicaiDoubleType.parse(playId);
            case 3:
                return Lottery11x5Type.parse(playId);
            case 4:
            case 16:
            case 18:
                return Lottery11x5DoubleType.parse(playId);
            case 6:
            case 20:
            case 22:
                return LotteryKuai3DoubleType.parse(playId);
            case 7:
                return LotteryPK10Type.parse(playId);
            case 8:
                return LotteryPK10DoubleType.parse(playId);
            default:
                return ShishicaiType.parse(playId);
        }
    }

    long value();

    String desc();
}
