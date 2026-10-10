import java.util.Scanner;

public class tokoSepeda {

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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Sepeda[] sepeda = new Sepeda[999];

        int jumlahSepeda = 0;
        boolean running = true;

        System.out.println("======================================");
        System.out.println("Selamat Datang di Toko Sepeda FIXFIX");
        System.out.println("======================================");

        while (running) {
            System.out.println("\n  === Menu Utama Toko Sepeda FIXFIX ===  ");
            System.out.println("1. Tambah Sepeda");
            System.out.println("2. Tampilkan Semua Sepeda yang Tersedia");
            System.out.println("3. Cari Sepeda");
            System.out.println("4. Proses Pembelian");
            System.out.println("5. Proses Pembelian Online");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = input.nextInt();
            input.nextLine();

            System.out.println("\n");

            switch (pilihan) {
                case 1:
                    if (jumlahSepeda < sepeda.length) {
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

                            sepeda[jumlahSepeda] = new sepedaGunung(namaSepeda, merk, harga, stok, ukuranRoda, suspensi);
                            jumlahSepeda++;

                            System.out.println("Sepeda Gunung Berhasil Ditambahkan!");

                        } else if (jenis == 2) {
                            System.out.print("Masukkan ukuran frame (S - XXL): ");
                            String ukuranFrame = input.nextLine();

                            System.out.print("Masukkan jumlah gear: ");
                            int jumlahGear = input.nextInt();
                            input.nextLine();

                            sepeda[jumlahSepeda] = new sepedaBalap(namaSepeda, merk, harga, stok, ukuranFrame, jumlahGear);
                            jumlahSepeda++;

                            System.out.println("Sepeda Balap Berhasil Ditambahkan!");

                        } else if (jenis == 3) {
                            System.out.print("Masukkan ukuran roda: ");
                            int ukuranRoda = input.nextInt();
                            input.nextLine();

                            System.out.print("Masukkan mekanisme lipat (MID/TRIANGLE/VERTICAL): ");
                            String mekanismeLipat = input.nextLine();

                            sepeda[jumlahSepeda] = new sepedaLipat(namaSepeda, merk, harga, stok, ukuranRoda, mekanismeLipat);
                            jumlahSepeda++;

                            System.out.println("Sepeda Lipat Berhasil Ditambahkan!");

                        } else {
                            System.out.println("Maaf, jenis sepeda tidak valid.");
                        } 

                    } else {
                        System.out.println("Maaf, kapasitas toko sudah penuh. Tidak dapat menambahkan sepeda baru.");
                    }

                    break;

                case 2:
                    if (jumlahSepeda == 0) {
                        System.out.println("Belum ada sepeda yang tersedia.");
                    } else {
                        System.out.println("=== Daftar Sepeda yang Tersedia ===");

                        // Dinamic Binding Polymorphism
                        for (int i = 0; i < jumlahSepeda; i++) {
                            System.out.println("\nSepeda ke-" + (i + 1));
                            sepeda[i].tampilkanInfo();
                        }
                    }
                    break;

                case 3:
                    if (jumlahSepeda == 0) {
                        System.out.println("Belum ada sepeda yang tersedia.");
                    } else {
                        System.out.print("Masukkan nama sepeda yang ingin dicari: ");
                        String cariSepeda = input.nextLine();
                        boolean ditemukan = false;

                        for (int i = 0; i < jumlahSepeda; i++) {
                            if (sepeda[i].cariSepeda(cariSepeda)) {
                                System.out.println("Sepeda ditemukan!");

                                sepeda[i].tampilkanInfo();
                                ditemukan = true;
                                break;
                            }
                        }

                        if (!ditemukan) {
                            System.out.println("Sepeda tidak ditemukan.");
                        }
                    }
                    break;

                case 4:
                    if (jumlahSepeda == 0) {
                        System.out.println("Belum ada sepeda yang tersedia.");
                    } else {
                        System.out.println("=== Pilih Sepeda yang Ingin Dibeli ===");
                        
                        for (int i = 0; i < jumlahSepeda; i++) {
                            System.out.println((i + 1) + ". " + sepeda[i].getNama() + " (Stok: " + sepeda[i].getStok() + ")");
                        }

                        System.out.print("Pilih nomor sepeda yang ingin dibeli: ");
                        int nomorSepeda = input.nextInt();
                        input.nextLine();

                        if (nomorSepeda >= 1 && nomorSepeda <= jumlahSepeda) {
                            int indeks = nomorSepeda - 1;

                            System.out.print("Masukkan jumlah sepeda yang ingin dibeli: ");
                            int jumlahSepedaDibeli = input.nextInt();
                            input.nextLine();

                            if (prosesPembelianOffline(sepeda[indeks], jumlahSepedaDibeli)) {
                                jumlahSepeda = hapusSepeda(sepeda, jumlahSepeda, indeks);
                            }

                        } else {
                            input.nextLine();
                            System.out.println("Nomor sepeda tidak valid.");
                        }
                    }
                    break;

                case 5:
                    if (jumlahSepeda == 0) {
                        System.out.println("Belum ada sepeda yang  tersedia.");
                    } else {
                        System.out.println("=== Pilih Sepeda yang igin diproses ===");

                        for (int i = 0; i < jumlahSepeda; i++) {
                            System.out.println((i + 1) + ". " + sepeda[i].getNama() + " (Stok: " + sepeda[i].getStok() + ")");
                        }

                        System.out.print("Pilih nomor sepeda: ");
                        int nomorSepeda = input.nextInt();
                        input.nextLine();

                        if (nomorSepeda >= 0 && nomorSepeda <= jumlahSepeda) {
                            int indeks = nomorSepeda - 1;

                            System.out.print("Masukkan alamat pengiriman: ");
                            String alamatPengiriman = input.nextLine();

                            System.out.print("Masukkan jumlah sepeda: ");
                            int jumlahSepedaDibeli = input.nextInt();
                            input.nextLine();

                            if (prosesPembelianOnline(sepeda[indeks], alamatPengiriman, jumlahSepedaDibeli)) {
                                jumlahSepeda = hapusSepeda(sepeda, jumlahSepeda, indeks);
                            }

                        } else {
                            System.out.println("Nomor sepeda tidak valid.");
                        }
                    }
                    break;

                case 6:
                    running = false;

                    System.out.println("=== Terimakasih Sudah Menggunakan Sistem Toko Sepeda FIXFIX ===");
                    break;

            }

        }

        input.close();
    }

}