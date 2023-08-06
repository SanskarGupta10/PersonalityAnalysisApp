package com.example.personalityanalysisapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
Button button,bt2;
EditText tv;
    EditText ed1;
FirebaseAuth mauth;
String verifyId;
ImageView uuser;
public static final String Phone_Number="number";
public String phno;




    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        uuser = findViewById(R.id.uuser);
        tv=findViewById(R.id.tv1);
        button=findViewById(R.id.b1);
        ed1=findViewById(R.id.ed1);
        bt2=findViewById(R.id.bt2);
         mauth=FirebaseAuth.getInstance();
         button.setOnClickListener(new View.OnClickListener() { //sign up button
             @Override
             public void onClick(View v) {
                 if(ed1.getText().toString().isEmpty()){
                     Toast.makeText(MainActivity.this, "Enter the otp first!", Toast.LENGTH_SHORT).show();
                 }
                 else{
                     verifycode(ed1.getText().toString());
                 }

             }
         });
         bt2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String pnumber=tv.getText().toString();
                 String fnumber="+"+pnumber;
                 phno=fnumber;
                 sendOtp(fnumber);
             }
         });

    }
    public void sendOtp(String PhoneNumber){
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mauth)
                        .setPhoneNumber(PhoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {


        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            final String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                verifycode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(MainActivity.this, "Verification Failed !", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCodeSent(@NonNull String verificationId,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(verificationId, token);
            verifyId = verificationId;

        }};


    private void verifycode(String code) {
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verifyId,code);
        signInByCredential(credential);
    }
    private void signInByCredential(PhoneAuthCredential credential){
        FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful()){
                 FirebaseUser user=task.getResult().getUser();
                 String my_uid=FirebaseAuth.getInstance().getCurrentUser().getUid();
                 Intent int1=new Intent(MainActivity.this,OptionShowActivity.class);
                 int1.putExtra("UN_ID",my_uid);
                 int1.putExtra(Phone_Number,phno);


                 startActivity(int1);
                 Toast.makeText(MainActivity.this, "Moving to next Step!", Toast.LENGTH_SHORT).show();
             }
             else{
                 Toast.makeText(MainActivity.this, "OTP doesn't match!", Toast.LENGTH_SHORT).show();
             }
            }
        });
    }
}