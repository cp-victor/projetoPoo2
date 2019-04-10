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
    private ProdutoExportacao prode = new ProdutoExportacao();
    private Categoria categoriaEscolhida;
    private ProdutoExportacao selectedProd;
    private ProdutoMercadoInterno prodi = new ProdutoMercadoInterno();
    private int radio;
    
    public void salvar(){
        if(this.radio == 2){
            if(categoriaEscolhida != null){
                prode.setCategoria(categoriaEscolhida);
                categoriaEscolhida.addProduto(prode);
            }

            produtoService.salvar(prode);
            prode = new ProdutoExportacao();
            categoriaEscolhida=null;
        }
        else{
            if(categoriaEscolhida != null){
                prodi.setCategoria(categoriaEscolhida);
                categoriaEscolhida.addProduto(prodi);
            }

            produtoService.salvar(prodi);
            prodi = new ProdutoMercadoInterno();
            categoriaEscolhida=null;
        }
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
      return servicocat.getListaCategoria();
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
    
    public void removeProduto(ProdutoExportacao prod){
        produtoService.removerProduto(prod);
    }
    
    public void removeSelected(){
        selectedProd.getCategoria().removeProduto(selectedProd);
        produtoService.removerProduto(selectedProd);
        selectedProd = null;
    }
    
    public List<Produto> getProdutos(){
        return produtoService.getProduto();
    }
    
    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    public ProdutoExportacao getProde() {
        return prode;
    }
    
    public ProdutoMercadoInterno getProdi() {
        return prodi;
    }

    public void setProde(ProdutoExportacao prode) {
        this.prode = prode;
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
