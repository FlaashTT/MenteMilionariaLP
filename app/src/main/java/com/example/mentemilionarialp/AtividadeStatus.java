package com.example.mentemilionarialp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadeStatus extends AppCompatActivity {

    private int nivelAtual;
    private TextView nivelView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atividade_status);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Atualizar o nível correspondente para vermelho
        nivelView = findViewById(getResources().getIdentifier("nivel" + nivelAtual, "id", getPackageName()));
        if (nivelView != null) {
            nivelView.setTextColor(Color.RED);
        }

        // Agora, vamos voltar para a próxima pergunta depois de 3 segundos
        new android.os.Handler().postDelayed(() -> {
            Intent intent = new Intent(AtividadeStatus.this, AtividadePerguntas.class);
            startActivity(intent);  // Inicia a próxima pergunta
        }, 3000);  // Aguarda 3 segundos

    }
}