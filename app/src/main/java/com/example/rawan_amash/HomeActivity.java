package com.example.rawan_amash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
}