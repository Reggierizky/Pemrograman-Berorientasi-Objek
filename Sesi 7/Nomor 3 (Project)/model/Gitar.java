package model;

import service.Mainkan;

public class Gitar extends AlatMusik implements Mainkan {

    public Gitar(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan cara strumming atau memetik senar.");
    }

    public void bunyi() {
        System.out.println("jreng jreng...");
    }
}