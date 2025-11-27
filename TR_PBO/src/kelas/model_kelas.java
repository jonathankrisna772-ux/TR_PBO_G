package kelas;

public class model_kelas {
    private String kode_kelas;
    private String dosen_id;
    private int mk_id;
    private String nama_kelas;
    private int kapasitas;
    
public model_kelas(String kode_kelas,String dosen_id,int mk_id, String nama_kelas, int kapasitas){
this.kode_kelas = kode_kelas;
this.dosen_id = dosen_id;
this.mk_id = mk_id;
this.nama_kelas = nama_kelas;
this.kapasitas = kapasitas;
}

    public String getKode_kelas() {
        return kode_kelas;
    }

    public void setKode_kelas(String kode_kelas) {
        this.kode_kelas = kode_kelas;
    }

    public String getDosen_id() {
        return dosen_id;
    }

    public void setDosen_id(String dosen_id) {
        this.dosen_id = dosen_id;
    }

    public int getMk_id() {
        return mk_id;
    }

    public void setMk_id(int mk_id) {
        this.mk_id = mk_id;
    }

    public String getNama_kelas() {
        return nama_kelas;
    }

    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(int kapasitas) {
        this.kapasitas = kapasitas;
    }


}
