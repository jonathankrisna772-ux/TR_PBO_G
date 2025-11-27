package dosen;

public class model {
 
    private String dosenId;
    private int userId;
    private int prodiId;
    private String nama;
    private String email;
    private int angkatan;
    
public model(String dosenId,int userId, int prodiId, String nama, String email){
this.dosenId = dosenId;
this.userId = userId;
this.prodiId = prodiId;
this.nama = nama;
this.email = email;

}

    public String getDosenId() {
        return dosenId;
    }

    public void setDosenId(String dosenId) {
        this.dosenId = dosenId;
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


