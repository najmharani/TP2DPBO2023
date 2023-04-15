/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author nazuh
 */
public class Movie {
    
    int id_movie;
    String title = "";
    String year = "";
    int id_director;
    String director_name = "";
    String poster = "";
    
    public Movie(int id_movie, String title, String year, int id_director, String director_name, String poster){
        this.id_movie = id_movie;
        this.title = title;
        this.year = year;
        this.id_director = id_director;
        this.director_name = director_name;
        this.poster = poster;
    }
    
    public void setId_movie(int id_movie){
        this.id_movie = id_movie;
    }
    
    public void setTitle(String title){
        this.title = title;
    }
        
    public void setYear(String year){
        this.year = year;
    }
    
    public void setId_director(int id_director){
        this.id_director = id_director;
    }
    
    public void setPoster(String poster){
        this.poster = poster;
    }
    
    public int getId_movie(){
        return this.id_movie;
    }
    
    public String getTitle(){
        return this.title;
    }
    
    public String getYear(){
        return this.year;
    }
    
    public int getId_director(){
        return this.id_director;
    }
    
    public String getDirector_name(){
        return this.director_name;
    }
    
    public String getPoster(){
        return this.poster;
    }

}
