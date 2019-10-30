package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView mostrarDatos;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        instancias();
        recuperarDatos();
    }

    private void instancias() {
        mostrarDatos = findViewById(R.id.mostrarDatos);
    }

    private void recuperarDatos() {

        String palabraRecuperada = String.valueOf(getIntent().getExtras().get(MainActivity.TAGresultado));
        String tipoOperacionRecuperada = String.valueOf(getIntent().getExtras().get(MainActivity.TAGtipoOperacion));

        if (getIntent().getExtras() != null) {

            if (Integer.valueOf(tipoOperacionRecuperada) == 1) {
                String saludo = String.format("El resultado de la suma es: %s", palabraRecuperada);
                mostrarDatos.setText(saludo);
            } else if (Integer.valueOf(tipoOperacionRecuperada) == 2) {
                String saludo = String.format("El resultado de la resta es: %s", palabraRecuperada);
                mostrarDatos.setText(saludo);
            } else if (Integer.valueOf(tipoOperacionRecuperada) == 3) {
                String saludo = String.format("El resultado de la multiplicacion es: %s", palabraRecuperada);
                mostrarDatos.setText(saludo);
            } else if (Integer.valueOf(tipoOperacionRecuperada) == 4) {
                String saludo = String.format("El resultado de la division es: %s", palabraRecuperada);
                mostrarDatos.setText(saludo);
            }

        }

    }
}
