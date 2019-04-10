/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author victo
 */
@Entity
public class Pedido implements Serializable{
    @Id
    private long numero;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @ManyToOne
    private Cliente cliente;
    
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<ItemPedido> itens;
    
    
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
