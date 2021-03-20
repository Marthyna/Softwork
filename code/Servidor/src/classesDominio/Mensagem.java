package classesDominio;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Mensagem implements Serializable {
    
    private static final long serialVersionUID = 999L;
    
    private Aluno aluno;
    private Empresa empresa;
    private String mensagem;
    private String assunto;
    private boolean alunoRemetente;
    private int ID;
    private LocalDateTime dataHoraEnvio;

    public Mensagem(Aluno aluno, Empresa empresa, String mensagem, String assunto, boolean alunoRemetente, LocalDateTime dataHoraEnvio) {
        this.aluno = aluno;
        this.empresa = empresa;
        this.mensagem = mensagem;
        this.assunto = assunto;
        this.alunoRemetente = alunoRemetente;
        this.dataHoraEnvio = dataHoraEnvio;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public boolean isAlunoRemetente() {
        return alunoRemetente;
    }

    public void setAlunoRemetente(boolean alunoRemetente) {
        this.alunoRemetente = alunoRemetente;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDateTime getDataHoraEnvio() {
        return dataHoraEnvio;
    }

    public void setDataHoraEnvio(LocalDateTime dataHoraEnvio) {
        this.dataHoraEnvio = dataHoraEnvio;
    }
}
