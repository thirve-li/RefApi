package com.liri.reference.common.interceptor;

import com.liri.reference.common.beans.ActionContext;
import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.common.utils.ActionContextUtil;
import com.liri.reference.common.utils.JSONUtil;
import com.liri.reference.common.utils.StringUtil;
import com.liri.reference.controller.LoginController;
import com.liri.reference.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * 身份验证拦截器
 *
 * @author William
 * @date 2019/10/14
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Autowired
    private CacheService cacheService;

    private static final String UNAUTHORIZED_URI = "../auth/unauthorized";

    private static final String AUTHORIZATION_INVALID_URI = "../auth/invalid";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String msg = null;
        String ip =  request.getRemoteAddr();
        
     
        try {

            msg = ",ip=" + ip + ",RequestURL=" + request.getRequestURL() +
                    ",QueryString=" + request.getQueryString() + ",RemoteAddr=" + request.getRemoteAddr();
            logger.info(msg);
            
            String isDevModel = cacheService.getDicItemByItemCode(Constants.DICT_CLASS_REF,
                    Constants.DICT_CLASS_REF_DEV_MODEL, null).getDictItemValue();
 
            // 非开发模式需要校验访问来源
            if (!Constants.DEV_MODEL.equalsIgnoreCase(isDevModel)) {
                // 白名单
                String[] whiteList = cacheService.getDicItemByItemCode(Constants.DICT_CLASS_REF,
                        Constants.DICT_CLASS_REF_ALLOW_URL, null).getDictItemValue().split(",");

                boolean isInWhiteList = false;
                for (int i = 0; i < whiteList.length; i++) {
                    if (ip.trim().equalsIgnoreCase(whiteList[i].trim())) {
                        isInWhiteList = true;
                        break;
                    }
                }

                if (isInWhiteList == false) {
                    logger.warn(">>>>>> 访问来源地址不在白名单内 " + msg);
                    response.sendRedirect(UNAUTHORIZED_URI);
                    return false;
                }
            }

            Class<?> clazz = ((HandlerMethod) handler).getBean().getClass();
            if (LoginController.class == clazz) {
                return true;
            } else {

                String token = request.getHeader(Constants.ACCESS_TOKEN);
                if (StringUtil.isBlank(token)) {
                    token = request.getParameter(Constants.ACCESS_TOKEN);
                }
                if (StringUtil.isBlank(token)) {
                    logger.warn(">>>>>> The token is blank " + msg);
                    response.sendRedirect(UNAUTHORIZED_URI);
                    return false;
                }

                if (!ActionContextUtil.isExists(token)) {
                    logger.warn(">>>>>> The token is invalid " + msg);
                    response.sendRedirect(AUTHORIZATION_INVALID_URI);
                    return false;
                }

                ActionContext context = ActionContextUtil.getContext(token);
                ActionContextUtil.setContext(context);

                logger.info(">>>>>> AccountNo=" + context.getAccountNo() + msg);
                return true;
            }
        } catch (Exception e) {
            ResultBean resultBean = new ResultBean();
            resultBean.setStatus(StatusEnum.SYSTEM_ERROR);
            response.getOutputStream().write(JSONUtil.convertObjectToJSON(resultBean).getBytes(StandardCharsets.UTF_8));
            logger.error(">>>>>> error " + msg, e);
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }
}
