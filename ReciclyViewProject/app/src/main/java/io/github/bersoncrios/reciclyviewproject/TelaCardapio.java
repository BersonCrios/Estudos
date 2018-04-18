package io.github.bersoncrios.reciclyviewproject;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


class Adaptador extends RecyclerView.Adapter<ItemHolder>{
    Context contexto = null;
    ArrayList<ItemCardapio> lista = null;
    Adaptador(Context contexto, ArrayList<ItemCardapio> lista) {
        this.contexto = contexto;
        this.lista = lista;
    }

    //Método chamado N* para inlfar o xml da celula e retornar um objeto de layout
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View celula = LayoutInflater.from(contexto).inflate(R.layout.layout_celula, parent, false);
        ItemHolder item  = new ItemHolder(celula);
        return item;
    }


    //método chamado n* para exibir o conteudo que será mostrado pela celula

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        ItemCardapio item = lista.get(position);

        holder.texto.setText(item.nome);
        holder.classificacao.setRating(item.classificacao);
        holder.image.setImageBitmap(BitmapFactory.decodeResource(contexto.getResources(), item.codImagem));
    }


    //Método que determna o numero de células a serem criadas na lista
    @Override
    public int getItemCount() {
        return (lista != null) ? lista.size() : 0;
    }
}

public class TelaCardapio extends AppCompatActivity  {

    ArrayList<ItemCardapio> dataSource = null;
    RecyclerView lista = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cardapio);

        dataSource = new ArrayList<ItemCardapio>();

        dataSource.add(new ItemCardapio("Calabresa", 3, R.drawable.calabresa));
        dataSource.add(new ItemCardapio("California", 1, R.drawable.california));
        dataSource.add(new ItemCardapio("Mussarela", 4, R.drawable.mussarela));
        dataSource.add(new ItemCardapio("Portuguesa", 3, R.drawable.portuguesa));
        dataSource.add(new ItemCardapio("Quatro Queijos", 3, R.drawable.quatroqueijos));
        dataSource.add(new ItemCardapio("Refrigerantes", 3, R.drawable.refrigerantes));
        dataSource.add(new ItemCardapio("salada de frutas", 2, R.drawable.saladadefrutas));
        dataSource.add(new ItemCardapio("Sorvete", 2, R.drawable.sorvete));
        dataSource.add(new ItemCardapio("Sucos", 3, R.drawable.sucos));
        dataSource.add(new ItemCardapio("Torta doce", 4, R.drawable.tortadoce));
        dataSource.add(new ItemCardapio("Vinhos", 4, R.drawable.vinhos));

        lista = (RecyclerView)findViewById(R.id.rv);

        lista.setLayoutManager(new LinearLayoutManager(this));
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setHasFixedSize(true);

        Adaptador adapt = new Adaptador(this, dataSource);

        lista.setAdapter(adapt);
    }
}
