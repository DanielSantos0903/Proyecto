package ejemplo1.com.proyecto.Principales;

import android.content.Intent;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import ejemplo1.com.proyecto.Adaptadores.Adaptador_Ruta;
import ejemplo1.com.proyecto.Modelos.Ruta;
import ejemplo1.com.proyecto.R;

public class Rutas extends AppCompatActivity {

    //Declaracion de variables
    private ArrayList<Ruta> ListaRuta;
    private Adaptador_Ruta adaptador_rutas;
    private RecyclerView Reciclador;
    private  ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);

        //Inicializacion de variables
        this.ListaRuta = new ArrayList<>();
        this.Reciclador = findViewById(R.id.Reciclador);
        this.img = findViewById(R.id.imgRuta);


        //Forma de presentar los Datos con RecyclerView
        this.Reciclador.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        LinearLayoutManager llm = new LinearLayoutManager(this);
        Reciclador.setLayoutManager(llm);

        //REGISTRANDO VALORES
        getData();
        adaptador_rutas = new Adaptador_Ruta(ListaRuta);

        //EVENTO CLICK
        adaptador_rutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Ruta= ListaRuta.get(Reciclador.getChildAdapterPosition(v)).getNombreRuta();

                Intent M = new Intent(Rutas.this,MunicipiosRutas.class);
                M.putExtra("Ruta",Ruta);
                startActivity(M);

                Toast.makeText(Rutas.this," "+ ListaRuta.get(Reciclador.getChildAdapterPosition(v)).getNombreRuta(),Toast.LENGTH_LONG ).show();

            }
        });

        DividerItemDecoration Decorador = new DividerItemDecoration(this, llm.getOrientation());
        Reciclador.addItemDecoration(Decorador);
        Reciclador.setAdapter(adaptador_rutas);


    }


    // METODO PARA EXTRAER LOS DATOS DEL WEBSERVICE
    public void getData(){
        //Declaramos la URL
        String sql = "https://raw.githubusercontent.com/JAlfonse/Pruebas/master/README.md";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();

            String json = "";

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }

            json = response.toString();

            JSONArray jsonArr = null;

            jsonArr = new JSONArray(json);
            String mensaje = "";
            for(int i = 0;i<jsonArr.length();i++){
                JSONObject jsonObject = jsonArr.getJSONObject(i);

                Log.d("SLIDA",jsonObject.optString("nombre"));
                mensaje += "NOMBRE "+i+" "+jsonObject.optString("nombre")+"\n";

                ListaRuta.add(new Ruta(jsonObject.optString("nombre"),jsonObject.optString("descripcion"),R.drawable.juego));
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}

