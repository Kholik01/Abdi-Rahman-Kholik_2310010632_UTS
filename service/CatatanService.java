package catatanharian.service;

import catatanharian.model.Catatan;
import java.util.ArrayList;
import java.util.List;

public class CatatanService {

    private ArrayList<Catatan> daftarCatatan;

    public CatatanService() {
        daftarCatatan = new ArrayList<>();
    }

    // Tambah catatan baru
    public void tambahCatatan(Catatan c) {
        daftarCatatan.add(c);
    }

    // Ambil semua catatan
    public List<Catatan> getSemuaCatatan() {
        return daftarCatatan;
    }
    
    // Ambil catatan berdasarkan index
    public Catatan getCatatan(int index) {
        if (index >= 0 && index < daftarCatatan.size()) {
            return daftarCatatan.get(index);
        }
        return null;
    }

    // Hapus catatan berdasarkan index
    public void hapusCatatan(int index) {
        if (index >= 0 && index < daftarCatatan.size()) {
            daftarCatatan.remove(index);
        }
    }

    // Ubah catatan (Hanya mengubah Isi)
    // Catatan: Judul dan Tanggal diubah langsung di UI/Frame setelah service ini dipanggil
    public void ubahCatatan(int index, String isiBaru) {
        if (index >= 0 && index < daftarCatatan.size()) {
            daftarCatatan.get(index).setIsi(isiBaru);
        }
    }

    // Hapus semua catatan
    public void clear() {
        daftarCatatan.clear();
    }
}