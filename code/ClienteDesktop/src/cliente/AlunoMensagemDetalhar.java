package cliente;

import classesDominio.Aluno;
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

public class AlunoMensagemDetalhar extends javax.swing.JFrame {
    
    Mensagem minhaMsg;
    Aluno meuAluno;
    
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";
    
    public AlunoMensagemDetalhar(Mensagem minhaMsg, Socket cliente, ObjectOutputStream out, ObjectInputStream in, Aluno meuAluno) {
        initComponents();
        this.minhaMsg = minhaMsg;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.meuAluno = meuAluno;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLNomeEmpresa = new javax.swing.JLabel();
        jLDataHora = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAMsgEnviar = new javax.swing.JTextArea();
        jBResponder = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAMensagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("De:");

        jLNomeEmpresa.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLNomeEmpresa.setText("Nome empresa");

        jLDataHora.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLDataHora.setText("Data, hora");

        jTAMsgEnviar.setColumns(20);
        jTAMsgEnviar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTAMsgEnviar.setRows(5);
        jScrollPane2.setViewportView(jTAMsgEnviar);

        jBResponder.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jBResponder.setText("Responder");
        jBResponder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResponderActionPerformed(evt);
            }
        });

        jTAMensagem.setEditable(false);
        jTAMensagem.setColumns(20);
        jTAMensagem.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTAMensagem.setRows(5);
        jScrollPane3.setViewportView(jTAMensagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLNomeEmpresa))
                    .addComponent(jLDataHora)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLNomeEmpresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDataHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBResponder, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLNomeEmpresa.setText(minhaMsg.getEmpresa().getNomeFantasia());
        jLDataHora.setText(minhaMsg.getDataHoraEnvio().getDayOfMonth() + "/" + minhaMsg.getDataHoraEnvio().getMonth() + "/" + minhaMsg.getDataHoraEnvio().getYear() + " - " + minhaMsg.getDataHoraEnvio().getHour() + ":" + minhaMsg.getDataHoraEnvio().getMinute());
        jTAMensagem.setText(minhaMsg.getMensagem());
    }//GEN-LAST:event_formWindowOpened

    private void jBResponderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResponderActionPerformed
        if (!jTAMsgEnviar.getText().equals("")) {
            String mensagem = jTAMsgEnviar.getText();
            String assunto = minhaMsg.getAssunto() + "/Resposta";
            boolean alunoRemetente = true;
            LocalDateTime dataHoraEnvio = LocalDateTime.now();
            Empresa minhaEmpresa = minhaMsg.getEmpresa();

            Mensagem msgResposta = new Mensagem(meuAluno, minhaEmpresa, mensagem, assunto, alunoRemetente, dataHoraEnvio);

            try {
                out.writeObject("enviaMensagemAluno");

                mensagemRecebida = (String) in.readObject();

                if(mensagemRecebida.equals("Ok")){
                    out.writeObject(msgResposta);

                    mensagemRecebida = (String) in.readObject();

                    if(mensagemRecebida.equals("mensagemEnviada")){
                        JOptionPane.showMessageDialog(rootPane, "Resposta enviada!");
                        this.dispose();
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AlunoMensagemDetalhar.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Escreva algo no corpo da mensagem.");
        }
    }//GEN-LAST:event_jBResponderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBResponder;
    private javax.swing.JLabel jLDataHora;
    private javax.swing.JLabel jLNomeEmpresa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTAMensagem;
    private javax.swing.JTextArea jTAMsgEnviar;
    // End of variables declaration//GEN-END:variables
}
