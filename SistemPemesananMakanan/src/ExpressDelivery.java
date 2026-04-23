public class ExpressDelivery implements DeliveryStrategy {
    private static final double TARIF_PER_KM = 4000;
    private static final double TARIF_MINIMUM = 10000;

    @Override
    public double hitungOngkir(double jarakKm) {
        double ongkir = jarakKm * TARIF_PER_KM;
        return Math.max(ongkir, TARIF_MINIMUM);
    }

    @Override
    public String getNamaLayanan() { return "Express"; }

    @Override
    public String getDeskripsiLayanan() {
        return "Pengiriman cepat (estimasi 15-30 menit), Rp4.000/km, min Rp10.000";
    }
}
