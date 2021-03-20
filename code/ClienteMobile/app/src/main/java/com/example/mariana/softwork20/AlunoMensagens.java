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
import classesDominio.Mensagem;

public class AlunoMensagens extends AppCompatActivity {

    TextView tvMensagensNomeAluno;
    RecyclerView rvMensagensAluno;
    InformacoesApp informacoesApp;
    String mensagemRecebida = "";
    Aluno meuAluno;
    MensagemAlunoAdapter mensagemAlunoAdapter;

    static final int CODIGO_ALUNO_DETALHA_MENSAGEM = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_mensagens);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMensagensNomeAluno = findViewById(R.id.tvMensagensNomeAluno);
        rvMensagensAluno = findViewById(R.id.rvMensagensAluno);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvMensagensNomeAluno.setText(meuAluno.getNomeCompleto());
        consulta();
    }

    public void consulta() {
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    informacoesApp.out.writeObject("listaMensagensAluno");

                    mensagemRecebida = (String) informacoesApp.in.readObject();
                    if (mensagemRecebida.equals("Ok")) {

                        informacoesApp.out.writeObject(meuAluno);
                        mensagemRecebida = (String) informacoesApp.in.readObject();
                        if (mensagemRecebida.equals("temMensagens")) {

                            informacoesApp.listaMensagensAluno = (LinkedList<Mensagem>) informacoesApp.in.readObject();

                            if (informacoesApp.getListaMensagensAluno() != null){
                                mensagemAlunoAdapter = new MensagemAlunoAdapter(informacoesApp.getListaMensagensAluno(), trataCliqueItem);
                                rvMensagensAluno.setLayoutManager(new LinearLayoutManager(AlunoMensagens.this));
                                rvMensagensAluno.setItemAnimator(new DefaultItemAnimator());
                                rvMensagensAluno.setAdapter(mensagemAlunoAdapter);
                            }

                        } else if (mensagemRecebida.equals("naoTemMensagens")) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(informacoesApp, "Não há mensagens na caixa de entrada!", Toast.LENGTH_SHORT).show();
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

    MensagemAlunoAdapter.MensagemAlunoOnClickListener trataCliqueItem = new MensagemAlunoAdapter.MensagemAlunoOnClickListener() {
        @Override
        public void onClickMensagemAluno(View view, int position) {
            Mensagem minhaMsg = informacoesApp.getListaMensagensAluno().get(position);

            Intent it = new Intent(AlunoMensagens.this, AlunoMensagemDetalhar.class);
            it.putExtra("msg", minhaMsg);
            it.putExtra("aluno",meuAluno);
            startActivityForResult(it,CODIGO_ALUNO_DETALHA_MENSAGEM);
        }
    };

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_ALUNO_DETALHA_MENSAGEM){
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
                Intent it = new Intent(AlunoMensagens.this, AlunoConta.class);
                it.putExtra("aluno", meuAluno);
                startActivity(it);
                return true;
            case R.id.item_ofertas:
                Intent it2 = new Intent(AlunoMensagens.this,AlunoOfertas.class);
                it2.putExtra("aluno", meuAluno);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(AlunoMensagens.this,AlunoHistorico.class);
                it3.putExtra("aluno",meuAluno);
                startActivity(it3);
                return true;
            case R.id.item_aceitos:
                Intent it4 = new Intent(AlunoMensagens.this,AlunoAceitos.class);
                it4.putExtra("aluno",meuAluno);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(AlunoMensagens.this,AlunoRecusados.class);
                it5.putExtra("aluno",meuAluno);
                startActivity(it5);
                return true;
            case R.id.item_em_espera:
                Intent it6 = new Intent(AlunoMensagens.this,AlunoRecusados.class);
                it6.putExtra("aluno",meuAluno);
                startActivity(it6);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(AlunoMensagens.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
