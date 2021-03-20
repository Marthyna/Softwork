package cliente;

import classesDominio.Aplicacao;
import classesDominio.Empresa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmpresaDetalharAplicacao extends javax.swing.JFrame {

    Empresa minhaEmpresa;
    Aplicacao minhaApp;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    public EmpresaDetalharAplicacao(Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, Aplicacao minhaApp) {
        initComponents();
        this.minhaEmpresa = minhaEmpresa;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.minhaApp = minhaApp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNomeAluno = new javax.swing.JLabel();
        jLCidade = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLCurso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLAno = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jLIdioma2 = new javax.swing.JLabel();
        jLIdioma3 = new javax.swing.JLabel();
        jLIdioma1 = new javax.swing.JLabel();
        jLFormacao2 = new javax.swing.JLabel();
        jLFormacao3 = new javax.swing.JLabel();
        jLFormacao1 = new javax.swing.JLabel();
        jLCurso1 = new javax.swing.JLabel();
        jLCurso2 = new javax.swing.JLabel();
        jLCurso3 = new javax.swing.JLabel();
        jLEmprego2 = new javax.swing.JLabel();
        jLEmprego1 = new javax.swing.JLabel();
        jLEmprego3 = new javax.swing.JLabel();
        jBAceitar = new javax.swing.JButton();
        jBRecusar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLNomeAluno.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLNomeAluno.setText("Nome do aluno");

        jLCidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLCidade.setText("Cidade");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Curso:");

        jLCurso.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLCurso.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Ano:");

        jLAno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLAno.setText("jLabel4");

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Currículo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 0, 14))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel12.setText("Emprego 2:");

        jLabel13.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel13.setText("Curso 3:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel4.setText("Idioma 1:");

        jLabel14.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel14.setText("Emprego 3:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel6.setText("Formação 1:");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel7.setText("Formação 2:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel8.setText("Idioma 2:");

        jLabel9.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel9.setText("Idioma 3:");

        jLabel10.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel10.setText("Formação 3:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel5.setText("Curso 1:");

        jLabel11.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel11.setText("Emprego 1:");

        jLabel15.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel15.setText("Curso 2:");

        jLabel16.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel16.setText("Descrição:");

        jLDescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLDescricao.setText("Descrição:");

        jLIdioma2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLIdioma2.setText("Idioma 2:");

        jLIdioma3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLIdioma3.setText("Idioma 3:");

        jLIdioma1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLIdioma1.setText("Idioma 1:");

        jLFormacao2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLFormacao2.setText("Formação 2:");

        jLFormacao3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLFormacao3.setText("Formação 3:");

        jLFormacao1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLFormacao1.setText("Formação 1:");

        jLCurso1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLCurso1.setText("Curso 1:");

        jLCurso2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLCurso2.setText("Curso 2:");

        jLCurso3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLCurso3.setText("Curso 3:");

        jLEmprego2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEmprego2.setText("Emprego 2:");

        jLEmprego1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEmprego1.setText("Emprego 1:");

        jLEmprego3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEmprego3.setText("Emprego 3:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLIdioma1, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLIdioma3)
                                            .addComponent(jLIdioma2))
                                        .addGap(96, 96, 96))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLCurso1)
                                            .addComponent(jLCurso2)
                                            .addComponent(jLCurso3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel6))
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(158, 158, 158)
                                .addComponent(jLabel7)))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLFormacao3)
                            .addComponent(jLFormacao1)
                            .addComponent(jLFormacao2)
                            .addComponent(jLEmprego3)
                            .addComponent(jLEmprego1)
                            .addComponent(jLEmprego2)))
                    .addComponent(jLDescricao))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLFormacao1)
                        .addGap(18, 18, 18)
                        .addComponent(jLFormacao2)
                        .addGap(18, 18, 18)
                        .addComponent(jLFormacao3)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEmprego1)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEmprego2)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLEmprego3)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLIdioma1)
                                .addGap(18, 18, 18)
                                .addComponent(jLIdioma2)
                                .addGap(18, 18, 18)
                                .addComponent(jLIdioma3)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLCurso1)
                                .addGap(18, 18, 18)
                                .addComponent(jLCurso2)
                                .addGap(18, 18, 18)
                                .addComponent(jLCurso3)))))
                .addGap(30, 30, 30))
        );

        jBAceitar.setBackground(new java.awt.Color(255, 255, 255));
        jBAceitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aceitar_icon.png"))); // NOI18N
        jBAceitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAceitarActionPerformed(evt);
            }
        });

        jBRecusar.setBackground(new java.awt.Color(255, 255, 255));
        jBRecusar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recusar_icon.png"))); // NOI18N
        jBRecusar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRecusarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel17.setText("Telefone:");

        jLTelefone.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLTelefone.setText("jLabel4");

        jLabel18.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel18.setText("E-mail:");

        jLEmail.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEmail.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLCurso)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLAno)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLTelefone)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLEmail)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLCidade)
                                    .addComponent(jLNomeAluno))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAceitar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBRecusar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLNomeAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLCidade))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jBAceitar)
                        .addComponent(jBRecusar)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jLEmail))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLTelefone))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLCurso)
                        .addComponent(jLabel3)
                        .addComponent(jLAno)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        jLNomeAluno.setText(minhaApp.getAluno().getNomeCompleto());
        jLCidade.setText(minhaApp.getAluno().getEndereco().getCidade());
        jLCurso.setText(minhaApp.getAluno().getCurso());
        jLAno.setText(minhaApp.getAluno().getAno() + "º ano");
        jLTelefone.setText("(" + minhaApp.getAluno().getDdd() + ") " + minhaApp.getAluno().getTelefone());
        jLEmail.setText(minhaApp.getAluno().getEmail());

        jLDescricao.setText(minhaApp.getAluno().getCurriculo().getDescricao());
        jLCurso1.setText(minhaApp.getAluno().getCurriculo().getCurso1());
        jLCurso2.setText(minhaApp.getAluno().getCurriculo().getCurso2());
        jLCurso3.setText(minhaApp.getAluno().getCurriculo().getCurso3());
        jLFormacao1.setText(minhaApp.getAluno().getCurriculo().getFormacao1());
        jLFormacao2.setText(minhaApp.getAluno().getCurriculo().getFormacao2());
        jLFormacao3.setText(minhaApp.getAluno().getCurriculo().getFormacao3());
        jLIdioma1.setText(minhaApp.getAluno().getCurriculo().getIdioma1());
        jLIdioma2.setText(minhaApp.getAluno().getCurriculo().getIdioma2());
        jLIdioma3.setText(minhaApp.getAluno().getCurriculo().getIdioma3());
        jLEmprego1.setText(minhaApp.getAluno().getCurriculo().getEmprego1());
        jLEmprego2.setText(minhaApp.getAluno().getCurriculo().getEmprego2());
        jLEmprego3.setText(minhaApp.getAluno().getCurriculo().getEmprego3());

    }//GEN-LAST:event_formWindowOpened

    private void jBAceitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAceitarActionPerformed
        try {
            out.writeObject("aceitarAplicacao");

            mensagemRecebida = (String) in.readObject();

            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(minhaApp);

                mensagemRecebida = (String) in.readObject();

                if (mensagemRecebida.equals("aplicacaoAceita")) {
                    JOptionPane.showMessageDialog(rootPane, "Aplicação aceita!");
                    EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                    telaRecebidos.setVisible(true);
                    this.dispose();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDetalharAplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBAceitarActionPerformed

    private void jBRecusarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRecusarActionPerformed
        try {
            out.writeObject("recusarAplicacao");

            mensagemRecebida = (String) in.readObject();

            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(minhaApp);

                mensagemRecebida = (String) in.readObject();

                if (mensagemRecebida.equals("aplicacaoRecusada")) {
                    JOptionPane.showMessageDialog(rootPane, "Aplicação recusada!");
                    EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                    telaRecebidos.setVisible(true);
                    this.dispose();
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(EmpresaDetalharAplicacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBRecusarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecebidos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAceitar;
    private javax.swing.JButton jBRecusar;
    private javax.swing.JLabel jLAno;
    private javax.swing.JLabel jLCidade;
    private javax.swing.JLabel jLCurso;
    private javax.swing.JLabel jLCurso1;
    private javax.swing.JLabel jLCurso2;
    private javax.swing.JLabel jLCurso3;
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLEmprego1;
    private javax.swing.JLabel jLEmprego2;
    private javax.swing.JLabel jLEmprego3;
    private javax.swing.JLabel jLFormacao1;
    private javax.swing.JLabel jLFormacao2;
    private javax.swing.JLabel jLFormacao3;
    private javax.swing.JLabel jLIdioma1;
    private javax.swing.JLabel jLIdioma2;
    private javax.swing.JLabel jLIdioma3;
    private javax.swing.JLabel jLNomeAluno;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
