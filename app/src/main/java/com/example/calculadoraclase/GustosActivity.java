package com.example.calculadoraclase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class GustosActivity extends AppCompatActivity {
    EditText edtComida, edtPelicula, edtGenero, edtColor, edtDeporte,
            edtLibro, edtPasatiempo, edtBebida, edtAnimal, edtLugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gustos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtComida = findViewById(R.id.edtComida);
        edtPelicula = findViewById(R.id.edtPelicula);
        edtGenero = findViewById(R.id.edtGenero);
        edtColor = findViewById(R.id.edtColor);
        edtDeporte = findViewById(R.id.edtDeporte);
        edtLibro = findViewById(R.id.edtLibro);
        edtPasatiempo = findViewById(R.id.edtPasatiempo);
        edtBebida = findViewById(R.id.edtBebida);
        edtAnimal = findViewById(R.id.edtAnimal);
        edtLugar = findViewById(R.id.edtLugar);
    }
    public void guardarGustos(View v) {
        String comida = edtComida.getText().toString().trim();
        if (comida.isEmpty()) {
            Toast.makeText(this, "Por favor llena al menos tu comida favorita", Toast.LENGTH_SHORT).show();
            return;
        }
        Gustos misGustos = new Gustos();
        misGustos.setComidaFavorita(comida);
        misGustos.setPeliculaFavorita(edtPelicula.getText().toString().trim());
        misGustos.setGeneroMusical(edtGenero.getText().toString().trim());
        misGustos.setColorFavorito(edtColor.getText().toString().trim());
        misGustos.setDeporteFavorito(edtDeporte.getText().toString().trim());
        misGustos.setLibroFavorito(edtLibro.getText().toString().trim());
        misGustos.setPasatiempo(edtPasatiempo.getText().toString().trim());
        misGustos.setBebidaFavorita(edtBebida.getText().toString().trim());
        misGustos.setAnimalFavorito(edtAnimal.getText().toString().trim());
        misGustos.setLibroFavorito(edtLugar.getText().toString().trim());

        Agenda.gustosTemporales = misGustos;
        Toast.makeText(this, "Gustos listos. Termina de guardar en la Agenda.", Toast.LENGTH_SHORT).show();
        finish();
    }
}