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
   switch(ops){
            case 1:  inserir(); break;
            case 2:  listar(); break;
            case 3:  buscar(); break;
            case 4:  alterar(); break;
            case 5:  excluir(); ;break;
            }
        }
    
    public static boolean validaUsuario()throws SQLException,ClassNotFoundException{
        boolean retorno = false;
        String login = JOptionPane.showInputDialog("LOGIN: ");
        String senha = JOptionPane.showInputDialog("SENHA: ");
        Usuario usuEntrada = new Usuario(login,senha);
        ControleUsuario contUsu = new ControleUsuario();
        Usuario usuSaida = contUsu.valida(usuEntrada);
        
        if(usuSaida != null){
            retorno = true;
        }
        return retorno;

    }
    
    public static void inserir() throws SQLException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"INSERIR USUARIO");
        String login = JOptionPane.showInputDialog("LOGIN: ");
        String senha = JOptionPane.showInputDialog("SENHA: ");
        String nome = JOptionPane.showInputDialog("NOME: ");
        String email = JOptionPane.showInputDialog("E-MAIL: ");
        
        Usuario usu = new Usuario(0,login,senha,nome,email);
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
    
    public static void buscar() throws SQLException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"BUSCAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID: "));
        Usuario usu = new Usuario(idUsu);
        ControleUsuario contU = new ControleUsuario();
        usu = contU.buscar(usu);
        JOptionPane.showMessageDialog(null,"Usuario: " + usu.toString());
    }
    
    public static void alterar() throws SQLException, ClassNotFoundException{
        JOptionPane.showMessageDialog(null,"ALTERAR USUARIO");
        int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID: "));
        String login = JOptionPane.showInputDialog("LOGIN: ");
        String senha = JOptionPane.showInputDialog("SENHA: ");
        String nome = JOptionPane.showInputDialog("NOME: ");
        String email = JOptionPane.showInputDialog("E-Mail: ");
        Usuario usu = new Usuario(idUsu,login,senha,nome,email);
        ControleUsuario contU = new ControleUsuario();
        usu = contU.alterar(usu);
        JOptionPane.showMessageDialog(null,"Usuario: "+ usu.toString());
        
    }
    
    public static void excluir() throws SQLException, ClassNotFoundException{
    JOptionPane.showMessageDialog(null,"Excluir Usuario");
    int idUsu = Integer.parseInt(JOptionPane.showInputDialog("ENTRE COM O ID"));
    Usuario usu = new Usuario(idUsu);
    ControleUsuario contU = new ControleUsuario();
    usu = contU.excluir(usu);
    JOptionPane.showMessageDialog(null,"Usuario: "+ usu.toString());
    }
}
