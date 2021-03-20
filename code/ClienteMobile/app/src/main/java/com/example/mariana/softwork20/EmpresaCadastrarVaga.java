package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;
import classesDominio.Vaga;

public class EmpresaCadastrarVaga extends AppCompatActivity {

    EditText etCadastroVagaTitulo,etCadastroVagaDescricao,etCadastroVagaSetor,
            etCadastroVagaSalario;
    Spinner spCadastroVagaTurno;
    RadioButton rbCadastroVagaSim,rbCadastroVagaNao;
    Button bCadastroVagaCadastrar, bCadastroVagaVoltar;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_vaga);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroVagaTitulo = findViewById(R.id.etCadastroVagaTitulo);
        etCadastroVagaDescricao = findViewById(R.id.etCadastroVagaDescricao);
        etCadastroVagaSetor = findViewById(R.id.etCadastroVagaSetor);
        etCadastroVagaSalario = findViewById(R.id.etCadastroVagaSalario);
        spCadastroVagaTurno = findViewById(R.id.spCadastroVagaTurno);
        rbCadastroVagaSim = findViewById(R.id.rbCadastroVagaSim);
        rbCadastroVagaNao = findViewById(R.id.rbCadastroVagaNao);
        bCadastroVagaCadastrar = findViewById(R.id.bCadastroVagaCadastrar);
        bCadastroVagaVoltar = findViewById(R.id.bCadastroVagaVoltar);

        bCadastroVagaCadastrar.setOnClickListener(trataClique);
        bCadastroVagaVoltar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Spinner mySpinnerTurno = (Spinner) findViewById(R.id.spCadastroVagaTurno);

        ArrayAdapter<String> myAdapterTurno = new ArrayAdapter<String>(EmpresaCadastrarVaga.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.turno));
        myAdapterTurno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerTurno.setAdapter(myAdapterTurno);

        Intent it = getIntent();
        Bundle parametrosRecebidos =  it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bCadastroVagaCadastrar.getId()){
                if (!etCadastroVagaTitulo.getText().toString().equals("")){
                    if (!etCadastroVagaDescricao.getText().toString().equals("")){
                        if (spCadastroVagaTurno.getSelectedItemPosition() != 0){
                            if (!etCadastroVagaSetor.getText().toString().equals("")){
                                if (rbCadastroVagaNao.isChecked() || rbCadastroVagaSim.isChecked()){
                                    
                                    String nome = etCadastroVagaTitulo.getText().toString();
                                    String setor = etCadastroVagaSetor.getText().toString();
                                    String descricao = etCadastroVagaDescricao.getText().toString();
                                    boolean preenchida = false;
                                    int turno = spCadastroVagaTurno.getSelectedItemPosition();
                                    LocalDate dataPublicacao = LocalDate.now();

                                    Vaga minhaVaga = null;

                                    if (rbCadastroVagaSim.isChecked()) {
                                        if (!etCadastroVagaSalario.getText().toString().equals("")) {
                                            boolean remunerada = true;
                                            float salario = Float.parseFloat(etCadastroVagaSalario.getText().toString());

                                            minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                            minhaVaga.setSalario(salario);
                                            minhaVaga.setTurnoLiteral();

                                            final Vaga finalMinhaVaga = minhaVaga;

                                            Thread thread = new Thread(){
                                                @Override
                                                public void run(){
                                                    try {
                                                        informacoesApp.out.writeObject("cadastraVaga");

                                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                                        if (mensagemRecebida.equals("Ok")) {
                                                            informacoesApp.out.writeObject(finalMinhaVaga);
                                                            informacoesApp.out.writeObject(minhaEmpresa);

                                                            mensagemRecebida = (String) informacoesApp.in.readObject();

                                                            switch (mensagemRecebida) {
                                                                case "vagaJaCadastrada":
                                                                    runOnUiThread(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            Toast.makeText(informacoesApp, "A vaga informada já está cadastrada.", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    });
                                                                    break;
                                                                case "vagaCadastrada":
                                                                    int cod_vaga = (int) informacoesApp.in.readObject();
                                                                    finalMinhaVaga.setID(cod_vaga);

                                                                    runOnUiThread(new Runnable() {
                                                                        @Override
                                                                        public void run() {
                                                                            Toast.makeText(informacoesApp, "Vaga cadastrada com sucesso.", Toast.LENGTH_SHORT).show();
                                                                        }
                                                                    });
                                                                    Intent it = new Intent(EmpresaCadastrarVaga.this,EmpresaVagasAbertas.class);
                                                                    it.putExtra("empresa",minhaEmpresa);
                                                                    startActivity(it);
                                                                    break;
                                                            }
                                                        }
                                                    } catch (IOException | ClassNotFoundException ex) {
                                                        Logger.getLogger(EmpresaCadastrarVaga.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                }
                                            };
                                            thread.start();
                                        } else {
                                            Toast.makeText(informacoesApp, "Informe o salário da vaga.", Toast.LENGTH_SHORT).show();
                                            etCadastroVagaSalario.requestFocus();
                                        }
                                    } else if (rbCadastroVagaNao.isChecked()){
                                        boolean remunerada = false;

                                        minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                        minhaVaga.setSalario(0);
                                        minhaVaga.setTurnoLiteral();

                                        final Vaga finalMinhaVaga = minhaVaga;

                                        Thread thread = new Thread(){
                                            @Override
                                            public void run(){
                                                try {
                                                    informacoesApp.out.writeObject("cadastraVaga");

                                                    mensagemRecebida = (String) informacoesApp.in.readObject();

                                                    if (mensagemRecebida.equals("Ok")) {
                                                        informacoesApp.out.writeObject(finalMinhaVaga);
                                                        informacoesApp.out.writeObject(minhaEmpresa);

                                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                                        switch (mensagemRecebida) {
                                                            case "vagaJaCadastrada":
                                                                runOnUiThread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        Toast.makeText(informacoesApp, "A vaga informada já está cadastrada.", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                });
                                                                break;
                                                            case "vagaCadastrada":
                                                                int cod_vaga = (int) informacoesApp.in.readObject();
                                                                finalMinhaVaga.setID(cod_vaga);

                                                                runOnUiThread(new Runnable() {
                                                                    @Override
                                                                    public void run() {
                                                                        Toast.makeText(informacoesApp, "Vaga cadastrada com sucesso.", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                });
                                                                Intent it = new Intent(EmpresaCadastrarVaga.this,EmpresaVagasAbertas.class);
                                                                it.putExtra("empresa",minhaEmpresa);
                                                                startActivity(it);
                                                                break;
                                                        }
                                                    }
                                                } catch (IOException | ClassNotFoundException ex) {
                                                    Logger.getLogger(EmpresaCadastrarVaga.class.getName()).log(Level.SEVERE, null, ex);
                                                } catch (Throwable throwable) {
                                                    throwable.printStackTrace();
                                                }
                                            }
                                        };
                                        thread.start();
                                    }
                                }else{
                                    Toast.makeText(EmpresaCadastrarVaga.this, "Informe se a vaga é remunerada.", Toast.LENGTH_SHORT).show();
                                    rbCadastroVagaSim.requestFocus();
                                }
                            }else{
                                Toast.makeText(EmpresaCadastrarVaga.this, "Informe o setor da vaga.", Toast.LENGTH_SHORT).show();
                                etCadastroVagaSetor.requestFocus();
                            }
                        }else{
                            Toast.makeText(EmpresaCadastrarVaga.this, "Informe o turno da vaga.", Toast.LENGTH_SHORT).show();
                            spCadastroVagaTurno.requestFocus();
                        }
                    }else{
                        Toast.makeText(EmpresaCadastrarVaga.this, "Informe a descrição da vaga.", Toast.LENGTH_SHORT).show();
                        etCadastroVagaDescricao.requestFocus();
                    }
                }else{
                    Toast.makeText(EmpresaCadastrarVaga.this, "Informe o título da vaga.", Toast.LENGTH_SHORT).show();
                    etCadastroVagaTitulo.requestFocus();
                }
            } else if (view.getId() == bCadastroVagaVoltar.getId()){
                Intent it = new Intent(EmpresaCadastrarVaga.this,EmpresaVagasAbertas.class);
                it.putExtra("empresa",minhaEmpresa);
                startActivity(it);
            }
        }
    };

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ((id == android.R.id.home)) {
            Intent it = new Intent();
            it.putExtra("empresa",minhaEmpresa);
            setResult(1, it);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
