package com.singh.vinay.mymeterial.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.singh.vinay.mymeterial.R;

/**
 * Created by root on 7/11/16.
 */
public class Home_fragmets extends CommonBaseFragment{
    public static Home_fragmets newInstance() {
        Home_fragmets fragment = new Home_fragmets();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main, container, false);
        return view;
    }
}
