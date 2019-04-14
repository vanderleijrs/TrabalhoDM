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
            convertView = inflater.inflate (R.layout.activity_produto, null);
            item = new Suporte();
            item.tvProduto = (TextView) convertView.findViewById(R.id.etProduto);
            item.tvPreco = (TextView) convertView.findViewById(R.id.etPreco);
            item.tvQuantidade = (TextView) convertView.findViewById(R.id.etQuantidade);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }

        Produto nota = lista.get( position );
        item.tvProduto.setText( String.valueOf( nota.getId() ) );
        item.tvPreco.setText(  nota.getProduto()  );
        item.tvQuantidade.setText(  nota.getPreco()  );



        return convertView;
    }

    private class Suporte{
        TextView tvProduto,tvPreco, tvQuantidade;
    }

}


