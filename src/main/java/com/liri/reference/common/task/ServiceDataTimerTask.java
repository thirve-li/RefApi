package com.liri.reference.common.task;

import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.utils.ActionContextUtil;
import com.liri.reference.common.utils.ApplicationContextUtil;
import com.liri.reference.common.utils.CollectionUtil;
import com.liri.reference.model.DictItemDto;
import com.liri.reference.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * 定时器任务
 *
 * @author William
 * @date 2019/8/19
 */
public class ServiceDataTimerTask extends TimerTask {

    private static final Logger logger = LoggerFactory.getLogger(ServiceDataTimerTask.class);

    // 授权过期间隔，单位秒(s)
    private static long EXPIRATION_INTERVAL = Constants.DEFAULT_AUTHORIZATION_EXPIRATION_INTERVAL;

    @Override
    public void run() {

        checkedAccountTimeout();

        cacheService();
    }

    /**
     * 检查帐户会话，超时账号的属性及配置信息删除
     */
    private void checkedAccountTimeout() {

        if (CollectionUtil.isNotEmpty(ActionContextUtil.getActionContextMap())) {

            ActionContextUtil.getActionContextMap().entrySet().removeIf(context -> context.getValue().expire(EXPIRATION_INTERVAL * 1000L));
        }
    }

    /**
     * 缓存服务：数据使用频繁并且很少修改
     */
    private void cacheService() {
        try {
            CacheService cacheService = ApplicationContextUtil.getBean(CacheService.class);
            cacheService.reload();

            // 授权过期间隔
            DictItemDto authorizationExpirationInterval = cacheService.getDicItemByItemCode(Constants.DICT_CLASS_REF,
                    Constants.AUTHORIZATION_EXPIRATION_INTERVAL, null);

            if (authorizationExpirationInterval != null) {
                EXPIRATION_INTERVAL = Long.parseLong(authorizationExpirationInterval.getDictItemValue());
            } else {
                logger.warn(">>>>>> REF_SESSION_TIMEOUT is empty!");
            }

        } catch (Exception e) {
            EXPIRATION_INTERVAL = Constants.DEFAULT_AUTHORIZATION_EXPIRATION_INTERVAL;
            logger.error(">>>>>> cacheService error:", e);
            e.printStackTrace();
        }
    }
}
