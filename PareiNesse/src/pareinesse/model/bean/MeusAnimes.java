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
public class MeusAnimes {
    private int id;
    private int id_anime;
    private int id_usu;
    private String ondeparei;
    
    private Usuario usu;
    private Anime ani;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_anime() {
        return id_anime;
    }

    public void setId_anime(int id_anime) {
        this.id_anime = id_anime;
    }

    public int getId_usu() {
        return id_usu;
    }

    public void setId_usu(int id_usu) {
        this.id_usu = id_usu;
    }

    public String getOndeparei() {
        return ondeparei;
    }

    public void setOndeparei(String ondeparei) {
        this.ondeparei = ondeparei;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Anime getAni() {
        return ani;
    }

    public void setAni(Anime ani) {
        this.ani = ani;
    }
    
    //construtores

    public MeusAnimes(int id, int id_anime, int id_usu, String ondeparei) {
        this.id = id;
        this.id_anime = id_anime;
        this.id_usu = id_usu;
        this.ondeparei = ondeparei;
    }

    public MeusAnimes(int id) {
        this.id = id;
    }

    public MeusAnimes(String ondeparei) {
        this.ondeparei = ondeparei;
    }
    
    @Override
    public String toString(){
        return "\n ID: "+id + " | IDAnime:"+ id_anime +" | IDUsuario"+id_usu + "\n | ULTIMO VISTO: " + ondeparei +"\n------------------\n";
    }
    
}
