package com.sanderpiva.appmatematico.Model.PerimetroQuadrado;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioPerimetroQuadrado;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class PerimetroQuadrado extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perimetro_quadrado);

        Button btnVideo = (Button) findViewById(R.id.btnVideoPerimetroQuadrado);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerimetroQuadrado.this, VperimetroQuadrado.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioPerimetroQuadrado);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PerimetroQuadrado.this, MaterialApoioPerimetroQuadrado.class);
                startActivity(intent);

            }
        });

        EditText ladoQuadrado = findViewById(R.id.editTextLadoPerimetroQuadrado);
        Button btnCalcula = findViewById(R.id.btnCalculaPerimetroQuadrado);
        TextView resultadoPerimetroQuadrado = findViewById(R.id.textViewResultadoPerimetroQuadrado);


        btnCalcula.setOnClickListener(view -> {
            String ladoQuadradoString = ladoQuadrado.getText().toString();

            if(ladoQuadradoString.isEmpty()||ladoQuadradoString.equals("0")){

                Snackbar.make(view, "Preencha dado valor > 0", Snackbar.LENGTH_LONG).show();
            }
            else{
                ProcessaPerimetroQuadrado pq = new ProcessaPerimetroQuadrado(ladoQuadradoString);

                resultadoPerimetroQuadrado.setText("Perímetro do quadrado: 4 x lado = 4 x " + ladoQuadradoString + " = " + pq.resultadoPerimetroQuadrado() + " unidades");

            }
        });
    }
}