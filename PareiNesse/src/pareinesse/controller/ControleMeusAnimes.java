/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.controller;

import java.sql.SQLException;
import pareinesse.model.bean.MeusAnimes;
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
    
}
