package model;

import java.time.LocalTime;

public class model_jadwal {
    private int jadwal_id;
    private String kode_kelas;
    private String hari;
    private LocalTime jam_mulai;
    private LocalTime jam_selesai;
    private String ruang;
    
    public model_jadwal(int jadwal_id,String kode_kelas,String hari, LocalTime jam_mulai, LocalTime jam_selesai, String ruang){
        this.jadwal_id = jadwal_id;
        this.kode_kelas = kode_kelas;
        this.hari = hari;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
        this.ruang = ruang;
    }

    public int getJadwal_id() {
        return jadwal_id;
    }

    public void setJadwal_id(int jadwal_id) {
        this.jadwal_id = jadwal_id;
    }

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public LocalTime getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(LocalTime jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public LocalTime getJam_selesai() {
        return jam_selesai;
    }

    public void setJam_selesai(LocalTime jam_selesai) {
        this.jam_selesai = jam_selesai;
    }

    public String getRuang() {
        return ruang;
    }

    public void setRuang(String ruang) {
        this.ruang = ruang;
    }


}
