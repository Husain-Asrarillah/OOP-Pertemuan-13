# 🔒 Sistem Otentikasi dengan Java Swing & JPA

Proyek ini adalah hasil **Laporan Praktikum Mata Kuliah Pemrograman Berorientasi Objek (PBO)** yang berfokus pada implementasi sistem otentikasi lengkap (Login, Register, Forgot Password) menggunakan antarmuka grafis **Java Swing** dan memanfaatkan **Java Persistence API (JPA)** untuk interaksi dengan database **PostgreSQL**.

---

## 👨‍🏫 Informasi Praktikum

| Keterangan | Detail |
| :--- | :--- |
| **Mata Kuliah** | Pemrograman Berorientasi Objek (PBO) |
| **Dosen Pengampu** | Bayu Adhi Nugroho, Ph.D. |
| **Penyusun** | Husain Asrarillah (09020624035) |
| **Institusi** | Program Studi Sistem Informasi, UIN Sunan Ampel Surabaya |
| **Tahun** | 2025 |

---

## 📚 Pendahuluan

### Latar Belakang

Otentikasi pengguna adalah komponen krusial dalam setiap aplikasi untuk memverifikasi identitas pengguna dan mengontrol akses ke sumber daya aplikasi. Praktikum ini bertujuan untuk mengimplementasikan sistem otentikasi lengkap menggunakan antarmuka grafis Java Swing dan memanfaatkan JPA untuk interaksi dengan database PostgreSQL.

### Tujuan Praktikum

* Menguasai integrasi **Java Swing** dengan **JPA (Hibernate/EclipseLink, dll.)** untuk operasi CRUD (Create, Read, Update) data pengguna.
* Mengimplementasikan fungsi **Login** dengan validasi username dan password.
* Mengembangkan fungsi **Register** untuk pendaftaran pengguna baru.
* Menciptakan alur **Forgot Password** untuk penggantian password yang aman.
* Memahami dan mengkonfigurasi **Persistence Unit** dalam berkas `persistence.xml`.

---

## 🛠️ Metodologi dan Teknologi

### Tools dan Lingkungan Pengembangan

| Komponen | Detail |
| :--- | :--- |
| **Bahasa Pemrograman** | Java |
| **GUI Framework** | Java Swing |
| **Database** | PostgreSQL |
| **ORM** | Java Persistence API (JPA) - melalui `persistence.xml` |

### Dasar Teori Singkat

* **JPA (Java Persistence API):** Spesifikasi Java untuk Object-Relational Mapping (ORM), digunakan untuk memetakan kelas Java ke tabel database (misalnya, `HalamanLogin.Login` ke tabel `login`).
* **Entity & Persistence Unit:**
    * **Entity Class (`Login.java`):** Kelas Java yang ditandai `@Entity` yang merepresentasikan tabel, dengan properti `username` sebagai `@Id` (Primary Key).
    * **Persistence Unit (`PertemuanKetigabelasPU`):** Didefinisikan dalam `persistence.xml`, mengkonfigurasi koneksi database: `jdbc:postgresql://localhost:5432/Toko_Komik`, `org.postgresql.Driver`, user `postgres`, pass `170206`.
* **Java Swing:** Toolkit GUI yang digunakan untuk membangun antarmuka pengguna (JFrame, JButton, JTextField) pada kelas `Masuk`, `Daftar`, `Password`, dan `LupaPass`.

---

## 🚀 Implementasi Kode (Fungsionalitas Utama)

### A. Kelas Entity (`Login.java`)
Memetakan kolom `username` (sebagai ID) dan `password_hash` dari tabel `login`.

### B. Form Login (`Masuk.java`)
* Mengambil input dari `tfuser` dan `tfpass`.
* Melakukan validasi input kosong.
* Mencari entitas `Login` berdasarkan `username` (`em.find(...)`).
* Membandingkan password input dengan `passwordHash` yang tersimpan.
* Menyediakan navigasi ke **Register** (`regisMouseClicked`) dan **Forgot Password** (`fgpassMouseClicked`).

### C. Form Register (`Daftar.java`)
* Memeriksa keberadaan `username` yang sama di database.
* Jika belum ada, membuat objek `Login` baru dan menyimpannya menggunakan `em.persist(newUser)`.

### D. Alur Forgot Password (`Password.java` dan `LupaPass.java`)
1.  **Validasi Username (`Password.java`):** Meminta `username` dan mencari entitas (`em.find`). Jika ditemukan, navigasi ke form `LupaPass` dengan membawa `username`.
2.  **Reset Password (`LupaPass.java`):**
    * Menerima `username`.
    * Meminta dua input password baru.
    * Melakukan validasi kecocokan password baru.
    * Jika valid, memperbarui `passwordHash` dan melakukan `em.getTransaction().commit()`.

---

## 📝 Hasil dan Pembahasan

### Hasil Fungsi Login

| Kondisi | Aksi | Hasil |
| :--- | :--- | :--- |
| **Username/Password Kosong** | Klik LOGIN | `JOptionPane` "Username dan Password harus diisi!" |
| **Username Terdaftar, Password Benar** | Klik LOGIN | `JOptionPane` "Selamat datang, [username]!" dan jendela ditutup |
| **Username/Password Salah** | Klik LOGIN | `JOptionPane` "Username atau Password salah!" |

### Hasil Fungsi Pendaftaran (Register)
Pendaftaran berhasil menyimpan data ke tabel `login`. Sistem mencegah pendaftaran jika `username` sudah ada.

### Hasil Fungsi Reset Password
Berhasil memperbarui kolom `password_hash` di database setelah validasi `username` dan kecocokan dua input password baru.

---

## ✅ Kesimpulan

Praktikum ini berhasil mengimplementasikan sistem otentikasi yang fungsional menggunakan **Java Swing GUI dan JPA (termasuk Login, Register, dan Forgot Password)**. Integrasi JPA memungkinkan manipulasi data pengguna yang efisien, dan penerapan validasi dasar telah ditambahkan untuk meningkatkan pengalaman pengguna.

---
