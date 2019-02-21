/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Cliente;
import org.primefaces.event.RowEditEvent;
import servico.ClienteService;
import servico.ItemPedidoService;

/**
 *
 * @author 171095
 */
@ManagedBean(name="ClienteMB", eager = true)
@SessionScoped
public class ClienteMB {
    private ClienteService servico = new ClienteService();
    private ItemPedidoService servicoItem = new ItemPedidoService();
    private Cliente cli = new Cliente();
    private int aux;
    boolean b = true;
    
    public void salvar(){
        servico.salvar(cli);
        cli = new Cliente();
    }
    
    @ManagedProperty(value="#{ItemPedidoMB}")
    private ItemPedidoMB itemPedidoMB;

    public String salvar2(){
        for(Cliente e: servico.getClientes()){
            if(e.getCodigo() == aux){
                servico.setAuxCli(aux);
                itemPedidoMB.setTotal();
                return "itemped.xhtml";
            }
        }
        
        b = false;
        return "logincli.xhtml";
    }
    
    public int getAux() {
        return aux;
    }
    
    public void setAux(int aux){
        this.aux = aux;
    }
    
    public List<Cliente> getClientes(){
        return servico.getClientes();
    }

    public Cliente getCli() {
        return cli;
    }

    public void setItemPedidoMB(ItemPedidoMB itemPedidoMB) {
        this.itemPedidoMB = itemPedidoMB;
    }
    
    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public boolean isB() {
        return b;
    }
    
    
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Funcionario Editado", ((Cliente) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel (RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edição Cancelada",((Cliente) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
    
    
    
}
