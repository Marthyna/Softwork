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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import classesDominio.Endereco;

public class CadastroAluno extends AppCompatActivity {
    EditText etCadastroNomeCompleto,etCadastroRG,etCadastroCPF,etCadastroDataNasc;
    RadioButton rbCadastroFeminino,rbCadastroMasculino;
    Button bCadastroProximo;

    int telefone = 0;
    Endereco endereco = null;
    int ddd = 0;
    String email = "";
    String senha = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroNomeCompleto = (EditText) findViewById(R.id.etCadastroNomeCompleto);
        etCadastroRG = (EditText) findViewById(R.id.etCadastroRG);
        etCadastroCPF = (EditText) findViewById(R.id.etCadastroCPF);
        etCadastroDataNasc = (EditText) findViewById(R.id.etCadastroDataNasc);
        rbCadastroFeminino = (RadioButton) findViewById(R.id.rbCadastroFeminino);
        rbCadastroMasculino = (RadioButton) findViewById(R.id.rbCadastroMasculino);
        bCadastroProximo = (Button) findViewById(R.id.bCadastroProximo);

        bCadastroProximo.setOnClickListener(trataClique);
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            if(view.getId() == bCadastroProximo.getId()){
                if(!etCadastroNomeCompleto.getText().toString().equals("")){
                    if(!etCadastroRG.getText().toString().equals("")){
                        if(!etCadastroCPF.getText().toString().equals("")){
                            if(!etCadastroDataNasc.getText().toString().equals("")){
                                if(rbCadastroFeminino.isChecked() || rbCadastroMasculino.isChecked()){

                                    Intent it = getIntent();
                                    if(it != null){
                                        Bundle parametrosRecebidos = it.getExtras();
                                        telefone = parametrosRecebidos.getInt("telefone");
                                        endereco = (Endereco) parametrosRecebidos.get("endereco");
                                        ddd =  parametrosRecebidos.getInt("ddd");
                                        email =  parametrosRecebidos.getString("email");
                                        senha =  parametrosRecebidos.getString("senha");

                                    }

                                    String nomeCompleto = etCadastroNomeCompleto.getText().toString();
                                    long rg = Long.parseLong(etCadastroRG.getText().toString());
                                    long cpf = Long.parseLong(etCadastroCPF.getText().toString());
                                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                    LocalDate dataNascimento = LocalDate.parse(etCadastroDataNasc.getText().toString(), formato);
                                    int sexo = 0;
                                    if(rbCadastroFeminino.isChecked()){
                                        sexo = 1;
                                    }else if(rbCadastroMasculino.isChecked()){
                                        sexo = 2;
                                    }

                                    Intent it2 = new Intent(CadastroAluno.this,CadastroAlunoFinal.class);
                                    it2.putExtra("nomeCompleto",nomeCompleto);
                                    it2.putExtra("rg",rg);
                                    it2.putExtra("cpf",cpf);
                                    it2.putExtra("dataNascimento",dataNascimento);
                                    it2.putExtra("sexo",sexo);
                                    it2.putExtra("telefone", telefone);
                                    it2.putExtra("endereco", endereco);
                                    it2.putExtra("ddd", ddd);
                                    it2.putExtra("email", email);
                                    it2.putExtra("senha", senha);

                                    startActivity(it2);

                                }else{
                                    Toast.makeText(CadastroAluno.this, "Selecione o sexo.", Toast.LENGTH_SHORT).show();
                                    rbCadastroFeminino.requestFocus();
                                }
                            }else{
                                Toast.makeText(CadastroAluno.this, "Informe a data de nascimento.", Toast.LENGTH_SHORT).show();
                                etCadastroDataNasc.requestFocus();
                            }
                        }else{
                            Toast.makeText(CadastroAluno.this, "Informe o CPF.", Toast.LENGTH_SHORT).show();
                            etCadastroCPF.requestFocus();
                        }
                    }else{
                        Toast.makeText(CadastroAluno.this, "Informe o RG.", Toast.LENGTH_SHORT).show();
                        etCadastroRG.requestFocus();
                    }
                }else{
                    Toast.makeText(CadastroAluno.this, "Informe o nome completo.", Toast.LENGTH_SHORT).show();
                    etCadastroNomeCompleto.requestFocus();
                }
                Intent it = getIntent();
                if(it != null){
                    Bundle parametrosRecebidos = it.getExtras();
                    telefone = parametrosRecebidos.getInt("telefone");
                    endereco = (Endereco) parametrosRecebidos.get("endereco");
                    ddd =  parametrosRecebidos.getInt("ddd");
                    email =  parametrosRecebidos.getString("email");
                    senha = parametrosRecebidos.getString("senha");
                }
            }
        }
    };

}
