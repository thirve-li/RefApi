package com.liri.reference.controller;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.enums.StatusEnum;
import com.liri.reference.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 调用ARMS 推荐银行API之前的安全认证接口
 *
 * @author William
 * @date 2019/10/14
 * http://localhost:8080/index?token=9f5563e3285d3f89a27938ae0e7334f0
 * http://localhost:8080/auth/token?code=bGlyaTAwMDA=&walletTypeCode=00012&accountNo=223
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 授权认证接口
     * @param code Base64位加密系统校验码，固定值
     * @param accountNo Wallet系统账号
     * @param walletTypeCode Wallet系统代号
     * @return ResultBean 成功后返回Token值存放的对象
     */
    @ResponseBody
    @RequestMapping(value = "auth/token", method = {RequestMethod.GET,RequestMethod.POST})
    public ResultBean authorize( String code, String accountNo, String walletTypeCode) {
        ResultBean resultBean = loginService.authorize(code, accountNo, walletTypeCode);
        return resultBean;
    }

    /**
     * 未经授权
     *
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping(value = "auth/unauthorized")
    public ResultBean unauthorized() {
        ResultBean resultBean = new ResultBean();
        resultBean.setStatus(StatusEnum.UNAUTHORIZED);
        return resultBean;
    }

    /**
     * 授权(token)失效
     *
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping(value = "auth/invalid")
    public ResultBean invalid() {
        ResultBean resultBean = new ResultBean();
        resultBean.setStatus(StatusEnum.AUTHORIZATION_INVALID);
        return resultBean;
    }
}
