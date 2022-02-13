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
import pareinesse.model.bean.Anime;
import pareinesse.util.ConexaoDb;

/**
 *
 * @author marcelo
 */
public class DaoAnime {
    private final Connection c;
    
    public DaoAnime()throws SQLException, ClassNotFoundException{
    this.c = new ConexaoDb().getConnection();
    }
    
    
    public Anime inserir(Anime a) throws SQLException{
    String sql = "insert into anime"+"(nome,nome_ingles,temporadas,episodios)"+"values(?,?,?,?)";
    
    try(PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
        stmt.setString(1,a.getNome());
        stmt.setString(2,a.getNome_ingles());
        stmt.setInt(3,a.getTemporadas());
        stmt.setInt(4,a.getEpisodios());
        
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()){
            int idAnime = rs.getInt(1);
            a.setIdAnime(idAnime);                       // talvez tenha que mudar pra idAnime dentro dos parenteses
        }
    }
    c.close();
    return a;
    }
    public List<Anime> listar (Anime an ) throws SQLException{
       List<Anime> listaA = new ArrayList<>();
       
       String sql = "select * from anime WHERE nome like ?";
       
       try (PreparedStatement stmt = this.c.prepareStatement(sql)){
           //seta os valores
              stmt.setString(1,"%"+an.getNome()+ "%");
              ResultSet rs = stmt.executeQuery();
              
              while(rs.next()){
                    Anime aSaida = new Anime(
                          rs.getInt(1),
                          rs.getNString(2),
                          rs.getString(3),
                          rs.getInt(4),
                          rs.getInt(5));
                    listaA.add(aSaida);
              }
       rs.close();
       }
    return listaA;
    }
    public Anime buscar(Anime an) throws SQLException{
    String sql = "select * from anime WHERE idAnime =  ?";
    Anime retorno;
        try(PreparedStatement stmt = this.c.prepareStatement(sql)){
            stmt.setInt(1,an.getIdAnime());
            ResultSet rs = stmt.executeQuery();
            retorno = null;
             while(rs.next()){
                 retorno = new Anime(
                 rs.getInt(1),
                 rs.getString(2),
                 rs.getString(3),
                 rs.getInt(4),
                 rs.getInt(5));
             }   
            }
            c.close();
            return retorno;
        }
   public Anime alterar(Anime an) throws SQLException {
       String sql = "UPDATE anime SET nome = ?, nome_ingles = ?, temporadas = ?, episodios = ? WHERE idAnime = ?";
       
       try(PreparedStatement stmt = c.prepareStatement(sql)){
           stmt.setString(1,an.getNome());
           stmt.setString(2,an.getNome_ingles());
           stmt.setInt(3,an.getTemporadas());
           stmt.setInt(4,an.getEpisodios());
           stmt.setInt(5,an.getIdAnime());
       
           stmt.execute();
       }
       return an;
   }
   public Anime excluir (Anime an) throws SQLException {
       String sql = "DELETE from anime WHERE idAnime = ?";
       
       try(PreparedStatement stmt = c.prepareStatement(sql)){
       stmt.setInt(1,an.getIdAnime());
       
       stmt.execute();
       
       return an;
       }
   
   
   }

//final
}
