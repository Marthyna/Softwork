package cliente;

import classesDominio.Empresa;
import classesDominio.Vaga;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpresaVagasAbertas extends javax.swing.JFrame {

    Empresa minhaEmpresa;

    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String mensagemRecebida = "";

    String[] alfabetosCriptografia;

    LinkedList<Vaga> listaVagas;

    DefaultTableModel model;

    public void consulta() {
        model.setNumRows(0);
        
        try {
            out.writeObject("listaVagasAbertasEmpresa");
            
            mensagemRecebida = (String) in.readObject();
            
            if (mensagemRecebida.equals("Ok")) {
                out.writeObject(minhaEmpresa);
                
                mensagemRecebida = (String) in.readObject();
                
                if (mensagemRecebida.equals("temVagas")) {
                    listaVagas = (LinkedList<Vaga>) in.readObject();
                    
                    for (int x = 0; x < listaVagas.size(); x++) {
                        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        String dataPublicacao = listaVagas.get(x).getDataPublicacao().format(formato);

                        model.addRow(new Object[]{listaVagas.get(x).getNome(), dataPublicacao, listaVagas.get(x).getTotalAplicacoes()});
                        
                    }
                } else if (mensagemRecebida.equals("nenhumaVagaCadastrada")) {
                    JOptionPane.showMessageDialog(rootPane, "Não há vagas abertas no momento!");
                }

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public EmpresaVagasAbertas(Empresa minhaEmpresa, Socket cliente, ObjectOutputStream out, ObjectInputStream in, String[] alfabetosCriptografia) {
        initComponents();
        this.minhaEmpresa = minhaEmpresa;
        this.cliente = cliente;
        this.out = out;
        this.in = in;
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.listaVagas = new LinkedList<>();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jBDetalhar = new javax.swing.JButton();
        jBCadastrarVaga = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVagasAbertas = new javax.swing.JTable();
        jBExcluir = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        jBDetalhar.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBDetalhar.setText("Ver detalhes");
        jBDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDetalharActionPerformed(evt);
            }
        });

        jBCadastrarVaga.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBCadastrarVaga.setText("Cadastrar nova vaga");
        jBCadastrarVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCadastrarVagaActionPerformed(evt);
            }
        });

        jTVagasAbertas.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTVagasAbertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome", "Data de publicação", "Total de aplicações"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTVagasAbertas.setToolTipText("");
        jTVagasAbertas.setRowHeight(35);
        jTVagasAbertas.setRowMargin(10);
        jScrollPane1.setViewportView(jTVagasAbertas);

        jBExcluir.setFont(new java.awt.Font("Calibri Light", 0, 12)); // NOI18N
        jBExcluir.setText("Excluir");
        jBExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBCadastrarVaga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBDetalhar)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDetalhar)
                    .addComponent(jBCadastrarVaga)
                    .addComponent(jBExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logo_icon.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/aceito.png"))); // NOI18N

        jLAceitos.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLAceitos.setText("Aceitos");
        jLAceitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLAceitosMouseClicked(evt);
            }
        });

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

        jLVagasAbertas.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLVagasAbertas.setText("Vagas abertas");

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
                        .addGap(69, 69, 69)
                        .addComponent(jLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
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
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLMensagens))
                .addContainerGap(40, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDetalharActionPerformed
        if (jTVagasAbertas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma vaga para detalhar.");
        } else {
            int x = jTVagasAbertas.getSelectedRow();
            String selecionadaNome = (String) jTVagasAbertas.getValueAt(x, 0);

            try {
                out.writeObject("detalhaVagaEmpresa");

                mensagemRecebida = (String) in.readObject();
                if (mensagemRecebida.equals("Ok")) {
                    out.writeObject(selecionadaNome);
                    out.writeObject(minhaEmpresa);

                    Vaga vaga = (Vaga) in.readObject();

                    EmpresaVagaDetalhar telaDetalhar = new EmpresaVagaDetalhar(vaga, minhaEmpresa, cliente, out, in, alfabetosCriptografia, "vagasAbertas");
                    telaDetalhar.setVisible(true);
                    this.dispose();

                    if (!telaDetalhar.isActive()) {
                        consulta();
                    }
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jBDetalharActionPerformed

    private void jLAceitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAceitosMouseClicked
        EmpresaAceitos telaAceitos = new EmpresaAceitos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaAceitos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAceitosMouseClicked

    private void jLHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLHistoricoMouseClicked
        EmpresaHistorico telaHistorico = new EmpresaHistorico(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaHistorico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLHistoricoMouseClicked

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

    private void jLAplicacoesRecebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLAplicacoesRecebidasMouseClicked
        EmpresaRecebidos telaRecebidos = new EmpresaRecebidos(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaRecebidos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLAplicacoesRecebidasMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        String[] nome = minhaEmpresa.getNomeFantasia().split(" ");
        String nomeString = nome[0];

        jLBemVindo.setText("Bem vinda, " + nomeString + "!");
        model = (DefaultTableModel) jTVagasAbertas.getModel();
        consulta();

    }//GEN-LAST:event_formWindowOpened

    private void jBCadastrarVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCadastrarVagaActionPerformed
        EmpresaCadastrarVaga telaCadastrarVaga = new EmpresaCadastrarVaga(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaCadastrarVaga.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBCadastrarVagaActionPerformed

    private void jLContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLContaMouseClicked
        EmpresaConta telaConta = new EmpresaConta(minhaEmpresa, cliente, out, in, alfabetosCriptografia);
        telaConta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLContaMouseClicked

    private void jLSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLSairMouseClicked
        Login telaLogin = new Login();
        telaLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLSairMouseClicked

    private void jBExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExcluirActionPerformed
        if (jTVagasAbertas.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma vaga para excluir.");
        } else {
            int x = jTVagasAbertas.getSelectedRow();
            String selecionadaNome = (String) jTVagasAbertas.getValueAt(x, 0);

            switch (JOptionPane.showConfirmDialog(null, "Deseja excluir a vaga '" + selecionadaNome + "'?")) {
                case 0: {
                    try {
                        out.writeObject("excluiVaga");

                        mensagemRecebida = (String) in.readObject();
                        if (mensagemRecebida.equals("Ok")) {
                            out.writeObject(selecionadaNome);
                            out.writeObject(minhaEmpresa);

                            mensagemRecebida = (String) in.readObject();
                            if (mensagemRecebida.equals("temAplicacao")) {
                                switch (JOptionPane.showConfirmDialog(rootPane, "Esta vaga têm aplicações vinculadas. Desejar excluir mesmo assim?")) {
                                    case 0: {
                                        out.writeObject("confirmaExclusao");
                                        mensagemRecebida = (String) in.readObject();
                                        if (mensagemRecebida.equals("vagaExcluida")) {
                                            JOptionPane.showMessageDialog(rootPane, "Vaga excluída.");
                                            consulta();
                                        }
                                        break;
                                    }
                                    default:
                                        out.writeObject("cancelaExclusao");
                                        break;
                                }
                            } else if (mensagemRecebida.equals("naoTemAplicacao")) {
                                out.writeObject("ok");
                                mensagemRecebida = (String) in.readObject();
                                if (mensagemRecebida.equals("vagaExcluida")) {
                                    JOptionPane.showMessageDialog(rootPane, "Vaga excluída.");
                                    consulta();
                                }
                            }
                        }

                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(AlunoOfertas.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
        }
    }//GEN-LAST:event_jBExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCadastrarVaga;
    private javax.swing.JButton jBDetalhar;
    private javax.swing.JButton jBExcluir;
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
    private javax.swing.JTable jTVagasAbertas;
    // End of variables declaration//GEN-END:variables
}
