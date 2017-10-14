package View;

import Model.Estado;
import Model.MaquinaTuring;
import Model.Movimento;
import static Model.TipoEstado.*;
import Model.Transicao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;


/**
 * @author deniojunior
 */
public class Execucao extends javax.swing.JFrame {

    private JTable fita;
    private JScrollPane barraRolagem;
    
    private MaquinaTuring mt;
    private Transicao[][]tabelaTransicao;
    private Estado estadoAtual;
    private ArrayList<String> alfaTabela;
    
    Border bordaPadrao;
    int tam = 500;
    int cabecote = (tam/2)-1;
    
    String lendo = "";
    int pos = 0;
    Transicao t = null;
    String palavra = "";
    
    boolean first = true;

    /** Creates new form Execucao **/
    public Execucao(MaquinaTuring mt, Transicao[][] tabelaTransicao, ArrayList<String> alfaTabela) {
        initComponents();
    
        lendo = "";
        pos = 0;
        t = null;
        
        this.mt = mt;
        this.tabelaTransicao = tabelaTransicao;
        this.alfaTabela = alfaTabela;
        
        bordaPadrao = jtfPalavra.getBorder();
        
        getContentPane().setBackground(Color.white);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        int i = 0;
        
        for(i = 0; i < mt.getEstados().size(); i++){
            if(mt.getEstados().get(i).getTipo() == INICIAL
                    || mt.getEstados().get(i).getTipo() == INICIAL_FINAL){
                
                estadoAtual = mt.getEstados().get(i);
                break;
            }
        }
        
        //jlbCabecote.setBounds(200, 35, 27, 24);
        jlbAceita.setBounds(257, 170, 250, 25);
        jlbRejeita.setBounds(245, 170, 300, 25);
        jlbImgEstado.setBounds(330, 80, 50, 50);
        jlbImgFinal.setBounds(325, 80, 50, 50);
        jlbImgInicial.setBounds(305, 80, 50, 50);
        jlbEstadoAtual.setBounds(321, 125, 80, 18);
        jckBarraRolagem.setBounds(10, 60, 180, 20);
        
        if(i >= 10){
            jlbEstado.setBounds(336, 94, 50, 20);
        }else{
            jlbEstado.setBounds(340, 94, 50, 20);
        }
        jlbCabecote.setVisible(false);
        jlbImgEstado.setVisible(true);
        jlbImgInicial.setVisible(false);
        jlbEstado.setVisible(true); 
        jlbEstadoAtual.setVisible(true);
        jckBarraRolagem.setVisible(true);
        jlbAceita.setVisible(false);
        jlbRejeita.setVisible(false);
        
        jlbImgFinal.setVisible(false);
        
        jpnMaquina.add(jlbImgEstado);
        jpnMaquina.add(jlbImgFinal);
        jpnMaquina.add(jlbImgInicial);
        jpnMaquina.add(jlbEstado);
        //jpnMaquina.add(jlbCabecote);
        jpnMaquina.add(jlbEstadoAtual);
        jpnMaquina.add(jckBarraRolagem);
        jpnMaquina.add(jlbAceita);
        jpnMaquina.add(jlbRejeita);
        
        jpnMaquina.setBackground(Color.white);
        jpnMaquina.repaint();
        
        configTable();
        
        jlbEstado.setText(estadoAtual.getNome());
        
        if(estadoAtual.getTipo() == FINAL){
            jlbImgFinal.setVisible(true);
        }else{
            jlbImgFinal.setVisible(false);
        }
        
        if(estadoAtual.getTipo() == INICIAL){
            jlbImgInicial.setVisible(true);
        }else{
            jlbImgInicial.setVisible(false);
        }
    }

