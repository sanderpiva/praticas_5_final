package com.sanderpiva.appmatematico.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.sanderpiva.appmatematico.R;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_TIMEOUT = 9000; // Tempo de carregamento em milissegundos
    private static final int PROGRESS_MAX = 100;
    private static final int PROGRESS_DELAY = 90; // Tempo de atraso entre as atualizações em milissegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
        progressBar.setMax(PROGRESS_MAX);

        // Iniciar o processo de carregamento gradual
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int progress = 0; progress <= PROGRESS_MAX; progress++) {
                    final int currentProgress = progress;
                    // Atualizar o progresso usando o handler
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(currentProgress);
                        }
                    });

                    try {
                        Thread.sleep(PROGRESS_DELAY);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // Após o carregamento gradual, iniciar a MenuActivity
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(ProgressBar.INVISIBLE);
                        //Intent intent = new Intent(MainActivity.this, Menu.class);
                        Intent intent = new Intent(MainActivity.this, SeletorAcesso.class);
                        startActivity(intent);
                        finish(); // Fecha a tela de carregamento (MainActivity)
                    }
                });
            }
        }).start();
    }
}
