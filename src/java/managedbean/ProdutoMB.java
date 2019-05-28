package managedbean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Categoria;
import modelo.Produto;
import modelo.ProdutoExportacao;
import modelo.ProdutoMercadoInterno;
import org.primefaces.event.RowEditEvent;
import servico.CategoriaService;
import servico.ProdutoService;

/**
 *
 * @author victo
 */
@ManagedBean(name="ProdutoMB")
@SessionScoped
public class ProdutoMB {
    private ProdutoService produtoService = new ProdutoService();
    private CategoriaService servicocat = new CategoriaService();
    private Produto prod = new Produto();
    private Categoria categoriaEscolhida;
    private ProdutoExportacao selectedProd;
    private ProdutoMercadoInterno prodi = new ProdutoMercadoInterno();
    private int radio;
    
    public void salvar(){
        produtoService.save(prod);
    }
    public boolean compara(String x){
        return !x.equals("");
    }
    
    public boolean comparain(boolean x){
        return x;
    }
    
    public boolean rendered(){
        if(this.radio == 1)
            return true;
        else if(this.radio == 2)
            return false;
        return false;
    }

    public Categoria getCategoriaEscolhida() {
        return categoriaEscolhida;
    }
    
    public List<Categoria> getCategorias(){
      return servicocat.getAll(Categoria.class);
    }

    public void setCategoriaEscolhida(Categoria categoriaEscolhida) {
        this.categoriaEscolhida = categoriaEscolhida;
    }
    
    public Produto getSelectedProd() {
        return selectedProd;
    }

    public void setSelectedProd(ProdutoExportacao selectedProd) {
        this.selectedProd = selectedProd;
    }
    
    public void remove(Produto prod){
        produtoService.remove(prod);
    }
    
    public void removeSelected(){
        selectedProd.getCategoria().removeProduto(selectedProd);
        produtoService.remove(selectedProd);
        selectedProd = null;
    }
    
    public List<Produto> getProdutos(){
        return produtoService.getAll(Produto.class);
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public Produto getProde() {
        return prod;
    }
    
    public ProdutoMercadoInterno getProdi() {
        return prodi;
    }

    public void setProde(ProdutoExportacao prode) {
        this.prod = prode;
    }
    
    public void setProdi(ProdutoMercadoInterno prodi) {
        this.prodi = prodi;
    }
    
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Produto Editado", ((Produto) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void onRowCancel (RowEditEvent event){
        FacesMessage msg = new FacesMessage("Edição Cancelada",((Produto) event.getObject()).getNome());
        FacesContext.getCurrentInstance().addMessage(null,msg);
    }
}
