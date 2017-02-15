package com.superapp.ruothinhbatchu.model;

/**
 * Created by ManhNV on 2/24/2016.
 */
public class Result {
    private String content;
    private Boolean result;

    public Result(String content, Boolean result) {
        this.content = content;
        this.result = result;
    }

    public Boolean isRight() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
