package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Aplicacao;
import classesDominio.Vaga;

public class AlunoDetalhaAplicacao extends AppCompatActivity {

    TextView tvDetalhaAppAlunoTitulo, tvDetalhaAppAlunoEmpresa, tvDetalhaAppAlunoSetor,
            tvDetalhaAppAlunoDescricao, tvDetalhaAppAlunoTurno, tvDetalhaAppAlunoSalario,
            tvDetalhaAppAlunoStatus;

    InformacoesApp informacoesApp;

    Vaga vaga;
    Aluno meuAluno;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_detalha_aplicacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvDetalhaAppAlunoTitulo = findViewById(R.id.tvDetalhaAppAlunoTitulo);
        tvDetalhaAppAlunoEmpresa = findViewById(R.id.tvDetalhaAppAlunoEmpresa);
        tvDetalhaAppAlunoSetor = findViewById(R.id.tvDetalhaAppAlunoSetor);
        tvDetalhaAppAlunoDescricao = findViewById(R.id.tvDetalhaAppAlunoDescricao);
        tvDetalhaAppAlunoTurno = findViewById(R.id.tvDetalhaAppAlunoTurno);
        tvDetalhaAppAlunoSalario = findViewById(R.id.tvDetalhaAppAlunoSalario);
        tvDetalhaAppAlunoStatus = findViewById(R.id.tvDetalhaAppAlunoStatus);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");
        vaga = (Vaga) parametrosRecebidos.get("vaga");

        consulta();
    }

    public void consulta() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("detalhaAplicacao");

                    mensagemRecebida = (String) informacoesApp.in.readObject();
                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(vaga.getNome());
                        informacoesApp.out.writeObject(meuAluno);

                        Aplicacao minhaApp = (Aplicacao) informacoesApp.in.readObject();

                        tvDetalhaAppAlunoTitulo.setText("Aplicação para a vaga " + vaga.getNome());

                        tvDetalhaAppAlunoEmpresa.setText(vaga.getEmpresa().getNomeFantasia());

                        tvDetalhaAppAlunoDescricao.setText(vaga.getDescricao());
                        tvDetalhaAppAlunoSetor.setText(vaga.getSetor());
                        tvDetalhaAppAlunoTurno.setText(vaga.getTurnoLiteral());

                        if (vaga.isRemunerada()) {
                            tvDetalhaAppAlunoSalario.setText("R$" + vaga.getSalario());
                        } else {
                            tvDetalhaAppAlunoSalario.setText("-");
                        }

                        String status = "";
                        if (minhaApp.isMovimentada()) {
                            if (minhaApp.isAceita()) {
                                status = "Aceita";
                            } else {
                                status = "Recusada";
                            }
                        } else {
                            status = "Em espera";
                        }

                        tvDetalhaAppAlunoStatus.setText(status);
                    }

                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ((id == android.R.id.home)) {
            Intent it = new Intent();
            it.putExtra("aluno", meuAluno);
            setResult(1, it);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
