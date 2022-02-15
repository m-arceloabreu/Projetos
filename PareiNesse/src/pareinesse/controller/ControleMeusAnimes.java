/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.controller;

import java.sql.SQLException;
import java.util.List;
import pareinesse.model.bean.Anime;
import pareinesse.model.bean.MeusAnimes;
import pareinesse.model.bean.Usuario;
import pareinesse.model.dao.DaoMeusAnimes;

/**
 *
 * @author marcelo
 */
public class ControleMeusAnimes {
    static DaoMeusAnimes maDao;
    static ControleAnime cAni;
    static ControleUsuario cUsu;
    
    public MeusAnimes inserir(MeusAnimes ma) throws ClassNotFoundException, SQLException{
    maDao = new DaoMeusAnimes();
    return maDao.inserir(ma);
    }
    
    public List<MeusAnimes> listar (MeusAnimes ma) throws SQLException, ClassNotFoundException{
          maDao = new DaoMeusAnimes();
          List<MeusAnimes> listaMa = maDao.listar(ma);
          for (MeusAnimes listaMa2 : listaMa){
          cAni = new ControleAnime();
          cUsu = new ControleUsuario();
          
          Anime aniEntrada = new Anime(listaMa2.getId());
          Usuario usuEntrada = new Usuario(listaMa2.getId());
          Anime aniSaida  = cAni.buscar(aniEntrada);
          Usuario usuSaida = cUsu.buscar(usuEntrada);
          listaMa2.setAni(aniSaida);
          listaMa2.setUsu(usuSaida);
          
          }
    return listaMa;
    
    }
    
}
