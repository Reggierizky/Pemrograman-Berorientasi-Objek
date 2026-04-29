import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<Mahasiswa> list = new ArrayList<>();

        int totalNilai = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nData Mahasiswa ke-" + (i + 1));

            System.out.print("NIM   : ");
            String nim = sc.nextLine();

            System.out.print("Nama  : ");
            String nama = sc.nextLine();

            System.out.print("Nilai : ");
            int nilai = sc.nextInt();
            sc.nextLine();

            Mahasiswa m = new Mahasiswa(nim, nama, nilai);
            list.add(m);

            totalNilai += nilai;
        }

        System.out.println("\n===== DATA MAHASISWA =====");
        for (Mahasiswa m : list) {
            m.tampil();
        }

        double rata = (double) totalNilai / n;
        System.out.println("Rata-rata nilai: " + rata);
    }
}