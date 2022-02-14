/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pareinesse.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import pareinesse.controller.ControleUsuario;
import pareinesse.model.bean.Usuario;

/**
 *
 * @author marcelo
 */
public class ManterUsuario {
    
    public static void montarTela() throws SQLException, ClassNotFoundException {
    int ops = Integer.parseInt(JOptionPane.showInputDialog("1-Inserir \n2-Listar\n3-Buscar\n4-Alterar\n5Excluir"));
    if(ops ==1) inserir();
    if(ops ==2) listar();
    if(ops ==3) buscar();
    if(ops ==4) alterar(); 
    if(ops ==5) excluir();
        }
    
    public static void inserir() throws SQLException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"INSERIR USUARIO");
        String login = JOptionPane.showInputDialog("LOGIN: ");
        String senha = JOptionPane.showInputDialog("SENHA: ");
        String nome = JOptionPane.showInputDialog("NOME: ");
        String email = JOptionPane.showInputDialog("E-MAIL: ");
        
        Usuario usu = new Usuario(login);
        ControleUsuario contU = new ControleUsuario();
        
        usu = contU.inserir(usu);
        JOptionPane.showMessageDialog(null,"USUARIO: "+usu.toString());
        
        
        
    }
    public static void listar() throws SQLException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"USUARIOS CADASTRADOS");
        String login = JOptionPane.showInputDialog("ENTRE COM O LOGIN: ");
        Usuario usu = new Usuario(login);
        ControleUsuario contU = new ControleUsuario();
        
        List<Usuario> listaU = contU.listar(usu);
        listaU.forEach((usuL)->{
        JOptionPane.showMessageDialog(null,usuL.toString());
        });
    }
    
    public static void buscar(){
    
    }
    
    public static void alterar(){
    
    }
    
    public static void excluir(){
    
    }
}
