import java.text.NumberFormat;
import java.util.Locale;

public class Sepeda {
    private String nama;
    private String merk;
    private double harga;
    private int stok;

    private static int totalSepeda = 0;

    public Sepeda(String nama, String merk, double harga, int stok) {
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.stok = stok;

        totalSepeda++;
    }

// Getter
    public String getNama() {
        return nama;
    }

    public String getMerk() {
        return merk;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

//Setter
    public void setNama(String nama) {
        if (nama != null && !nama.isEmpty()) {
            this.nama = nama;
        }
    }

    public void setMerk(String merk) {
        if (merk != null && !merk.isEmpty()) {
            this.merk = merk;
        }
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        }
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        }
    }

// Static Method
    public static int getTotalSepeda() {
        return totalSepeda;
    }

//Overloading
    public boolean cariSepeda(String nama) {
        return this.nama.equalsIgnoreCase(nama);    
    }

    public boolean cariSepeda(int stok) {
        return this.stok == stok;
    }

// Override Oleh Subclass
    public void tampilkanInfo() {
        NumberFormat formatRupiah = NumberFormat.getNumberInstance(new Locale("id", "ID"));

        System.out.println("Nama Sepeda: " + nama);
        System.out.println("Merk: " + merk);
        System.out.printf("Harga: Rp. " + formatRupiah.format(harga));
        System.out.println("\nStok: " + stok);
    }

    public boolean kurangiStok(int jumlah) {
        if(jumlah <= 0 || jumlah > stok) {
            return false;
        } 

        stok -= jumlah;
        return true;
    }

}
