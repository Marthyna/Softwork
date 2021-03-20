package com.example.mariana.softwork20;

import android.app.Application;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

import classesDominio.Aplicacao;
import classesDominio.Mensagem;
import classesDominio.Vaga;

public class InformacoesApp extends Application {
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;
    String[] alfabetosCriptografia = new String[3];

    LinkedList<Vaga> listaVagas = new LinkedList<>();
    LinkedList<Mensagem> listaMensagens = new LinkedList<>();
    LinkedList<Vaga> listaVagasEmEspera = new LinkedList<>();
    LinkedList<Vaga> listaVagasAceitas = new LinkedList<>();

    public Socket getCliente() {
        return cliente;
    }

    public void setCliente(Socket cliente) {
        this.cliente = cliente;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }

    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public String[] getAlfabetosCriptografia() {
        return alfabetosCriptografia;
    }

    public void setAlfabetosCriptografia(String[] alfabetosCriptografia) {
        this.alfabetosCriptografia = alfabetosCriptografia;
    }

    public LinkedList<Vaga> getListaVagas() {
        return listaVagas;
    }

    public void setListaVagas(LinkedList<Vaga> listaVagas) {
        this.listaVagas = listaVagas;
    }

    public LinkedList<Mensagem> getListaMensagens() {
        return listaMensagens;
    }

    public void setListaMensagens(LinkedList<Mensagem> listaMensagens) {
        this.listaMensagens = listaMensagens;
    }

    public LinkedList<Vaga> getListaVagasEmEspera() {
        return listaVagasEmEspera;
    }

    public void setListaVagasEmEspera(LinkedList<Vaga> listaVagasEmEspera) {
        this.listaVagasEmEspera = listaVagasEmEspera;
    }

    public LinkedList<Vaga> getListaVagasAceitas() {
        return listaVagasAceitas;
    }

    public void setListaVagasAceitas(LinkedList<Vaga> listaVagasAceitas) {
        this.listaVagasAceitas = listaVagasAceitas;
    }

    public LinkedList<Vaga> getListaVagasRecusadas() {
        return listaVagasRecusadas;
    }

    public void setListaVagasRecusadas(LinkedList<Vaga> listaVagasRecusadas) {
        this.listaVagasRecusadas = listaVagasRecusadas;
    }

    public LinkedList<Aplicacao> getListaAplicacoesHistorico() {
        return listaAplicacoesHistorico;
    }

    public void setListaAplicacoesHistorico(LinkedList<Aplicacao> listaAplicacoesHistorico) {
        this.listaAplicacoesHistorico = listaAplicacoesHistorico;
    }

    public LinkedList<Mensagem> getListaMensagensAluno() {
        return listaMensagensAluno;
    }

    public void setListaMensagensAluno(LinkedList<Mensagem> listaMensagensAluno) {
        this.listaMensagensAluno = listaMensagensAluno;
    }

    public LinkedList<Mensagem> getListaMensagensEmpresa() {
        return listaMensagensEmpresa;
    }

    public void setListaMensagensEmpresa(LinkedList<Mensagem> listaMensagensEmpresa) {
        this.listaMensagensEmpresa = listaMensagensEmpresa;
    }

    public LinkedList<Vaga> getListaVagasAbertasEmpresa() {
        return listaVagasAbertasEmpresa;
    }

    public void setListaVagasAbertasEmpresa(LinkedList<Vaga> listaVagasAbertasEmpresa) {
        this.listaVagasAbertasEmpresa = listaVagasAbertasEmpresa;
    }

    public LinkedList<Vaga> getListaVagasHistoricoEmpresa() {
        return listaVagasHistoricoEmpresa;
    }

    public void setListaVagasHistoricoEmpresa(LinkedList<Vaga> listaVagasHistoricoEmpresa) {
        this.listaVagasHistoricoEmpresa = listaVagasHistoricoEmpresa;
    }

    public LinkedList<Aplicacao> getListaAplicacoesRecebidas() {
        return listaAplicacoesRecebidas;
    }

    public void setListaAplicacoesRecebidas(LinkedList<Aplicacao> listaAplicacoesRecebidas) {
        this.listaAplicacoesRecebidas = listaAplicacoesRecebidas;
    }

    public LinkedList<Aplicacao> getListaAplicacoesAceitas() {
        return listaAplicacoesAceitas;
    }

    public void setListaAplicacoesAceitas(LinkedList<Aplicacao> listaAplicacoesAceitas) {
        this.listaAplicacoesAceitas = listaAplicacoesAceitas;
    }

    public LinkedList<Aplicacao> getListaAplicacoesRecusadasEmpresa() {
        return listaAplicacoesRecusadasEmpresa;
    }

    public void setListaAplicacoesRecusadasEmpresa(LinkedList<Aplicacao> listaAplicacoesRecusadasEmpresa) {
        this.listaAplicacoesRecusadasEmpresa = listaAplicacoesRecusadasEmpresa;
    }

    public LinkedList<Aplicacao> getListaAplicacoesPorVaga() {
        return listaAplicacoesPorVaga;
    }

    public void setListaAplicacoesPorVaga(LinkedList<Aplicacao> listaAplicacoesPorVaga) {
        this.listaAplicacoesPorVaga = listaAplicacoesPorVaga;
    }

    LinkedList<Vaga> listaVagasRecusadas = new LinkedList<>();
    LinkedList<Aplicacao> listaAplicacoesHistorico = new LinkedList<>();
    LinkedList<Mensagem> listaMensagensAluno = new LinkedList<>();
    LinkedList<Mensagem> listaMensagensEmpresa = new LinkedList<>();
    LinkedList<Vaga> listaVagasAbertasEmpresa = new LinkedList<>();
    LinkedList<Vaga> listaVagasHistoricoEmpresa = new LinkedList<>();
    LinkedList<Aplicacao> listaAplicacoesRecebidas = new LinkedList<>();
    LinkedList<Aplicacao> listaAplicacoesAceitas = new LinkedList<>();
    LinkedList<Aplicacao> listaAplicacoesRecusadasEmpresa = new LinkedList<>();
    LinkedList<Aplicacao> listaAplicacoesPorVaga = new LinkedList<>();



    @Override
    public void onCreate(){

        super.onCreate();
        this.alfabetosCriptografia[0] = "KoqCRZw0cvG&fmrMp*iYW@OALEsgUzS3kytP#e1BNV2$bja4xn8J%TFQ5l6I7uH-9D+hdX";
        this.alfabetosCriptografia[1] = "sXqNOh%MFrT1J0Lk*GB#825-dAPUI$ljzQY3vfRa7VgKtiucZ@opnwSeHx&E64yCbm+WD9";
        this.alfabetosCriptografia[2] = "iD128oHvFZE+U-SuMX3eAxB*nhmjpszYcqwR&kGb%KVI5arPt7W$L940dT#OQJl@6NgCfy";
    }
}
