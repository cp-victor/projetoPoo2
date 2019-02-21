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
    private ArrayList<Cliente> cli;
    private Cliente clis;
    private Pedido ped;
    private Produto produtoEscolhido;
    private ItemPedido selectedItem;
    private ItemPedido itemP = new ItemPedido();
    private double total;
    
    public void salvar(){
        if(produtoEscolhido != null){
                itemP.setProduto(produtoEscolhido);
            }
            this.total += produtoEscolhido.getPreco() * itemP.getQuantidade();
            
            itemService.salvar(itemP);
            itemP = new ItemPedido();
            produtoEscolhido=null;
    }

    public String finalizar(){
        ped = new Pedido();
        
        cli = clienteService.getClientes();
        ped.setNumero(Dados.getContPed(1));
        ped.setItens(itemService.getItem());
        ped.setCliente(Dados.getLISTA_CLIENTES().get(Dados.getCliFinal()));
        clis = ped.getCliente();
        clis.addPedido(ped);
        Dados.limpaLista();
        itemService = new ItemPedidoService();
        
        return "pedidok.xhtml";
    }

    public double getTotal() {
        return total;
    }
    
    public ItemPedidoService getItemService() {
        return itemService;
    }
    
    public ArrayList<ItemPedido> getItens(){
        return itemService.getItem();
    }

    public void setItemService(ItemPedidoService itemService) {
        this.itemService = itemService;
    }

    public List<Produto> getProdutos(){
      return produtoService.getProduto();
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

    public ItemPedido getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(ItemPedido selectedItem) {
        this.selectedItem = selectedItem;
    }

    public ItemPedido getItemP() {
        return itemP;
    }

    public void setItemP(ItemPedido itemP) {
        this.itemP = itemP;
    }

    public void setTotal() {
        this.total = 0;
    }
}
