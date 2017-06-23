package br.com.opet.tmm.appreceitaopet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Camila Bento de Araujo
 * Carolina Martins dos Santos
 * Emanuele Shyzue Kajita Dias
 * Christian Felipe da Silva
 */

public class CriaBanco extends SQLiteOpenHelper {

    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String NOTICIA = "noticia";
    public static final int VERSAO = 11;

    public CriaBanco(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + TITULO + " text,"
                + AUTOR + " text,"
                + NOTICIA + " text"
                +")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }
}
