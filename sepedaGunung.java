public class sepedaGunung extends Sepeda implements servis {
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

@Override 
public void panduanPerawatan() {
    System.out.println("Panduan Perawatan: Bersihkan suspensi, crank, dan gear setelah digunakan di medan berlumpur");
}

@Override 
public void servisRutin() {
    System.out.println("Servis: Pengecekan tekanan suspensi hidrolik.");
}

}
