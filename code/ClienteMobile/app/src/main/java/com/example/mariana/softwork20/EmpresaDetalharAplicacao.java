package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Aplicacao;
import classesDominio.Curriculo;
import classesDominio.Empresa;

public class EmpresaDetalharAplicacao extends AppCompatActivity {

    ImageButton ibDetalhaAppRecusa,ibDetalhaAppAceita;
    TextView tvDetalhaAppNomeAluno,tvDetalhaAppCidade,tvDetalhaAppEmail,
            tvDetalhaAppTelefone,tvDetalhaAppCurso,tvDetalhaAppAno,
            tvDetalhaAppDescricao,tvDetalhaAppIdioma1,tvDetalhaAppIdioma2,
            tvDetalhaAppIdioma3,tvDetalhaAppFormacao1,tvDetalhaAppFormacao2,
            tvDetalhaAppFormacao3,tvDetalhaAppEmprego1,tvDetalhaAppEmprego2,
            tvDetalhaAppEmprego3,tvDetalhaAppCurso1,tvDetalhaAppCurso2,
            tvDetalhaAppCurso3;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    Aplicacao minhaApp;
    Empresa minhaEmpresa;
    Aluno meuAluno;
    Curriculo meuCurriculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_detalhar_aplicacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ibDetalhaAppAceita = findViewById(R.id.ibDetalhaAppAceita);
        ibDetalhaAppRecusa = findViewById(R.id.ibDetalhaAppRecusa);
        tvDetalhaAppAno = findViewById(R.id.tvDetalhaAppAno);
        tvDetalhaAppCidade = findViewById(R.id.tvDetalhaAppCidade);
        tvDetalhaAppCurso = findViewById(R.id.tvDetalhaAppCurso);
        tvDetalhaAppTelefone = findViewById(R.id.tvDetalhaAppTelefone);
        tvDetalhaAppEmail = findViewById(R.id.tvDetalhaAppEmail);
        tvDetalhaAppCurso1 = findViewById(R.id.tvDetalhaAppCurso1);
        tvDetalhaAppCurso2 = findViewById(R.id.tvDetalhaAppCurso2);
        tvDetalhaAppCurso3 = findViewById(R.id.tvDetalhaAppCurso3);
        tvDetalhaAppEmprego1 = findViewById(R.id.tvDetalhaAppEmprego1);
        tvDetalhaAppEmprego2 = findViewById(R.id.tvDetalhaAppEmprego2);
        tvDetalhaAppEmprego3 = findViewById(R.id.tvDetalhaAppEmprego3);
        tvDetalhaAppFormacao1 = findViewById(R.id.tvDetalhaAppFormacao1);
        tvDetalhaAppFormacao2 = findViewById(R.id.tvDetalhaAppFormacao2);
        tvDetalhaAppFormacao3 = findViewById(R.id.tvDetalhaAppFormacao3);
        tvDetalhaAppNomeAluno = findViewById(R.id.tvDetalhaAppNomeAluno);
        tvDetalhaAppIdioma1 = findViewById(R.id.tvDetalhaAppIdioma1);
        tvDetalhaAppIdioma2 = findViewById(R.id.tvDetalhaAppIdioma2);
        tvDetalhaAppIdioma3 = findViewById(R.id.tvDetalhaAppIdioma3);
        tvDetalhaAppDescricao = findViewById(R.id.tvDetalhaAppDescricao);

        ibDetalhaAppRecusa.setOnClickListener(trataClique);
        ibDetalhaAppAceita.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaApp = (Aplicacao) parametrosRecebidos.get("aplicacao");
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");
        meuCurriculo = (Curriculo) parametrosRecebidos.get("curriculo");

        tvDetalhaAppNomeAluno.setText(meuAluno.getNomeCompleto());
        tvDetalhaAppCidade.setText(meuAluno.getEndereco().getCidade());
        tvDetalhaAppCurso.setText("Curso: " + meuAluno.getCurso());
        tvDetalhaAppAno.setText("Ano: " + meuAluno.getAno() + "º ano");
        tvDetalhaAppTelefone.setText("Telefone: (" + meuAluno.getDdd() + ") " + meuAluno.getTelefone());
        tvDetalhaAppEmail.setText("Email: " + meuAluno.getEmail());

        tvDetalhaAppDescricao.setText("Descrição: " + meuCurriculo.getDescricao());
        tvDetalhaAppCurso1.setText("Curso 1: " + meuCurriculo.getCurso1());
        tvDetalhaAppCurso2.setText("Curso 2: " + meuCurriculo.getCurso2());
        tvDetalhaAppCurso3.setText("Curso 3: " + meuCurriculo.getCurso3());
        tvDetalhaAppFormacao1.setText("Formação 1: " + meuCurriculo.getFormacao1());
        tvDetalhaAppFormacao2.setText("Formação 2: " + meuCurriculo.getFormacao2());
        tvDetalhaAppFormacao3.setText("Formação 3: " + meuCurriculo.getFormacao3());
        tvDetalhaAppIdioma1.setText("Idioma 1: " + meuCurriculo.getIdioma1());
        tvDetalhaAppIdioma2.setText("Idioma 2: " + meuCurriculo.getIdioma2());
        tvDetalhaAppIdioma3.setText("Idioma 3: " + meuCurriculo.getIdioma3());
        tvDetalhaAppEmprego1.setText("Emprego 1: " + meuCurriculo.getEmprego1());
        tvDetalhaAppEmprego2.setText("Emprego 2: " + meuCurriculo.getEmprego2());
        tvDetalhaAppEmprego3.setText("Emprego 3: " + meuCurriculo.getEmprego3());
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == ibDetalhaAppAceita.getId()){
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            informacoesApp.out.writeObject("aceitarAplicacao");

                            mensagemRecebida = (String) informacoesApp.in.readObject();

                            if(mensagemRecebida.equals("Ok")){
                                informacoesApp.out.writeObject(minhaApp);

                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                if(mensagemRecebida.equals("aplicacaoAceita")){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "Aplicação aceita!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(EmpresaDetalharAplicacao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
            }else if (view.getId() == ibDetalhaAppRecusa.getId()){
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            informacoesApp.out.writeObject("recusarAplicacao");

                            mensagemRecebida = (String) informacoesApp.in.readObject();

                            if(mensagemRecebida.equals("Ok")){
                                informacoesApp.out.writeObject(minhaApp);

                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                if(mensagemRecebida.equals("aplicacaoRecusada")){
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "Aplicação recusada!", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(EmpresaDetalharAplicacao.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent it = new Intent();
            it.putExtra("empresa",minhaEmpresa);
            setResult(1,it);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
