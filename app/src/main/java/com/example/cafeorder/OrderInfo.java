package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderInfo extends AppCompatActivity {
    private TextView textViewInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_info);

        Intent order = getIntent();
        String order_info = order.getStringExtra("order");
        textViewInfo = findViewById(R.id.textViewInfo);
        textViewInfo.setText(order_info);
    }
}