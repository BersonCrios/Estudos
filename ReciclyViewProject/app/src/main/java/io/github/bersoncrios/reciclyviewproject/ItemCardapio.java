package io.github.bersoncrios.reciclyviewproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by Berso on 04/04/2018.
 */

class ItemHolder extends RecyclerView.ViewHolder{
    ImageView image = null;
    TextView texto = null;
    RatingBar classificacao = null;

    public ItemHolder(View view) {
        super(view);
        image = (ImageView)view.findViewById(R.id.imageView);
        texto = (TextView)view.findViewById(R.id.textView);
        classificacao = (RatingBar)view.findViewById(R.id.ratingBar);
        classificacao.setEnabled(false);
    }
}

public class ItemCardapio{
    String nome;
    int classificacao;
    int codImagem;

    ItemCardapio(String pNome, int classific, int cod) {
        nome = pNome;
        classificacao = classific;
        codImagem = cod;
    }


}
