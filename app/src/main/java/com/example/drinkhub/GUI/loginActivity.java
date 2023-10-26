package com.example.drinkhub.GUI;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.drinkhub.R;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class loginActivity extends AppCompatActivity {

    private TextView register;
    private ImageView showPassword;
    private EditText usernameField;
    private EditText passwordField;
    private CheckBox rememberMe;
    private Button loginBtn;
    private Boolean isShowed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register = findViewById(R.id.register_message);
        showPassword = findViewById(R.id.showPw);
        usernameField = findViewById(R.id.username_EditText);
        passwordField = findViewById(R.id.password_EditText);
        rememberMe = findViewById(R.id.rememberMe);
        loginBtn = findViewById(R.id.loginButton);

        SharedPreferences sharedPreferences = loginActivity.this.getSharedPreferences("utente", MODE_PRIVATE);

        if (rememberMe.isChecked()) {
            usernameField.setText(sharedPreferences.getString("username", ""));
        }

        showPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowed) {
                    showPassword.setImageResource(R.drawable.ic_show_password);
                    passwordField.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    isShowed = false;
                } else {
                    showPassword.setImageResource(R.drawable.ic_hide_password);
                    passwordField.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    isShowed = true;
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, registerActivity.class);
                startActivity(intent);
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usernameField.getText().toString().isEmpty() || passwordField.getText().toString().isEmpty()) {
                    Toast.makeText(loginActivity.this, "Alcuni campi sono vuoti", Toast.LENGTH_SHORT).show();
                } else {
                    LoginUser loginUser = new LoginUser(usernameField.getText().toString(), passwordField.getText().toString(),loginActivity.this);
                    loginUser.execute();
                }
            }
        });

    }

    class LoginUser extends AsyncTask<Void, Void, String> {

        private static final String SERVER_IP = "192.168.1.15";
        private static final int SERVER_PORT = 8080;
        private InputStream in;
        private BufferedWriter out;
        private Socket socket;
        private String username, password;
        private Context context;
        private String response = "";
        private ProgressDialog pdLoading;

        LoginUser(String username, String password, Context context) {
            this.username = username;
            this.password = password;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading = new ProgressDialog(context);
            pdLoading.setMessage("\tLogin in corso...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVER_PORT);

                in = socket.getInputStream();
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

                sendDataToServer("Login;" + username + ";" + password + ";");

                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
                byte[] buffer = new byte[1024];
                int bytesRead;

                if ((bytesRead = in.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                    response = byteArrayOutputStream.toString("UTF-8");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                    in.close();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pdLoading.dismiss();

            if (!result.equals("Errore")) {
                SharedPreferences sharedPreferences = loginActivity.this.getSharedPreferences("Utente", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Username", username);
                editor.putString("Password", password);
                editor.putBoolean("Logged", true);
                editor.putBoolean("Check", rememberMe.isChecked());
                editor.commit();

                Toast.makeText(context, "Login avvenuto con successo", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, homeFragment.class);
                startActivity(intent);
            } else {
                Toast.makeText(context, "Si è verificato un errore durante la login", Toast.LENGTH_SHORT).show();
            }
        }

        public void sendDataToServer(final String data) {
            try {
                out.write(data);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}