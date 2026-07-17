    package model;

    import service.Laporan;

    public class KasKeluar extends Transaksi implements Laporan{

        private String keperluan;

        public KasKeluar() {
        }

        public KasKeluar(int id,String tanggal,double nominal,String keperluan) {

            super(id,tanggal,nominal);
            this.keperluan = keperluan;

        }

        public String getKeperluan() {
            return keperluan;
        }

        public void setKeperluan(String keperluan) {
            this.keperluan = keperluan;
        }

        @Override
        public void tampilData() {

            System.out.println("Riwayat Kas Keluar");

        }

    }