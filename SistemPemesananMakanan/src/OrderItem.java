public class OrderItem {
    private MenuItem menuItem;
    private int jumlah;

    public OrderItem(MenuItem menuItem, int jumlah) {
        this.menuItem = menuItem;
        this.jumlah = jumlah;
    }

    public double getSubtotal() {
        return menuItem.getHarga() * jumlah;
    }

    public MenuItem getMenuItem() { return menuItem; }
    public int getJumlah() { return jumlah; }

    @Override
    public String toString() {
        return String.format("%-20s x%d  = Rp%.0f",
            menuItem.getNama(), jumlah, getSubtotal());
    }
}
