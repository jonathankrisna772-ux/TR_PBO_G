package model;

public class model_krs {
    private int krs_id;
    private String kode_kelas;
    private String nim;
    private String status;
    
    // Correct Constructor
    public model_krs(int krs_id, String kode_kelas, String nim, String status) {
        this.krs_id = krs_id;
        this.kode_kelas = kode_kelas;
        this.nim = nim;
        this.status = status;
    }
    
    // Simple Constructor for lists
    public model_krs(String kode_kelas, String nim, String status) {
        this.kode_kelas = kode_kelas;
        this.nim = nim;
        this.status = status;
    }

    public String getKode_kelas() { return kode_kelas; }
    public String getNim() { return nim; }
    public int getKrs_id() { return krs_id; }
    public String getStatus() { return status; }
    
    public void setNim(String nim) { this.nim = nim; }
    public void setKrs_id(int krs_id) { this.krs_id = krs_id; }
    public void setStatus(String status) { this.status = status; }
}