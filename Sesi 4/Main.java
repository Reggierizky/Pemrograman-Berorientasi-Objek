public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        System.out.println("=== OVERLOADING ===");
        bank.transferUang(100000, "193505");
        bank.transferUang(200000, "827863", "BNI");
        bank.transferUang(300000, "847242", "BCA", "Bayar Hutang");
        bank.sukuBunga();

        System.out.println("\n=== OVERRIDING BNI ===");
        BankBNI bni = new BankBNI();
        bni.transferUang(500000, "22222", "BNI");
        bni.sukuBunga();

        System.out.println("\n=== OVERRIDING BCA ===");
        BankBCA bca = new BankBCA();
        bca.transferUang(700000, "33333", "BCA");
        bca.sukuBunga();
    }
}