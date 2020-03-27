package com.example.myapplication;

import android.os.Bundle;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class Protection extends AppCompatActivity {

    PDFView pdf1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protection);
        pdf1 = findViewById(R.id.pdf1);
        pdf1.fromAsset("upper.pdf").load();
    }
}
