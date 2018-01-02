package com.bc.lottery.draw.service.impl;


import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.*;

import java.util.*;

/**
 * User: clion
 * Date: 217/9/5
 * Time: 14:17
 **/
public class LotteryOrderTest {

    public List<UserOrderPO> getUserOrderList(long lotteryId, Long playId) {
        List<UserOrderPO> orderList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            UserOrderPO lotteryOrder = new UserOrderPO();
            lotteryOrder.setOrderId("testOrderNo111");
            List<List<String>> betNumbersByType = getBetNumbersByType(lotteryId, playId);
            lotteryOrder.setBetContentProc(betNumbersByType);
            orderList.add(lotteryOrder);
        }
        return orderList;
    }

    public List<List<String>> getBetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();

        if (lotteryId == 1) {
            priBetNumbers = getShishicaiBetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 2) {
            priBetNumbers = getShishicaiDoubleBetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 3) {
            priBetNumbers = get11x5BetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 4) {
            priBetNumbers = get11x5DoubleBetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 6) {
            priBetNumbers = getKuai3DoubleBetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 7) {
            priBetNumbers = getPK10BetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 8) {
            priBetNumbers = getPK10DoubleBetNumbersByType(lotteryId, playId);
        } else if (lotteryId == 10) {
            priBetNumbers = getMark6DoubleBetNumbersByType(lotteryId, playId);
        }
        return priBetNumbers;
    }

    public List<List<String>> getShishicaiBetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(String.valueOf(i));
        }
        Collections.shuffle(list);
        String[] twoNumber = {list.get(0), list.get(1)};
        Collections.shuffle(list);
        String[] threeNumber = {list.get(0), list.get(1), list.get(2)};
        Collections.shuffle(list);
        String[] fourNumber = {list.get(0), list.get(1), list.get(2), list.get(3)};
        Collections.shuffle(list);
        String[] fiveNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};
        Collections.shuffle(list);
        String[] sixNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)};
        Collections.shuffle(list);
        String[] sevenNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)};
        Collections.shuffle(list);
        String[] eightNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)};

        List<String> priBetNumber0 = new ArrayList<>();
        List<String> priBetNumber1 = new ArrayList<>();
        //五星
        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        if (shishicaiType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (shishicaiType) {
                //五星
                case WU_XING_ZHI_XUAN_ZU_HE:
                case WU_XING_ZHI_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;
                case WU_XING_ZHI_XUAN_DAN_SHI:
                    for (int i = 0; i < 10; i++) {
                        priBetNumber0.add(String.valueOf(i));
                    }

                    priBetNumber0.addAll(Arrays.asList(fourNumber));
                    priBetNumber0.addAll(Arrays.asList(sixNumber));
                    priBetNumbers.add(priBetNumber0);
                    break;
                case ZU_XUAN_120:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    break;
                case ZU_XUAN_60:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case ZU_XUAN_30:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case ZU_XUAN_10:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case ZU_XUAN_20:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case ZU_XUAN_5:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;

                // 四星
                case SI_XING_ZHI_XUAN_ZU_HE:
                case SI_XING_ZHI_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;
                case SI_XING_ZHI_XUAN_DAN_SHI:
                    for (int i = 0; i < 8; i++) {
                        priBetNumber0.add(String.valueOf(i));
                    }
                    priBetNumber0.addAll(Arrays.asList(eightNumber));
                    priBetNumbers.add(priBetNumber0);
                    break;
                case ZU_XUAN_24:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    break;
                case ZU_XUAN_12:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    break;
                case ZU_XUAN_6:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    break;
                case ZU_XUAN_4:
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;
                //三星
                case HOU_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case QIAN_SAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    priBetNumbers.add(Arrays.asList(sixNumber));
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case HOU_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case QIAN_SAN_DAN_SHI:

                    List<String> arrayList = new ArrayList<>();

                    for (String t : sixNumber) {
                        arrayList.add(t);
                    }
                    for (String t : fourNumber) {
                        arrayList.add(t);
                    }
                    for (String t : twoNumber) {
                        arrayList.add(t);
                    }

                    priBetNumbers.add(arrayList);
                    break;
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:

                    String[] hezhi = new String[7];
                    hezhi[0] = String.valueOf(new Random().nextInt(27));
                    hezhi[1] = String.valueOf(new Random().nextInt(27));
                    hezhi[2] = String.valueOf(new Random().nextInt(27));
                    hezhi[3] = String.valueOf(new Random().nextInt(27));
                    hezhi[4] = String.valueOf(new Random().nextInt(27));
                    hezhi[5] = String.valueOf(new Random().nextInt(27));
                    hezhi[6] = String.valueOf(new Random().nextInt(27));
                    priBetNumbers.add(Arrays.asList(hezhi));
                    break;
                case HOU_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_SAN:
                case QIAN_SAN_ZU_SAN:
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                    List<String> arrList = new ArrayList<>();
                    List<String> arrList2 = new ArrayList<>();
                    arrList2.add("0");
                    arrList2.add("1");
                    arrList2.add("2");

                    arrList2.add("1");
                    arrList2.add("2");
                    arrList2.add("3");

                    arrList2.add("2");
                    arrList2.add("3");
                    arrList2.add("4");

                    arrList2.add("3");
                    arrList2.add("4");
                    arrList2.add("5");

                    arrList2.add("4");
                    arrList2.add("5");
                    arrList2.add("6");

                    arrList2.add("5");
                    arrList2.add("6");
                    arrList2.add("7");

                    arrList2.add("2");
                    arrList2.add("5");
                    arrList2.add("5");

                    arrList2.add("7");
                    arrList2.add("9");
                    arrList2.add("7");

                    arrList2.add("6");
                    arrList2.add("6");
                    arrList2.add("7");

                    arrList2.add("2");
                    arrList2.add("3");
                    arrList2.add("5");

                    arrList.addAll(arrList2);
                    priBetNumbers.add(arrList);
                    break;
                case HOU_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case QIAN_SAN_ZU_LIU:
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    String[] zuxuanhezhi = new String[7];
                    zuxuanhezhi[0] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[1] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[2] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[3] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[4] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[5] = String.valueOf(new Random().nextInt(25) + 1);
                    zuxuanhezhi[6] = String.valueOf(new Random().nextInt(25) + 1);
                    priBetNumbers.add(Arrays.asList(zuxuanhezhi));
                    break;

                // 二星
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_DAN_SHI:

                    List<String> erxingArrList = new ArrayList<>();
                    erxingArrList.addAll(Arrays.asList(sixNumber));
                    erxingArrList.addAll(Arrays.asList(fourNumber));
                    priBetNumbers.add(erxingArrList);

                    break;
                case HOU_ER_ZU_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:

                    String[] erXingZuxuanhezhi = new String[4];
                    erXingZuxuanhezhi[0] = String.valueOf(new Random().nextInt(17) + 1);
                    erXingZuxuanhezhi[1] = String.valueOf(new Random().nextInt(17) + 1);
                    erXingZuxuanhezhi[2] = String.valueOf(new Random().nextInt(17) + 1);
                    erXingZuxuanhezhi[3] = String.valueOf(new Random().nextInt(17) + 1);
                    priBetNumbers.add(Arrays.asList(erXingZuxuanhezhi));
                    break;

                case HOU_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;
                //一星
                case YI_XING_DING_WEI_DAN:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    priBetNumbers.add(Arrays.asList(sixNumber));

                    break;

                // 不定胆
                case HOU_SAN_ER_MA:
                case QIAN_SAN_ER_MA:
                case HOU_SAN_YI_MA:
                case QIAN_SAN_YI_MA:
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    break;

                // 大小单双
                case HOU_ER_DA_XIAO_DAN_SHUANG:
                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                    priBetNumber0.add("大");
                    priBetNumber0.add("双");
                    priBetNumber1.add("小");
                    priBetNumber1.add("单");
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);
                    break;
                case ZONG_HE_DA_XIAO_DAN_SHUANG:
                    priBetNumber0.add("单");
                    priBetNumber0.add("小");
                    priBetNumbers.add(priBetNumber0);
                    break;

                //趣味
                case SI_JI_FA_CAI:
                case SAN_XING_BAO_XI:
                case HAO_SHI_CHENG_SHUANG:
                case YI_FAN_FENG_SHUN:
                    priBetNumbers.add(Arrays.asList(sixNumber));
                    break;
            }
        }
        return priBetNumbers;
    }

    public List<List<String>> getShishicaiDoubleBetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();

        String numBig = "大";
        String numSmall = "小";
        String numSingle = "单";
        String numDouble = "双";
        String numDragon = "龙";
        String numTiger = "虎";
        String numSam = "和";
        String numLeopard = "豹子";
        String numLink3 = "顺子";
        String numLink2 = "半顺";
        String numPair = "对子";
        String numOther = "杂六";
        List<String> numList = new ArrayList<>();
        ShishicaiDoubleType doubleType = ShishicaiDoubleType.parse(playId);
        switch (doubleType) {
            case WU_QIU_DA:
            case YI_QIU_DA:
            case SI_QIU_DA:
            case SAN_QIU_DA:
            case ER_QIU_DA:
            case ZONG_HE_DA:
                numList.add(numBig);
                break;
            case WU_QIU_XIAO:
            case YI_QIU_XIAO:
            case SI_QIU_XIAO:
            case SAN_QIU_XIAO:
            case ER_QIU_XIAO:
            case ZONG_HE_XIAO:
                numList.add(numSmall);
                break;
            case WU_QIU_DAN:
            case YI_QIU_DAN:
            case SI_QIU_DAN:
            case SAN_QIU_DAN:
            case ER_QIU_DAN:
            case ZONG_HE_DAN:
                numList.add(numSingle);
                break;
            case WU_QIU_SHUANG:
            case YI_QIU_SHUANG:
            case SI_QIU_SHUANG:
            case SAN_QIU_SHUANG:
            case ER_QIU_SHUANG:
            case ZONG_HE_SHUANG:
                numList.add(numDouble);
                break;
            case ZONG_HE_LONG:
                numList.add(numDragon);
                break;
            case ZONG_HE_HU:
                numList.add(numTiger);
                break;
            case ZONG_HE_HE:
                numList.add(numSam);
                break;
            case QIAN_SAN_BAO_ZI:
            case ZHONG_SAN_BAO_ZI:
            case HOU_SAN_BAO_ZI:
                numList.add(numLeopard);
                break;
            case QIAN_SAN_SHUN_ZI:
            case ZHONG_SAN_SHUN_ZI:
            case HOU_SAN_SHUN_ZI:
                numList.add(numLink3);
                break;
            case ZHONG_SAN_BAN_SHUN:
            case QIAN_SAN_BAN_SHUN:
            case HOU_SAN_BAN_SHUN:
                numList.add(numLink2);
                break;
            case ZHONG_SAN_DUI_ZI:
            case QIAN_SAN_DUI_ZI:
            case HOU_SAN_DUI_ZI:
                numList.add(numPair);
                break;
            case QIAN_SAN_ZA_LIU:
            case HOU_SAN_ZA_LIU:
            case ZHONG_SAN_ZA_LIU:
                numList.add(numOther);
                break;
            case WU_QIU_DING_WEI_DAN_0:
            case SI_QIU_DING_WEI_DAN_0:
            case SAN_QIU_DING_WEI_DAN_0:
            case ER_QIU_DING_WEI_DAN_0:
            case YI_QIU_DING_WEI_DAN_0:
                numList.add("0");
                break;
            case YI_QIU_DING_WEI_DAN_1:
            case ER_QIU_DING_WEI_DAN_1:
            case SAN_QIU_DING_WEI_DAN_1:
            case SI_QIU_DING_WEI_DAN_1:
            case WU_QIU_DING_WEI_DAN_1:
                numList.add("1");
                break;
            case YI_QIU_DING_WEI_DAN_2:
            case ER_QIU_DING_WEI_DAN_2:
            case SAN_QIU_DING_WEI_DAN_2:
            case SI_QIU_DING_WEI_DAN_2:
            case WU_QIU_DING_WEI_DAN_2:
                numList.add("2");
                break;
            case YI_QIU_DING_WEI_DAN_3:
            case ER_QIU_DING_WEI_DAN_3:
            case SAN_QIU_DING_WEI_DAN_3:
            case SI_QIU_DING_WEI_DAN_3:
            case WU_QIU_DING_WEI_DAN_3:
                numList.add("3");
                break;
            case YI_QIU_DING_WEI_DAN_4:
            case ER_QIU_DING_WEI_DAN_4:
            case SAN_QIU_DING_WEI_DAN_4:
            case SI_QIU_DING_WEI_DAN_4:
            case WU_QIU_DING_WEI_DAN_4:
                numList.add("4");
                break;
            case YI_QIU_DING_WEI_DAN_5:
            case ER_QIU_DING_WEI_DAN_5:
            case SAN_QIU_DING_WEI_DAN_5:
            case SI_QIU_DING_WEI_DAN_5:
            case WU_QIU_DING_WEI_DAN_5:
                numList.add("5");
                break;
            case YI_QIU_DING_WEI_DAN_6:
            case ER_QIU_DING_WEI_DAN_6:
            case SAN_QIU_DING_WEI_DAN_6:
            case SI_QIU_DING_WEI_DAN_6:
            case WU_QIU_DING_WEI_DAN_6:
                numList.add("6");
                break;
            case YI_QIU_DING_WEI_DAN_7:
            case ER_QIU_DING_WEI_DAN_7:
            case SAN_QIU_DING_WEI_DAN_7:
            case SI_QIU_DING_WEI_DAN_7:
            case WU_QIU_DING_WEI_DAN_7:
                numList.add("7");
                break;
            case YI_QIU_DING_WEI_DAN_8:
            case ER_QIU_DING_WEI_DAN_8:
            case SAN_QIU_DING_WEI_DAN_8:
            case SI_QIU_DING_WEI_DAN_8:
            case WU_QIU_DING_WEI_DAN_8:
                numList.add("8");
                break;
            case YI_QIU_DING_WEI_DAN_9:
            case ER_QIU_DING_WEI_DAN_9:
            case SAN_QIU_DING_WEI_DAN_9:
            case SI_QIU_DING_WEI_DAN_9:
            case WU_QIU_DING_WEI_DAN_9:
                numList.add("9");
                break;
        }
        priBetNumbers.add(numList);

        return priBetNumbers;
    }

    public List<List<String>> get11x5BetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> middleList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0").append(String.valueOf(i));
            list.add(stringBuilder.toString());
        }
        list.add("10");
        list.add("11");
        Collections.shuffle(list);
        String[] oneNumber = {list.get(0)};
        Collections.shuffle(list);
        String[] twoNumber = {list.get(0), list.get(1)};
        Collections.shuffle(list);
        String[] threeNumber = {list.get(0), list.get(1), list.get(2)};
        Collections.shuffle(list);
        String[] fourNumber = {list.get(0), list.get(1), list.get(2), list.get(3)};
        Collections.shuffle(list);
        String[] fiveNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};
        Collections.shuffle(list);
        String[] sixNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)};
        Collections.shuffle(list);
        String[] sevenNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)};
        Collections.shuffle(list);
        String[] eightNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)};
        List<String> danShuangList = new ArrayList<>();
        danShuangList.add("5单0双");
        danShuangList.add("4单1双");
        danShuangList.add("3单2双");
        danShuangList.add("2单3双");
        danShuangList.add("1单4双");
        danShuangList.add("0单5双");

        Lottery11x5Type jiangxiType = Lottery11x5Type.parse(playId);
        List<String> firstList = new ArrayList<>();

        switch (jiangxiType) {
            case QIAN_ER_ZU_XUAN_DAN_SHI:
            case QIAN_ER_ZHI_XUAN_DAN_SHI:
            case QIAN_SAN_ZU_XUAN_DAN_SHI:
            case QIAN_SAN_ZHI_XUAN_DAN_SHI:

                firstList.clear();
                firstList.addAll(Arrays.asList(fourNumber));
                firstList.addAll(Arrays.asList(fiveNumber));
                firstList.addAll(Arrays.asList(sixNumber));
                firstList.addAll(Arrays.asList(sevenNumber));
                firstList.addAll(Arrays.asList(eightNumber));
                priBetNumbers.add(firstList);
                break;
            case QIAN_ER_ZHI_XUAN_FU_SHI:
                priBetNumbers.add(Arrays.asList(threeNumber));
                priBetNumbers.add(Arrays.asList(twoNumber));
                break;
            case QIAN_SAN_YI_MA:
                priBetNumbers.add(Arrays.asList(threeNumber));
                break;
            case DAN_SHI_WU_ZHONG_WU:
            case QIAN_SAN_ZU_XUAN_FU_SHI:
            case QIAN_ER_ZU_XUAN_FU_SHI:
                priBetNumbers.add(Arrays.asList(fiveNumber));
                break;
            case YI_XING_DING_WEI_DAN:
            case QIAN_SAN_ZHI_XUAN_FU_SHI:
                priBetNumbers.add(Arrays.asList(sevenNumber));
                priBetNumbers.add(Arrays.asList(sixNumber));
                priBetNumbers.add(Arrays.asList(eightNumber));
                break;
            case DING_DAN_SHUANG_0:

                priBetNumbers.add(Arrays.asList(danShuangList.get(0)));
                break;
            case DING_DAN_SHUANG_1:

                priBetNumbers.add(Arrays.asList(danShuangList.get(1)));
                break;
            case DING_DAN_SHUANG_2:

                priBetNumbers.add(Arrays.asList(danShuangList.get(2)));
                break;
            case DING_DAN_SHUANG_3:

                priBetNumbers.add(Arrays.asList(danShuangList.get(3)));
                break;
            case DING_DAN_SHUANG_4:

                priBetNumbers.add(Arrays.asList(danShuangList.get(4)));
                break;
            case DING_DAN_SHUANG_5:

                priBetNumbers.add(Arrays.asList(danShuangList.get(5)));
                break;

            case DAN_SHI_SAN_ZHONG_SAN:
            case DAN_SHI_LIU_ZHONG_WU:
                firstList.clear();
                firstList.addAll(Arrays.asList(fourNumber));
                firstList.addAll(Arrays.asList(fiveNumber));
                firstList.addAll(Arrays.asList(sixNumber));
                firstList.addAll(Arrays.asList(sevenNumber));
                firstList.addAll(Arrays.asList(eightNumber));
                priBetNumbers.add(firstList);
                break;

            case FU_SHI_SAN_ZHONG_SAN:
            case FU_SHI_ER_ZHONG_ER:
            case FU_SHI_YI_ZHONG_YI:
                priBetNumbers.add(Arrays.asList(threeNumber));
                break;

            case FU_SHI_SI_ZHONG_SI:
            case FU_SHI_WU_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(sixNumber));
                break;
            case FU_SHI_BA_ZHONG_WU:
            case FU_SHI_QI_ZHONG_WU:
            case FU_SHI_LIU_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(eightNumber));
                break;
            case DAN_SHI_YI_ZHONG_YI:
                priBetNumbers.add(Arrays.asList(eightNumber));
                break;
            case DAN_SHI_ER_ZHONG_ER:
                priBetNumbers.add(Arrays.asList(eightNumber));
                break;
            case DAN_SHI_SI_ZHONG_SI:
                firstList.clear();
                firstList.addAll(Arrays.asList(fiveNumber));
                firstList.addAll(Arrays.asList(sevenNumber));
                firstList.addAll(Arrays.asList(eightNumber));
                priBetNumbers.add(firstList);
                break;
            case DAN_SHI_QI_ZHONG_WU:
                firstList.clear();
                firstList.addAll(Arrays.asList(sixNumber));
                firstList.addAll(Arrays.asList(sevenNumber));
                firstList.addAll(Arrays.asList(eightNumber));
                priBetNumbers.add(firstList);
                break;
            case DAN_SHI_BA_ZHONG_WU:
                firstList.clear();
                firstList.addAll(Arrays.asList(fourNumber));
                firstList.addAll(Arrays.asList(fiveNumber));
                firstList.addAll(Arrays.asList(sevenNumber));
                firstList.addAll(Arrays.asList(eightNumber));
                priBetNumbers.add(firstList);
                break;
            case CAI_ZHONG_WEI_3:
                middleList.add("3");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_4:
                middleList.add("4");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_5:
                middleList.add("5");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_6:
                middleList.add("6");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_7:
                middleList.add("7");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_8:
                middleList.add("8");
                priBetNumbers.add(middleList);
                break;
            case CAI_ZHONG_WEI_9:
                middleList.add("9");
                priBetNumbers.add(middleList);
                break;
        }
        return priBetNumbers;
    }

    public List<List<String>> get11x5DoubleBetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        String numBig = "大";
        String numSmall = "小";
        String numSingle = "单";
        String numDouble = "双";
        String numDragon = "龙";
        String numTiger = "虎";
        String num1 = "1";
        String num2 = "2";
        String num3 = "3";
        String num4 = "4";
        String num5 = "5";
        String num6 = "6";
        String num7 = "7";
        String num8 = "8";
        String num9 = "9";
        String num10 = "10";
        String num11 = "11";
        List<String> list = new ArrayList<>();
        list.add(num1);
        list.add(num2);
        list.add(num3);
        list.add(num4);
        list.add(num5);
        list.add(num6);
        list.add(num7);
        list.add(num8);
        list.add(num9);
        list.add(num10);
        list.add(num11);
        Collections.shuffle(list);
        String[] twoNums = {list.get(0), list.get(1)};
        Collections.shuffle(list);
        String[] threeNums = {list.get(0), list.get(1), list.get(2)};
        Collections.shuffle(list);
        String[] fourNums = {list.get(0), list.get(1), list.get(2), list.get(3)};
        Collections.shuffle(list);
        String[] fiveNums = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};
        Collections.shuffle(list);
        String[] sixNums = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)};
        Collections.shuffle(list);
        String[] sevenNums = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)};
        Collections.shuffle(list);
        String[] eightNums = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)};
        Collections.shuffle(list);
        String[] zhixuan21 = {list.get(0), list.get(1)};
        String[] zhixuan22 = {list.get(2), list.get(3)};
        String[] zhixuan23 = {list.get(4), list.get(5)};
        List<String> numList = new ArrayList<>();
        Lottery11x5DoubleType doubleType = Lottery11x5DoubleType.parse(playId);
        switch (doubleType) {
            case WU_QIU_DAN:
            case SI_QIU_DAN:
            case SAN_QIU_DAN:
            case ER_QIU_DAN:
            case ZONG_HE_DAN:
            case YI_QIU_DAN:
                numList.add(numSingle);
                priBetNumbers.add(numList);
                break;
            case WU_QIU_SHUANG:
            case SI_QIU_SHUANG:
            case SAN_QIU_SHUANG:
            case ER_QIU_SHUANG:
            case ZONG_HE_SHUANG:
            case YI_QIU_SHUANG:
                numList.add(numDouble);
                priBetNumbers.add(numList);
                break;
            case ZONG_HE_WEI_DA:
            case WU_QIU_DA:
            case SI_QIU_DA:
            case SAN_QIU_DA:
            case ER_QIU_DA:
            case ZONG_HE_DA:
            case YI_QIU_DA:
                numList.add(numBig);
                priBetNumbers.add(numList);
                break;
            case ZONG_HE_WEI_XIAO:
            case WU_QIU_XIAO:
            case SI_QIU_XIAO:
            case SAN_QIU_XIAO:
            case ER_QIU_XIAO:
            case ZONG_HE_XIAO:
            case YI_QIU_XIAO:
                numList.add(numSmall);
                priBetNumbers.add(numList);
                break;
            case ZONG_HE_LONG:
                numList.add(numDragon);
                priBetNumbers.add(numList);
                break;
            case ZONG_HE_HU:
                numList.add(numTiger);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_1:
            case WU_QIU_DING_WEI_DAN_1:
            case SI_QIU_DING_WEI_DAN_1:
            case SAN_QIU_DING_WEI_DAN_1:
            case ER_QIU_DING_WEI_DAN_1:
            case YI_QIU_DING_WEI_DAN_1:
                numList.add(num1);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_2:
            case WU_QIU_DING_WEI_DAN_2:
            case SI_QIU_DING_WEI_DAN_2:
            case SAN_QIU_DING_WEI_DAN_2:
            case ER_QIU_DING_WEI_DAN_2:
            case YI_QIU_DING_WEI_DAN_2:
                numList.add(num2);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_3:
            case WU_QIU_DING_WEI_DAN_3:
            case SI_QIU_DING_WEI_DAN_3:
            case SAN_QIU_DING_WEI_DAN_3:
            case ER_QIU_DING_WEI_DAN_3:
            case YI_QIU_DING_WEI_DAN_3:
                numList.add(num3);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_4:
            case WU_QIU_DING_WEI_DAN_4:
            case SI_QIU_DING_WEI_DAN_4:
            case SAN_QIU_DING_WEI_DAN_4:
            case ER_QIU_DING_WEI_DAN_4:
            case YI_QIU_DING_WEI_DAN_4:
                numList.add(num4);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_5:
            case WU_QIU_DING_WEI_DAN_5:
            case SI_QIU_DING_WEI_DAN_5:
            case SAN_QIU_DING_WEI_DAN_5:
            case ER_QIU_DING_WEI_DAN_5:
            case YI_QIU_DING_WEI_DAN_5:
                numList.add(num5);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_6:
            case WU_QIU_DING_WEI_DAN_6:
            case SI_QIU_DING_WEI_DAN_6:
            case SAN_QIU_DING_WEI_DAN_6:
            case ER_QIU_DING_WEI_DAN_6:
            case YI_QIU_DING_WEI_DAN_6:
                numList.add(num6);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_7:
            case WU_QIU_DING_WEI_DAN_7:
            case SI_QIU_DING_WEI_DAN_7:
            case SAN_QIU_DING_WEI_DAN_7:
            case ER_QIU_DING_WEI_DAN_7:
            case YI_QIU_DING_WEI_DAN_7:
                numList.add(num7);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_8:
            case WU_QIU_DING_WEI_DAN_8:
            case SI_QIU_DING_WEI_DAN_8:
            case SAN_QIU_DING_WEI_DAN_8:
            case ER_QIU_DING_WEI_DAN_8:
            case YI_QIU_DING_WEI_DAN_8:
                numList.add(num8);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_9:
            case WU_QIU_DING_WEI_DAN_9:
            case SI_QIU_DING_WEI_DAN_9:
            case SAN_QIU_DING_WEI_DAN_9:
            case ER_QIU_DING_WEI_DAN_9:
            case YI_QIU_DING_WEI_DAN_9:
                numList.add(num9);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_10:
            case WU_QIU_DING_WEI_DAN_10:
            case SI_QIU_DING_WEI_DAN_10:
            case SAN_QIU_DING_WEI_DAN_10:
            case ER_QIU_DING_WEI_DAN_10:
            case YI_QIU_DING_WEI_DAN_10:
                numList.add(num10);
                priBetNumbers.add(numList);
                break;
            case YI_ZHONG_YI_11:
            case WU_QIU_DING_WEI_DAN_11:
            case SI_QIU_DING_WEI_DAN_11:
            case SAN_QIU_DING_WEI_DAN_11:
            case ER_QIU_DING_WEI_DAN_11:
            case YI_QIU_DING_WEI_DAN_11:
                numList.add(num11);
                priBetNumbers.add(numList);
                break;
            case LIAN_MA_ER_ZHONG_ER:
                priBetNumbers.add(Arrays.asList(twoNums));
                break;
            case LIAN_MA_SAN_ZHONG_SAN:
                priBetNumbers.add(Arrays.asList(threeNums));
                break;
            case LIAN_MA_SI_ZHONG_SI:
                priBetNumbers.add(Arrays.asList(fourNums));
                break;
            case QIAN_SAN_ZU_XUAN:
            case QIAN_ER_ZU_XUAN:
            case LIAN_MA_WU_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(fiveNums));
                break;
            case LIAN_MA_LIU_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(sixNums));
                break;
            case LIAN_MA_QI_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(sevenNums));
                break;
            case LIAN_MA_BA_ZHONG_WU:
                priBetNumbers.add(Arrays.asList(eightNums));
                break;
            case QIAN_ER_ZHI_XUAN:
                priBetNumbers.add(Arrays.asList(zhixuan21));
                priBetNumbers.add(Arrays.asList(zhixuan22));
                break;
            case QIAN_SAN_ZHI_XUAN:
                priBetNumbers.add(Arrays.asList(zhixuan23));
                priBetNumbers.add(Arrays.asList(zhixuan21));
                priBetNumbers.add(Arrays.asList(zhixuan22));
                break;
        }
        return priBetNumbers;
    }

    public List<List<String>> getKuai3DoubleBetNumbersByType(long lotteryId, Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> oneSets = new ArrayList<>();
        String touzi1 = "1";
        String touzi2 = "2";
        String touzi3 = "3";
        String touzi4 = "4";
        String touzi5 = "5";
        String touzi6 = "6";
        String big = "大";
        String small = "小";
        String quanTou = "全骰";
        LotteryKuai3DoubleType doubleType = LotteryKuai3DoubleType.parse(playId);
        switch (doubleType) {
            case SAN_JUN_1:
                oneSets.add(touzi1);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_2:
                oneSets.add(touzi2);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_3:
                oneSets.add(touzi3);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_4:
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_5:
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_6:
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_大:
                oneSets.add(big);
                priBetNumbers.add(oneSets);
                break;
            case SAN_JUN_小:
                oneSets.add(small);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_1:
                oneSets.add(touzi1);
                oneSets.add(touzi1);
                oneSets.add(touzi1);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_2:
                oneSets.add(touzi2);
                oneSets.add(touzi2);
                oneSets.add(touzi2);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_3:
                oneSets.add(touzi3);
                oneSets.add(touzi3);
                oneSets.add(touzi3);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_4:
                oneSets.add(touzi4);
                oneSets.add(touzi4);
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_5:
                oneSets.add(touzi5);
                oneSets.add(touzi5);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case WEI_SHAI_6:
                oneSets.add(touzi6);
                oneSets.add(touzi6);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case QUAN_SHAI:
                oneSets.add(quanTou);
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_4:
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_5:
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_6:
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_7:
                oneSets.add("7");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_8:
                oneSets.add("8");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_9:
                oneSets.add("9");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_10:
                oneSets.add("10");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_11:
                oneSets.add("11");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_12:
                oneSets.add("12");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_13:
                oneSets.add("13");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_14:
                oneSets.add("14");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_15:
                oneSets.add("15");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_16:
                oneSets.add("16");
                priBetNumbers.add(oneSets);
                break;
            case DIAN_SHU_HE_17:
                oneSets.add("17");
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_12:
                oneSets.add(touzi1);
                oneSets.add(touzi2);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_13:
                oneSets.add(touzi1);
                oneSets.add(touzi3);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_14:
                oneSets.add(touzi1);
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_15:
                oneSets.add(touzi1);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_16:
                oneSets.add(touzi1);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_23:
                oneSets.add(touzi2);
                oneSets.add(touzi3);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_24:
                oneSets.add(touzi2);
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_25:
                oneSets.add(touzi2);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_26:
                oneSets.add(touzi2);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_34:
                oneSets.add(touzi3);
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_35:
                oneSets.add(touzi3);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_36:
                oneSets.add(touzi3);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_45:
                oneSets.add(touzi4);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_46:
                oneSets.add(touzi4);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case CHANG_PAI_56:
                oneSets.add(touzi5);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_1:
                oneSets.add(touzi1);
                oneSets.add(touzi1);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_2:
                oneSets.add(touzi2);
                oneSets.add(touzi2);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_3:
                oneSets.add(touzi3);
                oneSets.add(touzi3);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_4:
                oneSets.add(touzi4);
                oneSets.add(touzi4);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_5:
                oneSets.add(touzi5);
                oneSets.add(touzi5);
                priBetNumbers.add(oneSets);
                break;
            case DUAN_PAI_6:
                oneSets.add(touzi6);
                oneSets.add(touzi6);
                priBetNumbers.add(oneSets);
                break;
        }
        return priBetNumbers;
    }

    public List<List<String>> getPK10BetNumbersByType(long lotteryId, Long playId) {
        List<List<String>> priBetNumbers = new ArrayList<>();

        List<String> normalList = new ArrayList<>();
        List<String> sum3List = new ArrayList<>();
        List<String> sum2List = new ArrayList<>();
        List<String> oneSets = new ArrayList<>();
        String da = "大";
        String xiao = "小";
        String dan = "单";
        String shuang = "双";
        String dragon = "龙";
        String tiger = "虎";
        for (int i = 1; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0").append(String.valueOf(i));
            normalList.add(stringBuilder.toString());
            if (i >= 6) {
                sum3List.add(stringBuilder.toString());
            }
            if (i >= 3) {
                sum2List.add(stringBuilder.toString());
            }
        }
        for (int i = 10; i < 20; i++) {
            sum2List.add(String.valueOf(i));
            ;
        }
        for (int i = 10; i < 28; i++) {
            sum3List.add(String.valueOf(i));
        }
        Collections.shuffle(sum2List);
        Collections.shuffle(sum3List);
        normalList.add("10");
        Collections.shuffle(normalList);
        String[] twoNum = {normalList.get(0), normalList.get(1)};
        Collections.shuffle(normalList);
        String[] threeNum = {normalList.get(0), normalList.get(1), normalList.get(2)};
        Collections.shuffle(normalList);
        String[] fourNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3)};
        Collections.shuffle(normalList);
        String[] fiveNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3), normalList.get(4)};
        Collections.shuffle(normalList);
        String[] sixNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3), normalList.get(4), normalList.get(6)};
        Collections.shuffle(normalList);
        Collections.shuffle(normalList);
        String[] sevenNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3), normalList.get(4), normalList.get(6), normalList.get(5)};
        Collections.shuffle(normalList);
        String[] eightNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3),
                normalList.get(4), normalList.get(5), normalList.get(6), normalList.get(7)};
        Collections.shuffle(normalList);
        String[] tenNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3),
                normalList.get(4), normalList.get(5), normalList.get(6), normalList.get(7), normalList.get(8), normalList.get(9)};
        String[] twiveNum = {normalList.get(0), normalList.get(1), normalList.get(2), normalList.get(3),
                normalList.get(4), normalList.get(5), normalList.get(6), normalList.get(7), normalList.get(8), normalList.get(9), normalList.get(3), normalList.get(1)};
        LotteryPK10Type pk10Type = LotteryPK10Type.parse(playId);
        switch (pk10Type) {
            case GUAN_JUN_FU_SHI:
                priBetNumbers.add(Arrays.asList(sixNum));
                break;
            case QIAN_ER_FU_SHI:
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                break;
            case QIAN_ER_DAN_SHI:
                priBetNumbers.add(Arrays.asList(twiveNum));
                break;
            case QIAN_SAN_FU_SHI:
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(fiveNum));
                break;
            case QIAN_SAN_DAN_SHI:
                priBetNumbers.add(Arrays.asList(twiveNum));
                break;
            case QIAN_SI_FU_SHI:
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(sevenNum));
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(tenNum));
                break;
            case QIAN_SI_DAN_SHI:
                priBetNumbers.add(Arrays.asList(twiveNum));
                break;
            case QIAN_WU_FU_SHI:
                priBetNumbers.add(Arrays.asList(fiveNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(sevenNum));
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                break;
            case QIAN_WU_DAN_SHI:
                oneSets.addAll(Arrays.asList(tenNum));
                oneSets.addAll(Arrays.asList(sixNum));
                oneSets.addAll(Arrays.asList(fourNum));
                priBetNumbers.add(oneSets);
                break;
            case QIAN_LIU_FU_SHI:
                priBetNumbers.add(Arrays.asList(sevenNum));
                priBetNumbers.add(Arrays.asList(fiveNum));
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(sevenNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(tenNum));
                break;
            case QIAN_LIU_DAN_SHI:
                oneSets.clear();
                oneSets.addAll(Arrays.asList(twiveNum));
                oneSets.addAll(Arrays.asList(twoNum));
                oneSets.addAll(Arrays.asList(sixNum));
                oneSets.addAll(Arrays.asList(fourNum));
                priBetNumbers.add(oneSets);
                break;
            case DING_WEI_DAN:
                priBetNumbers.add(Arrays.asList(fourNum));
                priBetNumbers.add(Arrays.asList(fiveNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(sevenNum));
                priBetNumbers.add(Arrays.asList(eightNum));
                priBetNumbers.add(Arrays.asList(fiveNum));
                priBetNumbers.add(Arrays.asList(fourNum));
                priBetNumbers.add(Arrays.asList(sixNum));
                priBetNumbers.add(Arrays.asList(fourNum));
                priBetNumbers.add(Arrays.asList(fiveNum));
                priBetNumbers.add(Arrays.asList(sevenNum));
                break;
            case HOU_SAN_HE_ZHI:
            case QIAN_SAN_HE_ZHI:
                oneSets.clear();
                oneSets.add(sum3List.get(1));
                oneSets.add(sum3List.get(2));
                oneSets.add(sum3List.get(3));
                priBetNumbers.add(oneSets);
                break;

            case JING_SU:
                priBetNumbers.add(Arrays.asList(twoNum));

                List<String> oneList = new ArrayList<>();
                oneList.add(sixNum[0]);
                oneList.add(sixNum[1]);
                priBetNumbers.add(oneList);

                oneSets.clear();
                oneSets.add(sevenNum[4]);
                oneSets.add(sevenNum[5]);
                priBetNumbers.add(oneSets);

                List<String> twoList = new ArrayList<>();
                twoList.add(eightNum[6]);
                twoList.add(eightNum[7]);
                priBetNumbers.add(twoList);
                break;

            case HOU_ER_HE_ZHI:
            case ZHONG_ER_HE_ZHI:
            case QIAN_ER_HE_ZHI:
                oneSets.add(sum2List.get(0));
                oneSets.add(sum2List.get(2));
                oneSets.add(sum2List.get(3));
                oneSets.add(sum2List.get(4));
                oneSets.add(sum2List.get(5));
                priBetNumbers.add(oneSets);
                break;


            case GUAN_DA_XIAO_DAN_SHUANG:
                oneSets.clear();
                oneSets.add(da);
                oneSets.add(dan);
                priBetNumbers.add(oneSets);
                break;
            case YA_DA_XIAO_DAN_SHUANG:
                oneSets.clear();
                oneSets.add(xiao);
                oneSets.add(shuang);
                priBetNumbers.add(oneSets);
                break;
            case THIRD_DA_XIAO_DAN_SHUANG:
                oneSets.clear();
                oneSets.add(xiao);
                oneSets.add(dan);
                priBetNumbers.add(oneSets);
                break;
            case DAN_HAO_GUAN_LONG_HU:
                oneSets.clear();
                oneSets.add(dragon);
                priBetNumbers.add(oneSets);
                break;
            case DAN_HAO_YA_LONG_HU:
                oneSets.clear();
                oneSets.add(dragon);
                priBetNumbers.add(oneSets);
                break;
            case DAN_HAO_THIRD_LONG_HU:
                oneSets.clear();
                oneSets.add(tiger);
                priBetNumbers.add(oneSets);
                break;
            case DAN_HAO_FORTH_LONG_HU:
                oneSets.clear();
                oneSets.add(dragon);
                priBetNumbers.add(oneSets);
                break;
            case DAN_HAO_FIFTH_LONG_HU:
                oneSets.clear();
                oneSets.add(tiger);
                priBetNumbers.add(oneSets);
                break;
        }

        return priBetNumbers;
    }

    public List<List<String>> getPK10DoubleBetNumbersByType(long lotteryId, Long playId) {
        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        String first = "1";
        String second = "2";
        String third = "3";
        String fourth = "4";
        String fifth = "5";
        String sixth = "6";
        String seventh = "7";
        String eighth = "8";
        String ninth = "9";
        String tenth = "10";
        String big = "大";
        String small = "小";
        String single = "单";
        String shuang = "双";
        String dragon = "龙";
        String tiger = "虎";
        LotteryPK10DoubleType pk10DoubleType = LotteryPK10DoubleType.parse(playId);
        switch (pk10DoubleType) {
            case DAN_HAO_TENTH_DA:
            case DAN_HAO_NINTH_DA:
            case DAN_HAO_EIGHTH_DA:
            case DAN_HAO_SEVENTH_DA:
            case DAN_HAO_SIXTH_DA:
            case DAN_HAO_FIFTH_DA:
            case DAN_HAO_FORTH_DA:
            case DAN_HAO_THIRD_DA:
            case DAN_HAO_YA_DA:
            case DAN_HAO_GUAN_DA:
            case GUAN_YA_HE_DA:
                numList.add(big);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_TENTH_XIAO:
            case DAN_HAO_NINTH_XIAO:
            case DAN_HAO_EIGHTH_XIAO:
            case DAN_HAO_SEVENTH_XIAO:
            case DAN_HAO_SIXTH_XIAO:
            case DAN_HAO_FIFTH_XIAO:
            case DAN_HAO_FORTH_XIAO:
            case DAN_HAO_THIRD_XIAO:
            case DAN_HAO_YA_XIAO:
            case DAN_HAO_GUAN_XIAO:
            case GUAN_YA_HE_XIAO:
                numList.add(small);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_TENTH_DAN:
            case DAN_HAO_NINTH_DAN:
            case DAN_HAO_EIGHTH_DAN:
            case DAN_HAO_SEVENTH_DAN:
            case DAN_HAO_SIXTH_DAN:
            case DAN_HAO_FIFTH_DAN:
            case DAN_HAO_FORTH_DAN:
            case DAN_HAO_THIRD_DAN:
            case DAN_HAO_YA_DAN:
            case DAN_HAO_GUAN_DAN:
            case GUAN_YA_HE_DAN:
                numList.add(single);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_TENTH_SHUANG:
            case DAN_HAO_NINTH_SHUANG:
            case DAN_HAO_EIGHTH_SHUANG:
            case DAN_HAO_SIXTH_SHUANG:
            case DAN_HAO_SEVENTH_SHUANG:
            case DAN_HAO_FIFTH_SHUANG:
            case DAN_HAO_FORTH_SHUANG:
            case DAN_HAO_THIRD_SHUANG:
            case DAN_HAO_YA_SHUANG:
            case DAN_HAO_GUAN_SHUANG:
            case GUAN_YA_HE_SHUANG:
                numList.add(shuang);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_FIFTH_LONG:
            case DAN_HAO_FORTH_LONG:
            case DAN_HAO_THIRD_LONG:
            case DAN_HAO_YA_LONG:
            case DAN_HAO_GUAN_LONG:
                numList.add(dragon);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_FIFTH_HU:
            case DAN_HAO_FORTH_HU:
            case DAN_HAO_THIRD_HU:
            case DAN_HAO_YA_HU:
            case DAN_HAO_GUAN_HU:
                numList.add(tiger);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_TENTH_1:
            case DAN_HAO_NINTH_1:
            case DAN_HAO_EIGHTH_1:
            case DAN_HAO_SIXTH_1:
            case DAN_HAO_GUAN_1:
            case DAN_HAO_FORTH_1:
            case DAN_HAO_THIRD_1:
            case DAN_HAO_YA_1:
            case DAN_HAO_SEVENTH_1:
            case DAN_HAO_FIFTH_1:
                numList.add(first);
                priBetNumbers.add(numList);
                break;
            case DAN_HAO_TENTH_2:
            case DAN_HAO_NINTH_2:
            case DAN_HAO_EIGHTH_2:
            case DAN_HAO_SIXTH_2:
            case DAN_HAO_GUAN_2:
            case DAN_HAO_FORTH_2:
            case DAN_HAO_THIRD_2:
            case DAN_HAO_YA_2:
            case DAN_HAO_SEVENTH_2:
            case DAN_HAO_FIFTH_2:
                numList.add(second);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_3:
            case DAN_HAO_TENTH_3:
            case DAN_HAO_NINTH_3:
            case DAN_HAO_EIGHTH_3:
            case DAN_HAO_SIXTH_3:
            case DAN_HAO_GUAN_3:
            case DAN_HAO_FORTH_3:
            case DAN_HAO_THIRD_3:
            case DAN_HAO_YA_3:
            case DAN_HAO_SEVENTH_3:
            case DAN_HAO_FIFTH_3:
                numList.add(third);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_4:
            case DAN_HAO_TENTH_4:
            case DAN_HAO_NINTH_4:
            case DAN_HAO_EIGHTH_4:
            case DAN_HAO_SIXTH_4:
            case DAN_HAO_GUAN_4:
            case DAN_HAO_FORTH_4:
            case DAN_HAO_THIRD_4:
            case DAN_HAO_YA_4:
            case DAN_HAO_SEVENTH_4:
            case DAN_HAO_FIFTH_4:
                numList.add(fourth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_5:
            case DAN_HAO_TENTH_5:
            case DAN_HAO_NINTH_5:
            case DAN_HAO_EIGHTH_5:
            case DAN_HAO_SIXTH_5:
            case DAN_HAO_GUAN_5:
            case DAN_HAO_FORTH_5:
            case DAN_HAO_THIRD_5:
            case DAN_HAO_YA_5:
            case DAN_HAO_SEVENTH_5:
            case DAN_HAO_FIFTH_5:
                numList.add(fifth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_6:
            case DAN_HAO_TENTH_6:
            case DAN_HAO_NINTH_6:
            case DAN_HAO_EIGHTH_6:
            case DAN_HAO_SIXTH_6:
            case DAN_HAO_GUAN_6:
            case DAN_HAO_FORTH_6:
            case DAN_HAO_THIRD_6:
            case DAN_HAO_YA_6:
            case DAN_HAO_SEVENTH_6:
            case DAN_HAO_FIFTH_6:
                numList.add(sixth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_7:
            case DAN_HAO_TENTH_7:
            case DAN_HAO_NINTH_7:
            case DAN_HAO_EIGHTH_7:
            case DAN_HAO_SIXTH_7:
            case DAN_HAO_GUAN_7:
            case DAN_HAO_FORTH_7:
            case DAN_HAO_THIRD_7:
            case DAN_HAO_YA_7:
            case DAN_HAO_SEVENTH_7:
            case DAN_HAO_FIFTH_7:
                numList.add(seventh);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_8:
            case DAN_HAO_TENTH_8:
            case DAN_HAO_NINTH_8:
            case DAN_HAO_EIGHTH_8:
            case DAN_HAO_SIXTH_8:
            case DAN_HAO_GUAN_8:
            case DAN_HAO_FORTH_8:
            case DAN_HAO_THIRD_8:
            case DAN_HAO_YA_8:
            case DAN_HAO_SEVENTH_8:
            case DAN_HAO_FIFTH_8:
                numList.add(eighth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_9:
            case DAN_HAO_TENTH_9:
            case DAN_HAO_NINTH_9:
            case DAN_HAO_EIGHTH_9:
            case DAN_HAO_SIXTH_9:
            case DAN_HAO_GUAN_9:
            case DAN_HAO_FORTH_9:
            case DAN_HAO_THIRD_9:
            case DAN_HAO_YA_9:
            case DAN_HAO_SEVENTH_9:
            case DAN_HAO_FIFTH_9:
                numList.add(ninth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_10:
            case DAN_HAO_TENTH_10:
            case DAN_HAO_NINTH_10:
            case DAN_HAO_EIGHTH_10:
            case DAN_HAO_SIXTH_10:
            case DAN_HAO_GUAN_10:
            case DAN_HAO_FORTH_10:
            case DAN_HAO_THIRD_10:
            case DAN_HAO_YA_10:
            case DAN_HAO_SEVENTH_10:
            case DAN_HAO_FIFTH_10:
                numList.add(tenth);
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_11:
                numList.add("11");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_12:
                numList.add("12");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_13:
                numList.add("13");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_14:
                numList.add("14");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_15:
                numList.add("15");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_16:
                numList.add("16");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_17:
                numList.add("17");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_18:
                numList.add("18");
                priBetNumbers.add(numList);
                break;
            case GUAN_YA_HE_19:
                numList.add("19");
                priBetNumbers.add(numList);
                break;
        }
        return priBetNumbers;
    }

    // 六合彩玩法
    public List<List<String>> getMark6DoubleBetNumbersByType(long lotteryId, Long playId) {
        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        String big = "大";
        String small = "小";
        String single = "单";
        String shuang = "双";
        String hong = "红";
        String lan = "蓝";
        String lv = "绿";

        // 尾数
        List<String> weishuList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i));
            weishuList.add(stringBuilder.toString());
        }
        Collections.shuffle(weishuList);
        List<String> oneWeishu = new ArrayList<>();
        oneWeishu.add(weishuList.get(0));
        Collections.shuffle(weishuList);
        List<String> twoWeishu = new ArrayList<>();
        twoWeishu.add(weishuList.get(0));
        twoWeishu.add(weishuList.get(1));
        Collections.shuffle(weishuList);
        List<String> threeWeishu = new ArrayList<>();
        threeWeishu.add(weishuList.get(0));
        threeWeishu.add(weishuList.get(1));
        threeWeishu.add(weishuList.get(2));
        Collections.shuffle(weishuList);
        List<String> fourWeishu = new ArrayList<>();
        fourWeishu.add(weishuList.get(0));
        fourWeishu.add(weishuList.get(1));
        fourWeishu.add(weishuList.get(2));
        fourWeishu.add(weishuList.get(3));
        Collections.shuffle(weishuList);
        List<String> fiveWeishu = new ArrayList<>();
        fiveWeishu.add(weishuList.get(0));
        fiveWeishu.add(weishuList.get(1));
        fiveWeishu.add(weishuList.get(2));
        fiveWeishu.add(weishuList.get(3));
        fiveWeishu.add(weishuList.get(4));

        // 正码
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(String.valueOf(i));
            list.add(stringBuilder.toString());
        }
        Collections.shuffle(list);
        List<String> twoNumber = new ArrayList<>();
        twoNumber.add(list.get(0));
        twoNumber.add(list.get(1));
        Collections.shuffle(list);
        List<String> threeNumber = new ArrayList<>();
        threeNumber.add(list.get(0));
        threeNumber.add(list.get(1));
        threeNumber.add(list.get(2));
        Collections.shuffle(list);
        List<String> fourNumber = new ArrayList<>();
        fourNumber.add(list.get(0));
        fourNumber.add(list.get(1));
        fourNumber.add(list.get(2));
        fourNumber.add(list.get(3));

        Collections.shuffle(list);
        List<String> fiveNumber = new ArrayList<>();
        fiveNumber.add(list.get(0));
        fiveNumber.add(list.get(1));
        fiveNumber.add(list.get(2));
        fiveNumber.add(list.get(3));
        fiveNumber.add(list.get(4));
        Collections.shuffle(list);
        List<String> sixNumber = new ArrayList<>();
        sixNumber.add(list.get(0));
        sixNumber.add(list.get(1));
        sixNumber.add(list.get(2));
        sixNumber.add(list.get(3));
        sixNumber.add(list.get(4));
        sixNumber.add(list.get(5));
        Collections.shuffle(list);
        List<String> sevenNumber = new ArrayList<>();
        sevenNumber.add(list.get(0));
        sevenNumber.add(list.get(1));
        sevenNumber.add(list.get(2));
        sevenNumber.add(list.get(3));
        sevenNumber.add(list.get(4));
        sevenNumber.add(list.get(5));
        sevenNumber.add(list.get(6));
        Collections.shuffle(list);
        List<String> eightNumber = new ArrayList<>();
        eightNumber.add(list.get(0));
        eightNumber.add(list.get(1));
        eightNumber.add(list.get(2));
        eightNumber.add(list.get(3));
        eightNumber.add(list.get(4));
        eightNumber.add(list.get(5));
        eightNumber.add(list.get(6));
        eightNumber.add(list.get(7));
        Collections.shuffle(list);

        List<String> nineNumber = new ArrayList<>();
        nineNumber.add(list.get(0));
        nineNumber.add(list.get(1));
        nineNumber.add(list.get(2));
        nineNumber.add(list.get(3));
        nineNumber.add(list.get(4));
        nineNumber.add(list.get(5));
        nineNumber.add(list.get(6));
        nineNumber.add(list.get(7));
        nineNumber.add(list.get(8));
        Collections.shuffle(list);

        List<String> tenNumber = new ArrayList<>();
        tenNumber.add(list.get(0));
        tenNumber.add(list.get(1));
        tenNumber.add(list.get(2));
        tenNumber.add(list.get(3));
        tenNumber.add(list.get(4));
        tenNumber.add(list.get(5));
        tenNumber.add(list.get(6));
        tenNumber.add(list.get(7));
        tenNumber.add(list.get(8));
        tenNumber.add(list.get(9));
        Collections.shuffle(list);

        List<String> elevenNumber = new ArrayList<>();
        elevenNumber.add(list.get(0));
        elevenNumber.add(list.get(1));
        elevenNumber.add(list.get(2));
        elevenNumber.add(list.get(3));
        elevenNumber.add(list.get(4));
        elevenNumber.add(list.get(5));
        elevenNumber.add(list.get(6));
        elevenNumber.add(list.get(7));
        elevenNumber.add(list.get(8));
        elevenNumber.add(list.get(9));
        elevenNumber.add(list.get(10));
        Collections.shuffle(list);

        List<String> twelveNumber = new ArrayList<>();
        twelveNumber.add(list.get(0));
        twelveNumber.add(list.get(1));
        twelveNumber.add(list.get(2));
        twelveNumber.add(list.get(3));
        twelveNumber.add(list.get(4));
        twelveNumber.add(list.get(5));
        twelveNumber.add(list.get(6));
        twelveNumber.add(list.get(7));
        twelveNumber.add(list.get(8));
        twelveNumber.add(list.get(9));
        twelveNumber.add(list.get(10));
        twelveNumber.add(list.get(11));
        Collections.shuffle(list);

        //生肖
        List<String> shengxiaoList = new ArrayList<>();
        shengxiaoList.add("鼠");
        shengxiaoList.add("牛");
        shengxiaoList.add("虎");
        shengxiaoList.add("兔");
        shengxiaoList.add("龙");
        shengxiaoList.add("蛇");
        shengxiaoList.add("马");
        shengxiaoList.add("羊");
        shengxiaoList.add("猴");
        shengxiaoList.add("鸡");
        shengxiaoList.add("狗");
        shengxiaoList.add("猪");
        Collections.shuffle(list);

        List<String> twoXiao = new ArrayList<>();
        twoXiao.add(shengxiaoList.get(0));
        twoXiao.add(shengxiaoList.get(1));
        Collections.shuffle(shengxiaoList);
        List<String> threeXiao = new ArrayList<>();
        threeXiao.add(shengxiaoList.get(0));
        threeXiao.add(shengxiaoList.get(1));
        threeXiao.add(shengxiaoList.get(2));
        Collections.shuffle(shengxiaoList);
        List<String> fourXiao = new ArrayList<>();
        fourXiao.add(shengxiaoList.get(0));
        fourXiao.add(shengxiaoList.get(1));
        fourXiao.add(shengxiaoList.get(2));
        fourXiao.add(shengxiaoList.get(3));
        Collections.shuffle(shengxiaoList);
        List<String> fiveXiao = new ArrayList<>();
        fiveXiao.add(shengxiaoList.get(0));
        fiveXiao.add(shengxiaoList.get(1));
        fiveXiao.add(shengxiaoList.get(2));
        fiveXiao.add(shengxiaoList.get(3));
        fiveXiao.add(shengxiaoList.get(4));
        Collections.shuffle(shengxiaoList);

        List<String> sixXiao = new ArrayList<>();
        sixXiao.add(shengxiaoList.get(0));
        sixXiao.add(shengxiaoList.get(1));
        sixXiao.add(shengxiaoList.get(2));
        sixXiao.add(shengxiaoList.get(3));
        sixXiao.add(shengxiaoList.get(4));
        sixXiao.add(shengxiaoList.get(5));
        Collections.shuffle(shengxiaoList);

        List<String> sevenXiao = new ArrayList<>();
        sevenXiao.add(shengxiaoList.get(0));
        sevenXiao.add(shengxiaoList.get(1));
        sevenXiao.add(shengxiaoList.get(2));
        sevenXiao.add(shengxiaoList.get(3));
        sevenXiao.add(shengxiaoList.get(4));
        sevenXiao.add(shengxiaoList.get(5));
        sevenXiao.add(shengxiaoList.get(6));
        Collections.shuffle(shengxiaoList);

        List<String> eightXiao = new ArrayList<>();
        eightXiao.add(shengxiaoList.get(0));
        eightXiao.add(shengxiaoList.get(1));
        eightXiao.add(shengxiaoList.get(2));
        eightXiao.add(shengxiaoList.get(3));
        eightXiao.add(shengxiaoList.get(4));
        eightXiao.add(shengxiaoList.get(5));
        eightXiao.add(shengxiaoList.get(6));
        eightXiao.add(shengxiaoList.get(7));
        Collections.shuffle(shengxiaoList);

        List<String> nineXiao = new ArrayList<>();
        nineXiao.add(shengxiaoList.get(0));
        nineXiao.add(shengxiaoList.get(1));
        nineXiao.add(shengxiaoList.get(2));
        nineXiao.add(shengxiaoList.get(3));
        nineXiao.add(shengxiaoList.get(4));
        nineXiao.add(shengxiaoList.get(5));
        nineXiao.add(shengxiaoList.get(6));
        nineXiao.add(shengxiaoList.get(7));
        nineXiao.add(shengxiaoList.get(8));
        Collections.shuffle(shengxiaoList);

        List<String> tenXiao = new ArrayList<>();
        tenXiao.add(shengxiaoList.get(0));
        tenXiao.add(shengxiaoList.get(1));
        tenXiao.add(shengxiaoList.get(2));
        tenXiao.add(shengxiaoList.get(3));
        tenXiao.add(shengxiaoList.get(4));
        tenXiao.add(shengxiaoList.get(5));
        tenXiao.add(shengxiaoList.get(6));
        tenXiao.add(shengxiaoList.get(7));
        tenXiao.add(shengxiaoList.get(8));
        tenXiao.add(shengxiaoList.get(9));
        Collections.shuffle(shengxiaoList);


        List<String> elevenXiao = new ArrayList<>();
        elevenXiao.add(shengxiaoList.get(0));
        elevenXiao.add(shengxiaoList.get(1));
        elevenXiao.add(shengxiaoList.get(2));
        elevenXiao.add(shengxiaoList.get(3));
        elevenXiao.add(shengxiaoList.get(4));
        elevenXiao.add(shengxiaoList.get(5));
        elevenXiao.add(shengxiaoList.get(6));
        elevenXiao.add(shengxiaoList.get(7));
        elevenXiao.add(shengxiaoList.get(8));
        elevenXiao.add(shengxiaoList.get(9));
        elevenXiao.add(shengxiaoList.get(10));
        Collections.shuffle(shengxiaoList);

        LotteryMark6DoubleType lotteryMark6DoubleType = LotteryMark6DoubleType.parse(playId);
        switch (lotteryMark6DoubleType) {

            case TE_MA_A_1:
            case TE_MA_B_1:
            case ZHENG_MA_1:
            case ZHENG_YI_TE_1:
            case ZHENG_ER_TE_1:
            case ZHENG_SAN_TE_1:
            case ZHENG_SI_TE_1:
            case ZHENG_WU_TE_1:
            case ZHENG_LIU_TE_1:

                numList.add("01");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_2:
            case TE_MA_B_2:
            case ZHENG_MA_2:
            case ZHENG_YI_TE_2:
            case ZHENG_ER_TE_2:
            case ZHENG_SAN_TE_2:
            case ZHENG_SI_TE_2:
            case ZHENG_WU_TE_2:
            case ZHENG_LIU_TE_2:
                numList.add("02");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_3:
            case TE_MA_B_3:
            case ZHENG_MA_3:
            case ZHENG_YI_TE_3:
            case ZHENG_ER_TE_3:
            case ZHENG_SAN_TE_3:
            case ZHENG_SI_TE_3:
            case ZHENG_WU_TE_3:
            case ZHENG_LIU_TE_3:
                numList.add("03");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_4:
            case TE_MA_B_4:
            case ZHENG_MA_4:
            case ZHENG_YI_TE_4:
            case ZHENG_ER_TE_4:
            case ZHENG_SAN_TE_4:
            case ZHENG_SI_TE_4:
            case ZHENG_WU_TE_4:
            case ZHENG_LIU_TE_4:
                numList.add("04");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_5:
            case TE_MA_B_5:
            case ZHENG_MA_5:
            case ZHENG_YI_TE_5:
            case ZHENG_ER_TE_5:
            case ZHENG_SAN_TE_5:
            case ZHENG_SI_TE_5:
            case ZHENG_WU_TE_5:
            case ZHENG_LIU_TE_5:

                numList.add("05");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_6:
            case TE_MA_B_6:
            case ZHENG_MA_6:
            case ZHENG_YI_TE_6:
            case ZHENG_ER_TE_6:
            case ZHENG_SAN_TE_6:
            case ZHENG_SI_TE_6:
            case ZHENG_WU_TE_6:
            case ZHENG_LIU_TE_6:

                numList.add("06");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_7:
            case TE_MA_B_7:
            case ZHENG_MA_7:
            case ZHENG_YI_TE_7:
            case ZHENG_ER_TE_7:
            case ZHENG_SAN_TE_7:
            case ZHENG_SI_TE_7:
            case ZHENG_WU_TE_7:
            case ZHENG_LIU_TE_7:

                numList.add("07");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_8:
            case TE_MA_B_8:
            case ZHENG_MA_8:
            case ZHENG_YI_TE_8:
            case ZHENG_ER_TE_8:
            case ZHENG_SAN_TE_8:
            case ZHENG_SI_TE_8:
            case ZHENG_WU_TE_8:
            case ZHENG_LIU_TE_8:

                numList.add("08");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_9:
            case TE_MA_B_9:
            case ZHENG_MA_9:
            case ZHENG_YI_TE_9:
            case ZHENG_ER_TE_9:
            case ZHENG_SAN_TE_9:
            case ZHENG_SI_TE_9:
            case ZHENG_WU_TE_9:
            case ZHENG_LIU_TE_9:

                numList.add("09");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_10:
            case TE_MA_B_10:
            case ZHENG_MA_10:
            case ZHENG_YI_TE_10:
            case ZHENG_ER_TE_10:
            case ZHENG_SAN_TE_10:
            case ZHENG_SI_TE_10:
            case ZHENG_WU_TE_10:
            case ZHENG_LIU_TE_10:
                numList.add("10");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_11:
            case TE_MA_B_11:
            case ZHENG_MA_11:
            case ZHENG_YI_TE_11:
            case ZHENG_ER_TE_11:
            case ZHENG_SAN_TE_11:
            case ZHENG_SI_TE_11:
            case ZHENG_WU_TE_11:
            case ZHENG_LIU_TE_11:
                numList.add("11");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_12:
            case TE_MA_B_12:
            case ZHENG_MA_12:
            case ZHENG_YI_TE_12:
            case ZHENG_ER_TE_12:
            case ZHENG_SAN_TE_12:
            case ZHENG_SI_TE_12:
            case ZHENG_WU_TE_12:
            case ZHENG_LIU_TE_12:

                numList.add("12");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_13:
            case TE_MA_B_13:
            case ZHENG_MA_13:
            case ZHENG_YI_TE_13:
            case ZHENG_ER_TE_13:
            case ZHENG_SAN_TE_13:
            case ZHENG_SI_TE_13:
            case ZHENG_WU_TE_13:
            case ZHENG_LIU_TE_13:

                numList.add("13");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_14:
            case TE_MA_B_14:
            case ZHENG_MA_14:
            case ZHENG_YI_TE_14:
            case ZHENG_ER_TE_14:
            case ZHENG_SAN_TE_14:
            case ZHENG_SI_TE_14:
            case ZHENG_WU_TE_14:
            case ZHENG_LIU_TE_14:

                numList.add("14");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_15:
            case TE_MA_B_15:
            case ZHENG_MA_15:
            case ZHENG_YI_TE_15:
            case ZHENG_ER_TE_15:
            case ZHENG_SAN_TE_15:
            case ZHENG_SI_TE_15:
            case ZHENG_WU_TE_15:
            case ZHENG_LIU_TE_15:

                numList.add("15");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_16:
            case TE_MA_B_16:
            case ZHENG_MA_16:
            case ZHENG_YI_TE_16:
            case ZHENG_ER_TE_16:
            case ZHENG_SAN_TE_16:
            case ZHENG_SI_TE_16:
            case ZHENG_WU_TE_16:
            case ZHENG_LIU_TE_16:

                numList.add("16");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_17:
            case TE_MA_B_17:
            case ZHENG_MA_17:
            case ZHENG_YI_TE_17:
            case ZHENG_ER_TE_17:
            case ZHENG_SAN_TE_17:
            case ZHENG_SI_TE_17:
            case ZHENG_WU_TE_17:
            case ZHENG_LIU_TE_17:

                numList.add("17");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_18:
            case TE_MA_B_18:
            case ZHENG_MA_18:
            case ZHENG_YI_TE_18:
            case ZHENG_ER_TE_18:
            case ZHENG_SAN_TE_18:
            case ZHENG_SI_TE_18:
            case ZHENG_WU_TE_18:
            case ZHENG_LIU_TE_18:

                numList.add("18");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_19:
            case TE_MA_B_19:
            case ZHENG_MA_19:
            case ZHENG_YI_TE_19:
            case ZHENG_ER_TE_19:
            case ZHENG_SAN_TE_19:
            case ZHENG_SI_TE_19:
            case ZHENG_WU_TE_19:
            case ZHENG_LIU_TE_19:

                numList.add("19");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_20:
            case TE_MA_B_20:
            case ZHENG_MA_20:
            case ZHENG_YI_TE_20:
            case ZHENG_ER_TE_20:
            case ZHENG_SAN_TE_20:
            case ZHENG_SI_TE_20:
            case ZHENG_WU_TE_20:
            case ZHENG_LIU_TE_20:

                numList.add("20");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_21:
            case TE_MA_B_21:
            case ZHENG_MA_21:
            case ZHENG_YI_TE_21:
            case ZHENG_ER_TE_21:
            case ZHENG_SAN_TE_21:
            case ZHENG_SI_TE_21:
            case ZHENG_WU_TE_21:
            case ZHENG_LIU_TE_21:

                numList.add("21");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_22:
            case TE_MA_B_22:
            case ZHENG_MA_22:
            case ZHENG_YI_TE_22:
            case ZHENG_ER_TE_22:
            case ZHENG_SAN_TE_22:
            case ZHENG_SI_TE_22:
            case ZHENG_WU_TE_22:
            case ZHENG_LIU_TE_22:

                numList.add("22");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_23:
            case TE_MA_B_23:
            case ZHENG_MA_23:
            case ZHENG_YI_TE_23:
            case ZHENG_ER_TE_23:
            case ZHENG_SAN_TE_23:
            case ZHENG_SI_TE_23:
            case ZHENG_WU_TE_23:
            case ZHENG_LIU_TE_23:

                numList.add("23");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_24:
            case TE_MA_B_24:
            case ZHENG_MA_24:
            case ZHENG_YI_TE_24:
            case ZHENG_ER_TE_24:
            case ZHENG_SAN_TE_24:
            case ZHENG_SI_TE_24:
            case ZHENG_WU_TE_24:
            case ZHENG_LIU_TE_24:

                numList.add("24");
                priBetNumbers.add(numList);

                break;

            case TE_MA_A_25:
            case TE_MA_B_25:
            case ZHENG_MA_25:
            case ZHENG_YI_TE_25:
            case ZHENG_ER_TE_25:
            case ZHENG_SAN_TE_25:
            case ZHENG_SI_TE_25:
            case ZHENG_WU_TE_25:
            case ZHENG_LIU_TE_25:

                numList.add("25");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_26:
            case TE_MA_B_26:
            case ZHENG_MA_26:
            case ZHENG_YI_TE_26:
            case ZHENG_ER_TE_26:
            case ZHENG_SAN_TE_26:
            case ZHENG_SI_TE_26:
            case ZHENG_WU_TE_26:
            case ZHENG_LIU_TE_26:

                numList.add("26");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_27:
            case TE_MA_B_27:
            case ZHENG_MA_27:
            case ZHENG_YI_TE_27:
            case ZHENG_ER_TE_27:
            case ZHENG_SAN_TE_27:
            case ZHENG_SI_TE_27:
            case ZHENG_WU_TE_27:
            case ZHENG_LIU_TE_27:

                numList.add("27");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_28:
            case TE_MA_B_28:
            case ZHENG_MA_28:
            case ZHENG_YI_TE_28:
            case ZHENG_ER_TE_28:
            case ZHENG_SAN_TE_28:
            case ZHENG_SI_TE_28:
            case ZHENG_WU_TE_28:
            case ZHENG_LIU_TE_28:

                numList.add("28");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_29:
            case TE_MA_B_29:
            case ZHENG_MA_29:
            case ZHENG_YI_TE_29:
            case ZHENG_ER_TE_29:
            case ZHENG_SAN_TE_29:
            case ZHENG_SI_TE_29:
            case ZHENG_WU_TE_29:
            case ZHENG_LIU_TE_29:

                numList.add("29");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_30:
            case TE_MA_B_30:
            case ZHENG_MA_30:
            case ZHENG_YI_TE_30:
            case ZHENG_ER_TE_30:
            case ZHENG_SAN_TE_30:
            case ZHENG_SI_TE_30:
            case ZHENG_WU_TE_30:
            case ZHENG_LIU_TE_30:

                numList.add("30");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_31:
            case TE_MA_B_31:
            case ZHENG_MA_31:
            case ZHENG_YI_TE_31:
            case ZHENG_ER_TE_31:
            case ZHENG_SAN_TE_31:
            case ZHENG_SI_TE_31:
            case ZHENG_WU_TE_31:
            case ZHENG_LIU_TE_31:

                numList.add("31");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_32:
            case TE_MA_B_32:
            case ZHENG_MA_32:
            case ZHENG_YI_TE_32:
            case ZHENG_ER_TE_32:
            case ZHENG_SAN_TE_32:
            case ZHENG_SI_TE_32:
            case ZHENG_WU_TE_32:
            case ZHENG_LIU_TE_32:

                numList.add("32");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_33:
            case TE_MA_B_33:
            case ZHENG_MA_33:
            case ZHENG_YI_TE_33:
            case ZHENG_ER_TE_33:
            case ZHENG_SAN_TE_33:
            case ZHENG_SI_TE_33:
            case ZHENG_WU_TE_33:
            case ZHENG_LIU_TE_33:

                numList.add("33");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_34:
            case TE_MA_B_34:
            case ZHENG_MA_34:
            case ZHENG_YI_TE_34:
            case ZHENG_ER_TE_34:
            case ZHENG_SAN_TE_34:
            case ZHENG_SI_TE_34:
            case ZHENG_WU_TE_34:
            case ZHENG_LIU_TE_34:

                numList.add("34");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_35:
            case TE_MA_B_35:
            case ZHENG_MA_35:
            case ZHENG_YI_TE_35:
            case ZHENG_ER_TE_35:
            case ZHENG_SAN_TE_35:
            case ZHENG_SI_TE_35:
            case ZHENG_WU_TE_35:
            case ZHENG_LIU_TE_35:

                numList.add("35");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_36:
            case TE_MA_B_36:
            case ZHENG_MA_36:
            case ZHENG_YI_TE_36:
            case ZHENG_ER_TE_36:
            case ZHENG_SAN_TE_36:
            case ZHENG_SI_TE_36:
            case ZHENG_WU_TE_36:
            case ZHENG_LIU_TE_36:

                numList.add("36");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_37:
            case TE_MA_B_37:
            case ZHENG_MA_37:
            case ZHENG_YI_TE_37:
            case ZHENG_ER_TE_37:
            case ZHENG_SAN_TE_37:
            case ZHENG_SI_TE_37:
            case ZHENG_WU_TE_37:
            case ZHENG_LIU_TE_37:

                numList.add("37");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_38:
            case TE_MA_B_38:
            case ZHENG_MA_38:
            case ZHENG_YI_TE_38:
            case ZHENG_ER_TE_38:
            case ZHENG_SAN_TE_38:
            case ZHENG_SI_TE_38:
            case ZHENG_WU_TE_38:
            case ZHENG_LIU_TE_38:

                numList.add("38");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_39:
            case TE_MA_B_39:
            case ZHENG_MA_39:
            case ZHENG_YI_TE_39:
            case ZHENG_ER_TE_39:
            case ZHENG_SAN_TE_39:
            case ZHENG_SI_TE_39:
            case ZHENG_WU_TE_39:
            case ZHENG_LIU_TE_39:

                numList.add("39");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_40:
            case TE_MA_B_40:
            case ZHENG_MA_40:
            case ZHENG_YI_TE_40:
            case ZHENG_ER_TE_40:
            case ZHENG_SAN_TE_40:
            case ZHENG_SI_TE_40:
            case ZHENG_WU_TE_40:
            case ZHENG_LIU_TE_40:

                numList.add("40");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_41:
            case TE_MA_B_41:
            case ZHENG_MA_41:
            case ZHENG_YI_TE_41:
            case ZHENG_ER_TE_41:
            case ZHENG_SAN_TE_41:
            case ZHENG_SI_TE_41:
            case ZHENG_WU_TE_41:
            case ZHENG_LIU_TE_41:

                numList.add("41");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_42:
            case TE_MA_B_42:
            case ZHENG_MA_42:
            case ZHENG_YI_TE_42:
            case ZHENG_ER_TE_42:
            case ZHENG_SAN_TE_42:
            case ZHENG_SI_TE_42:
            case ZHENG_WU_TE_42:
            case ZHENG_LIU_TE_42:

                numList.add("42");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_43:
            case TE_MA_B_43:
            case ZHENG_MA_43:
            case ZHENG_YI_TE_43:
            case ZHENG_ER_TE_43:
            case ZHENG_SAN_TE_43:
            case ZHENG_SI_TE_43:
            case ZHENG_WU_TE_43:
            case ZHENG_LIU_TE_43:

                numList.add("43");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_44:
            case TE_MA_B_44:
            case ZHENG_MA_44:
            case ZHENG_YI_TE_44:
            case ZHENG_ER_TE_44:
            case ZHENG_SAN_TE_44:
            case ZHENG_SI_TE_44:
            case ZHENG_WU_TE_44:
            case ZHENG_LIU_TE_44:

                numList.add("44");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_45:
            case TE_MA_B_45:
            case ZHENG_MA_45:
            case ZHENG_YI_TE_45:
            case ZHENG_ER_TE_45:
            case ZHENG_SAN_TE_45:
            case ZHENG_SI_TE_45:
            case ZHENG_WU_TE_45:
            case ZHENG_LIU_TE_45:

                numList.add("45");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_46:
            case TE_MA_B_46:
            case ZHENG_MA_46:
            case ZHENG_YI_TE_46:
            case ZHENG_ER_TE_46:
            case ZHENG_SAN_TE_46:
            case ZHENG_SI_TE_46:
            case ZHENG_WU_TE_46:
            case ZHENG_LIU_TE_46:

                numList.add("46");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_47:
            case TE_MA_B_47:
            case ZHENG_MA_47:
            case ZHENG_YI_TE_47:
            case ZHENG_ER_TE_47:
            case ZHENG_SAN_TE_47:
            case ZHENG_SI_TE_47:
            case ZHENG_WU_TE_47:
            case ZHENG_LIU_TE_47:

                numList.add("47");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_48:
            case TE_MA_B_48:
            case ZHENG_MA_48:
            case ZHENG_YI_TE_48:
            case ZHENG_ER_TE_48:
            case ZHENG_SAN_TE_48:
            case ZHENG_SI_TE_48:
            case ZHENG_WU_TE_48:
            case ZHENG_LIU_TE_48:

                numList.add("48");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_49:
            case TE_MA_B_49:
            case ZHENG_MA_49:
            case ZHENG_YI_TE_49:
            case ZHENG_ER_TE_49:
            case ZHENG_SAN_TE_49:
            case ZHENG_SI_TE_49:
            case ZHENG_WU_TE_49:
            case ZHENG_LIU_TE_49:

                numList.add("49");
                priBetNumbers.add(numList);

                break;

            case TE_MA_A_DA:
            case TE_MA_B_DA:
            case TE_MA_DA:

            case TE_MA_HE_DA:
            case TE_MA_WEI_DA:
            case TE_MA_HONG_DA:
            case TE_MA_LAN_DA:
            case TE_MA_LV_DA:

            case ZHENG_MA_ZONG_DA:
            case ZONG_HE_DA:

            case ZHENG_YI_HE_DA:
            case ZHENG_YI_LIANG_MIAN_DA:
            case ZHENG_YI_LIANG_MIAN_HE_DA:
            case ZHENG_YI_LIANG_MIAN_WEI_DA:
            case ZHENG_YI_MA_DA:
            case ZHENG_YI_WEI_DA:

            case ZHENG_ER_MA_DA:
            case ZHENG_ER_LIANG_MIAN_DA:
            case ZHENG_ER_HE_DA:
            case ZHENG_ER_LIANG_MIAN_HE_DA:
            case ZHENG_ER_LIANG_MIAN_WEI_DA:
            case ZHENG_ER_WEI_DA:

            case ZHENG_SAN_HE_DA:
            case ZHENG_SAN_LIANG_MIAN_DA:
            case ZHENG_SAN_LIANG_MIAN_HE_DA:
            case ZHENG_SAN_LIANG_MIAN_WEI_DA:
            case ZHENG_SAN_MA_DA:
            case ZHENG_SAN_WEI_DA:
            case ZHENG_SI_HE_DA:
            case ZHENG_SI_LIANG_MIAN_DA:
            case ZHENG_SI_LIANG_MIAN_HE_DA:
            case ZHENG_SI_LIANG_MIAN_WEI_DA:
            case ZHENG_SI_MA_DA:
            case ZHENG_SI_WEI_DA:
            case ZHENG_WU_HE_DA:
            case ZHENG_WU_LIANG_MIAN_DA:
            case ZHENG_WU_LIANG_MIAN_HE_DA:
            case ZHENG_WU_LIANG_MIAN_WEI_DA:
            case ZHENG_WU_MA_DA:
            case ZHENG_WU_WEI_DA:
            case ZHENG_LIU_HE_DA:
            case ZHENG_LIU_LIANG_MIAN_DA:
            case ZHENG_LIU_LIANG_MIAN_HE_DA:
            case ZHENG_LIU_LIANG_MIAN_WEI_DA:
            case ZHENG_LIU_MA_DA:
            case ZHENG_LIU_WEI_DA:

                numList.add(big);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_XIAO:
            case TE_MA_B_XIAO:
            case TE_MA_XIAO:

            case TE_MA_HE_XIAO:
            case TE_MA_WEI_XIAO:
            case TE_MA_HONG_XIAO:
            case TE_MA_LAN_XIAO:
            case TE_MA_LV_XIAO:

            case ZHENG_MA_ZONG_XIAO:
            case ZONG_HE_XIAO:

            case ZHENG_YI_HE_XIAO:
            case ZHENG_YI_LIANG_MIAN_XIAO:
            case ZHENG_YI_LIANG_MIAN_HE_XIAO:
            case ZHENG_YI_LIANG_MIAN_WEI_XIAO:
            case ZHENG_YI_MA_XIAO:
            case ZHENG_YI_WEI_XIAO:

            case ZHENG_ER_MA_XIAO:
            case ZHENG_ER_LIANG_MIAN_XIAO:
            case ZHENG_ER_HE_XIAO:
            case ZHENG_ER_LIANG_MIAN_HE_XIAO:
            case ZHENG_ER_LIANG_MIAN_WEI_XIAO:
            case ZHENG_ER_WEI_XIAO:

            case ZHENG_SAN_HE_XIAO:
            case ZHENG_SAN_LIANG_MIAN_XIAO:
            case ZHENG_SAN_LIANG_MIAN_HE_XIAO:
            case ZHENG_SAN_LIANG_MIAN_WEI_XIAO:
            case ZHENG_SAN_MA_XIAO:
            case ZHENG_SAN_WEI_XIAO:
            case ZHENG_SI_HE_XIAO:
            case ZHENG_SI_LIANG_MIAN_XIAO:
            case ZHENG_SI_LIANG_MIAN_HE_XIAO:
            case ZHENG_SI_LIANG_MIAN_WEI_XIAO:
            case ZHENG_SI_MA_XIAO:
            case ZHENG_SI_WEI_XIAO:
            case ZHENG_WU_HE_XIAO:
            case ZHENG_WU_LIANG_MIAN_XIAO:
            case ZHENG_WU_LIANG_MIAN_HE_XIAO:
            case ZHENG_WU_LIANG_MIAN_WEI_XIAO:
            case ZHENG_WU_MA_XIAO:
            case ZHENG_WU_WEI_XIAO:
            case ZHENG_LIU_HE_XIAO:
            case ZHENG_LIU_LIANG_MIAN_XIAO:
            case ZHENG_LIU_LIANG_MIAN_HE_XIAO:
            case ZHENG_LIU_LIANG_MIAN_WEI_XIAO:
            case ZHENG_LIU_MA_XIAO:
            case ZHENG_LIU_WEI_XIAO:
                numList.add(small);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_DAN:
            case TE_MA_B_DAN:
            case TE_MA_DAN:

            case TE_MA_HE_DAN:
            case TE_MA_HONG_DAN:
            case TE_MA_LAN_DAN:
            case TE_MA_LV_DAN:

            case ZHENG_MA_ZONG_DAN:
            case ZONG_HE_DAN:

            case ZHENG_YI_HE_DAN:
            case ZHENG_YI_LIANG_MIAN_DAN:
            case ZHENG_YI_LIANG_MIAN_HE_DAN:
            case ZHENG_YI_MA_DAN:

            case ZHENG_ER_MA_DAN:
            case ZHENG_ER_LIANG_MIAN_DAN:
            case ZHENG_ER_HE_DAN:
            case ZHENG_ER_LIANG_MIAN_HE_DAN:

            case ZHENG_SAN_HE_DAN:
            case ZHENG_SAN_LIANG_MIAN_DAN:
            case ZHENG_SAN_LIANG_MIAN_HE_DAN:
            case ZHENG_SAN_MA_DAN:
            case ZHENG_SI_HE_DAN:
            case ZHENG_SI_LIANG_MIAN_DAN:
            case ZHENG_SI_LIANG_MIAN_HE_DAN:
            case ZHENG_SI_MA_DAN:
            case ZHENG_WU_HE_DAN:
            case ZHENG_WU_LIANG_MIAN_DAN:
            case ZHENG_WU_LIANG_MIAN_HE_DAN:
            case ZHENG_WU_MA_DAN:
            case ZHENG_LIU_HE_DAN:
            case ZHENG_LIU_LIANG_MIAN_DAN:
            case ZHENG_LIU_LIANG_MIAN_HE_DAN:
            case ZHENG_LIU_MA_DAN:

                numList.add(single);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_SHUANG:
            case TE_MA_B_SHUANG:
            case TE_MA_SHUANG:

            case TE_MA_HE_SHUANG:
            case TE_MA_HONG_SHUANG:
            case TE_MA_LAN_SHUANG:
            case TE_MA_LV_SHUANG:

            case ZHENG_MA_ZONG_SHUANG:
            case ZONG_HE_SHUANG:

            case ZHENG_YI_HE_SHUANG:
            case ZHENG_YI_LIANG_MIAN_SHUANG:
            case ZHENG_YI_LIANG_MIAN_HE_SHUANG:
            case ZHENG_YI_MA_SHUANG:

            case ZHENG_ER_MA_SHUANG:
            case ZHENG_ER_LIANG_MIAN_SHUANG:
            case ZHENG_ER_HE_SHUANG:
            case ZHENG_ER_LIANG_MIAN_HE_SHUANG:

            case ZHENG_SAN_HE_SHUANG:
            case ZHENG_SAN_LIANG_MIAN_SHUANG:
            case ZHENG_SAN_LIANG_MIAN_HE_SHUANG:
            case ZHENG_SAN_MA_SHUANG:
            case ZHENG_SI_HE_SHUANG:
            case ZHENG_SI_LIANG_MIAN_SHUANG:
            case ZHENG_SI_LIANG_MIAN_HE_SHUANG:
            case ZHENG_SI_MA_SHUANG:
            case ZHENG_WU_HE_SHUANG:
            case ZHENG_WU_LIANG_MIAN_SHUANG:
            case ZHENG_WU_LIANG_MIAN_HE_SHUANG:
            case ZHENG_WU_MA_SHUANG:
            case ZHENG_LIU_HE_SHUANG:
            case ZHENG_LIU_LIANG_MIAN_SHUANG:
            case ZHENG_LIU_LIANG_MIAN_HE_SHUANG:
            case ZHENG_LIU_MA_SHUANG:

                numList.add(shuang);
                priBetNumbers.add(numList);
                break;

            case QI_SE_HONG_BO:
            case TE_MA_HONG_BO:
            case TE_MA_A_HONG:
            case TE_MA_B_HONG:
            case ZHENG_YI_HONG:
            case ZHENG_ER_HONG:
            case ZHENG_SAN_HONG:
            case ZHENG_SI_HONG:
            case ZHENG_WU_HONG:
            case ZHENG_LIU_HONG:
            case ZHENG_YI_LIANG_MIAN_HONG:
            case ZHENG_ER_LIANG_MIAN_HONG:
            case ZHENG_SAN_LIANG_MIAN_HONG:
            case ZHENG_LIU_LIANG_MIAN_HONG:
            case ZHENG_SI_LIANG_MIAN_HONG:
            case ZHENG_WU_LIANG_MIAN_HONG:

                numList.add(hong);
                priBetNumbers.add(numList);
                break;

            case QI_SE_LV_BO:
            case TE_MA_LV_BO:
            case TE_MA_A_LV:
            case TE_MA_B_LV:
            case ZHENG_YI_LV:
            case ZHENG_ER_LV:
            case ZHENG_SAN_LV:
            case ZHENG_SI_LV:
            case ZHENG_WU_LV:
            case ZHENG_LIU_LV:
            case ZHENG_YI_LIANG_MIAN_LV:
            case ZHENG_ER_LIANG_MIAN_LV:
            case ZHENG_SAN_LIANG_MIAN_LV:
            case ZHENG_LIU_LIANG_MIAN_LV:
            case ZHENG_SI_LIANG_MIAN_LV:
            case ZHENG_WU_LIANG_MIAN_LV:

                numList.add(lv);
                priBetNumbers.add(numList);
                break;

            case QI_SE_LAN_BO:
            case TE_MA_LAN_BO:
            case TE_MA_A_LAN:
            case TE_MA_B_LAN:
            case ZHENG_YI_LAN:
            case ZHENG_ER_LAN:
            case ZHENG_SAN_LAN:
            case ZHENG_SI_LAN:
            case ZHENG_WU_LAN:
            case ZHENG_LIU_LAN:
            case ZHENG_YI_LIANG_MIAN_LAN:
            case ZHENG_ER_LIANG_MIAN_LAN:
            case ZHENG_SAN_LIANG_MIAN_LAN:
            case ZHENG_LIU_LIANG_MIAN_LAN:
            case ZHENG_SI_LIANG_MIAN_LAN:
            case ZHENG_WU_LIANG_MIAN_LAN:

                numList.add(lan);
                priBetNumbers.add(numList);
                break;

            case QI_SE_HE_JU:
                numList.add("和");
                priBetNumbers.add(numList);
                break;

            // 头数
            case TE_MA_TOU_0:
                numList.add("0");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_1:
                numList.add("1");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_2:
                numList.add("2");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_3:
                numList.add("3");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_4:
                numList.add("4");
                priBetNumbers.add(numList);
                break;
            // 尾数
            case PING_TE_WEI_SHU_0:
            case TE_MA_WEI_0:
                numList.add("0");
                priBetNumbers.add(numList);
                break;
            case PING_TE_WEI_SHU_1:
            case TE_MA_WEI_1:
                numList.add("1");
                priBetNumbers.add(numList);
                break;
            case PING_TE_WEI_SHU_2:
            case TE_MA_WEI_2:
                numList.add("2");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_3:
            case TE_MA_WEI_3:
                numList.add("3");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_4:
            case TE_MA_WEI_4:
                numList.add("4");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_5:
            case TE_MA_WEI_5:
                numList.add("5");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_6:
            case TE_MA_WEI_6:
                numList.add("6");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_7:
            case TE_MA_WEI_7:
                numList.add("7");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_8:
            case TE_MA_WEI_8:
                numList.add("8");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_9:
            case TE_MA_WEI_9:
                numList.add("9");
                priBetNumbers.add(numList);
                break;

            // 合肖 二
            case HE_XIAO_ER:
                priBetNumbers.add(twoXiao);
                break;
            // 合肖 三
            case HE_XIAO_SAN:
                priBetNumbers.add(threeXiao);
                break;
            // 合肖 四
            case HE_XIAO_SI:
                priBetNumbers.add(fourXiao);
                break;
            // 合肖 五
            case HE_XIAO_WU:
                priBetNumbers.add(fiveXiao);
                break;
            // 合肖 六
            case HE_XIAO_LIU:
                priBetNumbers.add(sixXiao);
                break;
            // 合肖
            case HE_XIAO_QI:
                priBetNumbers.add(sevenXiao);
                break;

            case HE_XIAO_BA:
                priBetNumbers.add(eightXiao);
                break;

            case HE_XIAO_JIU:
                priBetNumbers.add(nineXiao);
                break;

            case HE_XIAO_SHI:
                priBetNumbers.add(tenXiao);
                break;

            case HE_XIAO_SHI_YI:
                priBetNumbers.add(elevenXiao);
                break;

            case PING_TE_YI_XIAO_SHU:
            case ZHENG_XIAO_SHU:
            case TE_XIAO_SHU:
                numList.add("鼠");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_NIU:
            case ZHENG_XIAO_NIU:
            case TE_XIAO_NIU:
                numList.add("牛");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_HU:
            case ZHENG_XIAO_HU:
            case TE_XIAO_HU:
                numList.add("虎");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_TU:
            case ZHENG_XIAO_TU:
            case TE_XIAO_TU:
                numList.add("兔");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_LONG:
            case ZHENG_XIAO_LONG:
            case TE_XIAO_LONG:
                numList.add("龙");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_SHE:
            case ZHENG_XIAO_SHE:
            case TE_XIAO_SHE:
                numList.add("蛇");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_MA:
            case ZHENG_XIAO_MA:
            case TE_XIAO_MA:
                numList.add("马");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_YANG:
            case ZHENG_XIAO_YANG:
            case TE_XIAO_YANG:
                numList.add("羊");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_HOU:
            case ZHENG_XIAO_HOU:
            case TE_XIAO_HOU:
                numList.add("猴");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_JI:
            case ZHENG_XIAO_JI:
            case TE_XIAO_JI:
                numList.add("鸡");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_GOU:
            case ZHENG_XIAO_GOU:
            case TE_XIAO_GOU:
                numList.add("狗");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_ZHU:
            case ZHENG_XIAO_ZHU:
            case TE_XIAO_ZHU:
                numList.add("猪");
                priBetNumbers.add(numList);
                break;

            case WU_XING_JIN:
                numList.add("金");
                priBetNumbers.add(numList);
                break;
            case WU_XING_MU:
                numList.add("木");
                priBetNumbers.add(numList);
                break;
            case WU_XING_SHUI:
                numList.add("水");
                priBetNumbers.add(numList);
                break;
            case WU_XING_HUO:
                numList.add("火");
                priBetNumbers.add(numList);
                break;
            case WU_XING_TU:
                numList.add("土");
                priBetNumbers.add(numList);
                break;

            // 尾数
            case ER_LIAN_WEI_0:
            case ER_LIAN_WEI_FEI_0:
                priBetNumbers.add(twoWeishu);
                break;

            case SAN_LIAN_WEI_0:
            case SAN_LIAN_WEI_FEI_0:
                priBetNumbers.add(threeWeishu);
                break;

            case SI_LIAN_WEI_0:
            case SI_LIAN_WEI_FEI_0:
                priBetNumbers.add(fourWeishu);
                break;

            case WU_LIAN_WEI_0:
            case WU_LIAN_WEI_FEI_0:
                priBetNumbers.add(fiveWeishu);
                break;

            case ER_LIAN_XIAO_BEN_MING:
            case ER_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(twoXiao);
                break;

            case SAN_LIAN_XIAO_BEN_MING:
            case SAN_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(threeXiao);
                break;

            case SI_LIAN_XIAO_BEN_MING:
            case SI_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(fourXiao);
                break;

            case WU_LIAN_XIAO_BEN_MING:
            case WU_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(fiveXiao);
                break;

            case LIAN_MA_ER_QUAN_ZHONG:
            case LIAN_MA_ER_ZHONG_TE:
            case LIAN_MA_ER_ZHONG_ER:
            case LIAN_MA_TE_CHUAN:
                priBetNumbers.add(sixNumber);
                break;

            case LIAN_MA_SAN_QUAN_ZHONG:
            case LIAN_MA_SAN_ZHONG_ER:

                priBetNumbers.add(sevenNumber);
                break;

            case LIAN_MA_SI_QUAN_ZHONG:
                priBetNumbers.add(eightNumber);
                break;

            case ZI_XUAN_BU_ZHONG_5:
                priBetNumbers.add(fiveNumber);
                break;
            case ZI_XUAN_BU_ZHONG_6:
                priBetNumbers.add(sixNumber);
                break;
            case ZI_XUAN_BU_ZHONG_7:
                priBetNumbers.add(sevenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_8:
                priBetNumbers.add(eightNumber);
                break;
            case ZI_XUAN_BU_ZHONG_9:
                priBetNumbers.add(nineNumber);
                break;
            case ZI_XUAN_BU_ZHONG_10:
                priBetNumbers.add(tenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_11:
                priBetNumbers.add(elevenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_12:
                priBetNumbers.add(twelveNumber);
                break;

            case TE_TIAN_XIAO:
                numList.add("天肖");
                priBetNumbers.add(numList);
                break;
            case TE_DI_XIAO:
                numList.add("地肖");
                priBetNumbers.add(numList);
                break;
            case TE_QIAN_XIAO:
                numList.add("前肖");
                priBetNumbers.add(numList);
                break;
            case TE_HOU_XIAO:
                numList.add("后肖");
                priBetNumbers.add(numList);
                break;
            case TE_JIA_XIAO:
                numList.add("家肖");
                priBetNumbers.add(numList);
                break;
            case TE_YE_XIAO:
                numList.add("野肖");
                priBetNumbers.add(numList);
                break;

            case ZONG_ER_XIAO:
                numList.add("2");
                priBetNumbers.add(numList);
                break;
            case ZONG_SAN_XIAO:
                numList.add("3");
                priBetNumbers.add(numList);
                break;
            case ZONG_SI_XIAO:
                numList.add("4");
                priBetNumbers.add(numList);
                break;
            case ZONG_WU_XIAO:
                numList.add("5");
                priBetNumbers.add(numList);
                break;
            case ZONG_LIU_XIAO:
                numList.add("6");
                priBetNumbers.add(numList);
                break;
            case ZONG_QI_XIAO:
                numList.add("7");
                priBetNumbers.add(numList);
                break;

            case ZONG_SHUANG_XIAO:
            case ZONG_DAN_XIAO:
            case TE_MA_DA_DAN:
            case TE_MA_DA_SHUANG:
            case TE_MA_XIAO_DAN:
            case TE_MA_XIAO_SHUANG:
            case TE_MA_LV_DA_SHUANG:
            case TE_MA_LAN_DA_SHUANG:
            case TE_MA_LV_DA_DAN:
            case TE_MA_LAN_DA_DAN:
            case TE_MA_HONG_DA_DAN:
            case TE_MA_LV_XIAO_DAN:
            case TE_MA_LAN_XIAO_DAN:
            case TE_MA_HONG_XIAO_DAN:
            case TE_MA_HONG_DA_SHUANG:
            case TE_MA_LV_XIAO_SHUANG:
            case TE_MA_LAN_XIAO_SHUANG:
            case TE_MA_HONG_XIAO_SHUANG:
                numList.add("大小单双");
                priBetNumbers.add(numList);
                break;

        }

        return priBetNumbers;
    }

    // 获取随机的开奖号码
    public String getMark6RandomKjNumbers() {

        List<String> list = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(String.valueOf(i));
            list.add(stringBuilder.toString());
        }
        Collections.shuffle(list);

        StringBuilder kjSBuilder = new StringBuilder();

        kjSBuilder
                .append(list.get(0)).append(",")
                .append(list.get(1)).append(",")
                .append(list.get(2)).append(",")
                .append(list.get(3)).append(",")
                .append(list.get(4)).append(",")
                .append(list.get(5)).append(",")
                .append(list.get(6));

        return kjSBuilder.toString();
    }

}
