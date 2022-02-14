/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.view;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pareinesse.controller.ControleMeusAnimes;
import pareinesse.model.bean.MeusAnimes;



/**
 *
 * @author marcelo
 */
public class ManterMeusAnimes {
    public static void montarTela() throws SQLException, ClassNotFoundException  {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("INSERIR = 1, \nLISTAR = 2,\nBUSCAR = 3,\nALTERAR = 4,\nEXCLUIR = 5"));
        if(ops == 1 ) inserir();
        //if(ops == 2 ) listar();
        //if(ops == 3 ) buscar();
        //if(ops == 4 ) alterar();
        //if(ops == 5 ) excluir();
    }
    public static void inserir() throws ClassNotFoundException, SQLException{
    JOptionPane.showMessageDialog(null,"INSERIR MEU ANIME");
    int id_anime = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID ANIME"));
    int id_usu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID USU"));
    String ondeparei = JOptionPane.showInputDialog("ULTIMO EP VISTO: S ? EP ? :");
    MeusAnimes ma = new MeusAnimes(0,id_anime,id_usu,ondeparei);
    ControleMeusAnimes contMa = new ControleMeusAnimes();
    ma = contMa.inserir(ma);
    JOptionPane.showMessageDialog(null,"MEUS ANIMES: "+ ma.toString());

}
}

