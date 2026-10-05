public class sepedaLipat extends Sepeda{
    private int ukuranRoda;
    private String mekanismeLipat;

    public sepedaLipat(String nama, String merk, double harga, int stok, int ukuranRoda, String mekanismeLipat) {
        super(nama, merk, harga, stok);

        this.ukuranRoda = ukuranRoda;
        this.mekanismeLipat = mekanismeLipat;
    }
@Override
    public void tampilkanInfo() {
        super.tampilkanInfo();

        System.out.println("Ukuran Roda: " + ukuranRoda);
        System.out.println("Mekanisme Lipat: " + mekanismeLipat);
    }

}
