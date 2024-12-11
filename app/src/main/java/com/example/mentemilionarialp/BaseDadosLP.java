package com.example.mentemilionarialp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDadosLP extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "basedadoslp.db";
    private static final int DATABASE_VERSION = 1;

    public BaseDadosLP(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE perguntas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "pergunta TEXT, " +
                "resposta_correta TEXT, " +
                "resposta_1 TEXT, " +
                "resposta_2 TEXT, " +
                "resposta_3 TEXT, " +
                "resposta_4 TEXT, " +
                "dificuldade TEXT, " +
                "visualizada INTEGER DEFAULT 0) ");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quantos meses tem um ano?', '12', '10', '11', '13', '12', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é a capital de Portugal?', 'Lisboa', 'Lisboa', 'Porto', 'Portugal', 'Leiria', 'fácil',0)");



        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome da primeira letra do alfabeto?', 'A', 'B', 'C', 'A', 'D', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quantos continentes existem no planeta Terra?', '7', '5', '7', '6', '8', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quanto é 2+2', '4', '2', '4', '7', '8', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual a estação do ano mais quente', 'Verão', 'outono', 'inverno', 'Verão', 'primavera', 'fácil',0)");





        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem pintou a Mona Lisa?', 'Leonardo da Vinci', 'Vincent van Gogh', 'Pablo Picasso', 'Leonardo da Vinci', 'Claude Monet', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o maior país do mundo em área?', 'Rússia', 'Estados Unidos', 'China', 'Rússia', 'Canadá', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é a fórmula química do metano?', 'CH4', 'CO2', 'CH4', 'C2H6', 'C3H8', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o elemento químico que tem o símbolo O?', 'Oxigênio', 'Osmium', 'Oxigênio', 'Ouro', 'Oganessônio', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem escreveu \"Dom Quixote\"?', 'Miguel de Cervantes', 'Gabriel García Márquez', 'Miguel de Cervantes', 'Jorge Luis Borges', 'Mario Vargas Llosa', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o nome da sereia no filme A pequena sereia', 'Ariel', 'ana', 'rogeria', 'transmontana', 'Ariel', 'médio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual a raiz quadrada de 4', '2', '4', 'raiz quadrada de 4', '2', '8', 'médio',0)");




        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é a teoria que descreve a origem do universo?', 'Big Bang', 'Teoria da Relatividade', 'Big Bang', 'Teoria das Cordas', 'Teoria Quântica', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome da partícula subatômica descoberta por Peter Higgs?', 'Bóson de Higgs', 'Bóson de W', 'Neutrino', 'Bóson de Higgs', 'Quark Top', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem propôs a teoria da relatividade?', 'Albert Einstein', 'Isaac Newton', 'Albert Einstein', 'Niels Bohr', 'Galileo Galilei', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Em que ano ocorreu a Revolução Francesa?', '1789', '1799', '1789', '1800', '1776', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome do maior deserto do mundo?', 'Deserto da Antártida', 'Deserto do Saara', 'Deserto da Antártida', 'Deserto da Arábia', 'Deserto de Gobi', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o nome do filho do napoleao', 'Nao sei ', 'dartacao', 'jeremias', 'Antonieta', 'Nao sei', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o primeiro foguete a chegar ha lua', 'saturno V', 'Elon Musk', 'Apolo I', 'saturno V', 'Tom cruz', 'difícil',0)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS perguntas");
        onCreate(db);
    }

    public Cursor obterPerguntaAleatoria(String dificuldade) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(
                "SELECT * FROM perguntas WHERE dificuldade = ? AND visualizada = 0 ORDER BY RANDOM() LIMIT 1",
                new String[]{dificuldade});

    }

    public void adicionarVisualizada(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE perguntas SET visualizada = 1 WHERE id = ?", new Object[]{id});
        //Log.d("BaseDadosLP", "ID: " + id , "pergunta" + obterPerguntaAleatoria(id) );
    }

    public void resetarVisualizada(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE perguntas SET visualizada = 0 WHERE visualizada = 1");

    }

}
