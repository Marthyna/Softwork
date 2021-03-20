package com.example.mariana.softwork20;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import classesDominio.Empresa;
import classesDominio.Vaga;

public class EmpresaVagaDetalhar extends AppCompatActivity {

    EditText etDetalhaVagaTitulo, etDetalhaVagaDescricao, etDetalhaVagaSetor,
            etDetalhaVagaSalario;
    TextView tvDetalhaVagaLocalidade, tvDetalhaVagaEmpresa, tvDetalhaVagaEndereco,
            tvDetalhaVagaTelefone;
    RadioButton rbDetalhaVagaRemunerada, rbDetalhaVagaNaoRemunerada;
    Spinner spDetalhaVagaTurno;
    Button bDetalhaVagaEditar;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    Vaga minhaVaga;
    Empresa minhaEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empresa_vaga_detalhar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etDetalhaVagaDescricao = findViewById(R.id.etDetalhaVagaDescricao);
        etDetalhaVagaSalario = findViewById(R.id.etDetalhaVagaSalario);
        etDetalhaVagaSetor = findViewById(R.id.etDetalhaVagaSetor);
        etDetalhaVagaTitulo = findViewById(R.id.etDetalhaVagaTitulo);
        tvDetalhaVagaEmpresa = findViewById(R.id.tvDetalhaVagaEmpresa);
        tvDetalhaVagaEndereco = findViewById(R.id.tvDetalhaVagaEndereco);
        tvDetalhaVagaLocalidade = findViewById(R.id.tvDetalhaVagaLocalidade);
        tvDetalhaVagaTelefone = findViewById(R.id.tvDetalhaVagaTelefone);
        rbDetalhaVagaRemunerada = findViewById(R.id.rbDetalhaVagaRemunerada);
        rbDetalhaVagaNaoRemunerada = findViewById(R.id.rbDetalhaVagaNaoRemunerada);
        spDetalhaVagaTurno = findViewById(R.id.spDetalhaVagaTurno);
        bDetalhaVagaEditar = findViewById(R.id.bDetalhaVagaEditar);

        bDetalhaVagaEditar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();

        Spinner mySpinnerTurno = (Spinner) findViewById(R.id.spDetalhaVagaTurno);

