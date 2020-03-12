package com.liri.reference.common.listener;

import com.liri.reference.common.task.TimerManager;
import com.liri.reference.common.utils.ApplicationContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 任务侦听器
 *
 * @author William
 * @date 2019/8/19
 */
@WebListener
public class ServiceDataTaskListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(ServiceDataTaskListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
 
        try {
            ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
            ApplicationContextUtil.setApplicationContext(applicationContext);
            new TimerManager();
        } catch (Exception e) {
            logger.error(">>>>>> contextInitialized error:", e);
        }
 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
