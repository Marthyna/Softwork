package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;

import classesDominio.Aluno;
import classesDominio.Endereco;

public class CadastroCurriculo extends AppCompatActivity {

    EditText etCadastroCurriculoDescricao,etCadastroCurriculoIdioma1,etCadastroCurriculoIdioma2,
            etCadastroCurriculoIdioma3,etCadastroCurriculoFormacao1,etCadastroCurriculoFormacao2,
            etCadastroCurriculoFormacao3;
    Button bCadastroCurriculoProximo;

    Aluno meuAluno = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_curriculo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroCurriculoDescricao = findViewById(R.id.etCadastroCurriculoDescricao);
        etCadastroCurriculoFormacao1 =  findViewById(R.id.etCadastroCurriculoFormacao1);
        etCadastroCurriculoFormacao2 =  findViewById(R.id.etCadastroCurriculoFormacao2);
        etCadastroCurriculoFormacao3 =  findViewById(R.id.etCadastroCurriculoFormacao3);
        etCadastroCurriculoIdioma1 = findViewById(R.id.etCadastroCurriculoIdioma1);
        etCadastroCurriculoIdioma2 = findViewById(R.id.etCadastroCurriculoIdioma2);
        etCadastroCurriculoIdioma3 = findViewById(R.id.etCadastroCurriculoIdioma3);
        bCadastroCurriculoProximo = findViewById(R.id.bCadastroCurriculoProximo);

        bCadastroCurriculoProximo.setOnClickListener(trataClique);
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            if (view.getId() == bCadastroCurriculoProximo.getId()){
                if(!etCadastroCurriculoDescricao.getText().toString().equals("")){
                    if(!etCadastroCurriculoIdioma1.getText().toString().equals("")){
                        if(!etCadastroCurriculoFormacao1.getText().toString().equals("")){

                            Intent it = getIntent();
                            if(it != null){
                                Bundle parametrosRecebidos = it.getExtras();
                                meuAluno = (Aluno) parametrosRecebidos.get("aluno");
                            }

                            String descricao = etCadastroCurriculoDescricao.getText().toString();
                            String idioma1 = etCadastroCurriculoIdioma1.getText().toString();
                            String formacao1 = etCadastroCurriculoFormacao1.getText().toString();

                            String idioma2 = "", idioma3 = "", formacao2 = "", formacao3 = "";

                            if (!etCadastroCurriculoIdioma2.getText().toString().equals("")) {
                                idioma2 = etCadastroCurriculoIdioma2.getText().toString();
                            }
                            if (!etCadastroCurriculoIdioma3.getText().toString().equals("")) {
                                idioma3 = etCadastroCurriculoIdioma3.getText().toString();
                            }

                            if (!etCadastroCurriculoFormacao2.getText().toString().equals("")) {
                                formacao2 = etCadastroCurriculoFormacao2.getText().toString();
                            }
                            if (!etCadastroCurriculoFormacao3.getText().toString().equals("")) {
                                formacao3 = etCadastroCurriculoFormacao3.getText().toString();
                            }

                            Intent it2 = new Intent(CadastroCurriculo.this, CadastroCurriculoFinal.class);
                            it2.putExtra("descricao",descricao);
                            it2.putExtra("idioma1",idioma1);
                            it2.putExtra("idioma2",idioma2);
                            it2.putExtra("idioma3",idioma3);
                            it2.putExtra("formacao1",formacao1);
                            it2.putExtra("formacao2",formacao2);
                            it2.putExtra("formacao3",formacao3);
                            it2.putExtra("aluno",meuAluno);

                            startActivity(it2);

                        }else{
                            Toast.makeText(CadastroCurriculo.this, "Informe ao menos uma formação.", Toast.LENGTH_SHORT).show();
                            etCadastroCurriculoFormacao1.requestFocus();
                        }
                    }else{
                        Toast.makeText(CadastroCurriculo.this, "Informe ao menos um idioma.", Toast.LENGTH_SHORT).show();
                        etCadastroCurriculoIdioma1.requestFocus();
                    }
                }else{
                    Toast.makeText(CadastroCurriculo.this, "Escreva a descrição de seu currículo.", Toast.LENGTH_SHORT).show();
                    etCadastroCurriculoDescricao.requestFocus();
                }
            }
        }
    };

}
