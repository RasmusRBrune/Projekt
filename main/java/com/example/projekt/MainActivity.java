package com.example.projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.projekt.Interface.datalistner;
import com.example.projekt.service.apiservice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private TextView txt;
    private apiservice service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBinding();
    }

    private void DataBinding(){
        txt = findViewById(R.id.datainfo);

        btn = findViewById(R.id.getdata);

        btn.setOnClickListener(v -> {
            service = new apiservice(this);
            service.test(new datalistner() {
                @Override
                public void onDataReady(JSONArray jsonArray) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        try {
                            JSONObject obj = jsonArray.getJSONObject(i);
                            String item = obj.getString("monsterName");
                            txt.append(item.toString());
                            txt.append("\n");
                        }catch (JSONException e){
                            Log.e("json error",e.getMessage());
                        }

                    }
                }

                @Override
                public void onDataError(String err) {

                }

                @Override
                public void onDataReady(JSONObject jsonObject) {

                }
            });
        });
    }
}