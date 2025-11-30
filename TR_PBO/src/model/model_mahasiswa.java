package model;

public class model_mahasiswa {
    private String nim;
    private int userId;
    private int prodiId;
    private String nama;
    private String email;
    private int angkatan;
    
public model_mahasiswa(String nim,int userId, int prodiId, String nama, String email, int angkatan){
this.nim = nim;
this.userId = userId;
this.prodiId = prodiId;
this.nama = nama;
this.email = email;
this.angkatan = angkatan;

}

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProdiId() {
        return prodiId;
    }

    public void setProdiId(int prodiId) {
        this.prodiId = prodiId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    
}
