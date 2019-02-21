package servico;

import java.util.ArrayList;
import modelo.Produto;
/**
 *
 * @author victo
 */
public class ProdutoService {
    private static ArrayList<Produto> listaProd = Dados.getLISTA_PRODUTOS();

    public ArrayList<Produto> getProduto() {
        return listaProd;
    }

    public void salvar(Produto p){
        listaProd.add(p);
    }
    
    public void removerProduto(Produto p) {
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
