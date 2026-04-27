package com.example.calculadoraclase;

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

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class Login extends AppCompatActivity {
    public static ArrayList<LoginUsuario> listaUsuariosLogin = new ArrayList<>();
    EditText edtNombreUsuarioLogin, edtContraseñaLogin;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNombreUsuarioLogin = findViewById(R.id.edtNombreUsuarioLogin);
        edtContraseñaLogin = findViewById(R.id.edtContraseñaLogin);
        btnIngresar = findViewById(R.id.btnIngresar);

        cargarUsuariosRegistrados();
    }

    public void cargarUsuariosRegistrados() {
        try {
            InputStreamReader isr = new InputStreamReader(openFileInput("usuarios_login.txt"));
            BufferedReader br = new BufferedReader(isr);
            String linea = br.readLine();

            listaUsuariosLogin.clear();

            while (linea != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    LoginUsuario u = new LoginUsuario();
                    u.setNombreUsuario(partes[0]);
                    u.setContraseñaUsuario(partes[1]);
                    listaUsuariosLogin.add(u);
                }
                linea = br.readLine();
            }
            br.close();
            isr.close();
        } catch (Exception e) {
            //
        }
    }

    public void comprobarUsuario(View v) {
        String usuarioDigitado = edtNombreUsuarioLogin.getText().toString().trim();
        String ContraseñaDigitada = edtContraseñaLogin.getText().toString().trim();

        if (usuarioDigitado.isEmpty() || ContraseñaDigitada.isEmpty() ) {
            Toast.makeText(this, "Por favor ingrese usuario y contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean encontrado = false;

        for (LoginUsuario u : listaUsuariosLogin) {
            if (u.getNombreUsuario().equals(usuarioDigitado) && u.getContraseñaUsuario().equals(ContraseñaDigitada)) {
                Toast.makeText(this, "¡Bienvenido " + u.getNombreUsuario() + "!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, Menu.class);
                startActivity(intent);
                finish();

                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            limpiarCampos();
            Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    private void limpiarCampos() {
        edtNombreUsuarioLogin.setText("");
        edtContraseñaLogin.setText("");
    }
}