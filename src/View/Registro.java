package View;

import Data.PagamentoDAO;
import Model.BeneficioModel;
import Model.DescontoModel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import Model.PagamentoModel;

public class Registro extends javax.swing.JFrame {

    public Registro() {
    initComponents();
    CarregarTabela();
    }
 
    private void CarregarTabela() {
    DefaultTableModel Model = (DefaultTableModel) tblRegistro.getModel();
    Model.setRowCount(0);
    
    PagamentoDAO pagamentodao = new PagamentoDAO();      

    for (PagamentoModel p : pagamentodao.listar()) {
        
        Model.addRow(new Object[]{
            p.getIdPagamento(),
            p.getNomeFuncionario(),
            p.getMes(),
            p.getAno(),
            p.getSalarioMensal(),
            p.getJornada(),
            p.getHorasExtras(),
            p.getBeneficioTotal(),
            p.getSalarioBruto(),
            p.getInss(),
            p.getDescontoTotal(),
            p.getSalarioLiquido(),
            p.getFgts()  
        });
    }
    }
    
    private ArrayList<BeneficioModel> listaBeneficios = new ArrayList<>();
    private ArrayList<DescontoModel> listaDesconto = new ArrayList<>();
    
    private int linhaEmEdicao = -1;
    
    private void pesquisarTabela() {

        DefaultTableModel model = (DefaultTableModel) tblRegistro.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tblRegistro.setRowSorter(sorter);

        String texto = txtPesquisar1.getText().trim();

        if (texto.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
        }
    }
    
