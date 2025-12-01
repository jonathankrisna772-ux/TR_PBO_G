package controller;

import config.koneksi_db;
import model.model_mata_kuliah;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class matakuliah_controller {

    // Helper: Find MK_ID based on Kode MK (e.g., "TI-101" -> 501)
    public int getMkIdByCode(String kodeMk) {
        int id = -1;
        String sql = "SELECT mk_id FROM mata_kuliah WHERE kode_mk = ?";
        
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeMk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                id = rs.getInt("mk_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    // Get Full MK Details
    public model_mata_kuliah getMataKuliahByCode(String kodeMk) {
        model_mata_kuliah mk = null;
        String sql = "SELECT * FROM mata_kuliah WHERE kode_mk = ?";
        
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kodeMk);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                mk = new model_mata_kuliah(
                    rs.getInt("prodi_id"),
                    rs.getInt("mk_id"),
                    rs.getString("kode_mk"),
                    rs.getString("nama_mk"),
                    rs.getInt("sks")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mk;
    }
}
