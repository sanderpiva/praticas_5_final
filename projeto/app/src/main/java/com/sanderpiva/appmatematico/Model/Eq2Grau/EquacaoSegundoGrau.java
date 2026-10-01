package com.sanderpiva.appmatematico.Model.Eq2Grau;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioEquacaoSegundoGrau;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class EquacaoSegundoGrau extends AppCompatActivity {
    private android.widget.EditText a, operador1, operador2, b, c;
    private android.widget.TextView resultado, resultado2, resultado3, resultado4, resultado5, resultado6, resultado7;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equacao_segundo_grau);

        Button btnVideo = (Button) findViewById(R.id.btnVideoEquacaoSegundoGrau);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquacaoSegundoGrau.this, Vequacao2grau.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioEquacaoSegundoGrau);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EquacaoSegundoGrau.this, MaterialApoioEq2grau.class);
                startActivity(intent);
            }
        });

        a = findViewById(R.id.editTextCoeficienteAngular);
        operador1 = findViewById(R.id.editTextEqSegundoGrauOp1);
        b = findViewById(R.id.editTextCoeficienteB);
        operador2 = findViewById(R.id.editTextEqSegundoGrauOp2);
        resultado=findViewById(R.id.textViewResutado1EquacaoSegundoGrau);
        resultado2=findViewById(R.id.textViewResult2Eq2Grau);
        resultado3=findViewById(R.id.textViewResult3Eq2Grau);
        resultado4=findViewById(R.id.textViewResult4Eq2Grau);
        resultado5=findViewById(R.id.textViewResult5Eq2Grau);
        resultado6=findViewById(R.id.textViewResult6Eq2Grau);
        resultado7=findViewById(R.id.textViewResult7Eq2Grau);
        c= findViewById(R.id.editTextEquacao2GrauCoeficienteC);

        android.widget.Button btncalcular = findViewById(R.id.btnCalcularEquacaoSegundoGrau);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String resA = a.getText().toString();
                String resOperador1 = operador1.getText().toString();
                String resB = b.getText().toString();
                String resOperador2 = operador2.getText().toString();
                String resC = c.getText().toString();

                if(resA.equals("")||resOperador1.equals("")||resB.equals("")
                ||resOperador2.equals("")||resC.equals("")){
                    Snackbar.make(view, "Preencha todos os dados", Snackbar.LENGTH_LONG).show();

                }
                else if(resA.equals("0")||resB.equals("0")||resC.equals("0")){
                    Snackbar.make(view, "Número positivo ( > 0)", Snackbar.LENGTH_LONG).show();
                }
                else{
                    ProcessaEq2 eq2 = new ProcessaEq2(resA, resOperador1, resB, resOperador2, resC);
                    double delta = pow(eq2.getResB(),2)-4*eq2.getResA()*eq2.getResC();
                    double raizDelta = Math.sqrt(delta);
                    String comp1;
                    if(eq2.getComponente()>0)
                        comp1="+"+eq2.getComponente();
                    else{
                        comp1=""+eq2.getComponente();
                    }

                    if((resOperador1.equals("+") || resOperador1.equals("-"))&&
                            (resOperador2.equals("+") || resOperador2.equals("-"))){

                        if(delta>=0){

                            double nx1 = eq2.getResB() * -1 + raizDelta;
                            double dx1 = 2*eq2.getResA();
                            double x1 = nx1/dx1;
                            double nx2 = eq2.getResB() * -1 - raizDelta;
                            double dx2 = 2*eq2.getResA();
                            double x2 = nx2/dx2;

                            if (delta % raizDelta == 0 || (delta==0 && raizDelta==0)) {

                                double resultadoOriginalB = eq2.getResB();

                                double resultadoSemSinalB = Math.abs(resultadoOriginalB);

                                double resultadoOriginalC = eq2.getResC();

                                double resultadoSemSinalC = Math.abs(resultadoOriginalC);

                                resultado.setText("a = +"+eq2.getResA()+" b= "+resOperador1+resultadoSemSinalB+
                                         " c = "+resOperador2+resultadoSemSinalC+" -> ");
                                resultado2.setText(
                                        "Raiz da equacao 2º, y = 0, " +" 0 = "+
                                        eq2.getResA()+"x² "+resOperador1+resultadoSemSinalB+
                                        "x "+resOperador2+resultadoSemSinalC+" -> ");
                                resultado3.setText(eq2.getResA()+"x² "+resOperador1+resultadoSemSinalB+
                                        "x "+resOperador2+resultadoSemSinalC+" = 0"+" -> Δ = "+"b² -4 *a *c = ");
                                resultado4.setText("("+resOperador1+resultadoSemSinalB+")"+" ^2 "+" - "+"4"+" * "+
                                        + eq2.getResA() + " * " + eq2.getResC() + " = "+
                                        Math.pow(eq2.getResB(), 2) + " "+comp1+" = "
                                        + delta);
                                resultado5.setText(" -> "
                                                +"x1 ="+"(-b + √Δ)/2*a = ");


                                resultado6.setText(
                                        +eq2.getResB() * -1+" + "+raizDelta+" / "+" 2* "+eq2.getResA()+" = "+nx1+" / "+dx1+" = "+x1+" -> "
                                        );
                                resultado7.setText("x2 ="+"(-b - √Δ)/2*a = "+eq2.getResB() * -1+" - "+
                                        raizDelta+" / "+" 2* "+eq2.getResA()+" = "+nx2+" / "+dx2+" = "+x2);

                            }
                            else {

                                double resultadoOriginalB = eq2.getResB();
                                double resultadoSemSinalB = Math.abs(resultadoOriginalB);

                                double resultadoOriginalC = eq2.getResC();
                                double resultadoSemSinalC = Math.abs(resultadoOriginalC);

                                resultado.setText("a = +" + eq2.getResA() +
                                        " b = " + resOperador1 + resultadoSemSinalB +
                                        " c = " + resOperador2 + resultadoSemSinalC + " -> ");
                                resultado2.setText("Raiz da equacao 2º, y = 0, " + " 0 = " +
                                        eq2.getResA() + "x² " + resOperador1 + resultadoSemSinalB +
                                        "x " + resOperador2 + resultadoSemSinalC + " -> "
                                );
                                resultado3.setText(eq2.getResA() + "x² " + resOperador1 + resultadoSemSinalB +
                                        "x " + resOperador2 + resultadoSemSinalC + " = 0"+" -> Δ = " + "b² - 4 * a * c = "
                                );
                                resultado4.setText("("+resOperador1+resultadoSemSinalB+")"+" ^2 "+
                                " - " + "4" + " * "
                                        + eq2.getResA() + " * " + eq2.getResC() + " = "+
                                        Math.pow(eq2.getResB(), 2) + " "+comp1+" = "
                                        + delta + " -> ");
                                resultado5.setText(
                                        "x1 = (-b + √Δ) / (2 * a) = (" + eq2.getResB() * -1 + " + " +
                                        "\u221A" + delta + ") / (2 * " + eq2.getResA() + ")"+" = "
                                        );
                                resultado6.setText("("+eq2.getResB() * -1 + " + " +
                                        "\u221A" + delta + ") / (" +2*eq2.getResA() + ")"+" -> x2 = (-b - √Δ) / (2 * a) = "
                                        );
                                resultado7.setText("("+eq2.getResB() * -1 + " - " +
                                        "\u221A" + delta + ") / (2 * " + eq2.getResA() + ")"+
                                        " = ("+eq2.getResB() * -1 + " - " +
                                        "\u221A" + delta + ") / (" +2*eq2.getResA() + ")");

                            }
                        }else{
                            double resultadoOriginalB = eq2.getResB();
                            double resultadoSemSinalB = Math.abs(resultadoOriginalB);

                            double resultadoOriginalC = eq2.getResC();
                            double resultadoSemSinalC = Math.abs(resultadoOriginalC);

                            resultado.setText("a = +" + eq2.getResA() +
                                    " b = " + resOperador1 + resultadoSemSinalB +
                                    " c = " + resOperador2 + resultadoSemSinalC + " -> " );
                            resultado2.setText("Raiz da equacao 2º, y = 0, " + " 0 = " +
                                    eq2.getResA() + "x² " + resOperador1 + resultadoSemSinalB+
                                    "x " + resOperador2 + resultadoSemSinalC + " -> "
                            );
                            resultado3.setText(
                                    eq2.getResA() + "x² " + resOperador1 + resultadoSemSinalB+
                                    "x " + resOperador2 + resultadoSemSinalC + " = 0 -> "
                            );
                            resultado4.setText(
                                    "Δ negativo, sem raizes -> "
                            );
                            resultado5.setText("b² -4 *a *c = "+"("+resOperador1+resultadoSemSinalB+")"+" ^2 "+" - "+"4"+" * "
                                    +eq2.getResA()+" * "+eq2.getResC()+ " = ");
                            resultado6.setText(pow(eq2.getResB(),2)
                                    +" "+comp1+" = "+delta);
                            resultado7.setText("");
                        }
                    }
                    else{
                        Snackbar.make(view, "Sinal operador valido: + - ", Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}