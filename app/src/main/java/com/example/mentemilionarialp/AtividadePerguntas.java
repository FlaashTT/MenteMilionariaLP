package com.example.mentemilionarialp;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Time;

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


                new CountDownTimer(1000, 1000) { // 10000 ms = 10 segundos, 1000 ms = intervalo de 1 segundo
                    @Override
                    public void onTick(long millisUntilFinished) {
                        botao.setBackgroundColor(Color.rgb(246, 179, 7));
                    }

                    @Override
                    public void onFinish() {
                       verificarResposta(botao.getText().toString());
                    }
                }.start();


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

        // Desistir
        btnOpcaoDesistir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proseguir();
            }
        });

        // Troca Pergunta
        btnTrocaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrocaPergunta();
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
        opcaoA.setBackgroundColor(Color.BLUE);
        opcaoB.setBackgroundColor(Color.BLUE);
        opcaoC.setBackgroundColor(Color.BLUE);
        opcaoD.setBackgroundColor(Color.BLUE);

        // Certifique-se de que todas as opções estão visíveis
        opcaoA.setVisibility(View.VISIBLE);
        opcaoB.setVisibility(View.VISIBLE);
        opcaoC.setVisibility(View.VISIBLE);
        opcaoD.setVisibility(View.VISIBLE);

        mostrarPremio(nivelAtual);
        String dificuldade;

        // Incrementa o nível após carregar a pergunta
        Log.d("AtividadePerguntas", "Nivel antes da dificuldade  " + nivelAtual);




        if (nivelAtual > 10) {
            dificuldade = "difícil";
        } else if (nivelAtual > 5) {
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
            Log.d("AtividadePerguntas", "nivel " + nivelAtual);
            nivelAtual++;



            // Verificar se o nível atingiu 15,nivel maximo
            if (nivelAtual == 15) {
                proseguir();
                return;
            }

            // Exibir mensagem especial nos níveis 5 e 10
            if (nivelAtual == 5 || nivelAtual == 10) {
                Toast.makeText(this, "Caso perca nas próximas perguntas o seu valor final será de " + mostrarPremio(nivelAtual), Toast.LENGTH_LONG).show();
            }

            carregarPergunta();
        } else {
            proseguir();
        }
    }





    private void Opcao50_50() {
        // Verifica as respostas exibidas e oculta duas erradas
        if (!opcaoA.getText().toString().equals(respostaCorreta)) {
            opcaoA.setVisibility(View.INVISIBLE);
        }

        if (!opcaoB.getText().toString().equals(respostaCorreta)) {
            opcaoB.setVisibility(View.INVISIBLE);
        }

        // Oculta apenas mais uma opção incorreta
        if (!opcaoC.getText().toString().equals(respostaCorreta) && opcaoA.getVisibility() == View.VISIBLE) {
            opcaoC.setVisibility(View.INVISIBLE);
        } else if (!opcaoD.getText().toString().equals(respostaCorreta) && opcaoB.getVisibility() == View.VISIBLE) {
            opcaoD.setVisibility(View.INVISIBLE);
        }

        // Desativa o botão "50/50" para que ele não seja usado novamente
        btnOpcao50_50.setEnabled(false);
    }

    private void TrocaPergunta() {
        carregarPergunta();

        // Desativa o botão "50/50" para que ele não seja usado novamente
        btnTrocaPergunta.setEnabled(false);
    }


    private void proseguir(){
        int valorFinal;
        if (nivelAtual >= 10){
             valorFinal = mostrarPremio(10);
        } else if(nivelAtual >= 5 ) {
             valorFinal = mostrarPremio(5);
        }else {
             valorFinal = 0;
        }

        Intent intent = new Intent(AtividadePerguntas.this, AtividadeFinal.class);
        intent.putExtra("ValorTotalGanho", String.valueOf(valorFinal));
        intent.putExtra("RondasJogadas", String.valueOf(nivelAtual));   
        startActivity(intent);

    }
}