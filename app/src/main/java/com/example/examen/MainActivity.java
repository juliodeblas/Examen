package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText operando1, operando2;
    Button bSuma, bResta, bMultiplicacion, bDivision;
    CheckBox cPermitir;
    Button bPermitir;
    int tipoOperacion = 0;
    Double dOperando1, dOperando2, resultado;
    public static String TAGresultado;
    public static String TAGtipoOperacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    private void acciones() {
        bSuma.setOnClickListener(this);
        bResta.setOnClickListener(this);
        bMultiplicacion.setOnClickListener(this);
        bDivision.setOnClickListener(this);
        bPermitir.setOnClickListener(this);
    }

    private void instancias() {
        bSuma = findViewById(R.id.bSuma);
        bResta = findViewById(R.id.bResta);
        bMultiplicacion = findViewById(R.id.bMultiplicacion);
        bDivision = findViewById(R.id.bDivision);
        bPermitir = findViewById(R.id.bPermitir);
        cPermitir = findViewById(R.id.cPermitir);
        operando1 = findViewById(R.id.operando1);
        operando2 = findViewById(R.id.operando2);
    }

    @Override
    public void onClick(View v) {
        dOperando1 = Double.valueOf(operando1.getText().toString());
        dOperando2 = Double.valueOf(operando2.getText().toString());
        switch (v.getId()) {
            case R.id.bSuma:
                tipoOperacion = 1;
                break;
            case R.id.bResta:
                tipoOperacion = 2;
                break;
            case R.id.bMultiplicacion:
                tipoOperacion = 3;
                break;
            case R.id.bDivision:
                tipoOperacion = 4;
                break;
            case R.id.bPermitir:

                if (!operando1.getText().toString().isEmpty() &&
                        !operando2.getText().toString().isEmpty() &&
                        tipoOperacion != 0 &&
                        cPermitir.isChecked()) {

                    switch (tipoOperacion) {
                        case 1:
                            resultado = dOperando1 + dOperando2;
                            break;
                        case 2:
                            resultado = dOperando1 - dOperando2;
                            break;
                        case 3:
                            resultado = dOperando1 * dOperando2;
                            break;
                        case 4:
                            resultado = dOperando1 / dOperando2;
                            break;
                    }
                    Intent iPasar = new Intent(getApplicationContext(), SecondActivity.class);
                    iPasar.putExtra(TAGresultado, resultado);
                    iPasar.putExtra(TAGtipoOperacion, tipoOperacion);
                    startActivity(iPasar);


                }else{
                    Toast.makeText(getApplicationContext(), "Debe introducir los datos correctamente", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
