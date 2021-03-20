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

public class EmpresaConta extends javax.swing.JFrame {

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    public EmpresaConta(Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.minhaEmpresa = minhaEmpresa;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel32 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jBRedefinirSenha = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jTFRazaoSocial = new javax.swing.JTextField();
        jTFNomeFantasia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTFDDD = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jFTFTelefone = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jTFRua = new javax.swing.JTextField();
        jTFBairro = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTFCidade = new javax.swing.JTextField();
        jTFNumero = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTFComplemento = new javax.swing.JTextField();
        jFTFCEP = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPFSenhaAtual = new javax.swing.JPasswordField();
        jPFNovaSenha = new javax.swing.JPasswordField();
        jPFConfirmaSenha = new javax.swing.JPasswordField();
        jBEnviarSenha = new javax.swing.JButton();
        jBSalvar = new javax.swing.JButton();
        jFTFCNPJ = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLBemVindo = new javax.swing.JLabel();
        jLConta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLVagasAbertas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLAplicacoesRecebidas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLAceitos = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLHistorico = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLMensagens = new javax.swing.JLabel();
        jLRecusados = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLSair = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 1200));

        jLabel32.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel32.setText("Minha Conta");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("E-mail:");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("Senha:");

        jTFEmail.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jBRedefinirSenha.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jBRedefinirSenha.setText("Redefinir senha");
        jBRedefinirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRedefinirSenhaActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel33.setText("Dados Empresariais");

        jTFRazaoSocial.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFNomeFantasia.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Razão social:");

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel13.setText("Nome fantasia:");

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel14.setText("CNPJ:");

        jLabel17.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel17.setText("DDD:");

        jTFDDD.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel18.setText("Telefone:");

        try {
            jFTFTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFTelefone.setText("");
        jFTFTelefone.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel34.setText("Endereço");

        jTFRua.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFBairro.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel19.setText("Rua:");

        jLabel20.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel20.setText("Bairro:");

        jLabel21.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel21.setText("Cidade:");

        jTFCidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFNumero.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel22.setText("Número:");

        jLabel23.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel23.setText("CEP:");

        jLabel24.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel24.setText("Complemento:");

        jTFComplemento.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        try {
            jFTFCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCEP.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLabel9.setText("Senha atual:");
        jLabel9.setEnabled(false);

        jLabel41.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLabel41.setText("Nova senha:");
        jLabel41.setEnabled(false);

        jLabel42.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLabel42.setText("Confirmar:");
        jLabel42.setEnabled(false);

        jPFSenhaAtual.setEnabled(false);

        jPFNovaSenha.setEnabled(false);

        jPFConfirmaSenha.setEnabled(false);

        jBEnviarSenha.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBEnviarSenha.setText("Enviar");
        jBEnviarSenha.setEnabled(false);
        jBEnviarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarSenhaActionPerformed(evt);
            }
        });

        jBSalvar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        try {
            jFTFCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCNPJ.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel32))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPFSenhaAtual))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPFNovaSenha))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel42)
                                .addGap(18, 18, 18)
                                .addComponent(jPFConfirmaSenha))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel13))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFNomeFantasia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                    .addComponent(jTFRazaoSocial)
                                    .addComponent(jFTFCNPJ)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jFTFCEP))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jBEnviarSenha)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jBRedefinirSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jPFSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jPFNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jPFConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jBEnviarSenha)
                .addGap(13, 13, 13)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jTFNomeFantasia, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTFRua, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(jTFNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTFBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jFTFCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 453, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 452, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 453, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 452, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_icon.jpg"))); // NOI18N

        jLBemVindo.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLBemVindo.setText("Bem vindo, usuário!");

        jLConta.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLConta.setText("Conta");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/conta.png"))); // NOI18N

        jLVagasAbertas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLVagasAbertas.setText("Vagas abertas");
        jLVagasAbertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVagasAbertasMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ofertas.png"))); // NOI18N

        jLAplicacoesRecebidas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLAplicacoesRecebidas.setText("Aplicações recebidas");
        jLAplicacoesRecebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAplicacoesRecebidasMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recebidos.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aceito.png"))); // NOI18N

        jLAceitos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLAceitos.setText("Aceitos");
        jLAceitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAceitosMouseClicked(evt);
            }
        });

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recusado.png"))); // NOI18N

        jLHistorico.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLHistorico.setText("Histórico de vagas");
        jLHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLHistoricoMouseClicked(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mensagens.png"))); // NOI18N

        jLMensagens.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLMensagens.setText("Mensagens");
        jLMensagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMensagensMouseClicked(evt);
            }
        });

        jLRecusados.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLRecusados.setText("Recusados");
        jLRecusados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLRecusadosMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/historico.png"))); // NOI18N

        jLSair.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSair.setText("Sair");
        jLSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLSairMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(65, 65, 65))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLBemVindo)
                            .addGap(31, 31, 31)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSair)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLMensagens)
                                    .addComponent(jLHistorico)
                                    .addComponent(jLRecusados)
                                    .addComponent(jLAceitos)
                                    .addComponent(jLAplicacoesRecebidas)
                                    .addComponent(jLVagasAbertas)
                                    .addComponent(jLConta))))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLSair)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLConta))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLVagasAbertas))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLAplicacoesRecebidas))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLAceitos))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel43))
                    .addComponent(jLRecusados))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLHistorico))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLMensagens))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(749, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLVagasAbertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVagasAbertasMouseClicked
        EmpresaVagasAbertas telaAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaAbertas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLVagasAbertasMouseClicked

    private void jLAplicacoesRecebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAplicacoesRecebidasMouseClicked
        EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecebidos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAplicacoesRecebidasMouseClicked

    private void jLAceitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAceitosMouseClicked
        EmpresaAceitos telaAceitos = new EmpresaAceitos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaAceitos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAceitosMouseClicked

    private void jLHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHistoricoMouseClicked
        EmpresaHistorico telaHistorico = new EmpresaHistorico(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaHistorico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLHistoricoMouseClicked

    private void jLMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMensagensMouseClicked
        EmpresaMensagens telaMensagens = new EmpresaMensagens(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaMensagens.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLMensagensMouseClicked

    private void jLRecusadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecusadosMouseClicked
        EmpresaRecusados telaRecusados = new EmpresaRecusados(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecusados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLRecusadosMouseClicked

    private void jBEnviarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarSenhaActionPerformed
        if (!jPFSenhaAtual.getText().equals("")) {
            if (!jPFNovaSenha.getText().equals("")) {
                if (!jPFConfirmaSenha.getText().equals("")) {
                    String senhaAtual = jPFSenhaAtual.getText();
                    String senhaNova = jPFNovaSenha.getText();
                    String confirmaSenha = jPFConfirmaSenha.getText();

                    try {
                        out.writeObject("redefineSenha");
                        mensagemRecebida = (String) in.readObject();

                        if (mensagemRecebida.equals("Ok")) {
                            out.writeObject("empresa");
                            out.writeObject(minhaEmpresa);
                            mensagemRecebida = (String) in.readObject();

                            if (mensagemRecebida.equals("emailValido")) {
                                int cod_pessoa = (int) in.readObject();

                                String senhaAtualCriptografada = criptografa(senhaAtual, cod_pessoa);
                                out.writeObject(senhaAtualCriptografada);
                                mensagemRecebida = (String) in.readObject();
                                if (mensagemRecebida.equals("senhaValida")) {

                                    if (senhaNova.equals(confirmaSenha)) {
                                        String senhaNovaCriptografada = criptografa(senhaNova, cod_pessoa);
                                        out.writeObject(senhaNovaCriptografada);
                                        mensagemRecebida = (String) in.readObject();
                                        if (mensagemRecebida.equals("senhaRedefinida")) {
                                            JOptionPane.showMessageDialog(rootPane, "Senha redefinida com sucesso!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "As senhas não correspondem!");
                                        jPFNovaSenha.requestFocus();
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Senha incorreta!");
                                    jPFSenhaAtual.requestFocus();
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                            }
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(AlunoConta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe a nova senha novamente.");
                    jPFConfirmaSenha.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe a nova senha.");
                jPFNovaSenha.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe a senha atual.");
            jPFSenhaAtual.requestFocus();
        }
    }//GEN-LAST:event_jBEnviarSenhaActionPerformed

    private void jBRedefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedefinirSenhaActionPerformed
        jPFSenhaAtual.setEnabled(true);
        jPFNovaSenha.setEnabled(true);
        jPFConfirmaSenha.setEnabled(true);
        jBEnviarSenha.setEnabled(true);
    }//GEN-LAST:event_jBRedefinirSenhaActionPerformed

    private void jBSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarActionPerformed
        try {

            String email = jTFEmail.getText();
            String telefoneString = jFTFTelefone.getText();
            telefoneString = telefoneString.replace("-", "");
            int telefone = Integer.parseInt(telefoneString);

            String rua = jTFRua.getText();
            int numero = Integer.parseInt(jTFNumero.getText());
            String bairro = jTFBairro.getText();
            String complemento = jTFComplemento.getText();
            String cidade = jTFCidade.getText();
            String cepString = jFTFCEP.getText();
            cepString = cepString.replace("-", "");
            int cep = Integer.parseInt(cepString);
            int ddd = Integer.parseInt(jTFDDD.getText());

            String razaoSocial = jTFRazaoSocial.getText();
            String cnpjString = jFTFTelefone.getText();
            cnpjString = cnpjString.replace(".", "");
            cnpjString = cnpjString.replace("/", "");
            cnpjString = cnpjString.replace("-", "");
            long cnpj = Long.parseLong(cnpjString);
            String nomeFantasia = jTFNomeFantasia.getText();

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
            minhaEmpresa = new Empresa(razaoSocial, nomeFantasia, cnpj, endereco, telefone, ddd, email, rua);
            minhaEmpresa.getEndereco().setComplemento(complemento);

            out.writeObject("salvarDadosContaEmpresa");
            mensagemRecebida = (String) in.readObject();
            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(minhaEmpresa);

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("empresaAtualizada")) {
                    JOptionPane.showMessageDialog(rootPane, "As informações da conta foram atualizadas.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String[] nome = minhaEmpresa.getNomeFantasia().split(" ");
        String nomeString = nome[0];

        jLBemVindo.setText("Bem vinda, " + nomeString + "!");

        jTFEmail.setText(minhaEmpresa.getEmail());

        jTFRazaoSocial.setText(minhaEmpresa.getRazaoSocial());
        jTFNomeFantasia.setText(minhaEmpresa.getNomeFantasia());
        jFTFCNPJ.setText(String.valueOf(minhaEmpresa.getCnpj()));

        jTFDDD.setText(String.valueOf(minhaEmpresa.getDdd()));
        jFTFTelefone.setText(String.valueOf(minhaEmpresa.getTelefone()));

        jTFRua.setText(minhaEmpresa.getEndereco().getRua());
        jTFNumero.setText(String.valueOf(minhaEmpresa.getEndereco().getNumero()));
        jTFBairro.setText(minhaEmpresa.getEndereco().getBairro());
        jFTFCEP.setText(String.valueOf(minhaEmpresa.getEndereco().getCep()));
        jTFCidade.setText(minhaEmpresa.getEndereco().getCidade());
        jTFComplemento.setText(minhaEmpresa.getEndereco().getComplemento());

    }//GEN-LAST:event_formWindowOpened

    private void jLSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLSairMouseClicked
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLSairMouseClicked

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
    private javax.swing.JButton jBEnviarSenha;
    private javax.swing.JButton jBRedefinirSenha;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JFormattedTextField jFTFCEP;
    private javax.swing.JFormattedTextField jFTFCNPJ;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JLabel jLAceitos;
    private javax.swing.JLabel jLAplicacoesRecebidas;
    private javax.swing.JLabel jLBemVindo;
    private javax.swing.JLabel jLConta;
    private javax.swing.JLabel jLHistorico;
    private javax.swing.JLabel jLMensagens;
    private javax.swing.JLabel jLRecusados;
    private javax.swing.JLabel jLSair;
    private javax.swing.JLabel jLVagasAbertas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFConfirmaSenha;
    private javax.swing.JPasswordField jPFNovaSenha;
    private javax.swing.JPasswordField jPFSenhaAtual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFDDD;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFNomeFantasia;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFRazaoSocial;
    private javax.swing.JTextField jTFRua;
    // End of variables declaration//GEN-END:variables
}
