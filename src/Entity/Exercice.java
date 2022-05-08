/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author toshiba
 */
public class Exercice {
     private int id,repetition;
     private String nom,description;
     private int prog_mus_id; 
     private ProgMuscul prog;


    public Exercice() {
    }

    public int getProg_mus_id() {
        return prog_mus_id;
    }

    public void setProg_mus_id(int prog_mus_id) {
        this.prog_mus_id = prog_mus_id;
    }

    public ProgMuscul getProg() {
        return prog;
    }

    public void setProg(ProgMuscul prog) {
        this.prog = prog;
    }

    public Exercice(int repetition, String nom, String description, int prog_mus_id) {
        this.repetition = repetition;
        this.nom = nom;
        this.description = description;
        this.prog_mus_id = prog_mus_id;
    }

    
    public Exercice(int repetition, String description, int prog_mus_id) {
        this.repetition = repetition;
        this.description = description;
        this.prog_mus_id = prog_mus_id;
    }

    
    
    
    public Exercice(int repetition, String nom, String description) {
        this.repetition = repetition;
        this.nom = nom;
        this.description = description;
    }

    public Exercice(int id, int repetition, String nom, String description) {
        this.id = id;
        this.repetition = repetition;
        this.nom = nom;
        this.description = description;
    }

     
     
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     
    
    
}
