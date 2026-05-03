package model;

import service.Mainkan;

public class Saxophone extends AlatMusik implements Mainkan {

    public Saxophone(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan ditiup.");
    }

    public void bunyi() {
        System.out.println("toot toot...");
    }
}