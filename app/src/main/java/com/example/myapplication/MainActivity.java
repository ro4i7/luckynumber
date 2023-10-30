package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button btn;
    TextView txt;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt=findViewById(R.id.textView);
        btn=findViewById(R.id.btn);
        editText=findViewById(R.id.text2);
        img=findViewById(R.id.imageview);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=editText.getText().toString();
                Intent i=new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );
                i.putExtra("name", userName);
                startActivity(i);
            }
        });
    }
}