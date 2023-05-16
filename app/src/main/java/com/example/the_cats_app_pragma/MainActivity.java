package com.example.the_cats_app_pragma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Establecer el modo noche predeterminado en "Modo noche apagado" (MODE_NIGHT_NO)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        new Handler().postDelayed(new Runnable(){
            public void run(){

                //----------------------------
                //mProgressDialog.dismiss();
                Intent intent = new Intent(getApplicationContext(), VistaRecycler.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                //intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
                finish();
                //----------------------------

            }
        }, 3000); //5000 millisegundos = 5 segundos.
    }


}