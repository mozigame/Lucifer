package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.LotteryPK10DoubleType;
import com.bc.lottery.entity.LotteryPK10Type;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.util.LotteryUtils;

import java.util.*;

/**
 * User: clion
 * Date: 2017/10/30
 * Time: 19:10
 **/
public class LotteryPK10Draw {

    /**
     * PK10传统开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLotteryPK10(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLotteryPK10Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            LotteryPK10Type lotteryPK10Type = (LotteryPK10Type) lotteryType;
            switch (lotteryPK10Type) {

                //冠亚季军大小单双
                case GUAN_DA_XIAO_DAN_SHUANG:
                case YA_DA_XIAO_DAN_SHUANG:
                case THIRD_DA_XIAO_DAN_SHUANG:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjList.get(0)), 10).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //冠军
                case GUAN_JUN_FU_SHI:
                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.get(0).equals(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二复式
                case QIAN_ER_FU_SHI:
                    if (size == 2) {
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二单式
                case QIAN_ER_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realBetNumber = LotteryUtils.getStrListForPK10(betNumbers.get(0), 2);
                        for (List<String> betList : realBetNumber) {

                            if (betList.size() == 2) {
                                if (betNumbers.get(0).contains(betList.get(0))
                                        && betList.get(1).contains(kjList.get(1))) {
                                    firstPrizeNum++;
                                }
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前三复式
                case QIAN_SAN_FU_SHI:
                    if (size == 3) {
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前三单式
                case QIAN_SAN_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realBetNumber = LotteryUtils.getStrListForPK10(betNumbers.get(0), 3);
                        for (List<String> betList : realBetNumber) {

                            if (betList.size() == 3) {
                                if (betNumbers.get(0).contains(betList.get(0))
                                        && betList.get(1).contains(kjList.get(1))
                                        && betList.get(2).contains(kjList.get(2))) {
                                    firstPrizeNum++;
                                }
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前四复式
                case QIAN_SI_FU_SHI:
                    if (size == 4) {
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))
                                && betNumbers.get(3).contains(kjList.get(3))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前四单式
                case QIAN_SI_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realBetNumber = LotteryUtils.getStrListForPK10(betNumbers.get(0), 4);
                        for (List<String> betList : realBetNumber) {

                            if (betList.size() == 4) {
                                if (betNumbers.get(0).contains(betList.get(0))
                                        && betList.get(1).contains(kjList.get(1))
                                        && betList.get(2).contains(kjList.get(2))
                                        && betList.get(3).contains(kjList.get(3))) {
                                    firstPrizeNum++;
                                }
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前五复式
                case QIAN_WU_FU_SHI:
                    if (size == 5) {
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))
                                && betNumbers.get(3).contains(kjList.get(3))
                                && betNumbers.get(4).contains(kjList.get(4))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前五单式
                case QIAN_WU_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realBetNumber = LotteryUtils.getStrListForPK10(betNumbers.get(0), 5);
                        for (List<String> betList : realBetNumber) {

                            if (betList.size() == 5) {
                                if (betNumbers.get(0).contains(betList.get(0))
                                        && betList.get(1).contains(kjList.get(1))
                                        && betList.get(2).contains(kjList.get(2))
                                        && betList.get(3).contains(kjList.get(3))
                                        && betList.get(4).contains(kjList.get(4))) {
                                    firstPrizeNum++;
                                }
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前六复式
                case QIAN_LIU_FU_SHI:
                    if (size == 6) {
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))
                                && betNumbers.get(3).contains(kjList.get(3))
                                && betNumbers.get(4).contains(kjList.get(4))
                                && betNumbers.get(5).contains(kjList.get(5))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前六单式
                case QIAN_LIU_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realBetNumber = LotteryUtils.getStrListForPK10(betNumbers.get(0), 6);
                        for (List<String> betList : realBetNumber) {

                            if (betList.size() == 6) {
                                if (betNumbers.get(0).contains(betList.get(0))
                                        && betList.get(1).contains(kjList.get(1))
                                        && betList.get(2).contains(kjList.get(2))
                                        && betList.get(3).contains(kjList.get(3))
                                        && betList.get(4).contains(kjList.get(4))
                                        && betList.get(5).contains(kjList.get(5))) {
                                    firstPrizeNum++;
                                }
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //定位胆
                case DING_WEI_DAN:
                    if (size == 10) {
                        for (int i = 0; i < size; i++) {

                            if (betNumbers.get(i).contains(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 和值
                case QIAN_SAN_HE_ZHI:
                case HOU_SAN_HE_ZHI:
                case QIAN_ER_HE_ZHI:
                case ZHONG_ER_HE_ZHI:
                case HOU_ER_HE_ZHI:

                    if (size == 1) {
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kjList)))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单号龙虎
                case DAN_HAO_GUAN_LONG_HU:
                case DAN_HAO_YA_LONG_HU:
                case DAN_HAO_THIRD_LONG_HU:
                case DAN_HAO_FORTH_LONG_HU:
                case DAN_HAO_FIFTH_LONG_HU:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(1))).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 竞速
                case JING_SU:
                    if (size != 0) {

                        Map<String, Integer> resultMap = new HashMap<>();
                        int j = 0;
                        for (String kjStr : kjList) {
                            j++;
                            resultMap.put(kjStr, j);
                        }

                        for (int i = 0; i < size; i++) {

                            if (resultMap.get(betNumbers.get(i).get(0))
                                    < resultMap.get(betNumbers.get(i).get(1))) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * PK10双面盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLotteryPK10Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLotteryPK10Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            LotteryPK10DoubleType lotteryPK10DoubleType = (LotteryPK10DoubleType) lotteryType;
            switch (lotteryPK10DoubleType) {

                //冠亚和值大小单双
                case GUAN_YA_HE_DA:
                case GUAN_YA_HE_XIAO:
                case GUAN_YA_HE_DAN:
                case GUAN_YA_HE_SHUANG:

                    if (size == 1) {
                        // 和值
                        int sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getDaxiaodanshuangList(sumStr, 22).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //冠亚和值
                case GUAN_YA_HE_3:
                case GUAN_YA_HE_4:
                case GUAN_YA_HE_5:
                case GUAN_YA_HE_6:
                case GUAN_YA_HE_7:
                case GUAN_YA_HE_8:
                case GUAN_YA_HE_9:
                case GUAN_YA_HE_10:
                case GUAN_YA_HE_11:
                case GUAN_YA_HE_12:
                case GUAN_YA_HE_13:
                case GUAN_YA_HE_14:
                case GUAN_YA_HE_15:
                case GUAN_YA_HE_16:
                case GUAN_YA_HE_17:
                case GUAN_YA_HE_18:
                case GUAN_YA_HE_19:

                    if (size == 1) {

                        // 冠亚和值
                        int sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));

                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(String.valueOf(sumStr))) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单球大小单双
                case DAN_HAO_GUAN_DA:
                case DAN_HAO_GUAN_XIAO:
                case DAN_HAO_GUAN_DAN:
                case DAN_HAO_GUAN_SHUANG:

                case DAN_HAO_YA_DA:
                case DAN_HAO_YA_XIAO:
                case DAN_HAO_YA_DAN:
                case DAN_HAO_YA_SHUANG:

                case DAN_HAO_THIRD_DA:
                case DAN_HAO_THIRD_XIAO:
                case DAN_HAO_THIRD_DAN:
                case DAN_HAO_THIRD_SHUANG:

                case DAN_HAO_FORTH_DA:
                case DAN_HAO_FORTH_XIAO:
                case DAN_HAO_FORTH_DAN:
                case DAN_HAO_FORTH_SHUANG:

                case DAN_HAO_FIFTH_DA:
                case DAN_HAO_FIFTH_XIAO:
                case DAN_HAO_FIFTH_DAN:
                case DAN_HAO_FIFTH_SHUANG:

                case DAN_HAO_SIXTH_DA:
                case DAN_HAO_SIXTH_XIAO:
                case DAN_HAO_SIXTH_DAN:
                case DAN_HAO_SIXTH_SHUANG:

                case DAN_HAO_SEVENTH_DA:
                case DAN_HAO_SEVENTH_XIAO:
                case DAN_HAO_SEVENTH_DAN:
                case DAN_HAO_SEVENTH_SHUANG:

                case DAN_HAO_EIGHTH_DA:
                case DAN_HAO_EIGHTH_XIAO:
                case DAN_HAO_EIGHTH_DAN:
                case DAN_HAO_EIGHTH_SHUANG:

                case DAN_HAO_NINTH_DA:
                case DAN_HAO_NINTH_XIAO:
                case DAN_HAO_NINTH_DAN:
                case DAN_HAO_NINTH_SHUANG:

                case DAN_HAO_TENTH_DA:
                case DAN_HAO_TENTH_XIAO:
                case DAN_HAO_TENTH_DAN:
                case DAN_HAO_TENTH_SHUANG:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjList.get(0)), 10).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单号龙虎
                case DAN_HAO_GUAN_LONG:
                case DAN_HAO_GUAN_HU:
                case DAN_HAO_YA_LONG:
                case DAN_HAO_YA_HU:
                case DAN_HAO_THIRD_LONG:
                case DAN_HAO_THIRD_HU:
                case DAN_HAO_FORTH_LONG:
                case DAN_HAO_FORTH_HU:
                case DAN_HAO_FIFTH_LONG:
                case DAN_HAO_FIFTH_HU:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(1))).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单号
                case DAN_HAO_GUAN_1:
                case DAN_HAO_GUAN_2:
                case DAN_HAO_GUAN_3:
                case DAN_HAO_GUAN_4:
                case DAN_HAO_GUAN_5:
                case DAN_HAO_GUAN_6:
                case DAN_HAO_GUAN_7:
                case DAN_HAO_GUAN_8:
                case DAN_HAO_GUAN_9:
                case DAN_HAO_GUAN_10:

                case DAN_HAO_YA_1:
                case DAN_HAO_YA_2:
                case DAN_HAO_YA_3:
                case DAN_HAO_YA_4:
                case DAN_HAO_YA_5:
                case DAN_HAO_YA_6:
                case DAN_HAO_YA_7:
                case DAN_HAO_YA_8:
                case DAN_HAO_YA_9:
                case DAN_HAO_YA_10:

                case DAN_HAO_THIRD_1:
                case DAN_HAO_THIRD_2:
                case DAN_HAO_THIRD_3:
                case DAN_HAO_THIRD_4:
                case DAN_HAO_THIRD_5:
                case DAN_HAO_THIRD_6:
                case DAN_HAO_THIRD_7:
                case DAN_HAO_THIRD_8:
                case DAN_HAO_THIRD_9:
                case DAN_HAO_THIRD_10:

                case DAN_HAO_FORTH_1:
                case DAN_HAO_FORTH_2:
                case DAN_HAO_FORTH_3:
                case DAN_HAO_FORTH_4:
                case DAN_HAO_FORTH_5:
                case DAN_HAO_FORTH_6:
                case DAN_HAO_FORTH_7:
                case DAN_HAO_FORTH_8:
                case DAN_HAO_FORTH_9:
                case DAN_HAO_FORTH_10:

                case DAN_HAO_FIFTH_1:
                case DAN_HAO_FIFTH_2:
                case DAN_HAO_FIFTH_3:
                case DAN_HAO_FIFTH_4:
                case DAN_HAO_FIFTH_5:
                case DAN_HAO_FIFTH_6:
                case DAN_HAO_FIFTH_7:
                case DAN_HAO_FIFTH_8:
                case DAN_HAO_FIFTH_9:
                case DAN_HAO_FIFTH_10:

                case DAN_HAO_SIXTH_1:
                case DAN_HAO_SIXTH_2:
                case DAN_HAO_SIXTH_3:
                case DAN_HAO_SIXTH_4:
                case DAN_HAO_SIXTH_5:
                case DAN_HAO_SIXTH_6:
                case DAN_HAO_SIXTH_7:
                case DAN_HAO_SIXTH_8:
                case DAN_HAO_SIXTH_9:
                case DAN_HAO_SIXTH_10:

                case DAN_HAO_SEVENTH_1:
                case DAN_HAO_SEVENTH_2:
                case DAN_HAO_SEVENTH_3:
                case DAN_HAO_SEVENTH_4:
                case DAN_HAO_SEVENTH_5:
                case DAN_HAO_SEVENTH_6:
                case DAN_HAO_SEVENTH_7:
                case DAN_HAO_SEVENTH_8:
                case DAN_HAO_SEVENTH_9:
                case DAN_HAO_SEVENTH_10:

                case DAN_HAO_EIGHTH_1:
                case DAN_HAO_EIGHTH_2:
                case DAN_HAO_EIGHTH_3:
                case DAN_HAO_EIGHTH_4:
                case DAN_HAO_EIGHTH_5:
                case DAN_HAO_EIGHTH_6:
                case DAN_HAO_EIGHTH_7:
                case DAN_HAO_EIGHTH_8:
                case DAN_HAO_EIGHTH_9:
                case DAN_HAO_EIGHTH_10:

                case DAN_HAO_NINTH_1:
                case DAN_HAO_NINTH_2:
                case DAN_HAO_NINTH_3:
                case DAN_HAO_NINTH_4:
                case DAN_HAO_NINTH_5:
                case DAN_HAO_NINTH_6:
                case DAN_HAO_NINTH_7:
                case DAN_HAO_NINTH_8:
                case DAN_HAO_NINTH_9:
                case DAN_HAO_NINTH_10:

                case DAN_HAO_TENTH_1:
                case DAN_HAO_TENTH_2:
                case DAN_HAO_TENTH_3:
                case DAN_HAO_TENTH_4:
                case DAN_HAO_TENTH_5:
                case DAN_HAO_TENTH_6:
                case DAN_HAO_TENTH_7:
                case DAN_HAO_TENTH_8:
                case DAN_HAO_TENTH_9:
                case DAN_HAO_TENTH_10:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 获取双面PK10的中奖玩法idlist
     *
     * @param str
     * @return
     */
    public static List<Long> getLotteryPK10DoubleBetPlayIds(String str) {

        List<Long> resultList = new ArrayList<>();
        int sumStr = 0;
        for (LotteryPK10DoubleType lotteryPK10DoubleType : LotteryPK10DoubleType.values()) {

            List<String> kjList = getRealLotteryPK10Kj(str, lotteryPK10DoubleType);

            //获取单球的大小单双
            List<String> singleBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 9);

            //获取中奖号的龙虎和信息
            List<String> longhuBetList = new ArrayList<>();
            if (kjList.size() == 2) {
                longhuBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(1)));
            }

            switch (lotteryPK10DoubleType) {
                //冠亚和值大小单双
                case GUAN_YA_HE_DA:
                    // 和值
                    sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));
                    if (LotteryUtils.getDaxiaodanshuangList(sumStr, 22).contains("大")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;
                case GUAN_YA_HE_XIAO:
                    // 和值
                    sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));
                    if (LotteryUtils.getDaxiaodanshuangList(sumStr, 22).contains("小")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;
                case GUAN_YA_HE_DAN:
                    // 和值
                    sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));
                    if (LotteryUtils.getDaxiaodanshuangList(sumStr, 22).contains("单")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;
                case GUAN_YA_HE_SHUANG:
                    // 和值
                    sumStr = Integer.parseInt(kjList.get(0)) + Integer.parseInt(kjList.get(1));
                    if (LotteryUtils.getDaxiaodanshuangList(sumStr, 22).contains("双")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                    //单球大小单双
                case DAN_HAO_GUAN_DA:
                case DAN_HAO_YA_DA:
                case DAN_HAO_THIRD_DA:
                case DAN_HAO_FORTH_DA:
                case DAN_HAO_FIFTH_DA:
                case DAN_HAO_SIXTH_DA:
                case DAN_HAO_SEVENTH_DA:
                case DAN_HAO_EIGHTH_DA:
                case DAN_HAO_NINTH_DA:
                case DAN_HAO_TENTH_DA:
                    if (singleBetList.contains("大")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                case DAN_HAO_GUAN_XIAO:
                case DAN_HAO_YA_XIAO:
                case DAN_HAO_THIRD_XIAO:
                case DAN_HAO_FORTH_XIAO:
                case DAN_HAO_FIFTH_XIAO:
                case DAN_HAO_SIXTH_XIAO:
                case DAN_HAO_SEVENTH_XIAO:
                case DAN_HAO_EIGHTH_XIAO:
                case DAN_HAO_NINTH_XIAO:
                case DAN_HAO_TENTH_XIAO:
                    if (singleBetList.contains("小")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                case DAN_HAO_GUAN_DAN:
                case DAN_HAO_YA_DAN:
                case DAN_HAO_THIRD_DAN:
                case DAN_HAO_FORTH_DAN:
                case DAN_HAO_FIFTH_DAN:
                case DAN_HAO_SIXTH_DAN:
                case DAN_HAO_SEVENTH_DAN:
                case DAN_HAO_EIGHTH_DAN:
                case DAN_HAO_NINTH_DAN:
                case DAN_HAO_TENTH_DAN:
                    if (singleBetList.contains("单")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                case DAN_HAO_GUAN_SHUANG:
                case DAN_HAO_YA_SHUANG:
                case DAN_HAO_THIRD_SHUANG:
                case DAN_HAO_FORTH_SHUANG:
                case DAN_HAO_FIFTH_SHUANG:
                case DAN_HAO_SIXTH_SHUANG:
                case DAN_HAO_SEVENTH_SHUANG:
                case DAN_HAO_EIGHTH_SHUANG:
                case DAN_HAO_NINTH_SHUANG:
                case DAN_HAO_TENTH_SHUANG:
                    if (singleBetList.contains("双")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                    //单号龙虎
                case DAN_HAO_GUAN_LONG:
                case DAN_HAO_YA_LONG:
                case DAN_HAO_THIRD_LONG:
                case DAN_HAO_FORTH_LONG:
                case DAN_HAO_FIFTH_LONG:
                    if (longhuBetList.contains("龙")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

                case DAN_HAO_GUAN_HU:
                case DAN_HAO_YA_HU:
                case DAN_HAO_THIRD_HU:
                case DAN_HAO_FORTH_HU:
                case DAN_HAO_FIFTH_HU:
                    if (longhuBetList.contains("虎")) {
                        resultList.add(lotteryPK10DoubleType.value());
                    }
                    continue;

            }
        }
        return resultList;
    }


    /**
     * PK10开奖号整理
     *
     * @param kj
     * @param lotteryType
     * @return
     */
    private static List<String> getRealLotteryPK10Kj(String kj, LotteryType lotteryType) {

        List<String> kjList = Arrays.asList(kj.split(","));
        if (kjList.size() != 10) {
            return null;
        }
        List<String> resultList = new ArrayList<>();
        if (lotteryType instanceof LotteryPK10DoubleType) {
            LotteryPK10DoubleType lotteryPK10DoubleType = (LotteryPK10DoubleType) lotteryType;
            switch (lotteryPK10DoubleType) {

                //龙虎
                case DAN_HAO_GUAN_LONG:
                case DAN_HAO_GUAN_HU:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(9));
                    break;

                case DAN_HAO_YA_LONG:
                case DAN_HAO_YA_HU:
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(8));
                    break;

                case DAN_HAO_THIRD_LONG:
                case DAN_HAO_THIRD_HU:
                    resultList.add(kjList.get(2));
                    resultList.add(kjList.get(7));
                    break;

                case DAN_HAO_FORTH_LONG:
                case DAN_HAO_FORTH_HU:
                    resultList.add(kjList.get(3));
                    resultList.add(kjList.get(6));
                    break;

                case DAN_HAO_FIFTH_LONG:
                case DAN_HAO_FIFTH_HU:
                    resultList.add(kjList.get(4));
                    resultList.add(kjList.get(5));
                    break;

                // 单号冠军
                case DAN_HAO_GUAN_DA:
                case DAN_HAO_GUAN_XIAO:
                case DAN_HAO_GUAN_DAN:
                case DAN_HAO_GUAN_SHUANG:

                case DAN_HAO_GUAN_1:
                case DAN_HAO_GUAN_2:
                case DAN_HAO_GUAN_3:
                case DAN_HAO_GUAN_4:
                case DAN_HAO_GUAN_5:
                case DAN_HAO_GUAN_6:
                case DAN_HAO_GUAN_7:
                case DAN_HAO_GUAN_8:
                case DAN_HAO_GUAN_9:
                case DAN_HAO_GUAN_10:

                    resultList.add(kjList.get(0));
                    break;

                // 单号亚军
                case DAN_HAO_YA_DA:
                case DAN_HAO_YA_XIAO:
                case DAN_HAO_YA_DAN:
                case DAN_HAO_YA_SHUANG:

                case DAN_HAO_YA_1:
                case DAN_HAO_YA_2:
                case DAN_HAO_YA_3:
                case DAN_HAO_YA_4:
                case DAN_HAO_YA_5:
                case DAN_HAO_YA_6:
                case DAN_HAO_YA_7:
                case DAN_HAO_YA_8:
                case DAN_HAO_YA_9:
                case DAN_HAO_YA_10:

                    resultList.add(kjList.get(1));
                    break;

                // 单号第三名
                case DAN_HAO_THIRD_DA:
                case DAN_HAO_THIRD_XIAO:
                case DAN_HAO_THIRD_DAN:
                case DAN_HAO_THIRD_SHUANG:

                case DAN_HAO_THIRD_1:
                case DAN_HAO_THIRD_2:
                case DAN_HAO_THIRD_3:
                case DAN_HAO_THIRD_4:
                case DAN_HAO_THIRD_5:
                case DAN_HAO_THIRD_6:
                case DAN_HAO_THIRD_7:
                case DAN_HAO_THIRD_8:
                case DAN_HAO_THIRD_9:
                case DAN_HAO_THIRD_10:

                    resultList.add(kjList.get(2));
                    break;
                // 单号第四名
                case DAN_HAO_FORTH_DA:
                case DAN_HAO_FORTH_XIAO:
                case DAN_HAO_FORTH_DAN:
                case DAN_HAO_FORTH_SHUANG:

                case DAN_HAO_FORTH_1:
                case DAN_HAO_FORTH_2:
                case DAN_HAO_FORTH_3:
                case DAN_HAO_FORTH_4:
                case DAN_HAO_FORTH_5:
                case DAN_HAO_FORTH_6:
                case DAN_HAO_FORTH_7:
                case DAN_HAO_FORTH_8:
                case DAN_HAO_FORTH_9:
                case DAN_HAO_FORTH_10:

                    resultList.add(kjList.get(3));
                    break;

                // 单号第五名
                case DAN_HAO_FIFTH_DA:
                case DAN_HAO_FIFTH_XIAO:
                case DAN_HAO_FIFTH_DAN:
                case DAN_HAO_FIFTH_SHUANG:

                case DAN_HAO_FIFTH_1:
                case DAN_HAO_FIFTH_2:
                case DAN_HAO_FIFTH_3:
                case DAN_HAO_FIFTH_4:
                case DAN_HAO_FIFTH_5:
                case DAN_HAO_FIFTH_6:
                case DAN_HAO_FIFTH_7:
                case DAN_HAO_FIFTH_8:
                case DAN_HAO_FIFTH_9:
                case DAN_HAO_FIFTH_10:

                    resultList.add(kjList.get(4));
                    break;
                // 单号第六名
                case DAN_HAO_SIXTH_DA:
                case DAN_HAO_SIXTH_XIAO:
                case DAN_HAO_SIXTH_DAN:
                case DAN_HAO_SIXTH_SHUANG:

                case DAN_HAO_SIXTH_1:
                case DAN_HAO_SIXTH_2:
                case DAN_HAO_SIXTH_3:
                case DAN_HAO_SIXTH_4:
                case DAN_HAO_SIXTH_5:
                case DAN_HAO_SIXTH_6:
                case DAN_HAO_SIXTH_7:
                case DAN_HAO_SIXTH_8:
                case DAN_HAO_SIXTH_9:
                case DAN_HAO_SIXTH_10:

                    resultList.add(kjList.get(5));
                    break;
                // 单号第七名
                case DAN_HAO_SEVENTH_DA:
                case DAN_HAO_SEVENTH_XIAO:
                case DAN_HAO_SEVENTH_DAN:
                case DAN_HAO_SEVENTH_SHUANG:

                case DAN_HAO_SEVENTH_1:
                case DAN_HAO_SEVENTH_2:
                case DAN_HAO_SEVENTH_3:
                case DAN_HAO_SEVENTH_4:
                case DAN_HAO_SEVENTH_5:
                case DAN_HAO_SEVENTH_6:
                case DAN_HAO_SEVENTH_7:
                case DAN_HAO_SEVENTH_8:
                case DAN_HAO_SEVENTH_9:
                case DAN_HAO_SEVENTH_10:

                    resultList.add(kjList.get(6));
                    break;
                // 单号第八名
                case DAN_HAO_EIGHTH_DA:
                case DAN_HAO_EIGHTH_XIAO:
                case DAN_HAO_EIGHTH_DAN:
                case DAN_HAO_EIGHTH_SHUANG:

                case DAN_HAO_EIGHTH_1:
                case DAN_HAO_EIGHTH_2:
                case DAN_HAO_EIGHTH_3:
                case DAN_HAO_EIGHTH_4:
                case DAN_HAO_EIGHTH_5:
                case DAN_HAO_EIGHTH_6:
                case DAN_HAO_EIGHTH_7:
                case DAN_HAO_EIGHTH_8:
                case DAN_HAO_EIGHTH_9:
                case DAN_HAO_EIGHTH_10:

                    resultList.add(kjList.get(7));
                    break;

                // 单号第九名
                case DAN_HAO_NINTH_DA:
                case DAN_HAO_NINTH_XIAO:
                case DAN_HAO_NINTH_DAN:
                case DAN_HAO_NINTH_SHUANG:

                case DAN_HAO_NINTH_1:
                case DAN_HAO_NINTH_2:
                case DAN_HAO_NINTH_3:
                case DAN_HAO_NINTH_4:
                case DAN_HAO_NINTH_5:
                case DAN_HAO_NINTH_6:
                case DAN_HAO_NINTH_7:
                case DAN_HAO_NINTH_8:
                case DAN_HAO_NINTH_9:
                case DAN_HAO_NINTH_10:

                    resultList.add(kjList.get(8));
                    break;

                // 单号第十名
                case DAN_HAO_TENTH_DA:
                case DAN_HAO_TENTH_XIAO:
                case DAN_HAO_TENTH_DAN:
                case DAN_HAO_TENTH_SHUANG:

                case DAN_HAO_TENTH_1:
                case DAN_HAO_TENTH_2:
                case DAN_HAO_TENTH_3:
                case DAN_HAO_TENTH_4:
                case DAN_HAO_TENTH_5:
                case DAN_HAO_TENTH_6:
                case DAN_HAO_TENTH_7:
                case DAN_HAO_TENTH_8:
                case DAN_HAO_TENTH_9:
                case DAN_HAO_TENTH_10:

                    resultList.add(kjList.get(9));
                    break;
                default:
                    resultList = kjList;
            }

        } else if (lotteryType instanceof LotteryPK10Type) {

            LotteryPK10Type lotteryPK10Type = (LotteryPK10Type) lotteryType;
            switch (lotteryPK10Type) {

                // 冠军龙虎
                case DAN_HAO_GUAN_LONG_HU:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(9));
                    break;

                // 亚军龙虎
                case DAN_HAO_YA_LONG_HU:

                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(8));
                    break;

                //第三名龙虎
                case DAN_HAO_THIRD_LONG_HU:

                    resultList.add(kjList.get(2));
                    resultList.add(kjList.get(7));
                    break;

                // 第四名龙虎
                case DAN_HAO_FORTH_LONG_HU:

                    resultList.add(kjList.get(3));
                    resultList.add(kjList.get(6));
                    break;

                // 第五名龙虎
                case DAN_HAO_FIFTH_LONG_HU:
                case ZHONG_ER_HE_ZHI:

                    resultList.add(kjList.get(4));
                    resultList.add(kjList.get(5));
                    break;

                // 冠军
                case GUAN_JUN_FU_SHI:
                case GUAN_DA_XIAO_DAN_SHUANG:
                    resultList.add(kjList.get(0));
                    break;

                // 亚军
                case YA_DA_XIAO_DAN_SHUANG:
                    resultList.add(kjList.get(1));
                    break;

                //季军
                case THIRD_DA_XIAO_DAN_SHUANG:
                    resultList.add(kjList.get(2));
                    break;

                //前二
                case QIAN_ER_DAN_SHI:
                case QIAN_ER_FU_SHI:
                case QIAN_ER_HE_ZHI:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    break;

                // 前三
                case QIAN_SAN_DAN_SHI:
                case QIAN_SAN_FU_SHI:
                case QIAN_SAN_HE_ZHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    break;

                //前四
                case QIAN_SI_DAN_SHI:
                case QIAN_SI_FU_SHI:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    resultList.add(kjList.get(3));
                    break;

                // 前五
                case QIAN_WU_DAN_SHI:
                case QIAN_WU_FU_SHI:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    resultList.add(kjList.get(3));
                    resultList.add(kjList.get(4));
                    break;

                // 前六
                case QIAN_LIU_DAN_SHI:
                case QIAN_LIU_FU_SHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    resultList.add(kjList.get(3));
                    resultList.add(kjList.get(4));
                    resultList.add(kjList.get(5));
                    break;

                // 后三和值
                case HOU_SAN_HE_ZHI:
                    resultList.add(kjList.get(7));
                    resultList.add(kjList.get(8));
                    resultList.add(kjList.get(9));
                    break;

                // 后二和值
                case HOU_ER_HE_ZHI:
                    resultList.add(kjList.get(8));
                    resultList.add(kjList.get(9));
                    break;
                default:
                    resultList = kjList;
            }
        }
        return resultList;
    }

}
