package com.example.mobilevision;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TicketActivity extends AppCompatActivity {
    TextView tvqrcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        tvqrcode = findViewById(R.id.loadqrcode);
        Intent intent = getIntent();
        String qr_text = intent.getStringExtra("code");
        tvqrcode.setText(qr_text);
    }
}