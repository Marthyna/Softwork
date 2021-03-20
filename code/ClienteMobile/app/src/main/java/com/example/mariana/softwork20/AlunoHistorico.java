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
import classesDominio.Empresa;
import classesDominio.Vaga;

public class AlunoHistorico extends AppCompatActivity {

    TextView tvHistoricoNomeAluno;
    RecyclerView rvHistoricoAluno;
    InformacoesApp informacoesApp;
    AplicacaoHistoricoAdapter aplicacaoHistoricoAdapter;
    Aluno meuAluno;
    String mensagemRecebida = "";

    static final int CODIGO_ALUNO_DETALHA_APP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_historico);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvHistoricoNomeAluno = findViewById(R.id.tvHistoricoNomeAluno);
        rvHistoricoAluno = findViewById(R.id.rvHistoricoAluno);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvHistoricoNomeAluno.setText(meuAluno.getNomeCompleto());
        consulta();
    }

    public void consulta() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaVagasHistorico");

                    mensagemRecebida = (String) informacoesApp.in.readObject();
                    if (mensagemRecebida.equals("Ok")) {

                        informacoesApp.out.writeObject(meuAluno);
                        mensagemRecebida = (String) informacoesApp.in.readObject();
                        if (mensagemRecebida.equals("temAplicacoes")) {
                            informacoesApp.listaAplicacoesHistorico = (LinkedList<Aplicacao>) informacoesApp.in.readObject();
                            if (informacoesApp.getListaVagas() != null){
                                aplicacaoHistoricoAdapter = new AplicacaoHistoricoAdapter(informacoesApp.getListaAplicacoesHistorico(), trataCliqueItem);
                                rvHistoricoAluno.setLayoutManager(new LinearLayoutManager(AlunoHistorico.this));
                                rvHistoricoAluno.setItemAnimator(new DefaultItemAnimator());
                                rvHistoricoAluno.setAdapter(aplicacaoHistoricoAdapter);
                            }

                        } else if (mensagemRecebida.equals("nenhumaAplicacao")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há aplicações no histórico!", Toast.LENGTH_SHORT).show();
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

    AplicacaoHistoricoAdapter.AplicacaoHistoricoOnClickListener trataCliqueItem = new AplicacaoHistoricoAdapter.AplicacaoHistoricoOnClickListener() {
        @Override
        public void onClickAplicacaoHistorico(View view, int position) {
            Aplicacao minhaApp = informacoesApp.getListaAplicacoesHistorico().get(position);
            Vaga minhaVaga = minhaApp.getVaga();
            Intent it = new Intent(AlunoHistorico.this, AlunoDetalhaAplicacao.class);
            it.putExtra("app", minhaApp);
            it.putExtra("aluno",meuAluno);
            it.putExtra("vaga",minhaVaga);
            startActivityForResult(it,CODIGO_ALUNO_DETALHA_APP);
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_ALUNO_DETALHA_APP){
            if (it != null){
                meuAluno = (Aluno) it.getSerializableExtra("aluno");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_conta:
                Intent it = new Intent(AlunoHistorico.this, AlunoConta.class);
                it.putExtra("aluno", meuAluno);
                startActivity(it);
                return true;
            case R.id.item_ofertas:
                Intent it2 = new Intent(AlunoHistorico.this,AlunoOfertas.class);
                it2.putExtra("aluno", meuAluno);
                startActivity(it2);
                return true;
            case R.id.item_em_espera:
                Intent it3 = new Intent(AlunoHistorico.this,AlunoEmEspera.class);
                it3.putExtra("aluno", meuAluno);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(AlunoHistorico.this,AlunoMensagens.class);
                it4.putExtra("aluno", meuAluno);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(AlunoHistorico.this,AlunoRecusados.class);
                it5.putExtra("aluno",meuAluno);
                startActivity(it5);
                return true;
            case R.id.item_aceitos:
                Intent it6 = new Intent(AlunoHistorico.this,AlunoAceitos.class);
                it6.putExtra("aluno",meuAluno);
                startActivity(it6);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(AlunoHistorico.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
