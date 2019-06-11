/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Produto;
import org.apache.jasper.tagplugins.jstl.core.ForEach;
import servico.ClienteService;
import servico.Dados;
import servico.ItemPedidoService;
import servico.ProdutoService;

/**
 *
 * @author mateu
 */
@ManagedBean(name="ItemPedidoMB", eager = true)
@SessionScoped
public class ItemPedidoMB {
    private ItemPedidoService itemService = new ItemPedidoService();
    private ProdutoService produtoService = new ProdutoService();
    private ClienteService clienteService = new ClienteService();
    private List<Cliente> cli;
    private List<ItemPedido> itens = new ArrayList();
    private Cliente clis;
    private Pedido ped;
    private Produto produtoEscolhido;
    //private ItemPedido selectedItem;
    private Pedido itemP = new Pedido();
    private double total;
    
    public void salvar(){    
        for (ItemPedido Item : itens) {
            itemService.save(Item);
        }
    }
    public double getTotal() {
        return total;
    }
    
    public ItemPedidoService getItemService() {
        return itemService;
    }

    public void setItemService(ItemPedidoService itemService) {
        this.itemService = itemService;
    }

    public List<Produto> getProdutos(){
      return produtoService.getAll(Produto.class);
    }
    
    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public Produto getProdutoEscolhido() {
        return produtoEscolhido;
    }

    public void setProdutoEscolhido(Produto produtoEscolhido) {
        this.produtoEscolhido = produtoEscolhido;
    }

//    public ItemPedido getSelectedItem() {
//        return selectedItem;
//    }
//
//    public void setSelectedItem(ItemPedido selectedItem) {
//        this.selectedItem = selectedItem;
//    }
//
//    public ItemPedido getItemP() {
//        return null;//itemP;
//    }
//
//    public void setItemP(ItemPedido itemP) {
//        //this.itemP = itemP;
//    }

    public void setTotal() {
        this.total = 0;
    }
}
