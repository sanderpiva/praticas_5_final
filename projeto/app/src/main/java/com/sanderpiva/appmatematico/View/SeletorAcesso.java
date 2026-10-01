package com.sanderpiva.appmatematico.View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sanderpiva.appmatematico.Model.Google.Vgoogle;
import com.sanderpiva.appmatematico.R;
public class SeletorAcesso extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seletor_acesso);

        RadioButton radioProf = findViewById(R.id.radioButtonProf);
        RadioButton radioAluno = findViewById(R.id.radioButtonAluno);
        EditText senha = findViewById(R.id.editTextTextPassword);
        Button btnEnviar = findViewById(R.id.buttonEnviar);

        radioAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioProf.isChecked()) {
                    radioProf.setChecked(false);
                }
            }
        });

        radioProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioAluno.isChecked()) {
                    radioAluno.setChecked(false);
                }
            }
        });


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String senha2 = senha.getText().toString();
                if(radioProf.isChecked() && senha2.equals("123")){

                    Intent intentProf = new Intent(SeletorAcesso.this, Vgoogle.class);
                    startActivity(intentProf);

                }else if(radioAluno.isChecked() && senha2.equals("345")){

                    Intent intentAluno = new Intent(SeletorAcesso.this, Menu.class);
                    radioAluno.setChecked(false);
                    senha.setText("");
                    startActivity(intentAluno);
                }else{
                    Toast.makeText(SeletorAcesso.this, "Verifique dados inseridos!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}