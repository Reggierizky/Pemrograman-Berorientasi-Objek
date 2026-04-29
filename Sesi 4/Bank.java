class Bank {

    // BONUS: hitung biaya transfer berdasarkan bank tujuan
    int hitungBiaya(String bankTujuan) {
        if (bankTujuan.equalsIgnoreCase("BNI")) {
            return 4000;
        } else if (bankTujuan.equalsIgnoreCase("BCA")) {
            return 6500;
        } else {
            return 5000; // bank lain
        }
    }

    // 1. Transfer biasa
    void transferUang(int jumlah, String rekeningTujuan) {
        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan);
    }

    // 2. Transfer beda bank (PAKAI BONUS)
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya(bankTujuan);

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan);
        System.out.println("Biaya transfer: " + biaya);
    }

    // 3. Transfer + berita (PAKAI BONUS)
    void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiaya(bankTujuan);

        System.out.println("Transfer " + jumlah + " ke rekening " + rekeningTujuan +
                " di bank " + bankTujuan);
        System.out.println("Berita: " + berita);
        System.out.println("Biaya transfer: " + biaya);
    }

    // 4. Suku bunga standar
    void sukuBunga() {
        System.out.println("Suku bunga standar adalah 3%");
    }
}