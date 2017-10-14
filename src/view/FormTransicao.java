package View;

import Model.MaquinaTuring;
import Model.Movimento;
import Model.Transicao;
import java.awt.Color;
import java.util.ArrayList;
    

/**
 * @author deniojunior
 */
public class FormTransicao extends javax.swing.JFrame {

    MaquinaTuring mt;
    TabelaTransicao frameTabela;
    Transicao[][] tabelaTransicao;
    int linha;
    int coluna;

    /** Creates new form FormTransicao **/
    public FormTransicao(String estado, String lendo, 
            MaquinaTuring mt, ArrayList<String> alfaTabela,
            Transicao[][] tabelaTransicao, int linha, int coluna) {
        
        initComponents();
        
        this.mt = mt;
        
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        
        jlbEstado.setText(estado);
        jlbLendo.setText(lendo);
        
        for(int i = 0; i < mt.getEstados().size(); i++){
            jcbTransicao.addItem(mt.getEstados().get(i).getNome());
        }
        
        for(int i = 0; i < alfaTabela.size(); i++){
            jcbEscrever.addItem(alfaTabela.get(i));
        }
        
        jcbMover.addItem("R");
        jcbMover.addItem("L");
        jcbMover.addItem("S");
        
        if(tabelaTransicao[linha][coluna] != null){
            jcbTransicao.setSelectedItem(tabelaTransicao[linha][coluna].getEstado().getNome());
            jcbMover.setSelectedItem(tabelaTransicao[linha][coluna].getMove());
            jcbEscrever.setSelectedItem(tabelaTransicao[linha][coluna].getWrite());
        }
    }

    public void config(TabelaTransicao frameTabela, int linha, int coluna){
        this.frameTabela = frameTabela;
        this.linha = linha;
        this.coluna = coluna;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbTransicao = new javax.swing.JLabel();
        jlbEscrever = new javax.swing.JLabel();
        jlbMover = new javax.swing.JLabel();
        jbtAdd = new javax.swing.JButton();
        jcbEscrever = new javax.swing.JComboBox();
        jcbMover = new javax.swing.JComboBox();
        jcbTransicao = new javax.swing.JComboBox();
        jbtCancelar = new javax.swing.JButton();
        jlbTitEstado = new javax.swing.JLabel();
        jlbTItLendo = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jlbLendo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlbTransicao.setText("Transição:");

        jlbEscrever.setText("Escrever: ");

        jlbMover.setText("Mover: ");

        jbtAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Add.png"))); // NOI18N
        jbtAdd.setText("Adicionar");
        jbtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAddActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Erase.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jlbTitEstado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlbTitEstado.setText("Estado: ");

        jlbTItLendo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlbTItLendo.setText("Lendo: ");

        jlbEstado.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlbEstado.setForeground(new java.awt.Color(28, 25, 164));
        jlbEstado.setText("Q1");

        jlbLendo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jlbLendo.setForeground(new java.awt.Color(233, 1, 24));
        jlbLendo.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbTransicao)
                            .addComponent(jlbMover)
                            .addComponent(jlbEscrever))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jcbEscrever, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbMover, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbTransicao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlbTitEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbTItLendo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbLendo)
                        .addGap(8, 8, 8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbTitEstado)
                    .addComponent(jlbTItLendo)
                    .addComponent(jlbEstado)
                    .addComponent(jlbLendo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbTransicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTransicao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEscrever, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEscrever))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbMover)
                    .addComponent(jcbMover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtAdd)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        frameTabela.setEnabled(true);
        frameTabela.setFocusable(true);
    }

    private void jbtAddActionPerformed(java.awt.event.ActionEvent evt) {

        if(jcbMover.getSelectedIndex() == 0){
            frameTabela.add(mt.getEstados().get(jcbTransicao.getSelectedIndex()),
                (String)jcbEscrever.getSelectedItem(),
                    Movimento.R, 
                        linha, coluna);
        }else if(jcbMover.getSelectedIndex() == 1){
            frameTabela.add(mt.getEstados().get(jcbTransicao.getSelectedIndex()),
                (String)jcbEscrever.getSelectedItem(),
                    Movimento.L, 
                        linha, coluna);
        }else if(jcbMover.getSelectedIndex() == 2){
            frameTabela.add(mt.getEstados().get(jcbTransicao.getSelectedIndex()),
                (String)jcbEscrever.getSelectedItem(),
                    Movimento.S, 
                        linha, coluna);
        }
        
        
        this.dispose();
    }

    private javax.swing.JButton jbtAdd;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JComboBox jcbEscrever;
    private javax.swing.JComboBox jcbMover;
    private javax.swing.JComboBox jcbTransicao;
    private javax.swing.JLabel jlbEscrever;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbLendo;
    private javax.swing.JLabel jlbMover;
    private javax.swing.JLabel jlbTItLendo;
    private javax.swing.JLabel jlbTitEstado;
    private javax.swing.JLabel jlbTransicao;

}