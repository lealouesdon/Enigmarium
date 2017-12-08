/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;
import java.sql.*;
/**
 *
 * @author Léa
 */
public class Connexion {
    
    public static void main(String[] args) {   
        
    }
    public static Connection ConnecterDB(){
    try {
      //Class.forName("com.mysql.jdbc.Driver"); /* chemin du driver*/
      System.out.println("Driver O.K.");

      String url = "jdbc:postgresql://localhost:5432/Ecole"; /* url a changer en fonctio de la base 
      2-> localisation de la machine physique sur le reseau plus port
      3-> nom de la base de données*/
      String user = "postgres";
      String passwd = "postgres";

      Connection conn = DriverManager.getConnection(url, user, passwd);
      System.out.println("Connexion effective !");   
      return conn;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }      
  }
}

