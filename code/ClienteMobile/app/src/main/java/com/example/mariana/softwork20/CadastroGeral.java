package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Endereco;

public class CadastroGeral extends AppCompatActivity {

    EditText etCadastroEmail, etCadastroTelefone, etCadastroRua, etCadastroNumero,
            etCadastroBairro, etCadastroComplemento, etCadastroCep, etCadastroCidade,
            etCadastroSenha, etCadastroSenhaConfirma, etCadastroDDD;
    RadioButton rbCadastroEstudante, rbCadastroEmpresa;
    Button bCadastroEnviar,bCadastroCancelar;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_geral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroBairro = findViewById(R.id.etCadastroBairro);
        etCadastroCep = findViewById(R.id.etCadastroCep);
        etCadastroCidade = findViewById(R.id.etCadastroCidade);
        etCadastroComplemento = findViewById(R.id.etCadastroComplemento);
        etCadastroEmail = findViewById(R.id.etCadastroEmail);
        etCadastroNumero = findViewById(R.id.etCadastroNumero);
        etCadastroRua = findViewById(R.id.etCadastroRua);
        etCadastroTelefone = findViewById(R.id.etCadastroTelefone);
        etCadastroSenha = findViewById(R.id.etCadastroSenha);
        etCadastroSenhaConfirma = findViewById(R.id.etCadastroSenhaConfirma);
        etCadastroDDD = findViewById(R.id.etCadastroDDD);
        rbCadastroEmpresa = findViewById(R.id.rbCadastroEmpresa);
        rbCadastroEstudante = findViewById(R.id.rbCadastroEstudante);
        bCadastroEnviar = findViewById(R.id.bCadastroEnviar);
        bCadastroCancelar = findViewById(R.id.bCadastroCancelar);

        informacoesApp = (InformacoesApp) getApplicationContext();

