package com.bc.lottery.entity;

/**
 * Created by luis on 2017/4/13.
 */

public interface LotteryType<E extends Enum<E>> {

    static LotteryType parseType(long lotteryId, long playId) {
        switch ((int) lotteryId) {
            case 1:
                return ShishicaiType.parse(playId);
            case 2:
            case 12:
            case 14:
            case 102:
                return ShishicaiDoubleType.parse(playId);
            case 3:
                return Lottery11x5Type.parse(playId);
            case 4:
            case 16:
            case 18:
            case 104:
                return Lottery11x5DoubleType.parse(playId);
            case 6:
            case 20:
            case 22:
            case 106:
                return LotteryKuai3DoubleType.parse(playId);
            case 7:
                return LotteryPK10Type.parse(playId);
            case 8:
            case 108:
                return LotteryPK10DoubleType.parse(playId);
            // 六合彩
            case 10:
                return LotteryMark6DoubleType.parse(playId);
            default:
                return ShishicaiType.parse(playId);
        }
    }

    long value();

    String desc();
}
