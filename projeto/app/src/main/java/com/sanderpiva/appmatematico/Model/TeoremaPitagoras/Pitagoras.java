package com.sanderpiva.appmatematico.Model.TeoremaPitagoras;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioPitagoras;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class Pitagoras extends AppCompatActivity {

    private android.widget.TextView resultadoHipotenusa;
    private android.widget.TextView hipRaizExata;
    private android.widget.TextView hipNaoTemRaizExata;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitagoras);

        Button btnVideo = (Button) findViewById(R.id.btnVideoPitagoras);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pitagoras.this, Vpitagoras.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioPitagoras);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Pitagoras.this, MaterialApoioPitagoras.class);
                startActivity(intent);

            }
        });

        EditText editCa1 = findViewById(R.id.editTextCA1);
        EditText editCa2 = findViewById(R.id.editTextCA2);
        Button btnCalcula = findViewById(R.id.btnCalculaHipotenusa);
        resultadoHipotenusa = findViewById(R.id.textViewResultadoHipotenusa);
        hipRaizExata = findViewById(R.id.textViewHipTemRaizExata);
        hipNaoTemRaizExata = findViewById(R.id.textViewHipNaoTemRaizExata);

        btnCalcula.setOnClickListener(view -> {
            String ca1 = editCa1.getText().toString();
            String ca2 = editCa2.getText().toString();

            if(ca1.isEmpty() || ca2.isEmpty()||ca1.equals("0")||ca2.equals("0")){

                Snackbar.make(view, "Preencha todos dados com valor > 0", Snackbar.LENGTH_LONG).show();
            }
            
            else{
                ProcessaPitagoras pi = new ProcessaPitagoras(ca1, ca2);
                String resHip = "hip² = (ca1²) + (ca2²) -> ";

                resultadoHipotenusa.setText(String.format(
                        "%ship² = %s² + %s² -> %.2f + %.2f -> hip² = %s -> hip = √%s -> hip = %.2f",
                      resHip, ca1, ca2, pi.resultadoCa1(),
                        pi.resultadoCa2(),pi.resultadoHipAoQuadrado(),
                        pi.resultadoHipAoQuadrado(), pi.resultadoHip()));

                hipRaizExata.setText(R.string.hipTemRaizExata);
                hipNaoTemRaizExata.setText(R.string.hipNaoTemRaizExata);
            }
        });
    }
}