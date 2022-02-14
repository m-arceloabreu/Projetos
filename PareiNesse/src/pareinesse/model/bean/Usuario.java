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
public class Usuario {
        private int id;
    private String login;
    private String senha;
    private String nome;
    private String email;
    
    //getters e setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    //construtores

    public Usuario(int id) {
        this.id = id;
    }
    
 public Usuario(String login) {
        this.login = login;
    }
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(int id, String login, String senha, String nome, String email) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.email = email;
    }

   
    
    @Override
    public String toString(){
     return "Usuario: "+"ID: "+ id + "\n Login: "+login + "\nSenha: "+ senha +"\nNome: "+ nome + "\nE-mail: "+email;
    
    }
}
