import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int counter = 1;

    private String orderId;
    private String namaPelanggan;
    private List<OrderItem> items;
    private DeliveryStrategy deliveryStrategy;
    private double jarakKm;

    public Order(String namaPelanggan, DeliveryStrategy deliveryStrategy, double jarakKm) {
        this.orderId = "ORD-" + String.format("%03d", counter++);
        this.namaPelanggan = namaPelanggan;
        this.deliveryStrategy = deliveryStrategy;
        this.jarakKm = jarakKm;
        this.items = new ArrayList<>();
    }

    public void tambahItem(OrderItem item) {
        items.add(item);
    }

    public double getTotalMakanan() {
        return items.stream().mapToDouble(OrderItem::getSubtotal).sum();
    }

    public double getOngkir() {
        return deliveryStrategy.hitungOngkir(jarakKm);
    }

    public double getTotalBayar() {
        return getTotalMakanan() + getOngkir();
    }

    public String getOrderId() { return orderId; }
    public String getNamaPelanggan() { return namaPelanggan; }
    public List<OrderItem> getItems() { return items; }
    public DeliveryStrategy getDeliveryStrategy() { return deliveryStrategy; }
    public double getJarakKm() { return jarakKm; }

    public void tampilkanStruk() {
        System.out.println("\n======================================");
        System.out.println("           STRUK PESANAN              ");
        System.out.println("======================================");
        System.out.println("Order ID    : " + orderId);
        System.out.println("Pelanggan   : " + namaPelanggan);
        System.out.println("Pengiriman  : " + deliveryStrategy.getNamaLayanan());
        if (jarakKm > 0) {
            System.out.printf("Jarak       : %.1f km%n", jarakKm);
        }
        System.out.println("----------------------------------------");
        System.out.println("ITEM PESANAN:");
        for (OrderItem item : items) {
            System.out.println("  " + item);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Subtotal    : Rp%.0f%n", getTotalMakanan());
        System.out.printf("Ongkir      : Rp%.0f%n", getOngkir());
        System.out.println("========================================");
        System.out.printf("TOTAL BAYAR : Rp%.0f%n", getTotalBayar());
        System.out.println("========================================");
    }
}
