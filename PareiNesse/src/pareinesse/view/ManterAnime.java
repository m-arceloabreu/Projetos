/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

import pareinesse.controller.ControleAnime;
import pareinesse.model.bean.Anime;

/**
 *
 * @author marcelo
 */
public class ManterAnime {
     public static void montarTela() throws SQLException, ClassNotFoundException  {
        int ops = Integer.parseInt(JOptionPane.showInputDialog("INSERIR = 1 \nLISTAR = 2 \nBUSCAR = 3 \nALTERAR = 4 \nEXCLUIR = 5"));
       switch(ops){
            case 1:  inserir(); break;
            case 2:  listar(); break;
            case 3:  buscar(); break;
            case 4:  alterar(); break;
            case 5:  excluir(); ;break;
            }
    }
     
     public static void inserir() throws SQLException, ClassNotFoundException {
     JOptionPane.showMessageDialog(null,"INSERIR ANIME");
     String nome = JOptionPane.showInputDialog("ENTRE COM O NOME ORIGINAL DO ANIME");
     String nome_ingles = JOptionPane.showInputDialog("ENTRE COM O NOME EM INGLÊS DO ANIME");
     int temporadas = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O NUM DE TEMPORADAS DO ANIME"));
     int episodios = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O NUMERO TOTAL DE EPISODIOS DO ANIME"));
     
     Anime ani = new Anime(0,nome,nome_ingles,temporadas,episodios);
     ControleAnime  contA = new ControleAnime();
     ani = contA.inserir(ani);
     }
     
     public static void listar() throws SQLException,ClassNotFoundException{
     JOptionPane.showMessageDialog(null,"ANIMES CADASTRADOS" );
     String nome = JOptionPane.showInputDialog("Nome do Anime: ");
     Anime ani = new Anime(nome);
     ControleAnime contA = new ControleAnime();
     List<Anime> listaA = contA.listar(ani);
        listaA.forEach((aniL) ->{
            JOptionPane.showMessageDialog(null,aniL.toString());
        });

     }
     public static void buscar() throws SQLException, ClassNotFoundException{
         JOptionPane.showMessageDialog(null,"BUSCAR ANIME");
         int idAni = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
         Anime ani = new Anime(idAni);
         ControleAnime contA = new ControleAnime();
         ani = contA.buscar(ani);
         JOptionPane.showMessageDialog(null,"Anime: "+ani.toString());
     
     
     }
     public static void alterar()throws SQLException, ClassNotFoundException{
         JOptionPane.showMessageDialog(null,"ALTERAR ANIME");
         int idAni = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
         String nome = JOptionPane.showInputDialog("ENTRE COM O NOME");
         String nome_ingles = JOptionPane.showInputDialog("ENTRE COM O NOME EM INGLES");
         int temporadas = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O NUMERO DE TEMPORADAS"));
         int episodios = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O NUMERO DE Episodios"));
         
         Anime ani = new Anime(idAni,nome,nome_ingles,temporadas,episodios);
         ControleAnime contA = new ControleAnime();
         ani = contA.alterar(ani);
         JOptionPane.showMessageDialog(null,"Anime:"+ani.toString());
     }
     public static void excluir() throws SQLException, ClassNotFoundException {
     JOptionPane.showMessageDialog(null,"EXCLUIR ANIME");
     int idAni = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
     Anime ani = new Anime(idAni);
     ControleAnime contA = new ControleAnime();
     ani = contA.excluir(ani);
     JOptionPane.showMessageDialog(null,"Anime: "+ ani.toString());
     }
//fim
}
