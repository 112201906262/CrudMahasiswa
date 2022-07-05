package com.example.datasiswa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button saveBtn, showBtn;
    EditText namaET, nimET, ipkET, fakultasET;
    String namaSiswa, nimSiswa, fakultasSiswa;
    int ipkSiswa;
    Siswa siswaModel;

    List<Siswa> siswaList;
    DatabaseAdapter databaseAdapter;
    AdapterSiswa adapterSiswa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namaET = findViewById(R.id.nama_ET);
        nimET = findViewById(R.id.nim_ET);
        ipkET = findViewById(R.id.ipk_ET);
        fakultasET = findViewById(R.id.fakultas_ET);
        saveBtn = findViewById(R.id.save_button);
        showBtn = findViewById(R.id.show_button);

        databaseAdapter = new DatabaseAdapter(this);
        siswaList = databaseAdapter.getAllSiswa();
        adapterSiswa = new AdapterSiswa(this, siswaList);

        siswaModel = (Siswa) getIntent().getSerializableExtra("Siswa");
        if (siswaModel != null) {
            saveBtn.setText("Update");
            namaET.setText(siswaModel.getNamaSiswa());
            nimET.setText(siswaModel.getNimSiswa());
            ipkET.setText(siswaModel.getIpkSiswa());
            fakultasET.setText(siswaModel.getFakultasSiswa());
        }

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (siswaModel != null) {
                    String updatedNama = namaET.getText().toString();
                    String updatedNim = nimET.getText().toString();
                    int updatedIpk = Integer.parseInt(ipkET.getText().toString());
                    String updatedFakultas = fakultasET.getText().toString();
                    int id = siswaModel.getId();

                    Siswa updatedSiswa = new Siswa(id, updatedNama, updatedNim, updatedIpk, updatedFakultas);
                    Boolean updatedStatus = databaseAdapter.updateFromDatabase(updatedSiswa);

//                   if (updatedStatus){
//                       Toast.makeText(MainActivity.this, "updated Succesfully", Toast.LENGTH_SHORT).show();
//                   }else Toast.makeText(MainActivity.this, "cant Update", Toast.LENGTH_SHORT).show();

                } else
                    saveSiswa();
                emptyfield();
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }


    private void saveSiswa() {
        boolean error = false;
        namaSiswa = namaET.getText().toString().trim();
        if (namaSiswa.isEmpty()) {
            namaET.setError("Silahkan masukkan nama anda disini !");
            error = true;
        } else {
            error = false;
        }
        nimSiswa = nimET.getText().toString().trim();
        if (nimSiswa.isEmpty()) {
            nimET.setError("NIM tidak boleh kosong !");
            error = true;
        } else if (nimSiswa.length() == 14) {
            if (nimSiswa.startsWith("A1") || nimSiswa.startsWith("B1") || nimSiswa.startsWith("C1")) {
                error = false;
            } else {
                nimET.setError("Silahkan masukkan NIM siswa");
                error = true;
            }
        }

        ipkSiswa = Integer.parseInt(ipkET.getText().toString().trim());
        if (ipkSiswa == Integer.parseInt(null)) {
            ipkET.setError("Silahkan masukkan IPK !");
            error = true;
        } else {
            error = false;
        }

        fakultasSiswa = fakultasET.getText().toString().trim();
        if (fakultasSiswa.isEmpty()) {
            fakultasET.setError("Silahkan masukkan nama fakultas !");
            error = true;
        } else {
            error = false;
        }

        if (error) {
            Toast.makeText(MainActivity.this, "Data yang anda masukkan salah", Toast.LENGTH_SHORT).show();
        } else {
            Siswa siswa = new Siswa(namaSiswa, nimSiswa, ipkSiswa, fakultasSiswa);
            databaseAdapter.insertIntoDatabase(siswa);
            Toast.makeText(MainActivity.this, "Data berhasil di tambahkan", Toast.LENGTH_SHORT).show();
        }

    }


    private void emptyfield() {
        namaET.setText("");
        nimET.setText("");
        ipkET.setText("");
        fakultasET.setText("");
    }

}