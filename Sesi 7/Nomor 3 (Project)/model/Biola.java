package model;

import service.Mainkan;

public class Biola extends AlatMusik implements Mainkan {

    public Biola(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan digesek.");
    }

    public void bunyi() {
        System.out.println("ngiiing...");
    }
}