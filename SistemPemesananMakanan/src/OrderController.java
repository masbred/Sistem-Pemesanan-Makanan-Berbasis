import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class OrderController {
    private MenuRepository menuRepository;
    private List<Order> daftarPesanan;

    public OrderController() {
        this.menuRepository = new MenuRepository();
        this.daftarPesanan = new ArrayList<>();
    }

    public void buatPesanan(Scanner scanner) {
        System.out.println("\n====== BUAT PESANAN BARU ======");

        // Input nama pelanggan
        System.out.print("Nama pelanggan: ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("[!] Nama tidak boleh kosong.");
            return;
        }

        // Pilih jenis pengiriman
        System.out.println("\nPilih Jenis Pengiriman:");
        DeliveryStrategyFactory.tampilkanOpsi();
        System.out.print("Pilihan (1/2/3): ");
        String jenisDelivery = scanner.nextLine().trim();

        DeliveryStrategy strategy;
        try {
            strategy = DeliveryStrategyFactory.create(jenisDelivery);
        } catch (IllegalArgumentException e) {
            System.out.println("[!] Jenis pengiriman tidak valid.");
            return;
        }

        System.out.println(">> Layanan dipilih: " + strategy.getNamaLayanan());
        System.out.println("   " + strategy.getDeskripsiLayanan());

        // Input jarak
        double jarak = 0;
        if (!(strategy instanceof SelfPickupDelivery)) {
            System.out.print("Masukkan jarak pengiriman (km): ");
            try {
                jarak = Double.parseDouble(scanner.nextLine().trim());
                if (jarak <= 0) {
                    System.out.println("[!] Jarak harus lebih dari 0.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("[!] Jarak tidak valid.");
                return;
            }
        }

        Order order = new Order(nama, strategy, jarak);

        // Pilih makanan
        menuRepository.tampilkanMenu();
        boolean memilih = true;
        while (memilih) {
            System.out.print("\nNomor menu yang dipesan (0 = selesai): ");
            String inputMenu = scanner.nextLine().trim();
            int nomorMenu;
            try {
                nomorMenu = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                System.out.println("[!] Input tidak valid.");
                continue;
            }

            if (nomorMenu == 0) {
                if (order.getItems().isEmpty()) {
                    System.out.println("[!] Pesanan kosong, minimal pilih 1 item.");
                    continue;
                }
                memilih = false;
            } else {
                MenuItem menu = menuRepository.getMenuByIndex(nomorMenu - 1);
                if (menu == null) {
                    System.out.println("[!] Nomor menu tidak tersedia.");
                    continue;
                }
                System.out.print("Jumlah " + menu.getNama() + ": ");
                try {
                    int jumlah = Integer.parseInt(scanner.nextLine().trim());
                    if (jumlah <= 0) {
                        System.out.println("[!] Jumlah harus lebih dari 0.");
                        continue;
                    }
                    order.tambahItem(new OrderItem(menu, jumlah));
                    System.out.println(">> " + menu.getNama() + " x" + jumlah + " ditambahkan.");
                } catch (NumberFormatException e) {
                    System.out.println("[!] Jumlah tidak valid.");
                }
            }
        }

        // Simpan dan tampilkan struk
        daftarPesanan.add(order);
        order.tampilkanStruk();
        System.out.println("\n[✓] Pesanan berhasil dibuat!");
    }

    public void tampilkanSemuaPesanan() {
        if (daftarPesanan.isEmpty()) {
            System.out.println("\n[!] Belum ada pesanan.");
            return;
        }
        System.out.println("\n====== SEMUA PESANAN ======");
        for (Order order : daftarPesanan) {
            System.out.printf("%-10s | %-15s | %-10s | Total: Rp%.0f%n",
                order.getOrderId(),
                order.getNamaPelanggan(),
                order.getDeliveryStrategy().getNamaLayanan(),
                order.getTotalBayar());
        }
        System.out.println("Total pesanan: " + daftarPesanan.size());
    }
}
