package cliente;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.mail.PasswordAuthentication;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class RecuperaSenha extends javax.swing.JFrame {

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    public RecuperaSenha(Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Informe seu e-mail:");

        jButton1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jButton1.setText("Enviar senha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTFEmail.getText().equals("")) {
            String email = jTFEmail.getText();
            try {
                out.writeObject("recuperaSenha");
                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("Ok")) {
                    out.writeObject(email);
                    mensagemRecebida = (String) in.readObject();
                    if (mensagemRecebida.equals("enviaCodPessoaSenha")) {
                        out.writeObject("Ok");
                        int cod_pessoa = (int) in.readObject();
                        String senhaCriptografada = (String) in.readObject();
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

                        String minhaSenha = "TrabalhoFinal123";

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

                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress("softworkempresa@gmail.com")); //Remetente

                            Address[] toUser = InternetAddress.parse(email);

                            message.setRecipients(Message.RecipientType.TO, toUser);
                            message.setSubject("Recuperação de senha");//Assunto
                            message.setText("Olá! Aqui está sua senha: " + senhaOriginal);
                            /**
                             * Método para enviar a mensagem criada
                             */
                            Transport.send(message);

                            Login telaLogin = new Login();
                            telaLogin.setVisible(true);
                            this.dispose();

                        } catch (MessagingException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (mensagemRecebida.equals("emailInvalido")) {
                        JOptionPane.showMessageDialog(rootPane, "Email inválido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(RecuperaSenha.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o e-mail!");
            jTFEmail.requestFocus();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    public String descriptografa(String senhaCriptografada, int codigoUsuario) {
        String senhaOriginal = "";

        int chave = codigoUsuario + senhaCriptografada.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {
            char[] letras = alfabetosCriptografia[x].toCharArray();

            char[] letrasSenha = senhaCriptografada.toCharArray();
            char[] vetorSenhaOriginal = new char[letrasSenha.length];

            for (int y = 0; y < letrasSenha.length; y++) {
                char caractere = letrasSenha[y];
                System.out.println("Caractere: " + caractere);
                int posicaoLetra = 0;

                for (int z = 0; z < letras.length; z++) {
                    if (letras[z] == caractere) {
                        posicaoLetra = z;
                    }
                }
                int posicaoNova = posicaoLetra - chave;                
                if (posicaoNova <= 0) {
                    posicaoNova = posicaoNova + 70;
                }
                vetorSenhaOriginal[y] = letras[posicaoNova];
            }
            senhaOriginal = new String(vetorSenhaOriginal);
        }

        return senhaOriginal;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTFEmail;
    // End of variables declaration//GEN-END:variables
}
