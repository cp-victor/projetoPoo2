package managedbean;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    
    public void salvar(){
        servico.salvar(cat);
        cat = new Categoria();
    }
    
    public ArrayList<Categoria> getCategorias(){
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
    }
    
    public void onRowCancel (RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edição Cancelada",((Categoria) event.getObject()).getDescricao());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
}
