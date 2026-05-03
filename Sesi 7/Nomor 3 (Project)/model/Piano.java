package model;

import service.Mainkan;

public class Piano extends AlatMusik implements Mainkan {

    public Piano(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan menekan tuts.");
    }

    public void bunyi() {
        System.out.println("ting tong...");
    }
}