package com.example.calculadoraclase;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity {
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bbc,bpunto,bvolver;
    private EditText caja;
    String cadena = "";
    private double num1 = 0;
    private double num2 = 0;
    private String operacion = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bbc = findViewById(R.id.bbc);
        bpunto = findViewById(R.id.bpunto);
        caja = findViewById(R.id.caja);
        bvolver = findViewById(R.id.bvolver);
    }

    public void t0(View v){
        cadena = cadena + "0";
        visualizar();
    }

    public void t1(View v){
        cadena = cadena + "1";
        visualizar();
    }

    public void t2(View v){
        cadena = cadena + "2";
        visualizar();
    }

    public void t3(View v){
        cadena = cadena + "3";
        visualizar();
    }

    public void t4(View v){
        cadena = cadena + "4";
        visualizar();
    }

    public void t5(View v){
        cadena = cadena + "5";
        visualizar();
    }

    public void t6(View v){
        cadena = cadena + "6";
        visualizar();
    }

    public void t7(View v){
        cadena = cadena + "7";
        visualizar();
    }

    public void t8(View v){
        cadena = cadena + "8";
        visualizar();
    }

    public void t9(View v){
        cadena = cadena + "9";
        visualizar();
    }

    public void tpunto(View v){

        if(cadena.equals("")){
            cadena = "0.";
        }
        else if(!cadena.contains(".")){
            cadena = cadena + ".";
        }

        visualizar();
    }

    public void tsuma(View v){
        num1 = Double.parseDouble(cadena);
        operacion = "+";
        cadena = "";
    }

    public void tresta(View v){
        num1 = Double.parseDouble(cadena);
        operacion = "-";
        cadena = "";
    }

    public void tmultiplicar(View v){
        num1 = Double.parseDouble(cadena);
        operacion = "*";
        cadena = "";
    }

    public void tdivision(View v){
        num1 = Double.parseDouble(cadena);
        operacion = "/";
        cadena = "";
    }

    public void tigual(View v){
        if (cadena == null || cadena.isEmpty()) {
            return;
        }
        double resultado = 0;
        try {
            num2 = Double.parseDouble(cadena);
        } catch (NumberFormatException e) {
            cadena = "Error";
            visualizar();
            return;
        }
        switch (operacion){
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    cadena = "Error";
                    visualizar();
                    if (cadena == null || cadena.isEmpty()) {
                        return;
                    }
                    return;
                }
                resultado = num1 / num2;
                break;
        }
        cadena = String.valueOf(resultado);
        visualizar();
    }

    public void tbc(View v){
        cadena = "";
        caja.setText("");
    }

    public void visualizar(){
        caja.setText(cadena);
    }
    public void bvolver(View v) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}
