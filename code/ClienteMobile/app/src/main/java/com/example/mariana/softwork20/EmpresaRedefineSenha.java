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
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;

public class EmpresaRedefineSenha extends AppCompatActivity {

    EditText etRedefinirSenhaAtual,etRedefinirSenhaNova,etRedefinirSenhaConfirma;
    Button bRedefineSenhaSalvar;

    InformacoesApp informacoesApp;

    Empresa minhaEmpresa;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_redefine_senha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etRedefinirSenhaAtual = findViewById(R.id.etRedefinirSenhaAtual);
        etRedefinirSenhaConfirma = findViewById(R.id.etRedefinirSenhaConfirma);
        etRedefinirSenhaNova = findViewById(R.id.etRedefinirSenhaNova);
        bRedefineSenhaSalvar = findViewById(R.id.bRedefineSenhaSalvar);

        bRedefineSenhaSalvar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bRedefineSenhaSalvar.getId()){
                if (!etRedefinirSenhaAtual.getText().toString().equals("")) {
                    if (!etRedefinirSenhaNova.getText().toString().equals("")) {
                        if (!etRedefinirSenhaConfirma.getText().toString().equals("")) {
                            final String senhaAtual = etRedefinirSenhaAtual.getText().toString();
                            final String senhaNova = etRedefinirSenhaNova.getText().toString();
                            final String confirmaSenha = etRedefinirSenhaConfirma.getText().toString();

                            Thread thread = new Thread() {
                                @Override
                                public void run(){
                                    try {
                                        informacoesApp.out.writeObject("redefineSenha");
                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                        if (mensagemRecebida.equals("Ok")) {
                                            informacoesApp.out.writeObject("empresa");
                                            informacoesApp.out.writeObject(minhaEmpresa);
                                            mensagemRecebida = (String) informacoesApp.in.readObject();

                                            if (mensagemRecebida.equals("emailValido")) {
                                                int cod_pessoa = (int) informacoesApp.in.readObject();

                                                String senhaAtualCriptografada = criptografa(senhaAtual, cod_pessoa);

                                                informacoesApp.out.writeObject(senhaAtualCriptografada);
                                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                                if (mensagemRecebida.equals("senhaValida")) {

                                                    if (senhaNova.equals(confirmaSenha)) {
                                                        String senhaNovaCriptografada = criptografa(senhaNova, cod_pessoa);
                                                        informacoesApp.out.writeObject(senhaNovaCriptografada);
                                                        mensagemRecebida = (String) informacoesApp.in.readObject();
                                                        if (mensagemRecebida.equals("senhaRedefinida")) {
                                                            runOnUiThread(new Runnable() {
                                                                @Override
                                                                public void run() {
                                                                    Toast.makeText(informacoesApp, "Senha redefinida com sucesso!", Toast.LENGTH_SHORT).show();
                                                                }
                                                            });
                                                            Intent it = new Intent(EmpresaRedefineSenha.this,EmpresaConta.class);
                                                            it.putExtra("empresa",minhaEmpresa);
                                                            startActivity(it);
                                                        }
                                                    } else {
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Toast.makeText(informacoesApp, "As senhas não correspondem!", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                    }

                                                } else {
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "Senha incorreta!", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                }
                                            } else {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(informacoesApp, "Ocorreu um erro no servidor.", Toast.LENGTH_SHORT).show();
                                                    }
                                                });
                                            }
                                        }
                                    } catch (IOException | ClassNotFoundException ex) {
                                        Logger.getLogger(EmpresaRedefineSenha.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            };
                            thread.start();

                        } else {
                            Toast.makeText(informacoesApp, "Informe a nova senha novamente.", Toast.LENGTH_SHORT).show();

                        }
                    } else {
                        Toast.makeText(informacoesApp, "Informe a nova senha.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(informacoesApp, "Informe a senha atual.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    };

    public String criptografa(String senhaOriginal, int codigoUsuario) {
        String senhaCriptografada = "";
        int chave = codigoUsuario + senhaOriginal.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {

            char[] letras = informacoesApp.alfabetosCriptografia[x].toCharArray(); // vetor com as letras do alfabeto

            char[] vetorLetrasSenha = senhaOriginal.toCharArray(); // vetor com letras da senha
            char[] vetorSenhaCriptografada = new char[vetorLetrasSenha.length]; // vetor pras letras da senha criptada

            for (int y = 0; y < vetorLetrasSenha.length; y++) {
                char caractere = vetorLetrasSenha[y]; // pega cada caractere
                int posicaoLetra = 0;
                for (int z = 0; z < letras.length; z++) {
                    if (letras[z] == caractere) {
                        posicaoLetra = z; // acha cada um no alfabeto
                    }
                }
                int posicaoNova = posicaoLetra + chave; // incrementa a posicao com a chave
                if (posicaoNova >= 70) {
                    posicaoNova -= 70;
                }
                vetorSenhaCriptografada[y] = letras[posicaoNova]; // poe o caracter novo no vetor
            }

            senhaCriptografada = new String(vetorSenhaCriptografada); // por tudo numa String
        }

        return senhaCriptografada;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == android.R.id.home) {
            Intent it = new Intent();
            it.putExtra("empresa",minhaEmpresa);
            setResult(1,it);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}