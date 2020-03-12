package com.liri.reference.service;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.model.*;
import com.liri.reference.model.RefConfirmParam;

/**
 * 推荐银行
 *
 * @author William
 * @date 2019/8/19
 */
public interface RecommendBankService {
    
    public ResultBean getBank(GetBankParam condition);
    
    public ResultBean insertRef(RefConfirmParam refConfirmParam, String refNo);
    
    public ResultBean insertGC(GcConfirmParam refConfirmParam, String refNo);
    
    public String getRefNo(String walletTypeCode, String functionCode, String serverUrl);
    
}
