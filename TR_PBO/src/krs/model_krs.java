package krs;

import java.time.LocalDateTime;

public class model_krs {
    private String kode_kelas;
    private String nim;
    private int krs_id;
    private String status;
    private LocalDateTime tanggal_registrasi;
    
    
public model_krs(String kode_kelas,String dosen_id,int mk_id, String nama_kelas, int kapasitas){
this.kode_kelas = kode_kelas;
this.nim = nim;
this.krs_id = krs_id;
this.status = status;
this.tanggal_registrasi = tanggal_registrasi;
}

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getKrs_id() {
        return krs_id;
    }

    public void setKrs_id(int krs_id) {
        this.krs_id = krs_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTanggal_registrasi() {
        return tanggal_registrasi;
    }

    public void setTanggal_registrasi(LocalDateTime tanggal_registrasi) {
        this.tanggal_registrasi = tanggal_registrasi;
    }


}
