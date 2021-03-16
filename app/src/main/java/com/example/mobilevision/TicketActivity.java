package com.example.mobilevision;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

public class TicketActivity extends AppCompatActivity {
    TextView tvqrcode;
    private  static  final String URL= "http://192.168.1.24:8080/write_api/rest/api.php?ID=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        tvqrcode = findViewById(R.id.tv_json);
        Intent intent = getIntent();
        String qr_text = intent.getStringExtra("code");
        //tvqrcode.setText(qr_text);
        searchbarcode(qr_text);
        //changes teo dang mihn
    }

    public void searchbarcode(String qr_text) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL + qr_text, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        Log.d("json",response.toString());
                        try {
                            String name = response.getString("Name");
                            Toast.makeText(TicketActivity.this,name.toString(),Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        MyApplication.getInstance().addToRequestQueue(jsonObjectRequest);
    }

}