package com.example.rawan_amash;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    private EditText etMail,etPassword;
    private Button btnRegister;
    private TextView tvWelcome;

    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etMail= findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnRegister = findViewById(R.id.Registerbtn);
 preferences = getSharedPreferences("Userinfo",8);
    }
    public void register(View view){
        String input_mail=etMail.getText().toString();
        String input_password = etPassword.getText().toString();
        if (input_mail.length()>0){
            //open preferences file
            SharedPreferences.Editor editor= preferences.edit();
            //save key ,value data
            editor.putString("username",input_mail);
            editor.putString("password",input_password);
            editor.apply();
            Toast.makeText(this,"User registered!",Toast.LENGTH_LONG).show();
            Intent intent_main = new Intent(this,MainActivity.class);
            startActivity(intent_main);
        }
        else {
            Toast.makeText(this,"Empty values,please insert !",Toast.LENGTH_SHORT).show();

        }
    }

}