package com.dfbz.sys.enums;

/**
 * @author admin
 * @version 1.0.1
 * @company 东方标准
 * @date 2019/12/4 17:27
 * @description
 */
public enum SessionEnum {

    SESSION_EMAIL_CODE_NAME("sessionEmailCodeName"),
    SESSION_PIC_CODE_NAME("sessionPicCodeName"),
    SESSION_LOGIN_NAME("sessionLoginName");

    private String value;

    SessionEnum() {
    }

    SessionEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
