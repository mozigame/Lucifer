package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.draw.service.LotteryDrawHandle;
import com.bc.lottery.entity.*;
import com.bc.lottery.util.LotteryUtils;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.*;

/**
 * Created by luis on 2017/4/14.
 */

@Deprecated
public class ShishicaiDrawServiceImpl implements LotteryDrawHandle {

    @Override
    public UserOrderPO getBoundsInfoOfLottery(String kj, UserOrderPO order) {

        List<UserOrderPO> lotteryOrderList = new ArrayList<>();
        lotteryOrderList.add(order);
        LotteryType lotteryType = LotteryType.parseType(order.getLotteryId(), order.getPlayId());

        if (lotteryType instanceof ShishicaiType) {
            // 传统时时彩
            return getBoundsInfoOfShishicai(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof ShishicaiDoubleType) {
            // 双面盘时时彩
            return getBoundsInfoOfShishicaiDouble(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof Lottery11x5Type) {
            // 传统盘11选5
            return getBoundsInfoOfLottery11x5(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof Lottery11x5DoubleType) {
            // 双面盘11选5
            return getBoundsInfoOfLottery11x5Double(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryKuai3Type) {
            // 传统盘快3
            return getBoundsInfoOfLotteryKuai3(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryKuai3DoubleType) {
            // 双面盘快3
            return getBoundsInfoOfLotteryKuai3Double(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryPK10Type) {
            // 传统盘PK10
            return getBoundsInfoOfLotteryPK10(lotteryType, kj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof LotteryPK10DoubleType) {
            // 双面盘PK10
            return getBoundsInfoOfLotteryPK10Double(lotteryType, kj, lotteryOrderList).get(0);
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
            return getBoundsInfoOfShishicai(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof ShishicaiDoubleType) {
            // 双面盘时时彩
            return getBoundsInfoOfShishicaiDouble(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof Lottery11x5Type) {
            // 传统盘11选5
            return getBoundsInfoOfLottery11x5(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof Lottery11x5DoubleType) {
            // 双面盘11选5
            return getBoundsInfoOfLottery11x5Double(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryKuai3Type) {
            // 传统盘快3
            return getBoundsInfoOfLotteryKuai3(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryKuai3DoubleType) {
            // 双面盘快3
            return getBoundsInfoOfLotteryKuai3Double(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryPK10Type) {
            // 传统盘PK10
            return getBoundsInfoOfLotteryPK10(lotteryType, kj, lotteryOrderList);
        } else if (lotteryType instanceof LotteryPK10DoubleType) {
            // 双面盘PK10
            return getBoundsInfoOfLotteryPK10Double(lotteryType, kj, lotteryOrderList);
        }
        return null;
    }

    @Override
    public List<Long> getLotteryBetPlayIds(Long lotteryId, String str) {

        List<Long> resultList = new ArrayList<>();
        switch (String.valueOf(lotteryId)) {
            case 2 + "":
                return getShishicaiDoubleBetPlayIds(str);
            case 4 + "":
                return getLottery11x5DoubleBetPlayIds(str);
            case 6 + "":
                return getLotteryKuai3DoubleBetPlayIds(str);
            case 8 + "":
                return getLotteryPK10DoubleBetPlayIds(str);
            default:
                return resultList;
        }
    }

    /**
     * 获取双面时时彩的中奖玩法idlist
     *
     * @param str
     * @return
     */
    private List<Long> getShishicaiDoubleBetPlayIds(String str) {

        List<Long> resultList = new ArrayList<>();
        for (ShishicaiDoubleType shishicaiDoubleType : ShishicaiDoubleType.values()) {

            String kj = getRealShiShiCaiKj(str.replace(",", "").replace("|", ""), shishicaiDoubleType);
            String[] kjArr = kj.split("");
            //获取总和的大小单双
            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 45);

            //获取单球的大小单双
            List<String> singleBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 9);

            //获取中奖号的龙虎和信息
            List<String> longhuBetList = new ArrayList<>();
            if (kjArr.length == 5) {
                longhuBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjArr[0]), Integer.parseInt(kjArr[4]));
            }

            //获取中奖号码的的特殊玩法值
            List<String> specialBetList = new ArrayList<>();
            if (kjArr.length == 3) {
                specialBetList = LotteryUtils.getDoubleTeShuWanFaList(kj);
            }

            switch (shishicaiDoubleType) {

                //总和大小单双
                case ZONG_HE_DA:
                    if (firstBetList.contains("大")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case ZONG_HE_XIAO:
                    if (firstBetList.contains("小")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case ZONG_HE_DAN:
                    if (firstBetList.contains("单")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case ZONG_HE_SHUANG:
                    if (firstBetList.contains("双")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                    if (longhuBetList.contains("龙")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case ZONG_HE_HU:
                    if (longhuBetList.contains("虎")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case ZONG_HE_HE:
                    if (longhuBetList.contains("和")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case ER_QIU_DA:
                case SAN_QIU_DA:
                case SI_QIU_DA:
                case WU_QIU_DA:
                    if (singleBetList.contains("大")) {

                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_XIAO:
                case ER_QIU_XIAO:
                case SAN_QIU_XIAO:
                case SI_QIU_XIAO:
                case WU_QIU_XIAO:
                    if (singleBetList.contains("小")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DAN:
                case ER_QIU_DAN:
                case SAN_QIU_DAN:
                case SI_QIU_DAN:
                case WU_QIU_DAN:
                    if (singleBetList.contains("单")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case WU_QIU_SHUANG:
                    if (singleBetList.contains("双")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                   /* // 单球定位模式
                case YI_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_0:
                    if (kj.contains("0")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_1:
                    if (kj.contains("1")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_2:
                    if (kj.contains("2")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_3:
                    if (kj.contains("3")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_4:
                    if (kj.contains("4")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_5:
                    if (kj.contains("5")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_6:
                    if (kj.contains("6")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_7:
                    if (kj.contains("7")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_8:
                    if (kj.contains("8")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case YI_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_9:
                    if (kj.contains("9")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;*/
                    // 特殊玩法模式
                case QIAN_SAN_BAO_ZI:
                case ZHONG_SAN_BAO_ZI:
                case HOU_SAN_BAO_ZI:
                    if (specialBetList.contains("豹子")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;

                case QIAN_SAN_SHUN_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case HOU_SAN_SHUN_ZI:
                    if (specialBetList.contains("顺子")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case QIAN_SAN_DUI_ZI:
                case ZHONG_SAN_DUI_ZI:
                case HOU_SAN_DUI_ZI:
                    if (specialBetList.contains("对子")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case QIAN_SAN_BAN_SHUN:
                case ZHONG_SAN_BAN_SHUN:
                case HOU_SAN_BAN_SHUN:
                    if (specialBetList.contains("半顺")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
                case QIAN_SAN_ZA_LIU:
                case ZHONG_SAN_ZA_LIU:
                case HOU_SAN_ZA_LIU:
                    if (specialBetList.contains("杂六")) {
                        resultList.add(shishicaiDoubleType.value());
                    }
                    continue;
            }
        }
        return resultList;
    }

    /**
     * 获取双面11x5的中奖玩法idlist
     *
     * @param str
     * @return
     */
    private List<Long> getLottery11x5DoubleBetPlayIds(String str) {

        List<Long> resultList = new ArrayList<>();
        for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {

            List<String> kjList = getRealLottery11x5Kj(str, lottery11x5DoubleType);

            //获取总和的大小单双
            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60, 30);

            //获取中奖号的总和的尾数单双
            List<String> tailBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList) % 10, 9);

            //获取单球的大小单双
            List<String> singleBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 9);

            //获取中奖号的龙虎和信息
            List<String> longhuBetList = new ArrayList<>();
            if (kjList.size() == 5) {
                longhuBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(4)));
            }

            switch (lottery11x5DoubleType) {

                //总和大小单双
                case ZONG_HE_DA:
                    if (firstBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_XIAO:
                    if (firstBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
                case ZONG_HE_DAN:
                    if (firstBetList.contains("单")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
                case ZONG_HE_SHUANG:
                    if (firstBetList.contains("双")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //总和尾大小
                case ZONG_HE_WEI_DA:
                    if (tailBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_WEI_XIAO:
                    if (tailBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                    if (longhuBetList.contains("龙")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_HU:

                    if (longhuBetList.contains("虎")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case ER_QIU_DA:
                case SAN_QIU_DA:
                case SI_QIU_DA:
                case WU_QIU_DA:

                    if (singleBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_XIAO:
                case ER_QIU_XIAO:
                case SAN_QIU_XIAO:
                case SI_QIU_XIAO:
                case WU_QIU_XIAO:
                    if (singleBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_DAN:
                case ER_QIU_DAN:
                case SAN_QIU_DAN:
                case SI_QIU_DAN:
                case WU_QIU_DAN:
                    if (singleBetList.contains("单")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case WU_QIU_SHUANG:
                    if (singleBetList.contains("双")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
            }
        }
        return resultList;
    }

    /**
     * 获取双面快3的中奖玩法idlist
     *
     * @param str
     * @return
     */
    private List<Long> getLotteryKuai3DoubleBetPlayIds(String str) {

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
     * 获取双面PK10的中奖玩法idlist
     *
     * @param str
     * @return
     */
    private List<Long> getLotteryPK10DoubleBetPlayIds(String str) {

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
     * 截取时时彩开奖号码
     *
     * @param kj
     * @param lotteryType
     * @return
     */

    private String getRealShiShiCaiKj(String kj, LotteryType lotteryType) {

        String realLotteryKj = kj;
        if (lotteryType instanceof ShishicaiType) {
            ShishicaiType shishicaiType = (ShishicaiType) lotteryType;

            switch (shishicaiType) {

                // 截取四星中奖号
                case SI_XING_ZHI_XUAN_ZU_HE:
                case SI_XING_ZHI_XUAN_DAN_SHI:
                case SI_XING_ZHI_XUAN_FU_SHI:
                case ZU_XUAN_24:
                case ZU_XUAN_12:
                case ZU_XUAN_6:
                case ZU_XUAN_4:
                    realLotteryKj = kj.substring(1, 5);
                    break;

                // 截取三星号码
                case QIAN_SAN_DAN_SHI:
                case QIAN_SAN_FU_SHI:
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_LIU:
                case QIAN_SAN_ZU_SAN:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_DAN_SHI:
                case ZHONG_SAN_FU_SHI:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_DAN_SHI:
                case HOU_SAN_FU_SHI:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZU_LIU:
                case HOU_SAN_ZU_SAN:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(2, 5);
                    break;

                // 二星号码
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(0, 2);
                    break;
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(3, 5);
                    break;

                case QIAN_SAN_YI_MA:
                case QIAN_SAN_ER_MA:

                    realLotteryKj = kj.substring(0, 3);
                    break;
                case HOU_SAN_YI_MA:
                case HOU_SAN_ER_MA:
                    realLotteryKj = kj.substring(2, 5);
                    break;
            }
        } else if (lotteryType instanceof ShishicaiDoubleType) {

            ShishicaiDoubleType shishicaiDoubleType = (ShishicaiDoubleType) lotteryType;

            switch (shishicaiDoubleType) {

                // 截取总和
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_HE:
                    realLotteryKj = kj.substring(0, 5);
                    break;

                // 截取三星号码
                case QIAN_SAN_BAO_ZI:
                case QIAN_SAN_SHUN_ZI:
                case QIAN_SAN_DUI_ZI:
                case QIAN_SAN_BAN_SHUN:
                case QIAN_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_BAO_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case ZHONG_SAN_DUI_ZI:
                case ZHONG_SAN_BAN_SHUN:
                case ZHONG_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_BAO_ZI:
                case HOU_SAN_SHUN_ZI:
                case HOU_SAN_DUI_ZI:
                case HOU_SAN_BAN_SHUN:
                case HOU_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(2, 5);
                    break;

                // 一球号码
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:
                case YI_QIU_DING_WEI_DAN_0:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(0, 1);
                    break;

                // 二球号码
                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:
                case ER_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(1, 2);
                    break;

                // 三球号码
                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:
                case SAN_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(2, 3);
                    break;

                // 四球号码
                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:
                case SI_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(3, 4);
                    break;

                // 五球号码
                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:
                case WU_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(4, 5);
                    break;
            }
        }
        return realLotteryKj;
    }

    /**
     * 整理11选5的开奖号码
     *
     * @param kj
     * @param lotteryType
     * @return
     */
    private List<String> getRealLottery11x5Kj(String kj, LotteryType lotteryType) {

        List<String> resultList = new ArrayList<>();

        List<String> kjList = Arrays.asList(kj.replace(" ", ",").replace("|", ",").split(","));

        if (kjList.size() != 5) {
            return resultList;
        }
        if (lotteryType instanceof Lottery11x5DoubleType) {

            Lottery11x5DoubleType lottery11x5DoubleType = (Lottery11x5DoubleType) lotteryType;
            switch (lottery11x5DoubleType) {

                // 截取总和
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_WEI_DA:
                case ZONG_HE_WEI_XIAO:

                case YI_ZHONG_YI_1:
                case YI_ZHONG_YI_2:
                case YI_ZHONG_YI_3:
                case YI_ZHONG_YI_4:
                case YI_ZHONG_YI_5:
                case YI_ZHONG_YI_6:
                case YI_ZHONG_YI_7:
                case YI_ZHONG_YI_8:
                case YI_ZHONG_YI_9:
                case YI_ZHONG_YI_10:
                case YI_ZHONG_YI_11:

                case LIAN_MA_ER_ZHONG_ER:
                case LIAN_MA_SAN_ZHONG_SAN:
                case LIAN_MA_SI_ZHONG_SI:
                case LIAN_MA_WU_ZHONG_WU:
                case LIAN_MA_LIU_ZHONG_WU:
                case LIAN_MA_QI_ZHONG_WU:
                case LIAN_MA_BA_ZHONG_WU:
                    resultList.addAll(kjList);
                    break;

                // 截取前二号码
                case QIAN_ER_ZU_XUAN:
                case QIAN_ER_ZHI_XUAN:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    break;

                // 截取前三号码
                case QIAN_SAN_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    break;

                // 一球号码
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                case YI_QIU_DING_WEI_DAN_10:
                case YI_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(0));
                    break;

                // 二球号码
                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_10:
                case ER_QIU_DING_WEI_DAN_11:

                    resultList.add(kjList.get(1));
                    break;
                // 三球号码
                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_10:
                case SAN_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(2));
                    break;
                // 四球号码
                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_10:
                case SI_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(3));
                    break;

                // 五球号码
                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_10:
                case WU_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(4));
                    break;
            }
        } else if (lotteryType instanceof Lottery11x5Type) {

            Lottery11x5Type lottery11x5Type = (Lottery11x5Type) lotteryType;
            switch (lottery11x5Type) {

                // 截取总和
                case QIAN_SAN_YI_MA:
                case YI_XING_DING_WEI_DAN:
                case QIAN_SAN_ZHI_XUAN_FU_SHI:
                case QIAN_SAN_ZHI_XUAN_DAN_SHI:
                case QIAN_SAN_ZU_XUAN_FU_SHI:
                case QIAN_SAN_ZU_XUAN_DAN_SHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    break;

                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    break;

                case CAI_ZHONG_WEI_3:
                case CAI_ZHONG_WEI_4:
                case CAI_ZHONG_WEI_5:
                case CAI_ZHONG_WEI_6:
                case CAI_ZHONG_WEI_7:
                case CAI_ZHONG_WEI_8:
                case CAI_ZHONG_WEI_9:

                case DING_DAN_SHUANG_0:
                case DING_DAN_SHUANG_1:
                case DING_DAN_SHUANG_2:
                case DING_DAN_SHUANG_3:
                case DING_DAN_SHUANG_4:
                case DING_DAN_SHUANG_5:

                case DAN_SHI_YI_ZHONG_YI:
                case DAN_SHI_ER_ZHONG_ER:
                case DAN_SHI_SAN_ZHONG_SAN:
                case DAN_SHI_SI_ZHONG_SI:
                case DAN_SHI_WU_ZHONG_WU:
                case DAN_SHI_LIU_ZHONG_WU:
                case DAN_SHI_QI_ZHONG_WU:
                case DAN_SHI_BA_ZHONG_WU:

                case FU_SHI_YI_ZHONG_YI:
                case FU_SHI_ER_ZHONG_ER:
                case FU_SHI_SAN_ZHONG_SAN:
                case FU_SHI_SI_ZHONG_SI:
                case FU_SHI_WU_ZHONG_WU:
                case FU_SHI_LIU_ZHONG_WU:
                case FU_SHI_QI_ZHONG_WU:
                case FU_SHI_BA_ZHONG_WU:

                    resultList.addAll(kjList);
                    break;

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
    private List<String> getRealLotteryKuai3Kj(String kj, LotteryType lotteryType) {

        List<String> resultList = new ArrayList<>();
        if (lotteryType instanceof LotteryKuai3DoubleType) {

            resultList = Arrays.asList(kj.replace(",", "").replace("|", "").trim().split(""));
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
    private List<String> getRealLotteryPK10Kj(String kj, LotteryType lotteryType) {

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

    //TODO 把循环放在switch的里面效率会不会有明显提高？

    /**
     * 时时彩传统盘开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfShishicai(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        kj = getRealShiShiCaiKj(kj.replace(",", "").replace("|", ""), lotteryType);
        String[] kjArr = kj.split("");
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0;// 二等奖次数
            int thirdPrizeNum = 0; // 三等奖次数
            int forthPrizeNum = 0; // 四等奖次数
            int fifthPrizeNum = 0; // 五等奖次数

            Set<String> kjStrList = new HashSet<>();
            ShishicaiType shishicaiType = (ShishicaiType) lotteryType;
            switch (shishicaiType) {

                // 五星直选复式
                case WU_XING_ZHI_XUAN_FU_SHI:
                    if (size == 5) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])
                                && betNumbers.get(3).contains(kjArr[3])
                                && betNumbers.get(4).contains(kjArr[4])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 五星直选单式
                case WU_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case WU_XING_ZHI_XUAN_ZU_HE:
                    if (size == 5) {
                        // 判断是否中五等奖
                        if (betNumbers.get(4).contains(kjArr[4])) {
                            fifthPrizeNum++;
                            // 判断是否中四等奖
                            if (betNumbers.get(3).contains(kjArr[3])) {
                                forthPrizeNum++;
                                // 判断是否中三等奖
                                if (betNumbers.get(2).contains(kjArr[2])) {
                                    thirdPrizeNum++;
                                    // 判断是否中二等奖
                                    if (betNumbers.get(1).contains(kjArr[1])) {
                                        secondPrizeNum++;
                                        // 判断是否中一等奖
                                        if (betNumbers.get(0).contains(kjArr[0])) {
                                            firstPrizeNum++;
                                        }
                                    }
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                        lotteryOrder.setThirdPrizeNum(thirdPrizeNum);
                        lotteryOrder.setForthPrizeNum(forthPrizeNum);
                        lotteryOrder.setFifthPrizeNum(fifthPrizeNum);
                    }
                    continue;

                case ZU_XUAN_120:
                    if (size == 1 && LotteryUtils.checkIsZu120(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {

                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_60:
                    if (size == 2 && LotteryUtils.checkIsZu60(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_30:
                    if (size == 2 && LotteryUtils.checkIsZu30(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).contains(LotteryUtils.getUnDupStr(kj).get(0))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_20:
                    if (size == 2 && LotteryUtils.checkIsZu20(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_10:
                    if (size == 2 && LotteryUtils.checkIsZu10(kj)) {

                        //获取中奖号中的重复3次的字符
                        Set<String> dupStrList = LotteryUtils.getDupStrByDupNum(kj, 3);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getDupStrByDupNum(kj, 2))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case ZU_XUAN_5:
                    if (size == 2 && LotteryUtils.checkIsZu5(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).contains(LotteryUtils.getUnDupStr(kj).get(0))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 四星玩法
                    //四星直选复式
                case SI_XING_ZHI_XUAN_FU_SHI:

                    if (size == 4) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])
                                && betNumbers.get(3).contains(kjArr[3])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 四星直选单式
                case SI_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case SI_XING_ZHI_XUAN_ZU_HE:
                    if (size == 4) {
                        // 判断是否中四等奖
                        if (betNumbers.get(3).contains(kjArr[3])) {
                            forthPrizeNum++;
                            // 判断是否中三等奖
                            if (betNumbers.get(2).contains(kjArr[2])) {
                                thirdPrizeNum++;
                                // 判断是否中二等奖
                                if (betNumbers.get(1).contains(kjArr[1])) {
                                    secondPrizeNum++;
                                    // 判断是否中一等奖
                                    if (betNumbers.get(0).contains(kjArr[0])) {
                                        firstPrizeNum++;
                                    }
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                        lotteryOrder.setThirdPrizeNum(thirdPrizeNum);
                        lotteryOrder.setForthPrizeNum(forthPrizeNum);
                    }
                    continue;

                case ZU_XUAN_24:
                    if (size == 1 && LotteryUtils.checkIsZu24(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {

                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_12:
                    if (size == 2 && LotteryUtils.checkIsZu12(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_6:
                    if (size == 1 && LotteryUtils.checkIsZu6(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_4:
                    if (size == 2 && LotteryUtils.checkIsZu4(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星玩法
                    //三星复式
                case QIAN_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case HOU_SAN_FU_SHI:

                    if (size == 3) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星单式
                case QIAN_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case HOU_SAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星直选和值
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //三星组三
                case QIAN_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_SAN:
                case HOU_SAN_ZU_SAN:
                    if (size == 1 && LotteryUtils.checkIsZu3(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList) && betNumbers.get(0).containsAll(unDupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //三星组六
                case QIAN_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case HOU_SAN_ZU_LIU:
                    if (size == 1 && LotteryUtils.checkIsSanxingZu6(kj)) {

                        //判断中奖号中的非重复字符是否全部选中
                        if (betNumbers.get(0).containsAll(LotteryUtils.getUnDupStr(kj))) {
                            firstPrizeNum = 1;
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星组选和值
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    if (size == 1 && LotteryUtils.checkIsSanxingZuHe(kj)) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {

                            //判断是否中组三一等奖
                            if (LotteryUtils.checkIsZu3(kj)) {
                                firstPrizeNum = 1;
                            }
                            //判断是否中三星组六一等奖
                            else if (LotteryUtils.checkIsSanxingZu6(kj)) {
                                secondPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                    }
                    continue;

                    // 三星混合组选
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                    // 获取注单号码
                    if (size == 1) {
                        List<List<String>> betNumberList = getSanxingBetNumbers(betNumbers);

                        if (LotteryUtils.checkIsZu3(kj)) {
                            for (List<String> betNumber : betNumberList) {
                                StringBuilder orderNumber = new StringBuilder();
                                for (String bet : betNumber) {
                                    orderNumber.append(bet);
                                }
                                if (betNumber.size() != 3 || !LotteryUtils.checkIsZu3(orderNumber.toString())) {
                                    continue;
                                }
                                // 判断是否中组三一等奖(判断重复位和非重复位分别是否相等)
                                if (LotteryUtils.getDupStrByDupNum(betNumber.toString(), 2).containsAll(LotteryUtils.getDupStr(kj))
                                        && betNumber.containsAll(LotteryUtils.getUnDupStr(kj))) {
                                    firstPrizeNum++;
                                }
                            }
                        } else if (LotteryUtils.checkIsSanxingZu6(kj)) {
                            for (List<String> betNumber : betNumberList) {

                                // 判断是否中组三一等奖(判断重复位和非重复位分别是否相等)
                                if (betNumber.containsAll(LotteryUtils.getUnDupStr(kj))) {
                                    secondPrizeNum++;
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                    }
                    continue;

                    // 二星
                    //二星直选复式
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:

                    if (size == 2) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                ) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:

                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //二星组选复式
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                    if (size == 1 && LotteryUtils.checkIsErxingFuShi(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //二星组合单式
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                    if (size == 1 && LotteryUtils.checkIsErxingFuShi(kj)) {
                        String anotherKj = kjArr[1] + kjArr[0];
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && (betNumber.equals(kj) || betNumber.equals(anotherKj))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星直选和值
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星组选和值
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    if (size == 1 && LotteryUtils.checkIsErxingFuShi(kj)) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一星定位胆
                case YI_XING_DING_WEI_DAN:

                    for (int i = 0; i < betNumbers.size(); i++) {
                        if (betNumbers.get(i) != null && betNumbers.get(i).size() > 0 && betNumbers.get(i).contains(kjArr[i])) {
                            firstPrizeNum++;
                        }
                    }

                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //一码不定胆
                case QIAN_SAN_YI_MA:
                case HOU_SAN_YI_MA:

                    if (size == 1) {
                        //TODO 是否需要优化
                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        for (String betNumber : betNumbers.get(0)) {
                            if (dupStrList.contains(betNumber) || unDupStrList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二码不定胆
                case QIAN_SAN_ER_MA:
                case HOU_SAN_ER_MA:

                    //先判断是不是豹子号
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kj, 3).size() == 0) {

                        int betNum = 0; // 中奖号码数
                        for (String betNumber : betNumbers.get(0)) {
                            if (kj.contains(betNumber)) {
                                betNum++;
                            }
                        }
                        if (betNum >= 2) {
                            firstPrizeNum = (int) LotteryUtils.combination(betNum, 2);
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //前二码大小单双
                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                    if (betNumbers.size() == 2) {

                        int firstBetNum = 0;
                        int secondBetNum = 0;
                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[0]), 9);
                        //获取中奖号的第二个号码的大小单双
                        List<String> secondBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[1]), 9);

                        for (String kjNo : firstBetList) {
                            if (betNumbers.get(0).contains(kjNo)) {
                                firstBetNum++;
                            }
                        }
                        for (String kjNo : secondBetList) {
                            if (betNumbers.get(1).contains(kjNo)) {
                                secondBetNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstBetNum * secondBetNum);
                    }
                    continue;

                    //后二码大小单双
                case HOU_ER_DA_XIAO_DAN_SHUANG:

                    if (betNumbers.size() == 2) {

                        int firstBetNum = 0;
                        int secondBetNum = 0;
                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[3]), 9);
                        //获取中奖号的第二个号码的大小单双
                        List<String> secondBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[4]), 9);

                        for (String kjNo : firstBetList) {
                            if (betNumbers.get(0).contains(kjNo)) {
                                firstBetNum++;
                            }
                        }
                        for (String kjNo : secondBetList) {
                            if (betNumbers.get(1).contains(kjNo)) {
                                secondBetNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstBetNum * secondBetNum);
                    }
                    continue;

                    //总和大小单双
                case ZONG_HE_DA_XIAO_DAN_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 45);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一帆风顺
                case YI_FAN_FENG_SHUN:

                    for (String betNumber : betNumbers.get(0)) {
                        if (kj.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //好事成双
                case HAO_SHI_CHENG_SHUANG:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 2);
                    if (kjStrList.size() == 0) {
                        continue;
                    }

                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //三星报喜
                case SAN_XING_BAO_XI:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 3);
                    if (kjStrList.size() == 0) {
                        continue;
                    }
                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
                    //四季发财
                case SI_JI_FA_CAI:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 4);
                    if (kjStrList.size() == 0) {
                        continue;
                    }
                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
            }
        }
        return lotteryOrderList;
    }


    /**
     * 时时彩双面盘开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfShishicaiDouble(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        kj = getRealShiShiCaiKj(kj.replace(",", "").replace("|", ""), lotteryType);
        String[] kjArr = kj.split("");
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            ShishicaiDoubleType shishicaiType = (ShishicaiDoubleType) lotteryType;
            switch (shishicaiType) {

                //总和大小单双
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取总和的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 45);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_HE:

                    if (betNumbers.size() == 1 && kjArr.length == 5) {

                        //获取中奖号的龙虎和信息
                        List<String> firstBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjArr[0]), Integer.parseInt(kjArr[4]));

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:

                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:

                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:

                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:

                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 9);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单球定位模式
                case YI_QIU_DING_WEI_DAN_0:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:

                case ER_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:

                case SAN_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:

                case SI_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:

                case WU_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        for (String betNumber : betNumbers.get(0)) {
                            if (kj.contains(betNumber) || kj.equals(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 特殊玩法模式
                case QIAN_SAN_BAO_ZI:
                case QIAN_SAN_SHUN_ZI:
                case QIAN_SAN_DUI_ZI:
                case QIAN_SAN_BAN_SHUN:
                case QIAN_SAN_ZA_LIU:

                case ZHONG_SAN_BAO_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case ZHONG_SAN_DUI_ZI:
                case ZHONG_SAN_BAN_SHUN:
                case ZHONG_SAN_ZA_LIU:

                case HOU_SAN_BAO_ZI:
                case HOU_SAN_SHUN_ZI:
                case HOU_SAN_DUI_ZI:
                case HOU_SAN_BAN_SHUN:
                case HOU_SAN_ZA_LIU:

                    if (size == 1) {
                        //获取中奖号码的的特殊玩法值
                        List<String> firstBetList = LotteryUtils.getDoubleTeShuWanFaList(kj);
                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
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
     * 11选5传统盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfLottery11x5(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLottery11x5Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Lottery11x5Type Lottery11x5Type = (Lottery11x5Type) lotteryType;
            switch (Lottery11x5Type) {

                // 复式玩法
                //前三直选复式
                case QIAN_SAN_ZHI_XUAN_FU_SHI:

                    if (size == 3) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二直选复式
                case QIAN_ER_ZHI_XUAN_FU_SHI:

                    if (size == 2) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                ) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前三组选复式
                case QIAN_SAN_ZU_XUAN_FU_SHI:
                    //前二组选复式
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    if (size == 1) {

                        //获取中奖号中的非重复字符
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    // 单式玩法
                    // 前三组选单式
                case QIAN_SAN_ZU_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 前二组选单式
                case QIAN_ER_ZU_XUAN_DAN_SHI:

                    if (size == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //前三直选单式
                case QIAN_SAN_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (stringList.get(0).contains(kjList.get(0))
                                    && stringList.get(1).contains(kjList.get(1))
                                    && stringList.get(2).contains(kjList.get(2))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:

                    if (size == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (stringList.get(0).contains(kjList.get(0))
                                    && stringList.get(1).contains(kjList.get(1))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一星定位胆
                case YI_XING_DING_WEI_DAN:

                    for (int i = 0; i < betNumbers.size(); i++) {
                        if (betNumbers.get(i) != null && betNumbers.get(i).size() > 0 && betNumbers.get(i).contains(kjList.get(i))) {
                            firstPrizeNum++;
                        }
                    }

                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //一码不定胆
                case QIAN_SAN_YI_MA:

                    if (size == 1) {

                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 定单双
                case DING_DAN_SHUANG_0:
                case DING_DAN_SHUANG_1:
                case DING_DAN_SHUANG_2:
                case DING_DAN_SHUANG_3:
                case DING_DAN_SHUANG_4:
                case DING_DAN_SHUANG_5:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的大小单双
                        String dingDSStr = LotteryUtils.getDingDanShuangString(kjList);

                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(dingDSStr)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //猜中位
                case CAI_ZHONG_WEI_3:
                case CAI_ZHONG_WEI_4:
                case CAI_ZHONG_WEI_5:
                case CAI_ZHONG_WEI_6:
                case CAI_ZHONG_WEI_7:
                case CAI_ZHONG_WEI_8:
                case CAI_ZHONG_WEI_9:

                    if (betNumbers.size() == 1) {

                        //获取开奖号码的中位号
                        String dingDSStr = LotteryUtils.getCaiZhongWeiString(kjList);

                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(dingDSStr)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式一中一
                case FU_SHI_YI_ZHONG_YI:
                    // 单式一中一
                case DAN_SHI_YI_ZHONG_YI:
                    if (betNumbers.size() == 1) {

                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式二中二
                case FU_SHI_ER_ZHONG_ER:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                    // 单式二中二
                case DAN_SHI_ER_ZHONG_ER:
                    if (betNumbers.size() == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式三中三
                case FU_SHI_SAN_ZHONG_SAN:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 3);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                    // 单式三中三
                case DAN_SHI_SAN_ZHONG_SAN:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式四中四
                case FU_SHI_SI_ZHONG_SI:

                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 4);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式四中四
                case DAN_SHI_SI_ZHONG_SI:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 4);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 4) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式五中五
                case FU_SHI_WU_ZHONG_WU:
                    if (betNumbers.size() == 1) {
                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式六中五
                case FU_SHI_LIU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 1) * firstPrizeNum);
                    }
                    continue;

                    // 单式五中五
                case DAN_SHI_WU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 5);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 5) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式六中五
                case DAN_SHI_LIU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 6);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 6) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式七中五
                case DAN_SHI_QI_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 7);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 7) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单式八中五
                case DAN_SHI_BA_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 8);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 8) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式七中五
                case FU_SHI_QI_ZHONG_WU:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 2) * firstPrizeNum);
                    }
                    continue;

                case FU_SHI_BA_ZHONG_WU:

                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 3) * firstPrizeNum);
                    }
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 11选5双面盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfLottery11x5Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLottery11x5Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Lottery11x5DoubleType lottery11x5DoubleType = (Lottery11x5DoubleType) lotteryType;
            switch (lottery11x5DoubleType) {

                //总和大小单双
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:

                    if (betNumbers.size() == 1) {

                        if (LotteryUtils.getStrSum(kjList) == 30) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的总和的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60, 30);

                            for (String betNumber : betNumbers.get(0)) {
                                if (firstBetList.contains(betNumber)) {
                                    firstPrizeNum++;
                                }
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                    }
                    continue;

                    //总和尾大小
                case ZONG_HE_WEI_DA:
                case ZONG_HE_WEI_XIAO:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的总和的尾数单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList) % 10, 9);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                case ZONG_HE_HU:

                    if (betNumbers.size() == 1 && kjList.size() == 5) {

                        //获取中奖号的龙虎和信息
                        List<String> firstBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(4)));

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:

                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:

                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:

                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:

                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:

                    if (betNumbers.size() == 1) {

                        if (LotteryUtils.getStrSum(kjList) == 11) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 11, 11);

                            for (String betNumber : betNumbers.get(0)) {
                                if (firstBetList.contains(betNumber)) {
                                    firstPrizeNum++;
                                }
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                    }
                    continue;

                    // 单球定位模式
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                case YI_QIU_DING_WEI_DAN_10:
                case YI_QIU_DING_WEI_DAN_11:

                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_10:
                case ER_QIU_DING_WEI_DAN_11:

                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_10:
                case SAN_QIU_DING_WEI_DAN_11:

                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_10:
                case SI_QIU_DING_WEI_DAN_11:

                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_10:
                case WU_QIU_DING_WEI_DAN_11:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一中一玩法
                case YI_ZHONG_YI_1:
                case YI_ZHONG_YI_2:
                case YI_ZHONG_YI_3:
                case YI_ZHONG_YI_4:
                case YI_ZHONG_YI_5:
                case YI_ZHONG_YI_6:
                case YI_ZHONG_YI_7:
                case YI_ZHONG_YI_8:
                case YI_ZHONG_YI_9:
                case YI_ZHONG_YI_10:
                case YI_ZHONG_YI_11:

                    //连码玩法
                case LIAN_MA_ER_ZHONG_ER:
                case LIAN_MA_SAN_ZHONG_SAN:
                case LIAN_MA_SI_ZHONG_SI:
                case LIAN_MA_WU_ZHONG_WU:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //连码玩法（从上面拆分出来提高效率）
                case LIAN_MA_LIU_ZHONG_WU:
                case LIAN_MA_QI_ZHONG_WU:
                case LIAN_MA_BA_ZHONG_WU:
                    // 组选模式
                case QIAN_ER_ZU_XUAN:
                case QIAN_SAN_ZU_XUAN:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 直选模式
                case QIAN_ER_ZHI_XUAN:
                case QIAN_SAN_ZHI_XUAN:

                    //获取中奖号码的的特殊玩法值
                    if (kjList.size() != betNumbers.size()) {
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    } else {
                        firstPrizeNum = 1;
                        for (int i = 0; i < kjList.size(); i++) {
                            if (!betNumbers.get(i).contains(kjList.get(i))) {
                                firstPrizeNum = 0;
                                break;
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
     * 快3传统开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfLotteryKuai3(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

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
    private List<UserOrderPO> getBoundsInfoOfLotteryKuai3Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

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

                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjNo, 3).size() == 0) {

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
                        Set<String> stringSet = LotteryUtils.getDupStrByDupNum(kjNo, 3);
                        if (stringSet.size() != 0 && stringSet.containsAll(betNumbers.get(0))) {
                            firstPrizeNum = 1;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 全骰
                case QUAN_SHAI:

                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjNo, 3).size() == 1) {
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
                    if (betNumbers.size() == 1 && LotteryUtils.getDupStrByDupNum(kjNo, 3).size() == 0) {

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
     * PK10传统开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfLotteryPK10(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

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
    private List<UserOrderPO> getBoundsInfoOfLotteryPK10Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

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
     * 获取注单号码列表  --支持类型 (五星直选单式,四星直选单式,三星直选单式)
     *
     * @param lotteryType
     * @param betNumbers
     * @return
     */
    private List<String> getBetNumbers(LotteryType lotteryType, List<List<String>> betNumbers) {

        if (lotteryType instanceof ShishicaiType) {

            // 如果类型属于五星
            ShishicaiType shishicaiType = (ShishicaiType) lotteryType;
            switch (shishicaiType) {

                // 五星直选单式
                case WU_XING_ZHI_XUAN_DAN_SHI:
                    return LotteryUtils.getSubStrList(betNumbers.get(0), 5);

                // 四星直选单式
                case SI_XING_ZHI_XUAN_DAN_SHI:
                    return LotteryUtils.getSubStrList(betNumbers.get(0), 4);

                // 三星直选单式
                case QIAN_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case HOU_SAN_DAN_SHI:

                    // 三星混合组选
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                    return LotteryUtils.getSubStrList(betNumbers.get(0), 3);

                // 二星直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                    // 二星混合组选
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                    return LotteryUtils.getSubStrList(betNumbers.get(0), 2);
            }
        }
        return new ArrayList<String>();
    }

    /**
     * 获取注单号码列表  --支持类型 (三星混合组选)
     *
     * @param betNumbers
     * @return
     */
    private List<List<String>> getSanxingBetNumbers(List<List<String>> betNumbers) {

        return LotteryUtils.getStrListForSanxing(betNumbers.get(0), 3);
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
