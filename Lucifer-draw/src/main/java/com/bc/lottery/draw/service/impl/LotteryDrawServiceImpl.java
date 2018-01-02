package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.draw.service.LotteryDrawHandle;
import com.bc.lottery.entity.*;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 2017/4/14.
 */

public class LotteryDrawServiceImpl implements LotteryDrawHandle {

    @Override
    public UserOrderPO getBoundsInfoOfLottery(String kj, UserOrderPO order) {

        List<UserOrderPO> lotteryOrderList = new ArrayList<>();
        lotteryOrderList.add(order);
        LotteryType lotteryType = LotteryType.parseType(order.getLotteryId(), order.getPlayId());

        if (lotteryType instanceof ShishicaiType) {
            // 传统时时彩
            return LotteryShishicaiDraw.getBoundsInfoOfShishicai(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof ShishicaiDoubleType) {
            // 双面盘时时彩
            return LotteryShishicaiDraw.getBoundsInfoOfShishicaiDouble(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof Lottery11x5Type) {
            // 传统盘11选5
            return Lottery11x5Draw.getBoundsInfoOfLottery11x5(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof Lottery11x5DoubleType) {
            // 双面盘11选5
            return Lottery11x5Draw.getBoundsInfoOfLottery11x5Double(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryKuai3Type) {
            // 传统盘快3
            return LotteryKuai3Draw.getBoundsInfoOfLotteryKuai3(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryKuai3DoubleType) {
            // 双面盘快3
            return LotteryKuai3Draw.getBoundsInfoOfLotteryKuai3Double(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryPK10Type) {
            // 传统盘PK10
            return LotteryPK10Draw.getBoundsInfoOfLotteryPK10(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryPK10DoubleType) {
            // 双面盘PK10
            return LotteryPK10Draw.getBoundsInfoOfLotteryPK10Double(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryMark6DoubleType) {
            // 双面盘六合彩
            return LotteryMark6Draw.getBoundsInfoOfLotteryMark6Double(lotteryType, kj, lotteryOrderList).get(0);
        }
        return order;
    }

    @Override
    public List<UserOrderPO> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        if (lotteryOrderList.size() == 0) {
            return null;
        }
        if (lotteryType instanceof ShishicaiType) {
            // 传统时时彩
            return LotteryShishicaiDraw.getBoundsInfoOfShishicai(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof ShishicaiDoubleType) {
            // 双面盘时时彩
            return LotteryShishicaiDraw.getBoundsInfoOfShishicaiDouble(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof Lottery11x5Type) {
            // 传统盘11选5
            return Lottery11x5Draw.getBoundsInfoOfLottery11x5(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof Lottery11x5DoubleType) {
            // 双面盘11选5
            return Lottery11x5Draw.getBoundsInfoOfLottery11x5Double(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryKuai3Type) {
            // 传统盘快3
            return LotteryKuai3Draw.getBoundsInfoOfLotteryKuai3(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryKuai3DoubleType) {
            // 双面盘快3
            return LotteryKuai3Draw.getBoundsInfoOfLotteryKuai3Double(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryPK10Type) {
            // 传统盘PK10
            return LotteryPK10Draw.getBoundsInfoOfLotteryPK10(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryPK10DoubleType) {
            // 双面盘PK10
            return LotteryPK10Draw.getBoundsInfoOfLotteryPK10Double(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryMark6DoubleType) {
            // 双面盘六合彩
            return LotteryMark6Draw.getBoundsInfoOfLotteryMark6Double(lotteryType, kj, lotteryOrderList);
        }
        return null;
    }

    @Override
    public List<Long> getLotteryBetPlayIds(long lotteryId, String str) {

        List<Long> resultList = new ArrayList<>();
        switch ((int) lotteryId) {
            case 2:
            case 12:
            case 14:
            case 102:
                return LotteryShishicaiDraw.getShishicaiDoubleBetPlayIds(str);
            case 4:
            case 16:
            case 18:
            case 104:
                return Lottery11x5Draw.getLottery11x5DoubleBetPlayIds(str);
            case 6:
            case 20:
            case 22:
            case 106:
                return LotteryKuai3Draw.getLotteryKuai3DoubleBetPlayIds(str);
            case 8:
            case 108:
                return LotteryPK10Draw.getLotteryPK10DoubleBetPlayIds(str);
            case 10:
                return LotteryMark6Draw.getLotteryMark6DoubleBetPlayIds(str);
            default:
                return resultList;
        }
    }

    public static void main(String[] args) {

        String strEncoder = "DBQZLAgK";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] resultByte = decoder.decodeBuffer(strEncoder);
            if (resultByte.length >= 4) {
                List<String> resultList = new ArrayList();
                for (byte bt : resultByte) {
                    int rString = bt;
                    resultList.add(String.valueOf(rString));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
