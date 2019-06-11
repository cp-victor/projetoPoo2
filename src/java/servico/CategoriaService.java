/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Categoria;

/**
 *
 * @author victo
 */
public class CategoriaService extends DAO<Categoria, Long> {
        Categoria cat = new Categoria();
        
        public boolean verificaSeExiste(String desc){
            boolean ret = false;
            List<Categoria> listaCat;
            
            listaCat = getAll(Categoria.class);
            
            for(Categoria c : listaCat)
            {
                if (c.getDescricao().toUpperCase().equals(desc.toUpperCase()))
                    ret = true;                    
            }
            
            return ret;
        }
}
