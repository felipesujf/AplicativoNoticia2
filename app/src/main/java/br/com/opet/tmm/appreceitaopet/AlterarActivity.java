package br.com.opet.tmm.appreceitaopet;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AlterarActivity extends Activity {

    EditText titulo;
    EditText autor;
    EditText noticia;
    Button alterar;
    Button deletar;
    Cursor cursor;
    BancoController crud;
    String codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo = this.getIntent().getStringExtra("codigo");

        crud = new BancoController(getBaseContext());

        titulo = (EditText)findViewById(R.id.editText4);
        autor = (EditText)findViewById(R.id.editText5);
        noticia = (EditText)findViewById(R.id.editText6);

        alterar = (Button)findViewById(R.id.button2);

        cursor = crud.carregaDadoById(Integer.parseInt(codigo));
        titulo.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.AUTOR)));
        noticia.setText(cursor.getString(cursor.getColumnIndexOrThrow(CriaBanco.NOTICIA)));

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alteraRegistro(Integer.parseInt(codigo), titulo.getText().toString(),autor.getText().toString(),
                        titulo.getText().toString());
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        deletar = (Button)findViewById(R.id.button3);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent = new Intent(AlterarActivity.this,ConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
