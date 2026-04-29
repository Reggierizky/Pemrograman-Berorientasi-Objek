import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // INPUT STUDENT
        System.out.println("=== INPUT STUDENT ===");
        System.out.print("Nama: ");
        String namaS = sc.nextLine();

        System.out.print("Address: ");
        String addrS = sc.nextLine();

        Student s = new Student(namaS, addrS);

        System.out.print("Jumlah Mata Kuliah: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Nama MK: ");
            String mk = sc.nextLine();

            System.out.print("Nilai: ");
            int nilai = sc.nextInt();
            sc.nextLine();

            s.addCourseGrade(mk, nilai);
        }

        System.out.println("\nData Student:");
        System.out.println(s);
        s.printGrades();
        System.out.println("Rata-rata: " + s.getAverageGrade());

        // INPUT TEACHER
        System.out.println("\n=== INPUT TEACHER ===");
        System.out.print("Nama: ");
        String namaT = sc.nextLine();

        System.out.print("Address: ");
        String addrT = sc.nextLine();

        Teacher t = new Teacher(namaT, addrT);

        System.out.print("Jumlah Mata Kuliah yang diajar: ");
        int m = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < m; i++) {
            System.out.print("Nama MK: ");
            String mk = sc.nextLine();

            if (t.addCourse(mk)) {
                System.out.println("Berhasil ditambahkan");
            } else {
                System.out.println("Gagal (sudah ada)");
            }
        }

        System.out.println("\nData Teacher:");
        System.out.println(t);
    }
}