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
    @Deprecated
    long getBetCount(List<List<String>> betNumbers, Long playId);

    /**
     * 获取彩票注单数量
     *
     * @param betNumbers
     * @param playId
     * @return
     */
    long getLotteryBetCount(Long lotteryId, Long playId, List<List<String>> betNumbers);

    /**
     * 生成随机注单
     *
     * @param playId
     * @return
     */
    @Deprecated
    List<List<String>> getBetNumbersByType(Long playId);

    /**
     * 根据彩种生成随机注单
     *
     * @param playId
     * @return
     */
    List<List<String>> getBetNumbersByType(Long lotteryId, Long playId);

    /**
     * 根据类型获取彩票可接收的List
     *
     * @param playId
     * @return
     */

    @Deprecated
    List<List<String>> getLotteryListByType(Long playId, String str);

    /**
     * 根据类型获取彩票可接收的List
     *
     * @param playId
     * @return
     */
    List<List<String>> getLotteryListByType(Long lotteryId, Long playId, String str);

    /**
     * 根据彩票可接收的List转换成字符串
     *
     * @param playId
     * @param lotteryList
     * @return
     */
    @Deprecated
    String getStringByLotteryList(Long playId, List<List<String>> lotteryList);

    /**
     * 根据彩票可接收的List转换成字符串
     *
     * @param playId
     * @param lotteryList
     * @return
     */
    String getStringByLotteryList(Long lotteryId, Long playId, List<List<String>> lotteryList);

    /**
     * 获取彩票单行注数（目前只支持时时彩定位胆）
     *
     * @param playId
     * @return
     */
    List<Integer> getLotteryCountByType(Long lotteryId, Long playId, String str);
}
