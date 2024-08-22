package com.example.proyectopoojuegosolimpicos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Modelo.CredencialesInvalidasException;

public class LoginActivity extends AppCompatActivity {
    private EditText editUser;
    private EditText editPass;
    private Button botonSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editUser = findViewById(R.id.editTextUsuario);
        editPass = findViewById(R.id.editTextContrasena);
        botonSesion = findViewById(R.id.botonSesion);


    }

    public void iniciarSesion2(View view) {
        String user = editUser.getText().toString();
        String contra = editPass.getText().toString();

        try (BufferedReader bfr = new BufferedReader(
                new InputStreamReader(view.getContext().getAssets().open("usuarios.txt")))) {
            String linea;
            boolean credencialesValidas = false;

            while ((linea = bfr.readLine()) != null) {
                String[] datos = linea.split(",");
                String usuario = datos[0];
                String contrasena = datos[1];

                if (usuario.equals(user) && contrasena.equals(contra)) {
                    credencialesValidas = true;
                    break;
                }
            }

            if (credencialesValidas) {
                                Intent intent = new Intent(this, CuentaAccedida.class);
                startActivity(intent);
            } else {
                throw new CredencialesInvalidasException("El usuario o la contraseña son incorrectos.");
            }
        } catch (CredencialesInvalidasException e1) {
            Toast.makeText(view.getContext(), e1.getMessage(), Toast.LENGTH_LONG).show();
        } catch (IOException e2) {
           e2.getMessage();
        }
    }
}