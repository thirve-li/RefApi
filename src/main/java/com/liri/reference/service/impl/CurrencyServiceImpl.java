package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.utils.ActionContextUtil;
import com.liri.reference.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author William
 * @date 2019/8/20
 */
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyService.class);

    /**
     * 获取币种
     *
     * @return
     */
    @Override
    public ResultBean getCurrency() {
        ResultBean resultBean = new ResultBean();
        // TODO
        String walletTypeCode = ActionContextUtil.getContext().getWalletTypeCode();

        return resultBean;
    }

}
