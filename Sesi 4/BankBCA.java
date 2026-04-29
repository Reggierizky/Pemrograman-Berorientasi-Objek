class BankBCA extends Bank {

    @Override
    void sukuBunga() {
        System.out.println("Suku bunga BCA adalah 4.5%");
    }

    @Override
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya("BCA");

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank BCA");
        System.out.println("Biaya transfer: " + biaya);
    }
}