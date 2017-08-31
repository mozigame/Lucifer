package com.bc.lottery.entity;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 15:53
 **/
public class LotteryOrder {

    private String lotteryType; // 彩票类型
    private String tenThousand; // 万位
    private String thousand;    // 千位
    private String hundred;     // 百位
    private String ten;         // 十位
    private String unit;        // 个位

    List<List<String>> betNumbers; // 所选号码组合列表

    @Override
    public String toString() {
        return "LotteryOrder{" +
                "lotteryType='" + lotteryType + '\'' +
                ", tenThousand='" + tenThousand + '\'' +
                ", thousand='" + thousand + '\'' +
                ", hundred='" + hundred + '\'' +
                ", ten='" + ten + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public String getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(String lotteryType) {
        this.lotteryType = lotteryType;
    }

    public String getTenThousand() {
        return tenThousand;
    }

    public void setTenThousand(String tenThousand) {
        this.tenThousand = tenThousand;
    }

    public String getThousand() {
        return thousand;
    }

    public void setThousand(String thousand) {
        this.thousand = thousand;
    }

    public String getHundred() {
        return hundred;
    }

    public void setHundred(String hundred) {
        this.hundred = hundred;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<List<String>> getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(List<List<String>> betNumbers) {
        this.betNumbers = betNumbers;
    }
}
