package com.example.mentemilionarialp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BaseDadosLP extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "basedadoslp.db";
    private static final int DATABASE_VERSION = 1;

    // Nome Das Tabelas
    private static final String TABELA_USERS = "users";
    private static final String TABELA_CATEGORIAS = "categorias";
    private static final String TABELA_RECEITAS = "receitas";
    private static final String TABELA_FAVORITOS = "favoritos";

    public BaseDadosLP(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Users = "CREATE TABLE " + TABELA_USERS + " (" +
                "user_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username TEXT NOT NULL, " +
                "email TEXT UNIQUE NOT NULL, " +
                "password TEXT NOT NULL, " +
                "password_confirm TEXT NOT NULL " +
                ")";

        String Categorias = "CREATE TABLE " + TABELA_CATEGORIAS + " (" +
                "category_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL UNIQUE" +
                ")";

        String Receitas = "CREATE TABLE " + TABELA_RECEITAS + " (" +
                "recipe_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "ingredients TEXT NOT NULL, " +
                "steps TEXT NOT NULL, " +
                "image TEXT, " +
                "category_id INTEGER, " +
                "user_id INTEGER, " +
                "FOREIGN KEY (category_id) REFERENCES categories(category_id), " +
                "FOREIGN KEY (user_id) REFERENCES users(user_id)" +
                ")";

        String Favoritos = "CREATE TABLE " + TABELA_FAVORITOS + " (" +
                "favorite_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user_id INTEGER, " +
                "recipe_id INTEGER, " +
                "FOREIGN KEY (user_id) REFERENCES users(user_id), " +
                "FOREIGN KEY (recipe_id) REFERENCES recipes(recipe_id)" +
                ")";

        // Executar as queries de criação
        db.execSQL(Users);
        db.execSQL(Categorias);
        db.execSQL(Receitas);
        db.execSQL(Favoritos);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualizar o banco de dados (se necessário)
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CATEGORIAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_RECEITAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FAVORITOS);
        onCreate(db);
    }

    // --- Métodos para Tabela de Utilizadores ---
    public boolean addUser(String username, String email, String password, String password_Confirm) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("email", email);
        values.put("password", password);
        values.put("password_confirm", password_Confirm);

        long result = db.insert(TABELA_USERS, null, values);
        return result != -1;
    }

    public Cursor getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM users WHERE email = ?";
        return db.rawQuery(query, new String[]{email});
    }

}
