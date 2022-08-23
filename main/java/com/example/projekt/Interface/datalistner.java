package com.example.projekt.Interface;

import org.json.JSONArray;
import org.json.JSONObject;

public interface datalistner {

    public void onDataReady(JSONArray jsonArray);

    public void onDataError(String err);

    public void onDataReady(JSONObject jsonObject);

}
