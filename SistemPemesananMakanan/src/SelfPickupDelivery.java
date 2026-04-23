public class SelfPickupDelivery implements DeliveryStrategy {

    @Override
    public double hitungOngkir(double jarakKm) { return 0; }

    @Override
    public String getNamaLayanan() { return "Self Pickup"; }

    @Override
    public String getDeskripsiLayanan() {
        return "Ambil sendiri di restoran, GRATIS ongkir";
    }
}
