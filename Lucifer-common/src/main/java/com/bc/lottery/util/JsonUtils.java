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

    public static void main(String[] args) {

        String string = "12,345,67,890,11";
        List<List<String>> jsonList = json2LotteryList(string);
        System.out.println(jsonList);

        String zhixuanStr = "1234  3456  5567  9845";
        List<List<String>> zhixuanList = danShiJson2LotteryList(zhixuanStr);
        System.out.println(zhixuanList);

        String danhangStr = "1,2,4,22,23,1";
        List<List<String>> danhangList = oneOnlyJson2LotteryList(danhangStr);
        System.out.println(danhangList);
    }
}
