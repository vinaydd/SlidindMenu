package com.singh.vinay.mymeterial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.singh.vinay.mymeterial.utils.AppPreference;


/**
 * Created by root on 10/17/15.
 */
public class CommonBaseActivity extends AppCompatActivity {
    public AppPreference prefs;
    public boolean isErrorResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new AppPreference(getApplicationContext());
        isErrorResponse = false;
    }

    public <T> void processResponse(T result) {
        isErrorResponse = false;
        if (result == null) {
            isErrorResponse = true;
           // Toast.makeText(this, "Server Error", Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public void logout() {

        prefs.clearPreferences();
        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }



}
