package com.liri.reference.common.beans;

import com.liri.reference.common.enums.StatusEnum;

import java.io.Serializable;

/**
 * @author William
 * @date 2019/10/14
 */
public class ResultBean implements Serializable {

    private static final long serialVersionUID = 3148305130363466541L;

    private int status = StatusEnum.SUCCESS.getCode();

    private Object dataObject = "";

    private String message = StatusEnum.SUCCESS.getMsg();

    public void setStatus(StatusEnum codeEnum) {
        this.status = codeEnum.getCode();
        this.message = codeEnum.getMsg();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getDataObject() {
        return dataObject;
    }

    public void setDataObject(Object dataObject) {
        this.dataObject = dataObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultBean{" +
                "status=" + status +
                ", dataObject=" + dataObject +
                ", message='" + message + '\'' +
                '}';
    }
}
