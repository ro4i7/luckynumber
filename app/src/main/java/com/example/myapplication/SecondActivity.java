package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.util.Random;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {
    TextView wlcmtxt,luckyNumber;
    Button share_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        wlcmtxt=findViewById(R.id.textView2);
        luckyNumber=findViewById(R.id.textView3);
        share_btn=findViewById(R.id.share_btn);

        Intent i=getIntent();
        String userName=i.getStringExtra("name");

        int rndm_num=genrtRndm();
        luckyNumber.setText(""+rndm_num);

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName,rndm_num);

            }
        });

    }
    public int genrtRndm(){
        Random random = new Random();
        int upper_limit = 1000;
        int rndmgnrtd = random.nextInt(upper_limit);
        return rndmgnrtd;
    }

    public void shareData(String username, int randNum){
        Intent i= new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username+" got lucky ");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is: "+randNum);
        startActivity(Intent.createChooser(i, "Choose a Platform"));
    }
}