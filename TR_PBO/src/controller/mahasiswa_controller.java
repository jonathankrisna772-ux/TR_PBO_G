package controller;

import config.koneksi_db;
import model.model_jadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class mahasiswa_controller {

    // Get Schedule (Jadwal) based on what classes the student took (KRS)
    public List<model_jadwal> getJadwalMahasiswa(String nim) {
        List<model_jadwal> listJadwal = new ArrayList<>();
        
        String sql = "SELECT j.* FROM jadwal j " +
                     "JOIN kelas k ON j.kode_kelas = k.kode_kelas " +
                     "JOIN krs r ON k.kode_kelas = r.kode_kelas " +
                     "WHERE r.nim = ?";

        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LocalTime start = rs.getTime("jam_mulai").toLocalTime();
                LocalTime end = rs.getTime("jam_selesai").toLocalTime();
                
                model_jadwal jadwal = new model_jadwal(
                    rs.getInt("jadwal_id"),
                    rs.getString("kode_kelas"),
                    rs.getString("hari"),
                    start,
                    end,
                    rs.getString("ruang")
                );
                listJadwal.add(jadwal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listJadwal;
    }
    
    // Register a new class (KRS)
    public boolean tambahKRS(String nim, String kodeKelas) {
        String sql = "INSERT INTO krs (kode_kelas, nim, status) VALUES (?, ?, 'menunggu')";
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeKelas);
            ps.setString(2, nim);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
