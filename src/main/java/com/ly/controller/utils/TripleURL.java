package com.ly.controller.utils;

public enum TripleURL {
    SHOW_LIST_URL ("https://bapi.gaotu100.com/cms/footerLink/showlist","访问第三方showList接口"),
    Clazz_LIST_URL ("https://api.gaotu100.com/studyCenter/v1/user/clazz/list","访问第三方学习中心接口");

    private String url;
    private String description;
    TripleURL(String url, String description){
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
