package prodi;

public class model_prodi {

    private int prodi;
    private String nama_prodi;
    private String fakultas;
    
public model_prodi(int prodi,String nama_prodi,String fakultas){
this.prodi = prodi;
this.nama_prodi = nama_prodi;
this.fakultas = fakultas;
}

    public int getProdi() {
        return prodi;
    }

    public void setProdi(int prodi) {
        this.prodi = prodi;
    }

    public String getNama_prodi() {
        return nama_prodi;
    }

    public void setNama_prodi(String nama_prodi) {
        this.nama_prodi = nama_prodi;
    }

    public String getFakultas() {
        return fakultas;
    }

    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }

    

}