    private double calcularINSS(double salario){

        double inss = 0;

        if(salario > 8157.41){
            return 951.63;
        }

        if(salario > 4354.27){
            inss += (salario - 4354.27) * 0.14;
            salario = 4354.27;
        }

        if(salario > 2902.84){
            inss += (salario - 2902.84) * 0.12;
            salario = 2902.84;
        }

        if(salario > 1621.00){
            inss += (salario - 1621.00) * 0.09;
            salario = 1621.00;
        }

        inss += salario * 0.075;

        return inss;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPesquisar = new javax.swing.JTextField();
        lblPesquisar = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblRegistro = new javax.swing.JLabel();
        lblNomeFuncionario = new javax.swing.JLabel();
        txtAno = new javax.swing.JTextField();
        lblMes = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        lblSalario = new javax.swing.JLabel();
        lblInss = new javax.swing.JLabel();
        lblFgts = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnVisualizacao = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtPesquisar1 = new javax.swing.JTextField();
        lblPesquisar1 = new javax.swing.JLabel();
        cbxMes = new javax.swing.JComboBox<>();
        lblAno = new javax.swing.JLabel();
        lblHoras = new javax.swing.JLabel();
        lblHorasV = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        lblSinal1 = new javax.swing.JLabel();
        cbxHoras = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 0), new java.awt.Dimension(250, 32767));
        lblSalarioBruto = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRegistro = new javax.swing.JTable();
        lblSalarioLiquido = new javax.swing.JLabel();
        lblJornada = new javax.swing.JLabel();
        cbxJornada = new javax.swing.JComboBox<>();
        lblAdcionarB = new javax.swing.JLabel();
        txtbeneficio = new javax.swing.JTextField();
        lblSinal3 = new javax.swing.JLabel();
        txtValorbeneficio = new javax.swing.JTextField();
        btnAdicionarB = new javax.swing.JButton();
        btnAdicionarVer = new javax.swing.JButton();
        lblRegistro1 = new javax.swing.JLabel();
        lblDados = new javax.swing.JLabel();
        lblRegistro2 = new javax.swing.JLabel();
        txtValordesconto = new javax.swing.JTextField();
        btnAdicionarD = new javax.swing.JButton();
        btnDescontoVer = new javax.swing.JButton();
        lblAdcionarD = new javax.swing.JLabel();
        txtdesconto = new javax.swing.JTextField();
        lblSinal4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();

        lblNome.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblNome.setText("Nome Completo:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome Completo", "CPF", "Data de Nascimento", "Cargo", "Salário Base", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        lblPesquisar.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        lblPesquisar.setText("Pesquisar");

        jScrollPane3.setViewportView(jTextPane1);

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        lblRegistro.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        lblRegistro.setText("Registro de Pagamentos");

        lblNomeFuncionario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeFuncionario.setText("Nome do Funcionário:");

        txtAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAnoActionPerformed(evt);
            }
        });

        lblMes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblMes.setText("Mês:");

        lblSalario.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSalario.setText("Salário Mensal:");

        lblInss.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblInss.setText("INSS:");

        lblFgts.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblFgts.setText("FGTS:");

        btnSalvar.setBackground(new java.awt.Color(102, 255, 0));
        btnSalvar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnVisualizacao.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnVisualizacao.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizacao.setText("Visualização");
        btnVisualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizacaoActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 102, 255));
        btnEditar.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(255, 0, 0));
        btnExcluir.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtPesquisar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisar1KeyReleased(evt);
            }
        });

        lblPesquisar1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblPesquisar1.setText("Pesquisar");

        cbxMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));
        cbxMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMesActionPerformed(evt);
            }
        });

        lblAno.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblAno.setText("Ano:");

        lblHoras.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblHoras.setText("Horas Extras |");

        lblHorasV.setText("Horas:");

        lblSinal1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblSinal1.setText("+");

        cbxHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "50%", "100%" }));

        lblSalarioBruto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSalarioBruto.setText("Salário  Bruto:");

        tblRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome do Funcionário", "Mês", "Ano", "Salário Mensal", "Jornada Mensal", "Horas Extras", "Total de Benefício", "Salário Bruto", "INSS", "Total de Desconto", "Salário Líquido", "FGTS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRegistro);

        lblSalarioLiquido.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblSalarioLiquido.setText("Salário  Líquido:");

        lblJornada.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblJornada.setText("Jornada Mensal:");

        cbxJornada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "220 Horas", "200 Horas", "180 Horas" }));

        lblAdcionarB.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblAdcionarB.setText("Adicionar Benefício:");

        lblSinal3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblSinal3.setText("+");

        btnAdicionarB.setBackground(new java.awt.Color(102, 255, 0));
        btnAdicionarB.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnAdicionarB.setText("+");
        btnAdicionarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarBActionPerformed(evt);
            }
        });

        btnAdicionarVer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnAdicionarVer.setText("Ver");
        btnAdicionarVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarVerActionPerformed(evt);
            }
        });

        lblRegistro1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblRegistro1.setText("Remuneração");

        lblDados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblDados.setText("Dados");

        lblRegistro2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblRegistro2.setText("Desconto");

        btnAdicionarD.setBackground(new java.awt.Color(102, 255, 0));
        btnAdicionarD.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnAdicionarD.setText("+");
        btnAdicionarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarDActionPerformed(evt);
            }
        });

        btnDescontoVer.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        btnDescontoVer.setText("Ver");
        btnDescontoVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescontoVerActionPerformed(evt);
            }
        });

        lblAdcionarD.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        lblAdcionarD.setText("Adicionar Desconto:");

        lblSinal4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        lblSinal4.setText("+");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblMes)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblAno, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblSalario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lblJornada)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxJornada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(txtPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblPesquisar1))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(btnSalvar)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnVisualizacao)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnEditar)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnExcluir))
                                        .addComponent(lblDados, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(173, 173, 173))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lblNomeFuncionario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtNome)))
                            .addComponent(lblRegistro1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalarioBruto)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblAdcionarB)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtbeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblHoras)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblHorasV, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblSinal1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbxHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSinal3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValorbeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionarB)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionarVer))
                            .addComponent(lblRegistro2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblInss)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAdcionarD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSinal4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtValordesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAdicionarD)
                                .addGap(18, 18, 18)
                                .addComponent(btnDescontoVer))
                            .addComponent(lblSalarioLiquido)
                            .addComponent(lblFgts))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegistro)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblRegistro)
                .addGap(18, 18, 18)
                .addComponent(lblDados)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeFuncionario)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMes)
                            .addComponent(cbxMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAno)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSalario)
                            .addComponent(txtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJornada)
                            .addComponent(cbxJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lblRegistro1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblHoras)
                            .addComponent(lblHorasV)
                            .addComponent(txtHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSinal1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdcionarB)
                            .addComponent(txtbeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSinal3)
                            .addComponent(txtValorbeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdicionarVer))
                        .addGap(18, 18, 18)
                        .addComponent(lblSalarioBruto)
                        .addGap(5, 5, 5)))
                .addGap(18, 18, 18)
                .addComponent(lblRegistro2)
                .addGap(18, 18, 18)
                .addComponent(lblInss)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdcionarD)
                    .addComponent(txtdesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSinal4)
                    .addComponent(txtValordesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescontoVer))
                .addGap(18, 18, 18)
                .addComponent(lblSalarioLiquido)
                .addGap(18, 18, 18)
                .addComponent(lblFgts)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVisualizacao)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPesquisar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        // ----- Dados -----
        String nome = txtNome.getText().trim();
        String mes = cbxMes.getSelectedItem().toString();
        String ano = txtAno.getText().trim();
        String salariotxt = txtSalario.getText().trim();
        String jornadatxt = cbxJornada.getSelectedItem().toString();
        String horastxt = txtHoras.getText().trim();
        String horascbx = cbxHoras.getSelectedItem().toString();
        
        // ----- Validação -----
        if (nome.isEmpty() || mes.equals("Selecione") || ano.isEmpty() || 
        salariotxt.isEmpty() || jornadatxt.equals("Selecione")) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios.");
        return;
        }
        
        double salarioMensal;
        double horasExtras;

        try {
            salarioMensal = Double.parseDouble(salariotxt.replace(",", "."));
            horasExtras = horastxt.isEmpty() ? 0 : Double.parseDouble(horastxt);

        } catch (NumberFormatException e) {

            JOptionPane.showMessageDialog(this, "Digite valores numéricos válidos.");
            return;
        }
        
        // ----- Conversões -----
        int jornada = Integer.parseInt(jornadatxt.replace(" Horas", ""));
                
        // ----- Horas Extras -----
        double valorHora = salarioMensal / jornada;
        double adicional = 0;

        if (horascbx.equals("50%")) {
            adicional = 0.5;
        } else if (horascbx.equals("100%")) {
            adicional = 1.0;
        }

        double valorHoraExtra = valorHora + (valorHora * adicional);
        double totalHorasExtras = horasExtras * valorHoraExtra;
        
        // ----- Salário Bruto -----
        double totalBeneficios = calcularTotalBeneficios();
        double salarioBruto = salarioMensal + totalHorasExtras + totalBeneficios;
        
        // ----- INSS -----
        double totalInss = calcularINSS(salarioBruto);
        
        // ----- Salário Líquido -----
        double salarioLiquido = 0;
        double totalDesconto = calcularTotalDesconto();
        salarioLiquido = salarioBruto - (totalInss + totalDesconto);
        
        // ----- FGTS -----
        double fgts = 0;
        fgts = salarioBruto * 0.08;
        
        // ----- Conversões -----
        salarioMensal = Math.round(salarioMensal * 100.0) / 100.0;
        totalHorasExtras = Math.round(totalHorasExtras * 100.0) / 100.0;
        salarioBruto = Math.round(salarioBruto * 100.0) / 100.0;
        totalInss = Math.round(totalInss * 100.0) / 100.0;
        salarioLiquido = Math.round(salarioLiquido * 100.0) / 100.0;
        fgts = Math.round(fgts * 100.0) / 100.0;
        
        // ----- Cadastrar e Editar -----
        PagamentoDAO pagamentodao = new PagamentoDAO();

        if (linhaEmEdicao != -1) {

            int idPagamento = Integer.parseInt(tblRegistro.getValueAt(linhaEmEdicao, 0).toString());

            PagamentoModel pagamento = new PagamentoModel(
                idPagamento,
                nome,
                PagamentoModel.Mes.valueOf(mes.toUpperCase()),
                ano,
                salarioMensal,
                jornada,
                totalHorasExtras,
                totalBeneficios,
                salarioBruto,
                totalInss,
                totalDesconto,
                salarioLiquido,
                fgts
            );

            pagamentodao.Atualizar(pagamento);
            linhaEmEdicao = -1;

        } else {

            PagamentoModel pagamento = new PagamentoModel(
                nome,
                PagamentoModel.Mes.valueOf(mes.toUpperCase()),
                ano,
                salarioMensal,
                jornada,
                totalHorasExtras,
                totalBeneficios,
                salarioBruto,
                totalInss,
                totalDesconto,
                salarioLiquido,
                fgts
            );

            pagamentodao.Inserir(pagamento);
        }
        CarregarTabela();
                   
        // ----- Mensagem -----
        lblSalarioBruto.setText("Salário Bruto: R$ " + String.format("%.2f", salarioBruto));
        lblInss.setText("INSS: R$ " + String.format("%.2f", totalInss));
        lblSalarioLiquido.setText("Salário Líquido: R$ " + String.format("%.2f", salarioLiquido));
        lblFgts.setText("FGTS: R$ " + String.format("%.2f", fgts));
        
        // ----- Campo Limpo -----
        txtNome.setText("");
        cbxMes.setSelectedIndex(0);
        txtAno.setText("");
        txtSalario.setText("");
        cbxJornada.setSelectedIndex(0);
        txtHoras.setText("");
        cbxHoras.setSelectedIndex(0);
        
        // ----- Ajustes -----
        listaBeneficios.clear();
        listaDesconto.clear();        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnVisualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizacaoActionPerformed
        // TODO add your handling code here:
        int linha = tblRegistro.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) tblRegistro.getModel();

        String nome = model.getValueAt(linha, 1).toString();
        String mes = model.getValueAt(linha, 2).toString();
        String ano = model.getValueAt(linha, 3).toString();

        double salarioBase = Double.parseDouble(model.getValueAt(linha, 4).toString());
        double horasExtras = Double.parseDouble(model.getValueAt(linha, 6).toString());
        double totalBeneficios = Double.parseDouble(model.getValueAt(linha, 7).toString());
        double inss = Double.parseDouble(model.getValueAt(linha, 9).toString());
        double totalDescontos = Double.parseDouble(model.getValueAt(linha, 10).toString());
        double salarioLiquido = Double.parseDouble(model.getValueAt(linha, 11).toString());
        double fgts = Double.parseDouble(model.getValueAt(linha, 12).toString());

        Pagamento tela = new Pagamento();

        tela.preencherFolha(
                nome,
                mes,
                ano,
                salarioBase,
                horasExtras,
                totalBeneficios,
                inss,
                totalDescontos,
                salarioLiquido,
                fgts
        );
        tela.setVisible(true);
    }//GEN-LAST:event_btnVisualizacaoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        // ----- Seleciona -----
        int linha = tblRegistro.getSelectedRow();

        if (linha == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um registro para editar.");
            return;
        }

        linha = tblRegistro.convertRowIndexToModel(linha);
        linhaEmEdicao = linha;
        
        // ----- Tabela Atualizada -----
        DefaultTableModel model = (DefaultTableModel) tblRegistro.getModel();
        
        listaBeneficios.clear();
        listaDesconto.clear();
        
        txtNome.setText(model.getValueAt(linha, 1).toString());
        
        String mes = model.getValueAt(linha, 2).toString();
        mes = mes.substring(0,1).toUpperCase() + mes.substring(1).toLowerCase();
        cbxMes.setSelectedItem(mes);
        
        txtAno.setText(model.getValueAt(linha, 3).toString());
        txtSalario.setText(model.getValueAt(linha, 4).toString());
        
        String jornada = model.getValueAt(linha, 5).toString();
        cbxJornada.setSelectedItem(jornada + " Horas");
        
        txtHoras.setText("");
        cbxHoras.setSelectedIndex(0);

        // ----- Meensagem -----
        JOptionPane.showMessageDialog(
        this,
        "Modo edição ativado.\n\n"
        + "Atenção:\n"
        + "Horas Extras, Benefícios e Descontos foram resetados.\n"
        + "Caso necessário, adicione novamente antes de salvar."
);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        // ----- Selecionar -----
        int linha = tblRegistro.getSelectedRow();
        
        if (linha == -1) {
        JOptionPane.showMessageDialog(this, "Selecione um registro para excluir.");
        return;
        }
              
        int idPagamento = Integer.parseInt(tblRegistro.getValueAt(linha, 0).toString());

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            DefaultTableModel model = (DefaultTableModel) tblRegistro.getModel();
            model.removeRow(linha);

            JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
        }
        
        // ----- DAO -----
        PagamentoDAO pagamentodao = new PagamentoDAO();
        pagamentodao.Excluir(idPagamento);
        CarregarTabela();
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txtAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAnoActionPerformed

    private void cbxMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMesActionPerformed

    private void btnAdicionarVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarVerActionPerformed
        // TODO add your handling code here:
        new Beneficio(listaBeneficios).setVisible(true);     
    }//GEN-LAST:event_btnAdicionarVerActionPerformed

    private void btnAdicionarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarBActionPerformed
        // TODO add your handling code here:        
        String tipo = txtbeneficio.getText().trim();
        String valorTxt = txtValorbeneficio.getText().trim();

        if(tipo.isEmpty() || valorTxt.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha o tipo e o valor do benefício.");
            return;
        }
        try {

            double valor = Double.parseDouble(valorTxt.replace(",", "."));

            BeneficioModel beneficio = new BeneficioModel(tipo, valor);

            listaBeneficios.add(beneficio);

            JOptionPane.showMessageDialog(this, "Benefício adicionado com sucesso!");

            txtbeneficio.setText("");
            txtValorbeneficio.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido.");
        }     
    }//GEN-LAST:event_btnAdicionarBActionPerformed

    private void btnAdicionarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarDActionPerformed
        // TODO add your handling code here:
        String tipoD = txtdesconto.getText().trim();
        String valorTxtD = txtValordesconto.getText().trim();

        if(tipoD.isEmpty() || valorTxtD.isEmpty()){
            JOptionPane.showMessageDialog(this, "Preencha o tipo e o valor do desconto.");
            return;
        }
        try {

            double valorDesconto = Double.parseDouble(valorTxtD.replace(",", "."));

            DescontoModel desconto = new DescontoModel(tipoD, valorDesconto);

            listaDesconto.add(desconto);

            JOptionPane.showMessageDialog(this, "Desconto adicionado com sucesso!");

            txtdesconto.setText("");
            txtValordesconto.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite um valor válido.");
        }
    }//GEN-LAST:event_btnAdicionarDActionPerformed

    private void btnDescontoVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescontoVerActionPerformed
        // TODO add your handling code here:
        new Desconto(listaDesconto).setVisible(true);
    }//GEN-LAST:event_btnDescontoVerActionPerformed

    private void txtPesquisar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisar1KeyReleased
        // TODO add your handling code here:
        pesquisarTabela();
    }//GEN-LAST:event_txtPesquisar1KeyReleased

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (tblRegistro.getSelectedRow() != -1){
        tblRegistro.clearSelection();
        }
    }//GEN-LAST:event_formMouseClicked

    private double calcularTotalBeneficios(){

        double total = 0;

        for(BeneficioModel b : listaBeneficios){
            total += b.getValor();
        }

        return total;
        } 
    
    private double calcularTotalDesconto(){

        double total = 0;

        for(DescontoModel b : listaDesconto){
            total += b.getValor();
        }

        return total;
        }  
    
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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarB;
    private javax.swing.JButton btnAdicionarD;
    private javax.swing.JButton btnAdicionarVer;
    private javax.swing.JButton btnDescontoVer;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVisualizacao;
    private javax.swing.JComboBox<String> cbxHoras;
    private javax.swing.JComboBox<String> cbxJornada;
    private javax.swing.JComboBox<String> cbxMes;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel lblAdcionarB;
    private javax.swing.JLabel lblAdcionarD;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblDados;
    private javax.swing.JLabel lblFgts;
    private javax.swing.JLabel lblHoras;
    private javax.swing.JLabel lblHorasV;
    private javax.swing.JLabel lblInss;
    private javax.swing.JLabel lblJornada;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFuncionario;
    private javax.swing.JLabel lblPesquisar;
    private javax.swing.JLabel lblPesquisar1;
    private javax.swing.JLabel lblRegistro;
    private javax.swing.JLabel lblRegistro1;
    private javax.swing.JLabel lblRegistro2;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JLabel lblSalarioBruto;
    private javax.swing.JLabel lblSalarioLiquido;
    private javax.swing.JLabel lblSinal1;
    private javax.swing.JLabel lblSinal3;
    private javax.swing.JLabel lblSinal4;
    private javax.swing.JTable tblRegistro;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisar;
    private javax.swing.JTextField txtPesquisar1;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtValorbeneficio;
    private javax.swing.JTextField txtValordesconto;
    private javax.swing.JTextField txtbeneficio;
    private javax.swing.JTextField txtdesconto;
    // End of variables declaration//GEN-END:variables
}