package cliente;

import classesDominio.Aluno;
import classesDominio.Curriculo;
import classesDominio.Endereco;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlunoConta extends javax.swing.JFrame {

    Aluno meuAluno;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    public AlunoConta(Aluno meuAluno, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.meuAluno = meuAluno;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLBemVindo = new javax.swing.JLabel();
        jLConta = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLOfertas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLAceitos = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLRecusados = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLHistorico = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLMensagens = new javax.swing.JLabel();
        jLEmEspera = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLSair = new javax.swing.JLabel();
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
        jTFNomeCompleto = new javax.swing.JTextField();
        jTFRG = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jFTFDataNasc = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jRBFeminino = new javax.swing.JRadioButton();
        jRBMasculino = new javax.swing.JRadioButton();
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
        jLabel35 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jTFMatricula = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jCBAno = new javax.swing.JComboBox<>();
        jFTFCEP = new javax.swing.JFormattedTextField();
        jCBCurso = new javax.swing.JComboBox<>();
        jCBTurno = new javax.swing.JComboBox<>();
        jBSalvar = new javax.swing.JButton();
        jFTFCPF = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPFSenhaAtual = new javax.swing.JPasswordField();
        jPFNovaSenha = new javax.swing.JPasswordField();
        jPFConfirmaSenha = new javax.swing.JPasswordField();
        jBEnviarSenha = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jTFEmprego2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLabel45 = new javax.swing.JLabel();
        jTFCurso3 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jTFIdioma1 = new javax.swing.JTextField();
        jTFEmprego3 = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        jTFFormacao1 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jTFFormacao2 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTFIdioma2 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jTFIdioma3 = new javax.swing.JTextField();
        jTFFormacao3 = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTFCurso1 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTFEmprego1 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jTFCurso2 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();

        fileChooser.setDialogTitle("Esta é minha caixa de diálogo aberta");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_icon.jpg"))); // NOI18N

        jLBemVindo.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLBemVindo.setText("Bem vindo, usuário!");

        jLConta.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLConta.setText("Conta");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/conta.png"))); // NOI18N

        jLOfertas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLOfertas.setText("Ofertas");
        jLOfertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLOfertasMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ofertas.png"))); // NOI18N

        jLAceitos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLAceitos.setText("Aceitos");
        jLAceitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAceitosMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aceito.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recusado.png"))); // NOI18N

        jLRecusados.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLRecusados.setText("Recusados");
        jLRecusados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLRecusadosMouseClicked(evt);
            }
        });

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/emEspera.png"))); // NOI18N

        jLHistorico.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLHistorico.setText("Histórico");
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

        jLEmEspera.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLEmEspera.setText("Em espera");
        jLEmEspera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLEmEsperaMouseClicked(evt);
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
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(55, 55, 55))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLHistorico)
                            .addComponent(jLEmEspera)
                            .addComponent(jLRecusados)
                            .addComponent(jLAceitos)
                            .addComponent(jLOfertas)
                            .addComponent(jLConta)
                            .addComponent(jLMensagens))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSair)
                            .addComponent(jLBemVindo))
                        .addGap(22, 22, 22))))
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
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLConta))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLOfertas))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLAceitos))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLRecusados))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addComponent(jLEmEspera))
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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 2000));

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
        jLabel33.setText("Dados Pessoais");

        jTFNomeCompleto.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFRG.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Nome completo:");

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel13.setText("RG:");

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel14.setText("CPF:");

        jLabel15.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel15.setText("Data de nascimento:");

        try {
            jFTFDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFDataNasc.setText("");
        jFTFDataNasc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jFTFDataNasc.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel16.setText("Sexo:");

        jRBFeminino.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBFeminino.setText("Feminino");

        jRBMasculino.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBMasculino.setText("Masculino");

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

        jLabel35.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel35.setText("Dados escolares");

        jTFMatricula.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel25.setText("Matrícula:");

        jLabel26.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel26.setText("Curso:");

        jLabel27.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel27.setText("Currículo:");

        jLabel28.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel28.setText("Ano:");

        jLabel29.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel29.setText("Turno:");

        jCBAno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCBAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o ano", "1º", "2º", "3º", "4º" }));
        jCBAno.setPreferredSize(new java.awt.Dimension(56, 31));

        try {
            jFTFCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCEP.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jCBCurso.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCBCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o curso", "Técnico em Informática", "Técnico em Refrigeração e Climatização", "Técnico em Eletromecânica", "Técnico em Secretariado" }));
        jCBCurso.setPreferredSize(new java.awt.Dimension(56, 31));

        jCBTurno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCBTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o turno", "Manhã", "Tarde", "Noite" }));
        jCBTurno.setPreferredSize(new java.awt.Dimension(56, 31));

        jBSalvar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jBSalvar.setText("Salvar");
        jBSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarActionPerformed(evt);
            }
        });

        try {
            jFTFCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCPF.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

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

        jLabel44.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel44.setText("Emprego 2:");

        jTFEmprego2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescricao.setRows(5);
        jScrollPane3.setViewportView(jTADescricao);

        jLabel45.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel45.setText("Curso 3:");

        jTFCurso3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel46.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel46.setText("Idioma 1:");

        jLabel47.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel47.setText("Emprego 3:");

        jTFIdioma1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFEmprego3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel48.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel48.setText("Formação 1:");

        jTFFormacao1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel49.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel49.setText("Formação 2:");

        jTFFormacao2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel50.setText("Idioma 2:");

        jTFIdioma2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel51.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel51.setText("Idioma 3:");

        jTFIdioma3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFFormacao3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel52.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel52.setText("Formação 3:");

        jLabel53.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel53.setText("Curso 1:");

        jTFCurso1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel54.setText("Emprego 1:");

        jTFEmprego1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel55.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel55.setText("Curso 2:");

        jTFCurso2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel56.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel56.setText("Descrição:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTFRG)
                                    .addComponent(jFTFCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                    .addComponent(jTFNomeCompleto)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFTFTelefone))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel16)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRBFeminino)
                                        .addGap(10, 10, 10)
                                        .addComponent(jRBMasculino))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel35))
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
                                .addComponent(jTFCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jBEnviarSenha))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel56)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel46)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel48)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFFormacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel50)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel49)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTFFormacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel51)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel53)
                                                .addComponent(jLabel55)
                                                .addComponent(jLabel45))
                                            .addGap(16, 16, 16)))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTFCurso1)
                                        .addComponent(jTFIdioma3)
                                        .addComponent(jTFCurso2)
                                        .addComponent(jTFCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel52)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFFormacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel54)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFEmprego1))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel44)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFEmprego2))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel47)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTFEmprego3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel28)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCBAno, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jCBCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel29)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jCBTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(160, 160, 160))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTFNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTFRG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jFTFCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jRBFeminino)
                            .addComponent(jRBMasculino))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel18)
                        .addComponent(jFTFTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(52, 52, 52)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jCBAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel29)
                    .addComponent(jCBCurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jTFIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48)
                    .addComponent(jTFFormacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(jTFIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49)
                    .addComponent(jTFFormacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTFIdioma3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52)
                    .addComponent(jTFFormacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTFCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54)
                    .addComponent(jTFEmprego1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(jTFCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44)
                    .addComponent(jTFEmprego2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jTFCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47)
                    .addComponent(jTFEmprego3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jBSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 999, Short.MAX_VALUE)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 999, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 999, Short.MAX_VALUE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 999, Short.MAX_VALUE)))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String[] nome = meuAluno.getNomeCompleto().split(" ");
        String nomeString = nome[0];
        if (meuAluno.getSexo() == 1) {
            jLBemVindo.setText("Bem vinda, " + nomeString + "!");
        } else {
            jLBemVindo.setText("Bem vindo, " + nomeString + "!");
        }

        jTFEmail.setText(meuAluno.getEmail());

        jTFNomeCompleto.setText(meuAluno.getNomeCompleto());
        jTFRG.setText(String.valueOf(meuAluno.getRg()));
        jFTFCPF.setText(String.valueOf(meuAluno.getCpf()));

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataNascimento = meuAluno.getDataNascimento().format(formato);
        jFTFDataNasc.setText(String.valueOf(dataNascimento));
        int sexo = meuAluno.getSexo();
        if (sexo == 1) {
            jRBFeminino.setSelected(true);
        } else if (sexo == 2) {
            jRBMasculino.setSelected(true);
        }
        jTFDDD.setText(String.valueOf(meuAluno.getDdd()));
        jFTFTelefone.setText(String.valueOf(meuAluno.getTelefone()));

        jTFRua.setText(meuAluno.getEndereco().getRua());
        jTFNumero.setText(String.valueOf(meuAluno.getEndereco().getNumero()));
        jTFBairro.setText(meuAluno.getEndereco().getBairro());
        jFTFCEP.setText(String.valueOf(meuAluno.getEndereco().getCep()));
        jTFCidade.setText(meuAluno.getEndereco().getCidade());
        jTFComplemento.setText(meuAluno.getEndereco().getComplemento());

        jTFMatricula.setText(String.valueOf(meuAluno.getMatricula()));
        jCBAno.setSelectedIndex(meuAluno.getAno());
        jCBTurno.setSelectedIndex(meuAluno.getTurno());

        jTADescricao.setText(meuAluno.getCurriculo().getDescricao());
        jTFIdioma1.setText(meuAluno.getCurriculo().getIdioma1());
        jTFFormacao1.setText(meuAluno.getCurriculo().getFormacao1());
        if (!meuAluno.getCurriculo().getIdioma2().equals("")) {
            jTFIdioma2.setEnabled(true);
            jTFIdioma2.setText(meuAluno.getCurriculo().getIdioma2());
        }
        if (!meuAluno.getCurriculo().getIdioma3().equals("")) {
            jTFIdioma3.setEnabled(true);
            jTFIdioma3.setText(meuAluno.getCurriculo().getIdioma3());
        }
        if (!meuAluno.getCurriculo().getFormacao2().equals("")) {
            jTFFormacao2.setEnabled(true);
            jTFFormacao2.setText(meuAluno.getCurriculo().getFormacao2());
        }
        if (!meuAluno.getCurriculo().getFormacao3().equals("")) {
            jTFFormacao3.setEnabled(true);
            jTFFormacao3.setText(meuAluno.getCurriculo().getFormacao3());
        }
        if (!meuAluno.getCurriculo().getCurso1().equals("")) {
            jTFCurso1.setEnabled(true);
            jTFCurso1.setText(meuAluno.getCurriculo().getCurso1());
        }
        if (!meuAluno.getCurriculo().getCurso2().equals("")) {
            jTFCurso2.setEnabled(true);
            jTFCurso2.setText(meuAluno.getCurriculo().getCurso2());
        }
        if (!meuAluno.getCurriculo().getCurso3().equals("")) {
            jTFCurso3.setEnabled(true);
            jTFCurso3.setText(meuAluno.getCurriculo().getCurso3());
        }
        if (!meuAluno.getCurriculo().getEmprego1().equals("")) {
            jTFEmprego1.setEnabled(true);
            jTFEmprego1.setText(meuAluno.getCurriculo().getEmprego1());
        }
        if (!meuAluno.getCurriculo().getEmprego2().equals("")) {
            jTFEmprego2.setEnabled(true);
            jTFEmprego2.setText(meuAluno.getCurriculo().getEmprego2());
        }
        if (!meuAluno.getCurriculo().getEmprego3().equals("")) {
            jTFEmprego3.setEnabled(true);
            jTFEmprego3.setText(meuAluno.getCurriculo().getEmprego3());
        }

    }//GEN-LAST:event_formWindowOpened

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

            String nomeCompleto = jTFNomeCompleto.getText();
            String cpfString = jFTFCPF.getText();
            cpfString = cpfString.replace(".", "");
            cpfString = cpfString.replace("-", "");
            long cpf = Long.parseLong(cpfString);
            long rg = Long.parseLong(jTFRG.getText());
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataNascimento = LocalDate.parse(jFTFDataNasc.getText(), formato);
            int sexo = 0;
            if (jRBFeminino.isSelected()) {
                sexo = 1;
            } else if (jRBMasculino.isSelected()) {
                sexo = 2;
            }
            long matricula = Long.parseLong(jTFMatricula.getText());
            int ano = jCBAno.getSelectedIndex();
            int turno = jCBTurno.getSelectedIndex();
            String curso = String.valueOf(jCBTurno.getSelectedItem());

            String descricao = jTADescricao.getText();
            String idioma1 = jTFIdioma1.getText();
            String formacao1 = jTFFormacao1.getText();

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
            
            if (!jTFIdioma2.getText().equals("")) {
                idioma2 = jTFIdioma2.getText();
                meuCurriculo.setIdioma2(idioma2);
            }
            if (!jTFIdioma3.getText().equals("")) {
                idioma3 = jTFIdioma3.getText();
                meuCurriculo.setIdioma3(idioma3);
            }

            if (!jTFFormacao2.getText().equals("")) {
                formacao2 = jTFFormacao2.getText();
                meuCurriculo.setFormacao2(formacao2);
            }
            if (!jTFFormacao3.getText().equals("")) {
                formacao3 = jTFFormacao3.getText();
                meuCurriculo.setFormacao3(formacao3);
            }

            if (!jTFCurso1.getText().equals("")) {
                curso1 = jTFCurso1.getText();
                meuCurriculo.setCurso1(curso1);
            }
            if (!jTFCurso2.getText().equals("")) {
                curso2 = jTFCurso2.getText();
                meuCurriculo.setCurso2(curso2);
            }
            if (!jTFCurso3.getText().equals("")) {
                curso3 = jTFCurso3.getText();
                meuCurriculo.setCurso3(curso3);
            }

            if (!jTFEmprego1.getText().equals("")) {
                emprego1 = jTFEmprego1.getText();
                meuCurriculo.setEmprego1(emprego1);
            }
            if (!jTFEmprego2.getText().equals("")) {
                emprego2 = jTFEmprego2.getText();
                meuCurriculo.setEmprego2(emprego2);
            }
            if (!jTFEmprego3.getText().equals("")) {
                emprego3 = jTFEmprego3.getText();
                meuCurriculo.setEmprego3(emprego3);
            }

            Endereco endereco = new Endereco(rua, numero, bairro, cidade, cep);
            Aluno aluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, rua);
            aluno.getEndereco().setComplemento(complemento);
            aluno.setCurriculo(meuCurriculo);
            aluno.setID(meuAluno.getID());

            out.writeObject("salvarDadosConta");
            mensagemRecebida = (String) in.readObject();
            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(aluno);

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("alunoAtualizado")) {
                    JOptionPane.showMessageDialog(rootPane, "As informações da conta foram atualizadas.");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                }
            }

        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoConta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBSalvarActionPerformed

    private void jBRedefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRedefinirSenhaActionPerformed
        jPFSenhaAtual.setEnabled(true);
        jPFNovaSenha.setEnabled(true);
        jPFConfirmaSenha.setEnabled(true);
        jBEnviarSenha.setEnabled(true);
    }//GEN-LAST:event_jBRedefinirSenhaActionPerformed

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
                            out.writeObject("aluno");
                            out.writeObject(meuAluno);
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
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Senha incorreta!");
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
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe a nova senha.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe a senha atual.");
        }
    }//GEN-LAST:event_jBEnviarSenhaActionPerformed

    private void jLOfertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLOfertasMouseClicked
        AlunoOfertas telaOfertas = new AlunoOfertas(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaOfertas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLOfertasMouseClicked

    private void jLAceitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAceitosMouseClicked
        AlunoAceitos telaAceitos = new AlunoAceitos(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaAceitos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAceitosMouseClicked

    private void jLRecusadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecusadosMouseClicked
        AlunoRecusados telaRecusados = new AlunoRecusados(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaRecusados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLRecusadosMouseClicked

    private void jLMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMensagensMouseClicked
        AlunoMensagens telaMensagens = new AlunoMensagens(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaMensagens.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLMensagensMouseClicked

    private void jLHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHistoricoMouseClicked
        AlunoHistorico telaHistorico = new AlunoHistorico(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaHistorico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLHistoricoMouseClicked

    private void jLEmEsperaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLEmEsperaMouseClicked
        AlunoEmEspera telaEmEspera = new AlunoEmEspera(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaEmEspera.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLEmEsperaMouseClicked

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton jBEnviarSenha;
    private javax.swing.JButton jBRedefinirSenha;
    private javax.swing.JButton jBSalvar;
    private javax.swing.JComboBox<String> jCBAno;
    private javax.swing.JComboBox<String> jCBCurso;
    private javax.swing.JComboBox<String> jCBTurno;
    private javax.swing.JFormattedTextField jFTFCEP;
    private javax.swing.JFormattedTextField jFTFCPF;
    private javax.swing.JFormattedTextField jFTFDataNasc;
    private javax.swing.JFormattedTextField jFTFTelefone;
    private javax.swing.JLabel jLAceitos;
    private javax.swing.JLabel jLBemVindo;
    private javax.swing.JLabel jLConta;
    private javax.swing.JLabel jLEmEspera;
    private javax.swing.JLabel jLHistorico;
    private javax.swing.JLabel jLMensagens;
    private javax.swing.JLabel jLOfertas;
    private javax.swing.JLabel jLRecusados;
    private javax.swing.JLabel jLSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFConfirmaSenha;
    private javax.swing.JPasswordField jPFNovaSenha;
    private javax.swing.JPasswordField jPFSenhaAtual;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRBFeminino;
    private javax.swing.JRadioButton jRBMasculino;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFBairro;
    private javax.swing.JTextField jTFCidade;
    private javax.swing.JTextField jTFComplemento;
    private javax.swing.JTextField jTFCurso1;
    private javax.swing.JTextField jTFCurso2;
    private javax.swing.JTextField jTFCurso3;
    private javax.swing.JTextField jTFDDD;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFEmprego1;
    private javax.swing.JTextField jTFEmprego2;
    private javax.swing.JTextField jTFEmprego3;
    private javax.swing.JTextField jTFFormacao1;
    private javax.swing.JTextField jTFFormacao2;
    private javax.swing.JTextField jTFFormacao3;
    private javax.swing.JTextField jTFIdioma1;
    private javax.swing.JTextField jTFIdioma2;
    private javax.swing.JTextField jTFIdioma3;
    private javax.swing.JTextField jTFMatricula;
    private javax.swing.JTextField jTFNomeCompleto;
    private javax.swing.JTextField jTFNumero;
    private javax.swing.JTextField jTFRG;
    private javax.swing.JTextField jTFRua;
    // End of variables declaration//GEN-END:variables
}
