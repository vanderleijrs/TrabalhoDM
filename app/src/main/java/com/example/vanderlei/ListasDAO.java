package com.example.vanderlei;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListasDAO {

    public static final List<Listas> listar(Context context){
        List<Listas> listas = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM lista ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Listas list = new Listas();
                list.setId( cursor.getInt( 0 ) );
                list.setNome( cursor.getString( 1 ) );

                listas.add( list );
            }while ( cursor.moveToNext() );
        }
        return listas;
    }
}
