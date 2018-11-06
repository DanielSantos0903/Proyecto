package ejemplo1.com.proyecto.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import ejemplo1.com.proyecto.Modelos.Ruta;
import ejemplo1.com.proyecto.R;

public class Adaptador_Ruta extends RecyclerView.Adapter<Adaptador_Ruta.ViewHolderRuta> implements View.OnClickListener {

    private ArrayList<Ruta> ListaRuta;

    private View.OnClickListener listener;

    public Adaptador_Ruta(ArrayList<Ruta> listaRuta) {
        ListaRuta = listaRuta;
    }

    @NonNull
    @Override
    public ViewHolderRuta onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,null,false);
        v.setOnClickListener(this);

        ViewHolderRuta tvh = new ViewHolderRuta(v);

        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderRuta Ruta,final int posicion) {

     Ruta.txtNombreRuta.setText(ListaRuta.get(posicion).getNombreRuta());
     Ruta.txtDescripcionRuta.setText(ListaRuta.get(posicion).getDescripcion());
     Ruta.FotoRuta.setImageResource(ListaRuta.get(posicion).getFotoRuta());
     //Picasso.with(null).load("https://www.enriquedans.com/wp-content/uploads/2018/06/GitHub-Octocat.jpg").into(Ruta.FotoRuta);

    }

    @Override
    public int getItemCount() {
        return ListaRuta.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }


    public class ViewHolderRuta extends RecyclerView.ViewHolder {

        TextView txtNombreRuta, txtDescripcionRuta;
        ImageView FotoRuta;

        public ViewHolderRuta(@NonNull View itemView) {
            super(itemView);
            this.txtNombreRuta = itemView.findViewById(R.id.txtNombreRuta);
            this.txtDescripcionRuta = itemView.findViewById(R.id.txtPueblos);
            this.FotoRuta = itemView.findViewById(R.id.imgRuta);
        }
    }

}





