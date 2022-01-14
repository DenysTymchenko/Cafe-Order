package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void Login(View view) {
        String name = editTextName.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(!name.isEmpty() && !password.isEmpty()) {
            Intent login_info = new Intent(this, OrderCreation.class);
            login_info.putExtra("name", name);
            login_info.putExtra("password", password);
            startActivity(login_info);
        }
        else{
            Toast.makeText(this, R.string.toast_text,Toast.LENGTH_SHORT).show();
        }
    }
}