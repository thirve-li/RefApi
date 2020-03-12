package com.liri.reference.service.impl;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.common.utils.ActionContextUtil;
import com.liri.reference.common.utils.DateUtil;
import com.liri.reference.common.utils.UUIDUtil;
import com.liri.reference.common.utils.ValidateUtil;
import com.liri.reference.model.WalletTypeDto;
import com.liri.reference.service.CacheService;
import com.liri.reference.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 登录服务
 *
 * @author William
 * @date 2019/8/22
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private CacheService cacheService;

    /**
     * 授权
     *
     * @param code           SysCode
     * @param accountNo       客户accountNo
     * @param walletTypeCode wallet类型代码
     * @return ResultBean
     * CITIBank_HK_CSP_HK
     * http://localhost:8080/index?token=9f5563e3285d3f89a27938ae0e7334f0
     * http://localhost:8080/auth/token?code=bGlyaTAwMDA=&walletTypeCode=00012&accountNo=223
     */
    @Override
    public ResultBean authorize(String code, String accountNo, String walletTypeCode) {

        // 验证参数
        ResultBean resultBean = ValidateUtil.validateAuthorizationParams(code, accountNo, walletTypeCode);
        if (StatusEnum.SUCCESS.getCode() != resultBean.getStatus()) {
            logger.warn(">>>>>> 授权参数错误 "  + "code=" + code + "accountNo=" + accountNo
                    + "walletTypeCode=" + walletTypeCode);
            return resultBean;
        }

        // 检查Wallet是否在ARMS系统已设置
        WalletTypeDto walletType = cacheService.getWalletTypeByCode(walletTypeCode);
        if (walletType == null) {
            resultBean.setStatus(StatusEnum.PARAM_ERROR);
            resultBean.setMessage("walletTypeCode" + StatusEnum.PARAM_ERROR.getMsg());
            logger.warn(">>>>>> 授权参数错误 grantType="  + "code=" + code + "accountNo=" + accountNo
                    + "walletTypeCode=" + walletTypeCode);
            return resultBean;
        }

        int expireInterval;
        try {
            // 查询出来的授权过期间隔，单位秒(s)，默认30分钟=30*60
            String expire = cacheService.getDicItemByItemCode(Constants.DICT_CLASS_REF,
                    Constants.AUTHORIZATION_EXPIRATION_INTERVAL, null).getDictItemValue();
            expireInterval = Integer.parseInt(expire);
        } catch (Exception e) {
            expireInterval = Constants.DEFAULT_AUTHORIZATION_EXPIRATION_INTERVAL;
            logger.error(">>>>>> NumberFormatException:", e);
        }

        Map<String, String> data = new LinkedHashMap<>();
        
        // 生成访问令牌
        String token = UUIDUtil.getUUID(walletTypeCode + accountNo + Calendar.getInstance().getTimeInMillis());
        data.put(Constants.ACCESS_TOKEN, token);

        // 过期时间
        Date expirationDate = DateUtil.calculateDateBySecond(null, expireInterval);
        data.put("expirationDate", DateUtil.dateToString(expirationDate, DateUtil.FORMAT_DATE_DEFAULT));

        resultBean.setDataObject(data);

        // 存入缓存,为之后操作提供数据
        ActionContextUtil.getContext(token).setWalletTypeCode(walletTypeCode);
        ActionContextUtil.getContext(token).setAccountNo(accountNo);
        
        return resultBean;
    }
}
