public class QueuePasien {
    Pasien[] antrian;
    int front, rear, size, kapasitas;

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
            System.out.println(">> Antrian penuh! Tidak bisa menambahkan pasien.");
        }
    }

    public Pasien dequeue() {
        if (!isEmpty()) {
            Pasien p = antrian[front];
            front = (front + 1) % kapasitas;
            size--;
            return p;
        } else {
            System.out.println(">> Antrian kosong!");
            return null;
        }
    }

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println(">> Tidak ada pasien dalam antrian.");
            return;
        }
        System.out.println("-- Antrian Pasien --");
        for (int i = 0; i < size; i++) {
            System.out.println("Pasien ke-" + (i+1));
            int idx = (front + i) % kapasitas;
            antrian[idx].tampilkanInformasi();
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
}
