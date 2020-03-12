package com.liri.reference.controller;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.service.CurrencyService;
import com.liri.reference.service.RateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 基础数据
 *
 * @author William
 * @date 2019/8/20
 */
@RequestMapping("base")
@Controller
public class BaseDataController {

    private static Logger logger = LoggerFactory.getLogger(BaseDataController.class);

    @Autowired
    private RateService rateService;

    @Autowired
    private CurrencyService currencyService;

    /**
     * 汇率
     *
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("exchangeRate")
    public ResultBean exchangeRate() {
        ResultBean resultBean = rateService.getRate();
        return resultBean;
    }

    /**
     * 币种
     *
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("currency")
    public ResultBean currency() {
        ResultBean resultBean = currencyService.getCurrency();
        return resultBean;
    }

}
