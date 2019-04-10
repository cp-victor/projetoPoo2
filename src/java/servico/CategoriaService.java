/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Categoria;

/**
 *
 * @author victo
 */
public class CategoriaService {
    private static List<Categoria> listaCate = Dados.getLISTA_CATEGORIAS();
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrAula1610PU");
    
    public CategoriaService(){
    }
    
    public List<Categoria> getListaCategoria() {
        
        return listaCate;
    }

    public void salvar(Categoria categoria){
        EntityManager em = this.emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(categoria);
        em.getTransaction().commit();
        em.close();        
        //listaCate.add(categoria);
    }
    
    public Categoria getCategoriaByDescricao(String value) {
        for(Categoria e: listaCate){
           if(e.getDescricao().equals(value))
               return e;
        }
        return null;
    }
}
