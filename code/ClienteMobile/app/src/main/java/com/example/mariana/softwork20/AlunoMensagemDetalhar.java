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
import classesDominio.Empresa;
import classesDominio.Mensagem;

public class AlunoMensagemDetalhar extends AppCompatActivity {

    TextView tvMensagemAlunoDetalharNomeEmpresa, tvMensagemAlunoDetalharDataHora, tvMensagemAlunoDetalharCorpo;
    EditText etMensagemAlunoDetalharResposta;
    Button bMensagemAlunoDetalharEnviar;

    Mensagem minhaMsg;
    Aluno meuAluno;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_mensagem_detalhar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMensagemAlunoDetalharCorpo = findViewById(R.id.tvMensagemAlunoDetalharCorpo);
        tvMensagemAlunoDetalharDataHora = findViewById(R.id.tvMensagemAlunoDetalharDataHora);
        tvMensagemAlunoDetalharNomeEmpresa = findViewById(R.id.tvMensagemAlunoDetalharNomeEmpresa);
        etMensagemAlunoDetalharResposta = findViewById(R.id.etMensagemAlunoDetalharResposta);
        bMensagemAlunoDetalharEnviar = findViewById(R.id.bMensagemAlunoDetalharEnviar);

        bMensagemAlunoDetalharEnviar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");
        minhaMsg = (Mensagem) parametrosRecebidos.get("msg");

        tvMensagemAlunoDetalharNomeEmpresa.setText(minhaMsg.getEmpresa().getNomeFantasia());
        tvMensagemAlunoDetalharDataHora.setText(minhaMsg.getDataHoraEnvio().getDayOfMonth() + "/" + minhaMsg.getDataHoraEnvio().getMonth() + "/" + minhaMsg.getDataHoraEnvio().getYear() + " - " + minhaMsg.getDataHoraEnvio().getHour() + ":" + minhaMsg.getDataHoraEnvio().getMinute());
        tvMensagemAlunoDetalharCorpo.setText(minhaMsg.getMensagem());
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == bMensagemAlunoDetalharEnviar.getId()) {
                if (!etMensagemAlunoDetalharResposta.getText().toString().equals("")) {
                    String mensagem = etMensagemAlunoDetalharResposta.getText().toString();
                    String assunto = minhaMsg.getAssunto() + "/Resposta";
                    boolean alunoRemetente = true;
                    LocalDateTime dataHoraEnvio = LocalDateTime.now();
                    Empresa minhaEmpresa = minhaMsg.getEmpresa();

                    final Mensagem msgResposta = new Mensagem(meuAluno, minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);

                    Thread thread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                informacoesApp.out.writeObject("enviaMensagemAluno");

                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                if (mensagemRecebida.equals("Ok")) {
                                    informacoesApp.out.writeObject(msgResposta);

                                    mensagemRecebida = (String) informacoesApp.in.readObject();

                                    if (mensagemRecebida.equals("mensagemEnviada")) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "Resposta enviada!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        Intent it = new Intent(AlunoMensagemDetalhar.this, AlunoMensagens.class);
                                        it.putExtra("aluno", meuAluno);
                                        startActivity(it);
                                    }
                                }
                            } catch (IOException | ClassNotFoundException ex) {
                                Logger.getLogger(AlunoMensagemDetalhar.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    };
                    thread.start();
                } else {
                    Toast.makeText(informacoesApp, "Escreva algo no corpo da mensagem.", Toast.LENGTH_SHORT).show();
                    etMensagemAlunoDetalharResposta.requestFocus();
                }
            }
        }
    };

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
