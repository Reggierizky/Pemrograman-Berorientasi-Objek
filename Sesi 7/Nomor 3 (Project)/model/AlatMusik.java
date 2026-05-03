package model;

public abstract class AlatMusik {

    private String nama;

    public AlatMusik(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public abstract void caraMain();
}