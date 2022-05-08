/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.List;

/**
 *
 * @author toshiba
 */
public interface InterfaceCrud<Entite> {
    
    
    public void Ajouter(Entite e) ;
    public void Modifier(Entite e);
    public void Supprimer(int ID);
    public List<Entite>Afficher();
    
    
    
}
