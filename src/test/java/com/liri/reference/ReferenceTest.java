package com.liri.reference;

import com.liri.reference.common.beans.ResultBean;
import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.utils.Base64Util;
import com.liri.reference.common.utils.JSONUtil;
import com.liri.reference.dao.WalletTypeDao;
import com.liri.reference.model.DictItemDto;
import com.liri.reference.model.WalletTypeDto;
import com.liri.reference.service.CacheService;
import com.liri.reference.service.WalletTypeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ReferenceTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    WalletTypeService service;

    @Autowired
    WalletTypeDao dao;

    @Autowired
    CacheService cacheService;

    private static String token = "";

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();//建议使用这种
    }

    @Test
    public void testAction() throws Exception {
        MvcResult result = mockMvc.perform(
                get("/wallet/list")
                        .param("walletTypeCode", "00011")
                        .accept(MediaType.APPLICATION_JSON_UTF8_VALUE)

        ).andDo(MockMvcResultHandlers.print()).andReturn();
        int status = result.getResponse().getStatus();                 //得到返回代码
        String content = result.getResponse().getContentAsString();    //得到返回结果

        Assert.assertEquals(200, status);                   //断言，判断返回代码是否正确
        System.out.println(content);
    }

    @Test
    public void testDao() {
        WalletTypeDto dto = new WalletTypeDto();

        List list = dao.select(dto);
        System.out.println(list.size());

        dto.setWalletTypeCode("00013");
        dto.setWalletTypeFullName("William Test");
        dto.setRemarks("00013 test");
        dao.insert(dto);

        dto = dao.selectByCode("00013");

        dto.setRemarks("william test33333333");
        dto.setWalletTypeSimpleName("william");
        dao.update(dto);

        dao.delete(dto.getWalletTypeID());
    }

    @Test
    public void testService() {
        WalletTypeDto dto = new WalletTypeDto();
        List list = service.select(dto);
        System.out.println(list.size());
    }

    @Test
    public void testCacheService() {
        cacheService.reload();
        DictItemDto dictItemDto = cacheService.getDicItemByItemCode("DICT_CLASS_REF", "DICT_CLASS_REF_BCC", "00196");
        System.out.println(cacheService.getWalletTypeList());
    }

    @Test
    public void testLoginController() throws Exception {

        testCacheService();

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", Base64Util.encrypt("NEj!TCfjQ7Fku76Ac1#$348e"));
        params.add("accountNo", "123456789");
        params.add("walletTypeCode", "00196");

        MvcResult result = mockMvc.perform(post("/auth/token")
                .params(params)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        int status = result.getResponse().getStatus();                 //得到返回代码
        String content = result.getResponse().getContentAsString();    //得到返回结果

        Assert.assertEquals(200, status);                   //断言，判断返回代码是否正确
        ResultBean resultBean = JSONUtil.convertJSONToObject(content, ResultBean.class);
        Map<String, String> data = (Map) resultBean.getDataObject();
        setToken(data.get(Constants.ACCESS_TOKEN));
        System.out.println(content);
    }

    /**
     * 推荐银行成功，结果格式示例如下
     * <p>
     * {"status":200,"dataObject":{"1":{"id":1,"bankName":"GC","currency":null,"amount":null,"bankCountry":null,"method":null},"2":[{"id":2,"bankName":"Reference","currency":null,"amount":null,"bankCountry":null,"method":null},{"id":3,"bankName":"Reference2","currency":null,"amount":null,"bankCountry":null,"method":null}],"3":{"id":4,"bankName":"Help2Pay","currency":null,"amount":null,"bankCountry":null,"method":null}},"message":"成功"}
     */
    @Test
    public void testRecommendBankController() throws Exception {

        testLoginController();

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("ver", "1.0");
        params.add("countryCode", "CN");
        params.add("currency", "USD");
        params.add("amount", "100");

        // 推荐方式(1-GC, 2-Reference, 3-Help2Pay),多种推荐方式使用横杠"-"连接,如果GC与Reference推荐方式<code>1-2</code>
        params.add("method", "1-2-3");

        // Reference推荐独有参数，其他情况注释掉
        params.add("sender", "Myself");
        params.add("senderType", "Personal");

        MvcResult result = mockMvc.perform(post("/recommendBank")
                .header("token", getToken())
                .params(params)
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        int status = result.getResponse().getStatus();                 //得到返回代码
        result.getResponse().setCharacterEncoding("UTF-8");
        String content = result.getResponse().getContentAsString();    //得到返回结果
        result.getResponse().getOutputStream();
        Assert.assertEquals(200, status);                   //断言，判断返回代码是否正确

        System.out.println(content);
    }

    @Test
    public void testBaseDataController() throws Exception {

        testLoginController();

        MvcResult result = mockMvc.perform(post("/base/exchangeRate")
                .header("token", getToken())
                .accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andDo(MockMvcResultHandlers.print()).andReturn();
        int status = result.getResponse().getStatus();                 //得到返回代码
        result.getResponse().setCharacterEncoding("UTF-8");
        String content = result.getResponse().getContentAsString();    //得到返回结果
        result.getResponse().getOutputStream();
        Assert.assertEquals(200, status);                   //断言，判断返回代码是否正确

        System.out.println(content);
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        ReferenceTest.token = token;
    }
}
