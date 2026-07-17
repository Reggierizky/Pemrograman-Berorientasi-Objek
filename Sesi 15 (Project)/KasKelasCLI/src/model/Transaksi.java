package model;

public abstract class Transaksi {

    protected int id;
    protected String tanggal;
    protected double nominal;

    public Transaksi() {
    }

    public Transaksi(int id, String tanggal, double nominal) {
        this.id = id;
        this.tanggal = tanggal;
        this.nominal = nominal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }
}