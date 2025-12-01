package controller;

import config.koneksi_db;
import model.model_krs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class krs_controller {

    // 1. GET LIST OF TAKEN CLASSES (For the Table)
    public List<model_krs> getKrsByNim(String nim) {
        List<model_krs> list = new ArrayList<>();
        String sql = "SELECT * FROM krs WHERE nim = ?";
        
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, nim);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                // This now matches the FIXED model_krs constructor
                model_krs krs = new model_krs(
                    rs.getInt("krs_id"),
                    rs.getString("kode_kelas"),
                    rs.getString("nim"),
                    rs.getString("status")
                );
                list.add(krs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // 2. REGISTER A CLASS (For the Button)
    public String ambilKelas(String nim, String kodeKelas) {
        if (isAlreadyTaken(nim, kodeKelas)) return "Anda sudah mengambil kelas ini!";

        String sql = "INSERT INTO krs (kode_kelas, nim, status) VALUES (?, ?, 'menunggu')";
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kodeKelas);
            ps.setString(2, nim);
            return ps.executeUpdate() > 0 ? "Berhasil mengambil kelas!" : "Gagal.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error Database.";
        }
    }

    private boolean isAlreadyTaken(String nim, String kodeKelas) {
        String sql = "SELECT * FROM krs WHERE nim = ? AND kode_kelas = ?";
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nim);
            ps.setString(2, kodeKelas);
            return ps.executeQuery().next();
        } catch (Exception e) { return false; }
    }
}