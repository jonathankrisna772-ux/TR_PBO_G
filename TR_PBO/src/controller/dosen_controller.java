package controller;

import config.koneksi_db;
import model.model_jadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class dosen_controller {

    // Get the schedule of classes taught by this Dosen
    public List<model_jadwal> getJadwalMengajar(String dosenId) {
        List<model_jadwal> listJadwal = new ArrayList<>();
        
        String sql = "SELECT j.* FROM jadwal j " +
                     "JOIN kelas k ON j.kode_kelas = k.kode_kelas " +
                     "WHERE k.dosen_id = ?";

        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, dosenId);
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
}
