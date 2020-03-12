package com.liri.reference.service;

import com.liri.reference.common.beans.ResultBean;

/**
 * 登录服务
 *
 * @author William
 * @date 2019/8/22
 */
public interface LoginService {
    ResultBean authorize(String code, String accountNo, String walletTypeCode);
}
