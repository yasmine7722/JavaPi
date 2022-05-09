///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Service;
//
//import Entity.Event;
//import Entity.ProgMuscul;
//import Entity.Ticket;
//import Util.DataSource;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//
///**
// *
// * @author toshiba
// */
//public class ServiceMuscul  {
//Connection cnx;
// private Statement ste;
//
//    public ServiceMuscul() {
//        
//                cnx=DataSource.getInstance().getConn();
//
//    }
//
//
//    
//    public void Ajouter(ProgMuscul pm) {
//        
//        
//         
//            String req = "insert into prog_mus(nom,date)"
//                    +"values('"+pm.getNom()+"','"+pm.getDate()+"')";
//             try {
//            Statement st = cnx.createStatement();
//            st.executeUpdate(req);
//            System.out.println("prog ajouté avec succès");
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());        
//        }
//    }
//
//  //  @Override
////    public void Modifier(ProgMuscul pm) {
////        
////          try {
////            String req ="UPDATE prog_mus SET nom=? WHERE id=?";
////            PreparedStatement ps= cnx.prepareStatement(req);
////            ps.setString(1, pm.getNom() );
////             ps.setDate(2, pm.getDate() );
////          ps.executeUpdate();
////                        System.out.println("Ticket Modifié avec succès");
////
////        } catch (SQLException ex) {
////            Logger.getLogger(ServiceMuscul.class.getName()).log(Level.SEVERE, null, ex);
////        }
////        
////        
////    }
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//    
//
//         public void updatepm( ProgMuscul pm ,String nom ,Date date){
//        try {
//            String requete4 =" UPDATE prog_mus SET " + " nom = ?, date = ? WHERE id = " +pm.getId() ;
//            PreparedStatement pst =cnx.prepareStatement(requete4);
//                      //  pst.setInt(5, id);
//                        pst.setString(1, nom);
//                        pst.setDate(2, date);
//                  
//                       
//                        
//            pst.executeUpdate();
//            System.out.println("votre fournisseur est modifiee");
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//    }
//    
//    
//
//   // @Override
//    
//    
//        
//         public void deletepm(ProgMuscul pm) {
//     
//         String requete = "DELETE FROM prog_mus WHERE id =" + pm.getId();
//        
//           try {
//            ste = cnx.createStatement();
//            ste.executeUpdate(requete);
//        } catch (SQLException ex) {
//            Logger.getLogger(ServiceMuscul.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//     
//         
//         
//      
//    
//    
//    
//    
//
//    
//    public List<ProgMuscul> Afficher() {
//        
//         
//         List<ProgMuscul> prog_mus = new ArrayList<>();
//        try {
//            String req ="select * from prog_mus";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(req);
//            while(rs.next())
//            {
//               ProgMuscul p = new ProgMuscul();
//               p.setId(rs.getInt(1));
//               p.setNom(rs.getString(3));
//               p.setDate(rs.getDate(2));
//           
//               prog_mus.add(p);
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());        }
//            
//        return prog_mus;
//        
//        
//        
//    }
//    
//     public ObservableList<ProgMuscul>afficherpm(){
//       ObservableList<ProgMuscul> myList = FXCollections.observableArrayList();
//        try {
//            
//            String requete3 = "SELECT * FROM prog_mus";
//            Statement st = cnx.createStatement();
//           ResultSet rs = st.executeQuery(requete3);
//           while(rs.next()){
//               ProgMuscul P = new ProgMuscul();
//                P.setId(rs.getInt(1));
//               P.setNom(rs.getString("nom"));
//              
//                P.setDate(rs.getDate("date"));
//               
//               myList.add(P);
//           }
//           
//           
//           
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return myList;
//        
//    }
//    
//    
//    
//    
//
//    
//    public void Supprimer(int ID) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//        
//}
