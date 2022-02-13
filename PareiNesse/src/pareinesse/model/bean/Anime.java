/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.model.bean;

/**
 *
 * @author marcelo
 */
public class Anime {
        private int idAnime ;                       
        private String nome;
        private String nome_ingles;
        private int temporadas;                         //numero de temporadas
        private int episodios;                          //numero total de episodios do anime

     //getters setters

    public int getIdAnime() {
        return idAnime;
    }

    public void setIdAnime(int idAnime) {
        this.idAnime = idAnime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_ingles() {
        return nome_ingles;
    }

    public void setNome_ingles(String nome_ingles) {
        this.nome_ingles = nome_ingles;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
   
    //construtores

    public Anime(int idAnime, String nome, String nome_ingles, int temporadas, int episodios) {
        this.idAnime = idAnime;
        this.nome = nome;
        this.nome_ingles = nome_ingles;
        this.temporadas = temporadas;
        this.episodios = episodios;
    }

    public Anime(String nome) {
        this.nome = nome;
    }

    public Anime(int idAnime) {
        this.idAnime = idAnime;
    }
    
        
     @Override
     public String toString(){
         return "ANIME: \nNOME:"+ nome + " | ID: "+idAnime +"\nNOME INGLES: "+nome_ingles + "\nNUM TEMPORADAS: "+temporadas + "\nNUM EPISODIOS: "+episodios;
     
     }
        
}
