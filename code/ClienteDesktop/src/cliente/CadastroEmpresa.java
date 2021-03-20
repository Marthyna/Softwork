package cliente;

import classesDominio.Empresa;
import classesDominio.Endereco;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastroEmpresa extends javax.swing.JFrame {

    Endereco endereco;
    int telefone;
    int ddd;
    String email;
    String senha;

    String mensagemRecebida = "";
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String[] alfabetosCriptografia;

    public CadastroEmpresa(Endereco endereco, int telefone, int ddd, String email, String senha, String[] alfabetosCriptografia, Socket cliente, ObjectOutputStream out, ObjectInputStream in) {
        initComponents();
        this.endereco = endereco;
        this.telefone = telefone;
        this.ddd = ddd;
        this.email = email;
        this.senha = senha;
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.cliente = cliente;
        this.in = in;
        this.out = out;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFRazaoSocial = new javax.swing.JTextField();
        jTFNomeFantasia = new javax.swing.JTextField();
        jBVoltar = new javax.swing.JButton();
        jBEnviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jFTFCNPJ = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Empresa");

        jTFRazaoSocial.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFRazaoSocial.setToolTipText("");

        jTFNomeFantasia.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFNomeFantasia.setToolTipText("");

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

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Razão social:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("CNPJ:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Nome fantasia:");

        try {
            jFTFCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCNPJ.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTFNomeFantasia, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFTFCNPJ))
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        CadastroGeral telaCadastroGeral = new CadastroGeral(alfabetosCriptografia, cliente, out, in);
        telaCadastroGeral.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        if (!jTFRazaoSocial.getText().equals("")) {
            if (!jFTFCNPJ.getText().equals("  .   .   /    -  ")) {
                if (!jTFNomeFantasia.getText().equals("")) {

                    try {
                        String razaoSocial = jTFRazaoSocial.getText();
                        String cnpjString = jFTFCNPJ.getText();
                        cnpjString = cnpjString.replace(".", "");
                        cnpjString = cnpjString.replace("/", "");
                        cnpjString = cnpjString.replace("-", "");
                        long cnpj = Long.parseLong(cnpjString);
                        String nomeFantasia = jTFNomeFantasia.getText();

                        Empresa minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, senha);

                        out.writeObject("cadastraEmpresa");
                        mensagemRecebida = (String) in.readObject();

                        if (mensagemRecebida.equals("Ok")) {
                            out.writeObject(minhaEmpresa);

                            mensagemRecebida = (String) in.readObject();
                            if (mensagemRecebida.equals("razaoSocialEmUso")) {
                                JOptionPane.showMessageDialog(rootPane, "A razão social informada já está cadastrada.");
                                jTFRazaoSocial.requestFocus();
                            } else if (mensagemRecebida.equals("razaoSocialOk")) {
                                int cod_usuario = (int) in.readObject();
                                String senhaCriptografada = criptografa(senha, cod_usuario);
                                out.writeObject(senhaCriptografada);
                                mensagemRecebida = (String) in.readObject();

                                switch (mensagemRecebida) {
                                    case "empresaCadastrada":
                                        int cod_empresa = (int) in.readObject();
                                        minhaEmpresa.setID(cod_empresa);

                                        EmpresaVagasAbertas telaEmpresa = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                                        telaEmpresa.setVisible(true);
                                        this.dispose();

                                        break;
                                    case "cnpjEmUso":
                                        JOptionPane.showMessageDialog(rootPane, "O CNPJ informado já está cadastrado.");
                                        jFTFCNPJ.requestFocus();
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(CadastroEmpresa.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe o nome fantasia!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe o CNPJ!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe a razão social!");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    public String criptografa(String senhaOriginal, int codigoUsuario) {
        String senhaCriptografada = "";
        int chave = codigoUsuario + senhaOriginal.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {
            //String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";

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
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JFormattedTextField jFTFCNPJ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFNomeFantasia;
    private javax.swing.JTextField jTFRazaoSocial;
    // End of variables declaration//GEN-END:variables
}
