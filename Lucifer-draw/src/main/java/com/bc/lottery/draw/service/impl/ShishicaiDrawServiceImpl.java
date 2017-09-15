package com.bc.lottery.draw.service.impl;

import com.babel.venus.po.UserOrder;
import com.bc.lottery.draw.service.LotteryDrawHandle;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;
import com.bc.lottery.util.LotteryUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luis on 2017/4/14.
 */

public class ShishicaiDrawServiceImpl implements LotteryDrawHandle, ShishicaiType {

    private static final int[] ZHI_XUAN_KUA_DU = {10, 54, 96, 126, 144, 150, 144, 126, 96, 54};

    private static final int[] SAN_XING_ZHI_XUAN_HE_ZHI = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    private static final int[] SAN_XING_ZU_XUAN_HE_ZHI = {0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1};

    private static final int[] ER_XING_ZHI_XUAN_HE_ZHI = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] ER_XING_ZU_XUAN_HE_ZHI = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1};

    @Override
    public UserOrder getBoundsInfoOfLottery(String kj, UserOrder order) {

        if (kj.length() != 5) {
            return null;
        }
        List<UserOrder> lotteryOrderList = new ArrayList<>();
//        UserOrder lotteryOrder = new UserOrder();
//        lotteryOrder.setBetContentProc(order.getBetContentProc());
        lotteryOrderList.add(order);

        // 如果类型属于五星
        if (order.getLotteryType() instanceof Wuxing) {

            return getBoundsInfoOfWuxing(order.getLotteryType(), kj, lotteryOrderList).get(0);
        }
        // 如果类型属于四星
        else if (order.getLotteryType() instanceof Sixing) {

            // 截取四星中奖号
            String realSixingKj = kj.substring(1, 5);
            return getBoundsInfoOfSixing(order.getLotteryType(), realSixingKj, lotteryOrderList).get(0);
        }
        // 如果类型属于三星
        else if (order.getLotteryType() instanceof Sanxing) {

            // 截取三星中奖号
            String realSanxingKj = "";
            Sanxing sanxingType = (Sanxing) order.getLotteryType();
            switch (sanxingType) {

                case QIAN_SAN_DAN_SHI:
                case QIAN_SAN_FU_SHI:
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_LIU:
                case QIAN_SAN_ZU_SAN:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_DAN_SHI:
                case ZHONG_SAN_FU_SHI:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_DAN_SHI:
                case HOU_SAN_FU_SHI:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZU_LIU:
                case HOU_SAN_ZU_SAN:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(2, 5);
                    break;
            }
            getBoundsInfoOfSanxing(order.getLotteryType(), realSanxingKj, lotteryOrderList);
            return lotteryOrderList.get(0);
        }

        // 如果类型属于二星
        else if (order.getLotteryType() instanceof Erxing) {

            // 截取二星中奖号
            String realErxingKj = "";
            Erxing erxingType = (Erxing) order.getLotteryType();
            switch (erxingType) {

                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                    realErxingKj = kj.substring(0, 2);
                    break;
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    realErxingKj = kj.substring(3, 5);
                    break;

            }
            return getBoundsInfoOfErxing(order.getLotteryType(), realErxingKj, lotteryOrderList).get(0);
        }

        // 如果类型属于一星
        else if (order.getLotteryType() instanceof Yixing) {

            return getBoundsInfoOfYixing(order.getLotteryType(), kj, lotteryOrderList).get(0);
        }
        // 如果类型属于不定胆
        else if (order.getLotteryType() instanceof Budingdan) {

            // 截取三星中奖号
            String realBudingdanKj = "";
            Budingdan budingdanType = (Budingdan) order.getLotteryType();
            switch (budingdanType) {

                case QIAN_SAN_YI_MA:
                case QIAN_SAN_ER_MA:

                    realBudingdanKj = kj.substring(0, 3);
                    break;
                case HOU_SAN_YI_MA:
                case HOU_SAN_ER_MA:
                    realBudingdanKj = kj.substring(2, 5);
                    break;

            }
            return getBoundsInfoOfBudingdan(order.getLotteryType(), realBudingdanKj, lotteryOrderList).get(0);
        }
        // 如果类型属于大小单双
        else if (order.getLotteryType() instanceof Daxiaodanshuang) {
            return getBoundsInfoOfDaxiaodanshuang(order.getLotteryType(), kj, lotteryOrderList).get(0);

        }
        // 如果类型属于趣味玩法
        else if (order.getLotteryType() instanceof Quwei) {
            return getBoundsInfoOfQuwei(order.getLotteryType(), kj, lotteryOrderList).get(0);
        }
        return order;
    }

    @Override
    public List<UserOrder> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        if (kj.length() != 5 || lotteryOrderList.size() == 0) {
            return null;
        }
        // 如果类型属于五星
        if (lotteryType instanceof Wuxing) {
            return getBoundsInfoOfWuxing(lotteryType, kj, lotteryOrderList);
        }
        // 如果类型属于四星
        else if (lotteryType instanceof Sixing) {
            // 截取四星中奖号
            String realSixingKj = kj.substring(1, 5);
            return getBoundsInfoOfSixing(lotteryType, realSixingKj, lotteryOrderList);
        }
        // 如果类型属于三星
        else if (lotteryType instanceof Sanxing) {

            // 截取三星中奖号
            String realSanxingKj = "";
            Sanxing sanxingType = (Sanxing) lotteryType;
            switch (sanxingType) {

                case QIAN_SAN_DAN_SHI:
                case QIAN_SAN_FU_SHI:
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_LIU:
                case QIAN_SAN_ZU_SAN:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_DAN_SHI:
                case ZHONG_SAN_FU_SHI:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_DAN_SHI:
                case HOU_SAN_FU_SHI:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZU_LIU:
                case HOU_SAN_ZU_SAN:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    realSanxingKj = kj.substring(2, 5);
                    break;
            }
            return getBoundsInfoOfSanxing(lotteryType, realSanxingKj, lotteryOrderList);
        }
        // 如果类型属于二星
        else if (lotteryType instanceof Erxing) {

            // 截取二星中奖号
            String realErxingKj = "";
            Erxing erxingType = (Erxing) lotteryType;
            switch (erxingType) {

                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                    realErxingKj = kj.substring(0, 2);
                    break;
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    realErxingKj = kj.substring(3, 5);
                    break;

            }
            return getBoundsInfoOfErxing(lotteryType, realErxingKj, lotteryOrderList);
        }
        // 如果类型属于一星
        else if (lotteryType instanceof Yixing) {
            return getBoundsInfoOfYixing(lotteryType, kj, lotteryOrderList);
        }
        // 如果类型属于不定胆
        else if (lotteryType instanceof Budingdan) {

            // 截取三星中奖号
            String realBudingdanKj = "";
            Budingdan budingdanType = (Budingdan) lotteryType;
            switch (budingdanType) {

                case QIAN_SAN_YI_MA:
                case QIAN_SAN_ER_MA:

                    realBudingdanKj = kj.substring(0, 3);
                    break;
                case HOU_SAN_YI_MA:
                case HOU_SAN_ER_MA:
                    realBudingdanKj = kj.substring(2, 5);
                    break;
            }
            return getBoundsInfoOfBudingdan(lotteryType, realBudingdanKj, lotteryOrderList);
        }
        // 如果类型属于大小单双
        else if (lotteryType instanceof Daxiaodanshuang) {

            return getBoundsInfoOfDaxiaodanshuang(lotteryType, kj, lotteryOrderList);
            // 如果类型属于趣味玩法
        } else if (lotteryType instanceof Quwei) {
            return getBoundsInfoOfQuwei(lotteryType, kj, lotteryOrderList);
        }
        return lotteryOrderList;
    }

    //TODO 把循环放在switch的里面效率会不会有明显提高？

    /**
     * 五星开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfWuxing(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0;// 二等奖次数
            int thirdPrizeNum = 0; // 三等奖次数
            int forthPrizeNum = 0; // 四等奖次数
            int fifthPrizeNum = 0; // 五等奖次数

            // 如果类型属于五星
            Wuxing wuxingType = (Wuxing) lotteryType;
            switch (wuxingType) {

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
//                    boundsInfoList.add(boundsInfo);
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

//                    boundsInfoList.add(boundsInfo);
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

//                    boundsInfoList.add(boundsInfo);
                    continue;

                case ZU_XUAN_120:
                    if (size == 1 && checkIsZu120(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {

                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

//                    boundsInfoList.add(boundsInfo);
                    continue;

                case ZU_XUAN_60:
                    if (size == 2 && checkIsZu60(kj)) {

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
//                    boundsInfoList.add(boundsInfo);
                    continue;

                case ZU_XUAN_30:
                    if (size == 2 && checkIsZu30(kj)) {

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
//                    boundsInfoList.add(boundsInfo);
                    continue;

                case ZU_XUAN_20:
                    if (size == 2 && checkIsZu20(kj)) {

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
//                    boundsInfoList.add(boundsInfo);
                    continue;

                case ZU_XUAN_10:
                    if (size == 2 && checkIsZu10(kj)) {

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
//                    boundsInfoList.add(boundsInfo);
                    continue;
                case ZU_XUAN_5:
                    if (size == 2 && checkIsZu5(kj)) {

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
//                    boundsInfoList.add(boundsInfo);
                    continue;
//                default:
//
//                    boundsInfoList.add(boundsInfo);
//                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 四星开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfSixing(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0;// 二等奖次数
            int thirdPrizeNum = 0; // 三等奖次数
            int forthPrizeNum = 0; // 四等奖次数

            // 如果类型属于四星
            if (lotteryType instanceof Sixing) {
                Sixing sixingType = (Sixing) lotteryType;
                switch (sixingType) {

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
//                        boundsInfoList.add(boundsInfo);
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

//                        boundsInfoList.add(boundsInfo);
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

//                        boundsInfoList.add(boundsInfo);
                        continue;

                    case ZU_XUAN_24:
                        if (size == 1 && checkIsZu24(kj)) {

                            //获取中奖号中的非重复字符
                            List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                            if (betNumbers.get(0).containsAll(unDupStrList)) {

                                firstPrizeNum = 1;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
//                        boundsInfoList.add(boundsInfo);
                        continue;

                    case ZU_XUAN_12:
                        if (size == 2 && checkIsZu12(kj)) {

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
//                        boundsInfoList.add(boundsInfo);
                        continue;

                    case ZU_XUAN_6:
                        if (size == 1 && checkIsZu6(kj)) {

                            //获取中奖号中的重复字符
                            Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                            if (betNumbers.get(0).containsAll(dupStrList)) {
                                firstPrizeNum = 1;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
//                        boundsInfoList.add(boundsInfo);
                        continue;

                    case ZU_XUAN_4:
                        if (size == 2 && checkIsZu4(kj)) {

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
//                        boundsInfoList.add(boundsInfo);
                        continue;

//                    default:
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 三星开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfSanxing(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();

        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0;// 二等奖次数

            // 如果类型属于三星
            if (lotteryType instanceof Sanxing) {
                Sanxing sanxingType = (Sanxing) lotteryType;
                switch (sanxingType) {

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
//                        boundsInfoList.add(boundsInfo);
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
//                        boundsInfoList.add(boundsInfo);
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
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        //三星组三
                    case QIAN_SAN_ZU_SAN:
                    case ZHONG_SAN_ZU_SAN:
                    case HOU_SAN_ZU_SAN:
                        if (size == 1 && checkIsZu3(kj)) {

                            //获取中奖号中的重复字符
                            Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                            //获取中奖号中的非重复字符
                            List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                            if (betNumbers.get(0).containsAll(dupStrList) && betNumbers.get(0).containsAll(unDupStrList)) {
                                firstPrizeNum = 1;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        //三星组六
                    case QIAN_SAN_ZU_LIU:
                    case ZHONG_SAN_ZU_LIU:
                    case HOU_SAN_ZU_LIU:
                        if (size == 1 && checkIsSanxingZu6(kj)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(0).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }

                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        // 三星组选和值
                    case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    case HOU_SAN_ZU_XUAN_HE_ZHI:
                        if (size == 1 && checkIsSanxingZuHe(kj)) {
                            //判断中奖号码是否包含在所选的各组号码中
                            if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {

                                //判断是否中组三一等奖
                                if (checkIsZu3(kj)) {
                                    firstPrizeNum = 1;
                                }
                                //判断是否中三星组六一等奖
                                else if (checkIsSanxingZu6(kj)) {
                                    secondPrizeNum = 1;
                                }
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                            lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                        }
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        // 三星混合组选
                    case QIAN_SAN_HUN_HE_ZU_XUAN:
                    case ZHONG_SAN_HUN_HE_ZU_XUAN:
                    case HOU_SAN_HUN_HE_ZU_XUAN:
                        // 获取注单号码
                        if (size == 1) {
                            List<List<String>> betNumberList = getSanxingBetNumbers(betNumbers);

                            if (checkIsZu3(kj)) {
                                for (List<String> betNumber : betNumberList) {
                                    // 判断是否中组三一等奖(判断重复位和非重复位分别是否相等)
                                    if (betNumber.containsAll(LotteryUtils.getDupStr(kj))
                                            && betNumber.containsAll(LotteryUtils.getUnDupStr(kj))) {
                                        firstPrizeNum++;
                                    }
                                }
                            } else if (checkIsSanxingZu6(kj)) {
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
//                        boundsInfoList.add(boundsInfo);
                        continue;
//                    default:
//
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 二星开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfErxing(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();
        if (kj.length() != 2) {
            return null;
        }
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            // 如果类型属于二星
            if (lotteryType instanceof Erxing) {
                Erxing erxingType = (Erxing) lotteryType;
                switch (erxingType) {

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
                        if (size == 1 && checkIsErxingFuShi(kj)) {

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
                        if (size == 1 && checkIsErxingFuShi(kj)) {
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
                        if (size == 1 && checkIsErxingFuShi(kj)) {
                            //判断中奖号码是否包含在所选的各组号码中
                            if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                                firstPrizeNum = 1;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                        continue;

                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 一星开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfYixing(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            // 开奖号码必须为size=5的列表，如果不选，则传空list
            int size = betNumbers.size();
            if (size != 5) {
                continue;
            }

            int firstPrizeNum = 0; // 一等奖次数

            // 如果类型属于一星
            if (lotteryType instanceof Yixing) {
                Yixing yixingType = (Yixing) lotteryType;
                switch (yixingType) {

                    //一星定位胆
                    case YI_XING_DING_WEI_DAN:

                        for (int i = 0; i < betNumbers.size(); i++) {
                            if (betNumbers.get(i) != null && betNumbers.get(i).size() > 0 && betNumbers.get(i).contains(kjArr[i])) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
//                        boundsInfoList.add(boundsInfo);
                        continue;

//                    default:
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 不定胆开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */

    private List<UserOrder> getBoundsInfoOfBudingdan(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

//        List<UserOrder > boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder ();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            //String[] kjArr = kj.split("");
            // 如果类型属于不定胆
            if (lotteryType instanceof Budingdan) {
                Budingdan budingdanType = (Budingdan) lotteryType;
                switch (budingdanType) {

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
//                        boundsInfoList.add(boundsInfo);
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
//                        boundsInfoList.add(boundsInfo);
                        continue;
//                    default:
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 大小单双开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */

    private List<UserOrder> getBoundsInfoOfDaxiaodanshuang(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

        String[] kjArr = kj.split("");
//        List<UserOrder> boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int firstPrizeNum = 0; // 一等奖次数

            // 如果类型属于大小单双
            if (lotteryType instanceof Daxiaodanshuang) {
                Daxiaodanshuang daxiaodanshuangType = (Daxiaodanshuang) lotteryType;
                switch (daxiaodanshuangType) {

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
//                        boundsInfoList.add(boundsInfo);
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
//                        boundsInfoList.add(boundsInfo);
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
//                        boundsInfoList.add(boundsInfo);
                        continue;
//                    default:
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
            }
        }
        return lotteryOrderList;
    }

    /**
     * 趣味开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrder> getBoundsInfoOfQuwei(LotteryType lotteryType, String kj, List<UserOrder> lotteryOrderList) {

//        List<UserOrder> boundsInfoList = new ArrayList<>();
        for (UserOrder lotteryOrder : lotteryOrderList) {

//            UserOrder boundsInfo = new UserOrder();
//            boundsInfo.setLotteryType(lotteryType);
//            boundsInfo.setMultiple(lotteryOrder.getMultiple());
//            boundsInfo.setOrderId(lotteryOrder.getOrderId());

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();
            if (kj.length() != 5 || betNumbers.size() != 1) {
//                boundsInfoList.add(boundsInfo);
                continue;
            }

            int firstPrizeNum = 0; // 一等奖次数

            Set<String> kjStrList = new HashSet<>();
            // 如果类型属于趣味
            if (lotteryType instanceof Quwei) {
                Quwei quweiType = (Quwei) lotteryType;
                switch (quweiType) {

                    //一帆风顺
                    case YI_FAN_FENG_SHUN:

                        for (String betNumber : betNumbers.get(0)) {
                            if (kj.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        //好事成双
                    case HAO_SHI_CHENG_SHUANG:

                        kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 2);
                        if (kjStrList.size() == 0) {
//                            boundsInfoList.add(boundsInfo);
                            continue;
                        }

                        for (String betNumber : betNumbers.get(0)) {
                            if (kjStrList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
//                        boundsInfoList.add(boundsInfo);
                        continue;

                        //三星报喜
                    case SAN_XING_BAO_XI:

                        kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 3);
                        if (kjStrList.size() == 0) {
//                            boundsInfoList.add(boundsInfo);
                            continue;
                        }
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjStrList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
//                        boundsInfoList.add(boundsInfo);
                        continue;
                        //四季发财
                    case SI_JI_FA_CAI:

                        kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 4);
                        if (kjStrList.size() == 0) {
//                            boundsInfoList.add(boundsInfo);
                            continue;
                        }
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjStrList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
//                        boundsInfoList.add(boundsInfo);
                        continue;
//                    default:
//                        boundsInfoList.add(boundsInfo);
//                        continue;
                }
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

//        List<String> betNumberList = new ArrayList<>();
        // 如果类型属于五星
        if (lotteryType instanceof Wuxing) {
            Wuxing wuxingType = (Wuxing) lotteryType;
            switch (wuxingType) {

                // 五星直选单式
                case WU_XING_ZHI_XUAN_DAN_SHI:

                    return LotteryUtils.getSubStrList(betNumbers.get(0), 5);
            }
        }
        // 如果类型属于四星
        if (lotteryType instanceof Sixing) {
            Sixing sixingType = (Sixing) lotteryType;
            switch (sixingType) {

                // 四星直选单式
                case SI_XING_ZHI_XUAN_DAN_SHI:

                    return LotteryUtils.getSubStrList(betNumbers.get(0), 4);
            }
        }
        // 如果类型属于三星
        if (lotteryType instanceof Sanxing) {
            Sanxing sanxingType = (Sanxing) lotteryType;
            switch (sanxingType) {

                // 三星直选单式
                case QIAN_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case HOU_SAN_DAN_SHI:

                    // 三星混合组选
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_HUN_HE_ZU_XUAN:

                    return LotteryUtils.getSubStrList(betNumbers.get(0), 3);

            }
        }

        // 如果类型属于二星
        if (lotteryType instanceof Erxing) {
            Erxing erxingType = (Erxing) lotteryType;
            switch (erxingType) {

                // 二星直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                    // 二星混合组选
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:

                    return LotteryUtils.getSubStrList(betNumbers.get(0), 2);
            }
        }

        return null;
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

    /**
     * 判断中奖号是否满足组120规则
     *
     * @param kjStr
     * @return
     */

    private boolean checkIsZu120(String kjStr) {
        // TODO 可用正则优化  /^(\d),\1,\1/
        //return !kjStr.matches("/^(\\d),\\1,\\1/") && !LotteryUtils.checkDifferent(kjStr);

        return LotteryUtils.getUnDupStr(kjStr).size() == 5;
    }

    /**
     * 判断中奖号是否满足组60规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu60(String kjStr) {
        // TODO 可用正则优化  /^(\d),\1,\1/
        //return !kjStr.matches("/^(\\d),\\1,\\1/") && !LotteryUtils.checkDifferent(kjStr);

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 3;
    }

    /**
     * 判断中奖号是否满足组30规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu30(String kjStr) {
        return LotteryUtils.getDupStr(kjStr).size() == 2 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足组20规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu20(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组10规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu10(String kjStr) {

        //return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 1 && LotteryUtils.getDupStrByDupNum(kjStr, 2).size() == 1;
        return LotteryUtils.getDupStr(kjStr).size() == 2 && LotteryUtils.getUnDupStr(kjStr).size() == 0;
    }

    /**
     * 判断中奖号是否满足组5规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu5(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足组24规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu24(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 0 && LotteryUtils.getUnDupStr(kjStr).size() == 4;
    }

    /**
     * 判断中奖号是否满足组12规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu12(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组6规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu6(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组4规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu4(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足三星组6规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsSanxingZu6(String kjStr) {

        return LotteryUtils.getUnDupStr(kjStr).size() == 3;
    }

    /**
     * 判断中奖号是否满足三星组选和值规则（即去除豹子号）
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsSanxingZuHe(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 0;
    }

    /**
     * 判断中奖号是否满足三星组3规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu3(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 2).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足二星复式规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsErxingFuShi(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 0 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    public static void main(String[] args) {
    }

}
