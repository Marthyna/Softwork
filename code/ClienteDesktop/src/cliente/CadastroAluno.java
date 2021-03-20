package cliente;

import classesDominio.Aluno;
import classesDominio.Endereco;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class CadastroAluno extends javax.swing.JFrame {

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

    public CadastroAluno(Endereco endereco, int telefone, int ddd, String email, String senha, String[] alfabetosCriptografia, Socket cliente, ObjectOutputStream out, ObjectInputStream in) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTFNomeCompleto = new javax.swing.JTextField();
        jTFRG = new javax.swing.JTextField();
        jFTFDataNasc = new javax.swing.JFormattedTextField();
        jRBFeminino = new javax.swing.JRadioButton();
        jRBMasculino = new javax.swing.JRadioButton();
        jTFMatricula = new javax.swing.JTextField();
        jCBAno = new javax.swing.JComboBox<>();
        jCBTurno = new javax.swing.JComboBox<>();
        jCBCurso = new javax.swing.JComboBox<>();
        jBVoltar = new javax.swing.JButton();
        jBEnviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jFTFCPF = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLabel1.setText("Cadastrar Aluno");

        jTFNomeCompleto.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTFNomeCompleto.setToolTipText("");

        jTFRG.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTFRG.setToolTipText("");

        try {
            jFTFDataNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFDataNasc.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jFTFDataNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFDataNascActionPerformed(evt);
            }
        });

        jRBFeminino.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jRBFeminino.setText("Feminino");

        jRBMasculino.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jRBMasculino.setText("Masculino");

        jTFMatricula.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jTFMatricula.setToolTipText("");

        jCBAno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCBAno.setForeground(new java.awt.Color(102, 102, 102));
        jCBAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o ano", "1", "2", "3", "4" }));

        jCBTurno.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCBTurno.setForeground(new java.awt.Color(102, 102, 102));
        jCBTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o turno", "Manhã", "Tarde", "Noite" }));

        jCBCurso.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jCBCurso.setForeground(new java.awt.Color(102, 102, 102));
        jCBCurso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o curso", "Técnico em Informática", "Técnico em Refrigeração e Climatização", "Técnico em Eletromecânica", "Técnico em Secretariado" }));

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
        jLabel2.setText("Nome completo:");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("CPF:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("RG:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Data de nascimento:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Sexo:");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Matrícula:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Ano:");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("Turno:");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Curso:");

        try {
            jFTFCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTFCPF.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jFTFCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFTFCPFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBAno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFNomeCompleto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jFTFCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFRG, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRBFeminino)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRBMasculino))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBCurso, 0, 1, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFRG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jFTFCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTFDataNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jRBFeminino)
                    .addComponent(jRBMasculino)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jCBAno, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jCBCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        if (!jTFNomeCompleto.getText().equals("")) {
            if (jFTFCPF.getText().isEmpty() == false) {
                if (!jTFRG.getText().equals("")) {
                    if (jFTFDataNasc.getText().isEmpty() == false) {
                        if (jRBFeminino.isSelected() || jRBMasculino.isSelected()) {
                            if (!jTFMatricula.getText().equals("")) {
                                if (jCBAno.getSelectedIndex() != 0) {
                                    if (jCBTurno.getSelectedIndex() != 0) {
                                        if (jCBCurso.getSelectedIndex() != 0) {

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

                                            Aluno meuAluno = new Aluno(matricula, ano, curso, turno, nomeCompleto, sexo, cpf, rg, dataNascimento, endereco, telefone, ddd, email, senha);
                                            meuAluno.setSexoLiteral();
                                            meuAluno.setTurnoLiteral();

                                            CadastraCurriculo telaCadastraCurriculo = new CadastraCurriculo(cliente, out, in, alfabetosCriptografia, meuAluno);
                                            telaCadastraCurriculo.setVisible(true);
                                            this.dispose();

                                        } else {
                                            JOptionPane.showMessageDialog(rootPane, "Informe o curso!");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(rootPane, "Informe o turno!");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Informe o ano!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Informe a matrícula!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Informe o sexo!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Informe a data de nascimento!");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe o RG!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe o CPF!");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome completo!");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private void jBVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVoltarActionPerformed
        CadastroGeral telaCadastroGeral = new CadastroGeral(alfabetosCriptografia, cliente, out, in);
        telaCadastroGeral.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBVoltarActionPerformed

    private void jFTFDataNascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFDataNascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFDataNascActionPerformed

    private void jFTFCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFTFCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFTFCPFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBEnviar;
    private javax.swing.JButton jBVoltar;
    private javax.swing.JComboBox<String> jCBAno;
    private javax.swing.JComboBox<String> jCBCurso;
    private javax.swing.JComboBox<String> jCBTurno;
    private javax.swing.JFormattedTextField jFTFCPF;
    private javax.swing.JFormattedTextField jFTFDataNasc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRBFeminino;
    private javax.swing.JRadioButton jRBMasculino;
    private javax.swing.JTextField jTFMatricula;
    private javax.swing.JTextField jTFNomeCompleto;
    private javax.swing.JTextField jTFRG;
    // End of variables declaration//GEN-END:variables
}
