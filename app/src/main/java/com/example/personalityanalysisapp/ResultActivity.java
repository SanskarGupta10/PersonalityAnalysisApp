package com.example.personalityanalysisapp;




import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivity extends AppCompatActivity {
DatabaseReference mdatabase;
FirebaseAuth mauth;

 String YOU,value1,value2,value3,value4,value5, value6,value7,value8,value9,value10,value11,value12,value13,value14,value15,value16,value17,value18,value19,value20;
 int v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20;
 public int score1;
 public int score2;

    TextView resultShow,textView3,textView2,textView,textview4,textview5;
    ImageView imageView4,imageView5,imageView6;
    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        mauth=FirebaseAuth.getInstance();


        YOU= mauth.getCurrentUser().getUid();
        Toast.makeText(ResultActivity.this,"Showing The Result !", Toast.LENGTH_SHORT).show();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        resultShow=findViewById(R.id.resultShow);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView=findViewById(R.id.textView);
        textview4=findViewById(R.id.textView4);
        textview5=findViewById(R.id.textView5);
        imageView5=findViewById(R.id.imageView5);

        mdatabase=FirebaseDatabase.getInstance().getReferenceFromUrl("https://personalityanalysisapp-default-rtdb.firebaseio.com/");
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    value1=  snapshot.child(YOU).child("ans1").getValue().toString();
                    value1 = value1.trim();
                    v1 = Integer.parseInt(value1,10);
                    value2=snapshot.child(YOU).child("ans2").getValue().toString();
                    value2 = value2.trim();
                    v2 = Integer.parseInt(value2,10);
                    value3= snapshot.child(YOU).child("ans3").getValue().toString();
                    value3 = value3.trim();
                    v3 = Integer.parseInt(value3,10);
                    value4= snapshot.child(YOU).child("ans4").getValue().toString();
                value4 = value4.trim();
                v4 = Integer.parseInt(value4,10);
                    value5= snapshot.child(YOU).child("ans5").getValue().toString();
                value5 = value5.trim();
                v5 = Integer.parseInt(value5,10);
                    value6= snapshot.child(YOU).child("ans6").getValue().toString();
                value6 = value6.trim();
                v6 = Integer.parseInt(value6,10);
                    value7=snapshot.child(YOU).child("ans7").getValue().toString();
                value7 = value7.trim();
                v7 = Integer.parseInt(value7,10);
                    value8= snapshot.child(YOU).child("ans8").getValue().toString();
                value8 = value8.trim();
                v8 = Integer.parseInt(value8,10);
                    value9= snapshot.child(YOU).child("ans9").getValue().toString();
                value9 = value9.trim();
                v9 = Integer.parseInt(value9,10);
                    value10= snapshot.child(YOU).child("ans10").getValue().toString();
                value10 = value10.trim();
                v10 = Integer.parseInt(value10,10);

                value11=  snapshot.child(YOU).child("ans11").getValue().toString();
                value11 = value11.trim();
                v11 = Integer.parseInt(value11,10);

                value12=  snapshot.child(YOU).child("ans12").getValue().toString();
                value12 = value12.trim();
                v12 = Integer.parseInt(value12,10);

                value13=  snapshot.child(YOU).child("ans13").getValue().toString();
                value13 = value13.trim();
                v13 = Integer.parseInt(value13,10);

                value14=  snapshot.child(YOU).child("ans14").getValue().toString();
                value14 = value14.trim();
                v14 = Integer.parseInt(value14,10);

                value15=  snapshot.child(YOU).child("ans15").getValue().toString();
                value15 = value15.trim();
                v15 = Integer.parseInt(value15,10);

                value16=  snapshot.child(YOU).child("ans16").getValue().toString();
                value16 = value16.trim();
                v16 = Integer.parseInt(value16,10);

                value17=  snapshot.child(YOU).child("ans17").getValue().toString();
                value17 = value17.trim();
                v17 = Integer.parseInt(value17,10);

                value18=  snapshot.child(YOU).child("ans18").getValue().toString();
                value18 = value18.trim();
                v18 = Integer.parseInt(value18,10);

                value19=  snapshot.child(YOU).child("ans19").getValue().toString();
                value19 = value19.trim();
                v19 = Integer.parseInt(value19,10);

                value20=  snapshot.child(YOU).child("ans20").getValue().toString();
                value20 = value20.trim();
                v20 = Integer.parseInt(value20,10);

                int sc1 = v1+v2+v3+v4+v5;
                int sc2 = 30 - (v6+v7+v8+v9+v10);
                score1 = sc1+sc2;
                if(score1<=25){
                    resultShow.setText(" ~Your OCEAN model quiz results suggest that you are INTROVERT, as indicated by your total extraversion score of "+score1);
                }
                else{
                    resultShow.setText(" ~Your OCEAN model quiz results suggest that you are EXTROVERT, as indicated by your total extraversion score of "+score1);
                }
                int sc3=v11+v12+v13+v14+v15+v16;
                int sc4=24-(v17+v18+v19+v20);
                score2=sc3+sc4;
                if(score2<=25){
                    textview5.setText(" ~Your OCEAN model quiz results suggest that you are CONSCIENTIOUSLESS,as indicated by your total conscientiousness score of "+score2);
                }
                else{
                    textview5.setText(" ~Your OCEAN model quiz results suggest that you are CONSCIENTIOUS,as indicated by your total conscientiousness score of "+score2);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

}