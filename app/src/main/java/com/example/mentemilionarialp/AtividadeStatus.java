package com.example.mentemilionarialp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadeStatus extends AppCompatActivity {

    private int nivelAtual;

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


        /*
        Bundle extras = getIntent().getExtras();
        String nivelAtualRecebido = extras.getString("nivelAtual");
        int nivelAtual = Integer.parseInt(nivelAtualRecebido);
        Log.d("AtividadeStatus", "Nivel no status: "+nivelAtual);
        */

        // Agora, vamos voltar para a próxima pergunta depois de 3 segundos
        new android.os.Handler().postDelayed(() -> {
            Intent intent = new Intent(AtividadeStatus.this, AtividadePerguntas.class);
            intent.putExtra("nivelAtual", nivelAtual);  // Passa o nível novamente para a próxima atividade
            startActivity(intent);  // Inicia a próxima pergunta
        }, 3000);  // Aguarda 3 segundos

    }
}