/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author victo
 */
public class Pedido {
    private long numero;
    private Date data;
    private ArrayList<ItemPedido> itens;
    private Cliente cliente;
    
    public Pedido(){
        itens = new ArrayList<>();
    }
    
    public double totalPedido(){
        int total = 0;
        for(ItemPedido i: itens){
            total += i.getQuantidade() * i.getProduto().preco;
        }
        return total;
    }
    
    public double totalImposto(){
        int total = 0;
        for(ItemPedido i: itens){
            total += i.getQuantidade() * i.getProduto().imposto;
        }
        return total;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemPedido> itens) {
        this.itens = itens;
    }
    
}
