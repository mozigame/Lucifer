package com.bc.lottery.util;

import com.bc.lottery.entity.LotteryOrder;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;

import java.util.*;

/**
 * User: clion
 * Date: 2017/9/5
 * Time: 14:17
 **/
public class LotteryOrderTest {

    public List<LotteryOrder> getLotteryOrderList(LotteryType lotteryType) {
        List<LotteryOrder> orderList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            LotteryOrder lotteryOrder = new LotteryOrder();
            lotteryOrder.setOrderNo("testOrderNo111");
            List<List<String>> betNumbersByType = getBetNumbersByType(lotteryType);
            lotteryOrder.setBetNumbers(betNumbersByType);
            orderList.add(lotteryOrder);
        }
        return orderList;
    }

    public List<List<String>> getBetNumbersByType(LotteryType lotteryType) {
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
        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();
        List<String> priBetNumber1 = new ArrayList<>();
        //五星
        if (lotteryType instanceof ShishicaiType.Wuxing) {
            ShishicaiType.Wuxing wuxingType = (ShishicaiType.Wuxing) lotteryType;
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (wuxingType) {
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
            }
        }
        //四星
        if (lotteryType instanceof ShishicaiType.Sixing) {
            ShishicaiType.Sixing sixingType = (ShishicaiType.Sixing) lotteryType;
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            switch (sixingType) {
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
            }
        }
        //三星
        if (lotteryType instanceof ShishicaiType.Sanxing) {
            ShishicaiType.Sanxing sanxingType = (ShishicaiType.Sanxing) lotteryType;
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            switch (sanxingType) {
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
            }
        }
        if (lotteryType instanceof ShishicaiType.Erxing) {
            ShishicaiType.Erxing erxingType = (ShishicaiType.Erxing) lotteryType;
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (erxingType) {
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_DAN_SHI:

                    List<String> arrList = new ArrayList<>();
                    arrList.addAll(Arrays.asList(sixNumber));
                    arrList.addAll(Arrays.asList(fourNumber));
                    priBetNumbers.add(arrList);

                    break;
                case HOU_ER_ZU_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:

                    String[] zuxuanhezhi = new String[4];
                    zuxuanhezhi[0] = String.valueOf(new Random().nextInt(17) + 1);
                    zuxuanhezhi[1] = String.valueOf(new Random().nextInt(17) + 1);
                    zuxuanhezhi[2] = String.valueOf(new Random().nextInt(17) + 1);
                    zuxuanhezhi[3] = String.valueOf(new Random().nextInt(17) + 1);
                    priBetNumbers.add(Arrays.asList(zuxuanhezhi));
                    break;

                case HOU_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;
            }
        }
        if (lotteryType instanceof ShishicaiType.Yixing) {
            ShishicaiType.Yixing yixingType = (ShishicaiType.Yixing) lotteryType;
            priBetNumber0.clear();
            switch (yixingType) {
                case YI_XING_DING_WEI_DAN:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    priBetNumbers.add(Arrays.asList(sixNumber));

                    break;
            }
        }
        if (lotteryType instanceof ShishicaiType.Budingdan) {
            ShishicaiType.Budingdan budingdanType = (ShishicaiType.Budingdan) lotteryType;
            priBetNumber0.clear();
            switch (budingdanType) {
                case HOU_SAN_ER_MA:
                case QIAN_SAN_ER_MA:
                case HOU_SAN_YI_MA:
                case QIAN_SAN_YI_MA:
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    break;
            }
        }
        if (lotteryType instanceof ShishicaiType.Daxiaodanshuang) {
            ShishicaiType.Daxiaodanshuang daxiaodanshuangType = (ShishicaiType.Daxiaodanshuang) lotteryType;
            priBetNumber0.clear();
            priBetNumber1.clear();
            switch (daxiaodanshuangType) {
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
            }
        }
        if (lotteryType instanceof ShishicaiType.Quwei) {
            ShishicaiType.Quwei quweiType = (ShishicaiType.Quwei) lotteryType;
            priBetNumber0.clear();
            switch (quweiType) {
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
}
