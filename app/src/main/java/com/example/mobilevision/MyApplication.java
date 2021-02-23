package com.example.mobilevision;

import android.app.Application;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyApplication extends Application {
     private static final String TAG = MyApplication.class.getSimpleName();
     private static MyApplication minstance;
     private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        minstance = this;
    }

    public static synchronized MyApplication getInstance()
    {
          return minstance;
    }
    ///create Volly
    private RequestQueue getrequestQueue() {
        if (requestQueue == null)
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req)
    {
        getrequestQueue().add(req);
    }

}




