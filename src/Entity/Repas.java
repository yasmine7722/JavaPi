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
public class Repas {
    
     private int id;
     private String nom;
     private String description;
     private String ingrediant1;
     private String glucides;
     private String legumes;
     private int nb_caloris; 
     private int quant_legu; 
     private int quant_gluc; 
     private int prog_nutr_id; 
     private ProgNutri prog;

    public Repas() {
    }

    public Repas(String nom, int nb_caloris) {
        this.nom = nom;
        this.nb_caloris = nb_caloris;
    }

    
    
    public Repas(String nom, String description, String ingrediant1, String glucides, String legumes, int nb_caloris, int quant_legu, int quant_gluc, int prog_nutr_id) {
        this.nom = nom;
        this.description = description;
        this.ingrediant1 = ingrediant1;
        this.glucides = glucides;
        this.legumes = legumes;
        this.nb_caloris = nb_caloris;
        this.quant_legu = quant_legu;
        this.quant_gluc = quant_gluc;
        this.prog_nutr_id = prog_nutr_id;
    }

    public int getProg_nutr_id() {
        return prog_nutr_id;
    }

    public void setProg_nutr_id(int prog_nutr_id) {
        this.prog_nutr_id = prog_nutr_id;
    }

    public ProgNutri getProg() {
        return prog;
    }

    public void setProg(ProgNutri prog) {
        this.prog = prog;
    }

    
    
    public Repas(int id, String nom, String description, String ingrediant1, String glucides, String legumes, int nb_caloris, int quant_legu, int quant_gluc) {
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.ingrediant1 = ingrediant1;
        this.glucides = glucides;
        this.legumes = legumes;
        this.nb_caloris = nb_caloris;
        this.quant_legu = quant_legu;
        this.quant_gluc = quant_gluc;
    }

          
          
    public Repas(String nom, String description, String ingrediant1, String glucides, String legumes, int nb_caloris, int quant_legu, int quant_gluc) {
        this.nom = nom;
        this.description = description;
        this.ingrediant1 = ingrediant1;
        this.glucides = glucides;
        this.legumes = legumes;
        this.nb_caloris = nb_caloris;
        this.quant_legu = quant_legu;
        this.quant_gluc = quant_gluc;
    }

          
          
          
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIngrediant1() {
        return ingrediant1;
    }

    public void setIngrediant1(String ingrediant1) {
        this.ingrediant1 = ingrediant1;
    }

    public String getGlucides() {
        return glucides;
    }

    public void setGlucides(String glucides) {
        this.glucides = glucides;
    }

    public String getLegumes() {
        return legumes;
    }

    public void setLegumes(String legumes) {
        this.legumes = legumes;
    }

    public int getNb_caloris() {
        return nb_caloris;
    }

    public void setNb_caloris(int nb_caloris) {
        this.nb_caloris = nb_caloris;
    }

    public int getQuant_legu() {
        return quant_legu;
    }

    public void setQuant_legu(int quant_legu) {
        this.quant_legu = quant_legu;
    }

    public int getQuant_gluc() {
        return quant_gluc;
    }

    public void setQuant_gluc(int quant_gluc) {
        this.quant_gluc = quant_gluc;
    }
         
         
          
          
    
    
    
    
    
    
    
}
