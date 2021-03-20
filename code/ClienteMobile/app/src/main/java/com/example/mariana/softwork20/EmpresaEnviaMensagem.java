package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Aplicacao;
import classesDominio.Empresa;
import classesDominio.Mensagem;

public class EmpresaEnviaMensagem extends AppCompatActivity {

    TextView tvMensagemNomeAluno;
    EditText etMensagemAssunto,etMensagemConteudo;
    Button bMensagemEnviar;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;
    Aplicacao minhaApp;
    Aluno meuAluno;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_envia_mensagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMensagemNomeAluno = findViewById(R.id.tvMensagemNomeAluno);
        etMensagemAssunto = findViewById(R.id.etMensagemAssunto);
        etMensagemConteudo = findViewById(R.id.etMensagemConteudo);
        bMensagemEnviar = findViewById(R.id.bMensagemEnviar);

        bMensagemEnviar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");
        minhaApp = (Aplicacao) parametrosRecebidos.get("app");
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvMensagemNomeAluno.setText(meuAluno.getNomeCompleto());
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bMensagemEnviar.getId()){
                if (!etMensagemAssunto.getText().toString().equals("")) {
                    if (!etMensagemConteudo.getText().toString().equals("")) {
                        String mensagem = etMensagemConteudo.getText().toString();
                        String assunto = etMensagemAssunto.getText().toString();
                        boolean alunoRemetente = false;
                        LocalDateTime dataHoraEnvio = LocalDateTime.now();

                        final Mensagem msgResposta = new Mensagem(meuAluno, minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);

                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    informacoesApp.out.writeObject("enviaMensagemEmpresa");

                                    mensagemRecebida = (String) informacoesApp.in.readObject();

                                    if (mensagemRecebida.equals("Ok")) {
                                        informacoesApp.out.writeObject(msgResposta);

                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                        if (mensagemRecebida.equals("mensagemEnviada")) {
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(informacoesApp, "Mensagem enviada!", Toast.LENGTH_SHORT).show();
                                                }
                                            });
                                        }
                                    }
                                } catch (IOException | ClassNotFoundException ex) {
                                    Logger.getLogger(EmpresaEnviaMensagem.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        };
                        thread.start();

                    } else {
                        Toast.makeText(informacoesApp, "Escreva algo no corpo da mensagem.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(informacoesApp, "Informe o assunto da mensagem.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ((id == android.R.id.home)) {
            Intent it = new Intent();
            it.putExtra("empresa",minhaEmpresa);
            setResult(1, it);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
