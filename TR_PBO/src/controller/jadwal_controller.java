package controller;

import config.koneksi_db;
import model.model_jadwal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

public class jadwal_controller {

    // FETCH SCHEDULE FOR JTABLE (Student)
    public List<model_jadwal> getJadwalByNim(String nim) {
        // Joins Jadwal -> Kelas -> KRS to see what the student actually took
        String sql = "SELECT j.* FROM jadwal j " +
                     "JOIN kelas k ON j.kode_kelas = k.kode_kelas " +
                     "JOIN krs r ON k.kode_kelas = r.kode_kelas " +
                     "WHERE r.nim = ?";
        return fetchJadwal(sql, nim);
    }

    // FETCH SCHEDULE FOR JTABLE (Dosen)
    public List<model_jadwal> getJadwalByDosen(String dosenId) {
        String sql = "SELECT j.* FROM jadwal j " +
                     "JOIN kelas k ON j.kode_kelas = k.kode_kelas " +
                     "WHERE k.dosen_id = ?";
        return fetchJadwal(sql, dosenId);
    }

    // Helper method
    private List<model_jadwal> fetchJadwal(String sql, String param) {
        List<model_jadwal> list = new ArrayList<>();
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, param);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                LocalTime start = rs.getTime("jam_mulai").toLocalTime();
                LocalTime end = rs.getTime("jam_selesai").toLocalTime();
                
                list.add(new model_jadwal(
                    rs.getInt("jadwal_id"),
                    rs.getString("kode_kelas"),
                    rs.getString("hari"),
                    start,
                    end,
                    rs.getString("ruang")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
