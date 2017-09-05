package com.bc.lottery.entity;

/**
 * User: clion
 * Date: 2017/8/31
 * Time: 11:25
 **/
public class BoundsInfo {

    // PS:如果是三星组选和值玩法或是三星混合组选玩法，一等奖为组三一等奖，二等奖为组六一等奖
    private LotteryType lotteryType; // 时时彩类型
    private String orderNo;    // 注单编号
    private int firstPrizeNum; // 一等奖次数
    private int secondPrizeNum;// 二等奖次数
    private int thirdPrizeNum; // 三等奖次数
    private int forthPrizeNum; // 四等奖次数
    private int fifthPrizeNum; // 五等奖次数
    private int multipleNum;   // 投注倍数

    @Override
    public String toString() {
        return "BoundsInfo{" +
                "lotteryType=" + lotteryType +
                ", orderNo='" + orderNo + '\'' +
                ", firstPrizeNum=" + firstPrizeNum +
                ", secondPrizeNum=" + secondPrizeNum +
                ", thirdPrizeNum=" + thirdPrizeNum +
                ", forthPrizeNum=" + forthPrizeNum +
                ", fifthPrizeNum=" + fifthPrizeNum +
                ", multipleNum=" + multipleNum +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public int getFirstPrizeNum() {
        return firstPrizeNum;
    }

    public void setFirstPrizeNum(int firstPrizeNum) {
        this.firstPrizeNum = firstPrizeNum;
    }

    public int getSecondPrizeNum() {
        return secondPrizeNum;
    }

    public void setSecondPrizeNum(int secondPrizeNum) {
        this.secondPrizeNum = secondPrizeNum;
    }

    public int getThirdPrizeNum() {
        return thirdPrizeNum;
    }

    public void setThirdPrizeNum(int thirdPrizeNum) {
        this.thirdPrizeNum = thirdPrizeNum;
    }

    public int getMultipleNum() {
        return multipleNum;
    }

    public void setMultipleNum(int multipleNum) {
        this.multipleNum = multipleNum;
    }

    public int getForthPrizeNum() {
        return forthPrizeNum;
    }

    public void setForthPrizeNum(int forthPrizeNum) {
        this.forthPrizeNum = forthPrizeNum;
    }

    public int getFifthPrizeNum() {
        return fifthPrizeNum;
    }

    public void setFifthPrizeNum(int fifthPrizeNum) {
        this.fifthPrizeNum = fifthPrizeNum;
    }

    public LotteryType getLotteryType() {
        return lotteryType;
    }

    public void setLotteryType(LotteryType lotteryType) {
        this.lotteryType = lotteryType;
    }
}
