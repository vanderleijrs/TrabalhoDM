package com.example.vanderlei;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class ProdutoActivity extends AppCompatActivity{




        private EditText etProduto, etPreco, etQuantidade;
        private Button btnSalvar;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_produto);

            etProduto = (EditText) findViewById(R.id.etProduto);
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
            Produto produto = new Produto();
            produto.setProduto( etProduto.getText().toString() );
            produto.setPreco( etPreco.getText().toString() );
            produto.setQuantidade( etQuantidade.getText().toString() );
            ProdutoDAO.inserir(produto, this);
            this.finish();
        }
}


