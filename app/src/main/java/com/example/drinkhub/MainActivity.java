package com.example.drinkhub;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.example.drinkhub.activities.loginActivity;

public class MainActivity extends AppCompatActivity {

    // Durata della schermata di caricamento in millisecondi
    private static final int screen_timeout = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Imposta un ritardo per la schermata di caricamento
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Avvia l'attività principale dopo il ritardo
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);

                // Chiude la schermata di caricamento
                finish();
            }
        }, screen_timeout);
    }
}