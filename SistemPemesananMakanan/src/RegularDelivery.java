public class RegularDelivery implements DeliveryStrategy {
    private static final double TARIF_PER_KM = 2000;
    private static final double TARIF_MINIMUM = 5000;

    @Override
    public double hitungOngkir(double jarakKm) {
        double ongkir = jarakKm * TARIF_PER_KM;
        return Math.max(ongkir, TARIF_MINIMUM);
    }

    @Override
    public String getNamaLayanan() { return "Reguler"; }

    @Override
    public String getDeskripsiLayanan() {
        return "Pengiriman standar (estimasi 45-60 menit), Rp2.000/km, min Rp5.000";
    }
}
