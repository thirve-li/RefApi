package com.liri.reference.controller;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.utils.StringUtil;
import com.liri.reference.model.GcConfirmParam;
import com.liri.reference.model.GetBankParam;
import com.liri.reference.model.RefConfirmParam;
import com.liri.reference.service.CacheService;
import com.liri.reference.service.RecommendBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 推荐银行
 *
 * @author William
 * @date 2019/10/14
 */
@Controller
public class RecommendBankController {
    
    private static Logger logger = LoggerFactory.getLogger(RecommendBankController.class);
    
    @Autowired
    private RecommendBankService recommendBankService;
    
    @Autowired
    CacheService cacheService;
    
    @Autowired
    private HttpServletRequest request;
    
    @RequestMapping("index")
    public String index(GetBankParam condition) {
        return "index";
    }
    
    /**
     * 推荐银行
     *
     * @param condition 推荐条件
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("api/getBank")
    public ResultBean getBank(GetBankParam condition) {
        ResultBean resultBean = recommendBankService.getBank(condition);
        return resultBean;
    }
    
    /**
     * 获取RefNo,保存Ref入金信息
     *
     * @param refDto 获取RefNo,保存国际入金信息
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("api/refConfirm")
    public ResultBean refConfirm(RefConfirmParam refDto) {
        ResultBean resultBean = new ResultBean();
        String refNo = "";
        
        String url = request.getHeader("referer");
        
        if(StringUtils.isEmpty(url)){
            url = request.getRemoteAddr();
        }
        
        logger.info(">>>>>>>>>>>>>> Access SN URL is :"+url);
        refNo = recommendBankService.getRefNo(refDto.getWalletTypeCode(), "101", url);
        
        resultBean = recommendBankService.insertRef(refDto, refNo);
        return resultBean;
    }
    
    /**
     * 保存GC入金信息
     *
     * @param gcBankInfo 获取RefNo,保存本地入金信息
     * @return ResultBean
     */
    @ResponseBody
    @RequestMapping("api/gcConfirm")
    public ResultBean gcConfirm(GcConfirmParam gcBankInfo) {
        ResultBean resultBean = new ResultBean();
        String refNo = "";
        
        String url = request.getHeader("referer");
        refNo = recommendBankService.getRefNo(gcBankInfo.getWalletTypeCode(), "101", url);
        
        resultBean = recommendBankService.insertGC(gcBankInfo, refNo);
        return resultBean;
    }
    
    
}
