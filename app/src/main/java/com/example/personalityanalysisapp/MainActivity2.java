package com.example.personalityanalysisapp;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {
    FirebaseAuth mauth;
    FirebaseDatabase database;
    public static  int result=0;

    DatabaseReference usersRef, myqref;
    FirebaseDatabase database1=FirebaseDatabase.getInstance();


    String uid;
    Button submit,res;
    ImageView imageView2,imageView4;
    TextView tv1, tv2, tv3, tv4, tv5,tv6,tv7,tv8,tv9,tv10,tv11,tv12,tv13,tv14,tv15,tv16,tv17,tv18,tv19,tv20;
    EditText e1, e2, e3, e4, e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20;
    int i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        mauth=FirebaseAuth.getInstance();
        imageView2=findViewById(R.id.imageView2);
        imageView4=findViewById(R.id.imageView4);
        tv1 = findViewById(R.id.tv_1);
        tv2 = findViewById(R.id.tv_2);
        tv3 = findViewById(R.id.tv_3);
        tv4 = findViewById(R.id.tv_4);
        tv5 = findViewById(R.id.tv_5);
        tv6=findViewById(R.id.tv_6);
        tv7=findViewById(R.id.tv_7);
        tv8=findViewById(R.id.tv_8);
        tv9=findViewById(R.id.tv_9);
        tv10=findViewById(R.id.tv_10);
        tv11=findViewById(R.id.tv_11);
        tv12=findViewById(R.id.tv_12);
        tv13=findViewById(R.id.tv_13);
        tv14=findViewById(R.id.tv_14);
        tv15=findViewById(R.id.tv_15);
        tv16=findViewById(R.id.tv_16);
        tv17=findViewById(R.id.tv_17);
        tv18=findViewById(R.id.tv_18);
        tv19=findViewById(R.id.tv_19);
        tv20=findViewById(R.id.tv_20);
        res=findViewById(R.id.res);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e6=findViewById(R.id.e6);
        e7=findViewById(R.id.e7);
        e8=findViewById(R.id.e8);
        e9=findViewById(R.id.e9);
        e10=findViewById(R.id.e10);
        e11=findViewById(R.id.e11);
        e12=findViewById(R.id.e12);
        e13=findViewById(R.id.e13);
        e14=findViewById(R.id.e14);
        e15=findViewById(R.id.e15);
        e16=findViewById(R.id.e16);
        e17=findViewById(R.id.e17);
        e18=findViewById(R.id.e18);
        e19=findViewById(R.id.e19);
        e20=findViewById(R.id.e20);
        submit = findViewById(R.id.submit);


        uid = mauth.getCurrentUser().getUid();
        usersRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://personalityanalysisapp-default-rtdb.firebaseio.com");
        //created a child of 10 questions for every uid

        usersRef.child(uid).child("q1").setValue("0");
        usersRef.child(uid).child("q2").setValue("0");
        usersRef.child(uid).child("q3").setValue("0");
        usersRef.child(uid).child("q4").setValue("0");
        usersRef.child(uid).child("q5").setValue("0");
        usersRef.child(uid).child("q6").setValue("0");
        usersRef.child(uid).child("q7").setValue("0");
        usersRef.child(uid).child("q8").setValue("0");
        usersRef.child(uid).child("q9").setValue("0");
        usersRef.child(uid).child("q10").setValue("0");



       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s1 = e1.getText().toString();
               try{
                   i1 = Integer.parseInt(s1);}
               catch(NumberFormatException nfe){
                   i1 = 0;
               }
               String s2 = e2.getText().toString();
               try{
                   i2 = Integer.parseInt(s2);}
               catch (NumberFormatException nfe){
                   i2 = 0;
               }

               String s3 = e3.getText().toString();
               try{
                   i3 = Integer.parseInt(s3);}
               catch (NumberFormatException nfe){
                  i3 = 0;
               }
               String s4 = e4.getText().toString();
               try{
                   i4 = Integer.parseInt(s4);}
               catch (NumberFormatException nfe){
                  i4 = 0;
               }
               String s5 = e5.getText().toString();
               try{
                   i5 = Integer.parseInt(s5);}
               catch(NumberFormatException nfe){
                  i5 = 0;
                  System.out.println(i5);
               }
               String s6 = e6.getText().toString();
               try{
                   i6 = Integer.parseInt(s6);}
               catch(NumberFormatException nfe){
                   i6=0;
               }
               String s7 = e7.getText().toString();
               try{
                   i7= Integer.parseInt(s7);}
               catch(NumberFormatException nfe){
                   i7=0;
               }
               String s8 = e8.getText().toString();
               try{
                   i8= Integer.parseInt(s8);}
               catch(NumberFormatException nfe){
                   i8=0;
               }
               String s9 = e9.getText().toString();
               try{
                   i9= Integer.parseInt(s9);}
               catch(NumberFormatException nfe){
                   i9=0;
               }
               String s10 = e10.getText().toString();
               try{
                   i10= Integer.parseInt(s10);}
               catch(NumberFormatException nfe){
                   i10=0;
               }
               String s11= e11.getText().toString();
               try{
                   i11= Integer.parseInt(s11);}
               catch(NumberFormatException nfe){
                   i11=0;
               }
               String s12 = e12.getText().toString();
               try{
                   i12= Integer.parseInt(s12);}
               catch(NumberFormatException nfe){
                   i12=0;
               }
               String s13 = e13.getText().toString();
               try{
                   i13= Integer.parseInt(s13);}
               catch(NumberFormatException nfe){
                   i13=0;
               }
               String s14 = e14.getText().toString();
               try{
                   i14= Integer.parseInt(s14);}
               catch(NumberFormatException nfe){
                   i14=0;
               }
               String s15 = e15.getText().toString();
               try{
                   i15= Integer.parseInt(s15);}
               catch(NumberFormatException nfe){
                   i15=0;
               }
               String s16 = e16.getText().toString();
               try{
                   i16= Integer.parseInt(s16);}
               catch(NumberFormatException nfe){
                   i16=0;
               }
               String s17 = e17.getText().toString();
               try{
                   i17= Integer.parseInt(s17);}
               catch(NumberFormatException nfe){
                   i17=0;
               }
               String s18 = e18.getText().toString();
               try{
                   i18= Integer.parseInt(s18);}
               catch(NumberFormatException nfe){
                   i18=0;
               }
               String s19 = e19.getText().toString();
               try{
                   i19= Integer.parseInt(s19);}
               catch(NumberFormatException nfe){
                   i19=0;
               }
               String s20 = e20.getText().toString();
               try{
                   i20= Integer.parseInt(s20);}
               catch(NumberFormatException nfe){
                   i20=0;
               }

               if((s1.isEmpty())||(i1<1)||(i1>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s2.isEmpty())||(i2<1)||(i2>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if ((s3.isEmpty())||(i3<1)||(i3>5)) {
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if ((s4.isEmpty())||(i4<1)||(i4>5)) {
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s5.isEmpty())||(i5<1)||(i5>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s6.isEmpty())||(i6<1)||(i6>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s7.isEmpty())||(i7<1)||(i7>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s8.isEmpty())||(i8<1)||(i8>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s9.isEmpty())||(i9<1)||(i9>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s10.isEmpty())||(i10<1)||(i10>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s11.isEmpty())||(i11<1)||(i11>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s12.isEmpty())||(i12<1)||(i12>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s13.isEmpty())||(i13<1)||(i13>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s14.isEmpty())||(i14<1)||(i14>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s15.isEmpty())||(i15<1)||(i15>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s16.isEmpty())||(i16<1)||(i16>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s17.isEmpty())||(i17<1)||(i17>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s18.isEmpty())||(i18<1)||(i18>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s19.isEmpty())||(i19<1)||(i19>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else if((s20.isEmpty())||(i20<1)||(i20>5)){
                   Toast.makeText(MainActivity2.this, "Enter the number from 1 to 5!", Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(MainActivity2.this, "You answered all the questions!", Toast.LENGTH_SHORT).show();
               }
               usersRef.child(uid).child("ans1").setValue(s1);
               usersRef.child(uid).child("ans2").setValue(s2);
               usersRef.child(uid).child("ans3").setValue(s3);
               usersRef.child(uid).child("ans4").setValue(s4);
               usersRef.child(uid).child("ans5").setValue(s5);
               usersRef.child(uid).child("ans6").setValue(s6);
               usersRef.child(uid).child("ans7").setValue(s7);
               usersRef.child(uid).child("ans8").setValue(s8);
               usersRef.child(uid).child("ans9").setValue(s9);
               usersRef.child(uid).child("ans10").setValue(s10);
               usersRef.child(uid).child("ans11").setValue(s11);
               usersRef.child(uid).child("ans12").setValue(s12);
               usersRef.child(uid).child("ans13").setValue(s13);
               usersRef.child(uid).child("ans14").setValue(s14);
               usersRef.child(uid).child("ans15").setValue(s15);
               usersRef.child(uid).child("ans16").setValue(s16);
               usersRef.child(uid).child("ans17").setValue(s17);
               usersRef.child(uid).child("ans18").setValue(s18);
               usersRef.child(uid).child("ans19").setValue(s19);
               usersRef.child(uid).child("ans20").setValue(s20);



           }
       });
       res.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent in=new Intent(MainActivity2.this,ResultActivity.class);
               startActivity(in);
           }
       });

    }
}