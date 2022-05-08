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
public class Article {
    
     private int id;
    private String theme;

    @Override
    public String toString() {
        return "Article{" + "id=" + id + ", theme=" + theme + '}';
    }

    
    
    public Article() {
    }

    public Article(int id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Article(String theme) {
        this.theme = theme;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    
    
    
    
    
}
