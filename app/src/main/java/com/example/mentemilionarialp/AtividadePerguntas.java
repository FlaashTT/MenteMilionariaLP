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
    private int nivelAtual = 1;

    private Button botaoCorreto;

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

        //Resetar as perguguntas para nao visualizadas
        BD_LP.resetarVisualizada();

        // Simular Pergunta
        carregarPergunta();

        // Eventos para Gerir Respostas
        View.OnClickListener gerirRespostas = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button botao = (Button) v;

                //para botao ficar amarelo apos seleciona
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        botao.setBackgroundColor(Color.rgb(246, 179, 7));
                    }
                    @Override
                    public void onFinish() {
                        //counter para trocar a cor de amarelo para verde ou para vermelho
                        new CountDownTimer(1000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                if(verificarResposta(botao.getText().toString())){//caso a resposta seja corrtea fica a verde
                                    botao.setBackgroundColor(Color.GREEN);
                                }else{//se tiver errada coloca a vermelho a errada e a verde a correta
                                    botao.setBackgroundColor(Color.RED);
                                    botaoCorreto.setBackgroundColor(Color.GREEN);
                                }
                            }
                            @Override
                            public void onFinish() {
                                if(verificarResposta(botao.getText().toString())){

                                    // Exibir mensagem especial nos níveis 5 e 10
                                    if (nivelAtual == 5 || nivelAtual == 10) {
                                        new AlertDialog.Builder(AtividadePerguntas.this)
                                                .setTitle("Informação")//popUp a informar sobre os patamares de segurança
                                                .setMessage("Caso perca nas próximas perguntas o seu valor final será de " + mostrarPremio(nivelAtual))
                                                .setPositiveButton("OK", (dialog, which) -> {
                                                    nivelAtual++;
                                                    carregarPergunta();
                                                    dialog.dismiss();
                                                })
                                                .show();
                                    }else {
                                        //passa á proxima pergunta
                                        nivelAtual++;
                                        carregarPergunta();
                                    }

                                }else {
                                    proseguir();
                                }
                            }
                        }.start();
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

        // Trocar Pergunta
        btnTrocaPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TrocaPergunta();
            }
        });


    }

    //valor dos niveis
    private int mostrarPremio(int nivel) {
        int premio;

        switch (nivel) {
            case 1:premio = 0;break;
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

        //Para todos os botoes de resposta estarem visiveis e com a mesma cor
        opcaoA.setBackgroundColor(Color.BLUE);
        opcaoB.setBackgroundColor(Color.BLUE);
        opcaoC.setBackgroundColor(Color.BLUE);
        opcaoD.setBackgroundColor(Color.BLUE);
        opcaoA.setVisibility(View.VISIBLE);
        opcaoB.setVisibility(View.VISIBLE);
        opcaoC.setVisibility(View.VISIBLE);
        opcaoD.setVisibility(View.VISIBLE);

        mostrarPremio(nivelAtual);
        String dificuldade;


        //condiçao para gerir a dificuldade
        if (nivelAtual > 10) {
            dificuldade = "difícil";
        } else if (nivelAtual > 5) {
            dificuldade = "intermedio";
        } else {
            dificuldade = "fácil";
        }

        textoDificuldade.setText("Nivel-"+nivelAtual+" | Modo "+dificuldade);

        //para buscar uma pergunta aleatoria conforme a dificuldade
        Cursor resultadoColuna = BD_LP.obterPerguntaAleatoria(dificuldade);

        if (resultadoColuna != null && resultadoColuna.moveToFirst()) {
            String pergunta;

            //para nao garantir que nao volta a repetir a mesma pergunta
            int id = resultadoColuna.getInt(resultadoColuna.getColumnIndexOrThrow("id"));
            BD_LP.adicionarVisualizada(id);


            pergunta = resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("pergunta"));
            respostaCorreta = resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_correta"));

            // Atualizar texto das opções
            opcaoA.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_1")));
            opcaoB.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_2")));
            opcaoC.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_3")));
            opcaoD.setText(resultadoColuna.getString(resultadoColuna.getColumnIndexOrThrow("resposta_4")));

            //condiçao qual botao tem a resposta correta
            if (opcaoA.getText().toString().equals(respostaCorreta)) {
                botaoCorreto = opcaoA;
            } else if (opcaoB.getText().toString().equals(respostaCorreta)) {
                botaoCorreto = opcaoB;
            } else if (opcaoC.getText().toString().equals(respostaCorreta)) {
                botaoCorreto = opcaoC;
            } else if (opcaoD.getText().toString().equals(respostaCorreta)) {
                botaoCorreto = opcaoD;
            }
            textoPergunta.setText(pergunta);
            resultadoColuna.close();
        }
    }

    private boolean verificarResposta(String respostaEscolhida) {
        if (respostaEscolhida.equals(respostaCorreta)) {
            Log.d("AtividadePerguntas", "nivel " + nivelAtual);

            // Verificar se o nível atingiu o nível máximo
            if (nivelAtual == 15) {
                proseguir();
                return true;
            }
            return true; // Resposta correta
        } else {
            return false; // Resposta errada
        }
    }

    private void Opcao50_50() {
        //remove duas opçoes incorretas
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
        // Desativa o botão de troca para que ele não seja usado novamente
        btnTrocaPergunta.setEnabled(false);
    }

    //gestor de final de jogo
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