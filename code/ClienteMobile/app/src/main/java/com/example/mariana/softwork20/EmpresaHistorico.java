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

import classesDominio.Empresa;
import classesDominio.Vaga;

public class EmpresaHistorico extends AppCompatActivity {

    TextView tvHomeNomeEmpresa;
    RecyclerView rvHistoricoEmpresa;
    VagaHistoricoAdapter vagaHistoricoAdapter;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_DETALHA_VAGA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_historico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHomeNomeEmpresa = findViewById(R.id.tvHomeNomeEmpresa);
        rvHistoricoEmpresa = findViewById(R.id.rvHistoricoEmpresa);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvHomeNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());

        Thread thread = new Thread() {
            @Override
            public void run(){
                try {
                    informacoesApp.out.writeObject("listaVagasEmpresa");
                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaEmpresa);

                        mensagemRecebida = (String) informacoesApp.in.readObject();
                        if (mensagemRecebida.equals("temVagas")) {
                            informacoesApp.listaVagas = (LinkedList<Vaga>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaVagas() != null){
                                vagaHistoricoAdapter = new VagaHistoricoAdapter(informacoesApp.getListaVagas(), trataCliqueItem);
                                rvHistoricoEmpresa.setLayoutManager(new LinearLayoutManager(EmpresaHistorico.this));
                                rvHistoricoEmpresa.setItemAnimator(new DefaultItemAnimator());
                                rvHistoricoEmpresa.setAdapter(vagaHistoricoAdapter);
                            }

                        } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há vagas no histórico.", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }

                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(EmpresaVagasAbertas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        thread.start();
    }

    VagaHistoricoAdapter.VagaHistoricoOnClickListener trataCliqueItem = new VagaHistoricoAdapter.VagaHistoricoOnClickListener() {
        @Override
        public void onClickVaga(View view, int position) {
            Vaga minhaVaga = informacoesApp.getListaVagas().get(position);

            Intent it = new Intent(EmpresaHistorico.this, EmpresaVagaDetalhar.class);
            it.putExtra("vaga", minhaVaga);
            it.putExtra("empresa",minhaEmpresa);
            startActivityForResult(it,CODIGO_EMPRESA_DETALHA_VAGA);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_conta:
                Intent it = new Intent(EmpresaHistorico.this, EmpresaConta.class);
                it.putExtra("empresa",minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_aceitos:
                Intent it2 = new Intent(EmpresaHistorico.this, EmpresaAceitos.class);
                it2.putExtra("empresa",minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_vagas_abertas:
                Intent it3 = new Intent(EmpresaHistorico.this, EmpresaVagasAbertas.class);
                it3.putExtra("empresa",minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaHistorico.this, EmpresaMensagens.class);
                it4.putExtra("empresa",minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaHistorico.this, EmpresaRecusados.class);
                it5.putExtra("empresa",minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaHistorico.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
