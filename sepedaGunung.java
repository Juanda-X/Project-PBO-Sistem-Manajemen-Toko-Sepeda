public class sepedaGunung extends Sepeda {
    private int ukuranRoda;
    private String jenisSuspensi;

    public sepedaGunung(String nama, String merk, double harga, int stok, int ukuranRoda, String jenisSuspensi) {
        
        super(nama, merk, harga, stok);

        this.ukuranRoda = ukuranRoda;
        this.jenisSuspensi = jenisSuspensi;

    }

@Override
public void tampilkanInfo() {
    super.tampilkanInfo();

    System.out.println("Ukuran Roda: " + ukuranRoda);
    System.out.println("Jenis Suspensi: " + jenisSuspensi);

    }

}
