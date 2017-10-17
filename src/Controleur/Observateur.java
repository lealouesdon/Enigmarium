/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

/**
 *
 * @author Léa
 */
public interface Observateur
{
        // Méthode appelée automatiquement lors de la reception d'un message
        public void notification(Message m);
}
