package model;

public class Anggota {

    private int idAnggota;
    private String nama;
    private String kelas;

    public Anggota() {
    }

    public Anggota(int idAnggota, String nama, String kelas) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.kelas = kelas;
    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}