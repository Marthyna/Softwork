package classesDominio;

import java.io.Serializable;

public class Aplicacao implements Serializable {

    private static final long serialVersionUID = 888L;
    private Aluno aluno;
    private Vaga vaga;
    private boolean aceita;
    private boolean movimentada;
    private int ID;

    public Aplicacao(Aluno aluno, Vaga vaga, boolean movimentada) {
        this.aluno = aluno;
        this.vaga = vaga;
        this.movimentada = movimentada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public boolean isAceita() {
        return aceita;
    }

    public void setAceita(boolean aceita) {
        this.aceita = aceita;
    }

    public boolean isMovimentada() {
        return movimentada;
    }

    public void setMovimentada(boolean movimentada) {
        this.movimentada = movimentada;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
