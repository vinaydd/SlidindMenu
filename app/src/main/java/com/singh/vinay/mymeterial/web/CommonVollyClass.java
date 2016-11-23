package com.singh.vinay.mymeterial.web;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.singh.vinay.mymeterial.activities.CommonBaseActivity;
import com.singh.vinay.mymeterial.fragments.CommonBaseFragment;
import com.singh.vinay.mymeterial.utils.AppPreference;
import com.singh.vinay.mymeterial.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 10/11/16.
 */
public class CommonVollyClass<T> extends Activity {
    private static final String TAG = CommonVollyClass.class.getSimpleName();
    protected ProgressDialog _dialog;
    protected String message = "Loading...";
    Context _context;
    Class<T> _responseType;
    String _requestUrl;
    String methodName;
    private boolean isPost;
    private boolean isForFragment;
    private boolean isUserResponse;
    private boolean isApiRequired = true;
    private boolean isToShowProgress = true;
    private String apiKey;
    private CommonBaseFragment mFragment;
    public CommonVollyClass(Context context, String requestUrl, Class<T> responseType, String methodName) {
        _context = context;
        _requestUrl = requestUrl;
        _responseType = responseType;
        this.methodName = methodName;
        AppPreference prefs = new AppPreference(_context.getApplicationContext());
        apiKey = prefs.getStringValueForTag(Constants.API_KEY);
    }
    public void setIsApiKeyRequired(boolean isReqoured) {
        this.isApiRequired = isReqoured;
    }

    public boolean isFragment() {
        return isForFragment;
    }

    void setFragment(CommonBaseFragment fragment) {
        mFragment = fragment;
    }

    public void setForFragment(boolean isFragment) {
        this.isForFragment = isFragment;
    }

    public void setMessage(String loadingMessage) {
        message = loadingMessage;
    }
    T result = null;
    String response = "";
    String url = _requestUrl+ this.methodName;
    StringRequest postRequest = new StringRequest(Request.Method.POST, url,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String  response) {
                        result = new Gson().fromJson(response, _responseType);
                    if (isFragment()) {
                        mFragment.processFragmentResponse(result);
                    }
                    else {
                        ((CommonBaseActivity) _context).processResponse(result);
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            }
    ) {
        @Override
        protected Map<String, String> getParams()
        {
            JSONObject obj_file = new JSONObject();
            String product_id = "file_path";
            String corporate_id = "type";
            String servicesprovider_id = "extension";
            String comment = "extension";
            String services_date = "extension";
            try {
                obj_file.put("type", new String(product_id));
                obj_file.put("data", new String(corporate_id));
                obj_file.put("ext", new String(servicesprovider_id));
                obj_file.put("ext", new String(comment));
                obj_file.put("ext", new String(services_date));
                System.out.print(obj_file);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Map<String, String> params = new HashMap<>();
            // the POST parameters:
            params.put("vinay", obj_file.toString());
                   /*  ye jo vinay karke bheja hun pura json object hai dekhaa  thik debug kar lena  baki apna url set karna bas thik hai
                     aur jo niche hai n o ek ek parameter hai jaise apan id pass  bhejte hai okk samjha jaye aaur apna url use kar lena baki mai kam karta hun bhai bahut chap hai sala ajj thik hai jaisa bhi ho whats up pe batana

                    */
            params.put("product_id", product_id);
            params.put("corporate_id", corporate_id);
            params.put("servicesprovider_id", servicesprovider_id);
            params.put("comment", comment);
            params.put("services_date", services_date);
            return params;

        }
    };



}
