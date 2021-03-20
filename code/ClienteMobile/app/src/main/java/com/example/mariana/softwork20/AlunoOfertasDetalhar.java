package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Vaga;

public class AlunoOfertasDetalhar extends AppCompatActivity {

    TextView tvDetalhaVagaAlunoTitulo,tvDetalhaVagaAlunoLocalidade,tvDetalhaVagaAlunoRemunerada,
            tvDetalhaVagaAlunoEmpresa,tvDetalhaVagaAlunoEndereco,tvDetalhaVagaAlunoTelefone,
            tvDetalhaVagaAlunoDescricao,tvDetalhaVagaAlunoTurno,tvDetalhaVagaAlunoSetor;
    Button bDetalhaVagaAlunoEnviar;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    Vaga vaga;
    Aluno meuAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_ofertas_detalhar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvDetalhaVagaAlunoTitulo = findViewById(R.id.tvDetalhaVagaAlunoTitulo);
        tvDetalhaVagaAlunoLocalidade = findViewById(R.id.tvDetalhaVagaAlunoLocalidade);
        tvDetalhaVagaAlunoRemunerada = findViewById(R.id.tvDetalhaVagaAlunoRemunerada);
        tvDetalhaVagaAlunoEmpresa = findViewById(R.id.tvDetalhaVagaAlunoEmpresa);
        tvDetalhaVagaAlunoEndereco = findViewById(R.id.tvDetalhaVagaAlunoEndereco);
        tvDetalhaVagaAlunoTelefone = findViewById(R.id.tvDetalhaVagaAlunoTelefone);
        tvDetalhaVagaAlunoDescricao = findViewById(R.id.tvDetalhaVagaAlunoDescricao);
        tvDetalhaVagaAlunoTurno = findViewById(R.id.tvDetalhaVagaAlunoTurno);
        tvDetalhaVagaAlunoSetor = findViewById(R.id.tvDetalhaVagaAlunoSetor);
        bDetalhaVagaAlunoEnviar = findViewById(R.id.bDetalhaVagaAlunoEnviar);

        bDetalhaVagaAlunoEnviar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        vaga = (Vaga) parametrosRecebidos.get("vaga");
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        tvDetalhaVagaAlunoTitulo.setText(vaga.getNome());
        tvDetalhaVagaAlunoLocalidade.setText(vaga.getEmpresa().getEndereco().getCidade());

        if (vaga.isRemunerada()) {
            tvDetalhaVagaAlunoRemunerada.setText("Remunerada");
        } else {
            tvDetalhaVagaAlunoRemunerada.setText("Não remunerada.");
        }

        tvDetalhaVagaAlunoEmpresa.setText(vaga.getEmpresa().getNomeFantasia());
        String endereco = vaga.getEmpresa().getEndereco().getRua() + ", nº " + vaga.getEmpresa().getEndereco().getNumero() + " - Bairro " + vaga.getEmpresa().getEndereco().getBairro();
        tvDetalhaVagaAlunoEndereco.setText(endereco);
        String telefone = "(" + vaga.getEmpresa().getDdd() + ")-" + vaga.getEmpresa().getTelefone();
        tvDetalhaVagaAlunoTelefone.setText(telefone);
        tvDetalhaVagaAlunoDescricao.setText(vaga.getDescricao());
        tvDetalhaVagaAlunoTurno.setText(vaga.getTurnoLiteral());
        tvDetalhaVagaAlunoSetor.setText(vaga.getSetor());
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == bDetalhaVagaAlunoEnviar.getId()){
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            informacoesApp.out.writeObject("enviaCurriculo");

                            mensagemRecebida = (String) informacoesApp.in.readObject();
                            if (mensagemRecebida.equals("Ok")) {
                                informacoesApp.out.writeObject(meuAluno.getID());
                                informacoesApp.out.writeObject(vaga);

                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                if (mensagemRecebida.equals("temCurriculo")) {
                                    mensagemRecebida = (String) informacoesApp.in.readObject();
                                    if (mensagemRecebida.equals("cadastreiAplicacao")) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "Currículo enviado!", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        Intent it = new Intent(AlunoOfertasDetalhar.this,AlunoOfertas.class);
                                        it.putExtra("aluno",meuAluno);
                                        startActivity(it);
                                    }

                                }
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(AlunoOfertasDetalhar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
            }
        }
    };

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ((id == android.R.id.home)) {
            Intent it = new Intent();
            it.putExtra("aluno", meuAluno);
            setResult(1, it);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
