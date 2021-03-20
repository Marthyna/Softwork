package classesDominio;

import java.io.Serializable;

public class Empresa extends Pessoa implements Serializable{
    private static final long serialVersionUID = 555L;
    private String razaoSocial;
    private String nomeFantasia;
    private long cnpj;
    private int ID;

    public Empresa(String razaoSocial, String nomeFantasia, long cnpj,  Endereco endereco, int telefone, int ddd, String email, String senha) {
        super(endereco, telefone, ddd, email, senha);
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
        this.cnpj = cnpj;
    }


    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
