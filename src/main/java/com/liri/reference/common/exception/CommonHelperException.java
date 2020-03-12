package com.liri.reference.common.exception;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.enums.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统异常处理
 *
 * @author William
 * @date 2019/8/22
 */
@ControllerAdvice
public class CommonHelperException {

    private static Logger logger = LoggerFactory.getLogger(CommonHelperException.class);

    @ResponseBody
    @ExceptionHandler(value = {Exception.class})
    public ResultBean handlerException(Exception e) {
        ResultBean resultBean = new ResultBean();

        logger.error(">>>>>>> handlerExceptionResolver error:", e);
        resultBean.setStatus(StatusEnum.SYSTEM_ERROR);
        return resultBean;
    }
}
