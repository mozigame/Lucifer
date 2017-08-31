package com.bc.lottery.entity;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 15:53
 **/
public class LotteryOrder {

    private String orderNo; // 注单编号
    private LotteryType lotteryType; // 彩票类型
    List<List<String>> betNumbers; // 所选号码组合列表

    @Override
    public String toString() {
        return "LotteryOrder{" +
                "orderNo='" + orderNo + '\'' +
                ", lotteryType=" + lotteryType +
                ", betNumbers=" + betNumbers +
                '}';
    }

    public List<List<String>> getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(List<List<String>> betNumbers) {
        this.betNumbers = betNumbers;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LotteryType getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(LotteryType lotteryType) {
        this.lotteryType = lotteryType;
    }
}
