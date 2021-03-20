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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Aluno;
import classesDominio.Curriculo;
import classesDominio.Endereco;

public class AlunoConta extends AppCompatActivity {

    EditText etContaEmail,etContaNomeCompleto,etContaRG,etContaCPF,
            etContaDataNascimento,etContaDDD,etContaTelefone,etContaRua,
            etContaNumero,etContaComplemento,etContaBairro,etContaCidade,
            etContaCEP,etContaMatricula,etContaDescricao,etContaFormacao1,
            etContaIdioma1,etContaIdioma2,etContaFormacao2,etContaIdioma3,
            etContaFormacao3,etContaCurso1,etContaEmprego1,etContaCurso2,
            etContaEmprego2,etContaCurso3,etContaEmprego3;
    Button bRedefineSenha,bContaSalvar;
    RadioButton rbContaFeminino,rbContaMasculino;
    Spinner spContaAno,spContaTurno,spContaCurso;

    InformacoesApp informacoesApp;

    Aluno meuAluno;

    String mensagemRecebida = "";

    static final int CODIGO_ALUNO_REDEFINE_SENHA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_conta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        etContaEmail = findViewById(R.id.etContaEmail);
        etContaNomeCompleto = findViewById(R.id.etContaNomeCompleto);
        etContaRG = findViewById(R.id.etContaRG);
        etContaCPF = findViewById(R.id.etContaCPF);
        etContaDataNascimento = findViewById(R.id.etContaDataNascimento);
        etContaDDD = findViewById(R.id.etContaDDD);
        etContaTelefone = findViewById(R.id.etContaTelefone);
        etContaRua = findViewById(R.id.etContaRua);
        etContaNumero = findViewById(R.id.etContaNumero);
        etContaBairro = findViewById(R.id.etContaBairro);
        etContaComplemento = findViewById(R.id.etContaComplemento);
        etContaCidade = findViewById(R.id.etContaCidade);
        etContaCEP = findViewById(R.id.etContaCEP);
        etContaMatricula = findViewById(R.id.etContaMatricula);
        etContaDescricao = findViewById(R.id.etContaDescricao);
        etContaFormacao1 = findViewById(R.id.etContaFormacao1);
        etContaIdioma1 = findViewById(R.id.etContaIdioma1);
        etContaIdioma2 = findViewById(R.id.etContaIdioma2);
        etContaIdioma3 = findViewById(R.id.etContaIdioma3);
        etContaCurso1 = findViewById(R.id.etContaCurso1);
        etContaCurso2 = findViewById(R.id.etContaCurso2);
        etContaCurso3 = findViewById(R.id.etContaCurso3);
        etContaEmprego1 = findViewById(R.id.etContaEmprego1);
        etContaEmprego2 = findViewById(R.id.etContaEmprego2);
        etContaEmprego3 = findViewById(R.id.etContaEmprego3);
        bRedefineSenha = findViewById(R.id.bRedefineSenha);
        bContaSalvar = findViewById(R.id.bContaSalvar);
        rbContaMasculino = findViewById(R.id.rbContaMasculino);
        rbContaFeminino = findViewById(R.id.rbContaFeminino);
        spContaAno = findViewById(R.id.spContaAno);
        spContaCurso = findViewById(R.id.spContaCurso);
        spContaTurno = findViewById(R.id.spContaTurno);

        bContaSalvar.setOnClickListener(trataClique);
        bRedefineSenha.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Spinner mySpinnerAno = (Spinner) findViewById(R.id.spContaAno);
        Spinner mySpinnerTurno = (Spinner) findViewById(R.id.spContaTurno);
        Spinner mySpinnerCurso = (Spinner) findViewById(R.id.spContaCurso);

