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

import classesDominio.Aluno;
import classesDominio.Curriculo;

import static java.lang.System.in;

public class CadastroCurriculoFinal extends AppCompatActivity {

    EditText etCadastroCurriculoCurso1, etCadastroCurriculoCurso2, etCadastroCurriculoCurso3,
            etCadastroCurriculoEmprego1, etCadastroCurriculoEmprego2, etCadastroCurriculoEmprego3;
    Button bCadastrarCurriculoFinalEnviar;

    Aluno meuAluno = null;
    String descricao = "";
    String idioma1 = "";
    String formacao1 = "";

    String idioma2 = "", idioma3 = "", formacao2 = "", formacao3 = "";

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_curriculo_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroCurriculoCurso1 = findViewById(R.id.etCadastroCurriculoCurso1);
        etCadastroCurriculoCurso2 = findViewById(R.id.etCadastroCurriculoCurso2);
        etCadastroCurriculoCurso3 = findViewById(R.id.etCadastroCurriculoCurso3);
        etCadastroCurriculoEmprego1 = findViewById(R.id.etCadastroCurriculoEmprego1);
        etCadastroCurriculoEmprego2 = findViewById(R.id.etCadastroCurriculoEmprego2);
        etCadastroCurriculoEmprego3 = findViewById(R.id.etCadastroCurriculoEmprego3);
        bCadastrarCurriculoFinalEnviar = findViewById(R.id.bCadastrarCurriculoFinalEnviar);

        bCadastrarCurriculoFinalEnviar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bCadastrarCurriculoFinalEnviar.getId()) {
                Intent it = getIntent();
                if (it != null) {
                    Bundle parametrosRecebidos = it.getExtras();
                    assert parametrosRecebidos != null;
                    meuAluno = (Aluno) parametrosRecebidos.get("aluno");
                    descricao = parametrosRecebidos.getString("descricao");
                    idioma1 = parametrosRecebidos.getString("idioma1");
                    idioma2 = parametrosRecebidos.getString("idioma2");
                    idioma3 = parametrosRecebidos.getString("idioma3");
                    formacao1 = parametrosRecebidos.getString("formacao1");
                    formacao2 = parametrosRecebidos.getString("formacao2");
                    formacao3 = parametrosRecebidos.getString("formacao3");
                }

                String curso1 = "";
                String curso2 = "";
                String curso3 = "";

                String emprego1 = "";
                String emprego2 = "";
                String emprego3 = "";

                Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);

                if (!etCadastroCurriculoCurso1.getText().toString().equals("")) {
                    curso1 = etCadastroCurriculoCurso1.getText().toString();
                    meuCurriculo.setCurso1(curso1);
                }
                if (!etCadastroCurriculoCurso2.getText().toString().equals("")) {
                    curso2 = etCadastroCurriculoCurso2.getText().toString();
                    meuCurriculo.setCurso1(curso2);
                }
                if (!etCadastroCurriculoCurso3.getText().toString().equals("")) {
                    curso3 = etCadastroCurriculoCurso3.getText().toString();
                    meuCurriculo.setCurso1(curso3);
                }


                if (!etCadastroCurriculoEmprego1.getText().toString().equals("")) {
                    emprego1 = etCadastroCurriculoEmprego1.getText().toString();
                    meuCurriculo.setCurso1(emprego1);
                }
                if (!etCadastroCurriculoEmprego2.getText().toString().equals("")) {
                    emprego2 = etCadastroCurriculoEmprego2.getText().toString();
                    meuCurriculo.setCurso1(emprego2);
                }
                if (!etCadastroCurriculoEmprego3.getText().toString().equals("")) {
                    emprego3 = etCadastroCurriculoEmprego3.getText().toString();
                    meuCurriculo.setCurso1(emprego3);
                }

                meuAluno.setCurriculo(meuCurriculo);

                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            informacoesApp.out.writeObject("cadastraAluno");
                            mensagemRecebida = (String) informacoesApp.in.readObject();

                            if (mensagemRecebida.equals("Ok")) {
                                informacoesApp.out.writeObject(meuAluno);
                                int cod_usuario = (int) informacoesApp.in.readObject();

                                String senhaCriptografada = criptografa(meuAluno.getSenha(), cod_usuario);
                                informacoesApp.out.writeObject(senhaCriptografada);

                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                switch (mensagemRecebida) {
                                    case "alunoCadastrado":
                                        int cod_aluno = (int) informacoesApp.in.readObject();
                                        meuAluno.setID(cod_aluno);

                                        Intent it = new Intent(CadastroCurriculoFinal.this,AlunoOfertas.class);
                                        it.putExtra("aluno",meuAluno);
                                        startActivity(it);
                                        break;
                                    case "emailJaExiste":
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "O email informado já está sendo usado.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case "matriculaJaCadastrada":
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "A matrícula informada já está cadastrada.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case "rgJaCadastrado":
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "O RG informado já está cadastrado.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    case "cpfJaCadastrado":
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "O CPF informado já está cadastrado.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                        break;
                                    default:
                                        break;
                                }
                            } else {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(informacoesApp, "Ocorreu um erro no servidor.", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(CadastroCurriculoFinal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
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
