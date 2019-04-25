package com.example.vanderlei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListas extends BaseAdapter {

    private Context context;
    private List<Listas> lista;
    private LayoutInflater inflater;

    public AdapterListas(Context context, List<Listas> lista){
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
            convertView = inflater.inflate(R.layout.listas, null);
            item = new Suporte();
            item.tvCodigo = (TextView)convertView.findViewById(R.id.tvlistaid);
            item.tvNome = (TextView) convertView.findViewById(R.id.tvlistanome);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Listas list = lista.get( position );
        item.tvCodigo.setText( String.valueOf( list.getId() ) );
        item.tvNome.setText(  list.getNome()  );




        return convertView;
    }

    private class Suporte{
        TextView tvCodigo, tvNome;
    }

}










