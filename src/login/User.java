/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author nazuh
 */
public class User {
    int id_user;
    String name = "";
    String pass = "";
    
    public User(){
        
    }
    
    public User(int id_user, String name, String pass){
        this.id_user = id_user;
        this.name = name;
        this.pass = pass;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPass(String pass){
        this.pass = pass;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPass(){
        return this.pass;
    }
}
