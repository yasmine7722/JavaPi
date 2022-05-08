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
public class Utilisateur {
    
     private int id;
     private String email;
     private String roles;
     private String password;
     private String username;

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", roles=" + roles + ", password=" + password + ", username=" + username + '}';
    }

     
     
    public Utilisateur() {
    }

    public Utilisateur(int id, String email, String roles, String password, String username) {
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.username = username;
    }

    public Utilisateur(String email, String roles, String password, String username) {
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.username = username;
    }

    public Utilisateur(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

      public Utilisateur(String email, String username) {
        this.email = email;
        this.username = username;
    }
    
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     
     
     
    
    
}
