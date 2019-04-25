package com.example.vanderlei;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProdutoActivity extends AppCompatActivity {

    private EditText etNome, etPreco, etQuantidade;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        etNome = (EditText) findViewById(R.id.etNome);
        etPreco = (EditText) findViewById(R.id.etPreco);
        etQuantidade = (EditText) findViewById(R.id.etQuantidade);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar(){
        Produto nota = new Produto();
        nota.setNome( etNome.getText().toString() );
        nota.setPreco( etPreco.getText().toString() );
        nota.setQuantidade( etQuantidade.getText().toString() );
        ProdutoDAO.inserir(nota, this);
        this.finish();
    }
}

