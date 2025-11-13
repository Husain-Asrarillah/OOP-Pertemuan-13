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

<img width="756" height="223" alt="image" src="https://github.com/user-attachments/assets/f4e41875-c239-4710-9a07-20b2df54ef13" />


### B. Form Login (`Masuk.java`)

<img width="640" height="681" alt="image" src="https://github.com/user-attachments/assets/61870c64-0eb2-4792-a21d-806be1eb634e" />

* Mengambil input dari `tfuser` dan `tfpass`.
* Melakukan validasi input kosong.
* Mencari entitas `Login` berdasarkan `username` (`em.find(...)`).
* Membandingkan password input dengan `passwordHash` yang tersimpan.

<img width="617" height="290" alt="image" src="https://github.com/user-attachments/assets/8c69fc53-4e68-49e5-9848-820c509517eb" />

* Menyediakan navigasi ke **Register** (`regisMouseClicked`) dan **Forgot Password** (`fgpassMouseClicked`).

<img width="480" height="235" alt="image" src="https://github.com/user-attachments/assets/f758a07d-254c-49a7-8ca7-3ec3a9221bbc" />

### C. Form Register (`Daftar.java`)

<img width="400" height="449" alt="image" src="https://github.com/user-attachments/assets/599d917b-7b3a-43f9-a6b9-3f72866a92b9" />

* Memeriksa keberadaan `username` yang sama di database.
* Jika belum ada, membuat objek `Login` baru dan menyimpannya menggunakan `em.persist(newUser)`.

<img width="684" height="521" alt="image" src="https://github.com/user-attachments/assets/d720c92e-f743-4fdd-a08d-957db9af6e8d" />

### D. Alur Forgot Password (`Password.java` dan `LupaPass.java`)

<img width="366" height="258" alt="image" src="https://github.com/user-attachments/assets/35de0517-431a-42c6-8cda-39c22d037bae" />
<img width="328" height="371" alt="image" src="https://github.com/user-attachments/assets/99368e7a-4307-415d-97b4-86a8ba2325e5" />

1.  **Validasi Username (`Password.java`):** Meminta `username` dan mencari entitas (`em.find`). Jika ditemukan, navigasi ke form `LupaPass` dengan membawa `username`.

<img width="777" height="526" alt="image" src="https://github.com/user-attachments/assets/615ab02c-522c-4469-b89c-76550faf8e8d" />

2.  **Reset Password (`LupaPass.java`):**
    * Menerima `username`.
    * Meminta dua input password baru.
    * Melakukan validasi kecocokan password baru.
    * Jika valid, memperbarui `passwordHash` dan melakukan `em.getTransaction().commit()`.

<img width="709" height="564" alt="image" src="https://github.com/user-attachments/assets/686594ee-cb2f-4ce1-af54-f4c33cf2478a" />

---

## 📝 Hasil dan Pembahasan

### Koneksi Database
Konfigurasi persistence.xml berhasil menghubungkan aplikasi Java dengan database PostgreSQL Toko_Komik.

<img width="945" height="208" alt="image" src="https://github.com/user-attachments/assets/f69b7819-20d7-4d87-8bf3-c4e8bc4f2052" />

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
