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
import pareinesse.model.bean.MeusAnimes;
import pareinesse.util.ConexaoDb;

/**
 *
 * @author marcelo
 */
public class DaoMeusAnimes {
    private final Connection c;
    
    public DaoMeusAnimes() throws ClassNotFoundException{
        this.c = new ConexaoDb().getConnection();
    }
    
    public MeusAnimes inserir(MeusAnimes ma) throws SQLException{
        String sql = "insert into meusAnimes " + "(id_anime,id_usu,ondeparei)"+"values (?,?,?)";
        
        try(
            PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            stmt.setInt(1,ma.getId_anime());
            stmt.setInt(2,ma.getId_usu());
            stmt.setString(3,ma.getOndeparei());
            
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                ma.setId(id);
            }
        }
        c.close();
        return ma;
    }
    
}
