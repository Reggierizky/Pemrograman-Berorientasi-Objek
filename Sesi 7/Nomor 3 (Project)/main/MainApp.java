package main;

import java.util.Scanner;
import model.*;

public class MainApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Gitar gitar = new Gitar("Gitar");
        Drum drum = new Drum("Drum");
        Bass bass = new Bass("Bass");
        Piano piano = new Piano("Piano");
        Biola biola = new Biola("Biola");
        Saxophone sax = new Saxophone("Saxophone");

        int pilih;

        System.out.println("==================================");
        System.out.println("   APLIKASI BELAJAR ALAT MUSIK");
        System.out.println("==================================");

        do {
            System.out.println();
            System.out.println("===== MENU ALAT MUSIK =====");
            System.out.println("1. Gitar");
            System.out.println("2. Drum");
            System.out.println("3. Bass");
            System.out.println("4. Piano");
            System.out.println("5. Biola");
            System.out.println("6. Saxophone");
            System.out.println("7. Tips Bermain Musik");
            System.out.println("8. Keluar");
            System.out.print("Pilih : ");

            pilih = input.nextInt();
            System.out.println();

            switch (pilih) {

                case 1:
                    gitar.caraMain();
                    gitar.bunyi();
                    System.out.println();
                    break;

                case 2:
                    drum.caraMain();
                    drum.bunyi();
                    System.out.println();
                    break;

                case 3:
                    bass.caraMain();
                    bass.bunyi();
                    System.out.println();
                    break;

                case 4:
                    piano.caraMain();
                    piano.bunyi();
                    System.out.println();
                    break;

                case 5:
                    biola.caraMain();
                    biola.bunyi();
                    System.out.println();
                    break;

                case 6:
                    sax.caraMain();
                    sax.bunyi();
                    System.out.println();
                    break;

                case 7:
                    System.out.println("===== TIPS BERMAIN MUSIK =====");
                    System.out.println("- Latihan rutin setiap hari");
                    System.out.println("- Jaga tempo saat bermain");
                    System.out.println("- Fokus pada teknik dasar");
                    System.out.println("- Nikmati proses belajar");
                    System.out.println("- Enjoy!");
                    break;

                case 8:
                    System.out.println("Terima kasih telah menggunakan aplikasi.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilih != 8);

        input.close();
    }
}