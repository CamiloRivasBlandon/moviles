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
    EditText edtCedula, edtNombre, edtApellido, edtCorreo, edtTelefono, edtDireccion,
            edtCiudad, edtDepartamento, edtCodigoPostal, edtOcupacion, edtFechaNacimiento,
            edtColorFavorito, edtComidaFavorita, edtPasatiempo, edtMusica;

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
        edtColorFavorito = findViewById(R.id.editTextColorFavorito);
        edtComidaFavorita = findViewById(R.id.editTextComidaFavorita);
        edtPasatiempo = findViewById(R.id.editTextPasatiempo);
        edtMusica = findViewById(R.id.editTextMusica);
    }
    public void guardar(View v) {
        Usuario u = new Usuario();

        if (edtCedula != null) u.setCedula(edtCedula.getText().toString());
        u.setNombre(edtNombre.getText().toString());
        u.setApellido(edtApellido.getText().toString());
        u.setCorreo(edtCorreo.getText().toString());
        u.setTelefono(edtTelefono.getText().toString());
        u.setDireccion(edtDireccion.getText().toString());
        u.setCiudad(edtCiudad.getText().toString());
        u.setDepartamento(edtDepartamento.getText().toString());
        u.setCodigoPostal(edtCodigoPostal.getText().toString());
        u.setOcupacion(edtOcupacion.getText().toString());
        u.setFechaNacimiento(edtFechaNacimiento.getText().toString());
        u.setColorFavorito(edtColorFavorito.getText().toString());
        u.setComidaFavorita(edtComidaFavorita.getText().toString());
        u.setPasatiempo(edtPasatiempo.getText().toString());
        u.setGeneroMusica(edtMusica.getText().toString());

        int selectedId = rgGenero.getCheckedRadioButtonId();
        if (selectedId != -1) {
            RadioButton rbSeleccionado = findViewById(selectedId);
            u.setGenero(rbSeleccionado.getText().toString());
        } else {
            u.setGenero("No especificado");
        }

        Buscar.listaUsuarios.add(u);
        Toast.makeText(this, "Usuario guardado exitosamente", Toast.LENGTH_SHORT).show();

        edtCedula.setText("");
        edtNombre.setText("");
        edtApellido.setText("");
        edtCorreo.setText("");
        edtTelefono.setText("");
        edtDireccion.setText("");
        edtCiudad.setText("");
        edtDepartamento.setText("");
        edtCodigoPostal.setText("");
        edtOcupacion.setText("");
        edtFechaNacimiento.setText("");
        rgGenero.clearCheck();
        edtColorFavorito.setText("");
        edtComidaFavorita.setText("");
        edtPasatiempo.setText("");
        edtMusica.setText("");
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