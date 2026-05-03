package model;

import service.Mainkan;

public class Drum extends AlatMusik implements Mainkan {

    public Drum(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan cara dipukul menggunakan stik drum.");
    }

    public void bunyi() {
        System.out.println("dum tak dum...");
    }
}