package model;

import service.Laporan;

public class KasMasuk extends Transaksi implements Laporan{

    private int idAnggota;

    public KasMasuk() {
    }

    public KasMasuk(int id, String tanggal,double nominal,int idAnggota) {

        super(id,tanggal,nominal);
        this.idAnggota = idAnggota;

    }

    public int getIdAnggota() {
        return idAnggota;
    }

    public void setIdAnggota(int idAnggota) {
        this.idAnggota = idAnggota;
    }

    @Override
    public void tampilData() {

        System.out.println("Riwayat Kas Masuk");

    }

}