/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author nazuh
 */
public class Director {
    
    int id_director;
    String name = "";
    String nationality = "";
    
    public Director(int id_director, String name, String nationality){
        this.id_director = id_director;
        this.name = name;
        this.nationality = nationality;
    }
    
    public void setId_director(int id_director){
        this.id_director = id_director;
    }
    
    public void setName(String name){
        this.name = name;
    }
        
    public void setNationality(String nationality){
        this.nationality = nationality;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getNationality(){
        return this.nationality;
    }
    
    public int getId_director(){
        return this.id_director;
    }
    
}
