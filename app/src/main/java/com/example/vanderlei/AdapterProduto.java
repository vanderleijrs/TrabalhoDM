package com.example.vanderlei;



import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterProduto extends BaseAdapter {

    private Context context;
    private List<Produto> lista;
    private LayoutInflater inflater;

    public AdapterProduto(Context context, List<Produto> lista){
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate(R.layout.layout_lista, null);
            item = new Suporte();
            item.tvCodigo = (TextView)convertView.findViewById(R.id.tvCodigo);
            item.tvNome = (TextView) convertView.findViewById(R.id.tvNome);
            item.tvPreco = (TextView) convertView.findViewById(R.id.tvPreco);
            item.tvQuantidade = (TextView) convertView.findViewById(R.id.tvQuantidade);
            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Produto prod = lista.get( position );
       item.tvCodigo.setText( String.valueOf( prod.getId() ) );
        item.tvNome.setText(  prod.getNome()  );
        item.tvPreco.setText(  prod.getPreco()  );
        item.tvQuantidade.setText( prod.getQuantidade()  );



        return convertView;
    }

    private class Suporte{
        TextView tvCodigo, tvNome, tvPreco,tvQuantidade;
    }

}










