package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Categoria implements Serializable{
    @Id
    private int codigo;
    private String descricao;    
    
    @OneToMany(cascade = CascadeType.ALL)
    private ArrayList<Produto> produtos = new ArrayList<Produto>();

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
