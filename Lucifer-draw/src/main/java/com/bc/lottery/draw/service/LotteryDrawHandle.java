package com.bc.lottery.draw.service;

import com.babel.venus.po.UserOrder;
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
     * @param kj          中奖号
     * @return 中奖信息
     */
    UserOrder getBoundsInfoOfLottery(String kj, UserOrder order);

    /**
     * 根据批量获取奖金信息
     *
     * @param lotteryType
     * @param kj
     * @param orderList
     * @return
     */
    List<UserOrder> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<UserOrder> orderList);
}
