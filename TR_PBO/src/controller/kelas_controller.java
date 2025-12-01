package controller;

import config.koneksi_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.model_kelas;

public class kelas_controller {

    // Create a new Class
    public boolean tambahKelas(String kode, String dosenId, int mkId, String nama, int cap) {
        String sql = "INSERT INTO kelas (kode_kelas, dosen_id, mk_id, nama_kelas, kapasitas) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, kode);
            ps.setString(2, dosenId);
            ps.setInt(3, mkId);
            ps.setString(4, nama);
            ps.setInt(5, cap);
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Delete a Class
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
    
    // Get All Classes (Useful for filling dropdowns/tables)
    public List<model_kelas> getAllKelas() {
        List<model_kelas> list = new ArrayList<>();
        String sql = "SELECT * FROM kelas";
        
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()) {
                list.add(new model_kelas(
                    rs.getString("kode_kelas"),
                    rs.getString("dosen_id"),
                    rs.getInt("mk_id"),
                    rs.getString("nama_kelas"),
                    rs.getInt("kapasitas")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
