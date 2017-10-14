package View;

import Model.Transicao;
import Model.Estado;
import Model.MaquinaTuring;
import Model.Movimento;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

/**
 * @author deniojunior
 */
public class TabelaTransicao extends javax.swing.JFrame {

    //Table
    private JTable tabela;
    private JScrollPane barraRolagem;
    private String[][] dados;
    private String[] titulo;
    private DefaultTableCellRenderer aEstados, aTransicoes;
    
    private int numQ;
    private int numA;
    private Transicao[][] tabelaTransicao;
    private ArrayList<String> alfaTabela;
    
    private MaquinaTuring mt;
    private Main framePrincipal;

    /** Creates new form TabelaTransicao**/
    public TabelaTransicao(MaquinaTuring mt, Main framePrincipal) {
        initComponents();
        
        getContentPane().setBackground(Color.white);
        
        this.mt = mt;
        this.framePrincipal = framePrincipal;
        
        alfaTabela = new ArrayList<>();

        alfaTabela.add(mt.getSimboloInicioFita());
        
        for(String alfa : mt.getAlfabeto()){
            alfaTabela.add(alfa);
        }
        
        for(String alfa : mt.getAlfabetoAux()){
            if(!alfaTabela.contains(alfa)){
                alfaTabela.add(alfa);
            }
        }
        
        alfaTabela.add(mt.getSimboloBraco());
        
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        numQ = mt.getEstados().size();
        numA = alfaTabela.size();
        
        tabelaTransicao = new Transicao[numQ][numA];
        
        //table
        dados = new String[numQ][numA+1];
        titulo = new String[numA+1];
        
        for (int i = 1; i <= numQ; i++){
            dados[i-1][0] = mt.getEstados().get(i-1).getNome();
        }
        
        titulo[0] = "";
        
        for (int i = 0; i < numA; i++){
            titulo[i+1] = alfaTabela.get(i);
        }
        
        configTable();
    }

    public void configTable(){
        //table
        for (int i = 0; i < numQ; i++){
            for (int j = 1; j <= numA; j++){
                dados[i][j] = " - ";//matriz[i][j-1]; 
            }
        }
        
        tabela = new JTable(dados, titulo);
        
        tabela.setBackground(Color.white);
        
        aEstados = new DefaultTableCellRenderer(){
            public void setValue(Object value){
                setBackground(new Color(238, 238, 238));
                setForeground(Color.BLACK);
                setHorizontalAlignment(JLabel.CENTER);
                super.setValue(value);
   
                
            }
        };
        
        aTransicoes = new DefaultTableCellRenderer(){
          public void setValue(Object value){
              setHorizontalAlignment(JLabel.CENTER);
              super.setValue(value);
          }  
        };
        
        tabela.setRowSelectionAllowed(false);
        tabela.setColumnSelectionAllowed(false);

        barraRolagem = new JScrollPane(tabela);
        barraRolagem.setVisible(true);
        
        barraRolagem.setBackground(Color.white);
        
        jpnPainel.setLayout(new BorderLayout(5,5));      
        jpnPainel.add(barraRolagem, BorderLayout.CENTER); 
        
        ((DefaultTableCellRenderer)tabela.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(SwingConstants.CENTER);  
        
        TableColumn tc = tabela.getColumn("");
        tc.setCellRenderer(aEstados);
        
        for (int i = 0; i < numA ; i++){
            tabela.getColumn(alfaTabela.get(i)).setCellRenderer(aTransicoes);
        }
        
        //table
        add(jpnPainel);
        
        tabela.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable)e.getSource();
                    int linha = target.getSelectedRow();
                    int coluna = target.getSelectedColumn();

                    if(coluna != 0){
                        int pos = 0;
                        
                        FormTransicao ft = new FormTransicao(mt.getEstados().get(linha).getNome(), 
                                alfaTabela.get(coluna-1), mt, alfaTabela, tabelaTransicao, linha, coluna-1);
                        
                        TabelaTransicao.this.setEnabled(false);
                        
                        ft.config(TabelaTransicao.this, linha, coluna);
                        ft.setVisible(true);
                    }
                }
            }
        });
    }
    
    public void add(Estado estado, String escrita, Movimento movimento, int linha, int coluna){
        
        this.setEnabled(true);
        
        Transicao t = new Transicao();
        t.setEstado(estado);
        t.setWrite(escrita);
        t.setMove(movimento);

        tabelaTransicao[linha][coluna-1] = t;
        
        tabela.setValueAt(tabelaTransicao[linha][coluna-1].getEstado().getNome() + 
                ", " + tabelaTransicao[linha][coluna-1].getWrite() + 
                ", " + tabelaTransicao[linha][coluna-1].getMove(), linha, coluna);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbMaquinaTuring = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jpnPainel = new javax.swing.JPanel();
        jbtOk = new javax.swing.JButton();
        jbtVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbMaquinaTuring.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jlbMaquinaTuring.setForeground(new java.awt.Color(44, 44, 44));
        jlbMaquinaTuring.setText("Tabela de Transição(δ)");

        jlbTitulo.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jlbTitulo.setText("Máquina de Turing");

        javax.swing.GroupLayout jpnPainelLayout = new javax.swing.GroupLayout(jpnPainel);
        jpnPainel.setLayout(jpnPainelLayout);
        jpnPainelLayout.setHorizontalGroup(
            jpnPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 622, Short.MAX_VALUE)
        );
        jpnPainelLayout.setVerticalGroup(
            jpnPainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 123, Short.MAX_VALUE)
        );

        jbtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Check.png"))); // NOI18N
        jbtOk.setText("Ok");
        jbtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkActionPerformed(evt);
            }
        });

        jbtVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Back.png"))); // NOI18N
        jbtVoltar.setText("Voltar");
        jbtVoltar.setName(""); // NOI18N
        jbtVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnPainel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbMaquinaTuring)
                .addGap(242, 242, 242))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(134, 134, 134)
                        .addComponent(jbtVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jlbTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbMaquinaTuring)
                .addGap(18, 18, 18)
                .addComponent(jpnPainel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk)
                    .addComponent(jbtVoltar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtVoltarActionPerformed(java.awt.event.ActionEvent evt) {
        int op = JOptionPane.showConfirmDialog(null, "Deseja Voltar?", "Voltar", JOptionPane.YES_NO_OPTION);
        
        if (op == 0){
            framePrincipal.setEnabled(true);
            this.dispose();
        }
    }

    private void jbtOkActionPerformed(java.awt.event.ActionEvent evt) {
        Execucao exe = new Execucao(mt, tabelaTransicao, alfaTabela);
        exe.setVisible(true);
    }

    private javax.swing.JButton jbtOk;
    private javax.swing.JButton jbtVoltar;
    private javax.swing.JLabel jlbMaquinaTuring;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpnPainel;
}