    public void configTable(){
        //table
        DefaultTableCellRenderer borda;
        
        String[] titulo = new String[tam];
        String[][] dados = new String[1][tam];
        
        for(int i = 0; i < tam; i++){
            dados[0][i] = mt.getSimboloBraco();
            titulo[i] = ""+i;
        }
        
        dados[0][((tam/2)-1)] = mt.getSimboloInicioFita();
        cabecote = ((tam/2)-1);
        
        fita = new JTable(dados, titulo);
        
        fita.setRowSelectionAllowed(false);
        fita.setColumnSelectionAllowed(false);
        fita.setEnabled(false);
        fita.setVisible(true);
        fita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        fita.setCellSelectionEnabled(true);
        
        fita.changeSelection(0, cabecote, false, false);

        borda = new DefaultTableCellRenderer(){
             public void setValue(Object value){
                setForeground(Color.BLACK);
                setHorizontalAlignment(JLabel.CENTER);
                setBorder(BorderFactory.createLineBorder(Color.BLACK));
                super.setValue(value);
            }
        };
        
        TableColumn tc;
        
        for(int i = 0; i < tam; i++){
            tc = fita.getColumn(""+i);
            tc.setCellRenderer(borda);
            tc.setPreferredWidth(30); //Largura da Celula
        }
        
        changeCellSelectedColor(true);
        
        fita.setTableHeader(null);
        
        barraRolagem = new JScrollPane(fita);
        barraRolagem.setBounds(10, 16, 678, 40);//23
        barraRolagem.setVisible(true);
        barraRolagem.scrollRectToVisible(barraRolagem.getBounds());  
        barraRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        barraRolagem.getHorizontalScrollBar().setEnabled(false);
        barraRolagem.getVerticalScrollBar().setEnabled(false);
        barraRolagem.getViewport().getView().setEnabled(false);
        //Posiciona ScrollBar no centro
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() { 
               barraRolagem.getHorizontalScrollBar().setValue(((barraRolagem.getHorizontalScrollBar().getMaximum()/2)-(30*12))+10);
               //30 é o tamanho da célula e o inicio está em ((tam/2)-1)
               //para ficar no centro é necessário pular 12 celulas
               //por isso 30*12
               //mais 15 pra ficar totalmente alinhado
            }
        });
         
        jpnMaquina.add(barraRolagem, BorderLayout.CENTER);
 
        //table
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnMaquina = new javax.swing.JPanel();
        jlbCabecote = new javax.swing.JLabel();
        jlbEstado = new javax.swing.JLabel();
        jlbImgEstado = new javax.swing.JLabel();
        jlbImgFinal = new javax.swing.JLabel();
        jlbImgInicial = new javax.swing.JLabel();
        jlbEstadoAtual = new javax.swing.JLabel();
        jckBarraRolagem = new javax.swing.JCheckBox();
        jlbAceita = new javax.swing.JLabel();
        jlbRejeita = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jtfPalavra = new javax.swing.JTextField();
        jlbPalavra = new javax.swing.JLabel();
        jbtStep = new javax.swing.JButton();
        jbtExecutar = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnMaquina.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlbCabecote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCabecote.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Up.png"))); // NOI18N

        jlbEstado.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jlbEstado.setForeground(new java.awt.Color(10, 56, 7));
        jlbEstado.setText("Q1");

        jlbImgEstado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/circulo1.png"))); // NOI18N

        jlbImgFinal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/final1.gif"))); // NOI18N

        jlbImgInicial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/inicial.png"))); // NOI18N

        jlbEstadoAtual.setFont(new java.awt.Font("Cantarell", 2, 10)); // NOI18N
        jlbEstadoAtual.setText("Estado Atual");

        jckBarraRolagem.setText("Barra de Rolagem");
        jckBarraRolagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jckBarraRolagemMouseClicked(evt);
            }
        });

        jlbAceita.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jlbAceita.setForeground(new java.awt.Color(0, 107, 8));
        jlbAceita.setText("PALAVRA ACEITA");

        jlbRejeita.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jlbRejeita.setForeground(new java.awt.Color(255, 0, 9));
        jlbRejeita.setText("PALAVRA REJEITADA");

        javax.swing.GroupLayout jpnMaquinaLayout = new javax.swing.GroupLayout(jpnMaquina);
        jpnMaquina.setLayout(jpnMaquinaLayout);
        jpnMaquinaLayout.setHorizontalGroup(
            jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaquinaLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jlbEstado)
                .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(jlbCabecote))
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbAceita)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbImgFinal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbImgEstado)
                .addGap(18, 18, 18)
                .addComponent(jlbImgInicial)
                .addGap(7, 7, 7))
            .addGroup(jpnMaquinaLayout.createSequentialGroup()
                .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jckBarraRolagem))
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addGap(304, 304, 304)
                        .addComponent(jlbEstadoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(287, Short.MAX_VALUE))
            .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMaquinaLayout.createSequentialGroup()
                    .addContainerGap(232, Short.MAX_VALUE)
                    .addComponent(jlbRejeita)
                    .addGap(207, 207, 207)))
        );
        jpnMaquinaLayout.setVerticalGroup(
            jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaquinaLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jckBarraRolagem)
                .addGap(17, 17, 17)
                .addComponent(jlbEstadoAtual)
                .addGap(23, 23, 23)
                .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbImgEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbImgFinal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbImgInicial, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMaquinaLayout.createSequentialGroup()
                        .addComponent(jlbAceita)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbCabecote)))
                .addContainerGap())
            .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnMaquinaLayout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(jlbRejeita)
                    .addGap(25, 25, 25)))
        );

        jlbTitulo.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jlbTitulo.setText("Máquina de Turing");

        jtfPalavra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfPalavraMouseClicked(evt);
            }
        });
        jtfPalavra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfPalavraFocusGained(evt);
            }
        });
        jtfPalavra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfPalavraKeyTyped(evt);
            }
        });

        jlbPalavra.setText("Entrada: ");

        jbtStep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Step.png"))); // NOI18N
        jbtStep.setText("Step");
        jbtStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStepActionPerformed(evt);
            }
        });

        jbtExecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Play.png"))); // NOI18N
        jbtExecutar.setText("Executar");
        jbtExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExecutarActionPerformed(evt);
            }
        });

        jbtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Erase.png"))); // NOI18N
        jbtLimpar.setText("Limpar");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpnMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jlbTitulo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbPalavra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtStep, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtExecutar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbPalavra)
                        .addComponent(jbtStep)
                        .addComponent(jbtExecutar)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtStepActionPerformed(java.awt.event.ActionEvent evt) {
        threadSleep ts = new threadSleep();
        Thread t1 = new Thread (ts);
        t1.start();
    }

    private void jbtExecutarActionPerformed(java.awt.event.ActionEvent evt) {

        palavra = jtfPalavra.getText();
        
        //if(verificaEntrada(palavra)){
            
            jtfPalavra.setEditable(false);
            jbtExecutar.setEnabled(false);
            jbtStep.setEnabled(false);
            
            for(int i = (tam/2); i < (tam/2)+palavra.length(); i++){
                fita.setValueAt(""+palavra.charAt(i-(tam/2)), 0, i);
            }
                
            //direita();
            lendo = (String)fita.getValueAt(0, cabecote);
            pos = 0;

            for(int i = 0; i < alfaTabela.size(); i++){
                if (alfaTabela.get(i).equals(lendo)){
                    pos = i;
                    break;
                }
            }
            
            while(tabelaTransicao[estadoAtual.getId()][pos] != null){

                t = tabelaTransicao[estadoAtual.getId()][pos];

                fita.setValueAt(t.getWrite(), 0, cabecote);
                estadoAtual = t.getEstado();

                if(t.getMove() == Movimento.R){
                    direita();
                }else if(t.getMove() == Movimento.L){
                    esquerda();
                }


                //----DESENHO----------------------------
                jlbEstado.setText(estadoAtual.getNome());

                if(estadoAtual.getTipo() == FINAL){
                    jlbImgFinal.setVisible(true);
                }else{
                    jlbImgFinal.setVisible(false);
                }

                if(estadoAtual.getTipo() == INICIAL){
                    jlbImgInicial.setVisible(true);
                }else{  
                    jlbImgInicial.setVisible(false);
                }
                //----------------------------------
                    
                lendo = (String)fita.getValueAt(0, cabecote);
                pos = 0;

                for(int i = 0; i < alfaTabela.size(); i++){
                    if (alfaTabela.get(i).equals(lendo)){
                        pos = i;
                        break;
                    }
                }
            }
            
            if(estadoAtual.getTipo() == FINAL
                            || estadoAtual.getTipo() == INICIAL_FINAL){

                jlbAceita.setVisible(true);
                jbtStep.setEnabled(false);
            }
            else{    
                jlbRejeita.setVisible(true);
                jbtStep.setEnabled(false);
            }
        //}
    }

    private void jtfPalavraKeyTyped(java.awt.event.KeyEvent evt) {

        jtfPalavra.setBorder(bordaPadrao);
        
        if(!mt.getAlfabeto().contains(""+evt.getKeyChar())){
            evt.consume();
        }
    }

    private void jtfPalavraMouseClicked(java.awt.event.MouseEvent evt) {
        jtfPalavra.setBorder(bordaPadrao);
    }

    private void jtfPalavraFocusGained(java.awt.event.FocusEvent evt) {
        jtfPalavra.setBorder(bordaPadrao);
    }

    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {
        changeCellSelectedColor(false);
        
        jlbAceita.setVisible(false);
        jlbRejeita.setVisible(false);
        
        jtfPalavra.setEditable(true);
        jtfPalavra.setText("");
        
        jbtExecutar.setEnabled(true);
        jbtStep.setEnabled(true);
        
        first = true;
        
        for(int i = 0; i < mt.getEstados().size(); i++){
            if(mt.getEstados().get(i).getTipo() == INICIAL
                    || mt.getEstados().get(i).getTipo() == INICIAL_FINAL){
                
                estadoAtual = mt.getEstados().get(i);
                break;
            }
        }
        
        jlbEstado.setText(estadoAtual.getNome());
        
        if(estadoAtual.getTipo() == FINAL){
            jlbImgFinal.setVisible(true);
        }else{
            jlbImgFinal.setVisible(false);
        }
        
        if(estadoAtual.getTipo() == INICIAL){
            jlbImgInicial.setVisible(true);
        }else{
            jlbImgInicial.setVisible(false);
        }
        
        for(int i = 0; i < tam; i++){
            fita.setValueAt(mt.getSimboloBraco(), 0, i);
        }
        
        fita.setValueAt(mt.getSimboloInicioFita(), 0, ((tam/2)-1));
        
        cabecote = ((tam/2)-1);
        
        fita.changeSelection(0, cabecote, false, false);
        changeCellSelectedColor(true);
        
        barraRolagem.getHorizontalScrollBar().setValue(((barraRolagem.getHorizontalScrollBar().getMaximum()/2)-(30*12))+10);
    }

    private void jckBarraRolagemMouseClicked(java.awt.event.MouseEvent evt) {
        if(jckBarraRolagem.isSelected()){
            barraRolagem.getHorizontalScrollBar().setEnabled(true);
            barraRolagem.getVerticalScrollBar().setEnabled(true);
            barraRolagem.getViewport().getView().setEnabled(true);
        }else{
            barraRolagem.getHorizontalScrollBar().setEnabled(false);
            barraRolagem.getVerticalScrollBar().setEnabled(false);
            barraRolagem.getViewport().getView().setEnabled(false);
            barraRolagem.getHorizontalScrollBar().setValue(((barraRolagem.getHorizontalScrollBar().getMaximum()/2)-(30*12)+10)+(((cabecote*30)-barraRolagem.getHorizontalScrollBar().getMaximum()/2)+30));
        }
    }

    public void direita(){   
        changeCellSelectedColor(false);
        barraRolagem.getHorizontalScrollBar().setValue(barraRolagem.getHorizontalScrollBar().getValue()+30);
        cabecote = cabecote + 1;
        fita.changeSelection(0, cabecote, false, false);
        changeCellSelectedColor(true);
    }
    
    public void esquerda(){
        changeCellSelectedColor(false);
        barraRolagem.getHorizontalScrollBar().setValue(barraRolagem.getHorizontalScrollBar().getValue()-30);
        cabecote = cabecote - 1;
        fita.changeSelection(0, cabecote, false, false);
        changeCellSelectedColor(true);
    }
    
