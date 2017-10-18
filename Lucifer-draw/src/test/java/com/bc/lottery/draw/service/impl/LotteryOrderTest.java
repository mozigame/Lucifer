package com.bc.lottery.draw.service.impl;


import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.Lottery11x5DoubleType;
import com.bc.lottery.entity.ShishicaiDoubleType;
import com.bc.lottery.entity.ShishicaiType;

import java.util.*;

/**
 * User: clion
 * Date: 2017/9/5
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
        } else if (lotteryId == 4) {
            String numBig = "大";
            String numSmall = "小";
            String numSingle = "单";
            String numDouble = "双";
            String numDragon = "龙";
            String numTiger = "虎";
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
                    break;
                case WU_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case ZONG_HE_SHUANG:
                case YI_QIU_SHUANG:
                    numList.add(numDouble);
                    break;
                case ZONG_HE_WEI_DA:
                case WU_QIU_DA:
                case SI_QIU_DA:
                case SAN_QIU_DA:
                case ER_QIU_DA:
                case ZONG_HE_DA:
                case YI_QIU_DA:
                    numList.add(numBig);
                    break;
                case ZONG_HE_WEI_XIAO:
                case WU_QIU_XIAO:
                case SI_QIU_XIAO:
                case SAN_QIU_XIAO:
                case ER_QIU_XIAO:
                case ZONG_HE_XIAO:
                case YI_QIU_XIAO:
                    numList.add(numSmall);
                    break;
                case ZONG_HE_LONG:
                    numList.add(numDragon);
                    break;
                case ZONG_HE_HU:
                    numList.add(numTiger);
                    break;
            }
            priBetNumbers.add(numList);
            return priBetNumbers;
        }
        return priBetNumbers;
    }
}
