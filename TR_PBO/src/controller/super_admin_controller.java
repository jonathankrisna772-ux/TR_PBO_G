package controller;

import config.koneksi_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class super_admin_controller {

    // UPDATE: Sekarang menerima Hari, Jam, dan Ruang
    public boolean tambahKelasLengkap(String kodeKelas, String dosenId, int mkId, String namaKelas, int kapasitas, 
                                      String hari, String jamRaw, String ruang) {
        
        Connection conn = null;
        PreparedStatement psKelas = null;
        PreparedStatement psJadwal = null;
        
        try {
            conn = koneksi_db.getConnection();
            // Matikan auto-commit agar insert berjalan satu paket (Transaction)
            conn.setAutoCommit(false);

            // 1. INSERT KE TABEL KELAS
            String sqlKelas = "INSERT INTO kelas (kode_kelas, dosen_id, mk_id, nama_kelas, kapasitas) VALUES (?, ?, ?, ?, ?)";
            psKelas = conn.prepareStatement(sqlKelas);
            psKelas.setString(1, kodeKelas);
            psKelas.setString(2, dosenId);
            psKelas.setInt(3, mkId);
            psKelas.setString(4, namaKelas);
            psKelas.setInt(5, kapasitas);
            psKelas.executeUpdate();

            // 2. PARSING JAM (Contoh Input: "08:00-10:00" atau "08:00")
            String jamMulai = "07:00:00"; // Default
            String jamSelesai = "09:00:00"; // Default
            
            if (jamRaw != null && !jamRaw.isEmpty()) {
                if (jamRaw.contains("-")) {
                    String[] split = jamRaw.split("-");
                    jamMulai = split[0].trim() + ":00"; // Tambah detik agar format SQL TIME valid
                    jamSelesai = split[1].trim() + ":00";
                } else {
                    jamMulai = jamRaw.trim() + ":00";
                }
            }

            // 3. INSERT KE TABEL JADWAL
            // Kita hubungkan jadwal ini ke kode_kelas yang baru dibuat
            String sqlJadwal = "INSERT INTO jadwal (kode_kelas, hari, jam_mulai, jam_selesai, ruang) VALUES (?, ?, ?, ?, ?)";
            psJadwal = conn.prepareStatement(sqlJadwal);
            psJadwal.setString(1, kodeKelas);
            psJadwal.setString(2, hari);
            psJadwal.setString(3, jamMulai); // Format harus HH:MM:SS
            psJadwal.setString(4, jamSelesai);
            psJadwal.setString(5, ruang);
            psJadwal.executeUpdate();

            // Jika sampai sini tidak error, simpan permanen
            conn.commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            if (conn != null) {
                try { conn.rollback(); } catch (SQLException ex) {} // Batalkan jika error
            }
            return false;
        } finally {
            try { if (conn != null) conn.setAutoCommit(true); } catch (Exception e) {}
        }
    }

    public boolean hapusKelas(String kodeKelas) {
        String sql = "DELETE FROM kelas WHERE kode_kelas = ?";
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeKelas);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }  
}
