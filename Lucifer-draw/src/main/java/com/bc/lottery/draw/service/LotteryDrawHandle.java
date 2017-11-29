package com.bc.lottery.draw.service;

import com.babel.forseti_order.model.UserOrderPO;
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
    UserOrderPO getBoundsInfoOfLottery(String kj, UserOrderPO order);

    /**
     * 批量获取奖金信息
     *
     * @param lotteryType
     * @param kj
     * @param orderList
     * @return
     */
    List<UserOrderPO> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<UserOrderPO> orderList);

    /**
     * 获取彩票开奖号码的中奖玩法--双面长龙
     *
     * @param lotteryId
     * @param str
     * @return
     */
    List<Long> getLotteryBetPlayIds(long lotteryId, String str);
}
