package classesDominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void setSenha(String senhaOriginal, int codigoUsuario) {
        String senhaCriptografada = "";
        int chave = codigoUsuario + senhaOriginal.length();
        if(chave >= 70){
            chave -= 70;
        }

        for (int x = 0; x < 3; x++){
            String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";

            char[] letras = alfabeto.toCharArray(); // vetor com as letras do alfabeto
            List<Character> listaLetras = new ArrayList<Character>(letras.length); // lista

            for (char c : letras) {
                listaLetras.add(c); // adiciona as letras do vetor pra lista
            }
            Collections.shuffle(listaLetras); // embaralha a lista

            for (int i = 0; i < letras.length; i++) {
                letras[i] = listaLetras.get(i);   // por de novo no vetor
            }

            char[] vetorLetrasSenha = senha.toCharArray(); // vetor com letras da senha
            char[] vetorSenhaCriptografada = new char[vetorLetrasSenha.length]; // vetor pras letras da senha criptada

            for (int y = 0; y < vetorLetrasSenha.length; y++) {
                char caractere = vetorLetrasSenha[y]; // pega cada caractere
                int posicaoLetra = 0;
                for (int z = 0; z < letras.length; z++) {
                    if (letras[z] == caractere) {
                        posicaoLetra = z; // acha cada um no alfabeto
                    }
                }
                int posicaoNova = posicaoLetra + chave; // incrementa a posicao com a chave
                if (posicaoNova >= 70) {
                    posicaoNova -= 70;
                }
                vetorSenhaCriptografada[y] = letras[posicaoNova]; // poe o caracter novo no vetor
            }

            senhaCriptografada = new String(vetorSenhaCriptografada); // por tudo numa String
        }

        this.senha = senhaCriptografada; // salva na senha
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

    public boolean verificaLogin (String senha, String email) {
        boolean retorno = false;
        if(senha.equals(this.senha) && email.equals(this.email)){
            retorno = true;
        }
        return retorno;
    }

}
