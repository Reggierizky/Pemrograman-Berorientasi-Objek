class BankBNI extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BNI adalah 4%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya("BNI");

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank BNI");
        System.out.println("Biaya transfer: " + biaya);
    }
}