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
import android.widget.Spinner;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import classesDominio.Aluno;
import classesDominio.Endereco;

public class CadastroAlunoFinal extends AppCompatActivity {

    EditText etCadastroFinalMatricula;
    Button bCadastroFinalEnviar;
    Spinner spCadastroFinalAno,spCadastroFinalTurno,spCadastroFinalCurso;

    int telefone = 0;
    Endereco endereco = null;
    int ddd = 0;
    String email = "";
    String senha = "";
    String nomeCompleto = "";
    long rg = 0;
    long cpf = 0;
    LocalDate dataNascimento = null;
    int sexo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_aluno_final);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etCadastroFinalMatricula = findViewById(R.id.etCadastroFinalMatricula);
        spCadastroFinalCurso = findViewById(R.id.spCadastroFinalCurso);
        bCadastroFinalEnviar = findViewById(R.id.bCadastroFinalEnviar);
        spCadastroFinalAno = findViewById(R.id.spCadastroFinalAno);
        spCadastroFinalTurno = findViewById(R.id.spCadastroFinalTurno);

        bCadastroFinalEnviar.setOnClickListener(trataClique);

        Spinner mySpinnerAno = (Spinner) findViewById(R.id.spCadastroFinalAno);
        Spinner mySpinnerTurno = (Spinner) findViewById(R.id.spCadastroFinalTurno);
        Spinner mySpinnerCurso = (Spinner) findViewById(R.id.spCadastroFinalCurso);

        ArrayAdapter<String> myAdapterAno = new ArrayAdapter<String>(CadastroAlunoFinal.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ano));
        myAdapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerAno.setAdapter(myAdapterAno);

        ArrayAdapter<String> myAdapterTurno = new ArrayAdapter<String>(CadastroAlunoFinal.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.turno));
        myAdapterTurno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerTurno.setAdapter(myAdapterTurno);

        ArrayAdapter<String> myAdapterCurso = new ArrayAdapter<String>(CadastroAlunoFinal.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.curso));
        myAdapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerCurso.setAdapter(myAdapterCurso);

    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            if(view.getId() == bCadastroFinalEnviar.getId()){
                if(!etCadastroFinalMatricula.getText().toString().equals("")){
                    if(spCadastroFinalAno.getSelectedItemPosition() != 0){
                        if(spCadastroFinalTurno.getSelectedItemPosition() != 0){
                            if(spCadastroFinalCurso.getSelectedItemPosition() != 0){

                                Intent it = getIntent();
                                if(it != null){
                                    Bundle parametrosRecebidos = it.getExtras();
                                    telefone = parametrosRecebidos.getInt("telefone");
                                    endereco = (Endereco) parametrosRecebidos.get("endereco");
                                    ddd =  parametrosRecebidos.getInt("ddd");
                                    email =  parametrosRecebidos.getString("email");
                                    senha =  parametrosRecebidos.getString("senha");
                                    nomeCompleto = parametrosRecebidos.getString("nomeCompleto");
                                    rg = parametrosRecebidos.getLong("rg");
                                    cpf = parametrosRecebidos.getLong("cpf");
                                    dataNascimento = (LocalDate) parametrosRecebidos.get("dataNascimento");
                                    sexo = parametrosRecebidos.getInt("sexo");
                                }


                                long matricula = Long.parseLong(etCadastroFinalMatricula.getText().toString());
                                int ano = Integer.parseInt(spCadastroFinalAno.getSelectedItem().toString());
                                int turno = spCadastroFinalTurno.getSelectedItemPosition();
                                String curso = String.valueOf(spCadastroFinalCurso.getSelectedItem());
                                boolean empregado = false;

                                Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, senha);
                                meuAluno.setSexoLiteral();
                                meuAluno.setTurnoLiteral();

                                Intent it2 = new Intent(CadastroAlunoFinal.this, CadastroCurriculo.class);
                                it2.putExtra("aluno",meuAluno);
                                startActivity(it2);

                            }else{
                                Toast.makeText(CadastroAlunoFinal.this, "Informe o curso.", Toast.LENGTH_SHORT).show();
                                spCadastroFinalCurso.requestFocus();
                            }
                        }else{
                            Toast.makeText(CadastroAlunoFinal.this, "Informe o turno.", Toast.LENGTH_SHORT).show();
                            spCadastroFinalTurno.requestFocus();
                        }
                    }else{
                        Toast.makeText(CadastroAlunoFinal.this, "Informe o ano.", Toast.LENGTH_SHORT).show();
                        spCadastroFinalAno.requestFocus();
                    }
                }else{
                    Toast.makeText(CadastroAlunoFinal.this, "Informe a matrícula.", Toast.LENGTH_SHORT).show();
                    etCadastroFinalMatricula.requestFocus();
                }
            }
        }
    };

}
