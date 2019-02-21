/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author victo
 */
public class CategoriaService {
    private static ArrayList<Categoria> listaCate = Dados.getLISTA_CATEGORIAS();

    public ArrayList<Categoria> getListaCategoria() {
        return listaCate;
    }

    public void salvar(Categoria categoria){
        listaCate.add(categoria);
    }
    
    public Categoria getCategoriaByDescricao(String value) {
        for(Categoria e: listaCate){
           if(e.getDescricao().equals(value))
               return e;
        }
        return null;
    }
}
