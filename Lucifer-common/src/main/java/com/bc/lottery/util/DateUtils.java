package com.bc.lottery.util;

import java.util.Calendar;

/**
 * 日期相关工具类
 * Created by clion on 2017/9/13.
 */

public class DateUtils {

    /**
     * 获取当前年
     *
     * @param
     * @return
     */
    public static int getCurrYear() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    /**
     * 获取当前农历年
     *
     * @param
     * @return
     */
    public static int getCurrLunarYear() {

        // 获取当前时间
        Long currTime = System.currentTimeMillis();

        Long startTimeOf2018 = 1518710400000L;
        Long startTimeOf2019 = 1549296000000L;
        Long startTimeOf2020 = 1579881600000L;
        Long startTimeOf2021 = 1613059200000L;
        Long startTimeOf2022 = 1643644800000L;


        if (currTime < startTimeOf2018) {
            return 2017;
        } else if (currTime >= startTimeOf2018 && currTime < startTimeOf2019) {
            return 2018;
        } else if (currTime >= startTimeOf2019 && currTime < startTimeOf2020) {
            return 2019;
        } else if (currTime >= startTimeOf2020 && currTime < startTimeOf2021) {
            return 2020;
        } else if (currTime >= startTimeOf2021 && currTime < startTimeOf2022) {
            return 2021;
        } else {
            return 2022;
        }
    }

    public static void main(String[] args) {

        String str = "0";
        System.out.println(str.substring(0, 1));

        System.out.println(getCurrLunarYear());
    }
}
