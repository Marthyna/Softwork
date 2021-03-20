package cliente;

import classesDominio.Endereco;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroGeral extends javax.swing.JFrame {

    String[] alfabetosCritpografia;
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    public CadastroGeral(String[] alfabetosCriptografia, Socket cliente, ObjectOutputStream out, ObjectInputStream in) {
        initComponents();
        this.alfabetosCritpografia = alfabetosCriptografia;
        this.cliente = cliente;
        this.in = in;
        this.out = out;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jRBAluno = new javax.swing.JRadioButton();
        jRBEmpresa = new javax.swing.JRadioButton();
        jTFEmail = new javax.swing.JTextField();
        jTFRua = new javax.swing.JTextField();
        jTFNumero = new javax.swing.JTextField();
        jTFBairro = new javax.swing.JTextField();
        jTFComplemento = new javax.swing.JTextField();
        jTFCidade = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();
        jBEnviar = new javax.swing.JButton();
        jTFDDD = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFTFTelefone = new javax.swing.JFormattedTextField();
        jFTFCEP = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jPFSenha = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        jPFSenhaConfirma = new javax.swing.JPasswordField();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar");

        jRBAluno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBAluno.setText("Aluno");
        jRBAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBAlunoActionPerformed(evt);
            }
        });

        jRBEmpresa.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBEmpresa.setText("Empresa");
        jRBEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBEmpresaActionPerformed(evt);
            }
        });

        jTFEmail.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFEmailActionPerformed(evt);
            }
        });

        jTFRua.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFNumero.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFBairro.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFComplemento.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFCidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jBVoltar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBVoltar.setText("Voltar");
        jBVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVoltarActionPerformed(evt);
            }
        });

        jBEnviar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBEnviar.setText("Enviar");
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        jTFDDD.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("E-mail:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("DDD:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Rua:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Número:");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Bairro:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Complemento:");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("CEP:");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Cidade:");

        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFTFCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCEP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFCEPActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("Senha:");

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Confirmar senha:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jRBAluno)
                .addGap(48, 48, 48)
                .addComponent(jRBEmpresa)
                .addGap(171, 171, 171))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(278, 278, 278)
                                .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFNumero))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel10))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel8)))
                                        .addGap(91, 91, 91))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(222, 222, 222)
                                .addComponent(jTFCidade))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(83, 83, 83)
                            .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPFSenhaConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(224, 224, 224))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBEmpresa)
                    .addComponent(jRBAluno))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jPFSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jPFSenhaConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        if (jRBAluno.isSelected() || jRBEmpresa.isSelected()) {
            if (!jTFEmail.getText().equals("")) {
                if (!jPFSenha.getText().equals("")) {
                    if (!jPFSenhaConfirma.getText().equals("")) {
                        if (!jTFDDD.getText().equals("")) {
                            if (!"    -    ".equals(jFTFTelefone.getText())) {
                                if (!jTFRua.getText().equals("")) {
                                    if (!jTFNumero.getText().equals("")) {
                                        if (!jTFBairro.getText().equals("")) {
                                            if (!"     -   ".equals(jFTFCEP.getText())) {
                                                if (!jTFCidade.getText().equals("")) {

                                                    try {
                                                        out.writeObject("verificaEmail");

                                                        mensagemRecebida = (String) in.readObject();

                                                        if (mensagemRecebida.equals("Ok")) {
                                                            out.writeObject(jTFEmail.getText());

                                                            mensagemRecebida = (String) in.readObject();

                                                            if (mensagemRecebida.equals("emailEmUso")) {
                                                                JOptionPane.showMessageDialog(rootPane, "Este email já está sendo utilizado.");
                                                            } else if (mensagemRecebida.equals("emailDisponivel")) {
                                                                char letras[] = jPFSenha.getText().toCharArray(); // transforma a senha em um vetor de letras

                                                                boolean temCaracterInvalido = false; // cria a variável de validação

                                                                for (int x = 0; x < letras.length; x++) { // for que percorre o vetor da senha
                                                                    char letra = letras[x]; // pega cada caracter um por um

                                                                    // letras aceitas na senha
                                                                    String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";
                                                                    // vetor das letras aceitas
                                                                    char[] letrasAlfabeto = alfabeto.toCharArray();

                                                                    for (int z = 0; z < letrasAlfabeto.length; z++) { // for que percorre o vetros de letras aceitas
                                                                        if (letrasAlfabeto[z] == letra) { // se a letra no alfabeto por igual ao caracter da senha
                                                                            temCaracterInvalido = false; // nao tem caracter invalido
                                                                            break; // para
                                                                        } else {
                                                                            temCaracterInvalido = true; // enquanto nao achar um letra igual, supõe que os caracteres são invalidos
                                                                        }
                                                                    }

                                                                }

                                                                if (!temCaracterInvalido) {
                                                                    int tipo = 0;
                                                                    if (jRBAluno.isSelected()) {
                                                                        tipo = 1;
                                                                    } else if (jRBEmpresa.isSelected()) {
                                                                        tipo = 2;
                                                                    }
                                                                    String email = jTFEmail.getText();
                                                                    String telefoneString = jFTFTelefone.getText();
                                                                    telefoneString = telefoneString.replace("-", "");
                                                                    int telefone = Integer.parseInt(telefoneString);
                                                                    String rua = jTFRua.getText();
                                                                    int numero = Integer.parseInt(jTFNumero.getText());
                                                                    String bairro = jTFBairro.getText();
                                                                    String complemento = " ";
                                                                    if(!jTFComplemento.getText().equals("")){
                                                                        complemento = jTFComplemento.getText();
                                                                    }
                                                                    String cidade = jTFCidade.getText();
                                                                    String cepString = jFTFCEP.getText();
                                                                    cepString = cepString.replace("-", "");
                                                                    int cep = Integer.parseInt(cepString);
                                                                    int ddd = Integer.parseInt(jTFDDD.getText());
                                                                    String senha = jPFSenha.getText();
                                                                    String senhaConfirma = jPFSenhaConfirma.getText();

                                                                    if (senha.equals(senhaConfirma)) {
                                                                        Endereco meuEndereco = new Endereco(rua, numero, bairro, cidade, cep);
                                                                        meuEndereco.setComplemento(complemento);
                                                                        if (tipo == 1) {
                                                                            CadastroAluno telaCadastroAluno = new CadastroAluno(meuEndereco, telefone, ddd, email, senha, alfabetosCritpografia, cliente, out, in);
                                                                            telaCadastroAluno.setVisible(true);
                                                                            this.dispose();
                                                                        } else if (tipo == 2) {
                                                                            CadastroEmpresa telaCadastroEmpresa = new CadastroEmpresa(meuEndereco, telefone, ddd, email, senha, alfabetosCritpografia, cliente, out, in);
                                                                            telaCadastroEmpresa.setVisible(true);
                                                                            this.dispose();
                                                                        }
                                                                    } else {
                                                                        JOptionPane.showMessageDialog(rootPane, "As senhas não conferem! Digite novamente.");
                                                                    }
                                                                } else {
                                                                    JOptionPane.showMessageDialog(rootPane, "A senha possui caracteres inválidos!");
                                                                }
                                                            }
                                                        }

                                                    } catch (IOException | ClassNotFoundException ex) {
                                                        Logger.getLogger(CadastroGeral.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(rootPane, "Informe a cidade!");
                                                    jTFCidade.requestFocus();
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(rootPane, "Informe o CEP!");
                                                jFTFCEP.requestFocus();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Informe o bairro!");
                                            jTFBairro.requestFocus();
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Informe o número!");
                                        jTFNumero.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Informe a rua!");
                                    jTFRua.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Informe o telefone!");
                                jFTFTelefone.requestFocus();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Informe o DDD!");
                            jTFDDD.requestFocus();
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Confirme a senha!");
                        jPFSenhaConfirma.requestFocus();

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe a senha!");
                    jPFSenha.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe o email!");
                jTFEmail.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o tipo de usuário!");
            jRBAluno.requestFocus();
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private void jTFEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFEmailActionPerformed

    private void jFTFCEPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFCEPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFCEPActionPerformed

    private void jRBEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBEmpresaActionPerformed
        jRBAluno.setSelected(false);
    }//GEN-LAST:event_jRBEmpresaActionPerformed

    private void jRBAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBAlunoActionPerformed
        jRBEmpresa.setSelected(false);
    }//GEN-LAST:event_jRBAlunoActionPerformed

    public void limpaCampos() {
        jTFEmail.setText("");
        jFTFTelefone.setText("");
        jTFRua.setText("");
        jTFNumero.setText("");
        jRBAluno.setSelected(false);
        jRBEmpresa.setSelected(false);
        jTFBairro.setText("");
        jFTFCEP.setText("");
        jTFComplemento.setText("");
        jTFCidade.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JFormattedTextField jFTFCEP;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFSenha;
    private javax.swing.JPasswordField jPFSenhaConfirma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBAluno;
    private javax.swing.JRadioButton jRBEmpresa;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFDDD;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFRua;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
