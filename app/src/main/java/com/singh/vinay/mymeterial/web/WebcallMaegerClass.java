package com.singh.vinay.mymeterial.web;

import android.content.Context;

import com.singh.vinay.mymeterial.respoce.LoginResponse;
import com.singh.vinay.mymeterial.utils.Constants;

/**
 * Created by root on 10/11/16.
 */
public class WebcallMaegerClass {
    private static WebcallMaegerClass singleInstance;
    protected WebcallMaegerClass() {
    }
    public static WebcallMaegerClass getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebcallMaegerClass();
        }
        return singleInstance;
    }
    public  void  getLogin(Context context){
        CommonVollyClass<LoginResponse> httptask = new CommonVollyClass<>(context, Constants.HOST_URL, LoginResponse.class, Constants.LOGIN_URL);
        httptask.setIsApiKeyRequired(false);
    }
}
