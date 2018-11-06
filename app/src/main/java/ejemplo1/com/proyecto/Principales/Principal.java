package ejemplo1.com.proyecto.Principales;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import ejemplo1.com.proyecto.R;

public class Principal extends AppCompatActivity {

    private Button mapa;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        imageView = findViewById(R.id.imagen);

        imageView.setAdjustViewBounds(true);


        mapa =  findViewById(R.id.btnMapa);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.boton_navegacion);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.action_add:

                        Toast.makeText(Principal.this,"INICIO", Toast.LENGTH_SHORT).show();

                        break;

                    case R.id.action_edit:
                        Toast.makeText(Principal.this,"PROMOCIONES", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.action_remove:
                        Toast.makeText(Principal.this, "HISTORIA", Toast.LENGTH_SHORT).show();
                        break;

                }

                return true;
            }
        });

        mapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map = new Intent(Principal.this, Ubicacion.class);
                startActivity(map);
            }
        });


    }
}
