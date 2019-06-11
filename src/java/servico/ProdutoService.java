package servico;

import modelo.Produto;
/**
 *
 * @author victo
 */
public class ProdutoService extends DAO<Produto, Long>{
    public boolean verificaCampos(Produto p){
        boolean ret = true;
        
        if (p.getNome().isEmpty() || p.getPreco() == 0 || p.getMoeda() == 0)
            ret = false;
        return ret;
    }
 
}
