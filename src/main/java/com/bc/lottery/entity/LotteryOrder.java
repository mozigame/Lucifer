package com.bc.lottery.entity;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 15:53
 **/
public class LotteryOrder {

    private String orderNo; // 注单编号
    List<List<String>> betNumbers; // 所选号码组合列表
    private int multipleNum;   // 投注倍数

    @Override
    public String toString() {
        return "LotteryOrder{" +
                "orderNo='" + orderNo + '\'' +
                ", betNumbers=" + betNumbers +
                ", multipleNum=" + multipleNum +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public List<List<String>> getBetNumbers() {
        return betNumbers;
    }

    public void setBetNumbers(List<List<String>> betNumbers) {
        this.betNumbers = betNumbers;
    }

    public int getMultipleNum() {
        return multipleNum;
    }

    public void setMultipleNum(int multipleNum) {
        this.multipleNum = multipleNum;
    }
}
