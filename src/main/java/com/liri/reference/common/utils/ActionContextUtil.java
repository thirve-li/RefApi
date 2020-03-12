package com.liri.reference.common.utils;

import com.liri.reference.common.beans.ActionContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 上下文工具类
 *
 * @author William
 * @date 2019/8/19
 */
public class ActionContextUtil {

    private ActionContextUtil() {

    }

    /**
     * 线程本地变量
     */
    private static ThreadLocal<ActionContext> threadActionContext = new ThreadLocal<ActionContext>();

    private static Map<String, ActionContext> actionContext = new ConcurrentHashMap<String, ActionContext>();

    public static ActionContext getContext() {
        return threadActionContext.get();
    }

    public static void setContext(ActionContext context) {
        threadActionContext.set(context);
    }

    public static void setContext(String key) {
        actionContext.put(key, new ActionContext());
    }

    public static ActionContext getContext(String key) {
        ActionContext context = actionContext.get(key);
        if (context == null) {
            actionContext.put(key, new ActionContext());
        }
        return actionContext.get(key);
    }

    public static Map<String, ActionContext> getActionContextMap() {
        return actionContext;
    }

    /**
     * 是否存在
     *
     * @param key
     * @return key存在返回true, 否则返回false
     */
    public static boolean isExists(String key) {
        return actionContext.get(key) == null ? false : true;
    }
}
