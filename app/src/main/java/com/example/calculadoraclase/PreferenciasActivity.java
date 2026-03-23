package com.example.calculadoraclase;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PreferenciasActivity extends AppCompatActivity {

    RadioGroup rgNotificaciones, rgTema, rgIdioma, rgPrivacidad, rgCorreos;
    RadioGroup rgLetra, rgSonidos, rgAutoguardado, rgHora, rgInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        // Enlazamos los 10 RadioGroups
        rgNotificaciones = findViewById(R.id.rgNotificaciones);
        rgTema = findViewById(R.id.rgTema);
        rgIdioma = findViewById(R.id.rgIdioma);
        rgPrivacidad = findViewById(R.id.rgPrivacidad);
        rgCorreos = findViewById(R.id.rgCorreos);
        rgLetra = findViewById(R.id.rgLetra);
        rgSonidos = findViewById(R.id.rgSonidos);
        rgAutoguardado = findViewById(R.id.rgAutoguardado);
        rgHora = findViewById(R.id.rgHora);
        rgInicio = findViewById(R.id.rgInicio);
    }

    public void guardarPreferencias(View v) {
        Preferencias misPreferencias = new Preferencias();

        // Creamos un método auxiliar abajo para no repetir código 10 veces
        misPreferencias.setNotificaciones(obtenerTextoDeRadioGroup(rgNotificaciones));
        misPreferencias.setTema(obtenerTextoDeRadioGroup(rgTema));
        misPreferencias.setIdioma(obtenerTextoDeRadioGroup(rgIdioma));
        misPreferencias.setPrivacidad(obtenerTextoDeRadioGroup(rgPrivacidad));
        misPreferencias.setFrecuenciaCorreos(obtenerTextoDeRadioGroup(rgCorreos));
        misPreferencias.setTamañoLetra(obtenerTextoDeRadioGroup(rgLetra));
        misPreferencias.setSonidos(obtenerTextoDeRadioGroup(rgSonidos));
        misPreferencias.setAutoguardado(obtenerTextoDeRadioGroup(rgAutoguardado));
        misPreferencias.setFormatoHora(obtenerTextoDeRadioGroup(rgHora));
        misPreferencias.setPantallaInicio(obtenerTextoDeRadioGroup(rgInicio));

        // Metemos los datos en el nuevo buzón de la Agenda
        Agenda.preferenciasTemporales = misPreferencias;

        Toast.makeText(this, "Preferencias listas. Termina en la Agenda.", Toast.LENGTH_SHORT).show();
        finish(); // Volvemos a la agenda
    }

    // Método que busca qué botón se seleccionó en el grupo y saca su texto
    private String obtenerTextoDeRadioGroup(RadioGroup rg) {
        int selectedId = rg.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton rb = findViewById(selectedId);
            return rb.getText().toString();
        }
        return "No especificado"; // Por si el usuario no seleccionó ninguna opción
    }
}