        ArrayAdapter<String> myAdapterTurno2 = new ArrayAdapter<String>(EmpresaVagaDetalhar.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.turno));
        myAdapterTurno2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinnerTurno.setAdapter(myAdapterTurno2);

        Intent it = getIntent();
        Bundle parametrosRecebidos = it.getExtras();
        minhaVaga = (Vaga) parametrosRecebidos.get("vaga");
        minhaEmpresa = (Empresa) parametrosRecebidos.get("empresa");

        etDetalhaVagaTitulo.setText(minhaVaga.getNome());
        tvDetalhaVagaLocalidade.setText(minhaEmpresa.getEndereco().getCidade());

        boolean remunerada = minhaVaga.isRemunerada();
        if (remunerada) {
            rbDetalhaVagaRemunerada.setChecked(true);
            rbDetalhaVagaNaoRemunerada.setChecked(false);
            etDetalhaVagaSalario.setEnabled(true);
        } else {
            rbDetalhaVagaNaoRemunerada.setChecked(true);
            rbDetalhaVagaRemunerada.setChecked(false);
            etDetalhaVagaSalario.setEnabled(false);
        }

        tvDetalhaVagaEmpresa.setText("Empresa: " + minhaEmpresa.getNomeFantasia());
        tvDetalhaVagaEndereco.setText("Endereço: " + minhaEmpresa.getEndereco().getRua() + ", nº " + minhaEmpresa.getEndereco().getNumero() + " - Bairro " + minhaEmpresa.getEndereco().getBairro() + " - Complemento: " + minhaEmpresa.getEndereco().getComplemento() + " - " + minhaEmpresa.getEndereco().getCidade());
        tvDetalhaVagaTelefone.setText("Telefone: (" + String.valueOf(minhaEmpresa.getDdd()) + ") - " + String.valueOf(minhaEmpresa.getTelefone()));

        etDetalhaVagaDescricao.setText(minhaVaga.getDescricao());
        spDetalhaVagaTurno.setSelection(minhaVaga.getTurno());
        etDetalhaVagaSetor.setText(minhaVaga.getSetor());

        if (minhaVaga.isRemunerada()) {
            etDetalhaVagaSalario.setText(String.valueOf(minhaVaga.getSalario()));
        }
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == bDetalhaVagaEditar.getId()){
                if (!etDetalhaVagaTitulo.getText().toString().equals("")) {
                    if (rbDetalhaVagaRemunerada.isChecked() || rbDetalhaVagaNaoRemunerada.isChecked()) {
                        if (!etDetalhaVagaDescricao.getText().toString().equals("")) {
                            if (spDetalhaVagaTurno.getSelectedItemPosition() != 0) {
                                if (!etDetalhaVagaSetor.getText().equals("")) {
                                    String nome = etDetalhaVagaTitulo.getText().toString();
                                    String setor = etDetalhaVagaSetor.getText().toString();
                                    String descricao = etDetalhaVagaDescricao.getText().toString();
                                    boolean preenchida = false;
                                    int turno = spDetalhaVagaTurno.getSelectedItemPosition();
                                    LocalDate data = LocalDate.now();
                                    boolean remunerada = false;
                                    float salario = 0;

                                    Vaga minhaVaga = null;

                                    if (rbDetalhaVagaRemunerada.isChecked()) {
                                        if (!etDetalhaVagaSalario.getText().toString().equals("")) {
                                            remunerada = true;
                                            salario = Float.parseFloat(etDetalhaVagaSalario.getText().toString());
                                        } else {
                                            Toast.makeText(informacoesApp, "Informe o salário da vaga.", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, data, 0, minhaEmpresa);
                                    minhaVaga.setTurnoLiteral();
                                    minhaVaga.setSalario(salario);

                                    final Vaga finalMinhaVaga = minhaVaga;
                                    final Vaga finalMinhaVaga1 = minhaVaga;
                                    Thread thread = new Thread(){
                                        @Override
                                        public void run(){
                                            try {
                                                informacoesApp.out.writeObject("editarVaga");

                                                mensagemRecebida = (String) informacoesApp.in.readObject();

                                                if (mensagemRecebida.equals("Ok")) {
                                                    informacoesApp.out.writeObject(finalMinhaVaga);

                                                    mensagemRecebida = (String) informacoesApp.in.readObject();

                                                    if (mensagemRecebida.equals("vagaEditada")) {
                                                        runOnUiThread(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                Toast.makeText(informacoesApp, "Vaga editada com sucesso!", Toast.LENGTH_SHORT).show();
                                                            }
                                                        });
                                                        Intent it = new Intent(EmpresaVagaDetalhar.this,EmpresaRecebidosPorVaga.class);
                                                        it.putExtra("empresa",minhaEmpresa);
                                                        it.putExtra("vaga", finalMinhaVaga1);
                                                        startActivity(it);
                                                    }
                                                }
                                            } catch (IOException | ClassNotFoundException ex) {
                                                Logger.getLogger(EmpresaVagaDetalhar.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                    };
                                    thread.start();


                                } else {
                                    Toast.makeText(informacoesApp, "Informe o setor da vaga.", Toast.LENGTH_SHORT).show();
                                    etDetalhaVagaSetor.requestFocus();
                                }
                            } else {
                                Toast.makeText(informacoesApp, "Informe o turno da vaga.", Toast.LENGTH_SHORT).show();
                                spDetalhaVagaTurno.requestFocus();
                            }
                        } else {
                            Toast.makeText(informacoesApp, "Informe a descrição da vaga.", Toast.LENGTH_SHORT).show();
                            etDetalhaVagaDescricao.requestFocus();
                        }
                    } else {
                        Toast.makeText(informacoesApp, "Selecione uma opção de remuneração.", Toast.LENGTH_SHORT).show();
                        rbDetalhaVagaRemunerada.requestFocus();
                    }
                } else {
                    Toast.makeText(informacoesApp, "Informe o título da vaga.", Toast.LENGTH_SHORT).show();
                    etDetalhaVagaTitulo.requestFocus();
                }
            }
        }
    };

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if ((id == android.R.id.home)) {
            Intent it = new Intent();
            it.putExtra("empresa",minhaEmpresa);
            setResult(1, it);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
