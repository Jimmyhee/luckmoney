package com.hzm.codecenter.dto;

/**
 * @program: luckmoney
 * @author: Jimmy.He
 * @create: 2019-11-25 15:17
 **/
public class AccessTokenDTO {

    private String client_id;
    private String client_secert;
    private String code;
    private String redirect_url;
    private String state;

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secert() {
        return client_secert;
    }

    public void setClient_secert(String client_secert) {
        this.client_secert = client_secert;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRedirect_url() {
        return redirect_url;
    }

    public void setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
