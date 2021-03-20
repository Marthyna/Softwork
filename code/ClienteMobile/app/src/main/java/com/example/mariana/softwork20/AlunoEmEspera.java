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
import classesDominio.Vaga;

public class AlunoEmEspera extends AppCompatActivity {

    TextView tvEmEsperaNomeAluno;
    RecyclerView rvEmEsperaAluno;
    VagaAdapter vagaAdapter;
    InformacoesApp informacoesApp;
    String mensagemRecebida = "";
    Aluno meuAluno;

    static final int CODIGO_ALUNO_DETALHA_APP = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_em_espera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvEmEsperaNomeAluno = findViewById(R.id.tvEmEsperaNomeAluno);
        rvEmEsperaAluno = findViewById(R.id.rvEmEsperaAluno);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvEmEsperaNomeAluno.setText(meuAluno.getNomeCompleto());
        consulta();
    }

    public void consulta() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaVagasEmEspera");

                    mensagemRecebida = (String) informacoesApp.in.readObject();
                    if (mensagemRecebida.equals("Ok")) {

                        informacoesApp.out.writeObject(meuAluno);
                        mensagemRecebida = (String) informacoesApp.in.readObject();
                        if (mensagemRecebida.equals("temVagas")) {
                            informacoesApp.listaVagas = (LinkedList<Vaga>) informacoesApp.in.readObject();
                            if (informacoesApp.getListaVagas() != null){
                                vagaAdapter = new VagaAdapter(informacoesApp.getListaVagas(), trataCliqueItem);
                                rvEmEsperaAluno.setLayoutManager(new LinearLayoutManager(AlunoEmEspera.this));
                                rvEmEsperaAluno.setItemAnimator(new DefaultItemAnimator());
                                rvEmEsperaAluno.setAdapter(vagaAdapter);
                            }

                        } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há aplicações em espera!", Toast.LENGTH_SHORT).show();
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

            Intent it = new Intent(AlunoEmEspera.this, AlunoDetalhaAplicacao.class);
            it.putExtra("vaga", minhaVaga);
            it.putExtra("aluno",meuAluno);
            startActivityForResult(it,CODIGO_ALUNO_DETALHA_APP);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_aluno, menu);
        return true;
    }

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_ALUNO_DETALHA_APP){
            if (it != null){
                meuAluno = (Aluno) it.getSerializableExtra("aluno");
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_conta:
                Intent it = new Intent(AlunoEmEspera.this, AlunoConta.class);
                it.putExtra("aluno", meuAluno);
                startActivity(it);
                return true;
            case R.id.item_ofertas:
                Intent it2 = new Intent(AlunoEmEspera.this,AlunoOfertas.class);
                it2.putExtra("aluno", meuAluno);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(AlunoEmEspera.this,AlunoHistorico.class);
                it3.putExtra("aluno", meuAluno);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(AlunoEmEspera.this,AlunoMensagens.class);
                it4.putExtra("aluno", meuAluno);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(AlunoEmEspera.this,AlunoRecusados.class);
                it5.putExtra("aluno",meuAluno);
                startActivity(it5);
                return true;
            case R.id.item_aceitos:
                Intent it6 = new Intent(AlunoEmEspera.this,AlunoAceitos.class);
                it6.putExtra("aluno",meuAluno);
                startActivity(it6);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(AlunoEmEspera.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
