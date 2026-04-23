import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private List<MenuItem> daftarMenu;

    public MenuRepository() {
        daftarMenu = new ArrayList<>();
        inisialisasiMenu();
    }

    private void inisialisasiMenu() {
        // Makanan Utama
        daftarMenu.add(new MenuItem("Nasi Goreng Spesial", 25000, "Makanan Utama"));
        daftarMenu.add(new MenuItem("Ayam Bakar", 30000, "Makanan Utama"));
        daftarMenu.add(new MenuItem("Mie Goreng", 20000, "Makanan Utama"));
        daftarMenu.add(new MenuItem("Soto Ayam", 22000, "Makanan Utama"));
        daftarMenu.add(new MenuItem("Gado-Gado", 18000, "Makanan Utama"));

        // Minuman
        daftarMenu.add(new MenuItem("Es Teh Manis", 5000, "Minuman"));
        daftarMenu.add(new MenuItem("Jus Alpukat", 15000, "Minuman"));
        daftarMenu.add(new MenuItem("Air Mineral", 3000, "Minuman"));
        daftarMenu.add(new MenuItem("Kopi Hitam", 8000, "Minuman"));

        // Snack
        daftarMenu.add(new MenuItem("Kerupuk Udang", 5000, "Snack"));
        daftarMenu.add(new MenuItem("Tempe Goreng", 7000, "Snack"));
        daftarMenu.add(new MenuItem("Pisang Goreng", 10000, "Snack"));
    }

    public List<MenuItem> getDaftarMenu() {
        return daftarMenu;
    }

    public MenuItem getMenuByIndex(int index) {
        if (index < 0 || index >= daftarMenu.size()) {
            return null;
        }
        return daftarMenu.get(index);
    }

    public void tampilkanMenu() {
        System.out.println("\n====== DAFTAR MENU ======");
        System.out.printf("%-4s %-20s %-15s %-12s%n", "No", "Nama", "Kategori", "Harga");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < daftarMenu.size(); i++) {
            System.out.printf("%-4d %s%n", (i + 1), daftarMenu.get(i));
        }
        System.out.println("--------------------------------------------------");
    }
}
