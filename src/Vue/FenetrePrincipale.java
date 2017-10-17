/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Léa
 */
import Controleur.Message;
import Controleur.Observateur;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FenetrePrincipale extends JFrame implements Observateur{
    //modifier les attributs!!
    private Observateur observateur;//observateur de la fenetre est controleur
    private static final long serialVersionUID = 1L;
    private JPanel cardPanel, jp1, jp2, buttonPanel;
    private JLabel jl1, jl2;
    private JButton btn1, btn2;
    private CardLayout cardLayout = new CardLayout();

    public FenetrePrincipale() {
        setTitle("Enigmarium");
        //faire taille ecran
        setSize(400, 300);
        //panel de cards, situer au centre
        cardPanel = new JPanel();
        //panel qui va disparaitre, pour passer d'un monde a un autre
        buttonPanel = new JPanel();
        cardPanel.setLayout(cardLayout);
        //panel 1
        jp1 = new JPanel();
        jl1 = new JLabel("Card 1");
        jp1.add(jl1);
        //panel 2
        jp2 = new JPanel();
        jl2 = new JLabel("Card 2");
        jp2.add(jl2);
        //ajout de la carte 1 au panel
        cardPanel.add(jp1, "1");
        //ajout de la cartye 2 au panel
        cardPanel.add(jp2, "2");
        //def des boutons pour changer
        btn1 = new JButton("Show Card 1");
        btn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "1");
            }
        });
        btn2 = new JButton("Show Card 2");
        btn2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "2");
            }
        });
        buttonPanel.add(btn1);
        buttonPanel.add(btn2);
        add(cardPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    //main pour les test
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                FenetrePrincipale frame = new FenetrePrincipale();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //methode pour ajuter l'observateur
    public void ajouterObservateur(Observateur o){
        this.observateur=o;
    }
    
    //methode de l'observateur
    @Override
    public void notification(Message m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}




//elle est observé par controleur et elle observe ses panels