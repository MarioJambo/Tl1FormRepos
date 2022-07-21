package mz.ac.isutc.i33.tl1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "pessoas.db";

    public DbHelper(@Nullable Context context) {
        super(context,
                "pessoas.db",
                null,
                1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Criação da tabela de users
        db.execSQL("create table pessoas(nome TEXT primary key, idade TEXT," +
                " peso TEXT, altura TEXT, provincia TEXT, sexo TEXT, def TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists pessoas");
    }

    public boolean insertData(String nome , String idade, String
                              peso, String altura, String provincia,
                              String sexo, String def
                              ) {//método para Incerção de dados

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("nome", nome);
        values.put("idade", idade);
        values.put("altura",altura);
        values.put("peso", peso);
        values.put("sexo",sexo);
        values.put("def",def);
        values.put("provincia",provincia);

        long result = db.insert("pessoas", null, values);
        if (result == -1){
            return false;
        }else{
            return true;}
    }
    public Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from "+ "pessoas";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

}
