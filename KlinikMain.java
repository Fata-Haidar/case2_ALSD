import java.util.Scanner;

public class KlinikMain {
    


    public static void main(String[] args) {
        QueuePasien antrian = new QueuePasien(10);
        LinkedListTransaksi riwayat = new LinkedListTransaksi();
        Scanner sc = new Scanner(System.in);
        System.out.println("+-----------------------------------------+");
        System.out.println("|               Kelompok 1                |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| 1. Dimas handarhesky Irianto            |");
        System.out.println("| 2. Faatihurrizki Prasojo                |");
        System.out.println("| 3. Fata Haidar Aly                      |");
        System.out.println("+-----------------------------------------+");
        int pilihan;

        do {
            System.out.println("\n=== SISTEM ANTRIAN KLINIK ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                if(antrian.isFull()){
                    System.out.println(">> Antrian penuh! Tidak bisa menambahkan pasien.");
                    break;
                }
                    System.out.print("Masukkan NIK Pasien : ");
                    String nik = sc.nextLine();
                    System.out.print("Nasukkan Nama Pasien : ");
                    String nama = sc.nextLine();
                    System.out.print("Masukkan Keluhan Pasien : ");
                    String keluhan = sc.nextLine();
                    antrian.enqueue(new Pasien(nama, nik, keluhan));
                    System.out.println(">>Pasien berhasil ditambahkan ke antrian.");
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                if(antrian.isEmpty()){
                    System.out.println(">> Antrian kosong!");
                    break;
                }
                    Pasien pasien = antrian.dequeue();
                    System.out.println("Melayani pasien: " + pasien.nama);

                    System.out.print("ID Dokter: ");
                    String idDokter = sc.nextLine();
                    System.out.print("Nama Dokter: ");
                    String namaDokter = sc.nextLine();
                    System.out.print("Durasi Layanan (jam): ");
                    int durasi = sc.nextInt();
                    sc.nextLine();

                    Dokter dokter = new Dokter(idDokter, namaDokter);
                    TransaksiLayanan transaksi = new TransaksiLayanan(pasien, dokter, durasi);
                    riwayat.add(transaksi);

                    System.out.println(">> Pasien dilayani, transaksi berhasil dicatat.");
                    break;
                case 4:
                    System.out.println(">> Sisa antrian: " + antrian.getSize());
                    break;
                case 5:
                    riwayat.tampilkaRiwayat();
                    break;
                case 0:
                    System.out.println("Keluar dari sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
