package com.sanderpiva.appmatematico.Model.Eq1Grau;

import androidx.appcompat.app.AppCompatActivity;
import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioEquacaoPrimeiroGrau;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class EquacaoPrimeiroGrau extends AppCompatActivity {

    private android.widget.EditText a, operador, b;
    private android.widget.TextView resultado, resultado2, resultado3;
    private android.widget.Button btncalcular;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equacao_primeiro_grau);

        Button btnVideo = (Button) findViewById(R.id.btnVideoEquacaoPrimeiroGrau);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquacaoPrimeiroGrau.this, Vequacao1grau.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioEquacaoPrimeiroGrau);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquacaoPrimeiroGrau.this, MaterialApoioEq1grau.class);
                startActivity(intent);

            }
        });

        a = findViewById(R.id.editTextCoeficienteAngular);
        operador = findViewById(R.id.editTextOperadorEqPrimeiroGrau);
        b = findViewById(R.id.editTextCoeficienteB);
        resultado=findViewById(R.id.textViewResutado1EquacaoPrimeiroGrau);
        resultado2=findViewById(R.id.textViewResult2Eq1grau);
        resultado3=findViewById(R.id.textViewResult3Eq1grau);

        android.widget.Button btncalcular = findViewById(R.id.btnCalcularEquacaoPrimeiroGrau);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String resA = a.getText().toString();
                String resOperador = operador.getText().toString();
                String resB = b.getText().toString();

                if(resA.isEmpty() || resOperador.isEmpty()|| resB.isEmpty()) {
                    Snackbar.make(view, "Preencha todos os dados", Snackbar.LENGTH_LONG).show();
                }

                else if(resA.equals("0")||resB.equals("0")){
                    Snackbar.make(view, "Número positivo ( > 0)", Snackbar.LENGTH_LONG).show();
                }

                else{

                    if(resOperador.equals("+")) {
                        ProcessaEq1 eq1 = new ProcessaEq1(resA, resOperador, resB);
                        resultado.setText(
                                "Raiz equacao 1º grau:");
                        resultado2.setText("y = 0, logo -> "+" 0 = "+
                                eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" -> "+
                                eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" = 0"+" -> ");
                        resultado3.setText(eq1.getA()+"x"+" = "+eq1.getB()*-1+" -> "+
                                "x"+" = "+eq1.getB()*-1+" / "+eq1.getA()+" = "+eq1.calculaEq1());
                    }
                    else if(resOperador.equals("-")) {
                        ProcessaEq1 eq1 = new ProcessaEq1(resA, resOperador, resB);
                        resultado.setText("Raiz equacao 1º grau:" );
                        resultado2.setText("y = 0, logo -> "+" 0 = "+
                                +eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" -> "+
                                eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" = 0"+" -> ");
                        resultado3.setText(eq1.getA()+"x"+" = "+eq1.getB()*1+" -> "+
                                "x"+" = "+eq1.getB()+" / "+eq1.getA()+" = "+eq1.calculaEq1());
                    }

                    else if(resOperador.equals("/")){
                        ProcessaEq1 eq1 = new ProcessaEq1(resA, resOperador, resB);
                        resultado.setText("Raiz equacao 1º grau:");
                        resultado2.setText("y = 0, logo -> "+" 0 = "+
                                +eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" -> "+
                                eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" = 0"+" -> ");
                        resultado3.setText(
                                eq1.getA()+"x = "+eq1.getB()+"* 0 -> "+eq1.getA()+"x = "+"0"+" -> x = 0"+"/"+eq1.getA()
                                +" -> "+"x = 0");
                    }

                    else if(resOperador.equals("*")){
                        ProcessaEq1 eq1 = new ProcessaEq1(resA, resOperador, resB);
                        resultado.setText("Raiz equacao 1º grau:");
                        resultado2.setText("y = 0, logo -> "+" 0 = "+
                                +eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" -> "+
                                eq1.getA()+"x"+" "+eq1.getOp()+" "+eq1.getB()+" = 0"+" -> ");
                        resultado3.setText(eq1.getA()*eq1.getB()+"x = 0 "
                                +" -> "+" x = 0"+"/"+eq1.getA()*eq1.getB()+" -> "+"x = 0");
                    }

                    else{
                        Snackbar.make(view, "Sinal operador valido: + - * /", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}