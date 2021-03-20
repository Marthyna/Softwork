package cliente;

import classesDominio.Aluno;
import classesDominio.Vaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlunoOfertas extends javax.swing.JFrame {

    Aluno meuAluno;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String[] alfabetosCriptografia;

    String mensagemRecebida = "";

    LinkedList<Vaga> listaVagas;

    private DefaultTableModel model;
    
    public void consulta(){
        model = (DefaultTableModel) jTListaOfertas.getModel();
        model.setNumRows(0);
        try {
            out.writeObject("listaVagas");

            mensagemRecebida = (String) in.readObject();
            if (mensagemRecebida.equals("Ok")) {
                
                out.writeObject(meuAluno);
                
                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("temVagas")) {
                    listaVagas = (LinkedList<Vaga>) in.readObject();

                    for (int x = 0; x < listaVagas.size(); x++) {
                        model.addRow(new Object[]{listaVagas.get(x).getNome(), listaVagas.get(x).getEmpresa().getNomeFantasia()});
                    }

                } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                    JOptionPane.showMessageDialog(rootPane, "Não há vagas abertas no momento!");
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public AlunoOfertas(Aluno meuAluno, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.meuAluno = meuAluno;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.listaVagas = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jLabel7 = new javax.swing.JLabel();
        jLHistorico = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLMensagens = new javax.swing.JLabel();
        jLEmEspera = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLSair = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTFPesquisar = new javax.swing.JTextField();
        jBPesquisar = new javax.swing.JButton();
        jBDetalhar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTListaOfertas = new javax.swing.JTable();

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

        jLConta.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLConta.setText("Conta");
        jLConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLContaMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/conta.png"))); // NOI18N

        jLOfertas.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLOfertas.setText("Ofertas");

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

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/historico.png"))); // NOI18N

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

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/emEspera.png"))); // NOI18N

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLRecusados))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLEmEspera))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLAceitos)
                                    .addComponent(jLOfertas)
                                    .addComponent(jLConta)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLMensagens)
                                    .addComponent(jLHistorico))))
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
                .addGap(24, 24, 24)
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
                    .addComponent(jLabel9)
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
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jTFPesquisar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFPesquisar.setForeground(new java.awt.Color(153, 153, 153));
        jTFPesquisar.setToolTipText("Pesquisar");
        jTFPesquisar.setName(""); // NOI18N

        jBPesquisar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jBPesquisar.setText("Buscar");
        jBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPesquisarActionPerformed(evt);
            }
        });

        jBDetalhar.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBDetalhar.setText("Ver detalhes");
        jBDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalharActionPerformed(evt);
            }
        });

        jTListaOfertas.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTListaOfertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Empresa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTListaOfertas.setRowHeight(35);
        jTListaOfertas.setRowMargin(10);
        jScrollPane1.setViewportView(jTListaOfertas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBDetalhar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jTFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jBDetalhar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTFPesquisar.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLContaMouseClicked
        AlunoConta telaAlunoConta = new AlunoConta(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaAlunoConta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLContaMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        String[] nome = meuAluno.getNomeCompleto().split(" ");
        String nomeString = nome[0];
        if (meuAluno.getSexo() == 1) {
            jLBemVindo.setText("Bem vinda, " + nomeString + "!");
        } else {
            jLBemVindo.setText("Bem vindo, " + nomeString + "!");
        }

        consulta();
    }//GEN-LAST:event_formWindowOpened

    private void jBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPesquisarActionPerformed
        String termoPesquisado = jTFPesquisar.getText();
        try {
            out.writeObject("pesquisaVagas");

            mensagemRecebida = (String) in.readObject();
            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(termoPesquisado);

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("temVagas")) {
                    model.setNumRows(0);
                    listaVagas = (LinkedList<Vaga>) in.readObject();
                    for (int x = 0; x < listaVagas.size(); x++) {
                        model.addRow(new Object[]{listaVagas.get(x).getNome(), listaVagas.get(x).getEmpresa().getNomeFantasia()});
                    }

                } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhum resultado encontrado a partir da pesquisa: " + termoPesquisado);
                }
            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBPesquisarActionPerformed

    private void jBDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalharActionPerformed
        if (jTListaOfertas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma vaga para detalhar.");
        } else {
            int x = jTListaOfertas.getSelectedRow();
            String selecionadaNome = (String) jTListaOfertas.getValueAt(x, 0);

            try {
                out.writeObject("detalhaVaga");

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("Ok")) {
                    out.writeObject(selecionadaNome);

                    Vaga vaga = (Vaga) in.readObject();

                    AlunoOfertasDetalhar telaDetalharVaga = new AlunoOfertasDetalhar(vaga, meuAluno, cliente, out, in);
                    telaDetalharVaga.setVisible(true);
                    
                    if(!telaDetalharVaga.isShowing()){
                        consulta();
                    }
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jBDetalharActionPerformed

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

    private void jLHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHistoricoMouseClicked
        AlunoHistorico telaHistorico = new AlunoHistorico(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaHistorico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLHistoricoMouseClicked

    private void jLMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMensagensMouseClicked
        AlunoMensagens telaMensagens = new AlunoMensagens(meuAluno, cliente, out, in, alfabetosCriptografia);
        telaMensagens.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLMensagensMouseClicked

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDetalhar;
    private javax.swing.JButton jBPesquisar;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTable jTListaOfertas;
    // End of variables declaration//GEN-END:variables
}