        bCadastroEnviar.setOnClickListener(trataClique);
        bCadastroCancelar.setOnClickListener(trataClique);

    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bCadastroEnviar.getId()) {
                if (!etCadastroEmail.getText().toString().equals("")) {
                    if (!etCadastroSenha.getText().toString().equals("")) {
                        if (!etCadastroSenhaConfirma.getText().toString().equals("")) {
                            if (etCadastroSenha.getText().toString().equals(etCadastroSenhaConfirma.getText().toString())) {
                                if (!etCadastroDDD.getText().toString().equals("")) {
                                    if (!etCadastroTelefone.getText().toString().equals("")) {
                                        if (!etCadastroRua.getText().toString().equals("")) {
                                            if (!etCadastroNumero.getText().toString().equals("")) {
                                                if (!etCadastroBairro.getText().toString().equals("")) {
                                                    if (!etCadastroCep.getText().toString().equals("")) {
                                                        if (!etCadastroCidade.getText().toString().equals("")) {
                                                            if(rbCadastroEmpresa.isChecked() || rbCadastroEstudante.isChecked()){
                                                                final String email = etCadastroEmail.getText().toString();
                                                                final String senha = etCadastroSenha.getText().toString();
                                                                final int telefone = Integer.parseInt(etCadastroTelefone.getText().toString());
                                                                final String rua = etCadastroRua.getText().toString();
                                                                final int numero = Integer.parseInt(etCadastroNumero.getText().toString());
                                                                final String bairro = etCadastroBairro.getText().toString();
                                                                final int cep = Integer.parseInt(etCadastroCep.getText().toString());
                                                                final String cidade = etCadastroCidade.getText().toString();
                                                                final int ddd = Integer.parseInt(etCadastroDDD.getText().toString());
                                                                String complementoProv = "";

                                                                if (!etCadastroComplemento.getText().toString().equals("")) {
                                                                    complementoProv = etCadastroComplemento.getText().toString();
                                                                }

                                                                final String complemento = complementoProv;

                                                                Thread thread = new Thread() {
                                                                    @Override
                                                                    public void run() {
                                                                        try {
                                                                            informacoesApp.out.writeObject("verificaEmail");

                                                                            mensagemRecebida = (String) informacoesApp.in.readObject();

                                                                            if (mensagemRecebida.equals("Ok")) {
                                                                                informacoesApp.out.writeObject(email);

                                                                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                                                                if (mensagemRecebida.equals("emailEmUso")) {
                                                                                    runOnUiThread(new Runnable() {
                                                                                        @Override
                                                                                        public void run() {
                                                                                            Toast.makeText(informacoesApp, "Este email já está sendo utilizado.", Toast.LENGTH_SHORT).show();
                                                                                            etCadastroEmail.requestFocus();
                                                                                        }
                                                                                    });
                                                                                } else if (mensagemRecebida.equals("emailDisponivel")) {

                                                                                    char letras[] = senha.toCharArray();

                                                                                    boolean temCaracterInvalido = false;

                                                                                    for (char letra : letras) {
                                                                                        String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";

                                                                                        char[] letrasAlfabeto = alfabeto.toCharArray();

                                                                                        for (char aLetrasAlfabeto : letrasAlfabeto) {
                                                                                            if (aLetrasAlfabeto == letra) {
                                                                                                temCaracterInvalido = false;
                                                                                                break;
                                                                                            } else {
                                                                                                temCaracterInvalido = true;
                                                                                            }
                                                                                        }
                                                                                    }

                                                                                    if (!temCaracterInvalido) {

                                                                                        int tipo = 0;
                                                                                        if (rbCadastroEstudante.isChecked()) {
                                                                                            tipo = 1;
                                                                                        } else if (rbCadastroEmpresa.isChecked()) {
                                                                                            tipo = 2;
                                                                                        }

                                                                                        Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                                                                                        meuEndereco.setComplemento(complemento);

                                                                                        if (tipo == 1) {
                                                                                            Intent it = new Intent(CadastroGeral.this, CadastroAluno.class);
                                                                                            it.putExtra("telefone", telefone);
                                                                                            it.putExtra("endereco", meuEndereco);
                                                                                            it.putExtra("ddd", ddd);
                                                                                            it.putExtra("email", email);
                                                                                            it.putExtra("senha", senha);

                                                                                            startActivity(it);

                                                                                        } else if (tipo == 2) {
                                                                                            Intent it = new Intent(CadastroGeral.this, CadastroEmpresa.class);
                                                                                            it.putExtra("telefone", telefone);
                                                                                            it.putExtra("endereco", meuEndereco);
                                                                                            it.putExtra("ddd", ddd);
                                                                                            it.putExtra("email", email);
                                                                                            it.putExtra("senha", senha);

                                                                                            startActivity(it);
                                                                                        }

                                                                                    } else {
                                                                                        runOnUiThread(new Runnable() {
                                                                                            @Override
                                                                                            public void run() {
                                                                                                Toast.makeText(informacoesApp, "A senha possui caracteres inválidos.", Toast.LENGTH_SHORT).show();
                                                                                                etCadastroSenha.requestFocus();
                                                                                            }
                                                                                        });
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (IOException | ClassNotFoundException ex) {
                                                                            Logger.getLogger(CadastroGeral.class.getName()).log(Level.SEVERE, null, ex);
                                                                        }
                                                                    }
                                                                };
                                                                thread.start();
                                                            }else{
                                                                Toast.makeText(informacoesApp, "Informe o tipo de usuário.", Toast.LENGTH_SHORT).show();
                                                            }
                                                        } else {
                                                            Toast.makeText(informacoesApp, "Informe a cidade.", Toast.LENGTH_SHORT).show();
                                                            etCadastroCidade.requestFocus();
                                                        }
                                                    } else {
                                                        Toast.makeText(informacoesApp, "Informe o CEP.", Toast.LENGTH_SHORT).show();
                                                        etCadastroCep.requestFocus();
                                                    }
                                                } else {
                                                    Toast.makeText(informacoesApp, "Informe o bairro.", Toast.LENGTH_SHORT).show();
                                                    etCadastroBairro.requestFocus();
                                                }
                                            } else {
                                                Toast.makeText(informacoesApp, "Informe o número.", Toast.LENGTH_SHORT).show();
                                                etCadastroNumero.requestFocus();
                                            }
                                        } else {
                                            Toast.makeText(informacoesApp, "Informe a rua.", Toast.LENGTH_SHORT).show();
                                            etCadastroRua.requestFocus();
                                        }
                                    } else {
                                        Toast.makeText(informacoesApp, "Informe o telefone.", Toast.LENGTH_SHORT).show();
                                        etCadastroTelefone.requestFocus();
                                    }
                                } else {
                                    Toast.makeText(informacoesApp, "Informe o DDD.", Toast.LENGTH_SHORT).show();
                                    etCadastroDDD.requestFocus();
                                }
                            } else {
                                Toast.makeText(informacoesApp, "As senhas não conferem.", Toast.LENGTH_SHORT).show();
                                etCadastroSenha.requestFocus();
                            }
                        } else {
                            Toast.makeText(informacoesApp, "Confirme a senha.", Toast.LENGTH_SHORT).show();
                            etCadastroSenhaConfirma.requestFocus();
                        }
                    } else {
                        Toast.makeText(informacoesApp, "Informe a senha.", Toast.LENGTH_SHORT).show();
                        etCadastroSenha.requestFocus();
                    }
                } else {
                    Toast.makeText(informacoesApp, "Informe o email.", Toast.LENGTH_SHORT).show();
                    etCadastroEmail.requestFocus();
                }
            } else if (view.getId() == bCadastroCancelar.getId()) {
                Intent it = new Intent(CadastroGeral.this,Login.class);
                startActivity(it);
            }
        }
    };
}
