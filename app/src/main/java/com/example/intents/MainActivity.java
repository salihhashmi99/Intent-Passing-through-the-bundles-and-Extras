package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtName, edtAge;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName=findViewById(R.id.edttxtname);
        edtAge=findViewById(R.id.edttxtage);

        //add on click listener on the btn send
        send=findViewById(R.id.btnsend);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edtName.getText().toString().trim();
                int age = Integer.parseInt(String.valueOf(edtAge.getText()));

                if (TextUtils.isEmpty(name)){//same crash
                    edtName.setError("Please enter your name");
                    edtName.requestFocus();
                }
                else if (TextUtils.isEmpty(String.valueOf(edtAge))){
                    edtAge.setError("Please mention your age");
                    edtAge.requestFocus();
                }
                else
                {
                    Bundle extras = new Bundle();
                    extras.putString("Name", name);
                    extras.putInt("Age",age);

                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtras(extras);
                    startActivity(intent);
                }
            }
        });
    }
}