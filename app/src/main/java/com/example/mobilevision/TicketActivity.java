package com.example.mobilevision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class TicketActivity extends AppCompatActivity {
    TextView tv_name,tv_price,tv_country,tv_phone,tv_price2,tv_code,tv_load_country2,tv_description;
    ImageView tv_picture;
    ArrayList<Object> objectArrayList;
    private  static  final String URL= "http://192.168.1.13/write_api/rest/api.php?ID=";
    private  static  final String MY_KEY= "JSON";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        tv_name = findViewById(R.id.tv_load_name);
        tv_price = findViewById(R.id.tv_load_price);
        tv_country = findViewById(R.id.tv_load_country);
        tv_phone = findViewById(R.id.tv_load_phone);
        tv_price2 = findViewById(R.id.tv_load_price2);
        tv_code = findViewById(R.id.tv_load_code);
        tv_load_country2 = findViewById(R.id.tv_load_country2);
        tv_description = findViewById(R.id.tv_load_description);
        tv_picture = findViewById(R.id.tv_picture);

        Intent intent = getIntent();
        String qr_text = intent.getStringExtra("code");
        //tvqrcode.setText(qr_text);
        searchbarcode(qr_text);
        //changes teo dang mihn
        //getPreferenceObjectJson();

        //        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    }
    //    private void initialRecycleview() {
//    }
    public void searchbarcode(String qr_text) {
        String path_image = "http://192.168.1.13/";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL + qr_text, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                           //Log.d("json",response.toString());
                        try {
                            String name = response.getString("Name");
                            tv_name.setText(name);
                            String price = response.getString("Price");
                            tv_price.setText(price);
                            String country = response.getString("Country");
                            tv_country.setText(country);
                            String phone = response.getString("Phone");
                            tv_phone.setText(phone);
                            tv_price2.setText(price);
                            String code = response.getString("Code");
                            tv_code.setText(code);
                            tv_load_country2.setText(country);
                            String description = response.getString("Description");
                            tv_description.setText(description);
                            String picture = response.getString("Picture");
                            String newpicture = picture.replace("\\","");
                            String image = path_image+newpicture;
                            Glide.with(TicketActivity.this).load(image).into(tv_picture);

                            saveData(response.toString());
                            //Log.d("path", image.toString());
                            Log.d("json", response.toString());
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
    public void saveData(String response) {
        //SharedPreferences sharedPreferences = getSharedPreferences(MY_KEY,TicketActivity.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getSharedPreferences(MY_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dulieu", response);
        //editor.commit();
        editor.apply();

    }
    // le xong tiep tuc

//    public void setRecycleview(ArrayList<Object> objectArrayList) {
//        adapterRecycleview = new AdapterRecycleview(this,objectArrayList);
//        adapterRecycleview.notifyDataSetChanged();
//       recyclerView.setAdapter(adapterRecycleview);
//   }
}





