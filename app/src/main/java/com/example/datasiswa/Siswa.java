package com.example.datasiswa;

import java.io.Serializable;

class Siswa implements Serializable {
    private int id;
    private String namaSiswa;
    private String nimSiswa;
    private int ipkSiswa;
    private String fakultasSiswa;

    public Siswa(String namaSiswa, String nimSiswa, int ipkSiswa, String fakultasSiswa) {
        this.namaSiswa = namaSiswa;
        this.nimSiswa = nimSiswa;
        this.ipkSiswa = ipkSiswa;
        this.fakultasSiswa = fakultasSiswa;
    }

    public Siswa(int id, String namaSiswa, String nimSiswa, int ipkSiswa, String fakultasSiswa) {
        this.id = id;
        this.namaSiswa = namaSiswa;
        this.nimSiswa = nimSiswa;
        this.ipkSiswa = ipkSiswa;
        this.fakultasSiswa = fakultasSiswa;
    }

    public Siswa(int id, String namaSiswa, String nimSiswa, String ipkSiswa, String fakultasSiswa) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaSiswa() {
        return namaSiswa;
    }

    public void setNamaSiswa(String namaSiswa) {
        this.namaSiswa = namaSiswa;
    }

    public String getNimSiswa() {
        return nimSiswa;
    }

    public void setNimSiswa(String nimSiswa) {
        this.nimSiswa = nimSiswa;
    }

    public int getIpkSiswa() {
        return ipkSiswa;
    }

    public void setIpkSiswa(int ipkSiswa) {
        this.ipkSiswa = ipkSiswa;
    }

    public String getFakultasSiswa() {
        return fakultasSiswa;
    }

    public void setFakultasSiswa(String fakultasSiswa) {
        this.fakultasSiswa = fakultasSiswa;
    }
}
