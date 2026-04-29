public class Mahasiswa {
     String nim;
    String nama;
    int nilai;
    String grade;
    boolean lulus;

    public Mahasiswa(String nim, String nama, int nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
        setGrade();
    }

    void setGrade() {
        if (nilai >= 80 && nilai <= 100) {
            grade = "A"; lulus = true;
        } else if (nilai >= 70) {
            grade = "B"; lulus = true;
        } else if (nilai >= 60) {
            grade = "C"; lulus = true;
        } else if (nilai >= 50) {
            grade = "D"; lulus = false;
        } else if (nilai >= 0) {
            grade = "E"; lulus = false;
        } else {
            grade = "Input nilai anda salah";
            lulus = false;
        }
    }

    void tampil() {
        System.out.println("NIM   : " + nim);
        System.out.println("Nama  : " + nama);
        System.out.println("Nilai : " + nilai);
        System.out.println("Grade : " + grade);
        System.out.println("=====================================");
    }
}
