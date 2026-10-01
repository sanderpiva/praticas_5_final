package com.sanderpiva.appmatematico.Model.AreaQuadrado;

import static com.sanderpiva.appmatematico.R.id.btnMaterialApoioAreaQuadrado;

import static java.lang.Math.sqrt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

import java.text.DecimalFormat;

public class Aquadrado extends AppCompatActivity {


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aquadrado);

        Button btnVideo = (Button) findViewById(R.id.btnVideoAreaQuadrado);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Aquadrado.this, VareaQuadrado.class);
                startActivity(intent);
            }
        });

        Button btnPdf = findViewById(btnMaterialApoioAreaQuadrado);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Aquadrado.this, MaterialApoioAreaQuadrado.class);
                startActivity(intent);

            }
        });

        ImageView imagem = (ImageView) findViewById(R.id.imagemQuadrado);
        final TextView ladoValor = (TextView) findViewById(R.id.valorAreaQuadrado);
        final TextView lado1 = (TextView) findViewById(R.id.lado1CalculoAreaQuadrado);
        final TextView lado2 = (TextView) findViewById(R.id.lado2CalculoAreaQuadrado);
        imagem.setOnTouchListener(new View.OnTouchListener() {
            private float ultimaDistancia = -1;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getPointerCount() == 2) {
                    float distancia = getDistancia(motionEvent);
                    if (ultimaDistancia > 0) {
                        float proporcao = distancia / ultimaDistancia;
                        ajustarTamanho(proporcao);
                        atualizarValor(proporcao);
                    }
                    ultimaDistancia = distancia;
                } else {
                    ultimaDistancia = -1;
                }
                return true;
            }

            private float getDistancia(MotionEvent event) {
                float x = event.getX(0) - event.getX(1);
                float y = event.getY(0) - event.getY(1);
                return (float) sqrt(x * x + y * y);
            }

            private void ajustarTamanho(float proporcao) {
                ViewGroup.LayoutParams params = imagem.getLayoutParams();
                params.width = (int) (params.width * proporcao);
                params.height = (int) (params.height * proporcao);
                imagem.setLayoutParams(params);
            }

            private void atualizarValor(float proporcao) {
                DecimalFormat df = new DecimalFormat("#.##");
                ladoValor.setText("Area: "+df.format(imagem.getWidth() * proporcao) + " unidades^2");
                lado1.setText("Lado1: "+df.format(Math.sqrt(imagem.getWidth() * proporcao)) + " unidades");
                lado2.setText("Lado2: "+df.format(Math.sqrt(imagem.getWidth() * proporcao)) + " unidades");

            }
        });

        EditText ladoQuadrado = findViewById(R.id.editTextDoLadoQuadrado);
        Button btnCalcula = findViewById(R.id.btnCalculaAreaQuadrado);
        TextView resultadoAreaQuadrado = findViewById(R.id.textViewResultadoAreaQuadrado);
        TextView comentario = findViewById(R.id.textViewComentarioAreaQuadrado);

        btnCalcula.setOnClickListener(view -> {
            String ladoQuadradoString = ladoQuadrado.getText().toString();

            if(ladoQuadradoString.isEmpty()||ladoQuadradoString.equals("0")){

                Snackbar.make(view, "Preencha dado valor > 0", Snackbar.LENGTH_LONG).show();
            }
            else{
                ProcessaAreaQuadrado aq = new ProcessaAreaQuadrado(ladoQuadradoString);
                resultadoAreaQuadrado.setText(String.format("Area quadrado = %s%s = %.2f unidades²", ladoQuadradoString, '\u00B2', aq.resultadoAreaQuadrado()));
                comentario.setText(R.string.comentario);
            }
        });
    }
}