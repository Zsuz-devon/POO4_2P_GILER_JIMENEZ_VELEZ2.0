package com.example.proyectopoojuegosolimpicos;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Modelo.Atleta;
import Modelo.DatosIncompletosException;

public class CuentaAccedida extends AppCompatActivity {
    private Spinner spMedalla;
    private Spinner spDeporte;
    private Spinner spPais;
    private RadioGroup rgeneros;
    private EditText editAtleta;
    private Button bguardar;
    private Button bsalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cuenta_accedida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spMedalla = findViewById(R.id.spMedalla);
        spDeporte = findViewById(R.id.spDeporte);
        spPais = findViewById(R.id.spPais);
        editAtleta=findViewById(R.id.editAtleta);
        rgeneros=findViewById(R.id.rgeneros);

        ArrayAdapter<CharSequence> adapterMedalla = ArrayAdapter.createFromResource(this, R.array.medalla_array, android.R.layout.simple_spinner_item);
        adapterMedalla.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spMedalla.setAdapter(adapterMedalla);

        ArrayAdapter<CharSequence> adapterDeporte = ArrayAdapter.createFromResource(this, R.array.deporte_array, android.R.layout.simple_spinner_item);
        adapterDeporte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDeporte.setAdapter(adapterDeporte);

        ArrayAdapter<CharSequence> adapterPais = ArrayAdapter.createFromResource(this, R.array.pais_array, android.R.layout.simple_spinner_item);
        adapterPais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPais.setAdapter(adapterPais);
    }

    public void guardarAtleta(View view) {
        try {
            String nombreAtleta = editAtleta.getText().toString();
            int seleccionadoGeneroId = rgeneros.getCheckedRadioButtonId();
            RadioButton seleccionado = findViewById(seleccionadoGeneroId);
            String genero = (seleccionado != null) ? seleccionado.getText().toString() : null;
            String medalla = spMedalla.getSelectedItem().toString();
            String deporte = spDeporte.getSelectedItem().toString();
            String pais = spPais.getSelectedItem().toString();

            if (nombreAtleta.isEmpty() || genero == null || medalla.isEmpty() || deporte.isEmpty() || pais.isEmpty()) {
                throw new DatosIncompletosException("Todos los datos deben ser llenados");
            }

            Atleta atleta = new Atleta(nombreAtleta, genero, medalla, deporte, pais);
            String lineaAtleta = atleta.getNombre() + ", " + genero + ", " + medalla + ", " + deporte + ", " + pais;
            registrarAtleta(lineaAtleta);
            Toast.makeText(this, "El campeón " + atleta.getNombre() + " ha sido guardado correctamente", Toast.LENGTH_LONG).show();

        } catch (DatosIncompletosException e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, "Hubo un problema al guardar los datos del atleta", Toast.LENGTH_LONG).show();
        }
    }

    private void registrarAtleta(String datosAtleta) {
        File file = new File(getFilesDir(), "/campeones.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(datosAtleta);
            writer.newLine();
        } catch (IOException e) {
            Toast.makeText(this, "No se han podido guardar los datos", Toast.LENGTH_LONG).show();
        }
        System.out.println(getFilesDir() + "/campeones.txt");
        System.out.println(datosAtleta);
    }

        public void funcionSalir (View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }


}