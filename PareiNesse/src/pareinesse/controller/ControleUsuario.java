/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.controller;

import java.sql.SQLException;
import java.util.List;
import pareinesse.model.bean.Usuario;
import pareinesse.model.dao.DaoUsuario;

/**
 *
 * @author marcelo
 */
public class ControleUsuario {
    static DaoUsuario daoUsu;
    
    public ControleUsuario () throws SQLException, ClassNotFoundException{
    daoUsu = new DaoUsuario();
    }
    
    public Usuario inserir(Usuario u) throws SQLException{
        return daoUsu.inserir(u);
    }
    
    public List<Usuario> listar(Usuario u) throws SQLException{
        return daoUsu.listar(u);
    }
    
    public Usuario buscar(Usuario u) throws SQLException{
        return daoUsu.buscar(u);
    }
    
    public Usuario alterar(Usuario u) throws SQLException{
        return daoUsu.alterar(u);
    }
    
    public Usuario excluir(Usuario u) throws SQLException{
        return daoUsu.excluir(u);
    }
    
}
