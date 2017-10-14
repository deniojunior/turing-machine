package View;

import Model.Estado;
import Model.MaquinaTuring;
import static Model.TipoEstado.*;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * @author deniojunior
 */
public class Main extends javax.swing.JFrame {
    Border bordaPadrao1, bordaPadrao2;
    boolean inicial = false;
    MaquinaTuring mt;
    
    
    /** Creates new form Main**/
    public Main() {
        initComponents();
        
        getContentPane().setBackground(Color.white); 
        setLocationRelativeTo(null);
        setResizable(false);
                
        mt = new MaquinaTuring();
        jlbMaquina.setText("MT = (Σ, V, Q, δ, I, F, β, ¤)");
        bordaPadrao1 = jtfAlfabeto.getBorder();
        bordaPadrao2 = jtfInicio.getBorder();
        
        jpnMaquina.setBackground(Color.white); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbEstadoI = new javax.swing.JComboBox();
        jcbEstadoF = new javax.swing.JComboBox();
        jlbEstadoF = new javax.swing.JLabel();
        jlbEstadoI = new javax.swing.JLabel();
        jspEstados = new javax.swing.JSpinner();
        jlbEstadossp = new javax.swing.JLabel();
        jlbTitulo = new javax.swing.JLabel();
        jtfInicio = new javax.swing.JTextField();
        jtfBranco = new javax.swing.JTextField();
        jtfAlfabeto = new javax.swing.JTextField();
        jtfAlfabetoAux = new javax.swing.JTextField();
        jbtAlfabetoAux = new javax.swing.JButton();
        jbtAlfaAuxClean = new javax.swing.JButton();
        jbtAlfaClean = new javax.swing.JButton();
        jbtAlfabeto = new javax.swing.JButton();
        jlbAlfabetotf = new javax.swing.JLabel();
        jlbAlfabetoAuxtf = new javax.swing.JLabel();
        jlbBranco = new javax.swing.JLabel();
        jlbInicio = new javax.swing.JLabel();
        jbtOk = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();
        jpnMaquina = new javax.swing.JPanel();
        jlbAlfabeto = new javax.swing.JLabel();
        jlbAlfabetoAux = new javax.swing.JLabel();
        jlbEstados = new javax.swing.JLabel();
        jlbConjInicial = new javax.swing.JLabel();
        jlbConjFinais = new javax.swing.JLabel();
        jlbMaquina = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jcbEstadoI.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jcbEstadoI.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoIItemStateChanged(evt);
            }
        });

        jcbEstadoF.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jcbEstadoF.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbEstadoFItemStateChanged(evt);
            }
        });

        jlbEstadoF.setText("Estados Finais:");

        jlbEstadoI.setText("Estado Inicial:");

        jspEstados.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspEstadosStateChanged(evt);
            }
        });

        jlbEstadossp.setText("Número de Estados: ");

        jlbTitulo.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        jlbTitulo.setText("Máquina de Turing");

        jtfInicio.setText("¤");
        jtfInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfInicioMouseClicked(evt);
            }
        });
        jtfInicio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfInicioFocusGained(evt);
            }
        });
        jtfInicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfInicioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfInicioKeyTyped(evt);
            }
        });

        jtfBranco.setText("β");
        jtfBranco.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfBrancoMouseClicked(evt);
            }
        });
        jtfBranco.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfBrancoFocusGained(evt);
            }
        });
        jtfBranco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfBrancoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBrancoKeyTyped(evt);
            }
        });

        jtfAlfabeto.setCaretColor(new java.awt.Color(1, 1, 1));
        jtfAlfabeto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfAlfabetoMouseClicked(evt);
            }
        });
        jtfAlfabeto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfAlfabetoFocusGained(evt);
            }
        });
        jtfAlfabeto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfAlfabetoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAlfabetoKeyTyped(evt);
            }
        });

        jtfAlfabetoAux.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfAlfabetoAuxMouseClicked(evt);
            }
        });
        jtfAlfabetoAux.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfAlfabetoAuxFocusGained(evt);
            }
        });
        jtfAlfabetoAux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfAlfabetoAuxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfAlfabetoAuxKeyTyped(evt);
            }
        });

        jbtAlfabetoAux.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Add.png"))); // NOI18N
        jbtAlfabetoAux.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlfabetoAuxActionPerformed(evt);
            }
        });

        jbtAlfaAuxClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/remove.png"))); // NOI18N
        jbtAlfaAuxClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlfaAuxCleanActionPerformed(evt);
            }
        });

        jbtAlfaClean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/remove.png"))); // NOI18N
        jbtAlfaClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlfaCleanActionPerformed(evt);
            }
        });

        jbtAlfabeto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Add.png"))); // NOI18N
        jbtAlfabeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlfabetoActionPerformed(evt);
            }
        });

        jlbAlfabetotf.setText("Alfabeto (Σ): ");

        jlbAlfabetoAuxtf.setText("Alfabeto Auxiliar(V): ");

        jlbBranco.setText("Simbolo Branco:");

        jlbInicio.setText("Simbolo inicio de Fita:");

        jbtOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Check.png"))); // NOI18N
        jbtOk.setText("Ok");
        jbtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOkActionPerformed(evt);
            }
        });

        jbtLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/img/Erase.png"))); // NOI18N
        jbtLimpar.setText("Limpar");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        jpnMaquina.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlbAlfabeto.setText("Σ: {}");

        jlbAlfabetoAux.setText("V: {}");

        jlbEstados.setText("Q: {}");

        jlbConjInicial.setText("I :");

        jlbConjFinais.setText("F: {}");

        jlbMaquina.setText("MT = (Σ, V, Q, δ, I, F, β, ¤)");

        javax.swing.GroupLayout jpnMaquinaLayout = new javax.swing.GroupLayout(jpnMaquina);
        jpnMaquina.setLayout(jpnMaquinaLayout);
        jpnMaquinaLayout.setHorizontalGroup(
            jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaquinaLayout.createSequentialGroup()
                .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbConjFinais)
                            .addComponent(jlbConjInicial)
                            .addComponent(jlbAlfabetoAux)
                            .addComponent(jlbAlfabeto)
                            .addComponent(jlbEstados)))
                    .addGroup(jpnMaquinaLayout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jlbMaquina, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnMaquinaLayout.setVerticalGroup(
            jpnMaquinaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMaquinaLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jlbMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbAlfabeto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbAlfabetoAux)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbEstados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbConjInicial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlbConjFinais)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpnMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbInicio)
                            .addComponent(jlbBranco)
                            .addComponent(jlbAlfabetotf)
                            .addComponent(jlbAlfabetoAuxtf))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtfAlfabetoAux, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtAlfabetoAux, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtAlfaAuxClean, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jtfBranco, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfAlfabeto, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(jtfInicio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jbtAlfaClean, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jbtAlfabeto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28)))
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jlbEstadoF))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jlbEstadossp, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jlbEstadoI, javax.swing.GroupLayout.Alignment.TRAILING)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbEstadoI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jcbEstadoF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jspEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(29, 29, 29))
            .addGroup(layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jlbTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jlbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jlbEstadossp)
                            .addComponent(jspEstados))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbEstadoI)
                            .addComponent(jlbEstadoI))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbEstadoF)
                            .addComponent(jcbEstadoF)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jtfInicio)
                            .addComponent(jlbInicio))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbBranco)
                            .addComponent(jtfBranco))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jbtAlfabeto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtAlfaClean, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jlbAlfabetotf)
                                .addComponent(jtfAlfabeto)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtAlfaAuxClean, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtAlfabetoAux))
                        .addComponent(jlbAlfabetoAuxtf))
                    .addComponent(jtfAlfabetoAux))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jpnMaquina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbEstadoIItemStateChanged(java.awt.event.ItemEvent evt) {

        if((!"Selecione".equals((String)jcbEstadoI.getSelectedItem()))
                && (!(jcbEstadoI.getSelectedItem() == null))){
        
            jcbEstadoI.setEnabled(false);

            for(int i = 0; i < mt.getEstados().size(); i++){
                if(mt.getEstados().get(i).getId() == (jcbEstadoI.getSelectedIndex()-1)){
                    
                    if(mt.getEstados().get(i).getTipo() == FINAL){
                        mt.getEstados().get(i).setTipo(INICIAL_FINAL);
                    }else if (mt.getEstados().get(i).getTipo() == INTERMEDIARIO){
                        mt.getEstados().get(i).setTipo(INICIAL);
                    }
                    
                    jlbConjInicial.setText("I : " + mt.getEstados().get(i).getNome());
                    inicial = true;
                }
            }
        }
    }

    private void jtfBrancoKeyTyped(java.awt.event.KeyEvent evt) {
        if(jtfBranco.getText().length() > 0){
            evt.consume();
        }
    }

    private void jtfBrancoKeyReleased(java.awt.event.KeyEvent evt) {
        jtfBranco.setBorder(bordaPadrao2);

        atualizarMT();
    }

    private void jtfBrancoMouseClicked(java.awt.event.MouseEvent evt) {
        jtfBranco.setBorder(bordaPadrao2);
    }

    private void jtfInicioKeyTyped(java.awt.event.KeyEvent evt) {
        if(jtfInicio.getText().length() > 0){
            evt.consume();
        }
    }

    private void jtfInicioKeyReleased(java.awt.event.KeyEvent evt) {
        jtfInicio.setBorder(bordaPadrao2);
        atualizarMT();
    }

    private void jtfInicioMouseClicked(java.awt.event.MouseEvent evt) {
        jtfInicio.setBorder(bordaPadrao2);
    }

    private void jbtAlfaAuxCleanActionPerformed(java.awt.event.ActionEvent evt) {
        if(!mt.getAlfabetoAux().isEmpty()){
            jtfAlfabetoAux.setText("");
            mt.getAlfabetoAux().remove(mt.getAlfabetoAux().size()-1);
            atualizarMT();
        }
    }

    private void jbtAlfaCleanActionPerformed(java.awt.event.ActionEvent evt) {
        if(!mt.getAlfabeto().isEmpty()){
            jtfAlfabeto.setText("");
            mt.getAlfabeto().remove(mt.getAlfabeto().size()-1);
            atualizarMT();
        }
    }

    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {

        jspEstados.setValue(0);
        jtfAlfabeto.setText("");
        jtfAlfabetoAux.setText("");
        jtfBranco.setText("β");
        jtfInicio.setText("¤");
        
        mt.getEstados().removeAll(mt.getEstados());
        mt.getAlfabeto().removeAll(mt.getAlfabeto());
        mt.getAlfabetoAux().removeAll(mt.getAlfabetoAux());
        
        jcbEstadoI.setEnabled(true);
        jcbEstadoI.removeAllItems();
        jcbEstadoF.removeAllItems();
        
        jcbEstadoI.addItem("Selecione");
        jcbEstadoF.addItem("Selecione");
        
        jspEstados.setEnabled(true);
        
        inicial = false;
        
        atualizarMT();
    }

    private void jbtOkActionPerformed(java.awt.event.ActionEvent evt) {

        boolean tudoCerto = true;

        if(jtfInicio.getText().isEmpty()){
            jtfInicio.setBorder(new LineBorder(Color.red));
            tudoCerto = false;
        }

        if(jtfBranco.getText().isEmpty()){
            jtfBranco.setBorder(new LineBorder(Color.red));
            tudoCerto = false;
        }

        if(mt.getAlfabeto().isEmpty()){
            jtfAlfabeto.setBorder(new LineBorder(Color.red));
            tudoCerto = false;
        }

        if(mt.getAlfabetoAux().isEmpty()){
            jtfAlfabetoAux.setBorder(new LineBorder(Color.red));
            tudoCerto = false;
        }
        
        boolean begin = false, end = false;
        
        for(int i = 0; i < mt.getEstados().size(); i++){
            if(mt.getEstados().get(i).getTipo() == INICIAL){
                begin = true;
            }
            
            if(mt.getEstados().get(i).getTipo() == FINAL){
                end = true;
            }
            
            if(mt.getEstados().get(i).getTipo() == INICIAL_FINAL){
                begin = true;
                end = true;
            }
        }
        
        if(mt.getEstados().isEmpty()){
            JOptionPane.showMessageDialog(null, "Insira os estados!", "Erro", JOptionPane.ERROR_MESSAGE);
            tudoCerto = false;
        }
        else if(!begin){
            JOptionPane.showMessageDialog(null, "Selecione o estado inicial!", "Erro", JOptionPane.ERROR_MESSAGE);
            tudoCerto = false;
        }
        else if(!end){
            JOptionPane.showMessageDialog(null, "Selecione os estados finais!", "Erro", JOptionPane.ERROR_MESSAGE);
            tudoCerto = false;
        }
        
        
        if(tudoCerto){
            mt.setSimboloBraco(jtfBranco.getText());
            mt.setSimboloInicioFita(jtfInicio.getText());
            
            TabelaTransicao t = new TabelaTransicao(mt, this);
            
            this.setEnabled(false);
            jspEstados.setEnabled(false);
            
            t.setVisible(true);
        }
    }

    private void jspEstadosStateChanged(javax.swing.event.ChangeEvent evt) {

        int quant = Integer.parseInt(jspEstados.getValue().toString());

        if(quant < 0){
            jspEstados.setValue(0);
        }
        else if(quant > 20){
            jspEstados.setValue(20);
        }
        else{

            if(!inicial){
                jcbEstadoI.removeAllItems();
                jcbEstadoI.addItem("Selecione");
            }
            
            jcbEstadoF.removeAllItems();;
            
            mt.getEstados().removeAll(mt.getEstados());
            

            
            jcbEstadoF.addItem("Selecione");

            for(int i = 0; i < quant; i++){

                Estado e = new Estado();
                e.setId(i);
                e.setNome("Q"+i);
                mt.getEstados().add(e);
                
                if(!inicial){
                    jcbEstadoI.addItem(e.getNome());
                }
                
                jcbEstadoF.addItem(e.getNome());
            }
            
        }

        atualizarMT();
    }

    private void jtfAlfabetoAuxKeyTyped(java.awt.event.KeyEvent evt) {
        if(jtfAlfabetoAux.getText().length() > 0){
            evt.consume();
        }
    }

    private void jtfAlfabetoAuxKeyPressed(java.awt.event.KeyEvent evt) {
        jtfAlfabetoAux.setBorder(bordaPadrao1);

        int tecla = evt.getKeyCode();
        if (tecla == KeyEvent.VK_ENTER){
            jbtAlfabetoAuxActionPerformed(null);
        }
    }

    private void jtfAlfabetoAuxMouseClicked(java.awt.event.MouseEvent evt) {
        jtfAlfabetoAux.setBorder(bordaPadrao1);
    }

    private void jbtAlfabetoAuxActionPerformed(java.awt.event.ActionEvent evt) {
        if(!jtfAlfabetoAux.getText().isEmpty()){
            if(!mt.getAlfabetoAux().contains(jtfAlfabetoAux.getText())){
                mt.getAlfabetoAux().add(jtfAlfabetoAux.getText());
                jtfAlfabetoAux.setText("");
                atualizarMT();
            }else{
                jtfAlfabetoAux.setBorder(new LineBorder(Color.red));
            }
        }else{
            jtfAlfabetoAux.setBorder(new LineBorder(Color.red));
        }
    }

    private void jtfAlfabetoKeyTyped(java.awt.event.KeyEvent evt) {
        if(jtfAlfabeto.getText().length() > 0){
            evt.consume();
        }
    }

    private void jtfAlfabetoKeyPressed(java.awt.event.KeyEvent evt) {
        jtfAlfabeto.setBorder(bordaPadrao1);

        int tecla = evt.getKeyCode();
        
        if (tecla == KeyEvent.VK_ENTER){
            jbtAlfabetoActionPerformed(null);
        }
    }

    private void jtfAlfabetoFocusGained(java.awt.event.FocusEvent evt) {
        jtfAlfabeto.setBorder(bordaPadrao1);
    }

    private void jtfAlfabetoMouseClicked(java.awt.event.MouseEvent evt) {
        jtfAlfabeto.setBorder(bordaPadrao1);
    }

    private void jbtAlfabetoActionPerformed(java.awt.event.ActionEvent evt) {
        if(!jtfAlfabeto.getText().isEmpty()){

            if(!mt.getAlfabeto().contains(jtfAlfabeto.getText())){
                mt.getAlfabeto().add(jtfAlfabeto.getText());
                jtfAlfabeto.setText("");
                atualizarMT();
            }else{
                jtfAlfabeto.setBorder(new LineBorder(Color.red));
            }
        }else{
            jtfAlfabeto.setBorder(new LineBorder(Color.red));
        }
    }

    private void jcbEstadoFItemStateChanged(java.awt.event.ItemEvent evt) {
         if((!"Selecione".equals((String)jcbEstadoF.getSelectedItem()))
                && (!(jcbEstadoF.getSelectedItem() == null))){

            for(int i = 0; i < mt.getEstados().size(); i++){
                if(mt.getEstados().get(i).getId() == (jcbEstadoF.getSelectedIndex()-1)){
                    if(mt.getEstados().get(i).getTipo() == INICIAL){
                        mt.getEstados().get(i).setTipo(INICIAL_FINAL);
                    }else if(mt.getEstados().get(i).getTipo() == INTERMEDIARIO) {
                        mt.getEstados().get(i).setTipo(FINAL);
                    }
                }
            }
        }
         
        atualizarMT();
    }

    private void jtfInicioFocusGained(java.awt.event.FocusEvent evt) {
        jtfInicio.setBorder(bordaPadrao2);
    }

    private void jtfBrancoFocusGained(java.awt.event.FocusEvent evt) {
        jtfBranco.setBorder(bordaPadrao2);
    }

    private void jtfAlfabetoAuxFocusGained(java.awt.event.FocusEvent evt) {
        jtfAlfabetoAux.setBorder(bordaPadrao1);
    }

    public void atualizarMT(){

        String alfabetoMT = "";

        for(int i = 0; i < mt.getAlfabeto().size(); i++){
            if(i == mt.getAlfabeto().size()-1){
                alfabetoMT = alfabetoMT + mt.getAlfabeto().get(i);
            }
            else{
                alfabetoMT = alfabetoMT + mt.getAlfabeto().get(i) + ", ";
            }
        }

        String alfabetoAuxMT = "";

        for(int i = 0; i < mt.getAlfabetoAux().size(); i++){
            if(i == mt.getAlfabetoAux().size()-1){
                alfabetoAuxMT = alfabetoAuxMT + mt.getAlfabetoAux().get(i);
            }
            else{
                alfabetoAuxMT = alfabetoAuxMT + mt.getAlfabetoAux().get(i) + ", ";
            }
        }
        
        String estadosMT = "";

        for(int i = 0; i < mt.getEstados().size(); i++){
            if(i == mt.getEstados().size()-1){
                estadosMT = estadosMT + mt.getEstados().get(i).getNome();
            }
            else{
                estadosMT = estadosMT + mt.getEstados().get(i).getNome() + ", ";
            }
        }
        
        String aux = "";
        String estadoI = "";
        
        for(int i = 0; i < mt.getEstados().size(); i++){
            if((mt.getEstados().get(i).getTipo() == FINAL)
                    ||(mt.getEstados().get(i).getTipo() == INICIAL_FINAL)){
                aux = aux + mt.getEstados().get(i).getNome() + ", ";
            }
            if((mt.getEstados().get(i).getTipo() == INICIAL)
                    ||(mt.getEstados().get(i).getTipo() == INICIAL_FINAL)){
                estadoI = mt.getEstados().get(i).getNome();
            }
        }
        
        String estadosFinais = "";
        for(int i = 0; i < aux.length()-2; i++){
           estadosFinais = estadosFinais + aux.charAt(i);
        }
        
        
        jlbConjFinais.setText("F: {" + estadosFinais + "}");
        jlbConjInicial.setText("I: " + estadoI + "");
        jlbAlfabeto.setText("Σ: {" + alfabetoMT + "}");
        jlbAlfabetoAux.setText("V: {" + alfabetoAuxMT + "}");
        jlbEstados.setText("Q: {" + estadosMT + "}");
        jlbMaquina.setText("MT = (Σ, V, Q, δ, I, F, " + jtfBranco.getText() + ", " + jtfInicio.getText() + ")");
    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jbtAlfaAuxClean;
    private javax.swing.JButton jbtAlfaClean;
    private javax.swing.JButton jbtAlfabeto;
    private javax.swing.JButton jbtAlfabetoAux;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JButton jbtOk;
    private javax.swing.JComboBox jcbEstadoF;
    private javax.swing.JComboBox jcbEstadoI;
    private javax.swing.JLabel jlbAlfabeto;
    private javax.swing.JLabel jlbAlfabetoAux;
    private javax.swing.JLabel jlbAlfabetoAuxtf;
    private javax.swing.JLabel jlbAlfabetotf;
    private javax.swing.JLabel jlbBranco;
    private javax.swing.JLabel jlbConjFinais;
    private javax.swing.JLabel jlbConjInicial;
    private javax.swing.JLabel jlbEstadoF;
    private javax.swing.JLabel jlbEstadoI;
    private javax.swing.JLabel jlbEstados;
    private javax.swing.JLabel jlbEstadossp;
    private javax.swing.JLabel jlbInicio;
    private javax.swing.JLabel jlbMaquina;
    private javax.swing.JLabel jlbTitulo;
    private javax.swing.JPanel jpnMaquina;
    private javax.swing.JSpinner jspEstados;
    private javax.swing.JTextField jtfAlfabeto;
    private javax.swing.JTextField jtfAlfabetoAux;
    private javax.swing.JTextField jtfBranco;
    private javax.swing.JTextField jtfInicio;
}
