public class sepedaBalap extends Sepeda implements servis, ujiCoba{
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

@Override 
public void panduanPerawatan() {
    System.out.println("Panduan Perawatan: lumasi rantai dan cek crank serta gear secara berkala");
}

@Override
public void servisRutin() {
    System.out.println("Servis: Kalibrasi ulang sistem tranmisi (Non Fixed Gear), serta pengecekan gear dan crank pada sepeda balap.");
}

@Override 
public void ujiCobaLintasan() {
    System.out.println("Uji Coba: Sepeda diuji coba untuk penyesuaian kalibrasi sepeda.");
}

}
