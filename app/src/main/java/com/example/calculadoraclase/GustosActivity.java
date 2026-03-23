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

    // Declaramos las 10 variables
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

        // Enlazamos las 10 variables con el XML usando sus IDs
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

    // Función del botón (Recuerda: siempre public y con View v)
    public void guardarGustos(View v) {
        // 1. Validamos que no esté todo vacío (opcional)
        String comida = edtComida.getText().toString().trim();
        if (comida.isEmpty()) {
            Toast.makeText(this, "Por favor llena al menos tu comida favorita", Toast.LENGTH_SHORT).show();
            return;
        }

        // 2. Creamos la "caja" y la llenamos con lo que escribió el usuario
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
        // ... (agrega los set para los otros 7 campos) ...

        // 3. ¡LA MAGIA! Dejamos esta caja en el buzón de la Agenda
        Agenda.gustosTemporales = misGustos;

        // 4. Le avisamos al usuario
        Toast.makeText(this, "Gustos listos. Termina de guardar en la Agenda.", Toast.LENGTH_SHORT).show();

        // 5. Destruimos esta pantalla.
        // Como no usamos Intent, Android revelará la Agenda que estaba justo debajo, ¡con sus textos intactos!
        finish();
    }
}