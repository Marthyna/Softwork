package classesDominio;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Aluno extends Pessoa implements Serializable{

    private static final long serialVersionUID = 333L;
    private long matricula;
    private int ano;
    private String curso;
    private int turno;
    private String turnoLiteral;
    private String nomeCompleto;
    private int sexo;
    private String sexoLiteral;
    private long cpf;
    private long rg;
    private LocalDate dataNascimento;
    private int idade;
    private int ID;
    private Curriculo curriculo;

    public Aluno(long matricula, int ano, String curso, int turno, String nomeCompleto, int sexo, long cpf, long rg, LocalDate dataNascimento, Endereco endereco, int telefone, int ddd, String email, String senha) {
        super(endereco, telefone, ddd, email, senha);
        this.matricula = matricula;
        this.ano = ano;
        this.curso = curso;
        this.turno = turno;
        this.nomeCompleto = nomeCompleto;
        this.sexo = sexo;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public String getTurnoLiteral() {
        return turnoLiteral;
    }

    public void setTurnoLiteral() {
        if (this.turno == 1) {
            turnoLiteral = "Manhã";
        } else if (this.turno == 2) {
            turnoLiteral = "Tarde";
        } else if (this.turno == 3) {
            turnoLiteral = "Noite";
        }
        this.turnoLiteral = turnoLiteral;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getSexoLiteral() {
        return sexoLiteral;
    }

    public void setSexoLiteral() {
        if (this.sexo == 1) {
            this.sexoLiteral = "Feminino";
        } else if (this.sexo == 2) {
            this.sexoLiteral = "Masculino";
        }
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getRg() {
        return rg;
    }

    public void setRg(long rg) {
        this.rg = rg;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public int setIdade(final LocalDate dataNascimento) {
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(dataNascimento, dataAtual);
        return periodo.getYears();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

}
