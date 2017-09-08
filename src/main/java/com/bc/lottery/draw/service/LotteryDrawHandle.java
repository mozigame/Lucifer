package com.bc.lottery.draw.service;

import com.bc.lottery.entity.BoundsInfo;
import com.bc.lottery.entity.LotteryOrder;
import com.bc.lottery.entity.LotteryType;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 13:51
 **/
public interface LotteryDrawHandle {

    /**
     * 根据指定彩票类型和号码获取奖金信息
     *
     * @param lotteryType 彩票类型
     * @param kj          中奖号
     * @param betNumbers  下注号
     * @return 中奖信息
     */
    BoundsInfo getBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<List<String>> betNumbers);

    /**
     * 根据批量获取奖金信息
     *
     * @param lotteryType
     * @param kj
     * @param orderList
     * @return
     */
    List<BoundsInfo> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<LotteryOrder> orderList);
}
