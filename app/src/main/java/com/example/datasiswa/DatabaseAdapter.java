package com.example.datasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private DatabaseHelper databaseHelper;

    public DatabaseAdapter(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public void insertIntoDatabase(Siswa siswa) {
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.NAMA, siswa.getNamaSiswa());
        contentValues.put(DatabaseHelper.NIM, siswa.getNimSiswa());
        contentValues.put(DatabaseHelper.IPK, siswa.getIpkSiswa());
        contentValues.put(DatabaseHelper.FAKULTAS, siswa.getFakultasSiswa());

        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();

    }

    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = new ArrayList<>();

        String[] getColumn = {DatabaseHelper.ROW_ID,
                DatabaseHelper.NAMA,
                DatabaseHelper.NIM,
                DatabaseHelper.IPK,
                DatabaseHelper.FAKULTAS};

        SQLiteDatabase sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.query(DatabaseHelper.TABLE_NAME, getColumn, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String namaSiswa = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NAMA));
                String nimSiswa = cursor.getString(cursor.getColumnIndex(DatabaseHelper.NIM));
                String ipkSiswa = cursor.getString(cursor.getColumnIndex(DatabaseHelper.IPK));
                String fakultasSiswa = cursor.getString(cursor.getColumnIndex(DatabaseHelper.FAKULTAS));
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.ROW_ID));

                Siswa siswa = new Siswa(id, namaSiswa, nimSiswa, ipkSiswa, fakultasSiswa);
                siswaList.add(siswa);

            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return siswaList;

    }
    public Boolean updateFromDatabase(Siswa siswa){

        SQLiteDatabase database = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.ROW_ID, siswa.getId());
        contentValues.put(DatabaseHelper.NAMA, siswa.getNamaSiswa());
        contentValues.put(DatabaseHelper.NIM, siswa.getNimSiswa());
        contentValues.put(DatabaseHelper.IPK, siswa.getIpkSiswa());
        contentValues.put(DatabaseHelper.FAKULTAS, siswa.getFakultasSiswa());

        database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.ROW_ID + " =?",new String[]{String.valueOf(siswa.getId())});
        database.close();

        return null;
    }

}