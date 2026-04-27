package com.example.calculadoraclase;

import android.content.Context;
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

// Importaciones necesarias para manejar archivos
import java.io.OutputStreamWriter;

public class CrearUsuario extends AppCompatActivity {
    EditText edtNombreUsuario, edtContraseña;
    Button btnAñadirUsuario, btnVolverInicio;
    private final String NOMBRE_ARCHIVO = "usuarios_login.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crear_usuario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtNombreUsuario = findViewById(R.id.edtNombreUsuario);
        edtContraseña = findViewById(R.id.edtContraseña);
        btnAñadirUsuario = findViewById(R.id.btnAñadirUsuario);
        btnVolverInicio = findViewById(R.id.btnVolverInicio);
    }

    public void guardarNuevoUsuario(View v) {
        String nombreIngresado = edtNombreUsuario.getText().toString().trim();
        String contraseñaIngresada = edtContraseña.getText().toString().trim();

        if (nombreIngresado.isEmpty() || contraseñaIngresada.isEmpty()) {
            Toast.makeText(this, "Por favor introducir Usuario y Contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        for (LoginUsuario usuarioExistente : Login.listaUsuariosLogin) {
            if (usuarioExistente.getNombreUsuario().equals(nombreIngresado)) {
                Toast.makeText(this, "Error: Ese nombre de usuario ya está en uso", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        LoginUsuario u = new LoginUsuario();
        u.setNombreUsuario(nombreIngresado);
        u.setContraseñaUsuario(contraseñaIngresada);
        Login.listaUsuariosLogin.add(u);

        try {
            OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(NOMBRE_ARCHIVO, Context.MODE_APPEND));

            osw.write(nombreIngresado + "," + contraseñaIngresada + "\n");
            osw.flush();
            osw.close();

            Toast.makeText(this, "Usuario registrado y guardado exitosamente", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Error al guardar el archivo", Toast.LENGTH_LONG).show();
        }
        edtNombreUsuario.setText("");
        edtContraseña.setText("");
    }

    public void volverInicio(View v) {
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }
}