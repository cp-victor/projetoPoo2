/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Pedido;
import servico.Dados;

/**
 *
 * @author victo
 */
@ManagedBean(name="verItensMB")
@SessionScoped
public class verItensMB {
    private int cli = Dados.getCliFinal();
    private ArrayList<Pedido> listaPed = Dados.getLISTA_CLIENTES().get(cli).getPedidos();
    private Pedido auxped;

    public int getCli() {
        return cli;
    }

    public Pedido getListaPed() {
        for(Pedido p: listaPed){
            if(p.getNumero() == Dados.getPedidoVer()){
                auxped = p;
            }
        }
        return listaPed.get(listaPed.indexOf(auxped));
    }
}
