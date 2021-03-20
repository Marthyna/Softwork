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
import android.widget.Button;
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

public class EmpresaRecebidosPorVaga extends AppCompatActivity {

    TextView tvRecebidosNomeVaga;
    Button bRecebidosVagaInformacoesCompleta;
    RecyclerView rvAplicacoesRecebidas;
    AplicacaoAdapter aplicacaoAdapter;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    Vaga minhaVaga;
    Empresa minhaEmpresa;

    static final int CODIGO_EMPRESA_DETALHA_APP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_recebidos_por_vaga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvAplicacoesRecebidas = (RecyclerView) findViewById(R.id.rvAplicacoesRecebidas);

        informacoesApp = (InformacoesApp) getApplicationContext();

        tvRecebidosNomeVaga = findViewById(R.id.tvRecebidosNomeVaga);
        bRecebidosVagaInformacoesCompleta = findViewById(R.id.bRecebidosVagaInformacoesCompleta);

        bRecebidosVagaInformacoesCompleta.setOnClickListener(trataClique);

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaVaga = (Vaga) parametrosRecebidos.get("vaga");
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvRecebidosNomeVaga.setText((CharSequence) minhaVaga.getNome());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaRecebidosPorVaga");

                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaVaga);

                        mensagemRecebida = (String) informacoesApp.in.readObject();

                        if (mensagemRecebida.equals("temAplicacoes")) {
                            informacoesApp.listaAplicacoesRecebidas = (LinkedList<Aplicacao>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaAplicacoesRecebidas() != null) {
                                aplicacaoAdapter = new AplicacaoAdapter(informacoesApp.getListaAplicacoesRecebidas(), trataCliqueItem);
                                rvAplicacoesRecebidas.setLayoutManager(new LinearLayoutManager(EmpresaRecebidosPorVaga.this));
                                rvAplicacoesRecebidas.setItemAnimator(new DefaultItemAnimator());
                                rvAplicacoesRecebidas.setAdapter(aplicacaoAdapter);
                            }

                        } else if (mensagemRecebida.equals("naotemAplicacoes")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há aplicações pendentes para esta vaga.", Toast.LENGTH_SHORT).show();
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
            Aplicacao minhaApp = informacoesApp.getListaAplicacoesRecebidas().get(position);
            Aluno meuAluno = minhaApp.getAluno();
            Curriculo meuCurriculo = meuAluno.getCurriculo();

            Intent it = new Intent(EmpresaRecebidosPorVaga.this, EmpresaDetalharAplicacao.class);
            it.putExtra("aplicacao",minhaApp);
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

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bRecebidosVagaInformacoesCompleta.getId()){
                Intent it = new Intent(EmpresaRecebidosPorVaga.this, EmpresaVagaDetalhar.class);
                it.putExtra("vaga",minhaVaga);
                it.putExtra("empresa",minhaEmpresa);
                startActivity(it);
            }
        }
    };


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
            case R.id.home:
                Intent it = new Intent();
                it.putExtra("empresa",minhaEmpresa);
                setResult(1,it);
                finish();
                return true;
            case R.id.item_conta:
                Intent it1 = new Intent(EmpresaRecebidosPorVaga.this, EmpresaConta.class);
                it1.putExtra("empresa", minhaEmpresa);
                startActivity(it1);
                return true;
            case R.id.item_vagas_abertas:
                Intent it2 = new Intent(EmpresaRecebidosPorVaga.this, EmpresaVagasAbertas.class);
                it2.putExtra("empresa", minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(EmpresaRecebidosPorVaga.this,EmpresaHistorico.class);
                it3.putExtra("empresa",minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaRecebidosPorVaga.this,EmpresaMensagens.class);
                it4.putExtra("empresa",minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaRecebidosPorVaga.this,EmpresaRecusados.class);
                it5.putExtra("empresa",minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_aceitos:
                Intent it6 = new Intent(EmpresaRecebidosPorVaga.this,EmpresaAceitos.class);
                it6.putExtra("empresa",minhaEmpresa);
                startActivity(it6);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
