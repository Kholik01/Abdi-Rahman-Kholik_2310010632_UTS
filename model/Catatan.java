package catatanharian.model;

public class Catatan {
    
    private String judul; 
    private String isi;
    private String tanggal; 

    public Catatan(String judul, String isi, String tanggal) {
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    
    public String getTanggal() {
        return tanggal;
    }
    
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
    
    // Metode ini dipanggil oleh JList untuk menampilkan objek
    @Override
    public String toString() {
        // Format yang ditampilkan di JList: [yyyy/MM/dd HH:mm] Judul Catatan
        return "[" + tanggal + "] " + judul;
    }
}