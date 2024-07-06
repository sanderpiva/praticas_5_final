package com.sanderpiva.appmatematico.Model.PG;

import androidx.appcompat.app.AppCompatActivity;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioPG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class PG extends AppCompatActivity {

    private android.widget.EditText a1, nMenosUm, q;
    private android.widget.TextView resultadoAn;
    private android.widget.Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pg);

        Button btnVideo = (Button) findViewById(R.id.btnVideoPG);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PG.this, Vpg.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioPG);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PG.this, MaterialApoioPG.class);
                startActivity(intent);

            }
        });

        a1 = findViewById(R.id.editTextA1_PG);
        nMenosUm = findViewById(R.id.editTextNmenosUm_PG);
        q = findViewById(R.id.editTextQ_PG);
        resultadoAn=findViewById(R.id.textViewResultadoAn_PG);

        android.widget.Button btncalcular = findViewById(R.id.btnCalcularPG);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String resA1 = a1.getText().toString();
                String resNmenosUm = nMenosUm.getText().toString();
                String resQ = q.getText().toString();


                if(resA1.isEmpty() || resNmenosUm.isEmpty()|| resQ.isEmpty()) {
                    Snackbar.make(view, "Preencha todos os dados", Snackbar.LENGTH_LONG).show();
                }else{
                    ProcessaPG pg = new ProcessaPG(resA1, resNmenosUm, resQ);
                    resultadoAn.setText("an = a1*q ^ (n-1) = "+
                            pg.getResA1()+" * "+pg.getResQ()+" ^ "+
                            pg.getResNmenosUm()+" = "+
                            pg.getResA1()+" * "+ Math.pow(pg.getResQ(), pg.getResNmenosUm()) +" = "+
                            pg.calculaAn());
                }
            }
        });

    }
}