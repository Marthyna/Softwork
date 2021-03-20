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

import java.time.format.DateTimeFormatter;

import classesDominio.Aluno;
import classesDominio.Empresa;
import classesDominio.Mensagem;

public class EmpresaDetalharMensagem extends AppCompatActivity {

    TextView tvMensagemDetalharNomeAluno, tvMensagemDetalharDataHora, tvMensagemDetalharCorpo;

    Mensagem minhaMsg;
    Empresa minhaEmpresa;
    Aluno meuAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_detalhar_mensagem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvMensagemDetalharCorpo = findViewById(R.id.tvMensagemDetalharCorpo);
        tvMensagemDetalharDataHora = findViewById(R.id.tvMensagemDetalharDataHora);
        tvMensagemDetalharNomeAluno = findViewById(R.id.tvMensagemDetalharNomeAluno);

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaMsg = (Mensagem) parametrosRecebidos.get("mensagem");
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvMensagemDetalharNomeAluno.setText(meuAluno.getNomeCompleto());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        tvMensagemDetalharDataHora.setText(minhaMsg.getDataHoraEnvio().format(formato));
        tvMensagemDetalharCorpo.setText(minhaMsg.getMensagem());
    }

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
