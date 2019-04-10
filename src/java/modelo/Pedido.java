/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
    
    @ManyToMany(mappedBy = "pedidos")
    private List<Produto> produtos = new ArrayList<Produto>();
    
    
    public Pedido(){
    }
    
    public double totalPedido(){
//        int total = 0;
//        for(ItemPedido i: itens){
//            total += i.getQuantidade() * i.getProduto().preco;
//        }
        return 0;
    }
    
    public double totalImposto(){
//        int total = 0;
//        for(ItemPedido i: itens){
//            total += i.getQuantidade() * i.getProduto().imposto;
//        }
          return 0;
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
//public ArrayList<ItemPedido> getItens() {
//       // return itens;
//       return null;
//    }
//
//    public void setItens(List<ItemPedido> itens) {
//        //this.itens = itens;
//    }
//    

    public void addProduto(Produto produtoEscolhido) {
        this.produtos.add(produtoEscolhido);
    }
    
}
