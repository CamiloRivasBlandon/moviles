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

public class Agenda extends AppCompatActivity {
    public static Gustos gustosTemporales = null;
    public static Preferencias preferenciasTemporales = null;

    private String cedulaOriginal = "";

    EditText edtCedula, edtNombre, edtApellido, edtCorreo, edtTelefono, edtDireccion,
            edtCiudad, edtDepartamento, edtCodigoPostal, edtOcupacion, edtFechaNacimiento;
    RadioGroup rgGenero;
    Button bnueva, btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        bnueva = findViewById(R.id.bnueva);
        btnBuscar = findViewById(R.id.btnBuscar);
        edtCedula = findViewById(R.id.editTextCedula);
        edtNombre = findViewById(R.id.editTextNombre);
        edtApellido = findViewById(R.id.editTextApellido);
        edtCorreo = findViewById(R.id.editTextCorreo);
        edtTelefono = findViewById(R.id.editTextTelefono);
        edtDireccion = findViewById(R.id.editTextDireccion);
        edtCiudad = findViewById(R.id.editTextCiudad);
        edtDepartamento = findViewById(R.id.editTextDepartamento);
        edtCodigoPostal = findViewById(R.id.editTextCodigoPostal);
        edtOcupacion = findViewById(R.id.editTextOcupacion);
        edtFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        rgGenero = findViewById(R.id.radioGroupGenero);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("cedula_editar")) {
            cedulaOriginal = intent.getStringExtra("cedula_editar");

            for (Usuario u : Buscar.listaUsuarios) {
                if (u.getCedula().equals(cedulaOriginal)) {
                    edtCedula.setText(u.getCedula());
                    edtCedula.setEnabled(false);

                    edtNombre.setText(u.getNombre());
                    edtApellido.setText(u.getApellido());
                    edtCorreo.setText(u.getCorreo());
                    edtTelefono.setText(u.getTelefono());
                    edtDireccion.setText(u.getDireccion());
                    edtCiudad.setText(u.getCiudad());
                    edtDepartamento.setText(u.getDepartamento());
                    edtCodigoPostal.setText(u.getCodigoPostal());
                    edtOcupacion.setText(u.getOcupacion());
                    edtFechaNacimiento.setText(u.getFechaNacimiento());

                    gustosTemporales = u.getMisGustos();
                    preferenciasTemporales = u.getMisPreferencias();

                    Toast.makeText(this, "Modo Edición Activado", Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }

    public void guardar(View v) {
        if (gustosTemporales == null) {
            Toast.makeText(this, "Por favor, ve a la sección de Gustos primero", Toast.LENGTH_SHORT).show();
            return;
        }
        if (preferenciasTemporales == null) {
            Toast.makeText(this, "Por favor, ve a la sección de Preferencias primero", Toast.LENGTH_SHORT).show();
            return;
        }

        String cedulaActual = edtCedula.getText().toString().trim();
        if (cedulaActual.isEmpty()) {
            Toast.makeText(this, "La cédula es obligatoria", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!cedulaOriginal.isEmpty()) {
            for (int i = 0; i < Buscar.listaUsuarios.size(); i++) {
                if (Buscar.listaUsuarios.get(i).getCedula().equals(cedulaOriginal)) {
                    Buscar.listaUsuarios.remove(i);
                    break;
                }
            }
        }
        Usuario u = new Usuario();
        u.setCedula(cedulaActual);
        u.setNombre(edtNombre.getText().toString().trim());
        u.setApellido(edtApellido.getText().toString().trim());
        u.setCorreo(edtCorreo.getText().toString().trim());
        u.setTelefono(edtTelefono.getText().toString().trim());
        u.setDireccion(edtDireccion.getText().toString().trim());
        u.setCiudad(edtCiudad.getText().toString().trim());
        u.setDepartamento(edtDepartamento.getText().toString().trim());
        u.setCodigoPostal(edtCodigoPostal.getText().toString().trim());
        u.setOcupacion(edtOcupacion.getText().toString().trim());
        u.setFechaNacimiento(edtFechaNacimiento.getText().toString().trim());

        int selectedId = rgGenero.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton rbSeleccionado = findViewById(selectedId);
            u.setGenero(rbSeleccionado.getText().toString());
        } else {
            u.setGenero("No especificado");
        }
        u.setMisGustos(gustosTemporales);
        u.setMisPreferencias(preferenciasTemporales);
        Buscar.listaUsuarios.add(u);

        Toast.makeText(this, "¡Registro guardado con éxito!", Toast.LENGTH_SHORT).show();

        gustosTemporales = null;
        preferenciasTemporales = null;
        cedulaOriginal = "";

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
    }
    public void irGustos(View v) {
        Intent intent = new Intent(this, GustosActivity.class);
        startActivity(intent);
    }
    public void irPreferencias(View v) {
        Intent intent = new Intent(this, PreferenciasActivity.class);
        startActivity(intent);
    }
    public void buscar(View v) {
        Intent intent = new Intent(this, Buscar.class);
        startActivity(intent);
    }
    public void bvolver(View v) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}