package View;

import Model.LoginModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import Data.CadastroDAO;
import Model.CadastroModel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cadastro extends javax.swing.JFrame {

    public Cadastro() { 
        initComponents(); 
        CarregarTabela(); 
        DefaultTableModel Model = (DefaultTableModel) tblCadastro.getModel(); 
        Pesquisa = new TableRowSorter<>(Model); 
        tblCadastro.setRowSorter(Pesquisa); }
    
    private void CarregarTabela() {
    DefaultTableModel Model = (DefaultTableModel) tblCadastro.getModel();
    Model.setRowCount(0); 
    
    CadastroDAO cadastrodao = new CadastroDAO();
    
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));       

    for (CadastroModel C : cadastrodao.listar()) {
        
        String dataFormatada = C.getDataNascimento().format(formatter);
        String SalarioFormatado = nf.format(C.getSalarioBase());
        
        Model.addRow(new Object[]{
            C.getIdCadastro(),
            C.getNomeCompleto(),
            C.getCPF(),
            dataFormatada,           
            C.getCargo(),
            SalarioFormatado,
            C.getStatus()           
        });
    }
}
    
    private LoginModel usuarioLogado;
    
    public Cadastro(LoginModel usuario) { 
        this.usuarioLogado = usuario; 
        initComponents(); 
        configurarPermissoes(); }
    
    private void configurarPermissoes() {

    btnCadastrar.setEnabled(
        Services.Permissoes.btnCadastrar(usuarioLogado)
    );

    btnEditar.setEnabled(
        Services.Permissoes.btnEditar(usuarioLogado)
    );

    btnExcluir.setEnabled(
        Services.Permissoes.btnExcluir(usuarioLogado)
    );

    btnFolha.setEnabled(
        Services.Permissoes.btnFolha(usuarioLogado)
    );
}  
    
    private TableRowSorter<DefaultTableModel> Pesquisa;
    
    private void limparCampos() {
    txtNome.setText("");
        txtData.setText("");
        txtCpf.setText("");
        txtSalario.setText("");
        txtCargo.setText("");
        cbxStatus.setSelectedIndex(0);}   
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        lblCadastro = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        txtPesquisar = new javax.swing.JTextField();
        lblPesquisar = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblNome2 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblData = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        lblCargo = new javax.swing.JLabel();
        txtCargo = new javax.swing.JTextField();
        cbxStatus = new javax.swing.JComboBox<>();
        lblStatus = new javax.swing.JLabel();
        btnFolha = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        lblCpf1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCadastro = new javax.swing.JTable();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblCadastro.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblCadastro.setText("CADASTRO DE FUNCIONÁRIO");

        lblNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome.setText("Nome Completo:");

        txtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisarActionPerformed(evt);
            }
        });
        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        lblPesquisar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblPesquisar.setText("Pesquisar");

        lblNome2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNome2.setText("Salário Base:");

        lblData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblData.setText("Data de Nascimento:");

        lblCargo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCargo.setText("Cargo:");

        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "ATIVO", "INATIVO" }));
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblStatus.setText("Status:");

        btnFolha.setBackground(new java.awt.Color(0, 51, 102));
        btnFolha.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnFolha.setText("Folha");
        btnFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFolhaActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(102, 255, 51));
        btnCadastrar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnLimpar1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnLimpar1.setText("Limpar");
        btnLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpar1ActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 102, 255));
        btnEditar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        lblCpf1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblCpf1.setText("CPF:");

        tblCadastro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome Completo", "CPF", "Data de Nascimento", "Cargo", "Salário Base", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCadastroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCadastro);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar1))
                            .addComponent(txtPesquisar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnFolha))
                            .addComponent(lblPesquisar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblData)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addComponent(lblCadastro))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCpf1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtCpf))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lblCargo)
                                        .addGap(7, 7, 7)
                                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStatus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCadastro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNome2)
                                .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCpf1)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNome)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblData)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStatus)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCargo)
                        .addComponent(txtCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrar)
                    .addComponent(btnLimpar1)
                    .addComponent(btnFolha)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisar))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFolhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFolhaActionPerformed
        // TODO add your handling code here:
        new Registro().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnFolhaActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        // TODO add your handling code here:
        // ----- Ajustes -----
         if (tblCadastro.getSelectedRow() != -1) {
        JOptionPane.showMessageDialog(this,
            "Você selecionou um registro já existente.\n" +
            "Clique em LIMPAR antes de cadastrar um novo.");
        return;
        }

        // ----- Dados -----
        String Nome = txtNome.getText().trim();
        String Data = txtData.getText().trim();
        String CPF = txtCpf.getText().trim();
        String Salario = txtSalario.getText().trim();
        String Cargo = txtCargo.getText().trim();
        String Status = cbxStatus.getSelectedItem().toString();
        
        // ----- Tratamento ------
        if (Nome.isEmpty() || Data.isEmpty() || CPF.isEmpty() || 
        Salario.isEmpty() || Cargo.isEmpty()) {
           
        JOptionPane.showMessageDialog(
        this,"Por favor, preencha todos os campos.",
        "Atenção", JOptionPane.WARNING_MESSAGE
        ); return;}
        
        if (cbxStatus.getSelectedIndex() == 0) {
        JOptionPane.showMessageDialog(this,
        "Selecione um status válido!",
        "Atenção", JOptionPane.WARNING_MESSAGE
        ); return;}
        
        Double SalarioBase = Double.parseDouble(Salario.replaceAll("[^0-9,]", "")
        .replace(",", "."));
        
        if(!Data.matches("\\d{2}/\\d{2}/\\d{4}")){
        JOptionPane.showMessageDialog(this,
          "Data inválida!\nFormato: DD/MM/AAAA"
        ); return;}
        
        if(!CPF.matches("\\d{11}")){
        JOptionPane.showMessageDialog(this, "CPF deve conter 11 números!");
        return;
        }
        CPF = CPF.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                "$1.$2.$3-$4");
        
        // ----- Mensagem Final -----
        JOptionPane.showMessageDialog(this, "Cadastro finalizado com sucesso!");
        limparCampos();   
        
        // ----- Ajustes finais -----         
        LocalDate dataNascimento = LocalDate.parse(Data, 
        DateTimeFormatter.ofPattern("dd/MM/yyyy")); 

        CadastroModel.Status statusEnum =
        CadastroModel.Status.valueOf(Status.toUpperCase());
     
        CadastroModel cadastro = new CadastroModel(Nome, dataNascimento, CPF,
                Cargo, SalarioBase, statusEnum);
        
        // ----- DAO ------
        CadastroDAO cadastrodao = new CadastroDAO();
        cadastrodao.Inserir(cadastro);
        CarregarTabela();
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpar1ActionPerformed
        // TODO add your handling code here:
        limparCampos();
        tblCadastro.clearSelection();
    }//GEN-LAST:event_btnLimpar1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // ----- Seleciona -----
        int linhaView = tblCadastro.getSelectedRow();

        if (linhaView == -1) {
            JOptionPane.showMessageDialog(this,
                "Selecione um cadastro para editar.");
            return;
        }

        int linhaModel = tblCadastro.convertRowIndexToModel(linhaView);
              
        // ----- Tabela Atualizada ------
        DefaultTableModel Model = (DefaultTableModel) tblCadastro.getModel();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String salarioTexto = txtSalario.getText()
        .replaceAll("[^0-9,]", "")   
        .replace(",", ".");  
        
        int idCadastro = Integer.parseInt(Model.getValueAt(linhaModel, 0).toString());
        
        CadastroModel cadastro = new CadastroModel(
        idCadastro,
        txtNome.getText(),
        LocalDate.parse(txtData.getText(), formatter),
        txtCpf.getText(),
        txtCargo.getText(),
        Double.parseDouble(salarioTexto),
        CadastroModel.Status.valueOf(cbxStatus.getSelectedItem().toString())
        );
        
        // ----- DAO ------
        CadastroDAO cadastrodao = new CadastroDAO();
        cadastrodao.Atualizar(cadastro);
        CarregarTabela();
       
        // ----- Mensagem ------
        JOptionPane.showMessageDialog(this, "Dados atualizados com sucesso!");
        limparCampos();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        // ----- Seleciona ------
        int linhaView = tblCadastro.getSelectedRow();

        if (linhaView == -1) {
            JOptionPane.showMessageDialog(this,
                "Selecione um cadastro para excluir.");
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir este Cadastro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) return;

        int linhaModel = tblCadastro.convertRowIndexToModel(linhaView);
        
        // ----- Tabela Atualizada ------     
        DefaultTableModel Model = (DefaultTableModel) tblCadastro.getModel();
        int idCadastro = Integer.parseInt(Model.getValueAt(linhaModel, 0).toString());
        
        // ----- DAO -----
        CadastroDAO cadastrodao = new CadastroDAO();
        cadastrodao.Excluir(idCadastro);
        CarregarTabela();
        
        // ----- Mensagem Final -----
        JOptionPane.showMessageDialog(this, "Cadastro excluído com sucesso!");
        limparCampos();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStatusActionPerformed

    private void tblCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCadastroMouseClicked
        // TODO add your handling code here:
        int linha = tblCadastro.getSelectedRow();
        DefaultTableModel Model = (DefaultTableModel) tblCadastro.getModel();

        txtNome.setText(Model.getValueAt(linha, 1).toString());
        txtCpf.setText(Model.getValueAt(linha, 2).toString());
        txtData.setText(Model.getValueAt(linha, 3).toString());
        txtCargo.setText(Model.getValueAt(linha, 4).toString());
        txtSalario.setText(Model.getValueAt(linha, 5).toString());
        cbxStatus.setSelectedItem(Model.getValueAt(linha, 6).toString());
    }//GEN-LAST:event_tblCadastroMouseClicked

    private void txtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisarActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
        // TODO add your handling code here:
        String Texto = txtPesquisar.getText();

        if (Texto.trim().length() == 0) {
            Pesquisa.setRowFilter(null);
        } else { Pesquisa.setRowFilter(RowFilter.regexFilter("(?i)" + Texto));}
    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (tblCadastro.getSelectedRow() != -1){
        tblCadastro.clearSelection();
        limparCampos();
        }
    }//GEN-LAST:event_formMouseClicked

    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFolha;
    private javax.swing.JButton btnLimpar1;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCadastro;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblCpf1;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNome2;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblCadastro;
    private javax.swing.JTextField txtCargo;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtSalario;
    // End of variables declaration//GEN-END:variables
}