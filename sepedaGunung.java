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
    System.out.println("Jenis: Sepeda Gunung (MTB)");
    System.out.println("Nama Sepeda: " + getNama());
    System.out.println("Merk: " + getMerk());
    System.out.printf("Harga: Rp. %.f0\n", getHarga());
    System.out.println("Stok Tersedia: " + getStok());
    System.out.println("Ukuran Roda: " + ukuranRoda);
    System.out.println("Jenis Suspensi: " + jenisSuspensi);

    }

}
