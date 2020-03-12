package com.liri.reference.common.enums;

/**
 * 响应状态
 *
 * <p>
 * 以1xx为前缀的状态码表示失败类型
 * 以2xx为前缀的状态码表示成功类型
 * 以3xx为前缀的状态码表示授权类型
 * </p>
 *
 * @author William
 * @date 2019/10/14
 */
public enum StatusEnum {

    FAIL(100, "失败"),
    SYSTEM_ERROR(101, "系统错误"),
    PARAM_ERROR(102, "参数错误"),
    EXCEED_MIN(103, "小于最小入金金额"),
    EXCEED_MAX(104, "超过最大入金金额"),
    NO_REF(105, "获取REF NO.失败"),
    SUCCESS(200, "成功"),
    UNAUTHORIZED(300, "未授权"),
    AUTHORIZATION_INVALID(301, "授权无效"),
    NO_BANK_RISK_COUNTRY(400,"风险国无推荐银行"),
    NO_BANK(401,"无推荐银行"),
    NO_RATE(402,"汇率不存在")
    ;

    /**
     * 响应状态码
     */
    private final int code;

    /**
     * 响应提示
     */
    private final String msg;

    StatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
