package com.example.calculadoraclase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CrearUsuario extends AppCompatActivity {
    EditText edtNombreUsuario, edtContraseña;
    Button btnAñadirUsuario, btnVolverInicio;

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
        LoginUsuario u = new LoginUsuario();

        if (edtNombreUsuario != null || edtContraseña != null) {
            u.setNombreUsuario(edtNombreUsuario.getText().toString());
            u.setContraseñaUsuario(edtContraseña.getText().toString());
            Login.listaUsuariosLogin.add(u);
            Toast.makeText(this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Por favor introducir Usuario y Contraseña", Toast.LENGTH_SHORT).show();
            edtNombreUsuario.setText("");
            edtContraseña.setText("");
        }
    }

    public void volverInicio(View v) {
        Intent intent = new Intent(this, Inicio.class);
        startActivity(intent);
    }
}