package com.liri.reference.service;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.model.H2PApplyDto;
import com.liri.reference.model.GetBankParam;

/**
 * @author William
 * @date 2019/10/14
 */
public interface Help2PayService {

    /**
     * 推荐银行
     *
     * @param condition
     * @return
     */
    ResultBean recommendBank(GetBankParam condition);

    /**
     * 新增数据到DB
     *
     * @param h2PApplyDto
     * @return
     */
    ResultBean insert(H2PApplyDto h2PApplyDto);

}
