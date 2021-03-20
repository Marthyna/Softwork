package cliente;

import classesDominio.Empresa;
import classesDominio.Vaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmpresaCadastrarVaga extends javax.swing.JFrame {

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    public EmpresaCadastrarVaga(Empresa minhaEmpresa, Socket cliente,
            ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFNomeVaga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jCBTurno = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jTFSetor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jRBSim = new javax.swing.JRadioButton();
        jRBNao = new javax.swing.JRadioButton();
        jLSalario = new javax.swing.JLabel();
        jTFSalario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        jLabel1.setText("Cadastrar vaga:");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Título da vaga:");

        jTFNomeVaga.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Turno:");

        jCBTurno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCBTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "Manhã", "Tarde", "Noite" }));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Setor:");

        jTFSetor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Remunerada:");

        jRBSim.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBSim.setText("Sim");
        jRBSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBSimActionPerformed(evt);
            }
        });

        jRBNao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jRBNao.setText("Não");
        jRBNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNaoActionPerformed(evt);
            }
        });

        jLSalario.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSalario.setText("R$");
        jLSalario.setEnabled(false);

        jTFSalario.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFSalario.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jButton1.setText("Salvar");
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
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addComponent(jTFNomeVaga)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jRBSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRBNao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addComponent(jLSalario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFNomeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTFSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jRBSim)
                    .addComponent(jRBNao)
                    .addComponent(jLSalario))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTFNomeVaga.getText().equals("")) {
            if (!jTADescricao.getText().equals("")) {
                if (jCBTurno.getSelectedIndex() != 0) {
                    if (!jTFSetor.getText().equals("")) {
                        if (jRBNao.isSelected() || jRBSim.isSelected()) {

                            String nome = jTFNomeVaga.getText();
                            String setor = jTFSetor.getText();
                            String descricao = jTADescricao.getText();
                            boolean preenchida = false;
                            int turno = jCBTurno.getSelectedIndex();
                            LocalDate dataPublicacao = LocalDate.now();

                            Vaga minhaVaga = null;

                            if (jRBSim.isSelected()) {
                                if (!jTFSalario.getText().equals("")) {
                                    boolean remunerada = true;
                                    float salario = Float.parseFloat(jTFSalario.getText());

                                    minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                    minhaVaga.setSalario(salario);
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Informe o salário da vaga.");
                                }
                            } else {
                                boolean remunerada = false;

                                minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, dataPublicacao, 0, minhaEmpresa);
                                minhaVaga.setSalario(0);
                                minhaVaga.setTurnoLiteral();
                            }

                            minhaVaga.setTurnoLiteral();
                            try {
                                out.writeObject("cadastraVaga");

                                mensagemRecebida = (String) in.readObject();

                                if (mensagemRecebida.equals("Ok")) {
                                    out.writeObject(minhaVaga);
                                    out.writeObject(minhaEmpresa);

                                    mensagemRecebida = (String) in.readObject();

                                    switch (mensagemRecebida) {
                                        case "vagaJaCadastrada":
                                            JOptionPane.showMessageDialog(rootPane, "A vaga informada já está cadastrada.");
                                            break;
                                        case "vagaCadastrada":
                                            int cod_vaga = (int) in.readObject();
                                            minhaVaga.setID(cod_vaga);

                                            JOptionPane.showMessageDialog(rootPane, "Vaga cadastrada com sucesso.");
                                            EmpresaVagasAbertas telaVagasAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                                            telaVagasAbertas.setVisible(true);
                                            this.dispose();
                                    }

                                }
                            } catch (IOException | ClassNotFoundException ex) {
                                Logger.getLogger(EmpresaCadastrarVaga.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Informe se a vaga é remunerada ou não.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Informe o setor da vaga.");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe o turno da vaga.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe a descrição da vaga.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o título da vaga.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRBSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBSimActionPerformed
        jLSalario.setEnabled(true);
        jTFSalario.setEnabled(true);
        jRBNao.setSelected(false);
    }//GEN-LAST:event_jRBSimActionPerformed

    private void jRBNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNaoActionPerformed
        jRBSim.setSelected(false);
        jLSalario.setEnabled(false);
        jTFSalario.setEnabled(false);
    }//GEN-LAST:event_jRBNaoActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        EmpresaVagasAbertas telaVagasAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaVagasAbertas.setVisible(true);
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCBTurno;
    private javax.swing.JLabel jLSalario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRBNao;
    private javax.swing.JRadioButton jRBSim;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFNomeVaga;
    private javax.swing.JTextField jTFSalario;
    private javax.swing.JTextField jTFSetor;
    // End of variables declaration//GEN-END:variables
}
