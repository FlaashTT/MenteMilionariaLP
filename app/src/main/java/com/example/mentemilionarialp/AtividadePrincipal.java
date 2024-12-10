package com.example.mentemilionarialp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadePrincipal extends AppCompatActivity {

    private TextView InserirNome;
    private CheckBox checkBoxIdade;
    private Button buttonIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atividade_principal);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        InserirNome = findViewById(R.id.InserirNome);
        checkBoxIdade = findViewById(R.id.checkBoxIdade);
        buttonIniciar = findViewById(R.id.buttonIniciar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = InserirNome.getText().toString();

                if (nome.isEmpty() || nome.equals("Inserir nome")){
                    Toast.makeText(AtividadePrincipal.this, "Tem de inserir um nome!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!checkBoxIdade.isChecked()){
                    Toast.makeText(AtividadePrincipal.this, "Não pode jogar sendo menor de idade", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(AtividadePrincipal.this, "Sucesso ", Toast.LENGTH_SHORT).show();

                Intent enviarInfo = new Intent(AtividadePrincipal.this, AtividadePerguntas.class);
                enviarInfo.putExtra("Nome",nome);
                startActivity(enviarInfo);
            }
        });
    }
}