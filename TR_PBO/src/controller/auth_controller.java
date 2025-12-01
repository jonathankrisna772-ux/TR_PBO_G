package controller;

import config.koneksi_db;
import model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class auth_controller {
    
    // 1. LOGIN MAHASISWA
    public model_mahasiswa loginMahasiswa(String nim, String password) {
        // CHEAT: Force login if 12345 is typed
        if (nim.trim().equals("12345") && password.equals("123")) {
            return new model_mahasiswa("12345", 101, 1, "Budi (Demo)", "budi@univ.ac.id", 2023);
        }

        // Real Database Check
        try (Connection conn = koneksi_db.getConnection()) {
            if (conn != null) {
                String sql = "SELECT m.* FROM mahasiswa m JOIN users u ON m.user_id = u.user_id WHERE m.nim = ? AND u.password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nim);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new model_mahasiswa(rs.getString("nim"), rs.getInt("user_id"), rs.getInt("prodi_id"), rs.getString("nama"), rs.getString("email"), rs.getInt("angkatan"));
                }
            }
        } catch (Exception e) {}
        return null;
    }

    // 2. LOGIN DOSEN
    public model_dosen loginDosen(String inputId, String password) {
        // CHEAT: Force login if D001 or Dosen is typed
        if ((inputId.trim().equalsIgnoreCase("D001") || inputId.trim().equalsIgnoreCase("dosen")) && password.equals("123")) {
            return new model_dosen("D001", 102, 1, "Dr. Einstein (Demo)", "dosen@univ.ac.id");
        }

        // Real Database Check
        try (Connection conn = koneksi_db.getConnection()) {
            if (conn != null) {
                String sql = "SELECT d.* FROM dosen d JOIN users u ON d.user_id = u.user_id WHERE d.dosen_id = ? AND u.password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, inputId);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new model_dosen(rs.getString("dosen_id"), rs.getInt("user_id"), rs.getInt("prodi_id"), rs.getString("nama"), rs.getString("email"));
                }
            }
        } catch (Exception e) {}
        return null;
    }

    // 3. LOGIN ADMIN
    public model_super_admin loginAdmin(String username, String password) {
        // CHEAT: Force login if admin is typed
        if (username.trim().equalsIgnoreCase("admin") && password.equals("123")) {
            return new model_super_admin(1, 103, "Super Admin (Demo)", "admin@univ.ac.id");
        }

        // Real Database Check
        try (Connection conn = koneksi_db.getConnection()) {
            if (conn != null) {
                String sql = "SELECT a.* FROM super_admin a JOIN users u ON a.user_id = u.user_id WHERE u.username = ? AND u.password = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    return new model_super_admin(rs.getInt("admin_id"), rs.getInt("user_id"), rs.getString("nama"), rs.getString("email"));
                }
            }
        } catch (Exception e) {}
        return null;
    }
}