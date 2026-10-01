package com.sanderpiva.appmatematico.Model.Proporcao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class Proporcao extends AppCompatActivity {

    private android.widget.EditText a, b, c;
    private android.widget.TextView resultado, desc, legenda, legenda2;
    private android.widget.Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proporcao);

        Button btnVideo = (Button) findViewById(R.id.btnVideoProporcao);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Proporcao.this, Vproporcao.class);
                startActivity(intent);
            }
        });

        Button btnPdf = (Button) findViewById(R.id.btnMaterialApoioProporcao);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Proporcao.this, MaterialApoioProporcao.class);
                startActivity(intent);

            }
        });


        a = findViewById(R.id.editTextValor1a);
        b = findViewById(R.id.editTextValor1b);
        c = findViewById(R.id.editTextValor1c);
        resultado = findViewById(R.id.textViewResultadoPr);
        legenda = findViewById(R.id.textViewLegenda);
        legenda2 = findViewById(R.id.textViewLegenda2);
        desc = findViewById(R.id.textViewDescResultadoProporcao);
        android.widget.Button btncalcular = findViewById(R.id.buttonCalcularProporcao);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                String resA = a.getText().toString();
                String resB = b.getText().toString();
                String resC = c.getText().toString();
                if(resA.isEmpty()||resB.isEmpty()||resC.isEmpty()){
                    View layoutProporcao = findViewById(R.id.activity_proporcao);
                    Snackbar.make(layoutProporcao, "Preencha todos os dados", Snackbar.LENGTH_SHORT).show();
                }else{
                    ProcessaProporcao p = new ProcessaProporcao(resA, resB, resC);
                    legenda.setText("A = "+p.getV1()+", "+"B = "+p.getV2()+", "+"C = "+p.getV3()+", "+"D = ?");
                    legenda2.setText("D*A = C*B");
                    resultado.setText(String.format("D = %.2f", p.calculaProporcao()));
                    desc.setText(String.format(
                            "D*%.2f = %.2f * %.2f -> D*%.2f = %.2f -> D = %.2f / %.2f = %.2f",
                            p.getV1(),
                            p.getV3(),
                            p.getV2(),
                            p.getV1(),
                            (p.getV3() * p.getV2()),
                            (p.getV3() * p.getV2()),
                            p.getV1(),
                            p.calculaProporcao()
                    ));

                }
            }
        });
    }
}