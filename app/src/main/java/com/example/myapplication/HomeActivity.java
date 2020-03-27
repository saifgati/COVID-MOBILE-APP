package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    Button bt,b2,quit;
    EditText e1,e2;
    DatabaseHelper db;
    TextView t4;

    SQLiteDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t4 = findViewById(R.id.textView4);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        bt = findViewById(R.id.button_login);
        b2 = findViewById(R.id.button_register);
        quit = findViewById(R.id.quit);
        db=new DatabaseHelper(this);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(HomeActivity.this);
                alert.setTitle("Attention");
                alert.setMessage("Voulez vous quittez ?");
                alert.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                alert.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alert.show();
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = e1.getText().toString();
                String pass = e2.getText().toString();
                boolean check = db.login(user, pass);
                if (check == true) {
                    Intent i = new Intent(HomeActivity.this, Basic.class);
                    startActivity(i);
                    e1.setText(null);
                    e2.setText(null);
                } else {
                    if (e1.length() == 0)
                        e1.setError("");
                    if (e2.length() == 0)
                        e2.setError("");
                    else
                        Toast.makeText(HomeActivity.this, "Erreur d'identification ou non inscrit", Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdb=db.getReadableDatabase();
                Cursor cur=mdb.rawQuery("select count(*) from user",null);
                cur.moveToFirst();
                int c=cur.getInt(0);
                if(c>0){
                    String u=e1.getText().toString();
                    String p=e2.getText().toString();
                    boolean check=db.login(u,p);
                    if(check==true) {
                        Intent i = new Intent(HomeActivity.this, Registration.class);
                        startActivity(i);
                        e1.setText(null);
                        e2.setText(null);
                    }
                    else if(u.equals("")|| p.equals("")){
                        Toast.makeText(HomeActivity.this, "Déjà inscrit entrez votre identifiant et votre mot de passe pour accéder à cette interface", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(HomeActivity.this, "Erreur d'identification vérifier votre login et mot de passe", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(HomeActivity.this, Registration.class);
                    startActivity(i);
                    e1.setText(null);
                    e2.setText(null);
                }
            }
        });
    }
}
