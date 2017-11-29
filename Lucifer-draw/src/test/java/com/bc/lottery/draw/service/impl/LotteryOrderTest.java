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

        } else if (lotteryId == 2) {
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
        } else if (lotteryId == 3) {

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
        } else if (lotteryId == 4) {
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
        } else if (lotteryId == 6) {
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
        } else if (lotteryId == 7) {

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
        } else if (lotteryId == 8) {
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
        }else if(lotteryId==60){

            List<String> numList = new ArrayList<>();
            String first = "01";
            String second = "02";
            String third = "03";
            String fourth = "04";
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
            LotteryMark6DoubleType lotteryMark6DoubleType = LotteryMark6DoubleType.parse(playId);
            switch (lotteryMark6DoubleType) {



            }



        }
        return priBetNumbers;
    }
}
