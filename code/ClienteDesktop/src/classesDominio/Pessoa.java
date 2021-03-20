package classesDominio;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
    private static final long serialVersionUID = 222L;
    private Endereco endereco;
    private int telefone;
    private int ddd;
    private String email;
    private String senha;

    public Pessoa(Endereco endereco, int telefone, int ddd, String email, String senha) {
        this.endereco = endereco;
        this.telefone = telefone;
        this.ddd = ddd;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
