package com.example.proyectopoojuegosolimpicos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Modelo.Evento;

public class CalendarioActivity extends AppCompatActivity {
    private EditText editTextDate;
    private TableLayout eventosLayout;
    private Button bvolver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextDate = findViewById(R.id.editTextDate);
        eventosLayout = findViewById(R.id.eventosLayout);
        bvolver = findViewById(R.id.bvolver);



        //Configuracion DatePicker

        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month=calendar.get(Calendar.MONTH);
                int day=calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpicker = new DatePickerDialog(CalendarioActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int anioSel, int mesSel, int diaSel) {
                        String fechaSeleccionada = "0" + diaSel + "/0" + (mesSel + 1) + "/" + anioSel;
                        editTextDate.setText(fechaSeleccionada);
                        mostrarEventosPorFecha(fechaSeleccionada);

                    }
                }, year, month, day);
                dpicker.show();
                    }
        });



    }
    public void volver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



    private void mostrarEventosPorFecha(String fecha) {
        eventosLayout.removeAllViews();
        List<Evento> eventos = generarEventos();

        // Configuración para bordes
        TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(5, 5, 5, 5);

        for (Evento evento : eventos) {
            if (evento.getFecha().trim().equals(fecha.trim())) {
                TableRow eventoRow = new TableRow(this);
                eventoRow.setLayoutParams(layoutParams);

                // Configuración del TextView para el deporte
                TextView deporteTextView = new TextView(this);
                deporteTextView.setText(evento.getDeporte());
                deporteTextView.setLayoutParams(layoutParams);
                deporteTextView.setPadding(16, 16, 16, 16); // Padding
                deporteTextView.setGravity(Gravity.CENTER); // Centrar texto
                deporteTextView.setTextSize(16); // Tamaño del texto

                // Configuración del TextView para la hora
                TextView horaTextView = new TextView(this);
                horaTextView.setText(evento.getHora());
                horaTextView.setLayoutParams(layoutParams);
                horaTextView.setPadding(16, 16, 16, 16); // Padding
                horaTextView.setGravity(Gravity.CENTER); // Centrar texto
                horaTextView.setTextSize(16); // Tamaño del texto

                // Agregar los TextView a la fila
                eventoRow.addView(deporteTextView);
                eventoRow.addView(horaTextView);

                // Agregar la fila al TableLayout
                eventosLayout.addView(eventoRow);
            }
        }
    }




    private List<Evento> generarEventos() {
        List<Evento> eventos = new ArrayList<>();


        eventos.add(new Evento("Atletismo", "01/08/2024", "10:00"));
        eventos.add(new Evento("Natación", "01/08/2024", "12:00"));
        eventos.add(new Evento("Gimnasia", "01/08/2024", "14:00"));
        eventos.add(new Evento("Ciclismo", "01/08/2024", "16:00"));
        eventos.add(new Evento("Esgrima", "01/08/2024", "18:00"));

        eventos.add(new Evento("Fútbol", "02/08/2024", "10:00"));
        eventos.add(new Evento("Baloncesto", "02/08/2024", "12:00"));
        eventos.add(new Evento("Voleibol", "02/08/2024", "14:00"));
        eventos.add(new Evento("Tenis", "02/08/2024", "16:00"));
        eventos.add(new Evento("Golf", "02/08/2024", "18:00"));

        eventos.add(new Evento("Atletismo", "03/08/2024", "10:00"));
        eventos.add(new Evento("Natación", "03/08/2024", "12:00"));
        eventos.add(new Evento("Gimnasia", "03/08/2024", "14:00"));
        eventos.add(new Evento("Ciclismo", "03/08/2024", "16:00"));
        eventos.add(new Evento("Esgrima", "03/08/2024", "18:00"));

        eventos.add(new Evento("Fútbol", "04/08/2024", "10:00"));
        eventos.add(new Evento("Baloncesto", "04/08/2024", "12:00"));
        eventos.add(new Evento("Voleibol", "04/08/2024", "14:00"));
        eventos.add(new Evento("Tenis", "04/08/2024", "16:00"));
        eventos.add(new Evento("Golf", "04/08/2024", "18:00"));

        eventos.add(new Evento("Atletismo", "05/08/2024", "10:00"));
        eventos.add(new Evento("Natación", "05/08/2024", "12:00"));
        eventos.add(new Evento("Gimnasia", "05/08/2024", "14:00"));
        eventos.add(new Evento("Ciclismo", "05/08/2024", "16:00"));
        eventos.add(new Evento("Esgrima", "05/08/2024", "18:00"));

        eventos.add(new Evento("Fútbol", "06/08/2024", "10:00"));
        eventos.add(new Evento("Baloncesto", "06/08/2024", "12:00"));
        eventos.add(new Evento("Voleibol", "06/08/2024", "14:00"));
        eventos.add(new Evento("Tenis", "06/08/2024", "16:00"));
        eventos.add(new Evento("Golf", "06/08/2024", "18:00"));

        return eventos;
    }
}