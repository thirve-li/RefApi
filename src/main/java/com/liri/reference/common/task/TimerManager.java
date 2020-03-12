package com.liri.reference.common.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;

/**
 * 定时器管理
 *
 * @author William
 * @date 2019/8/19
 */
public class TimerManager {

    private static Logger logger = LoggerFactory.getLogger(TimerManager.class);

    public TimerManager() {

        logger.info(">>>>>> The begin of the method TimerManager");
        // 定时任务周期：1分钟 = 1000*60
        long periodTime = 5*1000*60L;

        Timer timer = new Timer("com.liri.reference.common.task.TimerManager");

        ServiceDataTimerTask task = new ServiceDataTimerTask();

        // 执行任务，延迟500毫秒
        timer.schedule(task, 500L, periodTime);

        logger.info(">>>>>> The end of the method TimerManager");
    }
}
