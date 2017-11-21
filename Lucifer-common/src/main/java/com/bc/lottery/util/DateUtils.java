package com.bc.lottery.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    public static void main(String[] args) {

        String str = "0";
        System.out.println(str.substring(0,1));

    }
}
