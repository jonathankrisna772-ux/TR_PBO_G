package super_admin;

public class model {

    private int adminId;
    private int userId;
    private String nama;
    private String email;
    
public model(int adminId,int userId, String nama, String email){
this.adminId = adminId;
this.userId = userId;
this.nama = nama;
this.email = email;

}

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    

}
