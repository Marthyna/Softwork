package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;
import classesDominio.Endereco;

public class EmpresaConta extends AppCompatActivity {

    EditText etContaEmail, etContaRazaoSocial, etContaCNPJ,
            etContaNomeFantasia, etContaDDD, etContaTelefone,
            etContaRua, etContaNumero, etContaComplemento,
            etContaBairro, etContaCidade, etContaCEP;
    Button bRedefineSenha, bContaSalvar;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    static final int CODIGO_EMPRESA_REDEFINE_SENHA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etContaEmail = findViewById(R.id.etContaEmail);
        etContaRazaoSocial = findViewById(R.id.etContaRazaoSocial);
        etContaCNPJ = findViewById(R.id.etContaCNPJ);
        etContaNomeFantasia = findViewById(R.id.etContaNomeFantasia);
        etContaDDD = findViewById(R.id.etContaDDD);
        etContaTelefone = findViewById(R.id.etContaTelefone);
        etContaRua = findViewById(R.id.etContaRua);
        etContaNumero = findViewById(R.id.etContaNumero);
        etContaComplemento = findViewById(R.id.etContaComplemento);
        etContaBairro = findViewById(R.id.etContaBairro);
        etContaCidade = findViewById(R.id.etContaCidade);
        etContaCEP = findViewById(R.id.etContaCEP);
        bRedefineSenha = findViewById(R.id.bRedefineSenha);
        bContaSalvar = findViewById(R.id.bContaSalvar);

        bRedefineSenha.setOnClickListener(trataClique);
        bContaSalvar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        etContaEmail.setText(minhaEmpresa.getEmail());

        etContaRazaoSocial.setText(minhaEmpresa.getRazaoSocial());
        etContaNomeFantasia.setText(minhaEmpresa.getNomeFantasia());
        etContaCNPJ.setText(String.valueOf(minhaEmpresa.getCnpj()));

        etContaDDD.setText(String.valueOf(minhaEmpresa.getDdd()));
        etContaTelefone.setText(String.valueOf(minhaEmpresa.getTelefone()));

        etContaRua.setText(minhaEmpresa.getEndereco().getRua());
        etContaNumero.setText(String.valueOf(minhaEmpresa.getEndereco().getNumero()));
        etContaBairro.setText(minhaEmpresa.getEndereco().getBairro());
        etContaCEP.setText(String.valueOf(minhaEmpresa.getEndereco().getCep()));
        etContaCidade.setText(minhaEmpresa.getEndereco().getCidade());
        etContaComplemento.setText(minhaEmpresa.getEndereco().getComplemento());
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bRedefineSenha.getId()) {
                Intent it = new Intent(EmpresaConta.this, EmpresaRedefineSenha.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivityForResult(it,CODIGO_EMPRESA_REDEFINE_SENHA);
            } else if (view.getId() == bContaSalvar.getId()) {
                String email = etContaEmail.getText().toString();
                int telefone = Integer.parseInt(etContaTelefone.getText().toString());

                String rua = etContaRua.getText().toString();
                int numero = Integer.parseInt(etContaNumero.getText().toString());
                String bairro = etContaBairro.getText().toString();
                String complemento = etContaComplemento.getText().toString();
                String cidade = etContaCidade.getText().toString();
                int cep = Integer.parseInt(etContaCEP.getText().toString());
                int ddd = Integer.parseInt(etContaDDD.getText().toString());

                String razaoSocial = etContaRazaoSocial.getText().toString();
                long cnpj = Long.parseLong(etContaCNPJ.getText().toString());
                String nomeFantasia = etContaNomeFantasia.getText().toString();

                Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, rua);
                minhaEmpresa.getEndereco().setComplemento(complemento);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            informacoesApp.out.writeObject("salvarDadosContaEmpresa");
                            mensagemRecebida = (String) informacoesApp.in.readObject();
                            if (mensagemRecebida.equals("Ok")) {
                                informacoesApp.out.writeObject(minhaEmpresa);

                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                if (mensagemRecebida.equals("empresaAtualizada")) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "As informações da conta foram atualizadas.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }

                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(EmpresaConta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
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
            case R.id.item_vagas_abertas:
                Intent it = new Intent(EmpresaConta.this, EmpresaVagasAbertas.class);
                it.putExtra("empresa", minhaEmpresa);
                startActivity(it);
                return true;
            case R.id.item_aceitos:
                Intent it2 = new Intent(EmpresaConta.this, EmpresaAceitos.class);
                it2.putExtra("empresa", minhaEmpresa);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(EmpresaConta.this, EmpresaHistorico.class);
                it3.putExtra("empresa", minhaEmpresa);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(EmpresaConta.this, EmpresaMensagens.class);
                it4.putExtra("empresa", minhaEmpresa);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(EmpresaConta.this, EmpresaRecusados.class);
                it5.putExtra("empresa", minhaEmpresa);
                startActivity(it5);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(EmpresaConta.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
