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
        super.tampilkanInfo();

        System.out.println("Ukuran Frame: " + ukuranFrame);
        System.out.println("Jumlah Gear: " + jumlahGear);
    }
}
