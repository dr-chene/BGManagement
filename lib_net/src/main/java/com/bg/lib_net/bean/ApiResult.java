package com.bg.lib_net.bean;

import com.google.gson.annotations.SerializedName;

/**
 * created by dr_chene on 2021/4/23
 * desc
 */
public class ApiResult<T> {
    public T data;
    @SerializedName("error_code")
    public int errorCode;
    @SerializedName("message")
    public String errorMsg;
}
