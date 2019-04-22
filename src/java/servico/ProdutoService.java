package servico;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Produto;
/**
 *
 * @author victo
 */
public class ProdutoService {
    private static List<Produto> listaProd = Dados.getLISTA_PRODUTOS();
    EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("PrAula1610PU");

    public List<Produto> getProduto() {
        return listaProd;
    }

    public void salvar(Produto p){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(p);
            em.flush();
        em.getTransaction().commit();
        em.close();
    }
    
    public void remove(Produto p) {
       listaProd.remove(p);
    }
    
    public Produto getProdutoByName(String value) {
        for(Produto e: listaProd){
           if(e.getNome().equals(value))
               return e;
        }
        return null;
    }
}
