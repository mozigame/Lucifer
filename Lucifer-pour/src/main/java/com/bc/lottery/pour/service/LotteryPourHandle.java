package com.bc.lottery.pour.service;

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
     * @param playId
     * @return
     */
    long getBetCount(List<List<String>> betNumbers, Long playId);

    /**
     * 生成随机注单
     *
     * @param playId
     * @return
     */
    List<List<String>> getBetNumbersByType(Long playId);
}
