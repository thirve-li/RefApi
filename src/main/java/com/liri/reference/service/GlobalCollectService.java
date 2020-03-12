package com.liri.reference.service;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.model.GcApplyInfoDto;
import com.liri.reference.model.GetBankParam;

/**
 * @author William
 * @date 2019/10/14
 */
public interface GlobalCollectService {

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
     * @param gcApplyInfoDto
     * @return
     */
    ResultBean insert(GcApplyInfoDto gcApplyInfoDto);

}
