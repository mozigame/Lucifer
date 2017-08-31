package com.bc.lottery.service;

import com.bc.lottery.util.LotteryType;

import java.util.List;

/**
 * User: clion
 * Date: 2017/8/30
 * Time: 13:51
 **/
public interface LotteryHandle {
    long getBetCount(List<List<String>> betNumbers, LotteryType lotteryType);
}
