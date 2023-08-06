package com.example.personalityanalysisapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OptionShowActivity extends AppCompatActivity {
    Button result;
    Button quiz;
    Button result2;
    Button DeleteUser;
    String uid;
    FirebaseAuth zauth;
    ImageView imageView3;
    DatabaseReference mDatabase;
    private FirebaseAuth mauth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_show);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        mauth=FirebaseAuth.getInstance();

        result=findViewById(R.id.result);
        result2=findViewById(R.id.result2);
        quiz=findViewById(R.id.quiz);
       uid=mauth.getCurrentUser().getUid();
       DeleteUser=findViewById(R.id.DeleteUser);
       imageView3 = findViewById(R.id.imageView3);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent n=new Intent(OptionShowActivity.this,ResultActivity.class);
                n.putExtra("UN_IDS",uid);
                startActivity(n);
            }
        });
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(OptionShowActivity.this,MainActivity2.class);
                x.putExtra("UN_IDS",uid);
                startActivity(x);
            }
        });
        result2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mauth.signOut();
                Toast.makeText(OptionShowActivity.this, "Logging Out !", Toast.LENGTH_SHORT).show();
                Intent inten = new Intent(OptionShowActivity.this,new1.class);
                startActivity(inten);
            }
        });
        DeleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(OptionShowActivity.this, "Initiating the Delete Operation !", Toast.LENGTH_SHORT).show();
                zauth = FirebaseAuth.getInstance();
                FirebaseUser user = zauth.getCurrentUser();
                String uid = user.getUid();
                mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://personalityanalysisapp-default-rtdb.firebaseio.com");
                mDatabase.child(uid).removeValue();
                Toast.makeText(OptionShowActivity.this, "Deleting the Data !", Toast.LENGTH_SHORT).show();

                    user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(OptionShowActivity.this, "Account Deleted Successfully !", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(OptionShowActivity.this, "Deletion Failed !", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

        });
    }
}