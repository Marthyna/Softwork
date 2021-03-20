package cliente;

import classesDominio.Aluno;
import classesDominio.Mensagem;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.format.DateTimeFormatter;

public class EmpresaMensagemDetalhar extends javax.swing.JFrame {

    Mensagem minhaMsg;
    Aluno meuAluno;
    
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";
    
    public EmpresaMensagemDetalhar(Mensagem minhaMsg, Socket cliente, ObjectOutputStream out, ObjectInputStream in, Aluno meuAluno) {
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
        jLNomeAluno = new javax.swing.JLabel();
        jLDataHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
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

        jLNomeAluno.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLNomeAluno.setText("Nome aluno");

        jLDataHora.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLDataHora.setText("Data, hora");

        jTAMensagem.setEditable(false);
        jTAMensagem.setColumns(20);
        jTAMensagem.setRows(5);
        jScrollPane1.setViewportView(jTAMensagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLNomeAluno))
                    .addComponent(jLDataHora)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLNomeAluno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDataHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLNomeAluno.setText(minhaMsg.getAluno().getNomeCompleto());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        jLDataHora.setText(minhaMsg.getDataHoraEnvio().format(formato));
        
        jTAMensagem.setText(minhaMsg.getMensagem());
        
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDataHora;
    private javax.swing.JLabel jLNomeAluno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMensagem;
    // End of variables declaration//GEN-END:variables
}
