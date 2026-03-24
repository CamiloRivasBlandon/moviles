package com.example.calculadoraclase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Buscar extends AppCompatActivity {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    EditText edtBuscarCedula;
    Button btnEjecutarBusqueda;
    TextView tvDatosBasicos, tvTodosLosGustos, tvTodasLasPreferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtBuscarCedula = findViewById(R.id.edtBuscarCedula);
        btnEjecutarBusqueda = findViewById(R.id.btnEjecutarBusqueda);

        tvDatosBasicos = findViewById(R.id.tvDatosBasicos);
        tvTodosLosGustos = findViewById(R.id.tvTodosLosGustos);
        tvTodasLasPreferencias = findViewById(R.id.tvTodasLasPreferencias);

        btnEjecutarBusqueda.setOnClickListener(v -> buscarUsuario());
    }

    private void buscarUsuario() {
        String cedulaBuscada = edtBuscarCedula.getText().toString().trim();

        if (cedulaBuscada.isEmpty()) {
            Toast.makeText(this, "Por favor ingrese una cédula", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean encontrado = false;

        for (Usuario u : listaUsuarios) {
            if (u.getCedula().equals(cedulaBuscada)) {
                String datos = "Cédula: " + u.getCedula() + "\n" +
                        "Nombre: " + u.getNombre() + " " + u.getApellido() + "\n" +
                        "Correo: " + u.getCorreo() + "\n" +
                        "Teléfono: " + u.getTelefono() + "\n" +
                        "Dirección: " + u.getDireccion() + "\n" +
                        "Ubicación: " + u.getCiudad() + ", " + u.getDepartamento() + "\n" +
                        "C.P.: " + u.getCodigoPostal() + "\n" +
                        "Ocupación: " + u.getOcupacion() + "\n" +
                        "Nacimiento: " + u.getFechaNacimiento() + "\n" +
                        "Género: " + u.getGenero();
                tvDatosBasicos.setText(datos);
                if (u.getMisGustos() != null) {
                    String gustos = "Comida: " + u.getMisGustos().getComidaFavorita() + "\n" +
                            "Película: " + u.getMisGustos().getPeliculaFavorita() + "\n" +
                            "Música: " + u.getMisGustos().getGeneroMusical() + "\n" +
                            "Color: " + u.getMisGustos().getColorFavorito() + "\n" +
                            "Deporte: " + u.getMisGustos().getDeporteFavorito() + "\n" +
                            "Libro: " + u.getMisGustos().getLibroFavorito() + "\n" +
                            "Pasatiempo: " + u.getMisGustos().getPasatiempo() + "\n" +
                            "Bebida: " + u.getMisGustos().getBebidaFavorita() + "\n" +
                            "Animal: " + u.getMisGustos().getAnimalFavorito() + "\n" +
                            "Viaje: " + u.getMisGustos().getLugarDeViaje();
                    tvTodosLosGustos.setText(gustos);
                } else {
                    tvTodosLosGustos.setText("El usuario no registró gustos.");
                }
                if (u.getMisPreferencias() != null) {
                    String pref = "Notificaciones: " + u.getMisPreferencias().getNotificaciones() + "\n" +
                            "Tema: " + u.getMisPreferencias().getTema() + "\n" +
                            "Idioma: " + u.getMisPreferencias().getIdioma() + "\n" +
                            "Privacidad: " + u.getMisPreferencias().getPrivacidad() + "\n" +
                            "Correos: " + u.getMisPreferencias().getFrecuenciaCorreos() + "\n" +
                            "Letra: " + u.getMisPreferencias().getTamañoLetra() + "\n" +
                            "Sonidos: " + u.getMisPreferencias().getSonidos() + "\n" +
                            "Autoguardado: " + u.getMisPreferencias().getAutoguardado() + "\n" +
                            "Hora: " + u.getMisPreferencias().getFormatoHora() + "\n" +
                            "Cafe con: " + u.getMisPreferencias().getPantallaInicio();
                    tvTodasLasPreferencias.setText(pref);
                } else {
                    tvTodasLasPreferencias.setText("El usuario no registró preferencias.");
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            limpiarCampos();
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
    public void irAModificar(View v) {
        String cedulaBuscada = edtBuscarCedula.getText().toString().trim();

        if (cedulaBuscada.isEmpty()) {
            Toast.makeText(this, "Primero busque una cédula para modificar", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean existe = false;
        for (Usuario u : listaUsuarios) {
            if (u.getCedula().equals(cedulaBuscada)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            Intent intent = new Intent(this, Agenda.class);
            intent.putExtra("cedula_editar", cedulaBuscada);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Ese usuario no existe", Toast.LENGTH_SHORT).show();
        }
    }
    private void limpiarCampos() {
        tvDatosBasicos.setText("Los datos aparecerán aquí...");
        tvTodosLosGustos.setText("Los gustos aparecerán aquí...");
        tvTodasLasPreferencias.setText("Las preferencias aparecerán aquí...");
    }
}