package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;
import classesDominio.Vaga;

public class EmpresaVagasAbertas extends AppCompatActivity {

    RecyclerView rvVagasAbertas;
    VagaAdapter vagaAdapter;
    InformacoesApp informacoesApp;

    TextView tvHomeNomeEmpresa;
    Button bHomeCadastrarVaga;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_DETALHA_VAGA = 1;
    static final int CODIGO_EMPRESA_CADASTRA_VAGA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_vagas_abertas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvVagasAbertas = (RecyclerView) findViewById(R.id.rvVagasAbertas);

        informacoesApp = (InformacoesApp) getApplicationContext();

        tvHomeNomeEmpresa = findViewById(R.id.tvHomeNomeEmpresa);
        bHomeCadastrarVaga = findViewById(R.id.bHomeCadastrarVaga);

        bHomeCadastrarVaga.setOnClickListener(trataClique);

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvHomeNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaVagasAbertasEmpresa");

                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaEmpresa);

                        mensagemRecebida = (String) informacoesApp.in.readObject();

                        if (mensagemRecebida.equals("temVagas")) {
                            informacoesApp.listaVagas = (LinkedList<Vaga>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaVagas() != null) {
                                vagaAdapter = new VagaAdapter(informacoesApp.getListaVagas(), trataCliqueItem);
                                rvVagasAbertas.setLayoutManager(new LinearLayoutManager(EmpresaVagasAbertas.this));
                                rvVagasAbertas.setItemAnimator(new DefaultItemAnimator());
                                rvVagasAbertas.setAdapter(vagaAdapter);
                            }

                        } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há vagas abertas no momento!", Toast.LENGTH_SHORT).show();
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

    VagaAdapter.VagaOnClickListener trataCliqueItem = new VagaAdapter.VagaOnClickListener() {
        @Override
        public void onClickVaga(View view, int position) {
            Vaga minhaVaga = informacoesApp.getListaVagas().get(position);

            Intent it = new Intent(EmpresaVagasAbertas.this, EmpresaRecebidosPorVaga.class);
            it.putExtra("vaga", minhaVaga);
            it.putExtra("empresa", minhaEmpresa);
            startActivity(it);
        }
    };

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bHomeCadastrarVaga.getId()) {
                Intent it = new Intent(EmpresaVagasAbertas.this, EmpresaCadastrarVaga.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivity(it);
            }
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
                Intent it = new Intent(EmpresaVagasAbertas.this, EmpresaConta.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_aceitos:
                Intent it2 = new Intent(EmpresaVagasAbertas.this, EmpresaAceitos.class);
                it2.putExtra("empresa", minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(EmpresaVagasAbertas.this, EmpresaHistorico.class);
                it3.putExtra("empresa", minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaVagasAbertas.this, EmpresaMensagens.class);
                it4.putExtra("empresa", minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaVagasAbertas.this, EmpresaRecusados.class);
                it5.putExtra("empresa", minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaVagasAbertas.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
