package com.example.mentemilionarialp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDadosLP extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "basedadoslp.db";
    private static final int DATABASE_VERSION = 1;
    private static final String PERGUNTAS = "CREATE TABLE perguntas (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "pergunta TEXT, " +
                    "resposta_correta TEXT, " +
                    "resposta_1 TEXT, " +
                    "resposta_2 TEXT, " +
                    "resposta_3 TEXT, " +
                    "resposta_4 TEXT, " +
                    "dificuldade TEXT, " +
                    "visualizada INTEGER DEFAULT 0)";

    public BaseDadosLP(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(PERGUNTAS);

        //faceis
        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual destas palavras é sinonima de \"malandro\"', 'Gabiru', 'Aluado', 'Casmurro', 'Gabiru', 'Pelintra', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual destes alimentos pode integrar uma dieta vegana?', 'Arroz', 'Queijo', 'Arroz', 'Salsichas', 'Salmão', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual destes numeros é o unico numero que,alem de ser par é primo', 'Dois', 'Quatro', 'Dois', 'Seis', 'Oito', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Em que ano se realizam os primeiros Jogos Olimpicos da era moderna?', '1896', '1968', '1896', '1972', '1907', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Os protagonistas da serie \"Os Simpsons\" são de cor', 'Amarela', 'Verde', 'Amarela', 'Azul', 'Rosa', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Das seguintes opções qual pode ser considerado um deserto', 'Antártida', 'Antártida', 'Moscovo', 'Amazonia', 'Floresta Portuguesa', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome da famosa torre localizada em Paris?', 'Torre Eiffel', 'Torre de Belem', 'Torre de Londres', 'Torre Eiffel', 'Torre Torta', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem é o personagem \"Tom\" na famosa serie animada? ', 'Tom,o gato do Tom e jerry', 'Tom,o gato do Tom e mickey', 'Garfield', 'Tom,o gato do Tom e jerry', 'Mickey', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual destes instrumentos não é um instrumento de sopro? ', 'Violão', 'Flauta', 'Trompete', 'Saxofone', 'Violão', 'fácil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o famoso brinquedo que é montado com peças coloridas e encaixaveis?', 'Lego', 'Domino', 'Lego', 'Pipa', 'Quebra-cabeça', 'fácil',0)");




//medias
        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual das seguintes opções nõo é uma linguagem de programação', 'HTML', 'Lua', 'HTML', 'GO', 'Cypher', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('O numero PI é usado para calcular a area de qual destas figuras geometricas', 'Circulo', 'Retangulo', 'Circulo', 'Quadrado', 'Triangulo', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é a fórmula química do metano?', 'CH4', 'CO2', 'CH4', 'C2H6', 'C3H8', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('As Luminarias de São José são uma tradição de que conselho do distrito de Leiria', 'Bombarral', 'Alcobaça', 'Bombarral', 'Pombal', 'Porto de Mós', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem escreveu \"Dom Quixote\"?', 'Miguel de Cervantes', 'Gabriel García Márquez', 'Miguel de Cervantes', 'Jorge Luis Borges', 'Mario Vargas Llosa', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Que seleção de Futebol é apelidada de \"Três Leões\"? ', 'Inglaterra', 'Espanha', 'Inglaterra', 'Sporting', 'PSG', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Quem é o autor da obra \"O princepe\"', 'Nicolau Maquiavel', 'Platão', 'Aristóteles', 'Nicolau Maquiavel', 'Jean-Jacques Rousseau', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o pais conhecido como \"Terra do sol Nascente\"?', 'Japão', 'Japão', 'Tailandia', 'China', 'Coreia do Sul', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o maior Oceano do Planeta Terra', 'Oceano Pacifico', 'Oceano Artico', 'Oceano Indico', 'Oceano Pacifico', 'Oceano Atalântico', 'intermedio',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o nome da escola de magia onde Harry Potter estuda ', 'Hogwarts', 'Ilvermorny', 'Durmstrang', 'Hogwarts', 'Beauxbatons', 'intermedio',0)");



//dificeis

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Que nome se dava aos Pescadores que no inverno migravam para pescar no rio Tejo', 'Avieiros', 'Avieiros', 'Cabaneiros', 'Esparregueiros', 'Ratinhos', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('O album \"The Guitar Trio\" de 1996,junta Al Di Meola,John McLaughlin e...', 'Paco de Lucia ', 'Carlos Santana', 'Paco de Lucia', 'Manolo Sanlúcar', 'Vicente Amigo', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Em que ano foi descoberto o bosão de Higgs, tambem apelidado de \" particula de Deus\"?', '2012', '1978', '2012', '1912', '1887', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Em que ano ocorreu a Revolução Francesa?', '1789', '1799', '1789', '1800', '1776', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome do maior deserto do mundo?', 'Deserto da Antártida', 'Deserto do Saara', 'Deserto da Antártida', 'Deserto da Arábia', 'Deserto de Gobi', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o nome da primeira obra de José Saramago', 'Terra do Pecado ', 'Memorial do Convento', 'Terra do Pecado', 'Ensaio sobre a Cegueira', 'A Jangada de Pedra', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual o primeiro foguete a chegar ha lua', 'saturno V', 'Elon Musk', 'Apolo I', 'saturno V', 'Redstone', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é a teoria que descreve a origem do universo?', 'Big Bang', 'Teoria da Relatividade', 'Big Bang', 'Teoria das Cordas', 'Teoria Quântica', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual é o nome da partícula subatômica descoberta por Peter Higgs?', 'Bóson de Higgs', 'Bóson de W', 'Neutrino', 'Bóson de Higgs', 'Quark Top', 'difícil',0)");

        db.execSQL("INSERT INTO perguntas (pergunta, resposta_correta, resposta_1, resposta_2, resposta_3, resposta_4, dificuldade,visualizada) " +
                "VALUES ('Qual destes Reis fez parte da dinastia brigantina', 'D.João V', 'D.João II', 'D.João V', 'D.Afonso Henriques', 'Dom Manuel I', 'difícil',0)");
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
