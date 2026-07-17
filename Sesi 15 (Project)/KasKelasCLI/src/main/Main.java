package main;

import dao.AnggotaDAO;
import dao.KasKeluarDAO;
import dao.KasMasukDAO;
import java.util.Scanner;
import model.Anggota;
import model.KasKeluar;
import model.KasMasuk;

public class Main {

    static Scanner input = new Scanner(System.in);

    static AnggotaDAO anggotaDAO = new AnggotaDAO();
    static KasMasukDAO kasMasukDAO = new KasMasukDAO();
    static KasKeluarDAO kasKeluarDAO = new KasKeluarDAO();

    public static void tampilMenuUtama() {

        System.out.println("\n===============================");
        System.out.println("      APLIKASI KAS KELAS");
        System.out.println("===============================");
        System.out.println("1. Kelola Anggota");
        System.out.println("2. Kelola Kas Masuk");
        System.out.println("3. Kelola Kas Keluar");
        System.out.println("0. Keluar");
        System.out.println("===============================");
        System.out.print("Pilihan : ");

    }

    public static void menuAnggota() {

        int pilihan;

        do {

            System.out.println("\n===== KELOLA ANGGOTA =====");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Lihat Data Anggota");
            System.out.println("0. Kembali");
            System.out.print("Pilihan : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    Anggota anggota = new Anggota();

                    System.out.print("Nama : ");
                    anggota.setNama(input.nextLine());

                    System.out.print("Kelas : ");
                    anggota.setKelas(input.nextLine());

                    anggotaDAO.tambahAnggota(anggota);

                    break;

                case 2:

                    anggotaDAO.tampilAnggota();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");

            }

        } while (pilihan != 0);

    }

    public static void menuKasMasuk() {

        int pilihan;

        do {

            System.out.println("\n===== KAS MASUK =====");
            System.out.println("1. Tambah Kas Masuk");
            System.out.println("2. Lihat Riwayat Kas Masuk");
            System.out.println("0. Kembali");
            System.out.print("Pilihan : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    KasMasuk masuk = new KasMasuk();

                    System.out.print("ID Anggota : ");
                    masuk.setIdAnggota(input.nextInt());
                    input.nextLine();

                    System.out.print("Tanggal : ");
                    masuk.setTanggal(input.nextLine());

                    System.out.print("Nominal : ");
                    masuk.setNominal(input.nextDouble());
                    input.nextLine();

                    kasMasukDAO.tambahKasMasuk(masuk);

                    break;

                case 2:

                    kasMasukDAO.tampilKasMasuk();
                    kasMasukDAO.tampilTotalSaldo();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");

            }

        } while (pilihan != 0);

    }

    public static void menuKasKeluar() {

        int pilihan;

        do {

            System.out.println("\n===== KAS KELUAR =====");
            System.out.println("1. Tambah Kas Keluar");
            System.out.println("2. Lihat Riwayat Kas Keluar");
            System.out.println("0. Kembali");
            System.out.print("Pilihan : ");

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    KasKeluar keluar = new KasKeluar();

                    System.out.print("Tanggal : ");
                    keluar.setTanggal(input.nextLine());

                    System.out.print("Keperluan : ");
                    keluar.setKeperluan(input.nextLine());

                    System.out.print("Nominal : ");
                    keluar.setNominal(input.nextDouble());
                    input.nextLine();

                    kasKeluarDAO.tambahKasKeluar(keluar);

                    break;

                case 2:

                    kasKeluarDAO.tampilKasKeluar();

                    break;

                case 0:

                    break;

                default:

                    System.out.println("Pilihan tidak tersedia.");

            }

        } while (pilihan != 0);

    }

    public static void main(String[] args) {

        int pilihan;

        do {

            tampilMenuUtama();

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {

                case 1:

                    menuAnggota();

                    break;

                case 2:

                    menuKasMasuk();

                    break;

                case 3:

                    menuKasKeluar();

                    break;

                case 0:

                    System.out.println("\nProgram selesai.");

                    break;

                default:

                    System.out.println("\nPilihan tidak tersedia.");

            }

        } while (pilihan != 0);

    }

}