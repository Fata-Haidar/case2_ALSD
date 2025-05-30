package CaseMethod;

public class QueuePasien {
    private Pasien[] antrian;
    private int front, rear, size, kapasitas;

    public QueuePasien(int kapasitas) {
        this.kapasitas = kapasitas;
        antrian = new Pasien[kapasitas];
        front = 0;
        rear = -1;
        size = 0;
    }

    public boolean isFull() {
        return size == kapasitas;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(Pasien p) {
        if (!isFull()) {
            rear = (rear + 1) % kapasitas;
            antrian[rear] = p;
            size++;
        } else {
            System.out.println("Antrian penuh!");
        }
    }

    public Pasien dequeue() {
        if (!isEmpty()) {
            Pasien p = antrian[front];
            front = (front + 1) % kapasitas;
            size--;
            return p;
        } else {
            System.out.println("Antrian Kosong!");
            return null;
        }
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }
        System.out.println("Daftar Pasien dalam Antrian:");
        for (int i = 0; i < size; i++) {
            int idx = (front + i) % kapasitas;
            System.out.println((i + 1) + ". " + antrian[idx].namaPasien + " - " + antrian[idx].nik);
        }
    }

    public int sisaAntrian() {
        return size;
    }
}
