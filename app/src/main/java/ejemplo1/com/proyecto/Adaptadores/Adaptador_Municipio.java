package ejemplo1.com.proyecto.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import ejemplo1.com.proyecto.Modelos.Municipios;

import ejemplo1.com.proyecto.R;

public class Adaptador_Municipio extends RecyclerView.Adapter<Adaptador_Municipio.ViewHolderMunicipio> implements View.OnClickListener{

    private ArrayList<Municipios> ListaMunicipio;

    private View.OnClickListener listener;

    public Adaptador_Municipio(ArrayList<Municipios> listaMunicipio) {
        ListaMunicipio = listaMunicipio;
    }

    @NonNull
    @Override
    public ViewHolderMunicipio onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_municard,null,false);
        v.setOnClickListener(this);

        ViewHolderMunicipio tvh = new ViewHolderMunicipio(v);

        return tvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderMunicipio Municipio, int posicion) {

        Municipio.txtNombreMunicipio.setText(ListaMunicipio.get(posicion).getNombreMunicipio());
        //Municipio.txtDescripcionMunicipio.setText(ListaMunicipio.get(posicion).getDescripcion());
        Municipio.FotoMunicipio.setImageResource(ListaMunicipio.get(posicion).getFotos());
    }

    @Override
    public int getItemCount() {
        return ListaMunicipio.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null)
            listener.onClick(v);
    }

    public class ViewHolderMunicipio extends RecyclerView.ViewHolder {

        TextView txtNombreMunicipio, txtDescripcionMunicipio;
        ImageView FotoMunicipio;

        public ViewHolderMunicipio(@NonNull View itemView) {
            super(itemView);
            this.txtNombreMunicipio = itemView.findViewById(R.id.txtNombreMunicipio);
            //this.txtDescripcionMunicipio = itemView.findViewById(R.id.txtdescripcion);
            this.FotoMunicipio = itemView.findViewById(R.id.imgMunicipio);

        }
    }
}