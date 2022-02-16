/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import pareinesse.view.ManterAnime;
import pareinesse.view.ManterUsuario;

/**
 *
 * @author marcelo
 */
public class PareiNesse {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO code application logic here
        boolean retorno = ManterUsuario.validaUsuario();
        
        if(retorno){
        int ops = Integer.parseInt(JOptionPane.showInputDialog("1-LISTA DE ANIMES\n2- ESTOU ASSISTINDO \n3-USUARIOS"));
        int escolha = 1;
        do{
        switch(ops){
            case 1: pareinesse.view.ManterAnime.montarTela();escolha = 1;break;
            case 2: pareinesse.view.ManterMeusAnimes.montarTela();escolha = 1;break;
            case 3: pareinesse.view.ManterUsuario.montarTela();escolha = 1;break;
            }
        }while(escolha == 1);
        }
        else{
            JOptionPane.showMessageDialog(null,"Usuario Invalido");
        }
    }
    
}
