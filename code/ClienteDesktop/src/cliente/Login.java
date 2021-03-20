package cliente;

import classesDominio.Aluno;
import classesDominio.Empresa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    String mensagemRecebida = "";
    ObjectOutputStream out;
    ObjectInputStream in;
    String[] alfabetosCriptografia = new String[3];
    Socket cliente;

    public Login() {
        initComponents();
        this.alfabetosCriptografia[0] = "KoqCRZw0cvG&fmrMp*iYW@OALEsgUzS3kytP#e1BNV2$bja4xn8J%TFQ5l6I7uH-9D+hdX";
        this.alfabetosCriptografia[1] = "sXqNOh%MFrT1J0Lk*GB#825-dAPUI$ljzQY3vfRa7VgKtiucZ@opnwSeHx&E64yCbm+WD9";
        this.alfabetosCriptografia[2] = "iD128oHvFZE+U-SuMX3eAxB*nhmjpszYcqwR&kGb%KVI5arPt7W$L940dT#OQJl@6NgCfy";
        try {
            this.cliente = new Socket("127.0.0.1", 12345);
            this.out = new ObjectOutputStream(cliente.getOutputStream());
            this.in = new ObjectInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jPFSenha = new javax.swing.JPasswordField();
        jBEntrar = new javax.swing.JButton();
        jLCadastrar = new javax.swing.JLabel();
        jLEsqueciSenha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_icon.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel2.setText("Login");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel3.setText("E-mail:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel4.setText("Senha:");

        jTFEmail.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jPFSenha.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jBEntrar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBEntrar.setText("Entrar");
        jBEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEntrarActionPerformed(evt);
            }
        });

        jLCadastrar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLCadastrar.setText("Não tem uma conta? Cadastre-se aqui.");
        jLCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCadastrarMouseClicked(evt);
            }
        });

        jLEsqueciSenha.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEsqueciSenha.setText("Esqueci minha senha.");
        jLEsqueciSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEsqueciSenhaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLCadastrar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPFSenha)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE))))))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(182, 182, 182))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLEsqueciSenha)
                        .addGap(169, 169, 169))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLEsqueciSenha)
                .addGap(18, 18, 18)
                .addComponent(jBEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLCadastrar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCadastrarMouseClicked
        CadastroGeral telaCadastroGeral = new CadastroGeral(alfabetosCriptografia, cliente, out, in);
        telaCadastroGeral.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLCadastrarMouseClicked

    private void jBEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEntrarActionPerformed
        if (!jTFEmail.getText().equals("")) {
            if (!jPFSenha.getText().equals("")) {
                try {
                    out.writeObject("validaUsuario");
                    mensagemRecebida = (String) in.readObject();
                    if (mensagemRecebida.equals("Ok")) {
                        String email = jTFEmail.getText();
                        String senha = jPFSenha.getText();
                        out.writeObject(email);
                        mensagemRecebida = (String) in.readObject();
                        
                        if (mensagemRecebida.equals("cod_pessoa")) {
                            int cod_pessoa = ((int) in.readObject());
                            String senhaCriptografada = criptografa(senha, cod_pessoa);
                            out.writeObject(senhaCriptografada);

                            mensagemRecebida = (String) in.readObject();
                            if (mensagemRecebida.equals("senhaValida")) {
                                out.writeObject("Ok");
                                mensagemRecebida = (String) in.readObject();
                                if (mensagemRecebida.equals("usuarioAluno")) {
                                    out.writeObject("Ok");
                                    Aluno meuAluno = (Aluno) in.readObject();
                                    int cod_aluno = (int) in.readObject();
                                    
                                    meuAluno.setID(cod_aluno);
                                    
                                    AlunoOfertas telaAlunoOfertas = new AlunoOfertas(meuAluno, cliente, out, in, alfabetosCriptografia);
                                    telaAlunoOfertas.setVisible(true);
                                    this.dispose();
                                    
                                } else if (mensagemRecebida.equals("usuarioEmpresa")) {
                                    out.writeObject("Ok");
                                    Empresa minhaEmpresa = (Empresa) in.readObject();
                                    int cod_empresa = (int) in.readObject();
                                    
                                    minhaEmpresa.setID(cod_empresa);
                                    
                                    EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                                    telaRecebidos.setVisible(true);
                                    this.dispose();
                                }
                            } else if (mensagemRecebida.equals("senhaInvalida")) {
                                JOptionPane.showMessageDialog(rootPane, "Senha incorreta!");
                                jPFSenha.requestFocus();
                            }
                        } else if (mensagemRecebida.equals("EmailInvalido")){
                            JOptionPane.showMessageDialog(rootPane, "O email informado é inválido.");
                            jTFEmail.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                    }

                } catch (IOException | ClassNotFoundException ioe) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ioe);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Informe a senha!");
                jPFSenha.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Informe o e-mail!");
            jTFEmail.requestFocus();
        }
    }//GEN-LAST:event_jBEntrarActionPerformed

    private void jLEsqueciSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEsqueciSenhaMouseClicked
        RecuperaSenha telaRecuperaSenha = new RecuperaSenha(cliente,out,in,alfabetosCriptografia);
        telaRecuperaSenha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLEsqueciSenhaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            out.writeObject("fim");
            
            in.close();

            out.close();

            this.cliente.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new Login().setVisible(true);
        });
    }

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

    public String criptografa(String senhaOriginal, int codigoUsuario) {
        String senhaCriptografada = "";
        int chave = codigoUsuario + senhaOriginal.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {

            char[] letras = alfabetosCriptografia[x].toCharArray(); // vetor com as letras do alfabeto

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

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEntrar;
    private javax.swing.JLabel jLCadastrar;
    private javax.swing.JLabel jLEsqueciSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFEmail;
    // End of variables declaration//GEN-END:variables
}
