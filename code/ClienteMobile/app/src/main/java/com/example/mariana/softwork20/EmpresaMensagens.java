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
import classesDominio.Empresa;
import classesDominio.Mensagem;
import classesDominio.Vaga;

public class EmpresaMensagens extends AppCompatActivity {

    TextView tvHomeNomeEmpresa;
    RecyclerView rvMensagens;
    MensagemAdapter mensagemAdapter;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_DETALHA_MENSAGEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_mensagens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHomeNomeEmpresa = findViewById(R.id.tvHomeNomeEmpresa);
        rvMensagens = findViewById(R.id.rvMensagens);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        tvHomeNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaMensagensEmpresa");

                    mensagemRecebida = (String) informacoesApp.in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        informacoesApp.out.writeObject(minhaEmpresa);

                        mensagemRecebida = (String) informacoesApp.in.readObject();

                        if (mensagemRecebida.equals("temMensagens")) {
                            informacoesApp.listaMensagens = (LinkedList<Mensagem>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaMensagens() != null) {
                                mensagemAdapter = new MensagemAdapter(informacoesApp.getListaMensagens(), trataCliqueItem);
                                rvMensagens.setLayoutManager(new LinearLayoutManager(EmpresaMensagens.this));
                                rvMensagens.setItemAnimator(new DefaultItemAnimator());
                                rvMensagens.setAdapter(mensagemAdapter);
                            }

                        } else if (mensagemRecebida.equals("naoTemMensagens")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Nenhuma mensagem recebida ainda.", Toast.LENGTH_SHORT).show();
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

    MensagemAdapter.MensagemOnClickListener trataCliqueItem = new MensagemAdapter.MensagemOnClickListener() {
        @Override
        public void onClickMensagem(View view, int position) {
            Mensagem minhaMsg = informacoesApp.getListaMensagens().get(position);
            Aluno meuAluno = minhaMsg.getAluno();

            Intent it = new Intent(EmpresaMensagens.this, EmpresaDetalharMensagem.class);

            it.putExtra("mensagem", minhaMsg);
            it.putExtra("empresa", minhaEmpresa);
            it.putExtra("aluno", meuAluno);

            startActivityForResult(it,CODIGO_EMPRESA_DETALHA_MENSAGEM);
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_EMPRESA_DETALHA_MENSAGEM){
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

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_conta:
                Intent it = new Intent(EmpresaMensagens.this, EmpresaConta.class);
                it.putExtra("empresa",minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_aceitos:
                Intent it2 = new Intent(EmpresaMensagens.this, EmpresaAceitos.class);
                it2.putExtra("empresa",minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_vagas_abertas:
                Intent it3 = new Intent(EmpresaMensagens.this, EmpresaVagasAbertas.class);
                it3.putExtra("empresa",minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_historico:
                Intent it4 = new Intent(EmpresaMensagens.this, EmpresaHistorico.class);
                it4.putExtra("empresa",minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaMensagens.this, EmpresaRecusados.class);
                it5.putExtra("empresa",minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaMensagens.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
