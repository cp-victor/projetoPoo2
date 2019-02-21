/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.ItemPedido;

/**
 *
 * @author mateu
 */
public class ItemPedidoService {
    private ArrayList<ItemPedido> listaItem = Dados.getLISTA_ITEMPEDIDOS();
    
    public ArrayList<ItemPedido> getItem(){
        return listaItem;
    }

    public void salvar(ItemPedido p){
        listaItem.add(p);
    }
    
    public void removerItem(ItemPedido p) {
       listaItem.remove(p);
    }
    
    public void limpaLista(){
        Dados.limpaLista();
    }
}