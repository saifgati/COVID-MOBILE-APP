package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Bib.db";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user (email text primary key,password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);
    }

    public boolean insertuser(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);
        long ins=db.insert("user",null,contentValues);
        if(ins==1) return false;
        else return true;
    }
    public boolean chkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from user where email=?",new String[]{email});
        if(cur.getCount()>0) return false;
        else return  true;
    }
    public boolean login(String email,String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur=db.rawQuery("select * from user where email=? and password=?",new String[]{email,password});
        if(cur.getCount()>0)return true;
        else return false;
    }
    public Integer Deleteuser (String email){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("user", "email = ?",new String[] {email});
    }
}
