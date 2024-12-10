package com.example.mentemilionarialp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AtividadePerguntas extends AppCompatActivity {
    private BaseDadosLP BD_LP;
    private TextView textoPergunta,textoDificuldade,textoPremio;
    private Button opcaoA, opcaoB, opcaoC, opcaoD, btnOpcao50_50, btnTrocaPergunta, btnOpcaoDesistir;
    private String respostaCorreta;

    private int nivelAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atividade_perguntas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textoPremio = findViewById(R.id.textViewPremio);
        textoDificuldade = findViewById(R.id.textViewDificuldade);
        textoPergunta = findViewById(R.id.textViewPergunta);
        opcaoA = findViewById(R.id.btnOpcaoA);
        opcaoB = findViewById(R.id.btnOpcaoB);
        opcaoC = findViewById(R.id.btnOpcaoC);
        opcaoD = findViewById(R.id.btnOpcaoD);

        btnOpcao50_50 = findViewById(R.id.btnOpcao50_50);
        btnTrocaPergunta = findViewById(R.id.btnOpcaoTrocaPergunta);
        btnOpcaoDesistir = findViewById(R.id.btnOpcaoDesistir);

        // Iniciar Base de Dados
        BD_LP = new BaseDadosLP(this);

        //Reset
        BD_LP.resetarVisualizada();

        // Simular Pergunta
        carregarPergunta();

        // Eventos para Gerir Respostas
        View.OnClickListener gerirRespostas = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button botao = (Button) v;
                verificarResposta(botao.getText().toString());
            }
        };

        opcaoA.setOnClickListener(gerirRespostas);
        opcaoB.setOnClickListener(gerirRespostas);
        opcaoC.setOnClickListener(gerirRespostas);
        opcaoD.setOnClickListener(gerirRespostas);






        // Ajuda 50_50

        btnOpcao50_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Opcao50_50();
            }
        });

        // Trocar Pergunta
        btnTrocaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrocaPergunta();
            }
        });

        // Desistir Pergunta
        btnTrocaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpcaoDesistir();
            }
        });


    }
    private int mostrarPremio(int nivel) {
        int premio;

        switch (nivel) {
            case 0:premio = 0;break;
            case 1:premio = 500;break;
            case 2:premio = 1500;break;
            case 3:premio = 2500;break;
            case 4:premio = 3500;break;
            case 5:premio = 4500;break;
            case 6:premio = 6000;break;
            case 7:premio = 7000;break;
            case 8:premio = 10000;break;
            case 9:premio = 12500;break;
            case 10:premio = 15000;break;
            case 11:premio = 25000;break;
            case 12:premio = 50000;break;
            case 13:premio = 250000;break;
            case 14:premio = 500000;break;
            case 15:premio = 1000000;break;
            default:premio = 0; // Caso o nível seja inválido
        }


        textoPremio.setText("total ganho "+premio + "€");
        return premio;
    }


    private void carregarPergunta() {

        mostrarPremio(nivelAtual);
        String dificuldade;

        // Incrementa o nível após carregar a pergunta
        Log.d("AtividadePerguntas", "Nivel antes da dificuldade  " + nivelAtual);



        if (nivelAtual >= 11) {
            dificuldade = "dificil";
        } else if (nivelAtual >= 5 && nivelAtual <=10) {
            dificuldade = "médio";
        } else {
            dificuldade = "fácil";

        }
        textoDificuldade.setText("Nivel-"+nivelAtual+" | Modo "+dificuldade);


        Cursor resultadoColuna = BD_LP.obterPerguntaAleatoria(dificuldade);

        if (resultadoColuna != null && resultadoColuna.moveToFirst()) {
            String pergunta;

            int id = resultadoColuna.getInt(resultadoColuna.getColumnIndexOrThrow("id"));
            BD_LP.adicionarVisualizada(id);
            Log.d("BD_LP", "ID visualizada: " + id);

            pergunta = resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("pergunta"));
            respostaCorreta = resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_correta"));

            // Atualizar texto das opções
            opcaoA.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_1")));
            opcaoB.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_2")));
            opcaoC.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_3")));
            opcaoD.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_4")));
            textoPergunta.setText(pergunta);



            resultadoColuna.close();

        }
    }

    private void verificarResposta(String respostaEscolhida) {
        if (respostaEscolhida.equals(respostaCorreta)) {

            Log.d("AtividadePerguntas", "antes de fechar " + nivelAtual);
            nivelAtual++;
            Log.d("AtividadePerguntas", "depois de fechar " + nivelAtual);
            // Verificar se o nível atingiu ou superou 5
            /*if (nivelAtual == 15) {
                // Se o nível for 5 ou mais, redireciona para a AtividadeStatus
                Intent intent = new Intent(AtividadePerguntas.this, AtividadeFim.class);
                startActivity(intent);
            } */

            carregarPergunta();
        } else {
            // Se a resposta estiver errada, reseta a visualização
           //BD_LP.resetarVisualizada();
        }
    }




    private void Opcao50_50() {

    }

    private void TrocaPergunta() {

    }

    private void OpcaoDesistir() {

    }
}