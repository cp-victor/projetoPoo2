package modelo;

import java.util.ArrayList;

/**
 *
 * @author victo
 */
public class Categoria {
    private String descricao;
    
    private ArrayList<Produto> produtos = new ArrayList<>();

    public Categoria(){
    }
    
    public Categoria(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public void addProduto(Produto produto){
        produtos.add(produto);
    }
   
    public void removeProduto(Produto produto){
        produtos.remove(produto);
    }
}
