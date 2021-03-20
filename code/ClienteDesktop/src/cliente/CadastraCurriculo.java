package cliente;

import classesDominio.Aluno;
import classesDominio.Curriculo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CadastraCurriculo extends javax.swing.JFrame {

    String mensagemRecebida = "";
    Socket cliente;
    ObjectOutputStream out;
    ObjectInputStream in;

    String[] alfabetosCriptografia;

    Aluno meuAluno;

    public CadastraCurriculo(Socket cliente, ObjectOutputStream out, ObjectInputStream in, String alfabetosCriptografia[], Aluno meuAluno) {
        initComponents();
        this.alfabetosCriptografia = alfabetosCriptografia;
        this.cliente = cliente;
        this.in = in;
        this.out = out;
        this.meuAluno = meuAluno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jTFIdioma1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFFormacao1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTFFormacao2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFIdioma2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTFIdioma3 = new javax.swing.JTextField();
        jTFFormacao3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFCurso1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFEmprego1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFCurso2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFEmprego2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTFCurso3 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFEmprego3 = new javax.swing.JTextField();
        jBEnviar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setText("Cadastrar currículo:");

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel2.setText("Descrição:");

        jTADescricao.setColumns(20);
        jTADescricao.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescricao.setRows(5);
        jScrollPane1.setViewportView(jTADescricao);

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel3.setText("Idioma 1:");

        jTFIdioma1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel6.setText("Formação 1:");

        jTFFormacao1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel7.setText("Formação 2:");

        jTFFormacao2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel8.setText("Idioma 2:");

        jTFIdioma2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel9.setText("Idioma 3:");

        jTFIdioma3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jTFFormacao3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel10.setText("Formação 3:");

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel4.setText("Curso 1:");

        jTFCurso1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel5.setText("Emprego 1:");

        jTFEmprego1.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel11.setText("Curso 2:");

        jTFCurso2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel12.setText("Emprego 2:");

        jTFEmprego2.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel13.setText("Curso 3:");

        jTFCurso3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLabel14.setText("Emprego 3:");

        jTFEmprego3.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N

        jBEnviar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jBEnviar.setText("Enviar");
        jBEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEnviarActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jBCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFFormacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFFormacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel13))
                                        .addGap(16, 16, 16)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTFCurso1)
                                    .addComponent(jTFIdioma3, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(jTFCurso2)
                                    .addComponent(jTFCurso3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFFormacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFEmprego1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFEmprego2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFEmprego3))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFIdioma1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTFFormacao1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFIdioma2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTFFormacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTFIdioma3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTFFormacao3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTFEmprego1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTFCurso2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTFEmprego2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTFCurso3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTFEmprego3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEnviarActionPerformed

        if (!jTADescricao.getText().equals("")) {
            if (!jTFIdioma1.getText().equals("")) {
                if (!jTFFormacao1.getText().equals("")) {

                    String descricao = jTADescricao.getText();
                    String idioma1 = jTFIdioma1.getText();
                    String formacao1 = jTFFormacao1.getText();

                    String idioma2 = "";
                    String idioma3 = "";
                    
                    String formacao2 = "";
                    String formacao3 = "";
                    
                    String curso1 = "";
                    String curso2 = "";
                    String curso3 = "";
                    
                    String emprego1 = "";
                    String emprego2 = "";
                    String emprego3 = "";
                    
                    Curriculo meuCurriculo = new Curriculo(descricao, formacao1, formacao2, formacao3, idioma1, idioma2, idioma3, curso1, curso2, curso3, emprego1, emprego2, emprego3);
                    
                    if (!jTFIdioma2.getText().equals("")) {
                        idioma2 = jTFIdioma2.getText();
                        meuCurriculo.setIdioma2(idioma2);
                    }
                    if (!jTFIdioma3.getText().equals("")) {
                        idioma3 = jTFIdioma3.getText();
                        meuCurriculo.setIdioma3(idioma3);
                    }

                    
                    if (!jTFFormacao2.getText().equals("")) {
                        formacao2 = jTFFormacao2.getText();
                        meuCurriculo.setFormacao2(formacao2);
                    }
                    if (!jTFFormacao3.getText().equals("")) {
                        formacao3 = jTFFormacao3.getText();
                        meuCurriculo.setFormacao3(formacao3);
                    }

                    
                    if (!jTFCurso1.getText().equals("")) {
                        curso1 = jTFCurso1.getText();
                        meuCurriculo.setCurso1(curso1);
                    }
                    if (!jTFCurso2.getText().equals("")) {
                        curso2 = jTFCurso2.getText();
                        meuCurriculo.setCurso2(curso2);
                    }
                    if (!jTFCurso3.getText().equals("")) {
                        curso3 = jTFCurso3.getText();
                        meuCurriculo.setCurso3(curso3);
                    }

                    
                    if (!jTFEmprego1.getText().equals("")) {
                        emprego1 = jTFEmprego1.getText();
                        meuCurriculo.setEmprego1(emprego1);
                    }
                    if (!jTFEmprego2.getText().equals("")) {
                        emprego2 = jTFEmprego2.getText();
                        meuCurriculo.setEmprego2(emprego2);
                    }
                    if (!jTFEmprego3.getText().equals("")) {
                        emprego3 = jTFEmprego3.getText();
                        meuCurriculo.setEmprego3(emprego3);
                    }

                    meuAluno.setCurriculo(meuCurriculo);

                    try {
                        out.writeObject("cadastraAluno");
                        mensagemRecebida = (String) in.readObject();

                        if (mensagemRecebida.equals("Ok")) {
                            out.writeObject(meuAluno);
                            int cod_usuario = (int) in.readObject();

                            String senhaCriptografada = criptografa(meuAluno.getSenha(), cod_usuario);
                            out.writeObject(senhaCriptografada);

                            mensagemRecebida = (String) in.readObject();

                            switch (mensagemRecebida) {
                                case "alunoCadastrado":
                                    int cod_aluno = (int) in.readObject();
                                    meuAluno.setID(cod_aluno);
                                    
                                    AlunoOfertas telaAlunoOfertas = new AlunoOfertas(meuAluno, cliente, out, in, alfabetosCriptografia);
                                    telaAlunoOfertas.setVisible(true);
                                    this.dispose();
                                    break;
                                case "emailJaExiste":
                                    JOptionPane.showMessageDialog(rootPane, "O email informado já está sendo usado.");
                                    break;
                                case "matriculaJaCadastrada":
                                    JOptionPane.showMessageDialog(rootPane, "A matrícula informada já está cadastrada.");
                                    break;
                                case "rgJaCadastrado":
                                    JOptionPane.showMessageDialog(rootPane, "O RG informado já está cadastrado.");
                                    break;
                                case "cpfJaCadastrado":
                                    JOptionPane.showMessageDialog(rootPane, "O CPF informado já está cadastrado.");
                                    break;
                                default:
                                    break;
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Ocorreu um erro no servidor.");
                        }
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(CadastraCurriculo.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    JOptionPane.showMessageDialog(rootPane, "Informe pelo menos uma formação.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Informe pelo menos um idioma.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Escreva a descrição do currículo.");
        }

    }//GEN-LAST:event_jBEnviarActionPerformed

    public String criptografa(String senhaOriginal, int codigoUsuario) {
        String senhaCriptografada = "";
        int chave = codigoUsuario + senhaOriginal.length();
        if (chave >= 70) {
            chave -= 70;
        }

        for (int x = 0; x < 3; x++) {
            //String alfabeto = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789*@&#$%-+";

            char[] letras = alfabetosCriptografia[x].toCharArray(); // vetor com as letras do alfabeto

            char[] vetorLetrasSenha = senhaOriginal.toCharArray(); // vetor com letras da senha             
            char[] vetorSenhaCriptografada = new char[vetorLetrasSenha.length]; // vetor pras letras da senha criptada

            for (int y = 0; y < vetorLetrasSenha.length; y++) {
                char caractere = vetorLetrasSenha[y]; // pega cada caractere
                int posicaoLetra = 0;
                for (int z = 0; z < letras.length; z++) {
                    if (letras[z] == caractere) {
                        posicaoLetra = z; // acha cada um no alfabeto
                    }
                }
                int posicaoNova = posicaoLetra + chave; // incrementa a posicao com a chave
                if (posicaoNova >= 70) {
                    posicaoNova -= 70;
                }
                vetorSenhaCriptografada[y] = letras[posicaoNova]; // poe o caracter novo no vetor
            }

            senhaCriptografada = new String(vetorSenhaCriptografada); // por tudo numa String
        }

        return senhaCriptografada;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescricao;
    private javax.swing.JTextField jTFCurso1;
    private javax.swing.JTextField jTFCurso2;
    private javax.swing.JTextField jTFCurso3;
    private javax.swing.JTextField jTFEmprego1;
    private javax.swing.JTextField jTFEmprego2;
    private javax.swing.JTextField jTFEmprego3;
    private javax.swing.JTextField jTFFormacao1;
    private javax.swing.JTextField jTFFormacao2;
    private javax.swing.JTextField jTFFormacao3;
    private javax.swing.JTextField jTFIdioma1;
    private javax.swing.JTextField jTFIdioma2;
    private javax.swing.JTextField jTFIdioma3;
    // End of variables declaration//GEN-END:variables
}
