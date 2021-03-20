package cliente;

import classesDominio.Aluno;
import classesDominio.Vaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AlunoOfertasDetalhar extends javax.swing.JFrame {
    
    Vaga vaga;
    
    Aluno meuAluno;
    
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;
    
    String mensagemRecebida = "";
    
    public AlunoOfertasDetalhar(Vaga vaga, Aluno meuAluno, Socket cliente, ObjectOutputStream out, ObjectInputStream in) {
        initComponents();
        this.vaga = vaga;
        this.meuAluno = meuAluno;
        this.cliente = cliente;
        this.in = in;
        this.out = out;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLNomeVaga = new javax.swing.JLabel();
        jLLocalidade = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLNomeEmpresa = new javax.swing.JLabel();
        jLEndereco = new javax.swing.JLabel();
        jLTelefone = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLTurno = new javax.swing.JLabel();
        jLSetor = new javax.swing.JLabel();
        jBEnviarCurriculo = new javax.swing.JButton();
        jLRemunerada = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLNomeVaga.setFont(new java.awt.Font("Calibri Light", 0, 24)); // NOI18N
        jLNomeVaga.setText("Nome");

        jLLocalidade.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLLocalidade.setText("Localidade");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Empresa:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Endereço:");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Telefone:");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Descrição:");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Turno:");

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Setor:");

        jLNomeEmpresa.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLNomeEmpresa.setText("Nome da empresa");

        jLEndereco.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLEndereco.setText("Endereço");

        jLTelefone.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLTelefone.setText("Telefone");

        jTADescricao.setEditable(false);
        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLTurno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLTurno.setText("Turno");

        jLSetor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSetor.setText("Setor");

        jBEnviarCurriculo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBEnviarCurriculo.setText("Enviar currículo");
        jBEnviarCurriculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarCurriculoActionPerformed(evt);
            }
        });

        jLRemunerada.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jLRemunerada.setText("Remunerada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jLSetor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLTelefone))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLEndereco))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLNomeEmpresa))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLTurno))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jBEnviarCurriculo)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLRemunerada)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLNomeVaga, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLLocalidade, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(185, 185, 185))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLNomeVaga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLLocalidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLRemunerada, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLNomeEmpresa))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLEndereco))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLTelefone))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLTurno))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLSetor))
                .addGap(18, 18, 18)
                .addComponent(jBEnviarCurriculo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLNomeVaga.setText(vaga.getNome());
        jLLocalidade.setText(vaga.getEmpresa().getEndereco().getCidade());
        
        if (vaga.isRemunerada()) {
            jLRemunerada.setText("Remunerada");
        } else {
            jLRemunerada.setText("Não remunerada.");
        }
        
        jLNomeEmpresa.setText(vaga.getEmpresa().getNomeFantasia());
        String endereco = vaga.getEmpresa().getEndereco().getRua() + ", nº " + vaga.getEmpresa().getEndereco().getNumero() + " - Bairro " + vaga.getEmpresa().getEndereco().getBairro();
        jLEndereco.setText(endereco);
        String telefone = "(" + vaga.getEmpresa().getDdd() + ")-" + vaga.getEmpresa().getTelefone();
        jLTelefone.setText(telefone);
        jTADescricao.setText(vaga.getDescricao());
        jLTurno.setText(vaga.getTurnoLiteral());
        jLSetor.setText(vaga.getSetor());
    }//GEN-LAST:event_formWindowOpened

    private void jBEnviarCurriculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarCurriculoActionPerformed
        try {
            out.writeObject("enviaCurriculo");
            
            mensagemRecebida = (String) in.readObject();
            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(meuAluno.getID());
                out.writeObject(vaga);
                
                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("temCurriculo")) {
                    mensagemRecebida = (String) in.readObject();
                    if (mensagemRecebida.equals("cadastreiAplicacao")) {
                        JOptionPane.showMessageDialog(rootPane, "Currículo enviado!");
                        this.dispose();
                    }
                    
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoOfertasDetalhar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBEnviarCurriculoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEnviarCurriculo;
    private javax.swing.JLabel jLEndereco;
    private javax.swing.JLabel jLLocalidade;
    private javax.swing.JLabel jLNomeEmpresa;
    private javax.swing.JLabel jLNomeVaga;
    private javax.swing.JLabel jLRemunerada;
    private javax.swing.JLabel jLSetor;
    private javax.swing.JLabel jLTelefone;
    private javax.swing.JLabel jLTurno;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    // End of variables declaration//GEN-END:variables
}
