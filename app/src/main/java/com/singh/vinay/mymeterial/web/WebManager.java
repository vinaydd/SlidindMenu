package com.singh.vinay.mymeterial.web;

/**
 * Created by ios4_dev on 8/29/15.
 */
public class WebManager {
    private static final String IS_FREE_APP = "isFree";
    private static WebManager singleInstance;

    protected WebManager() {
    }

    public static WebManager getInstance() {
        if (singleInstance == null) {
            singleInstance = new WebManager();
        }
        return singleInstance;
    }


}
