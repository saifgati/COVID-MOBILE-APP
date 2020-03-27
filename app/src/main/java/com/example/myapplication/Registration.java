package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Registration extends AppCompatActivity {
    DatabaseHelper db;
    Button b,b1;
    EditText e1,e2,e3;
    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.button_login);
        b = findViewById(R.id.button_register);
        db=new DatabaseHelper(this);

        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();
                String s3 = e3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(Registration.this, "Il y'a un champ vide", Toast.LENGTH_SHORT).show();
                    if (e1.getText().length() == 0)
                        e1.setError("Saisie nom d'utilisateur");
                    if (e2.getText().length() == 0)
                        e2.setError("Saisie Mot de passe");
                    if (e3.getText().length() == 0)
                        e3.setError("Confirmé votre mot de passe");
                }
                else if (s2.equals(s3) && s1.length() > 0 && s2.length() > 0) {
                    boolean check = db.chkemail(s1);
                    if (check) {
                        db.insertuser(s1, s2);
                        Toast.makeText(Registration.this, "Enregistré avec succès", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(Registration.this, "Utilisateur déja existe", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(Registration.this, "mot de passe ne correspond pas", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().length()>0 && e2.getText().length()==0&&e3.getText().length()==0) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(Registration.this);
                    alert.setTitle("Attention");
                    alert.setMessage("Etes vous sûre de supprimer cette utilisateur ?");
                    alert.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Integer del = db.Deleteuser(e1.getText().toString());
                            if (del > 0) {
                                Toast.makeText(Registration.this, "Utilisateur Supprimé", Toast.LENGTH_SHORT).show();
                                e1.setText("");
                            } else
                                Toast.makeText(Registration.this, "Utilisateur n'existe pas", Toast.LENGTH_SHORT).show();
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
                else
                    Toast.makeText(Registration.this, "Effacer le mot passe pour supprimer l'utilisateur ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
