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

public class EmpresaVagaDetalhar extends javax.swing.JFrame {

    Vaga vaga;

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String[] alfabetosCriptografia;

    String mensagemRecebida = "";
    String parentescoTela;

    public EmpresaVagaDetalhar(Vaga vaga, Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia, String parentescoTela) {
        initComponents();
        this.vaga = vaga;
        this.minhaEmpresa = minhaEmpresa;
        this.cliente = cliente;
        this.in = in;
        this.out = out;
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.parentescoTela = parentescoTela;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jBEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLNomeEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFNomeVaga = new javax.swing.JTextField();
        jCBTurno = new javax.swing.JComboBox<>();
        jTFSetor = new javax.swing.JTextField();
        jLEndereco = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jRBRemunerada = new javax.swing.JRadioButton();
        jRBNaoRemunerada = new javax.swing.JRadioButton();
        jLSalario = new javax.swing.JLabel();
        jTFSalario = new javax.swing.JTextField();
        jLLocalidade = new javax.swing.JLabel();

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

        jBEditar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBEditar.setText("Editar");
        jBEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Descrição:");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Turno:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Setor:");

        jLNomeEmpresa.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLNomeEmpresa.setText("Nome da empresa");

        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Empresa:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Telefone:");

        jTFNomeVaga.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N

        jCBTurno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jCBTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção", "Manhã", "Tarde", "Noite" }));

        jTFSetor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLEndereco.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEndereco.setText("Endereço");

        jLTelefone.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLTelefone.setText("Telefone");

