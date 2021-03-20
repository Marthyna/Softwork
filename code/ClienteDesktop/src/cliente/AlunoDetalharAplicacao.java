package cliente;

import classesDominio.Aplicacao;

public class AlunoDetalharAplicacao extends javax.swing.JFrame {

    Aplicacao minhaApp;

    public AlunoDetalharAplicacao(Aplicacao minhaApp) {
        initComponents();
        this.minhaApp = minhaApp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLTitulo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLNomeEmpresa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLSetor = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLDescricao = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLTurno = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLSalario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLTitulo.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLTitulo.setText("Aplicação para a vaga ");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Empresa:");

        jLNomeEmpresa.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLNomeEmpresa.setText("Nome da empresa");

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Setor:");

        jLSetor.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSetor.setText("Setor");

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Descrição da vaga:");

        jLDescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLDescricao.setText("jLabel1");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Turno:");

        jLTurno.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLTurno.setText("Turno");

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Salário:");

        jLSalario.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLSalario.setText("Valor do Salário");

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Status da aplicação:");

        jLStatus.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLStatus.setText("Status");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLNomeEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLTurno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLDescricao)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jLStatus)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLSetor)
                    .addComponent(jLSalario))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLTitulo)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLNomeEmpresa)
                    .addComponent(jLabel5)
                    .addComponent(jLSetor))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLDescricao)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLTurno)
                    .addComponent(jLabel7)
                    .addComponent(jLSalario))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLStatus))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        jLTitulo.setText("Aplicação para a vaga " + minhaApp.getVaga().getNome());

        jLNomeEmpresa.setText(minhaApp.getVaga().getEmpresa().getNomeFantasia());

        jLDescricao.setText(minhaApp.getVaga().getDescricao());
        jLSetor.setText(minhaApp.getVaga().getSetor());
        jLTurno.setText(minhaApp.getVaga().getTurnoLiteral());

        if (minhaApp.getVaga().isRemunerada()) {
            jLSalario.setText("R$" + minhaApp.getVaga().getSalario());
        } else {
            jLSalario.setText("-");
        }

        String status = "";
        if (minhaApp.isMovimentada()) {
            if (minhaApp.isAceita()) {
                status = "Aceita";
            } else {
                status = "Recusada";
            }
        } else {
            status = "Em espera";
        }
        
        jLStatus.setText(status);
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLDescricao;
    private javax.swing.JLabel jLNomeEmpresa;
    private javax.swing.JLabel jLSalario;
    private javax.swing.JLabel jLSetor;
    private javax.swing.JLabel jLStatus;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLTurno;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
