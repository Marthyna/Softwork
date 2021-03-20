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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import classesDominio.Aluno;
import classesDominio.Empresa;

public class Login extends AppCompatActivity {

    Button bLoginCadastrar, bLoginEntrar, bLoginEsqueciSenha;
    EditText etLoginEmail, etLoginSenha;

    String mensagemRecebida;
    
    InformacoesApp informacoesApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginSenha = findViewById(R.id.etLoginSenha);
        bLoginCadastrar = findViewById(R.id.bLoginCadastrar);
        bLoginEntrar = findViewById(R.id.bLoginEntrar);
        bLoginEsqueciSenha = findViewById(R.id.bLoginEsqueciSenha);

        bLoginCadastrar.setOnClickListener(trataClique);
        bLoginEntrar.setOnClickListener(trataClique);
        bLoginEsqueciSenha.setOnClickListener(trataClique);

        mensagemRecebida = "";
        
        informacoesApp = (InformacoesApp) getApplicationContext();
        
        Thread thread = new Thread() {
            @Override
            public void run() {
                try{
                    informacoesApp.cliente = new Socket("10.0.2.2",12345);
                    informacoesApp.out = new ObjectOutputStream(informacoesApp.cliente.getOutputStream());
                    informacoesApp.in = new ObjectInputStream(informacoesApp.cliente.getInputStream());

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(informacoesApp, "Conexão efetuada com sucesso.", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bLoginEntrar.getId()) {
                if (!etLoginEmail.getText().toString().equals("")) {
                    if (!etLoginSenha.getText().toString().equals("")) {
                        final String email = etLoginEmail.getText().toString();
                        final String senha = etLoginSenha.getText().toString();

                        Thread thread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    informacoesApp.out.writeObject("validaUsuario");
                                    mensagemRecebida = (String) informacoesApp.in.readObject();

                                    if (mensagemRecebida.equals("Ok")) {
                                        informacoesApp.out.writeObject(email);
                                        mensagemRecebida = (String) informacoesApp.in.readObject();

                                        if (mensagemRecebida.equals("cod_pessoa")) {
                                            int cod_pessoa = ((int) informacoesApp.in.readObject());
                                            String senhaCriptografada = criptografa(senha, cod_pessoa);
                                            informacoesApp.out.writeObject(senhaCriptografada);

                                            mensagemRecebida = (String) informacoesApp.in.readObject();
                                            if (mensagemRecebida.equals("senhaValida")) {
                                                informacoesApp.out.writeObject("Ok");
                                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                                switch (mensagemRecebida) {
                                                    case "usuarioAluno":
                                                        informacoesApp.out.writeObject("Ok");
                                                        Aluno meuAluno = (Aluno) informacoesApp.in.readObject();
                                                        int cod_aluno = (int) informacoesApp.in.readObject();

                                                        meuAluno.setID(cod_aluno);

                                                        Intent it = new Intent(Login.this,AlunoOfertas.class);
                                                        it.putExtra("aluno",meuAluno);
                                                        startActivity(it);

                                                        break;
                                                    case "usuarioEmpresa":
                                                        informacoesApp.out.writeObject("Ok");
                                                        Empresa minhaEmpresa = (Empresa) informacoesApp.in.readObject();
                                                        int cod_empresa = (int) informacoesApp.in.readObject();

                                                        minhaEmpresa.setID(cod_empresa);

                                                        Intent it2 = new Intent(Login.this,EmpresaVagasAbertas.class);
                                                        it2.putExtra("empresa",minhaEmpresa);
                                                        startActivity(it2);

                                                        break;
                                                }
                                            } else if (mensagemRecebida.equals("senhaInvalida")) {
                                                runOnUiThread(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        Toast.makeText(Login.this, "Senha incorreta.", Toast.LENGTH_SHORT).show();
                                                        etLoginSenha.requestFocus();
                                                    }
                                                });
                                            }
                                        } else if (mensagemRecebida.equals("EmailInvalido")){
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    Toast.makeText(Login.this, "O email informado é inválido.", Toast.LENGTH_SHORT).show();
                                                    etLoginEmail.requestFocus();
                                                }
                                            });
                                        }

                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                } catch (ClassNotFoundException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        thread.start();

                    } else {
                        Toast.makeText(Login.this, "Informe a senha.", Toast.LENGTH_SHORT).show();
                        etLoginSenha.requestFocus();
                    }
                } else {
                    Toast.makeText(Login.this, "Informe o email.", Toast.LENGTH_SHORT).show();
                    etLoginEmail.requestFocus();
                }
            } else if (view.getId() == bLoginCadastrar.getId()){
                Intent it = new Intent(Login.this,CadastroGeral.class);
                startActivity(it);
            } else if (view.getId() == bLoginEsqueciSenha.getId()){
                Intent it = new Intent(Login.this,RecuperaSenha.class);
                startActivity(it);
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
