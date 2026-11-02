import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class tokoSepeda {
    private static ArrayList<Sepeda> daftarSepeda = new ArrayList<>();

    private static HashMap<String, String> dataPelanggan = new HashMap<>();

    // Method pembelian sepeda dengan parameter Superclass Sepeda
    public static boolean prosesPembelianOffline(Sepeda sepeda, int jumlahSepedaDibeli) {
        if (!sepeda.kurangiStok(jumlahSepedaDibeli)) {
            System.out.println("Proses Pembelian sepeda gagal! Jumlah pembelian tidak valid atau stok tidak mencukupi.");
            return false;
        }

        System.out.println(" === Proses Pembelian Sepeda === ");
        sepeda.tampilkanInfo();

        System.out.println("\nPembelian Sepeda " + sepeda.getNama() 
        + " sebanyak "+ jumlahSepedaDibeli + " unit" 
        + ", berhasil dilakukan dan akan segera diposes. Terimakasih sudah berbelanja di toko Sepeda FIXFIX.");
        return true;
    }

    public static boolean prosesPembelianOnline(Sepeda sepeda, String alamatPengiriman, int jumlahSepedaDibeli) {
        if (alamatPengiriman == null || alamatPengiriman.trim().isEmpty()) {
            System.out.println("Proses pembelian gagal! Alamat pengiriman harus diisi.");
            return false;
        }

        if (!sepeda.kurangiStok(jumlahSepedaDibeli)) {
            System.out.println("Proses Pembelian sepeda gagal! Jumlah pembelian tidak valid atau stok tidak mencukupi.");
            return false;
        }

        System.out.println(" === Proses Pembelian Sepeda Online === ");
        sepeda.tampilkanInfo();

        System.out.println("\nPembelian Sepeda " + sepeda.getNama()
         + " sebanyak " + jumlahSepedaDibeli +" unit" + ", berhasil dilakukan dan akan segera dikirim ke alamat: " 
         + alamatPengiriman + ". Terimakasih sudah berbelanja di toko Sepeda FIXFIX.");
         return true;
    }

    // Jika stok habis, item dihapus dari system
    public static int hapusSepeda(Sepeda[] sepeda, int jumlahSepeda, int indeks) {
        if (sepeda[indeks].getStok() == 0) {
            System.out.println("Stok sepeda habis. " + sepeda[indeks].getNama() + " dihapus dari system.");

            // geser data ke posisi sebelumnya
            for (int i = indeks; i < jumlahSepeda - 1; i++) {
                sepeda[i] = sepeda[i + 1];
            }
            sepeda[jumlahSepeda - 1] = null;
            jumlahSepeda--;
        }

        return jumlahSepeda;
    }

    public static Sepeda cariSepeda(String nama) throws tokoSepedaException {
        if (nama == null || nama.trim().isEmpty()) {
            throw new tokoSepedaException("Nama sepeda tidak boleh kosong.");
        }

        for (Sepeda item : daftarSepeda) {
            if (item.cariSepeda(nama)) {
                return item;
            }
        }

        throw new tokoSepedaException("Sepeda Tidak Ditemukan.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        boolean running = true;

        System.out.println("======================================");
        System.out.println("Selamat Datang di Toko Sepeda FIXFIX");
        System.out.println("======================================");

        daftarSepeda.add(new sepedaGunung("Polygon Xtrada", "Polygon", 65000000, 5, 700, "Air Susppension"));
        daftarSepeda.add(new sepedaBalap("BXT Full Carbon 700", "BXT", 123550000, 3, "L", 1));
        daftarSepeda.add(new sepedaLipat("Pasific Noris", "Pasific", 25650000, 3, 700, "MID"));

        dataPelanggan.put("KIW01", "Jo Jahyun");
        dataPelanggan.put("KIW02", "Vinny Hong");
        dataPelanggan.put("KIW03", "Kwon Hyuk");

        while (running) {
            System.out.println("\n  === Menu Utama Toko Sepeda FIXFIX ===  ");
            System.out.println("1. Tambah Sepeda");
            System.out.println("2. Tampilkan Semua Sepeda yang Tersedia");
            System.out.println("3. Cari Sepeda");
            System.out.println("4. Proses Pembelian");
            System.out.println("5. Proses Pembelian Online");
            System.out.println("6. Manajemen Data Pelanggan");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu (1-7): ");

            int pilihan = input.nextInt();
            input.nextLine();

            System.out.println("\n");

            switch (pilihan) {
                case 1:
                        System.out.print("Masukkan Nama Sepeda: ");
                        String namaSepeda = input.nextLine();

                        System.out.print("Masukkan Merk Sepeda: ");
                        String merk = input.nextLine();

                        System.out.print("Masukkan harga Sepeda (Rp.): ");
                        double harga = input.nextDouble();

                        System.out.print("Masukkan Stok Sepeda: ");
                        int stok = input.nextInt();

                        System.out.println("\nPilih Jenis Sepeda: ");
                        System.out.println("1. Sepeda Gunung (MTB)");
                        System.out.println("2. Sepeda balap (Road Bike / Fixie)");
                        System.out.println("3. Sepeda Lipat (Folding Bike)");
                        System.out.print("masukkan Pilihan: ");

                        int jenis = input.nextInt();
                        input.nextLine();

                        if (jenis == 1) {
                            System.out.print("Masukkan ukuran roda: ");
                            int ukuranRoda = input.nextInt();
                            input.nextLine();

                            System.out.print("Masukkan jenis suspensi : ");
                            String suspensi = input.nextLine();

                            daftarSepeda.add(new sepedaGunung(namaSepeda, merk, harga, stok, ukuranRoda, suspensi));

                            System.out.println("Sepeda Gunung Berhasil Ditambahkan!");

                        } else if (jenis == 2) {
                            System.out.print("Masukkan ukuran frame (S - XXL): ");
                            String ukuranFrame = input.nextLine();

                            System.out.print("Masukkan jumlah gear: ");
                            int jumlahGear = input.nextInt();
                            input.nextLine();

                            daftarSepeda.add(new sepedaBalap(namaSepeda, merk, harga, stok, ukuranFrame, jumlahGear));

                            System.out.println("Sepeda Balap Berhasil Ditambahkan!");

                        } else if (jenis == 3) {
                            System.out.print("Masukkan ukuran roda: ");
                            int ukuranRoda = input.nextInt();
                            input.nextLine();

                            System.out.print("Masukkan mekanisme lipat (MID/TRIANGLE/VERTICAL): ");
                            String mekanismeLipat = input.nextLine();

                            daftarSepeda.add(new sepedaLipat(namaSepeda, merk, harga, stok, ukuranRoda, mekanismeLipat));

                            System.out.println("Sepeda Lipat Berhasil Ditambahkan!");

                        } else {
                            System.out.println("Maaf, jenis sepeda tidak valid.");
                        } 

                    break;

                case 2:
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Belum ada sepeda yang tersedia.");
                    } else {
                        System.out.println("=== Daftar Sepeda yang Tersedia ===");

                        // Dinamic Binding Polymorphism
                        for (int i = 0; i < daftarSepeda.size(); i++) {
                            System.out.println("\nSepeda ke-" + (i + 1));
                            daftarSepeda.get(i).tampilkanInfo();

                            daftarSepeda.get(i).panduanPerawatan();

                            if (daftarSepeda.get(i) instanceof servis) {
                                servis itemDiservis = (servis) daftarSepeda.get(i);
                                itemDiservis.servisRutin();
                            }

                            if (daftarSepeda.get(i) instanceof ujiCoba) {
                                ujiCoba itemUjiCoba = (ujiCoba) daftarSepeda.get(i);
                                itemUjiCoba.ujiCobaLintasan();
                            }
                        
                        }
                    }
                    break;

                case 3: 
                    System.out.print("Masukkan nama sepeda: ");
                    String nama = input.nextLine();

                    try {
                        Sepeda hasil = cariSepeda(nama);
                        System.out.println("Sepeda ditemukan: ");
                        hasil.tampilkanInfo();
                    } catch (tokoSepedaException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        System.out.println("Pencarian Sepeda selesai.");
                    }
                    break;
                
                case 4:
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Belum ada sepeda yang tersedia.");
                    } else {
                        System.out.println("=== Pilih Sepeda yang Ingin Dibeli ===");
                        
                        for (int i = 0; i < daftarSepeda.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarSepeda.get(i).getNama() + " (Stok: " + daftarSepeda.get(i).getStok() + ")");
                        }

                        System.out.print("Pilih nomor sepeda yang ingin dibeli: ");
                        int nomorSepeda = input.nextInt();
                        input.nextLine();

                        if (nomorSepeda >= 1 && nomorSepeda <= daftarSepeda.size()) {
                            int indeks = nomorSepeda - 1;

                            System.out.print("Masukkan jumlah sepeda yang ingin dibeli: ");
                            int jumlahSepedaDibeli = input.nextInt();
                            input.nextLine();

                            if (prosesPembelianOffline(daftarSepeda.get(indeks), jumlahSepedaDibeli)) {
                                daftarSepeda.remove(indeks);
                            } 

                        } else {
                            input.nextLine();
                            System.out.println("Nomor sepeda tidak valid.");
                        }
                    }
                    break;

                case 5:
                    if (daftarSepeda.isEmpty()) {
                        System.out.println("Belum ada sepeda yang  tersedia.");
                    } else {
                        System.out.println("=== Pilih Sepeda yang igin diproses ===");

                        for (int i = 0; i < daftarSepeda.size(); i++) {
                            System.out.println((i + 1) + ". " + daftarSepeda.get(i).getNama() + " (Stok: " + daftarSepeda.get(i).getStok() + ")");
                        }

                        System.out.print("Pilih nomor sepeda: ");
                        int nomorSepeda = input.nextInt();
                        input.nextLine();

                        if (nomorSepeda >= 1 && nomorSepeda <= daftarSepeda.size()) {
                            int indeks = nomorSepeda - 1;

                            System.out.print("Masukkan alamat pengiriman: ");
                            String alamatPengiriman = input.nextLine();

                            System.out.print("Masukkan jumlah sepeda: ");
                            int jumlahSepedaDibeli = input.nextInt();
                            input.nextLine();

                            if (prosesPembelianOnline(daftarSepeda.get(indeks), alamatPengiriman, jumlahSepedaDibeli)) {
                                daftarSepeda.remove(indeks);
                            }

                        } else {
                            System.out.println("Nomor sepeda tidak valid.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("\n=== Manajemen Data Pelanggan ===");
                    System.out.println("1. Tambah Data Pelanggan");
                    System.out.println("2. Cari berdasarkan ID Pelanggan");
                    System.out.println("3. Tampilkan Semua Data Pelanggan");

                    System.out.print("Pilih menu (1-3): ");
                    int pilihanPelanggan = input.nextInt();
                    input.nextLine();

                    if (pilihanPelanggan == 1) {
                        System.out.print("Masukkan ID Pelanggan (Sebagai Key): ");
                        String id = input.nextLine();
                        System.out.print("Masukkan Nama Pelanggan (Sebagai Value): ");
                        String namaPelanggan = input.nextLine();

                        dataPelanggan.put(id, namaPelanggan);
                        System.out.println("Data pelanggan berhasil ditambahkan.");
                    } else if (pilihanPelanggan == 2) {
                        System.out.print("Masukkan ID Pelanggan yang dicari: ");
                        String searchId = input.nextLine();
                        
                        if (dataPelanggan.containsKey(searchId)) { 
                            System.out.println("Ditemukan! Nama Pelanggan: " + dataPelanggan.get(searchId));
                        } else {
                            System.out.println("Pelanggan dengan ID tersebut tidak terdaftar.");
                        }
                    } else if (pilihanPelanggan == 3) {
                        System.out.println("Total Pelanggan Terdaftar: " + dataPelanggan.size());

                        for (String KeyId : dataPelanggan.keySet()) {
                            System.out.println("ID Pelanggan: " + KeyId + ", Nama Pelanggan: " + dataPelanggan.get(KeyId));
                        }
                    } else {
                        System.out.println("Pilihan menu tidak valid.");
                    }
                    break;


                case 7:
                    running = false;

                    System.out.println("=== Terimakasih Sudah Menggunakan Sistem Toko Sepeda FIXFIX ===");
                    break;

            }

        }

        input.close();
    }

}