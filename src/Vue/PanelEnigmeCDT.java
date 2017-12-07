/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controleur.Message;
import Controleur.Observateur;
import Modele.EnigmeChampsDeTexte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author Léa
 */
public class PanelEnigmeCDT extends javax.swing.JPanel {

    /**
     * Creates new form PanelEnigmeCDT
     */
    private Observateur observateur;
    
    public PanelEnigmeCDT(EnigmeChampsDeTexte e, int largeur, int hauteur) {
        initComponents();
        this.setSize(largeur, hauteur);
        question.setText(e.getQuestion());
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Message m = new Message();
                m.setAtt1(reponse.getText());
                observateur.notification(m);
            }
            
        });
    }
    
    public void setObservateur(Observateur observateur) {
        this.observateur = observateur;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        valider = new javax.swing.JButton();
        reponse = new javax.swing.JTextField();
        question = new javax.swing.JLabel();

        valider.setText("Valider");

        reponse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reponseActionPerformed(evt);
            }
        });

        question.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        question.setText("---");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(valider)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reponse, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(question, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(question)
                .addGap(33, 33, 33)
                .addComponent(reponse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(valider)
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void reponseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reponseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reponseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel question;
    private javax.swing.JTextField reponse;
    private javax.swing.JButton valider;
    // End of variables declaration//GEN-END:variables
}
