package model;

import service.Mainkan;

public class Bass extends AlatMusik implements Mainkan {

    public Bass(String nama) {
        super(nama);
    }

    public void caraMain() {
        System.out.println(getNama() + " dimainkan dengan dipetik atau menggunakan pick.");
    }

    public void bunyi() {
        System.out.println("boom boom...");
    }
}