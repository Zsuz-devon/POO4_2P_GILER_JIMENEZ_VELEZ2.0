package com.example.proyectopoojuegosolimpicos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button biniciarsesion;
    private Button bcalendario;
    private Button bmedallero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        biniciarsesion = findViewById(R.id.biniciarsesion);
        bcalendario = findViewById(R.id.bcalendario);
        bmedallero = findViewById(R.id.bmedallero);
    }

    public void iniciarSesion (View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void mostrarCalendario (View view){
        Intent intent = new Intent(this, CalendarioActivity.class);
        startActivity(intent);
    }
    public void mostrarMedallero (View view){
        Intent intent = new Intent(this, MedalleroActivity.class);
        startActivity(intent);
    }


}