        jRBRemunerada.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jRBRemunerada.setText("Remunerada");
        jRBRemunerada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBRemuneradaActionPerformed(evt);
            }
        });

        jRBNaoRemunerada.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jRBNaoRemunerada.setText("Não remunerada");
        jRBNaoRemunerada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBNaoRemuneradaActionPerformed(evt);
            }
        });

        jLSalario.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSalario.setText("Salário:");

        jTFSalario.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLLocalidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLLocalidade.setText("Localidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLTelefone)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLEndereco)
                            .addComponent(jLNomeEmpresa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLSalario)
                            .addComponent(jLabel7))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTFNomeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(140, 140, 140))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRBRemunerada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBNaoRemunerada)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLLocalidade)
                        .addGap(188, 188, 188))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jTFNomeVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLLocalidade)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBRemunerada)
                    .addComponent(jRBNaoRemunerada))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLNomeEmpresa))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLEndereco))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLTelefone))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCBTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLSalario)
                    .addComponent(jTFSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jBEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarActionPerformed
        if (!jTFNomeVaga.getText().equals("")) {
            if (jRBRemunerada.isSelected() || jRBNaoRemunerada.isSelected()) {
                if (!jTADescricao.getText().equals("")) {
                    if (jCBTurno.getSelectedIndex() != 0) {
                        if (!jTFSetor.getText().equals("")) {
                            String nome = jTFNomeVaga.getText();
                            String setor = jTFSetor.getText();
                            String descricao = jTADescricao.getText();
                            boolean preenchida = false;
                            int turno = jCBTurno.getSelectedIndex();
                            LocalDate data = LocalDate.now();
                            boolean remunerada = false;
                            float salario = 0;
                            int cod_vaga = vaga.getID();

                            if (jRBRemunerada.isSelected()) {
                                if (!jTFSalario.getText().equals("")) {
                                    remunerada = true;
                                    salario = Float.parseFloat(jTFSalario.getText());
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Informe o salário.");
                                }
                            }

                            Vaga minhaVaga = new Vaga(nome, setor, remunerada, descricao, preenchida, turno, data, 0, minhaEmpresa);
                            minhaVaga.setTurnoLiteral();
                            minhaVaga.setSalario(salario);
                            minhaVaga.setID(cod_vaga);

                            try {
                                out.writeObject("editarVaga");

                                mensagemRecebida = (String) in.readObject();

                                if (mensagemRecebida.equals("Ok")) {
                                    out.writeObject(minhaVaga);

                                    mensagemRecebida = (String) in.readObject();

                                    if (mensagemRecebida.equals("vagaEditada")) {
                                        JOptionPane.showMessageDialog(rootPane, "Vaga editada com sucesso!");

                                        if (parentescoTela.equals("vagasAbertas")) {
                                            EmpresaVagasAbertas telaVagasAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                                            telaVagasAbertas.setVisible(true);
                                        } else if (parentescoTela.equals("historico")) {
                                            EmpresaHistorico telaHistorico = new EmpresaHistorico(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
                                            telaHistorico.setVisible(true);
                                        }

                                        this.dispose();
                                    }
                                }
                            } catch (IOException | ClassNotFoundException ex) {
                                Logger.getLogger(EmpresaVagaDetalhar.class.getName()).log(Level.SEVERE, null, ex);
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
                JOptionPane.showMessageDialog(rootPane, "Selecione uma opção de remuneração.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o nome da vaga.");
        }
    }//GEN-LAST:event_jBEditarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jTFNomeVaga.setText(vaga.getNome());
        jLLocalidade.setText(minhaEmpresa.getEndereco().getCidade());

        boolean remunerada = vaga.isRemunerada();
        if (remunerada) {
            jRBRemunerada.setSelected(true);
            jRBNaoRemunerada.setSelected(false);
            jLSalario.setEnabled(true);
            jTFSalario.setEnabled(true);
        } else {
            jRBNaoRemunerada.setSelected(true);
            jRBRemunerada.setSelected(false);
            jLSalario.setEnabled(false);
            jTFSalario.setEnabled(false);
        }

        jLNomeEmpresa.setText(minhaEmpresa.getNomeFantasia());
        jLEndereco.setText(minhaEmpresa.getEndereco().getRua() + ", nº " + minhaEmpresa.getEndereco().getNumero() + " - Bairro " + minhaEmpresa.getEndereco().getBairro() + " - Complemento: " + minhaEmpresa.getEndereco().getComplemento() + " - " + minhaEmpresa.getEndereco().getCidade());
        jLTelefone.setText("(" + String.valueOf(minhaEmpresa.getDdd()) + ") - " + String.valueOf(minhaEmpresa.getTelefone()));

        jTADescricao.setText(vaga.getDescricao());
        jCBTurno.setSelectedIndex(vaga.getTurno());
        jTFSetor.setText(vaga.getSetor());

        if (vaga.isRemunerada()) {
            jTFSalario.setText(String.valueOf(vaga.getSalario()));
        }

    }//GEN-LAST:event_formWindowOpened

    private void jRBRemuneradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBRemuneradaActionPerformed
        jLSalario.setEnabled(true);
        jTFSalario.setEnabled(true);
        jRBNaoRemunerada.setSelected(false);
    }//GEN-LAST:event_jRBRemuneradaActionPerformed

    private void jRBNaoRemuneradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBNaoRemuneradaActionPerformed
        jLSalario.setEnabled(false);
        jTFSalario.setEnabled(false);
        jRBRemunerada.setSelected(false);
    }//GEN-LAST:event_jRBNaoRemuneradaActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (parentescoTela.equals("vagasAbertas")) {
            EmpresaVagasAbertas telaVagasAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
            telaVagasAbertas.setVisible(true);
        } else if (parentescoTela.equals("historico")) {
            EmpresaHistorico telaHistorico = new EmpresaHistorico(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
            telaHistorico.setVisible(true);
        }
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBEditar;
    private javax.swing.JComboBox<String> jCBTurno;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLLocalidade;
    private javax.swing.JLabel jLNomeEmpresa;
    private javax.swing.JLabel jLSalario;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRBNaoRemunerada;
    private javax.swing.JRadioButton jRBRemunerada;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFNomeVaga;
    private javax.swing.JTextField jTFSalario;
    private javax.swing.JTextField jTFSetor;
    // End of variables declaration//GEN-END:variables
}
