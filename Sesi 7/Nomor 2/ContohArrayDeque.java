import java.util.ArrayDeque;

public class ContohArrayDeque {
    public static void main(String[] args) {
        // Membuat ArrayDeque
        ArrayDeque<String> antrian = new ArrayDeque<>();

        // Menambahkan data (enqueue)
        antrian.add("Reggie");
        antrian.add("Asep");
        antrian.add("Saipul");

        // Menampilkan isi antrian
        System.out.println("Isi antrian:");
        System.out.println(antrian);

        // Mengambil dan menghapus elemen pertama (dequeue)
        System.out.println("Diproses: " + antrian.poll());

        // Menampilkan antrian setelah diproses
        System.out.println("Sisa antrian:");
        System.out.println(antrian);

        // Menambahkan di depan (seperti stack)
        antrian.addFirst("Dina");

        System.out.println("Setelah tambah di depan:");
        System.out.println(antrian);
    }
}