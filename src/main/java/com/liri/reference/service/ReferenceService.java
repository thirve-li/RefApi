package com.liri.reference.service;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.model.GetBankParam;
import com.liri.reference.model.ReferenceInfoDto;

/**
 * @author William
 * @date 2019/10/14
 */
public interface ReferenceService {
    
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
     * @param referenceInfoDto
     * @return
     */
    ResultBean insert(ReferenceInfoDto referenceInfoDto);

}
