/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Cliente;

/**
 *
 * @author 171095
 */
public class ClienteService {
    private static ArrayList<Cliente> listaCli = Dados.getLISTA_CLIENTES();
    private static int auxCli = Dados.getAuxC();
    
    public void salvar(Cliente f){
        listaCli.add(f);
    }
    
    public ArrayList<Cliente> getClientes(){
        return listaCli;
    }
    
    public void setAuxCli(int x){
        auxCli = x;
        Dados.setAuxC(auxCli);
    }
    
    public int getAuxCli(){
        return auxCli;
    }
}
