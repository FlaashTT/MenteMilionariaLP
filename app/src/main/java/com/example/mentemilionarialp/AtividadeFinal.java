package com.example.mentemilionarialp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadeFinal extends AppCompatActivity {



    private Button jogarNovamente, jogarInicio;

    private TextView ValorGanho,RondasJogadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atividade_final);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle extras = getIntent().getExtras();
        String valorGanho = extras.getString("ValorTotalGanho", "0"); // Valor padrão se null
        String rondaJogadas = extras.getString("RondasJogadas", "0"); // Valor padrão se null

        Log.d("AtividadeFinal", "Valor Total Ganho: " + valorGanho);
        Log.d("AtividadeFinal", "Rondas Jogadas: " + rondaJogadas);

        ValorGanho = findViewById(R.id.textViewValorGanho);
        RondasJogadas = findViewById(R.id.textViewRondasJogadas);
        jogarNovamente = findViewById(R.id.btnJogarNovamente);
        jogarInicio = findViewById(R.id.btnInicio);


        ValorGanho.setText(""+valorGanho);
        RondasJogadas.setText(""+rondaJogadas);

        jogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtividadeFinal.this, AtividadePerguntas.class);
                startActivity(intent);
            }
        });

        //para voltar ha pagina incial da aplicação
        jogarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtividadeFinal.this, AtividadePrincipal.class);
                startActivity(intent);
            }
        });

    }
}