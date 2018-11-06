package ejemplo1.com.proyecto.Principales;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

import ejemplo1.com.proyecto.Modelos.Ruta;
import ejemplo1.com.proyecto.R;

public class Splash extends AppCompatActivity {
    private Timer timer;
    private ProgressBar progressBar;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //progressBar.getSolidColor(ColorStateList.valueOf(Color.BLUE));
    progressBar =  findViewById(R.id.pgBar);
    progressBar.setProgress(0);
    final long intervalo = 45;
    timer = new Timer();
    timer.schedule(new TimerTask() {
        @Override
        public void run() {
            if (i < 100){
                progressBar.setProgress(i);
                i++;
            }else{
                timer.cancel();
                Intent intent = new Intent(Splash.this,Rutas.class);
                startActivity(intent);
                finish();
            }
        }
    },1 ,intervalo);
    }
}
