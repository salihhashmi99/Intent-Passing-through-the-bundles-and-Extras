package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView txtviewname, txtviewage;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtviewname=findViewById(R.id.txtName);
        txtviewage=findViewById(R.id.txtage);

        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        String name = extras.getString("Name");
        Integer age = extras.getInt("Age");
        txtviewage.setText(age.toString());
        txtviewname.setText(name);

        Toast.makeText(getApplicationContext(), "Name: "+name+" Age: "+age.toString(), Toast.LENGTH_SHORT).show();
        Log.i("Salih", "Name: "+name+" Age: "+age.toString());
    }
}