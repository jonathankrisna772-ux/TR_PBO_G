package controller;

import config.koneksi_db;
import model.model_prodi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class prodi_controller {

    public List<model_prodi> getAllProdi() {
        List<model_prodi> list = new ArrayList<>();
        String sql = "SELECT * FROM prodi";
        
        try (Connection conn = koneksi_db.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                list.add(new model_prodi(
                    rs.getInt("prodi_id"),
                    rs.getString("nama_prodi"),
                    rs.getString("fakultas")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    } 
}
