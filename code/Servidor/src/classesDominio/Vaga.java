package classesDominio;

import java.io.Serializable;
import java.time.LocalDate;

public class Vaga implements Serializable{
    private static final long serialVersionUID = 777L;
    private String nome;
    private String setor;
    private boolean remunerada;
    private float salario;
    private String descricao;
    private boolean preenchida;
    private int turno;
    private String turnoLiteral;
    private Empresa empresa;
    private int ID;
    private LocalDate dataPublicacao;
    private int totalAplicacoes;

    public Vaga(String nome, String setor, boolean remunerada, String descricao, boolean preenchida, int turno, LocalDate dataPublicacao, int totalAplicacoes, Empresa empresa) {
        this.nome = nome;
        this.setor = setor;
        this.remunerada = remunerada;
        this.descricao = descricao;
        this.preenchida = false;
        this.turno = turno;
        this.empresa = empresa;
        this.dataPublicacao = dataPublicacao;
        this.totalAplicacoes = totalAplicacoes;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public boolean isRemunerada() {
        return remunerada;
    }

    public void setRemunerada(boolean remunerada) {
        this.remunerada = remunerada;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {        
        this.salario = salario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isPreenchida() {
        return preenchida;
    }

    public void setPreenchida(boolean preenchida) {
        this.preenchida = preenchida;
    }

    public String getTurnoLiteral() {
        return turnoLiteral;
    }

    public void setTurnoLiteral() {
        switch (this.turno) {
            case 1:
                turnoLiteral = "Manhã";
                break;
            case 2:
                turnoLiteral = "Tarde";
                break;
            case 3:
                turnoLiteral = "Noite";
                break;
            default:
                break;
        }
        this.turnoLiteral = turnoLiteral;
    }

    public void preencheVaga(){
        this.preenchida = true;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public int getTotalAplicacoes() {
        return totalAplicacoes;
    }

    public void setTotalAplicacoes(int totalAplicacoes) {
        this.totalAplicacoes = totalAplicacoes;
    }
}
