package managedbean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Produto;
import servico.ProdutoService;

/**
 *
 * @author mateu
 */
@FacesConverter("converterProduto")
public class ConverterProdutos implements Converter{
    
	private ProdutoService servico = new ProdutoService();
        
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		long v = Long.parseLong(value);
		
                Produto e = null;
		if(v != 0) {
			e = servico.getById(Produto.class, v);
		}
		return e;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object produto) {
		if (produto == null || produto.equals("")) {
			return null;
		} else {
			return ((Produto) produto).getNome();
		}
	}
}