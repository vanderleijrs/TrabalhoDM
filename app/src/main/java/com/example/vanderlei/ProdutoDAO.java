package com.example.vanderlei;



        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;

        import java.util.ArrayList;
        import java.util.List;

public class ProdutoDAO {

    public static final void inserir(Produto nota, Context context){
        Banco banco = new Banco(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", nota.getNome() );
        valores.put("quantidade", nota.getQuantidade());
        valores.put("preco", nota.getPreco());
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("produto", null, valores);
    }

    public static final void excluir(int idProd, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("produto", "id = "+idProd, null);
    }

    public static final List<Produto> listar(Context context){
        List<Produto> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM produto ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto prod = new Produto();
                prod.setId( cursor.getInt( 0 ) );
                prod.setNome( cursor.getString( 1 ) );
                prod.setPreco( cursor.getString( 2) );
                prod.setQuantidade( cursor.getString( 3 ) );
                lista.add( prod );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }

}








