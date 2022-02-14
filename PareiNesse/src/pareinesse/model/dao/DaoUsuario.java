/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import pareinesse.model.bean.Usuario;
import pareinesse.util.ConexaoDb;

/**
 *
 * @author marcelo
 */
public class DaoUsuario {
    
    private final Connection c;
    
    public DaoUsuario() throws SQLException,ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }
    
    public Usuario inserir(Usuario u) throws SQLException {
       String sql = "inser into usuario"+"(usu_login,usu_senha,usu_nome,usu_email)"+"values (?,?,?,?)";
       
       try(
            PreparedStatement  stmt = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
           stmt.setString(1,u.getLogin());
           stmt.setString(2,u.getSenha());
           stmt.setString(3,u.getNome());
           stmt.setString(4,u.getEmail());
           
           stmt.executeUpdate();
           ResultSet rs = stmt.getGeneratedKeys();
           if (rs.next()){
               int id = rs.getInt(1);
               u.setId(id);
           }
       
       }
       c.close();
    return u;
    }

    public List<Usuario> listar(Usuario u) throws SQLException {
        List<Usuario> listaU = new ArrayList<>();
        String sql = "select * from usuario WHERE usu_login like ?";
        
        try(PreparedStatement stmt = this.c.prepareStatement(sql)){
        stmt.setString(1,"%"+ u.getLogin()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()){
        
                Usuario uSaida = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
                listaU.add(uSaida);
        }
        rs.close();
        }
        return listaU;
    }

    public Usuario buscar(Usuario u) throws SQLException {
        String sql = "select * from usuario WHERE   usu_id = ?";
        Usuario retorno;
        try(PreparedStatement stmt = this.c.prepareStatement(sql)){
            stmt.setInt(1,u.getId());
            ResultSet rs = stmt.executeQuery();
            retorno = null;
            while(rs.next()){
            retorno = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            }
        }
        c.close();
        return retorno;
    }

    public Usuario alterar(Usuario u) throws SQLException {
        String sql = "UPDATE usuario SET usu_login = ?, usu_senha = ?, usu_nome = ?, usu_email = ? WHERE usu_id = ?";
        
        try(PreparedStatement stmt = c.prepareStatement(sql)){
            stmt.setString(1,u.getLogin());
            stmt.setString(2,u.getSenha());
            stmt.setString(3,u.getNome());
            stmt.setString(4,u.getEmail());
            stmt.setInt(5,u.getId());
        }
    return u;
    }

    public Usuario excluir(Usuario u) throws SQLException {
       String sql = "Delete from usuario WHERE usu_id = ?";
       
       try (PreparedStatement stmt = c.prepareStatement(sql)){
           stmt.setInt(1,u.getId());
           stmt.execute();
       
       }
       c.close();
    return u;
    }

    public Usuario inserir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
