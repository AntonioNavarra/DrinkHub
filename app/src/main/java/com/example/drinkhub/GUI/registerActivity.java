package com.example.drinkhub.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.drinkhub.R;

public class registerActivity extends AppCompatActivity {
    private ImageButton backBtn;
    private Button submitBtn;
    private EditText usernameNewUser;
    private EditText passwordNewUser;
    private CheckBox rememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        usernameNewUser=findViewById(R.id.new_user_EditText);
        passwordNewUser=findViewById(R.id.new_password_EditText);
    }
}