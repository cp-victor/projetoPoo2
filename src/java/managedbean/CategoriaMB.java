package managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Categoria;
import org.primefaces.event.RowEditEvent;
import servico.CategoriaService;

/**
 *
 * @author victo
 */
@ManagedBean(name="CategoriaMB")
@SessionScoped
public class CategoriaMB {
    private CategoriaService servico = new CategoriaService();
    private Categoria cat = new Categoria();
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("PrAula1610PU");
    
    public void salvar(){   
        servico.salvar(cat);
        this.cat = new Categoria();
    }
    
    public List<Categoria> getCategorias(){
        return servico.getListaCategoria();
    }

    public Categoria getCat() {
        return cat;
    }

    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Categoria Editada", ((Categoria) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.merge(servico.getListaCategoria());
        em.getTransaction().commit();
        em.close();
    }
    
    public void onRowCancel (RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edição Cancelada",((Categoria) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
}
