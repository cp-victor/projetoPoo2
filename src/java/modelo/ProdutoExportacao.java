/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author victo
 */
@Entity
public class ProdutoExportacao extends Produto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;
    protected String destino;

    public ProdutoExportacao(){
        
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
