package CaseMethod;

import java.util.Scanner;

public class KlinikMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueuePasien antrian = new QueuePasien(10);
        LinkedListTransaksi riwayat = new LinkedListTransaksi();

        System.out.println("+-----------------------------------------+");
        System.out.println("|               Kelompok 1                |");
        System.out.println("+-----------------------------------------+");
        System.out.println("| 1. Dimas handarhesky Irianto            |");
        System.out.println("| 2. Faatihurrizki Prasojo                |");
        System.out.println("| 3. Fata Haidar Aly                      |");
        System.out.println("+-----------------------------------------+");

        int pilihan;
        do {
            System.out.println("\n=== Sistem Antrian Klinik Dokter ===");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Tampilkan Daftar Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.println("---------------------------------------");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan NIK Pasien : ");
                    String nik = sc.nextLine();
                    System.out.print("Nasukkan Nama Pasien : ");
                    String namaPasien = sc.nextLine();
                    System.out.print("Masukkan Keluhan Pasien : ");
                    String keluhan = sc.nextLine();
                    antrian.enqueue(new Pasien(namaPasien, nik, keluhan));
                    System.out.println("Pasien berhasil ditambahkan ke antrian.");
                    break;

                case 2:
                    antrian.tampilkanAntrian();
                    break;

                case 3:
                    if (antrian.isEmpty()) {
                        System.out.println("Tidak ada pasien dalam antrian.");
                    } else {
                        Pasien p = antrian.dequeue();
                        System.out.println("Melayani pasien : " + p.nik + " - " + p.namaPasien);

                        System.out.println();
                    }
                    break;

                case 4:
                    System.out.println("Sisa pasien dalam antrian: " + antrian.sisaAntrian());
                    break;

                case 5:
                    riwayat.tampilRiwayat();
                    break;

                case 0:
                    System.out.println("Terima Kasih !! ");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }

        } while (pilihan != 0);
        sc.close();
    }
}
