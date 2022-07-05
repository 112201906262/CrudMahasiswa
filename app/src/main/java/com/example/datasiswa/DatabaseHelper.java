package com.example.datasiswa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "data_siswa.db";

    public DatabaseHelper(@Nullable Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static final String TABLE_NAME = "tabel siswa";
    public static final String ROW_ID = "id";
    public static final String NAMA = "nama_siswa";
    public static final String NIM = "nim_siswa";
    public static final String IPK = "ipk_siswa";
    public static final String FAKULTAS = "fakultas_siswa";

    public static final String CREATE_TABLE = "CREATE TABLE" + TABLE_NAME + "("
            + ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE NOT NULL, "
            + NAMA + " TEXT, "
            + NIM + " TEXT, "
            + IPK + " INT, "
            + FAKULTAS + " TEXT" + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXIST" + TABLE_NAME);
    onCreate(db);

    }
}
