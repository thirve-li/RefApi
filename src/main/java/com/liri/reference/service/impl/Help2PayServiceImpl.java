package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.model.BankInfoDto;
import com.liri.reference.model.H2PApplyDto;
import com.liri.reference.model.Help2PayBankInfoDto;
import com.liri.reference.model.GetBankParam;
import com.liri.reference.service.Help2PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Help2Pay
 *
 * @author William
 * @date 2019/10/14
 */
@Service
public class Help2PayServiceImpl implements Help2PayService {

    private static Logger logger = LoggerFactory.getLogger(Help2PayService.class);

    /**
     * 推荐银行
     *
     * @param condition
     * @return ResultBean
     */
    @Override
    public ResultBean recommendBank(GetBankParam condition) {
        ResultBean resultBean = new ResultBean();
        // todo
        BankInfoDto bankInfo = new Help2PayBankInfoDto();
        bankInfo.setBankName("Help2Pay");
        bankInfo.setId(4);
        resultBean.setDataObject(bankInfo);
        return resultBean;
    }

    /**
     * 新增数据到DB
     *
     * @param h2PApplyDto
     * @return ResultBean
     */
    @Override
    public ResultBean insert(H2PApplyDto h2PApplyDto) {
        ResultBean resultBean = new ResultBean();
        // todo
        return resultBean;
    }

}
