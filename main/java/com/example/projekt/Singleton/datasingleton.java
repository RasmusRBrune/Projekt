package com.example.projekt.Singleton;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class datasingleton {

    private  static datasingleton instance;
    private RequestQueue queue;
    private Context ctx;

    private  datasingleton(Context _ctx){
        this.ctx = _ctx;
    }

    public static synchronized datasingleton getInstance(Context context) {
        if (instance == null) {
            instance = new datasingleton(context);
        }
        return instance;
    }

    public RequestQueue getQueue() {
        if (queue == null) {
            queue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return queue;
    }

}
