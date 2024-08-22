package com.example.proyectopoojuegosolimpicos;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Modelo.Pais;

public class MedalleroActivity extends AppCompatActivity {
    private Button bordenar;
    private Button bvolverM;
    private TableLayout medallasLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_medallero);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bordenar = findViewById(R.id.bordenar);
        bvolverM = findViewById(R.id.bvolverM);
        medallasLayout = findViewById(R.id.medallasLayout);
        List<Pais> Paises = generarMedallas();
        mostrarMedallas(Paises);





        bordenar.setOnClickListener(v -> {
            Collections.sort(Paises, (c1, c2) -> c2.getOro() - c1.getOro());

            medallasLayout.removeAllViews();
            mostrarMedallas(Paises);
        });



    }

    public void volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private List<Pais> generarMedallas() {
        List<Pais> medallasPaises = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("medallero.txt")))){
            String linea;
            while((linea = br.readLine()) != null){
                String[] datos = linea.split(", ");
                medallasPaises.add(new Pais(datos[0], Integer.parseInt(datos[1]), Integer.parseInt(datos[2]), Integer.parseInt(datos[3])));
            }

        }catch(IOException e){
            e.getMessage();
        }
        return medallasPaises;
    }

    private void mostrarMedallas(List<Pais> Paises) {
        // Configuración para bordes
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5, 5, 5, 5);

        // Crear la fila de encabezado
        TableRow headerRow = new TableRow(this);
        headerRow.setLayoutParams(layoutParams);

// Crear TextViews para cada etiqueta
        TextView headerCountry = new TextView(this);
        headerCountry.setText("País");
        headerCountry.setTypeface(null, Typeface.BOLD); // Texto en negrita
        headerCountry.setPadding(16, 16, 16, 16); // Padding
        headerCountry.setGravity(Gravity.CENTER); // Centrar texto
        headerCountry.setTextSize(16); // Tamaño del texto
        headerRow.addView(headerCountry);

        TextView headerGold = new TextView(this);
        headerGold.setText("Oro");
        headerGold.setTypeface(null, Typeface.BOLD);
        headerGold.setPadding(16, 16, 16, 16); // Padding
        headerGold.setGravity(Gravity.CENTER); // Centrar texto
        headerGold.setTextSize(16); // Tamaño del texto
        headerRow.addView(headerGold);

        TextView headerSilver = new TextView(this);
        headerSilver.setText("Plata");
        headerSilver.setTypeface(null, Typeface.BOLD);
        headerSilver.setPadding(16, 16, 16, 16); // Padding
        headerSilver.setGravity(Gravity.CENTER); // Centrar texto
        headerSilver.setTextSize(16); // Tamaño del texto
        headerRow.addView(headerSilver);

        TextView headerBronze = new TextView(this);
        headerBronze.setText("Bronce");
        headerBronze.setTypeface(null, Typeface.BOLD);
        headerBronze.setPadding(16, 16, 16, 16); // Padding
        headerBronze.setGravity(Gravity.CENTER); // Centrar texto
        headerBronze.setTextSize(16); // Tamaño del texto

        headerRow.addView(headerBronze);

// Agregar la fila de encabezado al TableLayout
        medallasLayout.addView(headerRow);

// Ahora agregar las filas con los datos de los países
        for (Pais pais : Paises) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(layoutParams);

            TextView paisNombre = new TextView(this);
            paisNombre.setText(pais.getNombre());
            paisNombre.setGravity(Gravity.CENTER); // Centrar texto
            row.addView(paisNombre);

            TextView oro = new TextView(this);
            oro.setText(String.valueOf(pais.getOro()));
            oro.setGravity(Gravity.CENTER); // Centrar texto
            row.addView(oro);

            TextView plata = new TextView(this);
            plata.setText(String.valueOf(pais.getPlata()));
            plata.setGravity(Gravity.CENTER); // Centrar texto
            row.addView(plata);

            TextView bronce = new TextView(this);
            bronce.setText(String.valueOf(pais.getBronce()));
            bronce.setGravity(Gravity.CENTER); // Centrar texto
            row.addView(bronce);

            medallasLayout.addView(row);
        }
    }

}