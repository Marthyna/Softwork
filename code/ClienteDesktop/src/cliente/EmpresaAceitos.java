package cliente;

import classesDominio.Aplicacao;
import classesDominio.Empresa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpresaAceitos extends javax.swing.JFrame {

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    LinkedList<Aplicacao> listaAplicacoes;

    DefaultTableModel model;

    public EmpresaAceitos(Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.minhaEmpresa = minhaEmpresa;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.listaAplicacoes = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLAceitos = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLHistorico = new javax.swing.JLabel();
        jLBemVindo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLConta = new javax.swing.JLabel();
        jLMensagens = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLRecusados = new javax.swing.JLabel();
        jLVagasAbertas = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLAplicacoesRecebidas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLSair = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jBDetalhar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAceitos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_icon.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aceito.png"))); // NOI18N

        jLAceitos.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLAceitos.setText("Aceitos");

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recusado.png"))); // NOI18N

        jLHistorico.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLHistorico.setText("Histórico de vagas");
        jLHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLHistoricoMouseClicked(evt);
            }
        });

        jLBemVindo.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLBemVindo.setText("Bem vindo, usuário!");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mensagens.png"))); // NOI18N

        jLConta.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLConta.setText("Conta");
        jLConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLContaMouseClicked(evt);
            }
        });

        jLMensagens.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLMensagens.setText("Mensagens");
        jLMensagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLMensagensMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/conta.png"))); // NOI18N

        jLRecusados.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLRecusados.setText("Recusados");
        jLRecusados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLRecusadosMouseClicked(evt);
            }
        });

        jLVagasAbertas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLVagasAbertas.setText("Vagas abertas");
        jLVagasAbertas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLVagasAbertasMouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/historico.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/ofertas.png"))); // NOI18N

        jLAplicacoesRecebidas.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLAplicacoesRecebidas.setText("Aplicações recebidas");
        jLAplicacoesRecebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAplicacoesRecebidasMouseClicked(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/recebidos.png"))); // NOI18N

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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLSair)
                            .addComponent(jLBemVindo)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLConta)
                                    .addComponent(jLVagasAbertas)
                                    .addComponent(jLAplicacoesRecebidas)
                                    .addComponent(jLAceitos)
                                    .addComponent(jLRecusados)
                                    .addComponent(jLHistorico)
                                    .addComponent(jLMensagens)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLBemVindo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLSair)
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel3)
                                                            .addComponent(jLConta))
                                                        .addGap(25, 25, 25)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel4)
                                                            .addComponent(jLVagasAbertas))
                                                        .addGap(25, 25, 25)
                                                        .addComponent(jLabel5))
                                                    .addComponent(jLAplicacoesRecebidas))
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel6))
                                            .addComponent(jLAceitos))
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel43))
                                    .addComponent(jLRecusados))
                                .addGap(25, 25, 25)
                                .addComponent(jLabel7))
                            .addComponent(jLHistorico))
                        .addGap(25, 25, 25)
                        .addComponent(jLabel8))
                    .addComponent(jLMensagens))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jBDetalhar.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBDetalhar.setText("Ver detalhes");
        jBDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalharActionPerformed(evt);
            }
        });

        jTAceitos.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTAceitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Aluno", "Vaga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTAceitos.setRowHeight(35);
        jTAceitos.setRowMargin(10);
        jScrollPane1.setViewportView(jTAceitos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBDetalhar))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jBDetalhar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHistoricoMouseClicked
        EmpresaHistorico telaHistorico = new EmpresaHistorico(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaHistorico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLHistoricoMouseClicked

    private void jLContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLContaMouseClicked
        EmpresaConta telaConta = new EmpresaConta(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaConta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLContaMouseClicked

    private void jLMensagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLMensagensMouseClicked
        EmpresaMensagens telaMensagens = new EmpresaMensagens(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaMensagens.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLMensagensMouseClicked

    private void jLRecusadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLRecusadosMouseClicked
        EmpresaRecusados telaRecusados = new EmpresaRecusados(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecusados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLRecusadosMouseClicked

    private void jLVagasAbertasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLVagasAbertasMouseClicked
        EmpresaVagasAbertas telaAbertas = new EmpresaVagasAbertas(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaAbertas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLVagasAbertasMouseClicked

    private void jBDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalharActionPerformed
        if (jTAceitos.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma aplicação para detalhar.");
        } else {
            int x = jTAceitos.getSelectedRow();
            String selecionadaNome = (String) jTAceitos.getValueAt(x, 0);

            try {
                out.writeObject("detalhaAplicacaoEmpresa");

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("Ok")) {
                    out.writeObject(selecionadaNome);
                    out.writeObject(minhaEmpresa);

                    Aplicacao minhaApp = (Aplicacao) in.readObject();

                    EmpresaDetalharAceitos telaDetalharApp = new EmpresaDetalharAceitos(minhaEmpresa, cliente, out, in, minhaApp);
                    telaDetalharApp.setVisible(true);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBDetalharActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        model = (DefaultTableModel) jTAceitos.getModel();
        model.setNumRows(0);
        
        String[] nome = minhaEmpresa.getNomeFantasia().split(" ");
        String nomeString = nome[0];

        jLBemVindo.setText("Bem vinda, " + nomeString + "!");

        try {
            out.writeObject("listaAceitosEmpresa");

            mensagemRecebida = (String) in.readObject();

            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(minhaEmpresa);

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("temAplicacoes")) {
                    listaAplicacoes = (LinkedList<Aplicacao>) in.readObject();

                    for (int x = 0; x < listaAplicacoes.size(); x++) {
                        model.addRow(new Object[]{listaAplicacoes.get(x).getAluno().getNomeCompleto(), listaAplicacoes.get(x).getVaga().getNome()});
                    }
                } else if (mensagemRecebida.equals("naoTemAplicacoesAceitas")) {
                    JOptionPane.showMessageDialog(rootPane, "Não há aplicações aceitas!");
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jLAplicacoesRecebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAplicacoesRecebidasMouseClicked
        EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecebidos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAplicacoesRecebidasMouseClicked

    private void jLSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLSairMouseClicked
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLSairMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDetalhar;
    private javax.swing.JLabel jLAceitos;
    private javax.swing.JLabel jLAplicacoesRecebidas;
    private javax.swing.JLabel jLBemVindo;
    private javax.swing.JLabel jLConta;
    private javax.swing.JLabel jLHistorico;
    private javax.swing.JLabel jLMensagens;
    private javax.swing.JLabel jLRecusados;
    private javax.swing.JLabel jLSair;
    private javax.swing.JLabel jLVagasAbertas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAceitos;
    // End of variables declaration//GEN-END:variables
}
