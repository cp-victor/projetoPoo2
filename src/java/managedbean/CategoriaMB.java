package managedbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private List<Categoria> categorias;
    private Categoria cat = new Categoria();
    private EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("PrAula1610PU");
    
    public void salvar(){   
        servico.salvar(cat);
        this.cat = new Categoria();
    }
    
    public List<Categoria> getCategorias(){
        this.categorias = servico.getListaCategoria();
        return categorias;
    }

    public Categoria getCat() {
        return cat;
    }

    public void remove(Categoria c){
        servico.remove(c);
    }
    
    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    
    @PostConstruct
    public void init(){
        this.emf = Persistence.createEntityManagerFactory("PrAula1610PU");
    }
    
    public void onRowEdit(RowEditEvent event) {
        
        System.out.println("Entrou no row edit");
        FacesMessage msg = new FacesMessage("Categoria editada", ((Categoria) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null, msg);
//        
        this.emf = Persistence.createEntityManagerFactory("PrAula1610PU");
        Categoria cate = ((Categoria) event.getObject());
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
            em.merge(cate);
        em.getTransaction().commit();
        em.close();

//        EntityManager em = emf.createEntityManager();
//        FacesMessage msg;
//        if(this.categorias == null){
//            msg = new FacesMessage("Falha na edição", ((Categoria) event.getObject()).getDescricao());
//        }
//        else{
//            em.getTransaction().begin();
//
//                List<Categoria> tempCatList = this.categorias;
//                for(Iterator<Categoria> it = tempCatList.iterator();it.hasNext();){
//                    Categoria cate = it.next();
//
//                    em.persist(cate);
//                    em.flush();
//                    em.clear();
//                }
//
//            em.getTransaction().commit();
//            em.close();
//            
//            msg = new FacesMessage("Categoria Editada", ((Categoria) event.getObject()).getDescricao());
//        }
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel (RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edição Cancelada",((Categoria) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
    
}
