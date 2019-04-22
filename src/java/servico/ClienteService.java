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
import modelo.Cliente;

/**
 *
 * @author 171095
 */
public class ClienteService {
    private static List<Cliente> listaCli = Dados.getLISTA_CLIENTES();
    private static int auxCli = Dados.getAuxC();
    EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("PrAula1610PU");
    
    public void salvar(Cliente f){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.persist(f);
            em.flush();
        em.getTransaction().commit();
        em.close();      
    }
    
    public List<Cliente> getClientes(){
        listaCli = Dados.getLISTA_CLIENTES();
        return listaCli;
    }
    
    public void remove(Cliente c){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
    
    public void setAuxCli(int x){
        auxCli = x;
        Dados.setAuxC(auxCli);
    }
    
    public int getAuxCli(){
        return auxCli;
    }
}