        ArrayAdapter<String> myAdapterAno = new ArrayAdapter<String>(AlunoConta.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ano));
        myAdapterAno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerAno.setAdapter(myAdapterAno);

        ArrayAdapter<String> myAdapterTurno = new ArrayAdapter<String>(AlunoConta.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.turno));
        myAdapterTurno.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerTurno.setAdapter(myAdapterTurno);

        ArrayAdapter<String> myAdapterCurso = new ArrayAdapter<String>(AlunoConta.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.curso));
        myAdapterCurso.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerCurso.setAdapter(myAdapterCurso);

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        meuAluno = (Aluno) parametrosRecebidos.get("aluno");

        etContaEmail.setText(meuAluno.getEmail());

        etContaNomeCompleto.setText(meuAluno.getNomeCompleto());
        etContaRG.setText(String.valueOf(meuAluno.getRg()));
        etContaCPF.setText(String.valueOf(meuAluno.getCpf()));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimento = meuAluno.getDataNascimento().format(formato);
        etContaDataNascimento.setText(String.valueOf(dataNascimento));
        int sexo = meuAluno.getSexo();
        if (sexo == 1) {
            rbContaFeminino.setChecked(true);
        } else if (sexo == 2) {
            rbContaMasculino.setChecked(true);
        }
        etContaDDD.setText(String.valueOf(meuAluno.getDdd()));
        etContaTelefone.setText(String.valueOf(meuAluno.getTelefone()));

        etContaRua.setText(meuAluno.getEndereco().getRua());
        etContaNumero.setText(String.valueOf(meuAluno.getEndereco().getNumero()));
        etContaBairro.setText(meuAluno.getEndereco().getBairro());
        etContaCEP.setText(String.valueOf(meuAluno.getEndereco().getCep()));
        etContaCidade.setText(meuAluno.getEndereco().getCidade());
        etContaComplemento.setText(meuAluno.getEndereco().getComplemento());

        etContaMatricula.setText(String.valueOf(meuAluno.getMatricula()));
        spContaAno.setSelection(meuAluno.getAno());
        spContaTurno.setSelection(meuAluno.getTurno());

        etContaDescricao.setText(meuAluno.getCurriculo().getDescricao());
        etContaIdioma1.setText(meuAluno.getCurriculo().getIdioma1());
        etContaFormacao1.setText(meuAluno.getCurriculo().getFormacao1());
        if (!meuAluno.getCurriculo().getIdioma2().equals("")) {
            etContaIdioma2.setEnabled(true);
            etContaIdioma2.setText(meuAluno.getCurriculo().getIdioma2());
        }
        if (!meuAluno.getCurriculo().getIdioma3().equals("")) {
            etContaIdioma3.setEnabled(true);
            etContaIdioma3.setText(meuAluno.getCurriculo().getIdioma3());
        }
        if (!meuAluno.getCurriculo().getFormacao2().equals("")) {
            etContaFormacao2.setEnabled(true);
            etContaFormacao2.setText(meuAluno.getCurriculo().getFormacao2());
        }
        if (!meuAluno.getCurriculo().getFormacao3().equals("")) {
            etContaFormacao3.setEnabled(true);
            etContaFormacao3.setText(meuAluno.getCurriculo().getFormacao3());
        }
        if (!meuAluno.getCurriculo().getCurso1().equals("")) {
            etContaCurso1.setEnabled(true);
            etContaCurso1.setText(meuAluno.getCurriculo().getCurso1());
        }
        if (!meuAluno.getCurriculo().getCurso2().equals("")) {
            etContaCurso2.setEnabled(true);
            etContaCurso2.setText(meuAluno.getCurriculo().getCurso2());
        }
        if (!meuAluno.getCurriculo().getCurso3().equals("")) {
            etContaCurso3.setEnabled(true);
            etContaCurso3.setText(meuAluno.getCurriculo().getCurso3());
        }
        if (!meuAluno.getCurriculo().getEmprego1().equals("")) {
            etContaEmprego1.setEnabled(true);
            etContaEmprego1.setText(meuAluno.getCurriculo().getEmprego1());
        }
        if (!meuAluno.getCurriculo().getEmprego2().equals("")) {
            etContaEmprego2.setEnabled(true);
            etContaEmprego2.setText(meuAluno.getCurriculo().getEmprego2());
        }
        if (!meuAluno.getCurriculo().getEmprego3().equals("")) {
            etContaEmprego3.setEnabled(true);
            etContaEmprego3.setText(meuAluno.getCurriculo().getEmprego3());
        }
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bRedefineSenha.getId()){
                Intent it = new Intent(AlunoConta.this, AlunoRedefineSenha.class);
                it.putExtra("aluno", meuAluno);
                startActivityForResult(it,CODIGO_ALUNO_REDEFINE_SENHA);
            }else if (view.getId() == bContaSalvar.getId()){
                Thread thread = new Thread(){
                    @Override
                    public void run(){
                        try {
                            String email = etContaEmail.getText().toString();
                            String telefoneString = etContaTelefone.getText().toString();
                            telefoneString = telefoneString.replace("-", "");
                            int telefone = Integer.parseInt(telefoneString);

                            String rua = etContaRua.getText().toString();
                            int numero = Integer.parseInt(etContaNumero.getText().toString());
                            String bairro = etContaBairro.getText().toString();
                            String complemento = etContaComplemento.getText().toString();
                            String cidade = etContaCidade.getText().toString();
                            String cepString = etContaCEP.getText().toString();
                            cepString = cepString.replace("-", "");
                            int cep = Integer.parseInt(cepString);
                            int ddd = Integer.parseInt(etContaDDD.getText().toString());

                            String nomeCompleto = etContaNomeCompleto.getText().toString();
                            String cpfString = etContaCPF.getText().toString();
                            cpfString = cpfString.replace(".", "");
                            cpfString = cpfString.replace("-", "");
                            long cpf = Long.parseLong(cpfString);
                            long rg = Long.parseLong(etContaRG.getText().toString());
                            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate dataNascimento = LocalDate.parse(etContaDataNascimento.getText().toString(), formato);
                            int sexo = 0;
                            if (rbContaFeminino.isChecked()) {
                                sexo = 1;
                            } else if (rbContaMasculino.isChecked()) {
                                sexo = 2;
                            }
                            long matricula = Long.parseLong(etContaMatricula.getText().toString());
                            int ano = spContaAno.getSelectedItemPosition();
                            int turno = spContaTurno.getSelectedItemPosition();
                            String curso = String.valueOf(spContaCurso.getSelectedItemPosition());

                            String descricao = etContaDescricao.getText().toString();
                            String idioma1 = etContaIdioma1.getText().toString();
                            String formacao1 = etContaFormacao1.getText().toString();

                            String idioma2 = "";
                            String idioma3 = "";

                            String formacao2 = "";
                            String formacao3 = "";

                            String curso1 = "";
                            String curso2 = "";
                            String curso3 = "";

                            String emprego1 = "";
                            String emprego2 = "";
                            String emprego3 = "";

                            Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                            meuCurriculo.setID(meuAluno.getCurriculo().getID());

                            if (!etContaIdioma2.getText().toString().equals("")) {
                                idioma2 = etContaIdioma2.getText().toString();
                                meuCurriculo.setIdioma2(idioma2);
                            }
                            if (!etContaIdioma3.getText().toString().equals("")) {
                                idioma3 = etContaIdioma2.getText().toString();
                                meuCurriculo.setIdioma3(idioma3);
                            }

                            if (!etContaFormacao2.getText().toString().equals("")) {
                                formacao2 = etContaFormacao2.getText().toString();
                                meuCurriculo.setFormacao2(formacao2);
                            }
                            if (!etContaFormacao3.getText().toString().equals("")) {
                                formacao3 = etContaFormacao3.getText().toString();
                                meuCurriculo.setFormacao3(formacao3);
                            }

                            if (!etContaCurso1.getText().toString().equals("")) {
                                curso1 = etContaCurso1.getText().toString();
                                meuCurriculo.setCurso1(curso1);
                            }
                            if (!etContaCurso2.getText().toString().equals("")) {
                                curso2 = etContaCurso2.getText().toString();
                                meuCurriculo.setCurso2(curso2);
                            }
                            if (!etContaCurso3.getText().toString().equals("")) {
                                curso3 = etContaCurso3.getText().toString();
                                meuCurriculo.setCurso3(curso3);
                            }

                            if (!etContaEmprego1.getText().toString().equals("")) {
                                emprego1 = etContaEmprego1.getText().toString();
                                meuCurriculo.setEmprego1(emprego1);
                            }
                            if (!etContaEmprego2.getText().toString().equals("")) {
                                emprego2 = etContaEmprego2.getText().toString();
                                meuCurriculo.setEmprego2(emprego2);
                            }
                            if (!etContaEmprego3.getText().toString().equals("")) {
                                emprego3 = etContaEmprego3.getText().toString();
                                meuCurriculo.setEmprego3(emprego3);
                            }

                            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
                            Aluno aluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, rua);
                            aluno.getEndereco().setComplemento(complemento);
                            aluno.setCurriculo(meuCurriculo);
                            aluno.setID(meuAluno.getID());

                            informacoesApp.out.writeObject("salvarDadosConta");
                            mensagemRecebida = (String) informacoesApp.in.readObject();
                            if (mensagemRecebida.equals("Ok")) {
                                informacoesApp.out.writeObject(aluno);

                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                if (mensagemRecebida.equals("alunoAtualizado")) {
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            Toast.makeText(informacoesApp, "As informações da conta foram atualizadas.", Toast.LENGTH_SHORT).show();
                                        }
                                    });
                                }
                            }

                        } catch (IOException | ClassNotFoundException ex) {
                            Logger.getLogger(AlunoConta.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                thread.start();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_aluno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_ofertas:
                Intent it = new Intent(AlunoConta.this,AlunoOfertas.class);
                it.putExtra("aluno", meuAluno);
                startActivity(it);
                return true;
            case R.id.item_aceitos:
                Intent it2 = new Intent(AlunoConta.this,AlunoAceitos.class);
                it2.putExtra("aluno", meuAluno);
                startActivity(it2);
                return true;
            case R.id.item_historico:
                Intent it3 = new Intent(AlunoConta.this,AlunoHistorico.class);
                it3.putExtra("aluno", meuAluno);
                startActivity(it3);
                return true;
            case R.id.item_mensagens:
                Intent it4 = new Intent(AlunoConta.this,AlunoMensagens.class);
                it4.putExtra("aluno", meuAluno);
                startActivity(it4);
                return true;
            case R.id.item_recusados:
                Intent it5 = new Intent(AlunoConta.this,AlunoRecusados.class);
                it5.putExtra("aluno", meuAluno);
                startActivity(it5);
                return true;
            case R.id.item_em_espera:
                Intent it6 = new Intent(AlunoConta.this,AlunoEmEspera.class);
                it6.putExtra("aluno", meuAluno);
                startActivity(it6);
                return true;
            case R.id.item_sair:
                Intent it7 = new Intent(AlunoConta.this,Login.class);
                startActivity(it7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    protected void onActivityResult(int codigo, int resultado, Intent it){
        if(codigo == CODIGO_ALUNO_REDEFINE_SENHA){
            if (it != null){
                meuAluno = (Aluno) it.getSerializableExtra("aluno");
            }
        }
    }
}
