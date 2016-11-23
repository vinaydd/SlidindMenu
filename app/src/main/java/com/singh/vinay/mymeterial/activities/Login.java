package com.singh.vinay.mymeterial.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.singh.vinay.mymeterial.R;
import com.singh.vinay.mymeterial.model.Model;
import com.singh.vinay.mymeterial.respoce.LoginResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 7/11/16.
 */
public class Login extends CommonBaseActivity{
    private static final String REGISTER_URL ="https://192.168.72.166:8081/test" ;
    Class<LoginResponse> _responseType;
    Class<Model> h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginnew);
        Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, SlidingMenuActvity.class);
                startActivity(intent);
            }
        });
    }
    private void getWebCall() {


        JSONObject params = new JSONObject();
        try {
            params.put("name", "585");
            params.put("date", "2016-11-01");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                REGISTER_URL, params,
                new Response.Listener<JSONObject>() {

                    public static final String TAG = "success";

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        //  pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            public static final String TAG = "error";

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                //  pDialog.hide();
            }
        }) {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjReq);

    }
}
