package classesDominio;

import java.io.Serializable;

public class Curriculo implements Serializable{

    private static final long serialVersionUID = 888L;
    private int ID;
    private String descricao;
    private String formacao1;
    private String formacao2;
    private String formacao3;
    private String idioma1;
    private String idioma2;
    private String idioma3;
    private String curso1;
    private String curso2;
    private String curso3;
    private String emprego1;
    private String emprego2;
    private String emprego3;

    public Curriculo(String descricao, String formacao1, String formacao2, String formacao3, String idioma1, String idioma2, String idioma3, String curso1, String curso2, String curso3, String emprego1, String emprego2, String emprego3) {

        this.descricao = descricao;
        this.formacao1 = formacao1;
        this.formacao2 = formacao2;
        this.formacao3 = formacao3;
        this.idioma1 = idioma1;
        this.idioma2 = idioma2;
        this.idioma3 = idioma3;
        this.curso1 = curso1;
        this.curso2 = curso2;
        this.curso3 = curso3;
        this.emprego1 = emprego1;
        this.emprego2 = emprego2;
        this.emprego3 = emprego3;
    }

    public String getIdioma1() {
        return idioma1;
    }

    public void setIdioma1(String idioma1) {
        this.idioma1 = idioma1;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormacao1() {
        return formacao1;
    }

    public void setFormacao1(String formacao1) {
        this.formacao1 = formacao1;
    }

    public String getFormacao2() {
        return formacao2;
    }

    public void setFormacao2(String formacao2) {
        this.formacao2 = formacao2;
    }

    public String getFormacao3() {
        return formacao3;
    }

    public void setFormacao3(String formacao3) {
        this.formacao3 = formacao3;
    }

    public String getIdioma2() {
        return idioma2;
    }

    public void setIdioma2(String idioma2) {
        this.idioma2 = idioma2;
    }

    public String getIdioma3() {
        return idioma3;
    }

    public void setIdioma3(String idioma3) {
        this.idioma3 = idioma3;
    }

    public String getCurso1() {
        return curso1;
    }

    public void setCurso1(String curso1) {
        this.curso1 = curso1;
    }

    public String getCurso2() {
        return curso2;
    }

    public void setCurso2(String curso2) {
        this.curso2 = curso2;
    }

    public String getCurso3() {
        return curso3;
    }

    public void setCurso3(String curso3) {
        this.curso3 = curso3;
    }

    public String getEmprego1() {
        return emprego1;
    }

    public void setEmprego1(String emprego1) {
        this.emprego1 = emprego1;
    }

    public String getEmprego2() {
        return emprego2;
    }

    public void setEmprego2(String emprego2) {
        this.emprego2 = emprego2;
    }

    public String getEmprego3() {
        return emprego3;
    }

    public void setEmprego3(String emprego3) {
        this.emprego3 = emprego3;
    }

}
