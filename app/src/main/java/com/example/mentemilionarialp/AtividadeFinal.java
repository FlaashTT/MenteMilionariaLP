package com.example.mentemilionarialp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadeFinal extends AppCompatActivity {
    private Button jogarNovamente, jogarInicio;
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

        jogarNovamente = findViewById(R.id.btnJogarNovamente);
        jogarInicio = findViewById(R.id.btnInicio);

        jogarNovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtividadeFinal.this, AtividadePerguntas.class);
                startActivity(intent);
            }
        });

        jogarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AtividadeFinal.this, AtividadePrincipal.class);
                startActivity(intent);
            }
        });

    }
}