package com.example.personalityanalysisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class new1 extends AppCompatActivity {
    Button start;
    private FirebaseAuth mauth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 mauth=FirebaseAuth.getInstance();
                 FirebaseUser muser=mauth.getCurrentUser();
                 if(muser==null){
                     Intent n1=new Intent(new1.this,MainActivity.class);
                     startActivity(n1);
                 }
                 else{
                     Intent intent=new Intent(new1.this,OptionShowActivity.class);
                     startActivity(intent);
                 }






            }
        });
    }
}