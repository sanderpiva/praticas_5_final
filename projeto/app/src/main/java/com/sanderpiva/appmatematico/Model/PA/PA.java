package com.sanderpiva.appmatematico.Model.PA;


import androidx.appcompat.app.AppCompatActivity;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioPA;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class PA extends AppCompatActivity {

    private android.widget.EditText a1, nMenosUm, r;
    private android.widget.TextView resultadoAn;
    private android.widget.Button btncalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pa);

        Button btnVideo = (Button) findViewById(R.id.btnVideoPA);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PA.this, Vpa.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioPA);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PA.this, MaterialApoioPA.class);
                startActivity(intent);

            }
        });

        a1 = findViewById(R.id.editTextA1_PA);
        nMenosUm = findViewById(R.id.editTextNmenosUm_PA);
        r = findViewById(R.id.editTextTextR);
        resultadoAn=findViewById(R.id.textViewResultadoAn_PA);

        android.widget.Button btncalcular = findViewById(R.id.btnCalcularPA);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                String resA1 = a1.getText().toString();
                String resNmenosUm = nMenosUm.getText().toString();
                String resR = r.getText().toString();

                if(resA1.isEmpty() || resNmenosUm.isEmpty()|| resR.isEmpty()) {
                    Snackbar.make(view, "Preencha todos os dados", Snackbar.LENGTH_LONG).show();
                }else{
                    ProcessaPA pa = new ProcessaPA(resA1, resNmenosUm, resR);
                    resultadoAn.setText("an = a1+(n-1)*r =>"+resA1+"+"+resNmenosUm+"*"+resR+" = "+
                            pa.getResA1()+" + "+
                            pa.getResNmenosUm()*pa.getResR()+" = "+pa.calculaAn());
                }
            }
        });

    }
}