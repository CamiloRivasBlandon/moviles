package com.example.calculadoraclase;

import android.os.Bundle;
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
    TextView tvCedula, tvNombre, tvApellido, tvCorreo, tvTelefono, tvDireccion, tvCiudad, tvDepartamento,
            tvCodigoPostal, tvOcupacion, tvFechaNacimiento, tvGenero, tvColorFavorito, tvComida, tvPasatiempo, tvMusica;

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

        tvCedula = findViewById(R.id.tvCedula);
        tvNombre = findViewById(R.id.tvNombre);
        tvApellido = findViewById(R.id.tvApellido);
        tvCorreo = findViewById(R.id.tvCorreo);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvDireccion = findViewById(R.id.tvDireccion);
        tvCiudad = findViewById(R.id.tvCiudad);
        tvDepartamento = findViewById(R.id.tvDepartamento);
        tvCodigoPostal = findViewById(R.id.tvCodigoPostal);
        tvOcupacion = findViewById(R.id.tvOcupacion);
        tvFechaNacimiento = findViewById(R.id.tvFechaNacimiento);
        tvGenero = findViewById(R.id.tvGenero);
        tvColorFavorito = findViewById(R.id.tvColorFavorito);
        tvComida = findViewById(R.id.tvComida);
        tvPasatiempo = findViewById(R.id.tvPasatiempo);
        tvMusica = findViewById(R.id.tvMusica);

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
                tvCedula.setText(u.getCedula());
                tvNombre.setText(u.getNombre());
                tvApellido.setText(u.getApellido());
                tvCorreo.setText(u.getCorreo());
                tvTelefono.setText(u.getTelefono());
                tvDireccion.setText(u.getDireccion());
                tvCiudad.setText(u.getCiudad());
                tvDepartamento.setText(u.getDepartamento());
                tvCodigoPostal.setText(u.getCodigoPostal());
                tvOcupacion.setText(u.getOcupacion());
                tvFechaNacimiento.setText(u.getFechaNacimiento());
                tvGenero.setText(u.getGenero());
                tvColorFavorito.setText(u.getColorFavorito());
                tvComida.setText(u.getComidaFavorita());
                tvPasatiempo.setText(u.getPasatiempo());
                tvMusica.setText(u.getGeneroMusica());

                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            limpiarCampos();
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }
    private void limpiarCampos() {
        tvCedula.setText("");
        tvNombre.setText("");
        tvApellido.setText("");
        tvCorreo.setText("");
        tvTelefono.setText("");
        tvDireccion.setText("");
        tvCiudad.setText("");
        tvDepartamento.setText("");
        tvCodigoPostal.setText("");
        tvOcupacion.setText("");
        tvFechaNacimiento.setText("");
        tvGenero.setText("");
        tvColorFavorito.setText("");
        tvComida.setText("");
        tvPasatiempo.setText("");
        tvMusica.setText("");
    }
}