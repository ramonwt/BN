/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Interface;

import BatalhaNaval.classBatalhaNaval;
import BatalhaNaval.classComunicacao;
import javax.swing.JOptionPane;

/**
 *
 * @author ramon
 */
public class telaPrincipal extends javax.swing.JFrame {

    classComunicacao Comunicacao;
    classBatalhaNaval BatalhaNaval;

    /**
     * Creates new form telaPrincipal
     * @param BN
     * @param Comm
     */
    public telaPrincipal(classBatalhaNaval BN, classComunicacao Comm) {
        initComponents();
        this.BatalhaNaval = BN;
        this.Comunicacao = Comm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtLinhaAtaque = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtColunaAtaque = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbAtaque = new javax.swing.JLabel();
        btAtacar = new javax.swing.JButton();
        btStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Posição a atacar");

        jLabel2.setText("Linha");

        jLabel3.setText("Coluna");

        lbAtaque.setText("Aparece a posição do último ataque que aconteceu");

        btAtacar.setText("ATACAR!");
        btAtacar.setEnabled(false);
        btAtacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtacarActionPerformed(evt);
            }
        });

        btStart.setText("Começar");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLinhaAtaque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtColunaAtaque))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAtacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbAtaque)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btStart)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAtacar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtLinhaAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtColunaAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(lbAtaque)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAtacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtacarActionPerformed
        //btAtacar.setEnabled(false);
        String linha = txtLinhaAtaque.getText();
        String coluna = txtColunaAtaque.getText();
        lbAtaque.setText("Ataque: '" + linha + "-" + coluna + "' enviado, esperando os gritos de morte");
        
        
        String resposta = Comunicacao.enviaAtaque("Atacar-" + linha +  "-" + coluna, this);
        if (resposta.equals("errou")) {
            int idNextPlayer = 2;
            JOptionPane.showMessageDialog(this, "Você errou, passando a vez", "Ohh", JOptionPane.INFORMATION_MESSAGE);
            Comunicacao.enviaPassarVez(idNextPlayer);
            btAtacar.setEnabled(false); //Comment
        } else {
            if (resposta.startsWith("meAcertou")) {
                JOptionPane.showMessageDialog(this, "Você acertou o ataque!\nJogue novamente", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
            } else if (resposta.startsWith("morri")) {
                int parametro;
                parametro = Integer.parseInt(resposta.substring(resposta.indexOf("-")+1));
                BatalhaNaval.remPlayer(parametro);
                Comunicacao.enviaMorreu(parametro);
                JOptionPane.showMessageDialog(this, "Você acertou o ataque e eliminou o inimigo de id " + parametro +"!\nJogue novamente", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new UnsupportedOperationException("Not supported yet.");
            }
            //btAtacar.setEnabled(true);
        }
        
        
    }//GEN-LAST:event_btAtacarActionPerformed

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        String idlimites;
        
        Comunicacao.conectarServidor();
        
        
        
        idlimites = Comunicacao.esperaLimites();
        System.out.println(idlimites);
        

        String infoLimites[] = idlimites.split("-");
        BatalhaNaval.setID(infoLimites[0]);
        BatalhaNaval.iniciaMar(infoLimites[1]);
        BatalhaNaval.setMeuEspaco(infoLimites[2], infoLimites[3]);
        
        
        
        //BatalhaNaval.Pronto = false;
        telaPosicionaBarco tPB = new telaPosicionaBarco(this);
        tPB.setVisible(true);
        
        btStart.setEnabled(false);
        
    }//GEN-LAST:event_btStartActionPerformed

    public void setBtAtacar(boolean vl) {
        btAtacar.setEnabled(vl);
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
        new telaPrincipal().setVisible(true);
        }
        });*/
        
        
        classBatalhaNaval batalhaNaval;
        classComunicacao comunicacao;
        
        telaPrincipal tP;
        
        batalhaNaval = new classBatalhaNaval();
        comunicacao = new classComunicacao();
        
        tP = new telaPrincipal(batalhaNaval, comunicacao);
        tP.setVisible(true);
        
        
        
        while (tP.BatalhaNaval.lenVetorOrdem() == 0) {
            try {    Thread.sleep(300);} catch (InterruptedException ex) {}
        }
        //System.out.println(!batalhaNaval.perdi());
        while (!batalhaNaval.perdi()) {
            System.out.println("Eu: " + tP.BatalhaNaval.getID() + " Agora: " + tP.BatalhaNaval.idJogadorAtual());
            
            if (batalhaNaval.minhaVez()) {
                tP.BatalhaNaval.enablePlaying(tP);
                while (tP.btAtacar.isEnabled()) {
                    try {    Thread.sleep(300);} catch (InterruptedException ex) {}
                }
            } else {
                String mensagem = comunicacao.recebeAcao(tP.BatalhaNaval.idJogadorAtual());
                if (mensagem.equals("passarVez")) {
                    batalhaNaval.updtJogadorAtual();
                } else if (mensagem.startsWith("morreu")) {
                    String parametro = mensagem.substring(mensagem.indexOf("-")+1);
                    batalhaNaval.remPlayer(Integer.parseInt(parametro));
                } else if (mensagem.startsWith("ataque")) {
                    /*Responde ataque*/
                    int estragoTiro = tP.BatalhaNaval.recebeTiro(mensagem.split("-")[1], mensagem.split("-")[2]);
                    switch (estragoTiro) {
                    //acertou
                        case 1:
                            comunicacao.enviaMeAcertou(batalhaNaval.getID());
                            break;
                    //morri
                        case 2:
                            comunicacao.enviaMorri(batalhaNaval.getID());
                            break;
                    //nao
                        case 0:
                            comunicacao.enviaErrou(batalhaNaval.getID());
                            break;
                        default:
                            break;
                    }
                    
                    
                }

            }
            
        }
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtacar;
    private javax.swing.JButton btStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbAtaque;
    private javax.swing.JTextField txtColunaAtaque;
    private javax.swing.JTextField txtLinhaAtaque;
    // End of variables declaration//GEN-END:variables

        
    
}