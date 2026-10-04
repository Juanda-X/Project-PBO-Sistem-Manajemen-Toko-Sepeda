public class sepedaLipat extends Sepeda{
    private int ukuranRoda;
    private String mekanismeLipat;

    public sepedaLipat(String nama, String merk, double harga, int stok, int ukuranRoda, String mekanismeLipat) {
        super(nama, merk, harga, stok);

        this.ukuranRoda = ukuranRoda;
        this.mekanismeLipat =mekanismeLipat;
    }
@Override
    public void tampilkanInfo() {
        System.out.println("Jenis: Sepeda Lipat (Foldeing Bike");
        System.out.println("Nama Sepeda: " + getNama());
        System.out.println("Merk: " + getMerk());
        System.out.println("Harga: Rp. " + getHarga());
        System.out.println("Stok Tersedia: " + getStok());
        System.out.println("Ukuran Roda: " + ukuranRoda);
        System.out.println("Mekanisme Lipat: " + mekanismeLipat);
    }

}
