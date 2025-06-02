package CaseMethod;

public class TransaksiLayanan {
    String nik, namaPasien;
    String idDokter, namaDokter;
    int durasiJam;
    int biaya;
    
    TransaksiLayanan(String nik, String namaPasien, String idDokter, int durasiJam, int biaya) {
        this.nik = nik;
        this.namaPasien = namaPasien;
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.durasiJam = durasiJam;
        this.biaya = durasiJam * 50000;
    }
}
