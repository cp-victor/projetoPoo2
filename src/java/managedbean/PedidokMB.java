/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.Pedido;
import servico.ClienteService;
import servico.Dados;

/**
 *
 * @author mateu
 */
@ManagedBean(name="PedidokMB")
@SessionScoped
public class PedidokMB {
    private ClienteService clienteService = new ClienteService();
    private Cliente cli;
    private static int cliFinal = -1;
    private int aux2;
    
    private void init(){
        for(Cliente c: clienteService.getClientes()){
            if(c.getCodigo() == Dados.getAuxC())
                cli = c;
        }
        cliFinal = Dados.getLISTA_CLIENTES().indexOf(cli);
        Dados.setCliFinal(cliFinal);
    }

    public String getClienteNome(){
        init();
        return this.cli.getNome();
    }

    public ArrayList<Pedido> getClientePedidos(){
        init();
        return this.cli.getPedidos();
    }
    
    public String ver(int x){
        Dados.setPedidoVer(x);
        return "verItens.xhtml";
    }
}