//    private boolean verificaEntrada(String palavra){
//        //Implementar testes
//        //so aceita caracteres pertencentes ao alfabeto
//        boolean ok = true;
//        if(palavra.equals("")){
//            jtfPalavra.setBorder(new LineBorder(Color.red));
//            ok = false;
//            
//            
//        }
//        return(true);
//    }
    
    public void changeCellSelectedColor(boolean white){
        DefaultTableCellRenderer borda;
        TableColumn tc;
        tc = fita.getColumn(""+cabecote);
        
        if(white){
            borda = new DefaultTableCellRenderer(){
                 public void setValue(Object value){
                    setForeground(Color.WHITE);
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    super.setValue(value);
                }
            };
            
            tc.setCellRenderer(borda);
        }else{
            borda = new DefaultTableCellRenderer(){
                 public void setValue(Object value){
                    setForeground(Color.BLACK);
                    setHorizontalAlignment(JLabel.CENTER);
                    setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    super.setValue(value);
                }
            };
            
            tc.setCellRenderer(borda);
        }
    }

    private javax.swing.JButton jbtExecutar;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JButton jbtStep;
    private javax.swing.JCheckBox jckBarraRolagem;
    private javax.swing.JLabel jlbAceita;
    private javax.swing.JLabel jlbCabecote;
    private javax.swing.JLabel jlbEstado;
    private javax.swing.JLabel jlbEstadoAtual;
    private javax.swing.JLabel jlbImgEstado;
    private javax.swing.JLabel jlbImgFinal;
    private javax.swing.JLabel jlbImgInicial;
    private javax.swing.JLabel jlbPalavra;
    private javax.swing.JLabel jlbRejeita;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpnMaquina;
    private javax.swing.JTextField jtfPalavra;

    class threadSleep implements Runnable{

        @Override
        public void run() {
            try{
                if(first){
                    palavra = jtfPalavra.getText();

                    //if(verificaEntrada(palavra)){
                        first = false;

                        jtfPalavra.setEditable(false);
                        jbtExecutar.setEnabled(false);

                        for(int i = (tam/2); i < (tam/2)+palavra.length(); i++){
                            fita.setValueAt(""+palavra.charAt(i-(tam/2)), 0, i);
                        }

                        //direita();
                    //}
                }else{                
                    lendo = (String)fita.getValueAt(0, cabecote);
                    pos = 0;

                    for(int i = 0; i < alfaTabela.size(); i++){
                        if (alfaTabela.get(i).equals(lendo)){
                            pos = i;
                            break;
                        }
                    }

                    t = tabelaTransicao[estadoAtual.getId()][pos];

                    if(t != null){
                        
                        changeCellSelectedColor(true);
                        fita.setValueAt(t.getWrite(), 0, cabecote);
                        changeCellSelectedColor(true);
                        
                        Thread.sleep(500);

                        estadoAtual = t.getEstado();
                        
                        if(t.getMove() == Movimento.R){
                            direita();
                            
                        }else if(t.getMove() == Movimento.L){
                            esquerda();
                        }


                        //----DESENHO----------------------------
                        jlbEstado.setText(estadoAtual.getNome());

                        if(estadoAtual.getTipo() == FINAL){
                            jlbImgFinal.setVisible(true);
                        }else{
                            jlbImgFinal.setVisible(false);
                        }

                        if(estadoAtual.getTipo() == INICIAL){
                            jlbImgInicial.setVisible(true);
                        }else{  
                            jlbImgInicial.setVisible(false);
                        }
                        //----------------------------------
                    }else{
//                        boolean acabou = false;
//                        for(int i = cabecote; i < tam; i++){
//                            
//                        }
                        
                        if(estadoAtual.getTipo() == FINAL
                                || estadoAtual.getTipo() == INICIAL_FINAL){

                            jlbAceita.setVisible(true);
                            jbtStep.setEnabled(false);
                        }
                        else{    
                            jlbRejeita.setVisible(true);
                            jbtStep.setEnabled(false);
                        }
                    }
                }
              }
              catch(InterruptedException e){
                System.out.println(e.getMessage()); 
              }      
        }
        
    }
    
}