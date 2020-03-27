package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Symptons extends AppCompatActivity {
    TextView t11,t12;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12;
    public int i = 0, A=0,B=2,C=5,D=11 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptons);
        t12 = findViewById(R.id.t12);
        t11 = findViewById(R.id.t11);

        c1 = findViewById(R.id.c1);
        c2 = findViewById(R.id.c2);
        c3 = findViewById(R.id.c3);
        c4 = findViewById(R.id.c4);
        c5 = findViewById(R.id.c5);
        c6 = findViewById(R.id.c6);
        c7 = findViewById(R.id.c7);
        c8 = findViewById(R.id.c8);
        c9 = findViewById(R.id.c9);
        c10 = findViewById(R.id.c10);
        c11 = findViewById(R.id.c11);
        c12 = findViewById(R.id.c12);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c2.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c3.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c4.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c5.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c6.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c7.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c8.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c9.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c10.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c11.isChecked()){
                    i= i + 1;
                }
                else
                    i=i-1;
            }
        });
        c12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c12.isChecked()){
                    i++;
                }
                else
                    i=i-1;
            }
        });
        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>=A && i<=B){
                    Toast.makeText(Symptons.this,"You have nothing just some stress",Toast.LENGTH_LONG).show();
                }else if (i> B && i <= C){
                    Toast.makeText(Symptons.this,"You have to drink more water, take care of your self and check again in few days !",Toast.LENGTH_LONG).show();

                }else if (i>C && i<=D){
                    Toast.makeText(Symptons.this,"You better call your doctor",Toast.LENGTH_LONG).show();

                }else if (i>D){
                    Toast.makeText(Symptons.this,"Hit call for help ",Toast.LENGTH_LONG).show();

                }else {
                    Toast.makeText(Symptons.this,"You are good ",Toast.LENGTH_LONG).show();

                }
            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "tel:190";
                Intent i0 = new Intent(Intent.ACTION_CALL);
                i0.setData(Uri.parse(s));
                if (ActivityCompat.checkSelfPermission(Symptons.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    return;
                }
                startActivity(i0);

            }
        });
    }
}
