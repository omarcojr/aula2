package cliente;

import clienteservidor.InterfaceProduto;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

public class IniciarCliente {
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        try{
            Remote produtoRemoto = Naming.lookup("rmi://127.0.0.1:1099/Produto");
            
            String string_descricao = JOptionPane.showInputDialog(null, "Qual produto quer cadastrar?","Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            String string_preco = JOptionPane.showInputDialog(null, "Qual preco desse produto?","Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            String string_quantidade = JOptionPane.showInputDialog(null, "Qual a quantidade no estoque?","Entrada de dados", JOptionPane.QUESTION_MESSAGE);
            
            String descricao = string_descricao;
            double preco = Double.parseDouble(string_preco);
            int quantidade = Integer.parseInt(string_quantidade);
            
            produtoRemoto.setDescricao(descricao);
            produtoRemoto.setPreco(preco);
            produtoRemoto.setQuantidade(quantidade);
            
            String texto_retorno
            
        }catch(RemoteException re){
            JOptionPane.showMessageDialog(null, "Erro Remoto"+re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro Remoto"+e.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        }
    }
}
