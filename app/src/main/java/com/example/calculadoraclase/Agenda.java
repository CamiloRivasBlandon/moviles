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
    public static Preferencias preferenciasTemporales = null; // NUEVO BUZÓN

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
    }

    public void irGustos(View v) {
        Intent intent = new Intent(this, GustosActivity.class); // Asegúrate que el nombre coincida
        startActivity(intent);
        // ¡OJO! NO ponemos finish() aquí. Queremos que la Agenda se quede esperando abajo.
    }
    public void irPreferencias(View v) {
        Intent intent = new Intent(this, PreferenciasActivity.class);
        startActivity(intent);
    }
    public void guardarTodoElUsuario(View v) {
        // Validamos AMBOS buzones
        if (gustosTemporales == null) {
            Toast.makeText(this, "Por favor, ve a la sección de Gustos primero", Toast.LENGTH_SHORT).show();
            return;
        }
        if (preferenciasTemporales == null) {
            Toast.makeText(this, "Por favor, ve a la sección de Preferencias primero", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "¡Todos los datos guardados con éxito!", Toast.LENGTH_SHORT).show();

        // Limpiamos AMBOS buzones
        gustosTemporales = null;
        preferenciasTemporales = null;

        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
        finish();
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