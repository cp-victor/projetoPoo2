/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import modelo.Cliente;

/**
 *
 * @author 171095
 */
public class ClienteService extends DAO<Cliente, Long>{
    public boolean validaCampos(Cliente c){
        boolean ret = true;
        
        if (c.getEndereco().isEmpty() ||
                c.getLimite() == 0    ||
                c.getNome().isEmpty() ||
                c.getTelefone().isEmpty())
            ret = false;
        
        return ret;
    }
          
    
}
