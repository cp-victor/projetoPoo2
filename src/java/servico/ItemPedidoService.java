/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import modelo.Pedido;

/**
 *
 * @author mateu
 */
public class ItemPedidoService {
    private List<Pedido> listaItem = Dados.getLISTA_ITEMPEDIDOS();
    
    public List<Pedido> getItem(){
        return listaItem;
    }

    public void salvar(Pedido p){
        
        listaItem.add(p);
    }
    
    public void removerItem(Pedido p) {
       listaItem.remove(p);
    }
    
    public void limpaLista(){
        Dados.limpaLista();
    }
}