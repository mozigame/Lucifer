package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.LotteryKuai3DoubleType;
import com.bc.lottery.entity.LotteryKuai3Type;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.util.LotteryUtils;

import java.util.*;

/**
 * User: clion
 * Date: 2017/10/30
 * Time: 19:10
 **/
public class LotteryKuai3Draw {

    /**
     * 快3传统开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLotteryKuai3(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLotteryKuai3Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            LotteryKuai3Type lotteryKuai3Type = (LotteryKuai3Type) lotteryType;
            switch (lotteryKuai3Type) {

                // 二同号复选
                case ER_TONG_HAO_FU_XUAN:
                    // TODO 后期优化
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 2).size() > 0) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getDupStrByDupNum(kjList, 2).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三不同号标准选号
                case SAN_BU_TONG_HAO_FU_SHI:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 1).size() == 3) {

                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三不同号手选
                case SAN_BU_TONG_HAO_DAN_SHI:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 1).size() == 3) {

                        List<List<String>> realStringList = LotteryUtils.getStrListForKuai3(betNumbers.get(0), 3);

                        for (List<String> strList : realStringList) {
                            if (strList.containsAll(LotteryUtils.getDupStrByDupNum(kjList, 1))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //三不同号胆拖选号
                case SAN_BU_TONG_HAO_DAN_TUO:
                    if (size == 2) {
                        for (String str : betNumbers.get(0)) {

                            List<String> stringList = new ArrayList<>();
                            stringList.addAll(betNumbers.get(1));
                            stringList.add(str);
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }

                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三同号单选
                case SAN_TONG_HAO_DAN_XUAN:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 1) {

                        for (String str : betNumbers.get(0)) {
                            if (LotteryUtils.getDupStrByDupNum(kjList, 3).contains(str)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三同号通选
                case SAN_TONG_HAO_TONG_XUAN:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 1) {
                        firstPrizeNum++;
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //和值大小单双
                case HE_ZHI_DA_XIAO:
                case HE_ZHI_DAN_SHUANG:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjList.get(0)), 20).contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 和值点数
                case HE_ZHI_DIAN_SHU:
                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(String.valueOf(LotteryUtils.getStrSum(kjList)))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二不同号标准
                case ER_BU_TONG_HAO_FU_SHI:
                    if (size == 1) {

                        int betNo = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                betNo++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(betNo, 2);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二不同号手动号
                case ER_BU_TONG_HAO_DAN_SHI:

                    if (size == 1) {
                        List<List<String>> realList = LotteryUtils.getStrListForKuai3(betNumbers.get(0), 2);
                        for (List<String> betList : realList) {
                            if (kjList.containsAll(betList)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二不同号胆拖
                case ER_BU_TONG_HAO_DAN_TUO:
                    if (size == 2 && betNumbers.get(0).size() == 1 && kjList.containsAll(betNumbers.get(0))) {
                        for (String str : betNumbers.get(1)) {
                            if (kjList.contains(str)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二同号单选
                case ER_TONG_HAO_FU_SHI:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 2).size() == 1) {

                        if (betNumbers.get(0).containsAll(LotteryUtils.getDupStrByDupNum(kjList, 2))
                                && betNumbers.get(1).containsAll(LotteryUtils.getDupStrByDupNum(kjList, 1))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二同号单式
                case ER_TONG_HAO_DAN_SHI:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 2).size() == 1) {

                        List<List<String>> realList = LotteryUtils.getStrListForKuai3(betNumbers.get(0), 3);
                        for (List<String> betList : realList) {
                            if (LotteryUtils.getDupStrByDupNum(betList, 2).size() == 1
                                    && LotteryUtils.getDupStrByDupNum(betList, 2).containsAll(LotteryUtils.getDupStrByDupNum(kjList, 2))
                                    && LotteryUtils.getDupStrByDupNum(betList, 1).containsAll(LotteryUtils.getDupStrByDupNum(kjList, 1))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三连号通选
                case SAN_LIAN_HAO_TONG_XUAN:
                    // TODO 暂时偷懒用简单方法--依赖前端
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 1).size() == 3) {

                        for (List<String> betList : betNumbers) {
                            if (betList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一号中奖不定胆
                case YI_HAO_DING_WEI_DAN:

                    if (size == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 快3双面盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLotteryKuai3Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLotteryKuai3Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            LotteryKuai3DoubleType lotteryKuai3DoubleType = (LotteryKuai3DoubleType) lotteryType;
            switch (lotteryKuai3DoubleType) {

                //三军
                case SAN_JUN_1:
                case SAN_JUN_2:
                case SAN_JUN_3:
                case SAN_JUN_4:
                case SAN_JUN_5:
                case SAN_JUN_6:

                    if (betNumbers.size() == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和大小
                case SAN_JUN_大:
                case SAN_JUN_小:

                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 0) {

                        Map<String, Integer> scopeMap = new HashMap<>();
                        scopeMap.put("smallSmall", 4);
                        scopeMap.put("smallBig", 10);
                        scopeMap.put("bigSmall", 11);
                        scopeMap.put("bigBig", 17);

                        //获取中奖号的总和的大小
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), scopeMap);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //围骰
                case WEI_SHAI_1:
                case WEI_SHAI_2:
                case WEI_SHAI_3:
                case WEI_SHAI_4:
                case WEI_SHAI_5:
                case WEI_SHAI_6:

                    if (betNumbers.size() == 1) {
                        Set<String> stringSet = LotteryUtils.getDupStrByDupNum(kjList, 3);
                        if (stringSet.size() != 0 && stringSet.containsAll(betNumbers.get(0))) {
                            firstPrizeNum = 1;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 全骰
                case QUAN_SHAI:

                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 1) {
                        firstPrizeNum = 1;
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //点数
                case DIAN_SHU_HE_4:
                case DIAN_SHU_HE_5:
                case DIAN_SHU_HE_6:
                case DIAN_SHU_HE_7:
                case DIAN_SHU_HE_8:
                case DIAN_SHU_HE_9:
                case DIAN_SHU_HE_10:
                case DIAN_SHU_HE_11:
                case DIAN_SHU_HE_12:
                case DIAN_SHU_HE_13:
                case DIAN_SHU_HE_14:
                case DIAN_SHU_HE_15:
                case DIAN_SHU_HE_16:
                case DIAN_SHU_HE_17:

                    // 去除豹子
                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 0) {

                        //获取中奖号的和值
                        int sumString = LotteryUtils.getStrSum(kjList);
                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(String.valueOf(sumString))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 长牌
                case CHANG_PAI_12:
                case CHANG_PAI_13:
                case CHANG_PAI_14:
                case CHANG_PAI_15:
                case CHANG_PAI_16:
                case CHANG_PAI_23:
                case CHANG_PAI_24:
                case CHANG_PAI_25:
                case CHANG_PAI_26:
                case CHANG_PAI_34:
                case CHANG_PAI_35:
                case CHANG_PAI_36:
                case CHANG_PAI_45:
                case CHANG_PAI_46:
                case CHANG_PAI_56:

                    if (size == 1) {
                        //判断中间号码是否包含所选的各组号码
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //短牌
                case DUAN_PAI_1:
                case DUAN_PAI_2:
                case DUAN_PAI_3:
                case DUAN_PAI_4:
                case DUAN_PAI_5:
                case DUAN_PAI_6:

                    //去除豹子
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 0) {
                        //判断中间号码是否包含所选的各组号码
                        if (LotteryUtils.getDupStr(kjNo).containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 获取双面快3的中奖玩法idlist
     *
     * @param str
     * @return
     */
    public static List<Long> getLotteryKuai3DoubleBetPlayIds(String str) {

        List<Long> resultList = new ArrayList<>();
        Map<String, Integer> scopeMap = new HashMap<>();
        scopeMap.put("smallSmall", 4);
        scopeMap.put("smallBig", 10);
        scopeMap.put("bigSmall", 11);
        scopeMap.put("bigBig", 17);
        for (LotteryKuai3DoubleType lotteryKuai3DoubleType : LotteryKuai3DoubleType.values()) {

            List<String> kjList = getRealLotteryKuai3Kj(str, lotteryKuai3DoubleType);
            Set<String> baoziSet = LotteryUtils.getDupStrByDupNum(kjList, 3);

            switch (lotteryKuai3DoubleType) {
                //三军
                case SAN_JUN_1:
                    if (kjList.contains("1")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;

                case SAN_JUN_2:
                    if (kjList.contains("2")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case SAN_JUN_3:
                    if (kjList.contains("3")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case SAN_JUN_4:
                    if (kjList.contains("4")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case SAN_JUN_5:
                    if (kjList.contains("5")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case SAN_JUN_6:
                    if (kjList.contains("6")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;

                    //总和大小
                case SAN_JUN_大:
                    if (LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 0) {
                        //获取中奖号的总和的大小
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), scopeMap);
                        if (firstBetList.contains("大")) {
                            resultList.add(lotteryKuai3DoubleType.value());
                        }
                    }
                    continue;

                case SAN_JUN_小:
                    if (LotteryUtils.getDupStrByDupNum(kjList, 3).size() == 0) {
                        //获取中奖号的总和的大小
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), scopeMap);
                        if (firstBetList.contains("小")) {
                            resultList.add(lotteryKuai3DoubleType.value());
                        }
                    }
                    continue;
                    //围骰
                case WEI_SHAI_1:
                    if (baoziSet.size() == 1 && baoziSet.contains("1")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case WEI_SHAI_2:
                    if (baoziSet.size() == 1 && baoziSet.contains("2")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case WEI_SHAI_3:
                    if (baoziSet.size() == 1 && baoziSet.contains("3")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case WEI_SHAI_4:
                    if (baoziSet.size() == 1 && baoziSet.contains("4")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case WEI_SHAI_5:
                    if (baoziSet.size() == 1 && baoziSet.contains("5")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case WEI_SHAI_6:
                    if (baoziSet.size() == 1 && baoziSet.contains("6")) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;

                    // 全骰
                case QUAN_SHAI:
                    if (baoziSet.size() == 1) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;

                    //短牌
                case DUAN_PAI_1:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(1)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;

                case DUAN_PAI_2:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(2)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case DUAN_PAI_3:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(3)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case DUAN_PAI_4:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(4)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case DUAN_PAI_5:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(5)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
                case DUAN_PAI_6:
                    if (baoziSet.size() == 0 && LotteryUtils.getDupStr(str).contains(6)) {
                        resultList.add(lotteryKuai3DoubleType.value());
                    }
                    continue;
            }
        }
        return resultList;
    }


    /**
     * 快3开奖号整理
     *
     * @param kj
     * @param lotteryType
     * @return
     */
    private static List<String> getRealLotteryKuai3Kj(String kj, LotteryType lotteryType) {

        List<String> resultList = new ArrayList<>();
        if (lotteryType instanceof LotteryKuai3DoubleType) {

            resultList = Arrays.asList(kj.replace(",", "").replace("|", "").trim().split(""));
        }

        return resultList;
    }
}
