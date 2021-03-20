package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;
import classesDominio.Endereco;

public class CadastroEmpresa extends AppCompatActivity {

    InformacoesApp informacoesApp;

    EditText etCadastroCNPJ, etCadastroRazaoSocial, etCadastroNomeFantasia;
    Button bCadastroEmpresaEnviar;

    String mensagemRecebida = "";

    int telefone = 0;
    Endereco endereco = null;
    int ddd = 0;
    String email = "";
    String senha = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_empresa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        informacoesApp = (InformacoesApp) getApplicationContext();

        etCadastroCNPJ = findViewById(R.id.etCadastroCNPJ);
        etCadastroRazaoSocial = findViewById(R.id.etCadastroRazaoSocial);
        etCadastroNomeFantasia = findViewById(R.id.etCadastroNomeFantasia);
        bCadastroEmpresaEnviar = findViewById(R.id.bCadastroEmpresaEnviar);

        bCadastroEmpresaEnviar.setOnClickListener(trataClique);
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bCadastroEmpresaEnviar.getId()) {
                if (!etCadastroCNPJ.getText().toString().equals("")) {
                    if (!etCadastroRazaoSocial.getText().toString().equals("")) {
                        if (!etCadastroNomeFantasia.getText().toString().equals("")) {

                            Intent it = getIntent();
                            if (it != null) {
                                Bundle parametrosRecebidos = it.getExtras();
                                telefone = parametrosRecebidos.getInt("telefone");
                                endereco = (Endereco) parametrosRecebidos.get("endereco");
                                ddd = parametrosRecebidos.getInt("ddd");
                                email = parametrosRecebidos.getString("email");
                                senha = parametrosRecebidos.getString("senha");

                            }

                            long cnpj = Long.parseLong(etCadastroCNPJ.getText().toString());
                            String razaoSocial = etCadastroRazaoSocial.getText().toString();
                            String nomeFantasia = etCadastroNomeFantasia.getText().toString();

                            final Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);

                            final Thread thread = new Thread() {
                                @Override
                                public void run() {
                                    try {
                                        informacoesApp.out.writeObject("cadastraEmpresa");
                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                        if (mensagemRecebida.equals("Ok")) {
                                            informacoesApp.out.writeObject(minhaEmpresa);
                                            final String mensagem = (String) informacoesApp.in.readObject();
                                            int cod_usuario = (int) informacoesApp.in.readObject();
                                            String senhaCriptografada = criptografa(senha, cod_usuario);
                                            informacoesApp.out.writeObject(senhaCriptografada);
                                            mensagemRecebida = (String) informacoesApp.in.readObject();

                                            switch (mensagemRecebida) {
                                                case "empresaCadastrada":
                                                    int cod_empresa = (int) informacoesApp.in.readObject();
                                                    minhaEmpresa.setID(cod_empresa);

                                                    Intent it = new Intent(CadastroEmpresa.this, EmpresaVagasAbertas.class);
                                                    it.putExtra("empresa", minhaEmpresa);

                                                    startActivity(it);

                                                    break;
                                                case "emailJaCadastrado":
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "O email informado já está cadastrado.", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                    break;
                                                case "empresaJaCadastrada":
                                                    runOnUiThread(new Runnable() {
                                                        @Override
                                                        public void run() {
                                                            Toast.makeText(informacoesApp, "O CNPJ informado já está cadastrado.", Toast.LENGTH_SHORT).show();
                                                        }
                                                    });
                                                    break;
                                                default:
                                                    break;
                                            }
                                        }
                                    } catch (IOException | ClassNotFoundException ex) {
                                        Logger.getLogger(CadastroEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            };
                        thread.start();


                            }else{
                                Toast.makeText(informacoesApp, "Informe o nome fantasia.", Toast.LENGTH_SHORT).show();
                            }

                        } else {
                            Toast.makeText(informacoesApp, "Informe a razão social.", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(informacoesApp, "Informe o CNPJ.", Toast.LENGTH_SHORT).show();
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

    }
