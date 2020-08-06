package com.sswh.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.sswh.Enum.AbhsUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/8/6 19:48
 */
public class AbhsUtil {

    public static void main(String[] args) {
        List<DateTime> dateTimes = acquireAbhsTimeList();
    }


    /**
     * 生成abhs复习时间点列表
     * @return
     */
    public static List<DateTime> acquireAbhsTimeList() {
        int[] days = {1, 2, 5, 7, 8, 9};
        List<DateTime> dates = new ArrayList<>();
        long current = DateUtil.current(false);
        long after20 = 0L;
        //20分钟后
        after20 = current + AbhsUnit.MINUTE.getMillis() * 20;
        DateTime dateTime = new DateTime(after20);
        dates.add(dateTime);

        for (int i = 0; i < days.length; i++) {
            long temp = current;
            temp = temp + AbhsUnit.DAY.getMillis() * days[i];
            DateTime dateTimeTemp = new DateTime(temp);
            dates.add(dateTimeTemp);
        }
        return dates;
    }


}
