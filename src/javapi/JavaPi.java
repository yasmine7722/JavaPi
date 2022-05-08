/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapi;
import Entity.Event;
import Entity.Exercice;
import Entity.ProgMuscul;
import Entity.Utilisateur;
import Entity.ProgNutri;
import Entity.Repas;
import Service.ServiceEvent;
import Service.ServiceExercice;
import Service.ServiceMuscul;
import Service.ServiceNutri;
import Service.ServiceRepas;
import Service.ServiceUtilisateur;
import Util.DataSource;
/**
 *
 * @author toshiba
 */
public class JavaPi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        DataSource db = DataSource.getInstance();
        System.out.println(db);
       
//Ajouter un programme nutrition
       
   //  Repas r =new Repas("nom", "description", "ingrediant1", "glucides", "legumes", 1, 2, 5);
   //   ServiceRepas ps = new ServiceRepas();
    //  ps.Ajouter(r);
       
        
     //  Exercice p = new Exercice(1,"alooo","Prog");
     // ServiceExercice ps = new ServiceExercice();
     // ps.Ajouter(p);
//Modifier un programme nutrition      
       
      // ProgMuscul p = new ProgMuscul(14,"proteine");
     //   ServiceMuscul ps = new ServiceMuscul();
      //  ps.update(14);
       
       ///// update prog
       
       // ProgMuscul p = new ProgMuscul("pg");
      //  ServiceExercice ps = new ServiceExercice();
      //  ps.delete(5);
       
       
       
        //   ServiceNutri ps = new ServiceNutri();
       // ps.Supprimer(14);
        
      
//Afficher nutrition
       ServiceUtilisateur ps = new ServiceUtilisateur ();
      System.out.println(ps.Afficher());
       
       
       //Ajouter un event
       
    //  Event p = new Event("loisir");
     //  ServiceEvent ps = new ServiceEvent();
     //  ps.Ajouter(p);
       
        //supprimer un utilisateur
       
     
      //  ServiceUtilisateur ps = new ServiceUtilisateur();
      //  ps.delete(8);
     
     
     //Ajouter un user
       
  //    Utilisateur u = new Utilisateur("yass@gmail.com", "COACH", "hayhahhaha", "yoooo");
  //    ServiceUtilisateur ps = new ServiceUtilisateur();
   //   ps.Ajouter(u);
     
       ///// update user
         //ServiceUtilisateur ps = new ServiceUtilisateur();
       //  ps.update(13);
     
    }
        
        
        
        
        // TODO code application logic here
 }
    

