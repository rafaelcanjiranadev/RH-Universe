package View;

import Model.LoginModel;
import Model.BeneficioModel;
import Model.DescontoModel;
import java.util.ArrayList;

public class Pagamento extends javax.swing.JFrame {

    public Pagamento() {
        initComponents();
    }
    
    private ArrayList<BeneficioModel> listaBeneficios;
    private ArrayList<DescontoModel> listaDescontos;
    private javax.swing.JPanel painelBeneficios;
    private javax.swing.JPanel painelDescontos;
    
    private LoginModel usuarioLogado;

    public Pagamento(LoginModel usuario) {
    this.usuarioLogado = usuario;
        initComponents();
    }

    public void preencherFolha(String nome, String mes, String ano,
    double salarioBase, double horasExtras, double totalBeneficios,
    double inss, double totalDescontos, double salarioLiquido,
    double fgts) {

    lblNome.setText("Nome Completo: " + nome);
    lblMes.setText("Mês: " + mes);
    lblAno.setText("Ano: " + ano);

    lblSalario.setText("Salário Base: R$ " + String.format("%.2f", salarioBase));
    lblHoraExtra.setText("Horas Extras: R$ " + String.format("%.2f", horasExtras));
    lblBeneficio.setText("Total Benefício: R$ " + String.format("%.2f", totalBeneficios));
    lblDesconto.setText("Total Desconto: R$ " + String.format("%.2f", totalDescontos));
    lblInss.setText("INSS: R$ " + String.format("%.2f", inss));
    lblSalarioLiquido.setText("Salário Líquido: R$ " + String.format("%.2f", salarioLiquido));
    lblFgts.setText("FGTS: R$ " + String.format("%.2f", fgts));
    
    double totalRemuneracao = 0;
    totalRemuneracao = salarioBase + horasExtras + totalBeneficios;
    lblVenctos.setText("Total Venctos Folha Pagto: R$ " + String.format("%.2f", totalRemuneracao));
    
    double totalDesconto = 0;
    totalDesconto = inss + totalDescontos;
    lblDesctos.setText("Total Desctos Folha Pagto: R$ " + String.format("%.2f", totalDesconto));
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFolha = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblAno = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblSalario = new javax.swing.JLabel();
        lblHoraExtra = new javax.swing.JLabel();
        lblBeneficio = new javax.swing.JLabel();
        lblVenctos = new javax.swing.JLabel();
        lblInss = new javax.swing.JLabel();
        lblDesconto = new javax.swing.JLabel();
        lblDesctos = new javax.swing.JLabel();
        lblSalarioLiquido = new javax.swing.JLabel();
        lblFgts = new javax.swing.JLabel();
        lblDesconta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblFolha.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        lblFolha.setText("Folha de Pagamento ");

        lblMes.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblMes.setText("Mês:");

        lblNome.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblNome.setText("Nome Completo:");

        lblAno.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblAno.setText("Ano:");

        lblDescricao.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDescricao.setForeground(new java.awt.Color(0, 0, 0));
        lblDescricao.setText("Descrição");

        lblSalario.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblSalario.setText("Salário Base:");

        lblHoraExtra.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblHoraExtra.setText("Horas Extras:");

        lblBeneficio.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblBeneficio.setText("Benefìcio:");

        lblVenctos.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblVenctos.setForeground(new java.awt.Color(0, 0, 0));
        lblVenctos.setText("Total Venctos Folha Pagto:");

        lblInss.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblInss.setText("INSS:");

        lblDesconto.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblDesconto.setText("Desconto:");

        lblDesctos.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblDesctos.setForeground(new java.awt.Color(0, 0, 0));
        lblDesctos.setText("Total Desctos Folha Pagto:");

        lblSalarioLiquido.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblSalarioLiquido.setForeground(new java.awt.Color(0, 0, 0));
        lblSalarioLiquido.setText("Salário Líquido:");

        lblFgts.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblFgts.setForeground(new java.awt.Color(0, 0, 0));
        lblFgts.setText("FGTS:");

        lblDesconta.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        lblDesconta.setForeground(new java.awt.Color(0, 0, 0));
        lblDesconta.setText("Desconto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFolha)
                            .addComponent(lblNome))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAno)
                            .addComponent(lblMes)))
                    .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSalario)
                    .addComponent(lblHoraExtra)
                    .addComponent(lblBeneficio)
                    .addComponent(lblVenctos)
                    .addComponent(lblInss)
                    .addComponent(lblDesconto)
                    .addComponent(lblDesctos)
                    .addComponent(lblSalarioLiquido)
                    .addComponent(lblFgts)
                    .addComponent(lblDesconta, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFolha)
                    .addComponent(lblMes))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(lblAno))
                .addGap(18, 18, 18)
                .addComponent(lblDescricao)
                .addGap(18, 18, 18)
                .addComponent(lblSalario)
                .addGap(18, 18, 18)
                .addComponent(lblHoraExtra)
                .addGap(18, 18, 18)
                .addComponent(lblBeneficio)
                .addGap(18, 18, 18)
                .addComponent(lblVenctos)
                .addGap(18, 18, 18)
                .addComponent(lblDesconta)
                .addGap(18, 18, 18)
                .addComponent(lblInss)
                .addGap(18, 18, 18)
                .addComponent(lblDesconto)
                .addGap(18, 18, 18)
                .addComponent(lblDesctos)
                .addGap(18, 18, 18)
                .addComponent(lblSalarioLiquido)
                .addGap(18, 18, 18)
                .addComponent(lblFgts)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblBeneficio;
    private javax.swing.JLabel lblDesconta;
    private javax.swing.JLabel lblDesconto;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDesctos;
    private javax.swing.JLabel lblFgts;
    private javax.swing.JLabel lblFolha;
    private javax.swing.JLabel lblHoraExtra;
    private javax.swing.JLabel lblInss;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSalarioLiquido;
    private javax.swing.JLabel lblVenctos;
    // End of variables declaration//GEN-END:variables
}
