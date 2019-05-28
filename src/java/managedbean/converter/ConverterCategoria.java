package managedbean.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Categoria;
import servico.CategoriaService;

/**
 *
 * @author mateu
 */
@FacesConverter("converterCategoria")
public class ConverterCategoria implements Converter{
    
	private CategoriaService servico = new CategoriaService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		long v = Long.parseLong(value);
		Categoria e = null;
		if(v != 0) {
			e = servico.getById(Categoria.class, v);	
		}
		return e;
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object categoria) {
		if (categoria == null || categoria.equals("")) {
			return null;
		} else {
			return ((Categoria) categoria).getDescricao();
		}
	}
}