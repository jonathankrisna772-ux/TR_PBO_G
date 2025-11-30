package model;

public class model_mata_kuliah {
    private int mk_id;
    private int prodi_id;   
    private String kode_mk;
    private String nama_mk;
    private int sks;
    
    public model_mata_kuliah(int prodi_id,int mk_id,String kode_mk, String nama_mk, int sks){
        this.mk_id = mk_id;
        this.prodi_id = prodi_id;
        this.kode_mk = kode_mk;
        this.nama_mk = nama_mk;
        this.sks = sks;
    }

    public int getProdi_id() {
        return prodi_id;
    }

    public void setProdi_id(int prodi_id) {
        this.prodi_id = prodi_id;
    }

    public int getMk_id() {
        return mk_id;
    }

    public void setMk_id(int mk_id) {
        this.mk_id = mk_id;
    }

    public String getKode_mk() {
        return kode_mk;
    }

    public void setKode_mk(String kode_mk) {
        this.kode_mk = kode_mk;
    }

    public String getNama_mk() {
        return nama_mk;
    }

    public void setNama_mk(String nama_mk) {
        this.nama_mk = nama_mk;
    }

    public int getSks() {
        return sks;
    }

    public void setSks(int sks) {
        this.sks = sks;
    }


}
