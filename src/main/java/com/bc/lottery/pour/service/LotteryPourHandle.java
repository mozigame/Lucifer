package com.bc.lottery.pour.service;

import com.bc.lottery.entity.BoundsInfo;
import com.bc.lottery.entity.LotteryOrder;
import com.bc.lottery.entity.LotteryType;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 13:51
 **/
public interface LotteryPourHandle {

    /**
     * 获取彩票注单数量
     *
     * @param betNumbers
     * @param lotteryType
     * @return
     */
    long getBetCount(List<List<String>> betNumbers, LotteryType lotteryType);

}
