# 📝 Aplikasi Catatan Harian (UTS PBO II)

[![Java Version](https://img.shields.io/badge/Java-JDK%208%2B-blue)](https://www.java.com/id/)
[![IDE](https://img.shields.io/badge/IDE-NetBeans-orange)](https://netbeans.apache.org/)
[![License](https://img.shields.io/badge/License-MIT-green)](https://choosealicense.com/licenses/mit/)

Proyek ini adalah implementasi dari **Ujian Tengah Semester (UTS)** mata kuliah Pemrograman Berorientasi Objek II (PBO II). Aplikasi *desktop* ini berfungsi sebagai sistem manajemen catatan harian yang dibangun menggunakan **Java Swing**, dengan fokus pada penerapan konsep **OOP** yang solid dan integrasi **library pihak ketiga** untuk interaksi *file* yang kompleks (PDF dan Excel).

## 📸 Tampilan Antarmuka Aplikasi

Berikut adalah *screenshot* dari antarmuka pengguna aplikasi Catatan Harian:

<img width="881" height="586" alt="image" src="https://github.com/user-attachments/assets/5951a6b1-e6cc-4044-870b-c7799794cb0f" />


## 👤 Informasi Pengembang

| Keterangan | Detail |
| :--- | :--- |
| **Nama** | Abdi Rahman Kholik |
| **NIM** | 2310010632 |
| **Mata Kuliah** | Pemrograman Berorientasi Objek II |

## ✨ Fitur Utama Aplikasi

Aplikasi `Catatan Harian` dirancang dengan arsitektur **Model-Service-View** untuk pemisahan tanggung jawab yang jelas.

### 1. ⚙️ Manajemen Data Dasar (CRUD)

| Fungsi | Deskripsi |
| :--- | :--- |
| **TAMBAH** | Membuat objek `Catatan` baru dengan *judul*, *isi*, dan *timestamp* otomatis. |
| **UBAH** | Memperbarui data isi catatan yang sudah dipilih dari `Daftar Catatan`. |
| **HAPUS** | Menghapus catatan yang dipilih secara permanen. |
| **CLEAR** | Menghapus teks pada *input field* `Isi Catatan`. |

### 2. 📁 Interaksi File Eksternal (Import & Export)

Fitur ini memungkinkan data catatan diolah menjadi format dokumen industri standar:

| Format File | Operasi | Library Pihak Ketiga Wajib |
| :--- | :--- | :--- |
| **.txt** | Import & Export | Bawaan Java (`java.io`) |
| **.pdf** | Export (Laporan) | **Apache PDFBox** |
| **.xlsx** | Export (Tabel Data) | **Apache POI** |

## 📐 Struktur Proyek

Proyek mengikuti struktur paket yang terorganisir di NetBeans:

| Lokasi File | Peran Arsitektural | Deskripsi |
| :--- | :--- | :--- |
| `Main.java` | **Bootstrap** | Titik eksekusi awal aplikasi (`main()`). |
| `catatanharian.model` | **Model** | Berisi *class* `Catatan.java` (struktur data). |
| `catatanharian.service`| **Service Layer** | Berisi *class* `CatatanService.java` (Logika Bisnis, CRUD, dan Fungsi Import/Export). |
| `catatanharian.ui` | **View** | Berisi *class* `CatatanFrame.java` (Antarmuka Grafis Java Swing). |

## 🔗 Panduan Ketergantungan (Dependencies)

Untuk mengeliminasi notifikasi **"Import dari PDF memerlukan library pihak ketiga"** (seperti terlihat pada *screenshot*), Anda harus menambahkan *dependency* berikut.

### Langkah-langkah Instalasi Dependency di NetBeans:

1.  **Unduh File JAR:** Dapatkan file JAR yang diperlukan (inti dan *dependency*) untuk **Apache PDFBox** dan **Apache POI**.
2.  Buka Proyek Anda di NetBeans.
3.  Klik kanan pada node **Libraries**.
4.  Pilih **Add JAR/Folder** atau **Add Library**.
5.  Tambahkan semua file JAR yang sudah diunduh ke *classpath* proyek.

## 🚀 Cara Menjalankan Proyek

1.  *Clone* repositori ini atau unduh *source code*.
2.  Buka proyek di NetBeans.
3.  Pastikan semua *dependencies* (PDFBox dan POI) sudah terinstal dan terdaftar di *Libraries*.
4.  Jalankan file `Main.java` atau tekan tombol **Run Project** (F6).

---
*Dibuat oleh Abdi Rahman Kholik untuk keperluan UTS PBO II.*
