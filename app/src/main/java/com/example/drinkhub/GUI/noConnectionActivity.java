package com.example.drinkhub.GUI;

import android.os.Bundle;

import com.example.drinkhub.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class noConnectionActivity extends Activity {
    private Button internetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_connection);

        internetBtn = findViewById(R.id.internetBtn);
        internetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isConnected()) {
                    Intent intent = new Intent(noConnectionActivity.this, loginActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(noConnectionActivity.this, "Connessione non disponibile", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private  boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = (activeNetwork != null) && activeNetwork.isConnectedOrConnecting();

        return isConnected;
    }
}