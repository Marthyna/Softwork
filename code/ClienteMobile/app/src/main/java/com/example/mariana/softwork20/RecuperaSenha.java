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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class RecuperaSenha extends AppCompatActivity {

    EditText etRecuperaSenhaEmail;
    Button bRecuperaSenhaEnviar;

    InformacoesApp informacoesApp;

    String mensagemRecebida = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recupera_senha);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etRecuperaSenhaEmail = findViewById(R.id.etRecuperaSenhaEmail);
        bRecuperaSenhaEnviar = findViewById(R.id.bRecuperaSenhaEnviar);

        bRecuperaSenhaEnviar.setOnClickListener(trataClique);

        informacoesApp = (InformacoesApp) getApplicationContext();
    }

    View.OnClickListener trataClique = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == bRecuperaSenhaEnviar.getId()){
                if (!etRecuperaSenhaEmail.getText().toString().equals("")){
                    final String email = etRecuperaSenhaEmail.getText().toString();
                    Thread thread = new Thread(){
                        @Override
                        public void run(){
                            try {
                                informacoesApp.out.writeObject("recuperaSenha");
                                mensagemRecebida = (String) informacoesApp.in.readObject();
                                if (mensagemRecebida.equals("Ok")) {
                                    informacoesApp.out.writeObject(email);
                                    mensagemRecebida = (String) informacoesApp.in.readObject();
                                    if (mensagemRecebida.equals("enviaCodPessoaSenha")) {
                                        informacoesApp.out.writeObject("Ok");
                                        int cod_pessoa = (int) informacoesApp.in.readObject();
                                        String senhaCriptografada = (String) informacoesApp.in.readObject();
                                        String senhaOriginal = descriptografa(senhaCriptografada, cod_pessoa);

                                        Properties props = new Properties();
                                        /**
                                         * Parâmetros de conexão com servidor Gmail
                                         */
                                        props.put("mail.smtp.host", "smtp.gmail.com");
                                        props.put("mail.smtp.socketFactory.port", "465");
                                        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                                        props.put("mail.smtp.auth", "true");
                                        props.put("mail.smtp.port", "465");

                                        final String minhaSenha = "TrabalhoFinal123";

                                        Authenticator auth = new Authenticator() {

                                            public PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication("softworkempresa@gmail.com", minhaSenha);
                                            }
                                        };
                                        Session session = Session.getInstance(props, auth);

                                        /**
                                         * Ativa Debug para sessão
                                         */
                                        session.setDebug(true);

                                        try {

                                            javax.mail.Message message = new MimeMessage(session);
                                            message.setFrom(new InternetAddress("softworkempresa@gmail.com")); //Remetente

                                            Address[] toUser = InternetAddress.parse(email);

                                            message.setRecipients(javax.mail.Message.RecipientType.TO, toUser);
                                            message.setSubject("Recuperação de senha");//Assunto
                                            message.setText("Olá! Aqui está sua senha: " + senhaOriginal);
                                            /**
                                             * Método para enviar a mensagem criada
                                             */
                                            Transport.send(message);

                                            Intent it = new Intent(RecuperaSenha.this,Login.class);
                                            startActivity(it);

                                        } catch (MessagingException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else if (mensagemRecebida.equals("emailInvalido")){
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                Toast.makeText(informacoesApp, "Email inválido.", Toast.LENGTH_SHORT).show();
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
                            } catch (IOException | ClassNotFoundException ex) {
                                Logger.getLogger(RecuperaSenha.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    };
                    thread.start();
                } else {
                    Toast.makeText(informacoesApp, "Informe o e-mail!", Toast.LENGTH_SHORT).show();
                    etRecuperaSenhaEmail.requestFocus();
                }
            }
        }
    };

    public String descriptografa(String senhaCriptografada, int codigoUsuario) {
        String senhaOriginal = "";

        int chave = codigoUsuario + senhaCriptografada.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {

            char[] letras = informacoesApp.alfabetosCriptografia[x].toCharArray();

            char[] letrasSenha = senhaCriptografada.toCharArray();
            char[] vetorSenhaOriginal = new char[letrasSenha.length];

            for (int y = 0; y < letrasSenha.length; y++) {
                char caractere = letrasSenha[y];
                int posicaoLetra = 0;

                for (int z = 0; z < letras.length; z++) {
                    if (letras[z] == caractere) {
                        posicaoLetra = z;
                    }
                }
                int posicaoNova = posicaoLetra - chave;
                if (posicaoNova <= 0) {
                    posicaoNova += 70;
                }
                vetorSenhaOriginal[y] = letras[posicaoNova];
            }
            senhaOriginal = new String(vetorSenhaOriginal);
        }

        return senhaOriginal;
    }


}
