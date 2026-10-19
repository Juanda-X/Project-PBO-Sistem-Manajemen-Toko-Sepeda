public class sepedaLipat extends Sepeda implements ujiCoba{
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

@Override 
public void panduanPerawatan() {
    System.out.println("Panduan perawatan: Berikan pelumas pada engsel sepeda lipat secara berkala");
}

@Override 
public void ujiCobaLintasan() {
    System.out.println("Uji Coba: Uji pada mekanisme buka tutup pada sepeda lipat.");
}

}
