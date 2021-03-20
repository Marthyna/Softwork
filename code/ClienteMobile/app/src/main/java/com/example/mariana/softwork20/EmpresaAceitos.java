package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Aplicacao;
import classesDominio.Curriculo;
import classesDominio.Empresa;
import classesDominio.Vaga;

public class EmpresaAceitos extends AppCompatActivity {

    TextView tvHomeNomeEmpresa;

    RecyclerView rvAppsAceitas;
    AplicacaoAdapter aplicacaoAdapter;
    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_DETALHA_ACEITO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_aceitos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHomeNomeEmpresa = findViewById(R.id.tvHomeNomeEmpresa);
        rvAppsAceitas = (RecyclerView) findViewById(R.id.rvAppsAceitas);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvHomeNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaAceitosEmpresa");

                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaEmpresa);

                        mensagemRecebida = (String) informacoesApp.in.readObject();
                        if (mensagemRecebida.equals("temAplicacoes")) {
                            informacoesApp.listaAplicacoesAceitas = (LinkedList<Aplicacao>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaAplicacoesAceitas() != null) {
                                aplicacaoAdapter = new AplicacaoAdapter(informacoesApp.getListaAplicacoesAceitas(), trataCliqueItem);
                                rvAppsAceitas.setLayoutManager(new LinearLayoutManager(EmpresaAceitos.this));
                                rvAppsAceitas.setItemAnimator(new DefaultItemAnimator());
                                rvAppsAceitas.setAdapter(aplicacaoAdapter);
                            }
                        } else if (mensagemRecebida.equals("naoTemAplicacoesAceitas")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há aplicações aceitas!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(EmpresaAceitos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    AplicacaoAdapter.AplicacaoOnClickListener trataCliqueItem = new AplicacaoAdapter.AplicacaoOnClickListener() {
        @Override
        public void onClickAplicacao(View view, int position) {
            Aplicacao minhaApp = informacoesApp.getListaAplicacoesAceitas().get(position);
            Aluno meuAluno = minhaApp.getAluno();
            Curriculo meuCurriculo = meuAluno.getCurriculo();

            Intent it = new Intent(EmpresaAceitos.this, EmpresaDetalharAceitos.class);
            it.putExtra("app", minhaApp);
            it.putExtra("empresa", minhaEmpresa);
            it.putExtra("aluno", meuAluno);
            it.putExtra("curriculo", meuCurriculo);
            startActivityForResult(it, CODIGO_EMPRESA_DETALHA_ACEITO);
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it) {
        if (it != null) {
            minhaEmpresa = (Empresa) it.getSerializableExtra("empresa");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_empresa, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_conta:
                Intent it = new Intent(EmpresaAceitos.this, EmpresaConta.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_vagas_abertas:
                Intent it2 = new Intent(EmpresaAceitos.this, EmpresaVagasAbertas.class);
                it2.putExtra("empresa", minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(EmpresaAceitos.this,EmpresaHistorico.class);
                it3.putExtra("empresa",minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaAceitos.this,EmpresaMensagens.class);
                it4.putExtra("empresa",minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaAceitos.this,EmpresaRecusados.class);
                it5.putExtra("empresa",minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaAceitos.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
