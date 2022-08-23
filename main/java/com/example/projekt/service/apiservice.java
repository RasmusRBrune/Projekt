package com.example.projekt.service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.projekt.Interface.datalistner;
import com.example.projekt.Singleton.datasingleton;

import org.json.JSONArray;
import org.json.JSONObject;

public class apiservice {

    private Context ctx;
    String url = "http://10.0.2.2:8080/demo_war_exploded/api/";
    //"https://api.fungenerators.com/name/categories.json?start=0&limit=1"

    public apiservice(Context _ctx) {
        this.ctx = _ctx;
    }

    public void test(datalistner listner) {
        JsonArrayRequest req = new JsonArrayRequest(
                Request.Method.GET,
                url + "monster/getall",
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        listner.onDataReady(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        listner.onDataError(error.getMessage().toString());
                    }
                }


        );
        datasingleton .getInstance(ctx).getQueue().add(req);
        // FruitSingleton.getInstance(ctx).getQueue().add(req);
    }
}
