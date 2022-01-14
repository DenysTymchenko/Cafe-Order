package com.example.cafeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class OrderCreation extends AppCompatActivity {
    private TextView textViewGreetings;
    private TextView textViewQuestion;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxSugar;
    private CheckBox checkBoxLemon;
    private Spinner spinnerTea;
    private Spinner spinnerCoffee;
    private String name;
    private String password;
    private String drink;
    private String drink_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_creation);

        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        Intent login_info = getIntent();
        name = login_info.getStringExtra("name");
        password = login_info.getStringExtra("password");

        textViewGreetings.setText(String.format(getString(R.string.greetings_text), name));

        drink = radioButtonTea.getText().toString();
        textViewQuestion.setText(String.format(getString(R.string.question_text), drink));
    }

    public void ChooseTea(View view) {
        drink = radioButtonTea.getText().toString();
        textViewQuestion.setText(String.format(getString(R.string.question_text), drink));

        checkBoxLemon.setVisibility((View.VISIBLE));

        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
    }

    public void ChooseCoffee(View view) {
        drink = radioButtonCoffee.getText().toString();
        textViewQuestion.setText(String.format(getString(R.string.question_text), drink));

        checkBoxLemon.setVisibility(View.INVISIBLE);
        checkBoxLemon.setChecked(false);

        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
    }

    public void CreateOrder(View view) {
        StringBuilder additions = new StringBuilder();
        if (checkBoxMilk.isChecked()) {
            additions.append(getString(R.string.milk)).append(" ");
        }
        if (checkBoxSugar.isChecked()) {
            additions.append(getString(R.string.sugar)).append(" ");
        }
        if (checkBoxLemon.isChecked()) {
            additions.append(getString(R.string.lemon)).append(" ");
        }

        String type;
        if (drink.equals(radioButtonTea.getText().toString())) {
            type = spinnerTea.getSelectedItem().toString();
        } else {
            type = spinnerCoffee.getSelectedItem().toString();
        }

        String order_info = String.format(getString(R.string.order_info_text), name, password, drink, type);
        String additions_info = getString(R.string.additions_info_default);
        if (additions.length() != 0) {
            additions_info = String.format(getString(R.string.additions_info_text), additions);
        }
        String full_order = order_info + " " + additions_info;

        Intent order = new Intent(this, OrderInfo.class);
        order.putExtra("order", full_order);
        startActivity(order);
    }
}