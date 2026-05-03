package util;

import java.util.ArrayList;

public class Data<T> {

    ArrayList<T> list = new ArrayList<>();

    public void tambah(T data) {
        list.add(data);
    }

    public void tampil() {
        for (T isi : list) {
            System.out.println(isi);
        }
    }
}