package com.example.rawan_amash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText etMail, etPassword;
    private Button btnLogin,btnSignup;
    private TextView tvSignup,tvWelcome;
    private final String valid_mail = "admin";
    private final String valid_password = "1";
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMail= findViewById(R.id.username);
        etPassword = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
        btnSignup = findViewById(R.id.Registerbtn);
        preferences = getSharedPreferences("Userinfo",0);
    }
    public void register(View view){
        Intent i_register=new Intent(this, RegisterActivity.class);
                startActivity(i_register);
    }
    public void login(View view){
        String input_mail = etMail.getText().toString();
        String input_password = etPassword.getText().toString();
        String registeredMail = preferences.getString("password","");
        String registeredPassword = preferences.getString("password","");
        if (input_mail.equals(registeredMail)&& input_password.equals(registeredPassword)){
            Intent i_mail = new Intent(this,Mail.class);
            startActivity(i_mail);
        }
        else {
            Toast.makeText(this, "Incorrect credentials!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help_menu:
                Intent i =new Intent(this,HelpActivity.class);
                startActivity(i);
                break;
            case R.id.setting_menu:
                Intent v =new Intent(this,SettingActivity.class);
                startActivity(v);
                break;
            case R.id.Logout_menu:
                Intent h =new Intent(this,MainActivity.class);
                startActivity(h);
                break;
            case R.id.about_menu:
                Intent m =new Intent(this,AboutActivity.class);
                startActivity(m);
                break;

        }
        return true;
    }
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you Sure you want to exit")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("NO", null);
    }


}
