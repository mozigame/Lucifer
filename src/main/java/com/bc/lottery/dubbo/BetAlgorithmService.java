package com.bc.lottery.dubbo;

import com.bc.lottery.entity.LotteryOrder;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 15:52
 **/
public interface BetAlgorithmService {

    /**
     * 获取下注单数
     * @param lotteryOrder
     * @return
     */
    long getLotteryOrderNum(LotteryOrder lotteryOrder);

}
