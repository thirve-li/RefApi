package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.utils.ActionContextUtil;
import com.liri.reference.service.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 汇率
 *
 * @author William
 * @date 2019/8/20
 */
@Service
public class RateServiceImpl implements RateService {

    private static final Logger logger = LoggerFactory.getLogger(RateService.class);

    /**
     * 获取汇率
     *
     * @return
     */
    @Override
    public ResultBean getRate() {
        ResultBean resultBean = new ResultBean();
        // TODO
        String walletTypeCode = ActionContextUtil.getContext().getWalletTypeCode();

        return resultBean;
    }
}
