package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

public class EmpresaRecusados extends AppCompatActivity {

    TextView tvHomeNomeEmpresa;
    RecyclerView rvAppsRecusadas;
    AplicacaoAdapter aplicacaoAdapter;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_DETALHA_APP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_recusados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHomeNomeEmpresa = findViewById(R.id.tvHomeNomeEmpresa);
        rvAppsRecusadas = findViewById(R.id.rvAppsRecusadas);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvHomeNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaRecusadosEmpresa");

                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaEmpresa);

                        mensagemRecebida = (String) informacoesApp.in.readObject();

                        if (mensagemRecebida.equals("temAplicacoes")) {
                            informacoesApp.listaAplicacoesRecusadasEmpresa = (LinkedList<Aplicacao>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaAplicacoesRecusadasEmpresa() != null) {
                                aplicacaoAdapter = new AplicacaoAdapter(informacoesApp.getListaAplicacoesRecusadasEmpresa(), trataCliqueItem);
                                rvAppsRecusadas.setLayoutManager(new LinearLayoutManager(EmpresaRecusados.this));
                                rvAppsRecusadas.setItemAnimator(new DefaultItemAnimator());
                                rvAppsRecusadas.setAdapter(aplicacaoAdapter);
                            }

                        } else if (mensagemRecebida.equals("naoTemAplicacoesRecusadas")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há aplicações recusadas!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    AplicacaoAdapter.AplicacaoOnClickListener trataCliqueItem = new AplicacaoAdapter.AplicacaoOnClickListener() {
        @Override
        public void onClickAplicacao(View view, int position) {
            Aplicacao minhaApp = informacoesApp.getListaAplicacoesRecusadasEmpresa().get(position);
            Aluno meuAluno = minhaApp.getAluno();
            Curriculo meuCurriculo = meuAluno.getCurriculo();

            Intent it = new Intent(EmpresaRecusados.this, EmpresaDetalharRecusado.class);
            it.putExtra("app", minhaApp);
            it.putExtra("empresa",minhaEmpresa);
            it.putExtra("aluno", meuAluno);
            it.putExtra("curriculo", meuCurriculo);
            startActivityForResult(it,CODIGO_EMPRESA_DETALHA_APP);
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_EMPRESA_DETALHA_APP){
            if (it != null){
                minhaEmpresa = (Empresa) it.getSerializableExtra("empresa");
            }
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
                Intent it = new Intent(EmpresaRecusados.this, EmpresaConta.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_vagas_abertas:
                Intent it2 = new Intent(EmpresaRecusados.this, EmpresaVagasAbertas.class);
                it2.putExtra("empresa", minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(EmpresaRecusados.this, EmpresaRecusados.class);
                it3.putExtra("empresa", minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaRecusados.this, EmpresaMensagens.class);
                it4.putExtra("empresa", minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_aceitos:
                Intent it5 = new Intent(EmpresaRecusados.this, EmpresaAceitos.class);
                it5.putExtra("empresa", minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaRecusados.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
