package com.sanderpiva.appmatematico.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.sanderpiva.appmatematico.Model.AreaQuadrado.Aquadrado;
import com.sanderpiva.appmatematico.Model.Eq1Grau.EquacaoPrimeiroGrau;
import com.sanderpiva.appmatematico.Model.Eq2Grau.EquacaoSegundoGrau;
import com.sanderpiva.appmatematico.Model.PA.PA;
import com.sanderpiva.appmatematico.Model.PG.PG;
import com.sanderpiva.appmatematico.Model.PerimetroQuadrado.PerimetroQuadrado;
import com.sanderpiva.appmatematico.Model.Porcentagem.Porcentagem;
import com.sanderpiva.appmatematico.Model.Proporcao.Proporcao;
import com.sanderpiva.appmatematico.Model.SenoCossenoTangente.SenoCossenoTangente;
import com.sanderpiva.appmatematico.Model.TeoremaPitagoras.Pitagoras;
import com.sanderpiva.appmatematico.R;

public class Menu extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        gridView = (GridView) findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(Menu.this, Aquadrado.class);
                        break;
                    case 1:
                        intent = new Intent(Menu.this, PerimetroQuadrado.class);
                        break;
                    case 2:
                        intent = new Intent(Menu.this, SenoCossenoTangente.class);
                        break;
                    case 3:
                        intent = new Intent(Menu.this, Pitagoras.class);
                        break;
                    case 4:
                        intent = new Intent(Menu.this, PA.class);
                        break;
                    case 5:
                        intent = new Intent(Menu.this, PG.class);
                        break;
                    case 6:
                        intent = new Intent(Menu.this, Proporcao.class);
                        break;
                    case 7:
                        intent = new Intent(Menu.this, Porcentagem.class);
                        break;
                    case 8:
                        intent = new Intent(Menu.this, EquacaoPrimeiroGrau.class);
                        break;
                    case 9:
                        intent = new Intent(Menu.this, EquacaoSegundoGrau.class);
                        break;

                }
                startActivity(intent);
            }
        });
    }
}




