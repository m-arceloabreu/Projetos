/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import pareinesse.model.bean.Anime;
import pareinesse.model.dao.DaoAnime;

/**
 *
 * @author marcelo
 */
public class ControleAnime {
    static DaoAnime daoA;
    
    public ControleAnime() throws SQLException, ClassNotFoundException{
    daoA = new DaoAnime();
    
    }
    
    public Anime inserir(Anime an) throws SQLException {
        return daoA.inserir(an);
    }
    public List<Anime> listar(Anime an) throws SQLException {
    
    return daoA.listar(an);
    }
    public Anime buscar(Anime an) throws SQLException{
        return daoA.buscar(an);
    }
    public Anime alterar(Anime an ) throws SQLException{
        return daoA.alterar(an);
    }
    public Anime excluir(Anime an) throws SQLException{
        return daoA.excluir(an);
    }
}
