package cliente;

import classesDominio.Aplicacao;
import classesDominio.Empresa;
import classesDominio.Mensagem;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class EmpresaEnviaMensagem extends javax.swing.JFrame {

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    Aplicacao minhaApp;

    public EmpresaEnviaMensagem(Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, Aplicacao minhaApp) {
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

        jLabel1 = new javax.swing.JLabel();
        jLNomeAluno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMensagem = new javax.swing.JTextArea();
        jBEnviar = new javax.swing.JButton();
        jTFAssunto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Para:");

        jLNomeAluno.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLNomeAluno.setText("Nome do Aluno");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setText("Assunto:");

        jTAMensagem.setColumns(20);
        jTAMensagem.setRows(5);
        jScrollPane1.setViewportView(jTAMensagem);

        jBEnviar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBEnviar.setText("Enviar");
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTFAssunto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLNomeAluno))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jBEnviar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLNomeAluno))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFAssunto, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBEnviar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed
        if (!jTFAssunto.getText().equals("")) {
            if (!jTAMensagem.getText().equals("")) {
                String mensagem = jTAMensagem.getText();
                String assunto = jTFAssunto.getText();
                boolean alunoRemetente = false;
                LocalDateTime dataHoraEnvio = LocalDateTime.now();

                Mensagem msgResposta = new Mensagem(minhaApp.getAluno(), minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);

                try {
                    out.writeObject("enviaMensagemEmpresa");

                    mensagemRecebida = (String) in.readObject();

                    if (mensagemRecebida.equals("Ok")) {
                        out.writeObject(msgResposta);

                        mensagemRecebida = (String) in.readObject();

                        if (mensagemRecebida.equals("mensagemEnviada")) {
                            JOptionPane.showMessageDialog(rootPane, "Mensagem enviada!");
                            this.dispose();
                        }
                    }
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(AlunoMensagemDetalhar.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Escreva algo no corpo da mensagem.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Informe o assunto da mensagem.");
        }
    }//GEN-LAST:event_jBEnviarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLNomeAluno.setText(minhaApp.getAluno().getNomeCompleto());
    }//GEN-LAST:event_formWindowOpened

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviar;
    private javax.swing.JLabel jLNomeAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMensagem;
    private javax.swing.JTextField jTFAssunto;
    // End of variables declaration//GEN-END:variables
}
