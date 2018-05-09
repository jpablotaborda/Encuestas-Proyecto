package com.example.juanpablo.encuestas;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Menuprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprincipal);
        FacebookLogin fblogin= new FacebookLogin();
        getSupportFragmentManager().beginTransaction().replace(R.id.fram_frag_facebooklogin,fblogin).addToBackStack(null).commit();


    }
}
