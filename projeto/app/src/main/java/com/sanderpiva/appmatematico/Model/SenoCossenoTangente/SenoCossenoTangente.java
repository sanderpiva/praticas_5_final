package com.sanderpiva.appmatematico.Model.SenoCossenoTangente;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioSenoCossenoTangente;

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

public class SenoCossenoTangente extends AppCompatActivity {

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seno_cosseno_tangente);

        Button btnVideo = (Button) findViewById(R.id.btnVideoSenoCossenoTangente);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenoCossenoTangente.this, VsenoCossenoTangente.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioSenoCossenoTangente);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SenoCossenoTangente.this, MaterialApoioSenoCossenoTangente.class);
                startActivity(intent);

            }
        });

        EditText editTextCo = findViewById(R.id.editTextCo);
        EditText editTextCa = findViewById(R.id.editTextCa);
        EditText editTextHip = findViewById(R.id.editTextHip);
        Button btnCalcula = findViewById(R.id.btnCalculaSenoCossenoTangente);
        TextView resultadoSeno = findViewById(R.id.textViewResultadoSeno);
        TextView resultadoCosseno = findViewById(R.id.textViewResultadoCosseno);
        TextView resultadoTangente = findViewById(R.id.textViewResultadoTangente);

        btnCalcula.setOnClickListener(view -> {
            String co = editTextCo.getText().toString();
            String ca = editTextCa.getText().toString();
            String hip = editTextHip.getText().toString();

            if(co.isEmpty() || ca.isEmpty()||  hip.isEmpty() ||
                    co.equals("0")||ca.equals("0") || hip.equals("0")){

                Snackbar.make(view, "Preencha todos dados com valor > 0", Snackbar.LENGTH_LONG).show();
            }

            else{
                ProcessaSenoCossenoTangente psct = new ProcessaSenoCossenoTangente(co, ca, hip);

                resultadoSeno.setText(String.format("Seno: co / hip -> %s / %s = %.2f", psct.getCo(), psct.getHip(), psct.resultadoSeno()));
                resultadoCosseno.setText(String.format("Cosseno: cad / hip -> %s / %s = %.2f", psct.getCa(), psct.getHip(), psct.resultadoCosseno()));
                resultadoTangente.setText(String.format("Tangente: co / cad -> %s / %s = %.2f", psct.getCo(), psct.getCa(), psct.resultadoTangente()));
            }
        });

    }
}