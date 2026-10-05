public class sepedaBalap extends Sepeda {
    private String ukuranFrame;
    private int jumlahGear;

    public sepedaBalap(String nama, String merk, double harga, int stok, String ukuranFrame, int jumlahGear) {
        super(nama, merk, harga, stok);

        this.ukuranFrame = ukuranFrame;
        this.jumlahGear = jumlahGear;

    }
@Override
    public void tampilkanInfo() {
        System.out.println("Jenis: Sepeda Balap (Road Bike / Fixie)");
        System.out.println("Nama Sepeda: " + getNama());
        System.out.println("Merk: " + getMerk());
        System.out.printf("Harga: Rp. %.0f\n", getHarga());
        System.out.println("Stok Tersedia: " + getStok());
        System.out.println("Ukuran Frame: " + ukuranFrame);
        System.out.println("Jumlah Gear: " + jumlahGear);
    }
}
