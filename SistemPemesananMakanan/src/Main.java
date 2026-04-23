import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderController controller = new OrderController();

        System.out.println("==================================");
        System.out.println("     SISTEM PEMESANAN MAKANAN     ");
        System.out.println("         Food Order System        ");
        System.out.println("==================================");

        boolean running = true;
        while (running) {
            System.out.println("\n====== MENU UTAMA ======");
            System.out.println("1. Buat Pesanan Baru");
            System.out.println("2. Lihat Semua Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilihan: ");

            String pilihan = scanner.nextLine().trim();

            switch (pilihan) {
                case "1":
                    controller.buatPesanan(scanner);
                    break;
                case "2":
                    controller.tampilkanSemuaPesanan();
                    break;
                case "3":
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    running = false;
                    break;
                default:
                    System.out.println("[!] Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
