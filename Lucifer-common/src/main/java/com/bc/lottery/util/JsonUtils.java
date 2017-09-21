package com.bc.lottery.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Json相关工具类
 * Created by clion on 2017/9/13.
 */

public class JsonUtils {


    /**
     * 将前端传入的指定字符串转换成彩票格式的List
     *
     * @param str
     * @return
     */
    public static List<List<String>> json2LotteryList(String str) {

        List<List<String>> resultList = new ArrayList<>();
        if (str == null || str.trim().equals("")) {
            return resultList;
        }
        String[] strArr = str.split(",");
        if (strArr.length != 0) {
            for (String innerStr : strArr) {
                String[] orderStrArr = innerStr.split("");
                if (orderStrArr.length != 0) {
                    List<String> strList = Arrays.asList(orderStrArr);
                    resultList.add(strList);
                }
            }
        }
        return resultList;
    }


    /**
     * 直选类型json转成彩票格式的List
     *
     * @param str
     * @return
     */
    public static List<List<String>> danShiJson2LotteryList(String str) {

        List<List<String>> resultList = new ArrayList<>();
        if (str == null || str.trim().equals("")) {
            return resultList;
        }
        String[] strArr = str.split(" ");
        if (strArr.length != 0) {
            List<String> strList = new ArrayList<>();
            for (String innerStr : strArr) {
                String[] orderStrArr = innerStr.split("");
                if (orderStrArr.length != 0) {
                    for (String aimStr : orderStrArr) {
                        if (!aimStr.trim().equals("")) {
                            strList.add(aimStr);
                        }
                    }
                }
            }
            resultList.add(strList);
        }
        return resultList;

    }

    /**
     * 单行玩法json转成彩票格式的List
     *
     * @param str
     * @return
     */
    public static List<List<String>> oneOnlyJson2LotteryList(String str) {

        List<List<String>> resultList = new ArrayList<>();
        if (str == null || str.trim().equals("")) {
            return resultList;
        }
        String[] strArr = str.split(",");
        List<String> strList = Arrays.asList(strArr);

        resultList.add(strList);

        return resultList;

    }

    /**
     * 彩票玩法转换成string
     *
     * @param stringList
     * @return
     */
    public static String lotteryList2Json(List<List<String>> stringList) {

        StringBuilder returnBuilder = new StringBuilder();
        if (stringList == null || stringList.size() == 0) {
            return "";
        }
        for (int i = 0; i < stringList.size(); i++) {
            if (i != 0) {
                returnBuilder.append(",");
            }
            StringBuilder innerString = new StringBuilder();
            if (stringList.get(i).size() > 0) {
                for (String str : stringList.get(i)) {
                    innerString.append(str);
                }
            }
            returnBuilder.append(innerString);
        }
        return returnBuilder.toString();
    }

    /**
     * 彩票玩法转换成单式
     *
     * @param stringList
     * @param size
     * @return
     */
    public static String lotteryListToDanShi(List<List<String>> stringList, int size) {

        StringBuilder returnBuilder = new StringBuilder();
        if (stringList == null || stringList.size() == 0) {
            return "";
        }
        if (stringList.get(0).size() > 0) {
            for (int i = 0; i < stringList.get(0).size(); i++) {

                returnBuilder.append(stringList.get(0).get(i));
                if ((i + 1) % size == 0) {
                    returnBuilder.append(" ");
                }
            }
        }
        return returnBuilder.toString();

    }

    /**
     * 彩票格式的List转换成单行类型json
     *
     * @param stringList
     * @return
     */
    public static String lotteryList2OneOnlyJson(List<List<String>> stringList) {

        StringBuilder returnBuilder = new StringBuilder();
        if (stringList == null || stringList.size() == 0) {
            return "";
        }
        if (stringList.get(0).size() > 0) {
            for (int i = 0; i < stringList.get(0).size(); i++) {
                if (i != 0) {
                    returnBuilder.append(",");
                }
                returnBuilder.append(stringList.get(0).get(i));
            }
        }
        return returnBuilder.toString();

    }

    public static void main(String[] args) {

        String string = "12,345,67,890,11";
        List<List<String>> jsonList = json2LotteryList(string);
        System.out.println(jsonList);
        System.out.println(string);
        String jsonString = lotteryList2Json(jsonList);
        System.out.println(jsonString);

        String zhixuanStr = "1234  3456  5567  9845";
        List<List<String>> zhixuanList = danShiJson2LotteryList(zhixuanStr);
        System.out.println(zhixuanList);
        System.out.println(zhixuanStr);
        String danshiString = lotteryListToDanShi(zhixuanList,4);
        System.out.println(danshiString);

        String danhangStr = "1,2,4,22,23,1";
        List<List<String>> danhangList = oneOnlyJson2LotteryList(danhangStr);
        System.out.println(danhangList);
        System.out.println(danhangStr);
        String onlyOneString = lotteryList2OneOnlyJson(danhangList);
        System.out.println(onlyOneString);

    }
}
