package CaseMethod;

public class LinkedListTransaksi {
    Node head, tail;

    public void tambahTransaksi(TransaksiLayanan t) {
        Node baru = new Node(t);
        if (head == null) {
            head = tail = baru;
        } else {
            tail.next = baru;
            tail = baru;
        }
    }

    public void tampilRiwayat() {
    if (head == null) {
        System.out.println("Belum ada transaksi layanan.");
        return;
    }
    System.out.println("Riwayat Transaksi Layanan : ");
    Node temp = head;
    int no = 1;
    while (temp != null) {
        System.out.println(no++ + ". Pasien: " + temp.data.nik + " - " + temp.data.namaPasien +
            " | Dokter: " + temp.data.idDokter + " - " + temp.data.namaDokter +
            " | Durasi: " + temp.data.durasiJam + " jam | Biaya: Rp" + temp.data.biaya);
        temp = temp.next;
    }
}

}
