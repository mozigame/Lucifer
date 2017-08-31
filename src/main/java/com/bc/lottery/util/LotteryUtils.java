package com.bc.lottery.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Lottery相关工具计算类
 * Created by luis on 2017/4/13.
 */

public class LotteryUtils {

    /**
     * 相乘
     *
     * @param args
     * @return
     */
    public static long toMultiplyAll(int... args) {
        if (args == null) {
            return 0;
        }
        long result = 1;
        for (int i : args) {
            result *= i;
        }
        return result;
    }

    public static long toMultiplyAll(List<List<String>> args) {
        if (args == null || args.isEmpty()) {
            return 0;
        }
        long result = 1;
        for (List<String> i : args) {
            result *= i.size();
        }
        return result;
    }

    /**
     * 相加
     *
     * @param args
     * @return
     */
    private static long toPlusAll(int... args) {
        if (args == null) {
            return 0;
        }
        long result = 1;
        for (int i : args) {
            result += i;
        }
        return result;
    }

    public static long toPlusAll(List<List<String>> args) {
        if (args == null || args.isEmpty()) {
            return 0;
        }
        long result = 1;
        for (List<String> i : args) {
            result += i.size();
        }
        return result;
    }

    /**
     * 2列组合去重
     *
     * @param a    第一组需选的号码数
     * @param b    第二组需选的号码数
     * @param args
     * @return
     */
    public static long twoCombinationRemoveRepeat(int a, int b, List<List<String>> args) {
        if (a <= 0 || b <= 0) {
            return 0;
        }
        if (args == null || args.size() < 2) {
            return 0;
        }
        return twoCombinationRemoveRepeat(a, args.get(0).size(), b, args.get(1).size(), (int) LotteryUtils.intersectionOfSetNum(args.get(0), args.get(1)));
    }

    /**
     * 取交集元素个数
     *
     * @param a
     * @param b
     * @return
     */
    public static long intersectionOfSetNum(List<String> a, List<String> b) {
        if (a == null || a.isEmpty() || b == null || b.isEmpty()) {
            return 0;
        }
        List<String> temp = new ArrayList<>();
        temp.addAll(a);
        temp.retainAll(b);
        return temp.size();
    }

    public static long intersectionOfSetNum(List<String> a, List<String>... b) {
        if (a == null || a.isEmpty() || b == null || b.length == 0) {
            return 0;
        }
        List<String> temp = new ArrayList<>();
        temp.addAll(a);
        for (List<String> list : b) {
            temp.retainAll(list);
        }
        return temp.size();
    }

    /**
     * 组合去重
     * C(m,a)*C(n,b)-k*C(m-1,a-1)*C(n-1,b-1)
     *
     * @param a
     * @param b
     * @param m
     * @param n
     * @param k 重复数
     * @return
     */
    private static long twoCombinationRemoveRepeat(int a, int m, int b, int n, int k) {
        if (a <= 0 || b <= 0 || m <= 0 || n <= 0 || k < 0) {
            return 0;
        }
        return (combination(m, a) * combination(n, b)) - (k * combination(m - 1, a - 1) * combination(n - 1, b - 1));
    }

    /**
     * 计算组合数
     * C(n,r) = n!/(r!*(n-r)!)
     *
     * @param n
     * @param r
     * @return
     */
    public static long combination(int n, int r) {

        if (r < 0 || n < r) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return factorialLoop(n) / (factorialLoop(r) * factorialLoop(n - r));
    }

    /**
     * 循环实现阶乘算法
     *
     * @param n [0, 12] 用int型: (12, 20] 用long: (20, 用BigInteger
     * @return
     */
    private static long factorialLoop(int n) {
        // 阶乘对整数才有意义
        if (n < 0) {
            return 0;
        }

        // 0！=1，（0 的阶乘是存在的）
        if (n == 0) {
            return 1;
        }

        // 初始值必须为1才有意义
        long result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }

        return result;
    }

    /**
     * 大数计算组合数
     *
     * @param n
     * @param r
     * @return
     */
    public static long combinationBig(int n, int r) {
        if (n < 0 || r < 0) {
            return 0;
        }
        if (n == 0 || r == 0) {
            return 1;
        }
        if (r > n) {
            return 0;
        }
        if (r > n / 2) {
            r = n - r;
        }
        double result = 0;
        for (int i = n; i >= (n - r + 1); i--) {
            //下面的函数返回指定变量的自然对数：
            result += Math.log(i);
        }
        for (int i = r; i >= 1; i--) {
            result -= Math.log(i);
        }
        result = Math.exp(result);
        //方法可把一个数字舍入为最接近的整数。
        return Math.round(result);
    }

    public static void main(String[] args) {
        System.out.println(combinationBig(21, 4));
    }

}
