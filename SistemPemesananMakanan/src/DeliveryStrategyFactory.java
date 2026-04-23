public class DeliveryStrategyFactory {

    public static DeliveryStrategy create(String jenis) {
        switch (jenis.toLowerCase()) {
            case "reguler":
            case "1":
                return new RegularDelivery();
            case "express":
            case "2":
                return new ExpressDelivery();
            case "pickup":
            case "selfpickup":
            case "3":
                return new SelfPickupDelivery();
            default:
                throw new IllegalArgumentException("Jenis pengiriman tidak dikenal: " + jenis);
        }
    }

    public static void tampilkanOpsi() {
        System.out.println("  [1] Reguler  - Rp2.000/km, estimasi 45-60 menit");
        System.out.println("  [2] Express  - Rp4.000/km, estimasi 15-30 menit");
        System.out.println("  [3] Pickup   - Gratis, ambil sendiri");
    }
}
